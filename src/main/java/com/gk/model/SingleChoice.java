package com.gk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 单选
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-13 18:04
 */
@Getter
@Setter
@ToString
public class SingleChoice extends Parent{
    //选项
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
