package com.codewithdurgesh.blogappapi.service.impl;

import com.codewithdurgesh.blogappapi.exception.ResourceNotFoundException;
import com.codewithdurgesh.blogappapi.model.Category;
import com.codewithdurgesh.blogappapi.payloads.CategoryDto;
import com.codewithdurgesh.blogappapi.repository.CategoryRepository;
import com.codewithdurgesh.blogappapi.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=this.dtoToCategory(categoryDto);
        Category savedCategory = this.categoryRepository.save(category);
        return this.categoryToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category= this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCategory= this.categoryRepository.save(category);
        return this.categoryToDto(updatedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category= this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories= this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category= this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
        this.categoryRepository.delete(category);

    }

    public Category dtoToCategory(CategoryDto categoryDto){
        Category category= this.modelMapper.map(categoryDto,Category.class);
        return category;
    }

    public CategoryDto categoryToDto(Category category){
        CategoryDto categoryDto= this.modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }
}
