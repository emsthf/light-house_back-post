package com.jo.post.notification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
public class NotificationDto {

    private Long id;
    private String title;
    private String content;
    private String notifImg;
    private LocalDate created;

    public NotificationDto(Long id, String title, String content, String notifImg, LocalDate created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.notifImg = notifImg;
        this.created = created;
    }
}
