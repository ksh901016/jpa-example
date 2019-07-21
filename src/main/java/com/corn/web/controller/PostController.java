package com.corn.web.controller;

import com.corn.web.post.Post;
import com.corn.web.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;
    /*
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id){
        Optional<Post> byId = postRepository.findById(id);
        Post post = byId.get();
        return post;
    }*/

    // DomainClassConverter
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable("id") Post post){
        return post;
    }

    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

}
