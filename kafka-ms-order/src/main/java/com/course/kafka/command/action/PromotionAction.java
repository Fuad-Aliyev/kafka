package com.course.kafka.command.action;

import com.course.kafka.api.request.PromotionRequest;
import com.course.kafka.broker.message.PromotionMessage;
import com.course.kafka.broker.producer.PromotionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionAction {
    @Autowired
    private PromotionProducer producer;

    public void publishToKafka(PromotionRequest request) {
        PromotionMessage message = new PromotionMessage(request.getPromotionCode());

        producer.publish(message);
    }
}