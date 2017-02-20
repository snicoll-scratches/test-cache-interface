package com.example.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Ahmed.
 */
public interface CachedService {

    @Cacheable(cacheManager = "cacheManager", value = "cache-test", key = "'test-key'")
    String hello();

    List<String> helloList();

    @Cacheable(cacheManager = "cacheManager", value = "cache-test", key = "'test-key2'")
    String hello2();
}
