package com.example.redisconf.controller;

import com.example.redisconf.model.SampleModel;
import com.example.redisconf.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SampleController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/sample")
    public String sample() {
        // Getting redis value of "val"
        var cache = Optional.ofNullable(redisService.getRedisValue("val"));

        // Checking if "val" key has a value set
        // If "val" doesn't have a value set
        if (cache.isEmpty()) {
            // creating val to set. In a real API, this value will be taken from a DB
            SampleModel model = new SampleModel();
            model.setFieldValue("value1234567890");

            // setting value to "val" key
            redisService.setRedisValue("val", model);

            return model.getFieldValue() + ", value not retrieved from redis";

            // If "val" has a value set and not expired yet
        } else {
            // casting Object taken from redis
            SampleModel model = (SampleModel) cache.get();
            System.out.println(model.getFieldValue());
            return model.getFieldValue() + ", value retrieved from redis";
        }
    }
}
