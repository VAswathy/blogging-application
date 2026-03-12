package com.codewithdurgesh.blogappapi.service;

import com.codewithdurgesh.blogappapi.payloads.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Long categoryId);
}
