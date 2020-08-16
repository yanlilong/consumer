package com.yanlilong.event.kafka.consumer;
import com.yanlilong.docrobot.kafka.model.NodeEvent;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {
  /**  private final static Logger LOGGER = Logger.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "${kafka.topic}", groupId="${kafka.group}",containerFactory = "nodeEventKafkaListenerFactory")
    public void consumerJson(NodeEvent nodeEvent){
        if (nodeEvent.getContentType().equals("F:cm:systemfolder") ||
                nodeEvent.getContentType().equals("F:bpm:package") ||
                nodeEvent.getContentType().equals("I:act:actionparameter") ||
                nodeEvent.getContentType().equals("I:act:action") ||
                nodeEvent.getContentType().equals("D:cm:thumbnail")) {
            return;
        }
        LOGGER.info("Event: " + nodeEvent.getEventType() + " on " + nodeEvent.getNodeRef());

    }*/
}
