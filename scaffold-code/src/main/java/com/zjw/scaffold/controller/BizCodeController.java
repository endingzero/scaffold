package com.zjw.scaffold.controller;

import com.zjw.scaffold.result.Result;
import com.zjw.scaffold.service.BizCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/03/28 15:50
 */
@RestController
@RequestMapping("/biz/code")
@Api(value = "/biz/code",tags = "code")
public class BizCodeController extends BaseController {

    @Autowired
    private BizCodeService bizCodeService;

    @GetMapping(value = "/get")
    @ApiOperation("新增用户")
    public Result<Void> get() {
        bizCodeService.getUserCode();
        return this.success();
    }

}
