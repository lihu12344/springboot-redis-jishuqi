package com.example.demo.controller;

import com.example.demo.util.RedisCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisCount redisCount;

    @RequestMapping("/hello")
    public String hello(@RequestParam("id") String id){
        System.out.println("参数id为："+id);
        return id;
    }

    @RequestMapping("/get")
    public String get(String id){
        System.out.println("参数："+id+"访问次数："+ redisCount.get(id));

        return "参数："+id+"访问次数："+ redisCount.get(id);
    }

    @RequestMapping("/get2")
    public void test(){
        System.out.println(redisTemplate.boundValueOps("6").get()==null);
    }
}
