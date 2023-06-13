package com.myapp.service;

import com.myapp.entities.Post;
import com.myapp.payload.PostDto;

import java.util.List;

public interface PostService {
    Post createPost(PostDto post);

    Post updatePost(PostDto post, Integer postId);
//delete post
    void deletePost(Integer postId);
//get post by Id
    Post getPostById(Integer postId);
//get all post
    List<Post> getAllPost();
//get all post by users
    List<Post> getPostByUser(Integer userId);
    //get all post by category
    List<Post> getPostByCategory(Integer categoryId);
    //search by keywor
    List<Post> getByKeyWord(String keyword);
}
