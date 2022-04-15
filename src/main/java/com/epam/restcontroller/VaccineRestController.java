package com.epam.restcontroller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/vaccinesdata")
public class VaccineRestController  {
	
	@Autowired
	VaccineMapper vaccineMapper;
	
	@GetMapping
	@Operation(description="Ferches all the data regarding available vaccines")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	public List<VaccineDto> getVaccineData(){
		return vaccineMapper.getVaccineList();
	}
	
	@PostMapping("/updatedata")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	@Operation(description="Updates the data of a specific location")
	public ResponseEntity<VaccineDto> insertsVaccineData(@RequestBody@Valid VaccineDto vaccineDto) {
	return new ResponseEntity<VaccineDto>(vaccineMapper.updateVaccineCount(vaccineDto),HttpStatus.OK);
	}
     
	@GetMapping("/{id}")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	@Operation(description="Ferches the vaccine count in a specific location")
	public ResponseEntity<VaccineDto> getVaccineDetails(@PathVariable("id") String location) {
	return new ResponseEntity<VaccineDto>(vaccineMapper.getVaccineDto(location),HttpStatus.OK);
	}
	
	@GetMapping("/locations")
	@ApiResponses({@ApiResponse(responseCode="200",description="Sucessfull"),@ApiResponse(responseCode="400",description="Bad Request")})
	@Operation(description="Ferches the available locations")
	public ResponseEntity<List<String>> getLocations() {
	return new ResponseEntity<List<String>>(vaccineMapper.getVaccineLocations(),HttpStatus.OK);
	}
	
	
}
