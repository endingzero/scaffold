package com.zjw.scaffold.builder;

import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @program scaffold
 * @description: 建造者模式
 * @author: zhuangjiewei
 * @create: 2019/06/17 10:03
 */
@ToString
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String phoneNumber;

    private LocalDateTime createTime;

    private Long createBy;

    //将构造器私有化
    private User(){

    }

    private User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.createTime = builder.createTime;
        this.createBy = builder.createBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder{

        private Long id;

        private String name;

        private Integer age;

        private String phoneNumber;

        private LocalDateTime createTime;

        private Long createBy;

        public Builder() {
            this.name = "";
            this.age = 1;
            this.phoneNumber = "";
            this.createTime = LocalDateTime.now();
            this.createBy = -1L;
        }
        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
