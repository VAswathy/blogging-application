package com.codewithdurgesh.blogappapi.service.impl;

import com.codewithdurgesh.blogappapi.exception.ResourceNotFoundException;
import com.codewithdurgesh.blogappapi.model.Category;
import com.codewithdurgesh.blogappapi.model.Post;
import com.codewithdurgesh.blogappapi.model.User;
import com.codewithdurgesh.blogappapi.payloads.CategoryDto;
import com.codewithdurgesh.blogappapi.payloads.PostDto;
import com.codewithdurgesh.blogappapi.repository.CategoryRepository;
import com.codewithdurgesh.blogappapi.repository.PostRepository;
import com.codewithdurgesh.blogappapi.repository.UserRepository;
import com.codewithdurgesh.blogappapi.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository catRepo;

    @Override
    public PostDto createPost(PostDto postDto,Long userId,Long categoryId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        Category category= this.catRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
        Post post=this.dtoToPost(postDto);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post savedPost = this.postRepo.save(post);
        return this.postToDto(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto categoryDto, Long postId) {

        //Post updatedPost = this.postRepo.save(post);
        return null;
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public List<PostDto> getPostByCategory(Long categoryId) {
        Category category= this.catRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
        List<Post> posts=this.postRepo.findByCategory(category);
        List<PostDto> postDto= posts.stream().map((posts) -> this.modelMapper.map(posts,PostDto.class))
                .collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<PostDto> getPostByUser(Long userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        List<Post> posts=this.postRepo.findByUser(user);
        List<PostDto> postDto= posts.stream().map((posts) -> this.modelMapper.map(posts,PostDto.class))
                .collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }

    public Post dtoToPost(PostDto postDto){
        Post post= this.modelMapper.map(postDto,Post.class);
        return post;
    }

    public PostDto postToDto(Post post){
        PostDto postDto= this.modelMapper.map(post,PostDto.class);
        return postDto;
    }
}
