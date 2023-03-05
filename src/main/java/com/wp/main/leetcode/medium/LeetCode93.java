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
//        System.out.println(individualExecute("1234567891234"));
//        System.out.println(individualExecute("12"));
//        System.out.println(individualExecute(""));
//        System.out.println(individualExecute("0000"));
//        System.out.println(individualExecute("25525511135"));
        System.out.println(individualExecute("101023"));
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
        // 记录当前递归过程字符串的长度(用于递归结束后清理当前递归产生的字符串)，stack的大小是拆解的次数
        Deque<Integer> stack = Lists.newLinkedList();
        findValidIpStr(result, joint, s, stack);
        return result;
    }

    @Deprecated
    private static void findValidIpStr(List<String> result, StringBuilder joint, String str, Deque<Integer> stack) {
        // 递归边界：字符串拆解3次即完成一个ip的查询
        if (stack.size() == 3) {
            // 符合IP规则，则加入到结果集中：
            // （1）不为空
            // （2）首位不是0，但如果有且只有0是可以的
            // （3）数字小于等于255
            if (str != null && !"".equals(str)
                    && !(str.length() > 1 && str.charAt(0) == '0')
                    && Integer.parseInt(str) <= 255) {
                joint.append(str);
                result.add(joint.toString());
                // 记录完成后将拼接的字符串清除，用于下次遍历
                joint.delete(joint.lastIndexOf(".") + 1, joint.length());
            }
            return;
        }
        // 经过类比发现：使用1个“.”进行字符串分隔，剩余的字符串长度不能超过9；使用2个“.”进行字符串分隔，剩余的字符串长度不能超过6；使用3个“.”进行字符串分隔，剩余的字符串长度不能超过3；
        // 随着“.”的个数增加，剩余字符串数量减少。
        // 因此，我们可以设定每增加1个"."和能形成有效IP的函数关系为：剩余字符串长度=(4-"当前使用'.'的个数")*3
        if (str.length() <= (4 - stack.size()) * 3 && str.length() > 0) {
            // 每层循环中，该层字符个数不能超过3，超过3本层循环就可以结束了
            for (int i = 0; i < Math.min(3, str.length()); i++) {
                String currentStr = str.substring(0, i + 1);
                // 当层循环中：
                // （1）数值大于255，则已经不符合IP规则，停止循环
                // （2）该数值的首位是0(0可以，但是01，012这种就不行)，则已经不符合IP规则，停止循环
                if (Integer.parseInt(currentStr) > 255 || (currentStr.length() > 1 && currentStr.charAt(0) == '0')) {
                    break;
                }
                joint.append(currentStr).append(".");
                // 放入当前字符串的长度，记得带上"."，因为joint的时候把"."也带上了
                stack.push(currentStr.length() + 1);
                // 截取剩余字符串
                String remainStr = str.substring(i + 1);
                findValidIpStr(result, joint, remainStr, stack);
                // 底层递归完成，当前内容清理
                int currentLength = stack.pop();
                joint.delete(joint.length() - currentLength, joint.length());
            }
        }
        /*else {
            // 当前IP规则不满足
            if (stack.size() > 0) {
                // 不符合IP规则，清理递归回溯过程中最近记录的内容(其实就是上一次调用的内容，就因为上一次调用的方案不合理才会导致本次失败，索引要把上一次的内容清理掉)
                int length = stack.pop();
                joint.delete(joint.length() - length, joint.length());
            } else {
                // 第一次查找就失败，不需要做任何处理。
                // 这种情况是给定的字符串长度超过了12
                System.out.println("给定字符串长度超过IP最大有效长度12，给定字符串长度为：" + str.length());
            }
        }*/
    }

    /**
     * 官方解答：和个人思路一致...递归回溯
     *
     * @param s 给定字符串
     * @return 结果集
     */
    private static List<String> standardExecute(String s) {
        List<String> result = Lists.newArrayList();

        return result;
    }
}
