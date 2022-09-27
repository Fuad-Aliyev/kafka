package com.course.kafka.api.request;

import lombok.Data;

@Data
public class DiscountRequest {
    private String discountCode;

    private int discountPercentage;
}
