package com.yanlilong.event.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yanlilong.docrobot.kafka.model.NodeEvent;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class KafkaConsumer {

  @KafkaListener(topics = "alfresco-nodes-event", containerFactory = "nodeEventKafkaListenerFactory")
  public void listen(NodeEvent nodeEvent) throws JsonProcessingException {
    if (nodeEvent != null) {
      log.info(
          "eventtpye: " + nodeEvent.getEventType() + "event contenttype" + nodeEvent.getNodeRef());
    }

  }

}
