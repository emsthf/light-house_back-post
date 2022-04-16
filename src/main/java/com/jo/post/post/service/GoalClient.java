package com.jo.post.post.service;

import com.jo.post.post.model.GoalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goalClient", url = "http://localhost:8080")
public interface GoalClient {
    @GetMapping("/api/goal/{id}")
    GoalDto getGoalById(@PathVariable("id") Long id);

//    @GetMapping("/api/doing/{id}")
//    DoingDto

}
