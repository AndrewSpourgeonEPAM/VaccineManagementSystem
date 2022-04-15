package com.epam.userinterface;

import com.epam.Configurations;
import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;
import com.epam.service.UpdateVaccineData;
import com.epam.utils.ScannerGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AdminDashboard {

    private static final Logger logger= LogManager.getLogger(AdminDashboard.class);
    String adminChoice;
    String location;
    boolean isValidChoice;
   @Autowired
   VaccineMapper vaccineMapper;
   @Autowired
   UpdateVaccineData updateVaccineData;
   @Autowired
   Dashboard dashboard;



    public void guidesTheAdmin()  {
        logger.info("-------Welcome ADMIN--------" );
        logger.info("Here is the ADMIN DASHBOARD");
        showsAdminDashboard();
    }
    public void notifyError(){
        logger.debug("Incorrect Password");
    }

    public void showsAdminDashboard()  {
        do {
            logger.info("TO VIEW THE AVAILABLE LOCATIONS AND VACCINES PRESS 1 : ");
            logger.info("TO UPDATE THE AVAILABLE VACCINE COUNT PRESS 2 : ");
            logger.info("TO LOGOUT PRESS 3 : ");

                adminChoice = ScannerGenerator.getScanner().nextLine();
                navigatesAdmin(adminChoice);

        }while (isValidChoice);
    }
    public void navigatesAdmin(String adminChoice)  {

        switch (adminChoice){
            case ("1")->{

              logger.info(vaccineMapper.getVaccineList());
               isValidChoice=true;
            }
            case ("2")->
              getAdminInput();

            case("3")->{
                logger.info("THANK YOU !!!");
                logger.info("You have Logged out");

                dashboard.dashboard();
            }
            default -> {
                logger.warn("Please select a valid option");
                isValidChoice=true;
            }
        }
    }
    public void getAdminInput(){

        boolean isValidLocation;
        do {
            logger.info("Enter the city name you where you want to update the count");
            logger.info("Hyderabad/Visakhapatnam/Indore/Bangalore/Delhi/Chennai : ");
            location = ScannerGenerator.getScanner().nextLine();
            isValidLocation=updateVaccineData.checkLocation(location);
            if(isValidLocation) {
                VaccineDto vaccineDto=vaccineMapper.getVaccineDto(location);
                vaccineDto.setLocation(location);
                logger.info("Enter the new Vaccination count : ");
                while (!ScannerGenerator.getScanner().hasNextInt()) ScannerGenerator.getScanner().next();
                int num1 = ScannerGenerator.getScanner().nextInt();
                       vaccineDto.setVaccineCount(num1);
                       vaccineMapper.updateVaccineCount(vaccineDto);
                       logger.info("Successfully updated vaccine count in {} to {}",vaccineDto.getLocation(),vaccineDto.getVaccineCount());
                       showsAdminDashboard();
            }
            else {
                logger.error("Enter a valid city name");
                isValidLocation=false;
            }
        }while (!isValidLocation);
    }
}
