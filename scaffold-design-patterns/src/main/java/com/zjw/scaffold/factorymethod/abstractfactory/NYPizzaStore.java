package com.zjw.scaffold.factorymethod.abstractfactory;

import com.zjw.scaffold.factorymethod.factory.NYStyleCheesePizza;
import com.zjw.scaffold.factorymethod.abstractfactory.Pizza;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/10 14:16
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {

        Pizza pizza = null;
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        pizza = new CheesePizza(factory);
        return pizza;
    }
}
