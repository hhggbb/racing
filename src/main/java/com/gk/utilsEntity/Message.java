package com.gk.utilsEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yws on 4/20/17.
 */
@Getter
@Setter
public class Message {
    //状态
    private int status;
    //消息
    private String msg;
    //状态
    private Object data;

    public Message() {}

    public Message(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Message(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}
