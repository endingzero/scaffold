package com.zjw.scaffold.core.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import com.zjw.scaffold.core.code.cache.AutoCodeCache;
import com.zjw.scaffold.core.code.converter.CodeConverter;
import com.zjw.scaffold.core.code.entity.AutoCode;
import com.zjw.scaffold.core.code.mapper.AutoCodeMapper;
import com.zjw.scaffold.core.code.service.AutoCodeService;
import com.zjw.scaffold.core.code.strategy.AutoCodeContext;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AutoCodeServiceImpl extends ServiceImpl<AutoCodeMapper, AutoCode> implements AutoCodeService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String getNextCode(String code) {
        AutoCodeAttribute autoCodeAttribute = AutoCodeCache.get(code);
        String key = "AtomicInteger." + code;
        //获取
        if(Objects.isNull(autoCodeAttribute) || !this.redisTemplate.hasKey(key) || autoCodeAttribute.isNeedUpdate()){
            if(Objects.nonNull(autoCodeAttribute)) {
                log.info(String.valueOf(autoCodeAttribute.isNeedUpdate()));
            }
            autoCodeAttribute = this.fetchCode(code);
        }

        return AutoCodeContext.get(autoCodeAttribute.getStrategy()).getNextCode(autoCodeAttribute);
    }

    private AutoCodeAttribute fetchCode(String code) {
        //查询数据库
        AutoCode autoCode = this.getByCode(code);
        //转换成AutoCodeAttribute,将缓存存储过到redis中
        CodeConverter codeConverter = new CodeConverter(redisTemplate);
        AutoCodeAttribute autoCodeAttribute = codeConverter.apply(autoCode);
        if(autoCodeAttribute.isLoop()) {
            autoCode.setCurrentValue(autoCode.getInitValue());
            autoCodeAttribute.getCurrentValue().set(autoCode.getInitValue());
            autoCodeAttribute.setMaxValue(autoCodeAttribute.getCurrentValue().get()+ autoCode.getCacheFrequency() * autoCode.getStep());
        }
        //将autoCode存储到缓存中
        AutoCodeCache.put(autoCodeAttribute);
        autoCode.setCurrentValue(autoCodeAttribute.getCurrentValue().get());
        this.baseMapper.updateById(autoCode);
        return autoCodeAttribute;
    }

    private AutoCode getByCode(String code) {
        QueryWrapper<AutoCode> queryWrapper = new QueryWrapper<>();
        AutoCode autoCode = new AutoCode();
        autoCode.setCode(code);
        queryWrapper.setEntity(autoCode);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
