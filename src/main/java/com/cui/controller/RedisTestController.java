package com.cui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiminglin
 * @description
 * @date 2018/6/15
 */
@RestController
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/redisinsert")
    public ResponseEntity<String> testInsert(String test) {
        System.out.println(test);
        redisTemplate.opsForValue().set("test1117",test);
        return ResponseEntity.ok("ok");
    }




    @GetMapping("/redisget")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok(String.valueOf(redisTemplate.opsForValue().get("test1117")));
    }
}
