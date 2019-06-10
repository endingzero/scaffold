package com.zjw.scaffold.factorymethod.factory;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/10 14:16
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {

        Pizza pizza = new NYStyleCheesePizza();
        return pizza;
    }
}
