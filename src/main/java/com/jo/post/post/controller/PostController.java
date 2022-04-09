package com.jo.post.post.controller;

import com.jo.post.post.model.Post;
import com.jo.post.post.model.PostDto;
import com.jo.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public Long savePost(@RequestBody PostDto postDto) {
        return postService.savePost(postDto);
    }

    @PutMapping("/post/{id}")
    public void editPost(@PathVariable Long id, @RequestBody PostDto postDto) {
        postService.editPost(id, postDto);
    }

    @GetMapping("/post")
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

    @GetMapping("/post/{id}")
    public Post findById(@PathVariable Long id) {
        return postService.findById(id).get();
    }

    @DeleteMapping("/post/{id}")
    public void delPost(@PathVariable Long id) {
        postService.delPost(id);
    }

    @GetMapping("/post/auth/{goalId}")
    public List<Post> findAllByGoalId(@PathVariable Long goalId) {
        return postService.findAllByGoalId(goalId);
    }

    @GetMapping("/post/auth/find")
    public Post findByGoalIdAndCreated(@RequestParam(value = "goalId") Long goalId, @RequestParam(value = "created") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate created) {
        return postService.findByGoalIdAndCreated(goalId, created).get();
    }

}
