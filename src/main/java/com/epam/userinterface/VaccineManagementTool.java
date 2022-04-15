package com.epam.userinterface;


import com.epam.Configurations;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class VaccineManagementTool {

    public static void main(String[] args)  {
   ApplicationContext applicationContext=Configurations.getApplicationContext();
   Dashboard dashboard=applicationContext.getBean(Dashboard.class);
        dashboard.dashboard();
    }
}
