package com.zjw.scaffold.templatemethod;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/01 13:40
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        Tea tea = new Tea();
        tea.setUserInput(false);
        tea.prepareRecipe();
    }
}
