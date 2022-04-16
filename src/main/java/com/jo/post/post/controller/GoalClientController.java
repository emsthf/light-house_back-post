package com.jo.post.post.controller;

import com.jo.post.post.model.DoingDto;
import com.jo.post.post.model.GoalDto;
import com.jo.post.post.model.PostDto;
import com.jo.post.post.service.GoalClient;
import com.jo.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GoalClientController {
    private final GoalClient goalClient;
    private final PostService postService;

    @PostMapping("/feign/{goalId}")
    public String findGoalInPost(@PathVariable("goalId") Long goalId, @RequestBody PostDto postDto) {
        System.out.println("### feign client : Goal 시작 ###");
        GoalDto goal = goalClient.getGoalById(goalId); // 외부 API 호출
        System.out.println("Feign을 이용한 goal 호출 결과 : " + goal.toString());

        // 불러온 Goal의 startDay를 이용해서 몇 주차인지 판단
        int now = LocalDate.now().getDayOfYear();
        int start = goal.getStartDay().getDayOfYear();
        int weekInProgress = 1;
        for(int i = 1; i <= now - start; i++) {
            if(i % 7 == 0) {
                weekInProgress++;
            }
        }
        log.info("this week : {}", weekInProgress);

        System.out.println("### feign client : Doing 시작 ###");
        List<DoingDto> doings = goalClient.findAllByWeekAndGoalId(weekInProgress, goalId);
        System.out.println("Feign을 이용한 doing 호출 결과 : " + doings.toString());
        if(doings.size() < goal.getWeekCount()) {
            postService.savePost(postDto);
            log.info("한 주의 doing 갯수가 weekcount 이하 일 때, 포스트 등록");
            return "save success!!";
        } else {
            return "save fail...";
        }
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
