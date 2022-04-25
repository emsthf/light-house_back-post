package com.jo.post.post.service;

import com.jo.post.post.model.DoingDto;
import com.jo.post.post.model.GoalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "goalClient", url = "http://springbootgoal-env.eba-wzmejvgd.us-east-1.elasticbeanstalk.com/")
public interface GoalClient {
    @GetMapping("/api/goal/{id}")
    GoalDto getGoalById(@PathVariable("id") Long id);

    @GetMapping("/api/doing/{goalId}/{week}")
    List<DoingDto> findAllByWeekAndGoalId(@PathVariable("week") int week, @PathVariable("goalId") Long id);
}
