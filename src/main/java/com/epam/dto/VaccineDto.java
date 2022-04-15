package com.epam.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Validated
@Repository
public class VaccineDto {

	
	@NotEmpty(message="Location cannot be empty")
    private String location;
	
	@NotNull
	@Digits(fraction = 0, integer = 3)
    private Integer vaccineCount;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getVaccineCount() {
        return vaccineCount;
    }

    public void setVaccineCount(Integer vaccineCount) {
        this.vaccineCount = vaccineCount;
    }

	@Override
	public String toString() {
		return "location=" + location + ", vaccineCount=" + vaccineCount;
	}



}
