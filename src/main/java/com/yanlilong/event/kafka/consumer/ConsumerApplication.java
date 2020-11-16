package com.yanlilong.event.kafka.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableKafka
@Slf4j
public class ConsumerApplication {

  @RequestMapping("/")
  public String home() {
    return "Hello Docker World";
  }

  public static void main(String[] args) {
    log.info("application start");
    ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
    KafkaConsumer kafkaConsumer = context.getBean(KafkaConsumer.class);

  }

}
