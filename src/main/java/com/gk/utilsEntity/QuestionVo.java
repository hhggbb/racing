package com.gk.utilsEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: 卖女孩的小火柴999
 * @Date: 2019-03-27 15:21
 */
@Getter
@Setter
@ToString
public class QuestionVo {
    private Integer id;
    private String type;
    private String title;
    //选项
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String result;
    private Integer score;
    private Integer time;
}
