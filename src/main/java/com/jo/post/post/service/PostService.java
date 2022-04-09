package com.jo.post.post.service;

import com.jo.post.post.model.Post;
import com.jo.post.post.model.PostDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PostService {

    Long savePost(PostDto postDto);
    List<Post> findAllPost();
    Optional<Post> findById(Long id);
    void editPost(Long id, PostDto postDto);
    void delPost(Long id);
    List<Post> findAllByGoalId(Long goalId);
    Optional<Post> findByGoalIdAndCreated(Long goalId, LocalDate created);
}
