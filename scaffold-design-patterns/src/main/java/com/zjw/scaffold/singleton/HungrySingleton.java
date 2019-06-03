package com.zjw.scaffold.singleton;

/**
 * @program scaffold
 * @description: HungrySingleton
 * @author: zhuangjiewei
 * @create: 2019/06/03 14:46
 */
public class HungrySingleton {

    //在类加载的时候加载倒内存
    public static HungrySingleton hungrySingleton = new HungrySingleton();

    //将构造函数私有化
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
