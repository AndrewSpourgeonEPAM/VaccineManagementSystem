package com.epam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.userinterface.Dashboard;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@EnableAutoConfiguration
@RestController
@SpringBootApplication(scanBasePackages="com")
@OpenAPIDefinition(info=@Info(title="Vaccine Management System",version="1.0",description="Book your vaccination in a minute"))
public class VaccineManagementSystemApplication{
	

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(VaccineManagementSystemApplication.class, args);
       Dashboard dashboard = context.getBean(Dashboard.class);
       dashboard.dashboard();
        
	}
}
