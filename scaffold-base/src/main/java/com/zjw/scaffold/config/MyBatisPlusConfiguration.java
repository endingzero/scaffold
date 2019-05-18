package com.zjw.scaffold.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @program scaffold
 * @description:mapper配置
 * @author: zhuangjiewei
 * @create: 2019/03/28 15:10
 */
@Configuration
@MapperScan(basePackages = {"com.**.mapper"})
public class MyBatisPlusConfiguration {
	/**
	 * 输出格式化SQL
	 * 
	 * @return
	 */
	@Bean
	@Profile("dev")
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}
}
