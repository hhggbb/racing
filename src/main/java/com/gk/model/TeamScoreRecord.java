package com.gk.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 参赛者必答题分数记录表
 * @Author: 卖女孩的小火柴999
 * @Date: 2019-03-28 17:09
 */
@Getter
@Setter
public class TeamScoreRecord extends TeamParent{
    //题目id
    private Integer titleId;
    //题目类型
    private String type;
}
