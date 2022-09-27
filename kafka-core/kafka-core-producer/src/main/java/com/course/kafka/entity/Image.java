package com.course.kafka.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {
    private String name;
    private long size;
    private String type;
}
