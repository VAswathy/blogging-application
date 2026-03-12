package com.codewithdurgesh.blogappapi.service;

import com.codewithdurgesh.blogappapi.model.Post;
import com.codewithdurgesh.blogappapi.payloads.CategoryDto;
import com.codewithdurgesh.blogappapi.payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto,Long userId,Long categoryId);
    PostDto updatePost(PostDto categoryDto, Long postId);
    Post getPostById(Long postId);
    List<Post> getAllPosts();
    void deletePost(Long postId);
    //get all posts by category
    List<PostDto> getPostByCategory(Long categoryId);
    //get all posts by user
    List<PostDto> getPostByUser(Long userId);
    List<Post> searchPosts(String keyword);
}
