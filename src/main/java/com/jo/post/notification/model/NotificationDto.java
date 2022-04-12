package com.jo.post.notification.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NotificationDto {

    private Long id;
    private String title;
    private String content;
    private String notifImg;

    public NotificationDto(Long id, String title, String content, String notifImg) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.notifImg = notifImg;
    }
}
