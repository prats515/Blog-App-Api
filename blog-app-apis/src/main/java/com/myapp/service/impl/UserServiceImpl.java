package com.myapp.service.impl;

import com.myapp.entities.User;
import com.myapp.exceptions.ResourceNotFoundException;
import com.myapp.payload.UserDto;
import com.myapp.repositories.UserRepo;
import com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user=this.dtoToUser(userDto);
        User userSaved=this.userRepo.save(user);
        return this.userToDto(userSaved);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser= this.userRepo.save(user);

        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
       User user= this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "Id",userId));
       return this.userToDto(user);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= this.userRepo.findAll();
        List<UserDto> userDtos= users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto) {
        //User user= this.modelMapper.map(userDto, User.class);
        //return user;
        // modelMapper is use for to convert one class object to another thats wht i commented all this code
        //key- from  Value- TO
        User user= new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }
    private UserDto userToDto(User user) {
        //	UserDto userDto= this.modelMapper.map(user, UserDto.class);
        //return userDto;
        UserDto userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
