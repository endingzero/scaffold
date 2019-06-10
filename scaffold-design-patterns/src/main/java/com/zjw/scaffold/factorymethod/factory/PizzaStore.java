package com.zjw.scaffold.factorymethod.factory;



/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/10 13:31
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    //现在实例化比萨的责任移到一个方法，由子类实现
    protected abstract Pizza createPizza(String type);

}
