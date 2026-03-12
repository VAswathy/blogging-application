package com.codewithdurgesh.blogappapi.controller;

import com.codewithdurgesh.blogappapi.payloads.ApiResponse;
import com.codewithdurgesh.blogappapi.payloads.UserDto;
import com.codewithdurgesh.blogappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Post - createUser
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);
    }

    //Put - updateUser
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Long userId) {
        UserDto updatedUserDto= this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updatedUserDto); //Alternate format for Response Entity
    }

    //Delete - deleteUser
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Long userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
        //Alternate Method of Return - return ResponseEntity.ok(Map.of("message","User Deleted Successfully"));
    }

    //GetById - getUserById
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("id") Long userId) {
        UserDto userDto= this.userService.getUserById(userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    //Get - getAllUsers
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
