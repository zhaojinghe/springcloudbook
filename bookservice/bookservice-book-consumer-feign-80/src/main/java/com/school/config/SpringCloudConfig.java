package com.school.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class SpringCloudConfig {
	
	/**
	 * 调用服务模板
	 * @return
	 */
	@Bean
	@LoadBalanced  // 引入ribbon负载均
	public RestTemplate geRestTemplate(){
		
		
		return new RestTemplate();
	}

	/**
     * 自定义轮询算法
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RetryRule();
    }
}
