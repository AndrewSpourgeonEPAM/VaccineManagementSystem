package com.epam.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/register_user")
public class RegistrationRestController {
	@Autowired
    UserMapper userMapper;
	
	@PutMapping
	@Operation(description="Will register a new user")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public ResponseEntity<UserDto> registerUser(@RequestBody@Valid UserDto userDto){
		return new ResponseEntity<UserDto>(userMapper.addUser(userDto),HttpStatus.OK);
	}
	

}
