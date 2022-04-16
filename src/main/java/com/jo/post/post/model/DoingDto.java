package com.jo.post.post.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DoingDto {
    private Long id;
    private Long goalId;
    private LocalDate checkDate;
    private int week;
    private Long postId;
}
