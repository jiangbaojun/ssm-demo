package com.ssm.block.spring.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.ssm.block.spring.i18n")
public class AppConfig {
	
	/**
	 * 创建MessageSource对象
	 * 
	 * MessageSource有如下三种实现：
	 * ReloadableResourceBundleMessageSource提供了定时刷新功能，允许在不重启系统的情况下，更新资源的信息。
	 * StaticMessageSource主要用于程序测试，它允许通过编程的方式提供国际化信息。
	 * DelegatingMessageSource是为方便操作父MessageSource而提供的代理类。
	 */
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        //指定properties文件位置。查找classpath目录下的/properties/i18n目录，以test开头的properties文件（文件名采用test加上本地化的字符）
        messageSource.setBasename("classpath:/properties/i18n/test");
        //可以设置多个目录
//        messageSource.setBasenames("classpath:/properties/i18n1", "classpath:/properties/i18n2");
//        messageSource.setCacheSeconds(10); //reload messages every 10 seconds,不建议生产设置
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
}