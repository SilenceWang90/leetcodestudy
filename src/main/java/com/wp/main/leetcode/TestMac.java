package com.wp.main.leetcode;

import com.wp.main.MyInterface;

public class TestMac {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        String result = myInterface.say("gegeg");
        System.out.println("你好呀" + result);
    }
}
