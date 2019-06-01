package com.zjw.scaffold.templatemethod;

/**
 * @program scaffold
 * @description: 茶
 * @author: zhuangjiewei
 * @create: 2019/06/01 13:37
 */

public class Tea extends CaffeineBeverage {

    private Boolean userInput;
    @Override
    void brew() {
        System.out.println("冲泡茶叶");
    }

    @Override
    void addCondiments() {
        System.out.println("添加蜂蜜");
    }

    boolean customerWantsCondiments(){
        return getUserInput();
    }

    public void setUserInput(Boolean userInput) {
        this.userInput = userInput;
    }

    public Boolean getUserInput() {
        return userInput;
    }
}
