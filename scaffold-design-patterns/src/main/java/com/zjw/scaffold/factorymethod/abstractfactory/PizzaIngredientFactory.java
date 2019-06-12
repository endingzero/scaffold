package com.zjw.scaffold.factorymethod.abstractfactory;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/12 10:43
 */
public interface PizzaIngredientFactory {
    //面团
    Dough createDough();
    //酱料
    Sauce createSauce();
    //芝士
    Cheese createCheese();
}
