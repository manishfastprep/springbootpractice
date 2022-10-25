package com.example.fastprep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FastprepmavenApplication
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(FastprepmavenApplication.class, args);
		String applicationName = ctx.getApplicationName();
		System.out.println("Application Name is "+applicationName);
		ctx.getBeansWithAnnotation(SpringBootApplication.class).entrySet().stream().forEach(a -> System.out.println(a.getKey()+":"+a.getValue()));
	}

}
