package com.course.kafka.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentRequest {
    private String paymentNumber;
    private int amount;
    private String currency;
    private String notes;
    private String transactionType;
}
