package com.gk.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-21 16:09
 */
@Getter
@Setter
public class TeamParent {
    //主键自增
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private Integer score;
}
