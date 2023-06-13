package com.myapp.service.impl;

import com.myapp.entities.Category;
import com.myapp.exceptions.ResourceNotFoundException;
import com.myapp.payload.CategoryDto;
import com.myapp.repositories.CategoryRepo;
import com.myapp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category= this.modelMapper.map(categoryDto, Category.class);
        Category createdCategory=this.categoryRepo.save(category);
        return this.modelMapper.map(createdCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","CategoryId", categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCat= this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "CategoryId", categoryId));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "CategoryId", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories=this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos= categories.stream().map((cat) -> this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
