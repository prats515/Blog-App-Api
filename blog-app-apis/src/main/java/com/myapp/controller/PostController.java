package com.myapp.controller;

import com.myapp.entities.Post;
import com.myapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post post= this.postService.createPost(post);
    }
}
