package com.zjw.scaffold.singleton;

/**
 * @program scaffold
 * @description: 双重检查加锁单例
 * @author: zhuangjiewei
 * @create: 2019/06/03 15:50
 */
public class DoubleCheckLockSingleton {

    //被实例化的时候，多个线程正确的处理此变量
    private volatile static DoubleCheckLockSingleton doubleCheckLockSingleton;

    private DoubleCheckLockSingleton() {}

    public static DoubleCheckLockSingleton getInstance() {

        if(doubleCheckLockSingleton == null) {
            //同步块，线程安全创建实例
            synchronized (DoubleCheckLockSingleton.class) {
                if(doubleCheckLockSingleton == null) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }

        return doubleCheckLockSingleton;
    }
}
