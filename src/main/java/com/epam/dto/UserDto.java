package com.epam.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Validated
@Repository
public class UserDto {

	
	@NotEmpty
    private String username;
	@NotEmpty(message="password cannot be empty")
    private String password;
	
	@Pattern(regexp = "[0-9]+")
	@Size(min=12,max=12)
    private String aadhaarNumber;
    
	
	
    private String firstDoseDate;
	
    private String secondDoseDate;
	
    private String firstDoseLocation;
	
    private String secondDoseLocation;
	
    private boolean bookedFirstDose;
	
    private boolean bookedSecondDose;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
       this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getFirstDoseDate() {
        return firstDoseDate;
    }

    public void setFirstDoseDate(String firstDoseDate) {
        this.firstDoseDate = firstDoseDate;
    }

    public String getSecondDoseDate() {
        return secondDoseDate;
    }

    public void setSecondDoseDate(String secondDoseDate) {
        this.secondDoseDate = secondDoseDate;
    }

    public String getFirstDoseLocation() {
        return firstDoseLocation;
    }

    public void setFirstDoseLocation(String firstDoseLocation) {
        this.firstDoseLocation = firstDoseLocation;
    }

    public String getSecondDoseLocation() {
        return secondDoseLocation;
    }

    public void setSecondDoseLocation(String secondDoseLocation) {
        this.secondDoseLocation = secondDoseLocation;
    }

    public boolean isBookedFirstDose() {
        return bookedFirstDose;
    }

    public void setBookedFirstDose(boolean bookedFirstDose) {
        this.bookedFirstDose = bookedFirstDose;
    }

    public boolean isBookedSecondDose() {
        return bookedSecondDose;
    }

    public void setBookedSecondDose(boolean bookedSecondDose) {
        this.bookedSecondDose = bookedSecondDose;
    }
}
