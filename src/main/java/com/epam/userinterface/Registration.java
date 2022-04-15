package com.epam.userinterface;

import com.epam.Configurations;
import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;
import com.epam.service.Builder.UserBuilder;
import com.epam.utils.ScannerGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Registration {

    private static final Logger logger= LogManager.getLogger(Registration.class);

    @Autowired
    UserDto userDto;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserBuilder userBuilder;
    @Autowired
    UserDashBoard userDashBoard;




    public void newUsersGuide(){
        logger.info("Hello I am Drew , I am here to help you in the process of registration");
        logger.info("Please provide us some details about you, to assist you throughout this process");
        logger.info("---------------------------------------------------");
        setUsername();
    }

    public void setUsername() {

        boolean isEmpty;
        do {
            logger.info("Enter the USERNAME : ");
           String username=ScannerGenerator.getScanner().nextLine();

           isEmpty=userBuilder.setUserName(username);
            if (isEmpty) {
                logger.warn("User Name cannot be empty");
            } else {
                LoginUser.username=username;
                userDto.setUsername(username);
                setPassword();
            }
        }while (isEmpty);
    }
    public void setPassword() {

        boolean isEmpty;
        do {
            logger.info("Enter the PASSWORD : ");
            String password = ScannerGenerator.getScanner().nextLine();

            isEmpty=userBuilder.setPassword(password);
             if (isEmpty){
                 logger.warn("Password cannot be empty");
             }
             else {
                 userDto.setPassword(password);
                 setAadhaarNumber();
             }
        }while (isEmpty);
    }
    public void setAadhaarNumber() {

        boolean isValid;
        do {
            logger.info("Enter the AADHAAR NUMBER : ");
            String aadhaar=ScannerGenerator.getScanner().nextLine();

            isValid=userBuilder.setAadhaar(aadhaar);
            if (isValid) {
                userDto.setAadhaarNumber(aadhaar);

                userMapper.addUser(userDto);

                userDashBoard.notifyRegistrationResult();
            } else {
                logger.warn("Enter a valid 12 digit AADHAAR NUMBER please");
            }
        }while (!isValid);
    }


}
