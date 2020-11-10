package com.wp.main.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Deque;
import java.util.Map;

/**
 * @Classname LeetCode20
 * @Description 有效的括号
 * @Date 2020/11/10 14:22
 * @Created by wangpeng116
 */
public class LeetCode20 {
    public static void main(String[] args) {
        String str1 = "(){}[]";
        String str2 = "([{}])";
        String str3 = "({[}])";
        System.out.println("当前字符是否是有效括号：" + standardExecute(str1));
        System.out.println("当前字符是否是有效括号：" + standardExecute(str2));
        System.out.println("当前字符是否是有效括号：" + standardExecute(str3));
    }

    private static Boolean standardExecute(String target) {
        //1、如果字符串长度为奇数，则肯定不符合有效括号的要求
        if (target.length() % 2 == 1) {
            return false;
        }
        //2、设置括号匹配的Map，用于校验是否属于一对有效的括号
        Map<Character, Character> bracketsMap = Maps.newHashMap();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
        //3、遍历字符串，对括号进行匹配校验
        Deque<Character> stack = Lists.newLinkedList();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (bracketsMap.containsKey(ch)) {
                //如果是右括号
                //但堆栈是空(证明无匹配左侧括号) || 堆栈栈顶非匹配的左侧括号
                //则证明不是有效的括号
                if (stack.isEmpty() || bracketsMap.get(ch) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                //不是右括号则向堆栈中插入数据
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
