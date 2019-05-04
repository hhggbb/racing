package com.gk.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 父类，所有必答题题型都继承此类
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-13 18:06
 */
@Getter
@Setter
public class Parent {
    private Integer id;
    //题目
    private String title;
    //结果
    private String result;
    //类型
    private String type;
    //分数
    private Integer score;
    //答题时间
    private Integer time;

}
