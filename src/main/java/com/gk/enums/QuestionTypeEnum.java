package com.gk.enums;

import lombok.Getter;

/**
 * 题目类型枚举
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-25 14:45
 */
@Getter
public enum QuestionTypeEnum {
    JUDGE(1,"判断题"),
    SINGLE_CHOICE(2,"单选题"),
    MULTIPLE_CHOICE(3,"多选题"),
    SHORT_ANSWER(4,"简答题"),
    QUICKLY_ANSWER(5,"抢答题"),
    RISK_QUESTION(6,"风险题"),
    RED_SONG(7,"红歌竞猜"),
    ;

    private Integer status;
    private String type;

    QuestionTypeEnum(Integer status, String type) {
        this.status = status;
        this.type = type;
    }
}
