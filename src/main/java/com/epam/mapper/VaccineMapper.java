package com.epam.mapper;

import com.epam.Configurations;
import com.epam.dao.JpaDao;
import com.epam.dao.VaccineDao;
import com.epam.dao.VaccineJpaDao;
import com.epam.dto.VaccineDto;
import com.epam.entity.Admin;
import com.epam.entity.Vaccine;
import com.epam.exception.LocationNotFoundException;
import com.epam.repo.VaccineRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
public class VaccineMapper {

//    @Autowired
//    private VaccineJpaDao<Vaccine> vaccineJpaDao;

    @Autowired
    private VaccineRepository vaccineRepository;

    public VaccineDto getVaccineDto(String id){
 Optional<Vaccine> optionlVaccine= vaccineRepository.findById(id) ;
        Vaccine vaccine=optionlVaccine.orElseThrow(()->new LocationNotFoundException("Vaccines are not available in "+id));
        return convertEntityToDto(vaccine);
       
    }

    public VaccineDto updateVaccineCount(VaccineDto vaccineDto){

        Vaccine vaccine=convertDtoToEntity(vaccineDto);
        vaccineRepository.save(vaccine);
        return vaccineDto;
    }

  

	public List<VaccineDto> getVaccineList(){
		 Iterable<Vaccine> vaccine=vaccineRepository.findAll();
	        List<Vaccine> vaccines=new ArrayList<>();
	        vaccine.forEach(vaccines::add);
	        return convertEntityToDtoList(vaccines);
    }

    public VaccineDto convertEntityToDto(Vaccine vaccine){
    	
        ModelMapper modelMapper=new ModelMapper();
      return modelMapper.map(vaccine,VaccineDto.class);
    	
      }
    
    
    public Vaccine convertDtoToEntity(VaccineDto vaccineDto){
        ModelMapper modelMapper=new ModelMapper();
        Vaccine vaccine=modelMapper.map(vaccineDto,Vaccine.class);
        return vaccine;
    }
    
    private List<VaccineDto> convertEntityToDtoList(List<Vaccine> vaccines) {
    	ModelMapper modelMapper=new ModelMapper();
		return vaccines.stream().map(vac->modelMapper.map(vac, VaccineDto.class)).collect(Collectors.toList());
	}
    
    public List<String> getVaccineLocations(){
       return vaccineRepository.getLocationsList();
   }
}
