package com.macro.mall.tiny.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfiguration {
    @Bean
    public CacheManager cacheManager(RedisTemplate  redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }
}
