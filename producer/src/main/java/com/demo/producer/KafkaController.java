package com.demo.producer;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {

    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        RiderLocation location = new RiderLocation("rider101112", 61.28, 23.77);
        kafkaTemplate.send("my-topic-rider", location);
        return "Message sent: " + location.getRiderId();
    }

//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String message) {
//
//        kafkaTemplate.send("my-topic", message);
//        return "Message sent: " + message;
//    }
}
