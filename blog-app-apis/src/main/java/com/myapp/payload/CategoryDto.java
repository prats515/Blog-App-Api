package com.myapp.payload;

import com.myapp.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotEmpty
    @Size(min=3, message = "Title must be min 4 chars")
    private String categoryTitle;
    @NotEmpty
    @Size(min=3, message = "Description must be min 10 chars")
    private String categoryDescription;
}
