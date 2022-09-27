package com.course.kafka.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commodity {
    private String name;
    private double price;
    private String measurement;
    private long timestamp;
}
