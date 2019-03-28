package com.zjw.scaffold.controller;

import com.zjw.scaffold.core.controller.BaseController;
import com.zjw.scaffold.core.result.Result;
import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.service.UserService;
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
@RequestMapping("/user")
@Api(value = "/user",tags = "用户")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/add")
    @ApiOperation("新增用户")
    public Result insert() {
        User user = new User();
        user.setName("hah");
        return this.success(userService.insert(user));
    }
}
