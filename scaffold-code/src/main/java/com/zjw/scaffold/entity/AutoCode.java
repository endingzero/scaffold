package com.zjw.scaffold.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @program scaffold
 * @description: code类
 * @author: zhuangjiewei
 * @create: 2019/05/13 15:39
 */
@TableName("t_auto_code")
@Data
public class AutoCode implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @NotNull(message = "规则编号不能为空")
    @TableField(value = "code")
    private String code;
    @TableField(value = "init_value")
    private Integer initValue;
    @TableField(value = "current_value")
    private Integer currentValue;
    @TableField(value = "num_length")
    private Integer numLength;
    @TableField(value = "prefix")
    private String prefix;
    @TableField(value = "cache_frequency")
    private Integer cacheFrequency;
    @TableField(value = "step")
    private Integer step;
    @TableField(value = "strategy")
    private String strategy;
}
