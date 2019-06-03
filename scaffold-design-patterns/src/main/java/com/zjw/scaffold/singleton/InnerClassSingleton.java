package com.zjw.scaffold.singleton;

/**
 * @program scaffold
 * @description: 内部类单例
 * @author: zhuangjiewei
 * @create: 2019/06/03 16:00
 */
public class InnerClassSingleton {

    private static class Holder {
        private static InnerClassSingleton innerClassSIngleton = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return Holder.innerClassSIngleton;
    }
}
