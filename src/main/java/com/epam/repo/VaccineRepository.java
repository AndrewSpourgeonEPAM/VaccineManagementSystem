package com.epam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine,String>{

	
	@Query("Select location from Vaccine")
	public List<String> getLocationsList();
}
