package com.jo.post.post.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false) //???시스템에서 추가하라고함
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
=======
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Category category;
>>>>>>> f1979ddfe81133f1ece23984e6ddbce5c10a2ed9
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String postImg;
    private LocalDate created;
    private Long goalId;

    @Builder
    public Post(Long id, Category category, String title, String content, String postImg, LocalDate created, Long goalId) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.postImg = postImg;
        this.created = created;
        this.goalId = goalId;
    }
}
