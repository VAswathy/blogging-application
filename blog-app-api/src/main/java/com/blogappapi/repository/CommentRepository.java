package com.codewithdurgesh.blogappapi.repository;

import com.codewithdurgesh.blogappapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
