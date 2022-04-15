package com.epam.entity;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
public class User {

	@Id
	@Column(unique = true,columnDefinition = "VARCHAR(64)")
	private String username;
	
	@Column 
	private String password;

	@Column(unique = true, columnDefinition = "VARCHAR(64)")
	private String aadhaarNumber;

	@Column
	private String firstDoseDate;

	@Column
	private String secondDoseDate;

	@Column
	private boolean bookedFirstDose;
	
	@Column
	private boolean bookedSecondDose;

	@Column
	private String firstDoseLocation;

	@Column
	private String secondDoseLocation;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
