package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;

import java.util.Deque;
import java.util.List;

/**
 * @Description 复原 IP 地址
 * 有效IP地址正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是有效IP地址，但是"0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是无效IP地址。
 * 给定一个只包含数字的字符串s用以表示一个IP地址，返回所有可能的有效IP地址，这些地址可以通过在s中插入'.'来形成。
 * 你不能重新排序或删除s中的任何数字。你可以按任何顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 提示：
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * @Author admin
 * @Date 2023/3/5 14:16
 */
public class LeetCode93 {
    public static void main(String[] args) {
//        System.out.println(individualExecute("0000"));
//        System.out.println(individualExecute("25525511135"));
        System.out.println(standardExecute("25525511135"));
        System.out.println(standardExecute("0000"));
    }

    /**
     * 官方解答：
     *
     * @param s 给定字符串
     * @return 结果集
     */
    private static List<String> standardExecute(String s) {
        List<String> result = Lists.newArrayList();

        return result;
    }


    /**
     * 个人思路：递归
     *
     * @param s 给定的IP字符串
     * @return 结果
     */
    @Deprecated
    private static List<String> individualExecute(String s) {
        List<String> result = Lists.newArrayList();
        StringBuilder joint = new StringBuilder();
        // 记录字符串拆解次数
        Deque<String> stack = Lists.newLinkedList();
        findValidIpStr(result, joint, s, stack);
        return result;
    }

    @Deprecated
    private static void findValidIpStr(List<String> result, StringBuilder joint, String str, Deque<String> stack) {
        // 递归边界：字符串拆解3次即完成一个ip的查询
        if (stack.size() == 3) {
            // 符合IP规则，则加入到结果集中：
            // （1）不为空
            // （2）不等于0的时候首位不是0，首位是0的时候只能是0
            // （3）数字小于等于255
            if (str != null && !"".equals(str) && (str.equals("0") || (str.length() > 1 && str.charAt(0) != '0')) && Integer.parseInt(str) <= 255) {
                joint.append(str);
                result.add(joint.toString());
            }
            return;
        }
        if (str.length() <= (4 - stack.size()) * 3 && str.length() > 0) {
            // 每层循环中，该层字符个数不能超过3
            for (int i = 0; i < Math.min(3, str.length()); i++) {
                String currentStr = str.substring(0, i + 1);
                // 当层循环中：
                // （1）数值大于255，则已经不符合IP规则，停止循环
                // （2）该数值的首位是0(0可以，但是01，012这种就不行)，则已经不符合IP规则，停止循环
                if (Integer.parseInt(currentStr) > 255 || (currentStr.length() > 1 && currentStr.charAt(0) != '0')) {
                    break;
                }
                joint.append(currentStr).append(".");
                stack.push(currentStr);
                String remainStr = str.substring(i + 1);
                findValidIpStr(result, joint, remainStr, stack);
                // 底层递归完成，将底层字符串在堆栈中的内容清除
                stack.pop();
                // 完成一次调用后，将刚加入的字符串从joint中删除
                joint.delete(joint.length() - remainStr.length(), joint.length());
            }
        } else {
            joint.delete(joint.lastIndexOf("."), joint.length());
        }
    }
}
