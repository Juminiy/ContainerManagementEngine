package com.hua.cloud.api.restful.v1.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/test")
public class v1TestController {
    @Autowired
    private StringRedisTemplate redisTemplate ;
    @Value("${redis.str_prefix.docker_image}")
    private String dockerImageStrPrefix ;
    @RequestMapping(value = "/testapi/{num}" , method = RequestMethod.GET)
    public String testApiNum(@PathVariable("num") Integer num){
        return "testapi" + num ;
    }
    @RequestMapping(value = "/getapi/{item}" , method = RequestMethod.GET)
    public String getApiItem(@PathVariable("item") String item) {
        return redisTemplate.opsForValue().get(dockerImageStrPrefix + item);
    }
}
