package com.jo.post.post.model;

import com.jo.post.category.model.CategoryEntity;
import com.jo.post.util.BaseTime;
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
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String postImg;
    private LocalDate created;
    private Long goalId;


    @Builder
    public Post(Long id, CategoryEntity category, String title, String content, String postImg, LocalDate created, Long goalId) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.postImg = postImg;
        this.created = created;
        this.goalId = goalId;
    }
}
