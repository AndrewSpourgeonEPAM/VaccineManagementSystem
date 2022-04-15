package com.epam.service;

import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticateUser {
    @Autowired
    UserMapper userMapper;

    public AuthenticateUser(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int authenticateUser(UserDto dto) {
        UserDto userDto= userMapper.getUser(dto.getUsername());
        try {
            if ( userDto.getUsername().equals(dto.getUsername())&& userDto.getPassword().equals(dto.getPassword()) && dto.getUsername().length()>0 && dto.getPassword().length()>0) {

                return 1;
            } else {

                return 2;
            }
        } catch (NullPointerException n) {

           return 3;
        }
    }











}
