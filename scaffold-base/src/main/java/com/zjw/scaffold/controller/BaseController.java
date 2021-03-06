package com.zjw.scaffold.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjw.scaffold.result.Result;
import com.zjw.scaffold.util.PageUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @program scaffold
 * @description: 基础controller
 * @author: zhuangjiewei
 * @create: 2019/03/28 17:08
 */
public class BaseController {

    /**
     * 构建成功结果带信息
     * @param data
     * @return
     */
    public <T> Result<T> success(T data){
        return Result.buildSuccess(data);
    }

    public Result<Void> success() {
        return this.success(null, null);
    }

    public <T> Result<T> success(String msg, T data) {
        return Result.build(Boolean.TRUE, msg, data);
    }
    /**
     * 获取分页参数
     * @param <T>
     * @return
     */
    public <T> Page<T> getPage() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return PageUtils.buildFromRequest(request);
    }
}
