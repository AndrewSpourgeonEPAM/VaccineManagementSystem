package com.epam.service;

import com.epam.dto.AdminDto;
import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;
import com.epam.service.Builder.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AuthenticateUserTest {
    @InjectMocks
    AuthenticateUser authenticateUser;

    @Mock
    UserMapper userMapper;

    @BeforeEach
    void setUp() {
        authenticateUser=new AuthenticateUser(userMapper);
    }

    /*
    1.empty username -> 2
    2.empty password -> 2
    3.Incorrect username and correct password-> 2
    4.Incorrect password and correct username -> 2
    5.Correct credentials-> 1
     */
    @Test
    void emptyUsername() {
        UserDto userDto=new UserDto();
        userDto.setUsername("Andrew");
        userDto.setPassword("Justin");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        UserDto userDto1=new UserDto();
        userDto1.setUsername("");
        userDto1.setPassword("epam@369");
        int result=authenticateUser.authenticateUser(userDto1);
        assertEquals(2,result);
    }
    @Test
    void emptyPassword() {
        UserDto userDto=new UserDto();
        userDto.setUsername("Andrew");
        userDto.setPassword("Justin");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        UserDto userDto1=new UserDto();
        userDto1.setUsername("andrew");
        userDto1.setPassword("");
        int result=authenticateUser.authenticateUser(userDto1);
        assertEquals(2,result);
    }
    @Test
    void incorrectUsername() {
        UserDto userDto=new UserDto();
        userDto.setUsername("Andrew");
        userDto.setPassword("Justin");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        UserDto userDto1=new UserDto();
        userDto1.setUsername("and");
        userDto1.setPassword("epam@369");
        int result=authenticateUser.authenticateUser(userDto1);
        assertEquals(2,result);
    }
    @Test
    void incorrectPassword() {
        UserDto userDto=new UserDto();
        userDto.setUsername("Andrew");
        userDto.setPassword("Justin");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        UserDto userDto1=new UserDto();
        userDto1.setUsername("andrew");
        userDto1.setPassword("epam");
        int result=authenticateUser.authenticateUser(userDto1);
        assertEquals(2,result);
    }
    @Test
    void correctCredentials() {
        UserDto userDto=new UserDto();
        userDto.setUsername("Andrew");
        userDto.setPassword("Justin");
        given(userMapper.getUser(anyString())).willReturn(userDto);
        UserDto userDto1=new UserDto();
        userDto1.setUsername("Andrew");
        userDto1.setPassword("Justin");
        int result=authenticateUser.authenticateUser(userDto1);
        assertEquals(1,result);
    }


}