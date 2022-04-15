package com.epam.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.UserDto;
import com.epam.dto.VaccineDto;
import com.epam.mapper.UserMapper;
import com.epam.service.AuthenticateUser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/user_login")
public class UserRestController {

	@Autowired
    UserMapper userMapper;
	@Autowired
	AuthenticateUser authenticateUser;
	
	@PostMapping
	@Operation(description="User can login with valid credentials")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public ResponseEntity<String> checksUser(@RequestBody UserDto userDto) {
		ResponseEntity<String> responseEntity;
		if(authenticateUser.authenticateUser(userDto)==1) {
			responseEntity= new ResponseEntity<String>("WELCOME "+userDto.getUsername(),HttpStatus.OK);
		}
		else{
			responseEntity= new ResponseEntity<String>("Invalid UserName or Password",HttpStatus.UNAUTHORIZED);
		}
		return responseEntity;
	}
	
	@GetMapping("/user_profile/{id}")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public ResponseEntity<UserDto> getUser(@PathVariable("id") String username) {
	return new ResponseEntity<UserDto>(userMapper.getUser(username),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_user/{id}")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public ResponseEntity<String> deletesUser(@PathVariable("id") String username){
		userMapper.deleteUser(username);
		return new ResponseEntity<String>("User accounr with id "+username+" deleted successfulyy",HttpStatus.OK);
	}	
	
}
