package com.codewithdurgesh.blogappapi.service.impl;

import com.codewithdurgesh.blogappapi.exception.ResourceNotFoundException;
import com.codewithdurgesh.blogappapi.model.User;
import com.codewithdurgesh.blogappapi.payloads.UserDto;
import com.codewithdurgesh.blogappapi.repository.UserRepository;
import com.codewithdurgesh.blogappapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user= this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        User updatedUser= this.userRepository.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user= this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Long userId) {
        User user= this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepository.delete(user);
    }

    public User dtoToUser(UserDto userDto){
          User user= this.modelMapper.map(userDto,User.class);
/*        user.setId(userDto.getId());
          user.setName(userDto.getName());
          user.setEmail(userDto.getEmail());
          user.setPassword(userDto.getPassword());
          user.setAbout(userDto.getAbout()); */
          return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto= this.modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
