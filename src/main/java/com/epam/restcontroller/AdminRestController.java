package com.epam.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.AdminDto;
import com.epam.dto.VaccineDto;
import com.epam.service.AuthenticateAdmin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/admin_login")
public class AdminRestController {
     
	@Autowired
	AuthenticateAdmin authenticateAdmin;
	
	@PostMapping
	@Operation(description="Admin can login here using id and password")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public ResponseEntity<String> checksAdmin(@RequestBody@Valid AdminDto adminDto) {
		ResponseEntity<String> responseEntity;
		if(authenticateAdmin.checkAdmin(adminDto)) {
			responseEntity= new ResponseEntity<String>("WELCOME ADMIN",HttpStatus.OK);
		}
		else {
			responseEntity= new ResponseEntity<String>("Invalid UserName or Password",HttpStatus.UNAUTHORIZED);
		}
		return responseEntity;
	}
}
