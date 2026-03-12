package com.codewithdurgesh.blogappapi.repository;

import com.codewithdurgesh.blogappapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
