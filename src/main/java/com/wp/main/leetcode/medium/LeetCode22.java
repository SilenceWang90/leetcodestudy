package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Deque;
import java.util.List;

/**
 * @Description 括号生成
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 * @Author admin
 * @Date 2023/3/21 13:53
 */
public class LeetCode22 {
    public static void main(String[] args) {
//        int n = 1;
        int n = 3;
        List<String> result = individualExecute(n);
        for (String subject : result) {
            System.out.println(subject);
        }
    }

    /**
     * 思路：递归-回溯
     * 1、递归
     * 1.1、每次递归将"("和")"作为当次的选择，选择结束后进行递归调用。
     * 1.2、递归结束条件：
     * （1）如果左括号的集合与右括号的集合清空，那么括号选择完成，结束递归
     * （2）分支剪裁：如果左括号的数量大于右括号的数量，结束递归。因为此时的结果肯定是错的，右括号一定是在左括号出现后再出现
     * （3）分支剪裁：如果左括号的数量=右括号的数量，那么此时只能选择左括号，右括号的递归省略
     * 1.3、每层递归2次，一次是选择左括号后递归；一次是选择右括号后递归
     * 1.4、递归调用完成后，将当前加入字符串的字符清除，用于下一种选择
     *
     * @param n 传入括号数
     * @return 返回符合括号数要求的括号组合字符串
     */
    private static List<String> individualExecute(int n) {
        // 结果集
        List<String> result = Lists.newArrayList();
        // 左括号
        Deque<String> left = Lists.newLinkedList();
        // 右括号
        Deque<String> right = Lists.newLinkedList();
        // 左括号和右括号栈中加入括号数量
        while (n > 0) {
            left.push("(");
            right.push(")");
            n--;
        }
        // 括号拼接
        StringBuilder stringBuilder = new StringBuilder();
        // 括号组合组装
        recursionExecute(left, right, result, stringBuilder);
        return result;
    }

    /**
     * 递归回溯
     *
     * @param left          左括号集合
     * @param right         右括号集合
     * @param stringBuilder 括号拼接
     * @param result
     */
    private static void recursionExecute(Deque<String> left, Deque<String> right, List<String> result, StringBuilder stringBuilder) {
        /**
         * 1、递归结束条件：左括号和右括号匹配完成
         */
        if (left.size() == 0 && right.size() == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        /**
         * 2、分支剪裁：左括号如果比右括号多，则截止目前选择的是错误的，不需要继续递归操作
         */
        if (left.size() > right.size()) {
            return;
        }
        /**
         * 3、递归括号组合拼接
         */
        if (left.size() == right.size()) {
            // 左括号的数量和右括号的数量相同，则此时只能选择左括号进行递归。正好满足第一层只能选择左括号的规则。
            stringBuilder.append(left.pop());
            recursionExecute(left, right, result, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            left.push("(");
        } else {
            // 左括号和右括号均可选择
            // 1、选择左括号并进行递归回溯
            if (left.size() > 0) {
                stringBuilder.append(left.pop());
                recursionExecute(left, right, result, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                // 匹配完成后将匹配的括号放回入对应的栈中
                left.push("(");
            }
            if (right.size() > 0) {
                // 2、选择右括号并进行递归回溯
                stringBuilder.append(right.pop());
                recursionExecute(left, right, result, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                // 匹配完成后将匹配的括号放回入对应的栈中
                right.push(")");
            }
        }
    }
}
