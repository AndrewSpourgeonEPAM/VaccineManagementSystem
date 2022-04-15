package com.epam.service.Builder;

import com.epam.dto.UserDto;
import com.epam.dto.VaccineDto;
import com.epam.mapper.UserMapper;
import com.epam.mapper.VaccineMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserBuilderTest {
    @InjectMocks
    UserBuilder userBuilder;
    @Mock
    UserMapper userMapper;
    @Mock
    VaccineMapper vaccineMapper;
    @BeforeEach
    void setUp() {
        userBuilder=new UserBuilder(userMapper,vaccineMapper);
    }

    /*
    1.Epmty  username -> true
    2.Integer username -> false
    3.String username -> false
     */
    @Test
    void emptyUsername() {
        boolean result= userBuilder.setUserName("");
        assertTrue(result);
    }
    @Test
    void integerUsername() {
        boolean result= userBuilder.setUserName("73328923");
        assertFalse(result);
    }
    @Test
    void stringUsername() {
        boolean result= userBuilder.setUserName("andrew");
        assertFalse(result);
    }


    /*
   1.Epmty  password -> true
   2.Integer password -> false
   3.String password -> false
    */
   @Test
    void emptyPassword() {
        boolean result= userBuilder.setPassword("");
        assertTrue(result);
    }
    @Test
    void integerPassword() {
        boolean result= userBuilder.setPassword("733");
        assertFalse(result);
    }
    @Test
    void stringPassword() {
        boolean result= userBuilder.setPassword("andrew@369");
        assertFalse(result);
    }



    /*
    1."" -> false
    2.11 -> false
    3.ad -> false
    4.aaaammmmgggg -> false
    5.222233334444 -> true
     */
    @Test
    void emptyAadhaar() {
        boolean result = userBuilder.setAadhaar("");
        assertFalse(result);
    }
    @Test
    void integerAadhaar() {
        boolean result = userBuilder.setAadhaar("aa");
        assertFalse(result);
    }
    @Test
    void invalidAadhaar() {
        boolean result = userBuilder.setAadhaar("11");
        assertFalse(result);
    }
    @Test
    void stringAadhaar() {
        boolean result = userBuilder.setAadhaar("aaaammmmgggg");
        assertFalse(result);
    }
    @Test
    void correctAadhaar() {
        boolean result = userBuilder.setAadhaar("222233334444");
        assertTrue(result);
    }



    /*
    1."" -> false
    2.sd -> false
    3.567 -> false
    4.yyyy-mm-dd -> false
    5.2022-03-12 -> true
     */
    @Test
    void emptyFirstDoseDate() {
        boolean result = userBuilder.setFirstDoseDate("");
        assertFalse(result);
    }
    @Test
    void checkFirstDoseDate() {
        boolean result = userBuilder.setFirstDoseDate("sd");
        assertFalse(result);
    }
    @Test
    void checksFirstDoseDate() {
        boolean result = userBuilder.setFirstDoseDate("567");
        assertFalse(result);
    }
    @Test
    void characterFirstDoseDate() {
        boolean result = userBuilder.setFirstDoseDate("yyyy-mm-dd");
        assertFalse(result);
    }
    @Test
    void FirstDoseDate() {
        boolean result = userBuilder.setFirstDoseDate("2022-03-12");
        assertTrue(result);
    }




    /*
   1."" -> false
   2.sd -> false
   3.567 -> false
   4.yyyy-mm-dd -> false
   5.2022-03-12 -> false
   6.2022-06-20 -> true
    */
    @Test
    void emptySecondDoseDate() {
        UserDto userDto=new UserDto();
        userDto.setUsername("DJ");
        userDto.setFirstDoseDate("2022-03-12");
        given(userMapper.getUser(anyString())).willReturn(userDto);
       boolean result = userBuilder.setSecondDoseDate("","DJ");
       assertFalse(result);
   }

   @Test
    void checSecondDoseDate() {
       UserDto userDto=new UserDto();
       userDto.setUsername("DJ");
       userDto.setFirstDoseDate("2022-03-12");
       given(userMapper.getUser(anyString())).willReturn(userDto);
       boolean result = userBuilder.setSecondDoseDate("sd","");
       assertFalse(result);

 }

  @Test
  void checkSecondDoseDate() {
      UserDto userDto=new UserDto();
      userDto.setUsername("DJ");
      userDto.setFirstDoseDate("2022-03-12");
      given(userMapper.getUser(anyString())).willReturn(userDto);
      boolean result = userBuilder.setSecondDoseDate("567","");

      assertFalse(result);
    }
    @Test
   void characterSecondDoseDate() {
        UserDto userDto=new UserDto();
        userDto.setUsername("DJ");
        userDto.setFirstDoseDate("2022-03-12");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        boolean result = userBuilder.setSecondDoseDate("yyyy-mm-dd","");
        assertFalse(result);
    }
    @Test
    void SecondDoseDate() {
        UserDto userDto=new UserDto();
        userDto.setUsername("DJ");
        userDto.setFirstDoseDate("2022-03-12");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        boolean result = userBuilder.setSecondDoseDate("2022-04-12","");
        assertFalse(result);
      }

  @Test
    void checksSecondDoseDate() {
      UserDto userDto=new UserDto();
      userDto.setUsername("DJ");
      userDto.setFirstDoseDate("2022-03-12");
      given(userMapper.getUser(anyString())).willReturn(userDto);
        boolean result = userBuilder.setSecondDoseDate("2022-06-10","");
        assertTrue(result);
    }

     /*
    1."" -> false
    2.Chen -> false
    3.78 -> false
     */

    @Test
    void emptyFirstDoseLocation() {
        VaccineDto vaccineDto=new VaccineDto();
        vaccineDto.setVaccineCount(20);
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Pune");
        when(vaccineMapper.getVaccineDto(anyString())).thenReturn(vaccineDto);
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result= userBuilder.isValidLocation("");
        assertFalse(result);
    }

   @Test
    void invalidFirstDoseLocation() {
       VaccineDto vaccineDto=new VaccineDto();
       vaccineDto.setVaccineCount(20);
       List<String> locations=new ArrayList<>();
       locations.add("Chennai");
       locations.add("Pune");
       when(vaccineMapper.getVaccineDto(anyString())).thenReturn(vaccineDto);
       when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result= userBuilder.isValidLocation("Chen");
        assertFalse(result);
    }

    @Test
    void integerFirstDoseLocation() {
        VaccineDto vaccineDto=new VaccineDto();
        vaccineDto.setVaccineCount(20);
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Pune");
        when(vaccineMapper.getVaccineDto(anyString())).thenReturn(vaccineDto);
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result= userBuilder.isValidLocation("78");
        assertFalse(result);
    }
    @Test
    void correctFirstDoseLocation() {
        VaccineDto vaccineDto=new VaccineDto();
        vaccineDto.setVaccineCount(20);
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Pune");
        when(vaccineMapper.getVaccineDto(anyString())).thenReturn(vaccineDto);
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result= userBuilder.isValidLocation("Chennai");
        assertTrue(result);
    }
    @Test
    void emptyVaccineCount() {
        VaccineDto vaccineDto=new VaccineDto();
        vaccineDto.setVaccineCount(0);
        List<String> locations=new ArrayList<>();
        locations.add("Chennai");
        locations.add("Pune");
        when(vaccineMapper.getVaccineDto(anyString())).thenReturn(vaccineDto);
        when(vaccineMapper.getVaccineLocations()).thenReturn(locations);
        boolean result= userBuilder.isValidLocation("Pune");
        assertFalse(result);
    }



}