package com.epam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Configurations {
    private static ApplicationContext applicationContext = null;
    public static ApplicationContext getApplicationContext(){
        if(applicationContext==null){
            applicationContext = new AnnotationConfigApplicationContext(Configurations.class);
        }
        return applicationContext;
    }


}
