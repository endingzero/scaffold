package com.zjw.scaffold.templatemethod;

/**
 * @program scaffold
 * @description: 咖啡
 * @author: zhuangjiewei
 * @create: 2019/06/01 13:38
 */
public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("冲泡咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("增加糖和牛奶");
    }
}
