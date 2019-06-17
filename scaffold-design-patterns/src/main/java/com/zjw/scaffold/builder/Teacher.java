package com.zjw.scaffold.builder;

import java.time.LocalDateTime;

/**
 * @program scaffold
 * @description: 插件生成的类
 * @author: zhuangjiewei
 * @create: 2019/06/17 11:09
 */
public class Teacher {


    private Long id;

    private String name;

    private Integer age;

    private String phoneNumber;

    private LocalDateTime createTime;

    private Long createBy;

    private Teacher(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        phoneNumber = builder.phoneNumber;
        createTime = builder.createTime;
        createBy = builder.createBy;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Integer age;
        private String phoneNumber;
        private LocalDateTime createTime;
        private Long createBy;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        public Builder createTime(LocalDateTime val) {
            createTime = val;
            return this;
        }

        public Builder createBy(Long val) {
            createBy = val;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }
}
