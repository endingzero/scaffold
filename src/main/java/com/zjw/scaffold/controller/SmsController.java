package com.zjw.scaffold.controller;

import com.zjw.scaffold.core.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program scaffold
 * @description: 短信通知
 * @author: zhuangjiewei
 * @create: 2019/03/29 16:27
 */

@RestController
@RequestMapping("/sms")
@Api(value = "/sms",tags = "短信")
public class SmsController extends BaseController {


}
