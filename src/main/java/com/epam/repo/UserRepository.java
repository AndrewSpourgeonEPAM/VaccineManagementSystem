package com.epam.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

	@Query("Select username from User")
	public List<String> getUsersList();
	

	@Query("Select aadhaarNumber from User")
	public List<String> getAadhaarList();
}
