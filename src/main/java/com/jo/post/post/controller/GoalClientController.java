package com.jo.post.post.controller;

import com.jo.post.post.model.GoalDto;
import com.jo.post.post.service.GoalClient;
import com.jo.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoalClientController {
    private final GoalClient goalClient;

    @PostMapping("/feign")
    public GoalDto findGoalInPost() {
        System.out.println("### feign client 시작 ###");
        GoalDto goal =goalClient.getGoalById(1L); // 외부 API 호출
        System.out.println("Feign을 이용한 호출 결과 : " + goal.toString());
        return goal;
    }

//    @GetMapping("/posts/{id}")
//    public GoalDto getGoalId(@PathVariable("id") long id) {
//        System.out.println("### getPostId가 시작됨 ###");
//        GoalDto goal = new GoalDto();
//        goal.setStartDay("내용");
//        post.setId(3L);
//        post.setCategoryId(1L);
//        post.setTitle("제목");
//        return post;
//    }
}
