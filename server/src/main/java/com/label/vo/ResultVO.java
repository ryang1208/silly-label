package com.label.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    /**
     * code 和 http 状态码保持一致
     */
    private Integer code;

    private T msg;

}
