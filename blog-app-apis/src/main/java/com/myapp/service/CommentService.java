package com.myapp.service;

import com.myapp.entities.Comment;
import com.myapp.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
    void delete(Integer commentId);
}
