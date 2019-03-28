package com.zjw.scaffold.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @program scaffold
 * @description: 分页小工具
 * @author: zhuangjiewei
 * @create: 2019/03/28 17:17
 */
public class PageUtils {

    public static <T> Page<T> buildFromRequest(HttpServletRequest request) {
        Objects.requireNonNull(request,"请检查request对象是否注入！");

        String pageSize = request.getParameter("pageSize");
        if(Objects.isNull(pageSize)) {
            pageSize = "20";
        }
        String current = request.getParameter("current");
        if(Objects.isNull(current)) {
            current = "1";
        }

        Assert.isTrue(StringUtils.isNumeric(pageSize),"分页参数：pageSize参数不是数字");
        Assert.isTrue(StringUtils.isNumeric(current),"分页参数：current参数不算数字");

        String sort = request.getParameter("sort");
        Page<T> page = new Page<>(Integer.valueOf(current), Integer.valueOf(pageSize));
        if (Objects.nonNull(sort)) {
            page.setAsc(sort);
        }
        return page;
    }



}
