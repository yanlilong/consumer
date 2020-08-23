package com.yanlilong.event.kafka.consumer;
import com.yanlilong.docrobot.kafka.model.NodeEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final static Logger LOGGER = Logger.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "alfresco-nodes-event")
    public void listen(ConsumerRecord<String, String> record){
        System.out.println("message key: " +record.key()+" value: "+record.value());

       /** if (nodeEvent.getContentType().equals("F:cm:systemfolder") ||
                nodeEvent.getContentType().equals("F:bpm:package") ||
                nodeEvent.getContentType().equals("I:act:actionparameter") ||
                nodeEvent.getContentType().equals("I:act:action") ||
                nodeEvent.getContentType().equals("D:cm:thumbnail")) {
            return;
        }*/
        LOGGER.info("Event: " + record.key()+"value"+record.value() );

    }
}
