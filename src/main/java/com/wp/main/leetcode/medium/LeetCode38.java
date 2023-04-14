package com.wp.main.leetcode.medium;

/**
 * @Description 外观数列
 * 给定一个正整数n，输出外观数列的第n项。
 * 「外观数列」是一个整数序列，从数字1开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n)是对countAndSay(n-1)的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字1
 * 描述前一项，这个数是1即“一个1”，记作"11"
 * 描述前一项，这个数是11即“二个1”，记作"21"
 * 描述前一项，这个数是21即“一个2+一个1” ，记作"1211"
 * 描述前一项，这个数是1211即“一个1+一个2+二个1”，记作"111221"
 * 要描述 一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。
 * 要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 * @Author admin
 * @Date 2023/4/14 18:32
 */
public class LeetCode38 {
    public static void main(String[] args) {

    }

    /**
     * 个人思路
     * @param n 给定外观数列的第n项
     * @return 返回外观字符串描述信息
     */
    private static String individualExecute(int n){
        StringBuilder sb = new StringBuilder();



        return sb.toString();
    }
}
