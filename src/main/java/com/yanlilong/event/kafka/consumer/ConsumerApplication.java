package com.yanlilong.event.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableKafka
public class ConsumerApplication {
	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}
	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(ConsumerApplication.class, args);
		KafkaConsumer kafkaConsumer=context.getBean(KafkaConsumer.class);

	}

}
