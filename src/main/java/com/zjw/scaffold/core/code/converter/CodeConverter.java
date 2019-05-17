package com.zjw.scaffold.core.code.converter;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import com.zjw.scaffold.core.code.entity.AutoCode;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;

import java.util.Objects;
import java.util.function.Function;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/16 10:07
 */
public class CodeConverter implements Function<AutoCode,AutoCodeAttribute> {

    private StringRedisTemplate redisTemplate;

    public CodeConverter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public AutoCodeAttribute apply(AutoCode autoCode) {
        AutoCodeAttribute autoCodeAttribute = new AutoCodeAttribute();
        autoCodeAttribute.setCode(autoCode.getCode());
        autoCodeAttribute.setId(autoCode.getId());
        autoCodeAttribute.setStrategy(autoCode.getStrategy());
        autoCodeAttribute.setStep(autoCode.getStep());
        autoCodeAttribute.setPrefix(autoCode.getPrefix());
        autoCodeAttribute.setNumLength(autoCode.getNumLength());
        autoCodeAttribute.setMax(this.calculateMax(autoCode));
        autoCodeAttribute.setCurrentValue(this.calculateCurrentValue(autoCode));
        autoCodeAttribute.setMaxValue(this.calculateMaxValue(autoCode));
        return autoCodeAttribute;
    }

    private RedisAtomicInteger calculateCurrentValue(AutoCode autoCode) {
        String key = "AtomicInteger." + autoCode.getCode();
        RedisAtomicInteger redisAtomicInteger;
        if (redisTemplate.hasKey(key)) {
            redisAtomicInteger = new RedisAtomicInteger(key, redisTemplate.getConnectionFactory());
        } else {
            redisAtomicInteger = new RedisAtomicInteger(key, redisTemplate.getConnectionFactory());
            redisAtomicInteger.set(this.calculateMaxValue(autoCode));
        }
        return redisAtomicInteger;
    }

    private int calculateMaxValue(AutoCode autoCode) {
        return this.calculateCurrentValue(autoCode).get()+ autoCode.getCacheFrequency() * autoCode.getStep();
    }

    private Integer calculateMax(AutoCode autoCode) {
        Integer numLength = autoCode.getNumLength();
        int max = 0;
        if(Objects.nonNull(numLength)) {
            max = (int)Math.pow(10.0D, (double)numLength) - 1;
        }
        return max;

    }
}
