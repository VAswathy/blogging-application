package com.codewithdurgesh.blogappapi.controller;

import com.codewithdurgesh.blogappapi.payloads.ApiResponse;
import com.codewithdurgesh.blogappapi.payloads.PostDto;
import com.codewithdurgesh.blogappapi.payloads.UserDto;
import com.codewithdurgesh.blogappapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    //Post - createPost
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,@PathVariable Long userId,@PathVariable Long categoryId) {
        PostDto createdPostDto= this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createdPostDto, HttpStatus.CREATED);
    }

    //Get Posts by User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId){
        List<PostDto> posts= this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

     //Get Posts by User
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId) {
        List<PostDto> posts= this.postService.getPostByUser(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
/*
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
    } */
}



