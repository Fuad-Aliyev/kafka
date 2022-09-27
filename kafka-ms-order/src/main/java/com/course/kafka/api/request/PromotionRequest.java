package com.course.kafka.api.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PromotionRequest {
    private String promotionCode;
}
