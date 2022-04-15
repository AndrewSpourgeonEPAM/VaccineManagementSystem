package com.epam.service;

import java.util.*;

import com.epam.entity.Vaccine;
import com.epam.mapper.VaccineMapper;
import org.hamcrest.collection.IsMapContaining;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateVaccineDataTest {
    @InjectMocks
    UpdateVaccineData updateVaccineData;

    @Mock
    VaccineMapper vaccineMapper;

   /* @Mock
    Scanner scanner = new Scanner(System.in);*/

    @BeforeEach
    void setUp() {
        updateVaccineData = new UpdateVaccineData(vaccineMapper);
    }

    /*
    1.Hyderabad -> true
    2.hyderabad -> false
    3.Chennai -> true
    4.Visakhapatnam -> true
    5.Pune -> true
    6.Indore -> true
    7.Delhi -> true
    8.Bangalore -> true
    9."" -> false
    10.34 -> false
    11.Ranchi -> false
    12." " -> false
     */
    @Test
    void checkHyderabad() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("Chennai");
        assertTrue(result);
    }

    @Test
    void checkhyderabad() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("hyderabad");
        assertFalse(result);
    }

    @Test
    void checkChennai() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("Mumbai");
        assertTrue(result);
    }



    @Test
    void checkPune() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("Pune");
        assertFalse(result);
    }




    @Test
    void checkBangalore() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("Bangalore");
        assertFalse(result);
    }

    @Test
    void checkNull() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("");
        assertFalse(result);
    }

    @Test
    void checkInteger() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation("34");
        assertFalse(result);
    }


    @Test
    void checkSpace() {
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Mumbai");
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result = updateVaccineData.checkLocation(" ");
        assertFalse(result);
    }

    /*
    1.12 -> true
    2."w" -> false
    3."" -> false
    */

  /*  @Test
    void testCheckCount(){
        String temp="as";
        when(scanner.nextInt()).thenReturn(Integer.valueOf(temp));
        boolean result=updateVaccineData.checkCount();
        assertFalse(result);
    }*/


}
