package com.example.fastprep;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.example")
public class Config
{
	@Bean("cpu")
	public CPU createCPU()
	{
		return new CPU("i5",7);
	}
	@Bean
	public Map<String,String> map()
	{
		Map<String,String> map = new HashMap<>();
		map.put("partitionSize", "500MB");
		return map;
	}
}
