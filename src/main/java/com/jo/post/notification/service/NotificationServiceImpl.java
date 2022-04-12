package com.jo.post.notification.service;

import com.jo.post.notification.model.Notification;
import com.jo.post.notification.model.NotificationDto;
import com.jo.post.notification.reppository.NotificationRepository;
import com.jo.post.post.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository noticeRepository;

    @Transactional
    @Override
    public void saveNotice(NotificationDto noticeDto) {
        log.info("add Notification");
        noticeRepository.save(Notification.builder()
                .id(null)
                .title(noticeDto.getTitle())
                .content(noticeDto.getContent())
                .notifImg(noticeDto.getNotifImg())
                .build());
    }


    @Transactional
    @Override
    public List<Notification> findAllNotice() {
        log.info("findAll Notification");
        return noticeRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Notification> findById(Long id) {
        log.info("find by Notification id : {}", id);
        return Optional.ofNullable(noticeRepository.findById(id).get());
    }

    @Transactional
    @Override
    public void editNotice(Long id, NotificationDto noticeDto) {
        log.info("edit post {}.", noticeRepository.findById(noticeDto.getId()));
        if(noticeRepository.findById(id).isPresent()){ //id 값이 있는지 확인부터 해보기
            Notification notification = Notification.builder()
                    .id(noticeDto.getId())
                    .title(noticeDto.getTitle())
                    .content(noticeDto.getContent())
                    .notifImg(noticeDto.getNotifImg())
                    .build();
            noticeRepository.save(notification);
        }else {
            log.error("edit notification error.");
        }
    }

    @Transactional
    @Override
    public void delNotice(Long id) {
        if (noticeRepository.findById(id).isPresent()){
            log.info("delete notification by id : {}", id);
            noticeRepository.deleteById(id);
        }else {
            log.error("delete notification error.");
        }
    }
}
