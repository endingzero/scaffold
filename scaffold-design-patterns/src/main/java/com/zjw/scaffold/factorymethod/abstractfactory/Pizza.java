package com.zjw.scaffold.factorymethod.abstractfactory;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/12 10:55
 */
public abstract class Pizza {

    String name;

    Dough dough;

    Cheese cheese;

    Sauce sauce;

    abstract void prepare();
}
