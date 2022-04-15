package com.epam.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;
import com.epam.service.Builder.UserBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/book_dose_two")
public class DoseTwoRestController {
	
	@Autowired
    UserMapper userMapper;
	@Autowired
	UserBuilder userBuilder;
	
	@PostMapping("/{id}")
	@Operation(description="User can book dose two")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public ResponseEntity<String> updateUserDetails(@PathVariable("id") String username,@RequestBody UserDto userDto) {
	ResponseEntity<String> responseEntity;	
	UserDto dto=userMapper.getUser(username);
	if(userBuilder.isValidLocation(userDto.getSecondDoseLocation()) && userBuilder.setSecondDoseDate(userDto.getSecondDoseDate(),username) && dto.isBookedFirstDose() && !dto.isBookedSecondDose()) {
	dto.setSecondDoseDate(userDto.getSecondDoseDate());
	dto.setSecondDoseLocation(userDto.getSecondDoseLocation());
	dto.setBookedSecondDose(true);
	userMapper.updateUser(dto);
	responseEntity= new ResponseEntity<String>("DoseTwo Booked Successfulyy",HttpStatus.OK);
	}
	else {
		responseEntity= new ResponseEntity<>("Please Enter correct details",HttpStatus.BAD_REQUEST);
	}
	return responseEntity;
	}
}

