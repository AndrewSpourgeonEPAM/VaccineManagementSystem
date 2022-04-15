package com.epam.dto;


import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Validated
@Repository
public class AdminDto {
    @NotEmpty(message="User Id cannot be empty")
    private String userId;
    
    @NotEmpty(message="Password cannot be empty")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
