package com.myapp.service.impl;

import com.myapp.entities.Category;
import com.myapp.entities.Post;
import com.myapp.entities.User;
import com.myapp.exceptions.ResourceNotFoundException;
import com.myapp.payload.PostDto;
import com.myapp.payload.PostResponse;
import com.myapp.repositories.CategoryRepo;
import com.myapp.repositories.PostRepo;
import com.myapp.repositories.UserRepo;
import com.myapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId ) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserID", userId));
        Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId", categoryId));
        Post post=this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post createdPost=postRepo.save(post);
        return this.modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
       // Post post=this.postRepo.findById(postId);
        Post post= this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId", postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
        PostDto postDto=this.modelMapper.map(post, PostDto.class);
        return postDto;
    }

    @Override
    public PostResponse getAllPost(Integer pageSize, Integer pageNumber) {

        Pageable pageble= PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost=this.postRepo.findAll(pageble);
        List<Post> allPost=pagePost.getContent();
         List<PostDto> postDtos=allPost.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }





    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId", userId));
        List<Post> posts=postRepo.findByUser(user);
        return posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Cat", "CatId",categoryId));
        List<Post> posts=this.postRepo.findByCategory(cat);
        return posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<Post> searchPost(String keyword) {

        return null;
    }
}
