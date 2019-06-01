package com.zjw.scaffold.templatemethod;

/**
 * @program scaffold
 * @description: 咖啡因饮料
 * @author: zhuangjiewei
 * @create: 2019/06/01 11:54
 */
public abstract class CaffeineBeverage {

    /**
     * 定义为final，因为不希望子类覆盖此方法
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        //使用钩子，子类可以覆盖实现，也可以不用
        if(customerWantsCondiments()) {
            addCondiments();
        }
    }

    boolean customerWantsCondiments(){
        return true;
    }

    /**
     * 冲泡
     */
    abstract void brew();

    /**
     * 增加调料
     */
    abstract void addCondiments();

    /**
     * 倒到杯子
     */
    private void pourInCup() {
        System.out.println("倒到杯子");
    }


    /**
     * 煮开水
     */
    protected void boilWater() {
        System.out.println("煮开水");
    };

}
