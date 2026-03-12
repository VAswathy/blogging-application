package com.codewithdurgesh.blogappapi.repository;

import com.codewithdurgesh.blogappapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
