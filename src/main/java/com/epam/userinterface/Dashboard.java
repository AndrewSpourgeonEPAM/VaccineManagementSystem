package com.epam.userinterface;

import java.util.Scanner;

import com.epam.Configurations;
import com.epam.utils.ScannerGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Dashboard {
   private static final Logger logger=LogManager.getLogger(Dashboard.class);
    String choice;
    boolean isValidChoice;

    @Autowired
    Registration registration;
    @Autowired
    LoginUser loginUser;
    @Autowired
    LoginAdmin loginAdmin;

    public void dashboard(){
        do {
            logger.info("----Vaccine Management Tool----");
            logger.info("I am drew your assistant please tell us who you are -> ");
            logger.info("IF YOU ARE AN ADMIN PLEASE PRESS A ");
            logger.info("IF YOU ARE AN EXISTING USER PLEASE PRESS E");
            logger.info("IF YOU ARE AN NEW USER PLEASE PRESS N ");
            choice = ScannerGenerator.getScanner().nextLine();
            navigatesUser(choice);
        }while (isValidChoice);

    }
    public void navigatesUser(String choice){
    switch (choice) {
        case ("A") -> {

            loginAdmin.takeAdminID();

        }
        case ("N") -> {

            registration.newUsersGuide();

        }
        case ("E") -> {

            loginUser.setUserName();
        }
        default -> {

             isValidChoice=true;
            logger.warn("Please select a valid option ");

        }
    }


    }
}
