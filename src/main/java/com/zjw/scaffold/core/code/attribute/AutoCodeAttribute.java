package com.zjw.scaffold.core.code.attribute;

import io.swagger.annotations.ApiParam;
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

    @ApiParam(value = "对应数据库中的id")
    private Long id;
    @ApiParam(value = "对应数据库中的code")
    private String code;
    @ApiParam(value = "对应数据库中的")
    private String strategy;
    @ApiParam(value = "数据库能够生成的最大数字")
    private int max;
    @ApiParam(value = "下一次更新缓存的最大数字")
    private int maxValue;
    @ApiParam(value = "步长")
    private int step;
    @ApiParam(value = "数字最大的长度")
    private Integer numLength;
    @ApiParam(value = "前缀")
    private String prefix;
    @ApiParam(value = "当前值")
    RedisAtomicInteger currentValue;

    public int getNextValue() {
        return this.currentValue.addAndGet(this.step);
    }

    public boolean isNeedUpdate() {
        return this.currentValue.get() + this.step > this.maxValue;
    }
}
