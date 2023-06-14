package com.myapp.service;

import com.myapp.entities.Post;
import com.myapp.payload.PostDto;
import com.myapp.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto post, Integer userId, Integer categoryId );

    PostDto updatePost(PostDto post, Integer postId);
//delete post
    void deletePost(Integer postId);
//get post by Id
    PostDto getPostById(Integer postId);
//get all post
    PostResponse getAllPost(Integer pageSize, Integer pageNumber);
//get all post by users
    List<PostDto> getPostByUser(Integer userId);
    //get all post by category
    List<PostDto> getPostByCategory(Integer categoryId);
    //search by keywor
    List<Post> searchPost(String keyword);
}
