package com.epam.userinterface;

import com.epam.Configurations;
import com.epam.dto.UserDto;
import com.epam.service.AuthenticateUser;
import com.epam.utils.ScannerGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LoginUser {
    int temp;
    public static String username;
     String password;
    private static final Logger logger= LogManager.getLogger(LoginUser.class);

@Autowired
AuthenticateUser authenticateUser;
@Autowired
UserDashBoard userDashBoard;
@Autowired
UserDto userDto;

    public void setUserName(){
        boolean isvalid = false;
        do {
            logger.info("ENTER USERNAME : ");

           username= ScannerGenerator.getScanner().nextLine();
            if (username.isEmpty()) {
                logger.warn("Username cannot be empty");
                isvalid=true;
            } else {
            	userDto.setUsername(username);
                setPassword();
            }
        }while (isvalid);
    }
    public void setPassword() {
        boolean isValid=false;
        do {
            logger.info("ENTER PASSWORD: ");

           password=ScannerGenerator.getScanner().nextLine();
            if(password.isEmpty()){
                logger.warn("Password cannot be empty");
                isValid=true;
            }else {
              userDto.setPassword(password);
             temp= authenticateUser.authenticateUser(userDto);
             showLoginResult();
            }
        }while (isValid);
    }

    public void showLoginResult(){

        switch (temp){
            case (1)->{
                userDashBoard.showLoginResult(username);

            }
            case (2)->{
                userDashBoard.notifyError();
            }
            case (3)->{
                userDashBoard.notifyInvalid();
            }
        }
    }




}
