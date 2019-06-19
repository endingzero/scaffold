package com.zjw.scaffold.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/06/19 19:08
 */
public class Client {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>(2);
        map.put("java","java");
        map.put("c++","c++");
        map.put("php","php");
        map.put("go","go");
        System.out.println(map.size());
    }
}
