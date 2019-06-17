package com.zjw.scaffold.factorymethod.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program scaffold
 * @description: \
 * @author: zhuangjiewei
 * @create: 2019/06/10 14:18
 */
public class Client {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
        Map<String,String> map =  new HashMap<>();

    }
}
