package com.example.demo.controller;

import com.example.demo.consumer.MyTopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("kafka")
public class KafkaController {
    private final KafkaTemplate<String, String> template;
    private final MyTopicConsumer myTopicConsumer;

    public KafkaController(KafkaTemplate<String, String> template, MyTopicConsumer myTopicConsumer) {

        this.template = template;
        this.myTopicConsumer = myTopicConsumer;
    }


    @GetMapping("/produce")
    public void produce(@RequestParam String message) {
        template.send("TestKafkaTopic", message);

    }
    @PostMapping("/messages")
    public List<String> getMessages() {
        return myTopicConsumer.getMessages();
    }
}


