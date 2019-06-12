package com.zjw.scaffold.factorymethod.abstractfactory;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/12 10:57
 */
public class CheesePizza extends Pizza{

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzanIngredientFactory){
        this.pizzaIngredientFactory = pizzanIngredientFactory;
    }

    @Override
    void prepare() {
        //每当需要原料就跟工厂要
        pizzaIngredientFactory.createDough();
        pizzaIngredientFactory.createSauce();
        pizzaIngredientFactory.createCheese();

    }
}
