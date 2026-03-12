package com.codewithdurgesh.blogappapi.controller;

import com.codewithdurgesh.blogappapi.payloads.ApiResponse;
import com.codewithdurgesh.blogappapi.payloads.CategoryDto;
import com.codewithdurgesh.blogappapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Post - createCategory
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategoryDto= this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategoryDto, HttpStatus.CREATED);
    }

    //Put - updateCategory
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("id") Long categoryId) {
        CategoryDto updatedCategoryDto= this.categoryService.updateCategory(categoryDto,categoryId);
        return ResponseEntity.ok(updatedCategoryDto); //Alternate format for Response Entity
    }

    //Delete - deleteCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("id") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
    }

    //GetById - getCategoryById
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("id") Long categoryId) {
        CategoryDto categoryDto= this.categoryService.getCategoryById(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    //Get - getAllCategories
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }
}


