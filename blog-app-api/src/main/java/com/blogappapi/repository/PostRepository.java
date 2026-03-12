package com.codewithdurgesh.blogappapi.repository;

import com.codewithdurgesh.blogappapi.model.Category;
import com.codewithdurgesh.blogappapi.model.Post;
import com.codewithdurgesh.blogappapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user); //find all post by user
    List<Post> findByCategory(Category category);
}
