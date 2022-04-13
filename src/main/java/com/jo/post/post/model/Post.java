package com.jo.post.post.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false) //???시스템에서 추가하라고함
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @Column(nullable = false)
    private String postImg;

    @Column(nullable = false)
    private LocalDate created;

    @Column(nullable = false)
    private Long goalId;

    @Column(nullable = false)
    private Long userId;

    @Builder
    public Post(Long id, Category category, String title, String content, int view, String postImg, LocalDate created, Long goalId, Long userId) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.view = view;
        this.postImg = postImg;
        this.created = created;
        this.goalId = goalId;
        this.userId = userId;
    }
}
