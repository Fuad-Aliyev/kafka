package com.course.kafka.service;

import com.course.kafka.entity.Image;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ImageService {
    private static AtomicInteger counter = new AtomicInteger();

    public Image generateImage(String type) {
        String name = "image-" + counter.incrementAndGet();
        long size = ThreadLocalRandom.current().nextLong(100, 10_000);
        return new Image(name, size, type);
    }
}
