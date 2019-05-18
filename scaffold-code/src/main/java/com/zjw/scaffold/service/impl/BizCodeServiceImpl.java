package com.zjw.scaffold.service.impl;

import com.zjw.scaffold.service.AutoCodeService;
import com.zjw.scaffold.enums.BizCodeType;
import com.zjw.scaffold.service.BizCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/16 14:54
 */
@Service
public class BizCodeServiceImpl implements BizCodeService {

    @Autowired
    private AutoCodeService autoCodeService;
    @Override
    public String getUserCode() {
        return autoCodeService.getNextCode(BizCodeType.USER.name());
    }
}
