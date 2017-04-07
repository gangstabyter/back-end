package com.back.end.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by dmitry on 28.03.2017.
 */
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan(basePackages={"com.back.end"},
		excludeFilters=@ComponentScan.Filter(type= FilterType.REGEX, pattern={"com.back.end.controller"}))
public class AppConfig {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}
}