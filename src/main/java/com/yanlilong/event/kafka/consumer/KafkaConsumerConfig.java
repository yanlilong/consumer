package com.yanlilong.event.kafka.consumer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.yanlilong.docrobot.kafka.model.NodeEvent;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Value("kafka.groupId")
  private String groupId;
  @Value("${kafka.bootstrapServers}")
  private String bootstrapServers;

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(getKafkaConfig());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public ConsumerFactory<String, NodeEvent> nodeEventConsumerFactory() {
    Map<String, Object> config = getKafkaConfig();
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserialize.class);
    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
        new JsonDeserializer<>(NodeEvent.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, NodeEvent> nodeEventKafkaListenerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, NodeEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(nodeEventConsumerFactory());
    return factory;
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, NodeEvent> nodeEventConcurrentKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, NodeEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(nodeEventConsumerFactory());
    return factory;
  }


  @Bean
  public Map<String, Object> getKafkaConfig() {
    Map<String, Object> props = new HashMap<>();
    props.put(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
        bootstrapServers);
    props.put(
        ConsumerConfig.GROUP_ID_CONFIG,
        groupId);
    props.put(
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        StringDeserializer.class);
    props.put(
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        StringDeserializer.class);
    return props;
  }
}
