package com.epam.userinterface;

import com.epam.dto.UserDto;
import com.epam.dto.VaccineDto;
import com.epam.factsAPI.FactsAPI;
import com.epam.mapper.UserMapper;
import com.epam.mapper.VaccineMapper;
import com.epam.service.Builder.UserBuilder;
import com.epam.utils.ScannerGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.InputMismatchException;
import java.time.*;

@Component
public class UserDashBoard {

    private static final Logger logger= LogManager.getLogger(UserDashBoard.class);
    boolean isValidChoice=false;
   @Autowired
   Dashboard dashboard;
    @Autowired
    UserMapper userMapper;
    @Autowired
    LoginUser loginUser;
@Autowired
VaccineMapper vaccineMapper;
@Autowired
UserBuilder userBuilder;

    public void notifyRegistrationResult(){

        UserDto userDto=userMapper.getUser(LoginUser.username);
        logger.info("***** Registration Successful *****");

        logger.info("Welcome {} !!", userDto.getUsername());
        logger.info("------Now you can login------ ");

        loginUser.setUserName();
    }
    public void showLoginResult(String username){
        logger.info("***** LOGIN Successful *****");
        UserDto userDto=userMapper.getUser(username);
        logger.info("Welcome {} !!", userDto.getUsername());
        logger.info("***** HERE IS THE USER DASHBOARD *****");
        showsUserDashboard();
    }
    public void notifyError(){
        logger.error("*****INVALID USERNAME OR PASSWORD*****");
        loginUser.setUserName();
    }
    public void notifyInvalid(){
        logger.info("User Does not Exist , Please register first");
        dashboard.dashboard();
    }
    public void showsUserDashboard(){

         do {
             logger.info("TO VIEW THE AVAILABLE LOCATIONS AND VACCINES PRESS 1 : ");
             logger.info("TO BOOK DOSE 1 PRESS 2 : ");
             logger.info("TO BOOK DOSE 2 PRESS 3 : ");
             logger.info("TO SEE YOUR PROFILE PRESS 4 : ");
             logger.info("FOR A RANDOM FACT PRESS 5: ");
             logger.info("TO LOGOUT PRESS 6 :");
             logger.info("TO DELETE YOUR ACCOUNT PRESS 7 :");
             try {
                 int userChoice = ScannerGenerator.getScanner().nextInt();
                 navigatesUser(userChoice);
             } catch (InputMismatchException i) {
                 logger.warn("Please select a valid option : ");
                isValidChoice=true;
             }
         }while (isValidChoice);
    }
    public void navigatesUser(int userChoice){

        UserDto userDto=userMapper.getUser(LoginUser.username);

             switch (userChoice) {
                 case (1) -> {

                  logger.info(vaccineMapper.getVaccineList());
                     isValidChoice=true;
                 }
                 case (2) -> {
                     if (!userDto.isBookedFirstDose()) {
                         bookDoseOne();
                     } else {
                         logger.warn("You have already booked your first Dose please choose another option");
                         isValidChoice=true;
                     }
                 }
                 case (3) -> {
                     if (!userDto.isBookedSecondDose() && userDto.isBookedFirstDose()) {
                         bookDoseTwo();
                     } else {
                         logger.warn("Sorry ! Looks like you need to book DOSE 1 first or You have already booked both Doses");
                         isValidChoice=true;
                     }
                 }
                 case(4)->{
                    userProfile();
                    isValidChoice=true;
                 }
                 case(5)->{
                     boolean exit;
                     do {
                         FactsAPI factsAPI = new FactsAPI();
                         logger.info("=".repeat(20));
                         factsAPI.fetchFacts();
                         logger.info("=".repeat(20));
                         logger.info("Press 1 to get another fact : ");
                         logger.info("To go back press anything other than 1 : ");
                         int choice=ScannerGenerator.getScanner().nextInt();
                         if(choice==1){
                             exit=true;
                         }
                         else{
                             exit=false;
                             isValidChoice=true;
                         }
                     }while (exit);

                 }
                 case (6) -> {
                     logger.info("THANK YOU !!!");
                     logger.info("You have Logged out");
                     dashboard.dashboard();
                 }
                 case(7)->{
                     userMapper.deleteUser(userDto.getUsername());
                     logger.info("=====You have successfully Deleted your account=====");
                     dashboard.dashboard();
                 }
                 default -> {
                     logger.warn("Please select a valid option");
                    isValidChoice=true;

                 }
             }

    }

