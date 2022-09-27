package com.course.kafka.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseRequest {
    private int id;
    private String prNumber;
    private int amount;
    private String currency;
}
