package com.zjw.scaffold.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.attribute.AutoCodeAttribute;
import com.zjw.scaffold.cache.AutoCodeCache;
import com.zjw.scaffold.converter.CodeConverter;
import com.zjw.scaffold.entity.AutoCode;
import com.zjw.scaffold.mapper.AutoCodeMapper;
import com.zjw.scaffold.service.AutoCodeService;
import com.zjw.scaffold.strategy.AutoCodeContext;
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
        //内存中是否存在,是否第一次假如缓存,是否需要更新
        //第一次执行的获取,之后就根据更新频率进行更新
        if(Objects.isNull(autoCodeAttribute) || !this.redisTemplate.hasKey(key) || autoCodeAttribute.isNeedUpdate()){
            autoCodeAttribute = this.fetchCode(code);
        }

        return AutoCodeContext.get(autoCodeAttribute.getStrategy()).getNextCode(autoCodeAttribute);
    }

    /**
     * 获取code
     * 1、查找数据库获取实体
     * 2、将实体对象转换成缓存对象,将缓存对象存储到redis
     * 3、将缓存对象设置到本地缓存
     * 4、将实体更新到数据库
     * @param code
     * @return
     */
    private AutoCodeAttribute fetchCode(String code) {
        //查询数据库
        AutoCode autoCode = this.getByCode(code);
        //转换成AutoCodeAttribute,将缓存存储过到redis中
        CodeConverter codeConverter = new CodeConverter(redisTemplate);
        AutoCodeAttribute autoCodeAttribute = codeConverter.apply(autoCode);
        if(autoCodeAttribute.isLoop()) {
            //循环
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
