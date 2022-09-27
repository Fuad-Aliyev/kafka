package com.course.kafka.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Invoice {
    private String invoiceNumber;
    private int amount;
    private String currency;
}
