package com.zjw.scaffold.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @program scaffold
 * @description: 用户实体类
 * @author: zhuangjiewei
 * @create: 2019/03/28 15:53
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("code")
    private String code;

    @NotNull(message = "用户名不能为空")
    @Length(max = 20,message = "用户名长度必须在{max}个字符内")
    @TableField("username")
    private String username;

    @NotNull(message = "姓名不能为空")
    @Length(max = 40,message = "姓名长度必须为{max}个字符内")
    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("status")
    private String status;

    @TableField("sex")
    private String sex;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("create_by")
    private Long createBy;

    @TableField("update_by")
    private Long updateBy;

    @TableField("avatar")
    private String avatar;

}
