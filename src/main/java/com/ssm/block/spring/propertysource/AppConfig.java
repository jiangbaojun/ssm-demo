package com.ssm.block.spring.propertysource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @PropertySource 声明多个properties，如果有相同的值，后面的会覆盖前面的，所以要注意声明的顺序
 *  第二个properties使用到了${…​}占位符${ssm.env:development}。如果没有匹配到该占位符，使用默认的development。
 *  可以通过设置运行参数-Dssm.env="test"指定${ssm.env}占位符的值。会有相应的路径对应
 */
@Configuration
@ComponentScan(basePackages = "com.ssm.block.spring.propertysource")
@PropertySource({
	"classpath:/properties/env/common.properties",
	"classpath:/properties/env/${ssm.env:development}/jdbc.properties"
	})
public class AppConfig {
	
	@Autowired
    Environment env;
	
	@Bean("dataSource")
    public DataSource standaloneDataSource() {
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    	dataSource.setUrl(env.getProperty("jdbc.url"));
    	dataSource.setUsername(env.getProperty("jdbc.username"));
    	dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }
    
}