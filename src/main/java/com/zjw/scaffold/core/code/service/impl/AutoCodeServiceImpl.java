package com.zjw.scaffold.core.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import com.zjw.scaffold.core.code.cache.AutoCodeCache;
import com.zjw.scaffold.core.code.entity.AutoCode;
import com.zjw.scaffold.core.code.mapper.AutoCodeMapper;
import com.zjw.scaffold.core.code.service.AutoCodeService;
import com.zjw.scaffold.core.code.strategy.AutoCodeContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/15 13:13
 */
@Service
public class AutoCodeServiceImpl extends ServiceImpl<AutoCodeMapper, AutoCode> implements AutoCodeService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String getNextCode(String code) {
        AutoCodeAttribute autoCodeAttribute = AutoCodeCache.get(code);
        String key = "AutoCode." + code;
        //缓存不存在的情况
        if(Objects.isNull(autoCodeAttribute) || !this.redisTemplate.hasKey(key)){
            autoCodeAttribute = this.fetchCode(code);
        }
        //缓存需要更新
        if(autoCodeAttribute.isNeedUpdate()) {
            autoCodeAttribute = this.updateCode(code);
        }
        //缓存获取
        //AutoCode autoCode = this.getByCode(code);
        //AutoCodeAttribute autoCodeAttribute = new AutoCodeAttribute();
        //BeanUtils.copyProperties(autoCode,autoCodeAttribute);
        return AutoCodeContext.get(code).getNextCode(autoCodeAttribute);
    }

    private AutoCodeAttribute updateCode(String code) {
        return null;
    }

    private AutoCodeAttribute fetchCode(String code) {
        return null;
    }

    private AutoCode getByCode(String code) {
        QueryWrapper<AutoCode> queryWrapper = new QueryWrapper<>();
        AutoCode autoCode = new AutoCode();
        autoCode.setCode(code);
        queryWrapper.setEntity(autoCode);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
