package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description
 * @Author admin
 * @Date 2023/3/25 16:51
 */
public class LeetCode93Optimization {
    public static void main(String[] args) {
//        String s = "0000";
//        String s = "1234567891234";
//        String s = "12";
//        String s = "";
//        String s = "25525511135";
//        String s = "101023";
        String s = "101023@";
        if (s.length() > 12) {
            return;
        }
        // 可能ip的结果集
        List<String> result = Lists.newArrayList();
        // 当前点的数量
        int dotNums = 3;
        // 拼接的ip
        StringBuilder str = new StringBuilder();
        individualExecute(s, dotNums, str, result);
        System.out.println(result);
    }

    private static void individualExecute(String s, int dotNums, StringBuilder str, List<String> result) {
        /** 1、递归终止条件*/
        // （1）点的个数和当前字符串的数量关系：dotNums+1<=s.length()<=3*(dotNums+1)，如果不符合则返回即可
        if (s.length() < dotNums + 1 || s.length() > 3 * (dotNums + 1)) {
            return;
        }
        // （2）dot使用完成：符合IP要求的字符串加入到结果集中
        if (dotNums == 0) {
            // 最后一串数字校验
            if (Integer.parseInt(s) > 255
                    || (s.length() > 1 && s.charAt(0) - '0' == 0)) {
                return;
            }
            // todo：补充优化：对最后一段字符串要遍历是否存在非数字，如果存在则要直接return
            // 将最后的字符拼接到str上，并加入到结果集
            result.add(str.append(s).toString());
            // 将当前拼接的内容清除(从最后一个点的下一个位置开始到最后)
            str.delete(str.lastIndexOf(".") + 1, str.length());
            return;
        }
        /** 2、递归逻辑：拼接字符串*/
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            // 2.1、拼接前校验：
            //（1）当前是否是字符
            if (!Character.isDigit(s.charAt(i))) {
                return;
            }
            // （2）数字是否超过255（3）数字是否是0开头
            String subStr = s.substring(0, i + 1);
            if (Integer.parseInt(subStr) > 255 || (subStr.length() > 1 && subStr.charAt(0) - '0' == 0)) {
                return;
            }
            // 记录当前已拼接字符串的长度，用于递归结束清理时作为起始位置
            int currentLength = str.length();
            str.append(subStr).append(".");
            dotNums--;
            // 将剩余的字符传入，这样每次遍历的i起始位置就不用变，都是从0开始
            individualExecute(s.substring(i + 1), dotNums, str, result);
            /** 3、递归结束：将当前选择的字符以及拼接的dot清除，dot的数量还原*/
            str.delete(currentLength, str.length());
            dotNums++;
        }
    }
}
