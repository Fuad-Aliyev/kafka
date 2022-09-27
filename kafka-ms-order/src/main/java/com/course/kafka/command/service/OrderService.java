package com.course.kafka.command.service;

import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.command.action.OrderAction;
import com.course.kafka.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderAction orderAction;

    public String saveOrder(OrderRequest request) {
        Order order = orderAction.convertToOrder(request);
        orderAction.saveToDatabase(order);

        // flatten message & publish
        order.getItems().forEach(orderAction::publishToKafka);

        return order.getOrderNumber();
    }
}
