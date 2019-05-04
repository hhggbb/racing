package com.gk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 比赛规则
 * @Author: 卖女孩的小火柴999
 * @Date: 2019-03-27 17:07
 */
@Getter
@Setter
@ToString
public class MatchRule {
    private Integer id;
    private String type;
    private String rule;
}
