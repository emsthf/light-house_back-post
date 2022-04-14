package com.jo.post.notification.model;

import com.jo.post.util.BaseTime;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false) //???시스템에서 추가하라고함
@Entity
public class Notification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String content;
    private String notifImg;
    private LocalDate created;

    @Builder
    public Notification(Long id, String title, String content, String notifImg, LocalDate created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.notifImg = notifImg;
        this.created = created;
    }
}
