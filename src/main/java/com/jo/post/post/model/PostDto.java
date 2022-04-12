package com.jo.post.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Long id;
    private Long categoryId;
    private String title;
    private String content;
    private String postImg;
    private LocalDate created;
    private Long goalId;
    private Long userId;

    public PostDto(Long id, Long categoryId, String title, String content, String postImg, LocalDate created, Long goalId, Long userId) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.postImg = postImg;
        this.created = created;
        this.goalId = goalId;
        this.userId = userId;
    }

    public PostDto(Long id, Long categoryId, String title, String content, String postImg, LocalDate created, Long goalId) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.postImg = postImg;
        this.created = created;
        this.goalId = goalId;
    }
}
