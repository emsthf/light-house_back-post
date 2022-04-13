package com.jo.post.post.repository;

import com.jo.post.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByGoalIdAndCreated(Long goalId, LocalDate created);
    List<Post> findAllByGoalId(Long goalId);
    List<Post> findAllByGoalIdAndUserId(Long goalId, Long userId);

    @Modifying
    @Query("update Post p set p.view = p.view + 1 where p.id = :id")
    int updateView(@Param("id") Long id);

}
