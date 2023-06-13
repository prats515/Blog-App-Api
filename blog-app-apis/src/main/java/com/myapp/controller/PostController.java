package com.myapp.controller;

import com.myapp.entities.Category;
import com.myapp.entities.Post;
import com.myapp.entities.User;
import com.myapp.payload.PostDto;
import com.myapp.repositories.PostRepo;
import com.myapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepo postRepo;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        PostDto post= this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    public ResponseEntity<PostDto>updatePost(@RequestBody Integer postId,PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        Post updatedPost=this.postService.updatePost(postDto, postId);

        return null;
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>>getPostByUser(@RequestBody @PathVariable Integer userId){
        List<PostDto> posts=this.postService.getPostByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>>getPostByCategory(@RequestBody @PathVariable Integer categoryId){
        List<PostDto> posts=this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
