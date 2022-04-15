package com.epam.mapper;

import com.epam.Configurations;
import com.epam.dao.JpaDao;
import com.epam.dao.UserDao;
import com.epam.dto.UserDto;
import com.epam.entity.User;
import com.epam.exception.UserNotFoundException;
import com.epam.repo.UserRepository;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

//    @Autowired
//    UserDao userJpaDao;
    @Autowired
    UserRepository userRepository;
  
    public UserDto addUser(UserDto userDto){
        User user= convertDtoToEntity(userDto);
        userRepository.save(user);
        return userDto;
    }
    public void updateUser(UserDto userDto){

        User user= convertDtoToEntity(userDto);
        userRepository.save(user);

    }
    
    public boolean checkUser(String id) {
    	return userRepository.existsById(id);
    }

    public UserDto getUser(String id){

       Optional<User> optionalUser= userRepository.findById(id);
       User user=optionalUser.orElseThrow(()->new UserNotFoundException("User Not found with User Id "+id));
     return convertEntityToDto(user);
       
    }

    public void deleteUser(String id){

        userRepository.deleteById(id);
    }

    public List<String> getUserList(){
		return userRepository.getUsersList();
    }

    public List<String> getAdhaarList(){
  		return userRepository.getAadhaarList();
      }

    
    public User convertDtoToEntity(UserDto userDto){
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userDto,User.class);
    
    }

    public UserDto convertEntityToDto(User user){
        ModelMapper modelMapper=new ModelMapper();
       return modelMapper.map(user,UserDto.class);
    }

}
