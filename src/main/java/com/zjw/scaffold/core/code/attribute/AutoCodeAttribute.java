package com.zjw.scaffold.core.code.attribute;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/14 14:41
 */
@Getter
@Setter
@ToString
public class AutoCodeAttribute {

    private Long id;
    private String name;
    private Integer max;
    private int maxValue;
    private int step;
    private Integer numLength;
    private String prefix;
    private String type;
    RedisAtomicInteger currentValue;

    public int getNextValue() {
        return this.currentValue.addAndGet(this.step);
    }
}
