package com.gk.enums;

import lombok.Getter;

/**
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-25 14:39
 */
@Getter
public enum RightOrWrongEnum {
    RIGHT(1,"right"),
    WRONG(2,"wrong");

    private Integer status;
    private String result;

    RightOrWrongEnum(Integer status, String result) {
        this.status = status;
        this.result = result;
    }
}
