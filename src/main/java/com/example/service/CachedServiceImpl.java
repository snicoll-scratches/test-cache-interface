package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Ahmed.
 */
@Service
public class CachedServiceImpl implements CachedService {
	private static final Logger logger = LoggerFactory.getLogger(CachedServiceImpl.class);

	@Override
	public String hello() {
		logger.info("Method invocation Hello");
		return "Hello";
	}

	@Override
	@Cacheable(cacheManager = "cacheManager", value = "cache-test", key = "'test-key-list'")
	public List<String> helloList() {
		logger.info("List Method invocation");
		return Arrays.asList("Hello", "Hello");
	}

	@Override
	public String hello2() {
		logger.info("Method invocation Hello2");
		return "Hello2";
	}
}
