package com.zjw.scaffold.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program scaffold
 * @description: 返回结果封装
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:53
 */
@Getter
@Setter
@ToString
public class Result<T> {

    private Boolean success;
    private String msg;
    private Integer code;
    private T data;

    private Result(Boolean success, String msg, Integer code, T data) {
        this.success = success;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static <T> Result<T> buildSuccess(T data) {

        return new Result<>(Boolean.TRUE, "成功", 0, data);
    }

    public static <T> Result<T> build(Boolean success, String msg, T data) {
        return new Result(success, msg, 0, data);
    }

    public static <T> Result buildFaild(T data) {

        return new Result<>(Boolean.TRUE, "失败", -1, data);
    }
}
