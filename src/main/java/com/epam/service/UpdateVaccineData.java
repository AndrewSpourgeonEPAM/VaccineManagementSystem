package com.epam.service;

import com.epam.mapper.VaccineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class UpdateVaccineData {

    /*public static int count;*/
    @Autowired
    VaccineMapper vaccineMapper;

    public UpdateVaccineData(VaccineMapper vaccineMapper) {
        this.vaccineMapper = vaccineMapper;
    }


   public boolean checkLocation(String location) {
       List locations=vaccineMapper.getVaccineLocations();
        return (locations.contains(location)
        );
    }
/*
    public boolean checkCount() {
        try {
               Scanner scanner=new Scanner(System.in);
                int newVaccineCount = scanner.nextInt();
                this.count=newVaccineCount;
                return true;
        } catch (InputMismatchException i) {
            return false;
        }

    }*/




}
