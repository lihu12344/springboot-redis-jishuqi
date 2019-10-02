package com.example.demo.config;

import com.example.demo.util.RedisCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class CustomInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCount redisCount;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String id=request.getParameter("id");
        redisCount.incr(id);

        return true;
    }
}
