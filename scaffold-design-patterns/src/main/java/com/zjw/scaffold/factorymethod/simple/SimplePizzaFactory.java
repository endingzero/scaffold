package com.zjw.scaffold.factorymethod.simple;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/10 10:16
 */
public class SimplePizzaFactory {

    public static Pizza createPizza(String type){
        Pizza pizza = null;

        if("cheese".equals(type)) {
            pizza = new CheesePizza();
        }else if ("clam".equals(type)){
            pizza = new ClamPizza();
        }else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
