package com.jo.post.notification.controller;

import com.jo.post.notification.model.Notification;
import com.jo.post.notification.model.NotificationDto;
import com.jo.post.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class NotificationController {

    private final NotificationService noticeService;

    @PostMapping("/notification")
    public void saveNotice(@RequestBody NotificationDto noticeDto) {
        noticeService.saveNotice(noticeDto);
    }

    @GetMapping("/notification/{id}")
    public Notification findById(@PathVariable Long id) {
        return noticeService.findById(id).get();
    }

    @GetMapping("/notification")
    public List<Notification> findAllNotice() {
        return noticeService.findAllNotice();
    }

    @PutMapping("/notification/{id}")
    public void editNotice(@PathVariable Long id, @RequestBody NotificationDto noticeDto) {
        noticeService.editNotice(id, noticeDto);
    }

    @DeleteMapping("/notification/{id}")
    public void delNotice(@PathVariable Long id) {
        noticeService.delNotice(id);
    }

}