    public void bookDoseOne(){
         boolean isValid;
         do {

                 logger.info("In which city do you want to book Dose 1");
                 logger.info("Hyderabad/Visakhapatnam/Indore/Bangalore/Delhi/Chennai : ");
                String location=ScannerGenerator.getScanner().nextLine();
                isValid= userBuilder.isValidLocation(location);
                 if (isValid) {

                     getDoseOneDateInput(location);
                 } else {
                     logger.warn("Looks like you entered a invalid location or may be the vaccines are not available at that location");
                     logger.warn("**** PLEASE CHOOSE A DIFFERENT LOCATION ****");
                 }

         }while (!isValid);
    }
    public void getDoseOneDateInput(String location){
        boolean isValid;
        do {
            logger.info("Enter the date in this format (yyyy-mm-dd) : ");
            String date = ScannerGenerator.getScanner().nextLine();
            UserDto userDto=userMapper.getUser(LoginUser.username);
            isValid=userBuilder.setFirstDoseDate(date);
            if(isValid) {
                userDto.setFirstDoseDate(date);
                userDto.setFirstDoseLocation(location);
                userDto.setBookedFirstDose(true);
                userMapper.updateUser(userDto);
                VaccineDto vaccineDto=vaccineMapper.getVaccineDto(location);
                vaccineDto.setLocation(location);
                vaccineDto.setVaccineCount(vaccineDto.getVaccineCount()-1);
                vaccineMapper.updateVaccineCount(vaccineDto);
                LocalDate firstDose = LocalDate.parse(date);
                LocalDate firstDoseEndDate = firstDose.plusMonths(2);
                logger.info("You have successfully booked you 1st Dose at {} on {}", userDto.getFirstDoseLocation(), userDto.getFirstDoseDate());
                logger.info("You can book your SECOND DOSE after {}", firstDoseEndDate);
                showsUserDashboard();
            }
        }while (!isValid);
    }


    public void bookDoseTwo(){
         boolean isValid;
         do {

                 logger.info("In which city do you want to book Dose 2");
             logger.info("Hyderabad/Visakhapatnam/Indore/Bangalore/Delhi/Chennai : ");
             String location = ScannerGenerator.getScanner().nextLine();
                isValid=userBuilder.isValidLocation(location);
                 if (isValid) {

                     getDoseTwoDateInput(location);

                 } else {
                     logger.warn("Looks like you entered a invalid location or may be the vaccines are not available at that location");
                     logger.warn("**** PLEASE CHOOSE A DIFFERENT LOCATION ****");
                 }

         }while (!isValid);
    }
public void getDoseTwoDateInput(String location){
    boolean reslut;
  do  {
        logger.info("Enter the date in this format (yyyy-mm-dd) : ");
        String date = ScannerGenerator.getScanner().nextLine();
      UserDto userDto=userMapper.getUser(LoginUser.username);
        reslut = userBuilder.setSecondDoseDate(date,LoginUser.username);
        if(reslut) {
            userDto.setSecondDoseDate(date);
            userDto.setSecondDoseLocation(location);
                userDto.setBookedSecondDose(true);
               userMapper.updateUser(userDto);
               VaccineDto vaccineDto=vaccineMapper.getVaccineDto(location);
               vaccineDto.setLocation(location);
               vaccineDto.setVaccineCount(vaccineDto.getVaccineCount()-1);
               vaccineMapper.updateVaccineCount(vaccineDto);
                logger.info("You have successfully booked you 2nd Dose at {} on {}", userDto.getSecondDoseLocation(), userDto.getSecondDoseDate());
                showsUserDashboard();
            }
        else {
            LocalDate firstDose = LocalDate.parse(userDto.getFirstDoseDate());
            LocalDate firstDoseEndDate = firstDose.plusMonths(2);
            logger.warn("Sorry you can only book your second dose after {} or May be you have given an invalid date input", firstDoseEndDate);

            }


    }while (!reslut);

}










    public void userProfile() {
        UserDto userDto=userMapper.getUser(LoginUser.username);
        logger.info("Name : {}",userDto.getUsername());
        logger.info("Aadhaar Number : {}", userDto.getAadhaarNumber());
        if (userDto.isBookedFirstDose()) {
            logger.info("First Dose status :");
            logger.info("Booked on : {} at {}" , userDto.getFirstDoseDate(),userDto.getFirstDoseLocation());
        } else {
            logger.info("You haven't booked your FIRST DOSE !");
        }
        if (userDto.isBookedSecondDose()) {
            logger.info("Second Dose status :");
            logger.info("Booked on : {} at {}" , userDto.getSecondDoseDate(),userDto.getSecondDoseLocation());
        } else {
            logger.info("You haven't booked your SECOND DOSE !");
        }
    }
}
