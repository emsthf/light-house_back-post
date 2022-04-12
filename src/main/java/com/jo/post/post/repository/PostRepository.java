package com.jo.post.post.repository;

import com.jo.post.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByGoalIdAndCreated(Long goalId, LocalDate created);
    List<Post> findAllByGoalId(Long goalId);
    List<Post> findAllByGoalIdAndUserId(Long goalId, Long userId);
}
