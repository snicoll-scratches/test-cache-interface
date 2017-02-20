package com.example;

import com.example.service.CachedService;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableCaching
public class TestCacheInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCacheInterfaceApplication.class, args);
	}

	@Service
	public static class Startup implements ApplicationRunner {

		private final CachedService cachedService;

		public Startup(CachedService cachedService) {
			this.cachedService = cachedService;
		}

		@Override
		public void run(ApplicationArguments applicationArguments) throws Exception {
			System.out.println("Hello, 2 times");
			cachedService.hello();
			cachedService.hello();
			System.out.println("Done");

			System.out.println("Hello list, 2 times");
			cachedService.helloList();
			cachedService.helloList();
			System.out.println("Done");

			System.out.println("Hello 2, 2 times");
			cachedService.hello2();
			cachedService.hello2();
			System.out.println("Done");
		}
	}
}
