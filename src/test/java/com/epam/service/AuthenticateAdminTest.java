package com.epam.service;

import com.epam.dto.AdminDto;
import com.epam.mapper.AdminMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticateAdminTest {
    /*TO-DO LIST
    1.USERID is null and PASSWORD is epam@369 -> true
    2.PASSWORD is null and USERID is 11112222333 -> true
    3.USERID is 111122223333  PASSWORD IS epam369 -> true
    4.USERID is 111122223335  PASSWORD IS epam@369 -> true
    3.USERID is epam@369  PASSWORD IS 111122223333 -> true
    5.USERID is 111122223333  PASSWORD IS epam@369 -> false
    */
    @InjectMocks
    AuthenticateAdmin authenticateAdmin;

    @Mock
     AdminMapper adminMapper;

    @BeforeEach
    void setUp() throws Exception {
       authenticateAdmin=new AuthenticateAdmin(adminMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    @DisplayName("User ID is null")
    void checkIfUserIdIsNull() {
       AdminDto adminDto=new AdminDto();
       adminDto.setUserId("999900005555");
       adminDto.setPassword("epam@369");
        given(adminMapper.getAdminDto(anyString())).willReturn(adminDto);
        AdminDto adminDto1=new AdminDto();
        adminDto1.setUserId("");
        adminDto1.setPassword("epam@369");
        boolean result= authenticateAdmin.checkAdmin(adminDto1);
        assertEquals(true,result);
    }

   @Test
    @DisplayName("Password is null")
    void checkIfPasswordIsNull(){
       AdminDto adminDto=new AdminDto();
       adminDto.setUserId("999900005555");
       adminDto.setPassword("epam@369");
       given(adminMapper.getAdminDto(anyString())).willReturn(adminDto);
       AdminDto adminDto1=new AdminDto();
       adminDto1.setUserId("111122223333");
       adminDto1.setPassword("");
        boolean result= authenticateAdmin.checkAdmin(adminDto1);
        assertEquals(true,result);
    }

    @Test
    @DisplayName("Password is incorrect but User Id is correct")
    void checkIfPasswordIsIncorrect(){
        AdminDto adminDto=new AdminDto();
        adminDto.setUserId("999900005555");
        adminDto.setPassword("epam@369");
        given(adminMapper.getAdminDto(anyString())).willReturn(adminDto);
        AdminDto adminDto1=new AdminDto();
        adminDto1.setUserId("111122223333");
        adminDto1.setPassword("epam@369");
        boolean result= authenticateAdmin.checkAdmin(adminDto1);
        assertEquals(true,result);
    }

    @Test
    @DisplayName("User Id is incorrect and password is correct")
    void checkIfUserIdIsIncorrect(){
        AdminDto adminDto=new AdminDto();
        adminDto.setUserId("999900005555");
        adminDto.setPassword("epam@369");
        given(adminMapper.getAdminDto(anyString())).willReturn(adminDto);
        AdminDto adminDto1=new AdminDto();
        adminDto1.setUserId("999900005555");
        adminDto1.setPassword("32723");
        boolean result= authenticateAdmin.checkAdmin(adminDto1);
        assertEquals(true,result);
    }

    @Test
    @DisplayName("User Id and Password are swapped")
    void checkIfCredentialsAreSwapped(){
        AdminDto adminDto=new AdminDto();
        adminDto.setUserId("999900005555");
        adminDto.setPassword("epam@369");
        given(adminMapper.getAdminDto(anyString())).willReturn(adminDto);
        AdminDto adminDto1=new AdminDto();
        adminDto1.setUserId("epam@369");
        adminDto1.setPassword("111122223333");
        boolean result= authenticateAdmin.checkAdmin(adminDto1);
        assertEquals(true,result);
    }

    @Test
    @DisplayName("Correct USER ID and PASSWORD")
    void checkCorrectCredentials(){
        AdminDto adminDto=new AdminDto();
        adminDto.setUserId("999900005555");
        adminDto.setPassword("epam@369");
        given(adminMapper.getAdminDto(anyString())).willReturn(adminDto);
        AdminDto adminDto1=new AdminDto();
        adminDto1.setUserId("999900005555");
        adminDto1.setPassword("epam@369");
        boolean result= authenticateAdmin.checkAdmin(adminDto1);
        assertEquals(false,result);
    }

}