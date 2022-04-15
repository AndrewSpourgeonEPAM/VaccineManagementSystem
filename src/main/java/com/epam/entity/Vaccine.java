package com.epam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vaccine_Data")
public class Vaccine {

    @Id
    @Column(name = "Location",columnDefinition = "VARCHAR(64)")
    private String location;

    @Column(name = "VaccineCount")
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
        return "location='" + location + ", vaccineCount=" + vaccineCount ;
    }
}
