package com.assignment.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author SUDHANSHU
 *
 */
@SpringBootApplication
@EnableCaching
public class BooksApplication {

	 @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	
	
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager=new ConcurrentMapCacheManager("greetings");
		return cacheManager;
		
	}
}
