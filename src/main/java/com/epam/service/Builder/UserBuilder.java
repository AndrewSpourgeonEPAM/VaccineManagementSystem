package com.epam.service.Builder;

import com.epam.dto.UserDto;
import com.epam.dto.VaccineDto;
import com.epam.mapper.UserMapper;
import com.epam.mapper.VaccineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class UserBuilder {

    @Autowired
    UserMapper userMapper;
    @Autowired
    VaccineMapper vaccineMapper;

    public UserBuilder(UserMapper userMapper, VaccineMapper vaccineMapper) {
        this.userMapper = userMapper;
        this.vaccineMapper = vaccineMapper;
    }


    public boolean setUserName(String userName) {
       return userName.isEmpty();
    }

    public boolean setPassword(String password) {
        return password.isEmpty();
    }

    public boolean setAadhaar(String aadhaar) {
        return (aadhaar.length()==12 && aadhaar.matches("[0-9]+") && aadhaar.length()>2);

    }

    public boolean setFirstDoseDate(String firstDoseDate) {
        try {
            LocalDate firstDose = LocalDate.parse(firstDoseDate);
            return true;
        }
        catch (DateTimeParseException d){
            return false;
        }
    }

    public boolean setSecondDoseDate(String secondDoseDate,String username) {
        try {
            UserDto userDto=userMapper.getUser(username);
            LocalDate secondDose = LocalDate.parse(secondDoseDate);
            LocalDate firstDose = LocalDate.parse(userDto.getFirstDoseDate());
            int daysDifference = (int) ChronoUnit.DAYS.between(firstDose,secondDose);
            if(daysDifference>60) {
                return true;
            }
            return false;
        }
        catch (DateTimeParseException d){
            return false;
        }
        catch (NullPointerException n){
            return false;
        }

    }

    public boolean isValidLocation(String firstDoseLocation) {
        VaccineDto vaccineDto=vaccineMapper.getVaccineDto(firstDoseLocation);
        List locations=vaccineMapper.getVaccineLocations();
        return (locations.contains(firstDoseLocation) && firstDoseLocation.length()>0 && vaccineDto.getVaccineCount()>0);
    }



}
