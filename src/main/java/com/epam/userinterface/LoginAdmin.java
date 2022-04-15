package com.epam.userinterface;

import com.epam.Configurations;
import com.epam.dto.AdminDto;
import com.epam.service.AuthenticateAdmin;
import com.epam.utils.ScannerGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoginAdmin  {

    boolean temp;
    private static final Logger logger= LogManager.getLogger(LoginAdmin.class);

    @Autowired
    AuthenticateAdmin authenticateAdmin;
    @Autowired
    AdminDashboard adminDashboard;
    @Autowired
    AdminDto adminDto;

    public void takeAdminID(){
        boolean isEmpty=false;
        do {
            logger.info("***Please Enter your user ID*** : ");
        String  adminId= ScannerGenerator.getScanner().nextLine();
        
            if (adminId.isEmpty()) {
                logger.error("Invalid USER ID");
                isEmpty=true;

            } else {
                adminDto.setUserId(adminId);
                takeAdminPassword();
            }
        }while (isEmpty);
    }


    public void takeAdminPassword(){
        boolean isEmpty;
        do {
            logger.info("***Please Enter ADMIN password*** : ");
        String adminPassword=ScannerGenerator.getScanner().nextLine();
            if (adminPassword.isEmpty()) {
                logger.error("Invalid Password");
                isEmpty = true;
            } else {
                adminDto.setPassword(adminPassword);
                isEmpty=authenticateAdmin.checkAdmin(adminDto);
                temp=isEmpty;
                showLoginResult();
                takeAdminID();
            }
        }while (isEmpty );

    }
    
    public void showLoginResult(){

        if(temp){
            adminDashboard.notifyError();
        }
        else{
            adminDashboard.guidesTheAdmin();
        }

    }

}