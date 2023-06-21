package com.myapp.controller;

import com.myapp.payload.ApiResponse;
import com.myapp.payload.CommentDto;
import com.myapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/userId/{userId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId, @PathVariable Integer userId){
        CommentDto comments=this.commentService.createComment(commentDto, postId, userId);
        return new ResponseEntity<>(comments, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.delete(commentId);
        return new ResponseEntity(new ApiResponse("Comment deleted successfully", true),HttpStatus.OK);
    }
}
