package com.jo.post.notification.service;

import com.jo.post.notification.model.Notification;
import com.jo.post.notification.model.NotificationDto;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    void saveNotice(NotificationDto noticeDto);
    List<Notification> findAllNotice();
    Optional<Notification> findById(Long id);
    void editNotice(Long id, NotificationDto noticeDto);
    void delNotice(Long id);
}

