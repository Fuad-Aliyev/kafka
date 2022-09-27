package com.course.kafka.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarLocation {
    private String carId;
    private long timestamp;
    private int distance;
}
