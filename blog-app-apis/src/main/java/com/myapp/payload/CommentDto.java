package com.myapp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
    private int id;
    private String content;
}
