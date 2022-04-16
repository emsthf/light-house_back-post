package com.jo.post.post.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class GoalDto {
    private Long id;
    private LocalDate startDay;
    private LocalDate endDay;
    private int weekCount;
    private int period;
    private int state;
    private int count;
}
