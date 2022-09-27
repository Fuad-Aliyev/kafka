package com.course.kafka.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class OrderResponse {
    private String orderNumber;

    public OrderResponse(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
