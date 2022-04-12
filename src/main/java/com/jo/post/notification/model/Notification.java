package com.jo.post.notification.model;

import com.jo.post.util.BaseTime;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false) //???시스템에서 추가하라고함
@Entity
public class Notification extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String content;
    private String notifImg;

    @Builder
    public Notification(Long id, String title, String content, String notifImg) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.notifImg = notifImg;
    }
}
