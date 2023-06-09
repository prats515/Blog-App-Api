package com.myapp.controller;

import com.myapp.entities.Category;
import com.myapp.payload.ApiResponse;
import com.myapp.payload.CategoryDto;
import com.myapp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    };

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
      CategoryDto updatedCat=this.categoryService.updateCategory(categoryDto, categoryId);
      return new ResponseEntity<CategoryDto>(updatedCat,HttpStatus.OK);
    };
    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity(new ApiResponse("Category Deleted", true),HttpStatus.OK);
    }

    //get
    @GetMapping("/")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        CategoryDto categoryDto=this.categoryService.getCategory(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> catDto=this.categoryService.getCategories();
        return ResponseEntity.ok(catDto);
    }

}





