package com.course.kafka.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class OrderMessage {
    private String orderLocation;
    private String orderNumber;
    private String creditCardNumber;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderDateTime;

    private String itemName;
    private int price;
    private int quantity;
}
