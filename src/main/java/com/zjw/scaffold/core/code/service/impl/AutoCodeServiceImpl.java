package com.zjw.scaffold.core.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import com.zjw.scaffold.core.code.entity.AutoCode;
import com.zjw.scaffold.core.code.mapper.AutoCodeMapper;
import com.zjw.scaffold.core.code.service.AutoCodeService;
import com.zjw.scaffold.core.code.strategy.AutoCodeContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/15 13:13
 */
@Service
public class AutoCodeServiceImpl extends ServiceImpl<AutoCodeMapper, AutoCode> implements AutoCodeService {

    @Override
    public String getNextCode(String code) {

        AutoCode autoCode = this.getByCode(code);
        AutoCodeAttribute autoCodeAttribute = new AutoCodeAttribute();
        BeanUtils.copyProperties(autoCode,autoCodeAttribute);
        return AutoCodeContext.get(code).getNextCode(autoCodeAttribute);
    }

    private AutoCode getByCode(String code) {
        QueryWrapper<AutoCode> queryWrapper = new QueryWrapper<>();
        AutoCode autoCode = new AutoCode();
        autoCode.setCode(code);
        queryWrapper.setEntity(autoCode);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
