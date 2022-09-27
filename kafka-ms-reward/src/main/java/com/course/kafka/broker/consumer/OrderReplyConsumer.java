package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import com.course.kafka.broker.message.OrderReplyMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class OrderReplyConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderReplyConsumer.class);

    @KafkaListener(topics = "t-commodity-order")
    @SendTo("t-commodity-order-reply")
    public OrderReplyMessage listen(ConsumerRecord<String, OrderMessage> consumerRecord) {
        Headers headers = consumerRecord.headers();
        OrderMessage orderMessage = consumerRecord.value();

        LOG.info("Processing order {},item {}, credit card number {}", orderMessage.getOrderNumber(),
                orderMessage.getItemName(), orderMessage.getCreditCardNumber());
        LOG.info("Headers : ");
        headers.forEach(h -> LOG.info("  key : {}, value : {}", h.key(), new String(h.value())));

        String headerValue = ObjectUtils.isEmpty(headers.lastHeader("surpriseBonus").value()) ? "0"
                : new String(headers.lastHeader("surpriseBonus").value());

        int bonusPercentage = Integer.parseInt(headerValue);
        double bonusAmount = (bonusPercentage / 100d) * orderMessage.getPrice() * orderMessage.getQuantity();

        LOG.info("Bonus amount is {}", bonusAmount);

        OrderReplyMessage replyMessage = new OrderReplyMessage();
        replyMessage.setReplyMessage(
                "Order " + orderMessage.getOrderNumber() + ", item " + orderMessage.getItemName() + " processed");

        return replyMessage;
    }
}
