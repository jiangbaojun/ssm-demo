package com.ssm.block.spring.profile;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @Profile可以和@Bean结合用着方法上，也可以直接用在类上面
 */
@Configuration
public class AppConfig {

    @Bean("dataSource")
    @Profile("development") 
    public DataSource standaloneDataSource() {
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hello?connectTimeout=1000&socketTimeout=12000&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
    	dataSource.setUsername("root");
    	dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean("dataSource")
    @Profile("production") 
    public DataSource jndiDataSource() throws Exception {
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://140.100.130.105:3306/hello?connectTimeout=1000&socketTimeout=12000&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
    	dataSource.setUsername("root");
    	dataSource.setPassword("123456");
        return dataSource;
    }
}