package com.epam.entity;

import javax.persistence.*;

@Entity
@Table(name = "Admin_Table")
public class Admin {

    @Id
    @Column(name = "User_ID",columnDefinition = "VARCHAR(64)")
    private String userId;

    @Column(name = "Password")
    private String password;

    public Admin(){}

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }





}
