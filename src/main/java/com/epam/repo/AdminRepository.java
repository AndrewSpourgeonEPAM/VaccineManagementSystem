package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,String>{

}
