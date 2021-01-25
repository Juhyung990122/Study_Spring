package com.example.spring_practive.controller;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_practive.entity.Post;
import com.example.spring_practive.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//요즘은 @RestController로 위의 Responsebody를 대체한다. Responsebody는 자동으로 활성화
@RestController
public class TestRestController{

    @RequestMapping(value="/returndata",method = RequestMethod.GET)
    public String restTestValue(){
        String restdata = "Happy Birthday Guinness";
        return restdata;
    }

    @Autowired
    PostRepository postRepository;

    @GetMapping("/post")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable String id){
        Long postID = Long.parseLong(id);
        Optional<Post> post = postRepository.findById(postID);
        return post.get();
    }

    @PostMapping("/post/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost){
        Long postID = Long.parseLong(id);
        Optional<Post> post = postRepository.findById(postID);
        post.get().setTitle(newPost.getTitle());
        post.get().setContent(newPost.getContent());
        postRepository.save(post.get());
        return post.get();
    }
    @PutMapping("/post")
    public Post createPost(@RequestBody Post post){
        Post newPost = postRepository.save(post);
        return newPost;
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id){
        Long postID = Long.parseLong(id);
        postRepository.deleteById(postID);

        return "Delete success!";
    }
}

//컨트롤러 두개로 추가하니까 최종결과는 얘가나온다

