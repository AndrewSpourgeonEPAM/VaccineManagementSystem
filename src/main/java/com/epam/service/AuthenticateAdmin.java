package com.epam.service;

import com.epam.dto.AdminDto;
import com.epam.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateAdmin {
    @Autowired
    AdminMapper adminMapper;

    public AuthenticateAdmin(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

        public boolean checkAdmin (AdminDto dto) {
            AdminDto adminDto=adminMapper.getAdminDto("999900005555");
            try {
                if (adminDto.getUserId().equals(dto.getUserId()) && adminDto.getPassword().equals(dto.getPassword())) {

                    return true;
                } else {

                    return false;
                }
            }catch (NullPointerException n){
                return false;
            }
    }




}
