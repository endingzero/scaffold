package com.zjw.scaffold.singleton;

/**
 * @program scaffold
 * @description: 懒汉式单例
 * @author: zhuangjiewei
 * @create: 2019/06/03 15:42
 */
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        //需要的时候再创建
        if(lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
