package com.wp.main.leetcode;

import com.google.common.collect.Lists;

import java.util.Deque;

/**
 * @Classname Test
 * @Description 测试
 * @Date 2020/11/10 19:08
 * @Created by wangpeng116
 */
public class Test {
    public static void main(String[] args) {
        Deque<String> stack = Lists.newLinkedList();
        Deque<String> queue = Lists.newLinkedList();
        /**1、堆栈使用方法**/
        //1、堆栈压入数据
        stack.push("111");
        //2、查看堆栈头部数据，不会清除该数据
        System.out.println(stack.peek());
        stack.push("222");
        System.out.println(stack.peek());
        stack.push("333");
        System.out.println(stack.peek());
        //3、查看堆栈头部数据，并清除该数据
        System.out.println(stack.pop());
        //4、遍历堆栈
        for (String obj : stack) {
            System.out.println(obj);
        }
        //5、查看栈头和栈尾
        System.out.println("stack.peekFirst()：" + stack.peekFirst());
        System.out.println("stack.peekLast()：" + stack.peekLast());
        /**2、队列使用方法：队列尾用于插入数据，队列头用于读取数据**/
        //add()、offer()队列尾插入数据
        /*queue.add("1");
        queue.offer("2");
        //First是向队列头部增加数据
        queue.addFirst("0");
        //Last是向队列尾部增加数据
        queue.addLast("3");
        //push()是向队列头部增加数据
        queue.push("4");
        for (String obj : queue) {
            System.out.println(obj);
        }*/
    }
}
