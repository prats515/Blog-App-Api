package com.myapp.service.impl;

import com.myapp.entities.Post;
import com.myapp.payload.PostDto;
import com.myapp.repositories.PostRepo;
import com.myapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Post createPost(PostDto postDto) {
        Post post=this.modelMapper.map(postDto, Post.class);
        System.out.println("pratiknewcat"+post.getCategory());
        Post createdPost=postRepo.save(post);
        return createdPost;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
       // Post post=this.postRepo.findById(postId);
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getByKeyWord(String keyword) {
        return null;
    }
}
