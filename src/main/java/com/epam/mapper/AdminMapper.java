package com.epam.mapper;

import com.epam.dao.AdminDao;
import com.epam.Configurations;
import com.epam.dao.AdminJpaDao;
import com.epam.dao.JpaDao;
import com.epam.dto.AdminDto;
import com.epam.entity.Admin;
import com.epam.repo.AdminRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AdminMapper {

//@Autowired
//private AdminJpaDao<Admin> adminJpaDao;

@Autowired
private AdminRepository adminRepository;

    public AdminDto getAdminDto(String id){
        Admin admin=adminRepository.getById(id);
        return convertEntityToDto(admin);
    }

    public AdminDto convertEntityToDto(Admin admin){
        ModelMapper modelMapper=new ModelMapper();
        AdminDto adminDto=modelMapper.map(admin,AdminDto.class);
        return adminDto;
    }
}
