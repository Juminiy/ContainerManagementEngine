package com.hua.cloud.service.cache;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RedisStorageService {
    @Autowired
    private StringRedisTemplate redisTemplate ;

    @Value("${redis.str_prefix.docker_image}")
    private String dockerImageStrPrefix ;
    @PostConstruct
    public void initDockerImage() {
        redisTemplate.opsForValue().set(dockerImageStrPrefix + "10730" , "gcc:7.3");
        redisTemplate.opsForValue().set(dockerImageStrPrefix + "20800" , "openjdk:8");
        redisTemplate.opsForValue().set(dockerImageStrPrefix + "21100" , "openjdk:11");
        redisTemplate.opsForValue().set(dockerImageStrPrefix + "30114" , "golang:1.14");
    }

}
