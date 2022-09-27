package com.course.kafka;

import com.course.kafka.entity.Image;
import com.course.kafka.entity.Invoice;
import com.course.kafka.entity.PurchaseRequest;
import com.course.kafka.producer.Image2Producer;
import com.course.kafka.producer.ImageProducer;
import com.course.kafka.producer.InvoiceProducer;
import com.course.kafka.producer.PurchaseRequestProducer;
import com.course.kafka.service.ImageService;
import com.course.kafka.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaCoreProducerApplication.class, args);
    }

    @Autowired
    private ImageService imageService;

    @Autowired
    private Image2Producer image2Producer;

    @Override
    public void run(String... args) throws Exception {
        Image image1 = imageService.generateImage("jpg");
        Image image2 = imageService.generateImage("svg");
        Image image3 = imageService.generateImage("gif");
        Image image4 = imageService.generateImage("gif");
        Image image5 = imageService.generateImage("gif");
        Image image6 = imageService.generateImage("gif");

        image2Producer.send(image1, 0);
        image2Producer.send(image2, 0);
        image2Producer.send(image3, 0);
        image2Producer.send(image4, 1);
        image2Producer.send(image5, 1);
        image2Producer.send(image6, 1);
    }
}
