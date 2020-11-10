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
        String str = "";
        System.out.println("当前字符是否是有效括号：" + standardExecute(str));
    }

    private static Boolean standardExecute(String target) {
        Boolean result = true;
        //1、如果字符串长度为奇数，则肯定不符合有效括号的要求
        if (target.length() % 2 == 1) {
            return false;
        }
        //2、设置括号匹配的Map，用于校验是否属于一对有效的括号
        Map<String, String> bracketsMap = Maps.newHashMap();
        bracketsMap.put(")", "(");
        bracketsMap.put("]", "[");
        bracketsMap.put("}", "{");
        //3、遍历字符串，对括号进行匹配校验
        Deque<String> stack = Lists.newLinkedList();
        for (int i = 0; i < target.length(); i++) {

        }
        return result;
    }
}
