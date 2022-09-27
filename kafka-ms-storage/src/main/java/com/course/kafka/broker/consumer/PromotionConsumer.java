package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.DiscountMessage;
import com.course.kafka.broker.message.PromotionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "t-commodity-promotion")
public class PromotionConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(PromotionConsumer.class);

    //spring will use methot parameter datatype to understand incoming message
    @KafkaHandler
    public void listenPromotion(PromotionMessage message) {
        LOG.info("Processing promotion : {}", message);
    }

    @KafkaHandler
    public void listenDiscount(DiscountMessage message) {
        LOG.info("Processing discount : {}", message);
    }
}
