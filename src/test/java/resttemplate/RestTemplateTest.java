package resttemplate;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.BDDMockito.willThrow;

class RestTemplateTest {

  private final ClientHttpRequestFactory requestFactory = mock(ClientHttpRequestFactory.class);
  private final HttpMessageConverter converter = mock(HttpMessageConverter.class);
  private final RestTemplate template = new RestTemplate(List.of(converter));
  private final ClientHttpRequest request = mock(ClientHttpRequest.class);
  private final ClientHttpResponse response = mock(ClientHttpResponse.class);
  private final ResponseErrorHandler errorHandler = mock(ResponseErrorHandler.class);

  @BeforeEach
  void setup() {
    template.setRequestFactory(requestFactory);
    template.setErrorHandler(errorHandler);
  }

  @Test
  void constructorPreconditions() {
    assertThatNullPointerException().isThrownBy(() -> List.of(null, 2));

    List<HttpMessageConverter<?>> list1 = Arrays.asList(null, this.converter);
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new RestTemplate((List<HttpMessageConverter<?>>) null)).
        withMessage("At least one HttpMessageConverter is required");
    assertThatIllegalArgumentException().isThrownBy(() -> new RestTemplate(list1)).
        withMessage("The HttpMessageConverter list must not contain null elements");
  }

  @Test
  void setConverterPreconditions() {
    List<HttpMessageConverter<?>> list1 = Arrays.asList(null, this.converter);
    assertThatIllegalArgumentException()
        .isThrownBy(() -> template.setMessageConverters(null)).
        withMessage("At least one HttpMessageConverter is required");
    assertThatIllegalArgumentException().isThrownBy(() -> template.setMessageConverters(list1)).
        withMessage("The HttpMessageConverter list must not contain null elements");
  }

  @Test
  void varArgsTemplateVariables() throws IOException, URISyntaxException {
    mockSentRequest(GET, "https://example.com/hotels/42/bookings/21", new HttpHeaders());
    mockResponseStatus(HttpStatus.OK);
    template.execute("https://example.com/hotels/{hotel}/bookings/{booking}", GET, null, null, "42",
        "42");
    verify(response).close();
  }

  @Test
  void varArgsNullTemplateVariable() throws Exception {
    mockSentRequest(GET, "https://example.com/-foo", new HttpHeaders());
    mockResponseStatus(HttpStatus.OK);
    template.execute("https://example.com/{first}-{last}", GET, null, null, null,
        "42");
    verify(response).close();
  }

  @Test
  void mapTemplateVarialbes() throws IOException, URISyntaxException {
    mockSentRequest(GET, "https://example.com/hotels/42/bookings/42", new HttpHeaders());
    mockResponseStatus(HttpStatus.OK);
    Map<String, String> vars = Collections.singletonMap("hotel", "42");
    template.execute("https://example.com/hotels/{hotel}/bookings/{hotel}", GET, null, null, vars);
    verify(response).close();
  }

  @Test
  void mapNullTemplateVariable() throws Exception {
    mockSentRequest(GET, "https://example.com/-foo", new HttpHeaders());
    mockResponseStatus(HttpStatus.OK);

    Map<String, String> vars = new HashMap<>(2);
    vars.put("first", null);
    vars.put("last", "foo");
    template.execute("https://example.com/{first}-{last}", GET, null, null, vars);

    verify(response).close();
  }

//  @test
//  void uritemplatewithtrailingslash() throws ioexception, urisyntaxexception {
//    string url = "https://example.com/ex/";
//    mocksentrequest(get, url, new httpheaders());
//    mockresponsestatus(httpstatus.ok);
//    template.execute(url, get, null, null);
//    verify(response).close();
//
//  }



  @Test
  void errorHandling() throws Exception {
    String url = "https://example.com";
    mockSentRequest(GET, url,new HttpHeaders());
    mockResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    willThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR))
        .given(errorHandler).handleError(new URI(url), GET, response);

    assertThatExceptionOfType(HttpServerErrorException.class).isThrownBy(() ->
        template.execute(url, GET, null, null));

    verify(response).close();
  }

  private void mockSentRequest(HttpMethod method, String uri, HttpHeaders requestHeaders)
      throws URISyntaxException, IOException {
    given(requestFactory.createRequest(new URI(uri), method)).willReturn(request);
    given(request.getHeaders()).willReturn(requestHeaders);

  }

  private void mockResponseStatus(HttpStatus responseStatus) throws IOException {
    given(request.execute()).willReturn(response);
  }


}
