package com.wp.main.leetcode.easy;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Deque;
import java.util.Map;

/**
 * @Classname LeetCode20
 * @Description 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @Date 2020/11/10 14:22
 * @Created by wangpeng116
 */
public class LeetCode20 {
    public static void main(String[] args) {
        String str1 = "(){}[]";
        String str2 = "([{}])";
        String str3 = "({[(}(]))";
        String str4 = "({[]})[]";
        String str5 = "(({[]}))[]";
        System.out.println("当前字符是否是有效括号：" + standardExecute(str1));
        System.out.println("当前字符是否是有效括号：" + standardExecute(str2));
        System.out.println("当前字符是否是有效括号：" + standardExecute(str3));
        System.out.println("当前字符是否是有效括号：" + standardExecute(str4));
        System.out.println("当前字符是否是有效括号：" + standardExecute(str5));
    }

    /**
     * 通过堆栈解决该问题：想到堆栈的原因可能是因为后遇到的左括号要先闭合。
     * 堆栈中只保存左括号的字符。
     * 1、如果字符串长度为奇数，肯定不是有效的括号
     * 2、遍历字符串：如果是左括号则直接放入堆栈顶部，如果是右括号则要看能不能找到可闭合的左括号
     * 3、如果是右括号：
     * （1）此时堆栈如果为空，则肯定不是有效括号；如果栈顶不是匹配的左括号，肯定也不是有效括号。
     * （2）如果找到匹配的左侧括号，则把匹配的栈顶左侧括号弹出，用于下一个右侧括号来匹配新的栈顶左侧括号
     * 4、如果一直都是匹配，那么最终如果堆栈为空，则是有效括号字符串，否则就不是有效括号字符串
     * @param target
     * @return
     */
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
                //但堆栈是空(证明无左侧括号，肯定不是有效括号) || 堆栈栈顶非匹配的左侧括号
                //则证明不是有效的括号
                if (stack.isEmpty() || bracketsMap.get(ch) != stack.peek()) {
                    return false;
                } else {
                    //如果匹配则从栈顶弹出该数据
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
