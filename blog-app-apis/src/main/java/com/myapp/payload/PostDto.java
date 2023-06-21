package com.myapp.payload;

import com.myapp.entities.Category;
import com.myapp.entities.Comment;
import com.myapp.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private int postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private UserDto user;
    private CategoryDto category;

    private Set<CommentDto> comment= new HashSet<>();
}
