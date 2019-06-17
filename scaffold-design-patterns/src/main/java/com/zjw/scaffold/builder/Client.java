package com.zjw.scaffold.builder;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/17 10:17
 */
public class Client {

    public static void main(String[] args) {
        User user = User.newBuilder()
                .setId(1L)
                .setName("xiaoming")
                .setPhoneNumber("137518181881")
                .build();
        System.out.println(user.toString());
    }
}
