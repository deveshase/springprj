package com.app.dkc.jmsc.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffCacheConfig {

    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("subscriptions");
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(300, TimeUnit.SECONDS)
                .weakKeys()
                .recordStats();
    }
}
