package com.wp.main.leetcode.medium;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * @Author admin
 * @Date 2023/3/16 15:50
 */
public class LeetCode17 {
    public static void main(String[] args) {
//        String digits = "23";
//        String digits = "";
        String digits = "2";
        List<String> result = individualExecute(digits);
        for (String obj : result) {
            System.out.print(obj + " ");
        }
    }

    /**
     * 个人思路
     *
     * @param digits
     * @return 所有可能的组合
     */
    private static List<String> individualExecute(String digits) {
        /**
         * 1、初始化数字和字符映射关系，放入map中
         */
        Map<Character, List<String>> numberStrMap = Maps.newHashMap();
        List<String> numberStr = new ArrayList<>();
        numberStr.add("a");
        numberStr.add("b");
        numberStr.add("c");
        numberStrMap.put('2', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("d");
        numberStr.add("e");
        numberStr.add("f");
        numberStrMap.put('3', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("g");
        numberStr.add("h");
        numberStr.add("i");
        numberStrMap.put('4', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("j");
        numberStr.add("k");
        numberStr.add("l");
        numberStrMap.put('5', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("m");
        numberStr.add("n");
        numberStr.add("o");
        numberStrMap.put('6', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("p");
        numberStr.add("q");
        numberStr.add("r");
        numberStr.add("s");
        numberStrMap.put('7', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("t");
        numberStr.add("u");
        numberStr.add("v");
        numberStrMap.put('8', numberStr);
        numberStr = new ArrayList<>();
        numberStr.add("w");
        numberStr.add("x");
        numberStr.add("y");
        numberStr.add("z");
        numberStrMap.put('9', numberStr);
        /**
         * 2、字符串组合的StringBuilder
         */
        StringBuilder stringBuilder = new StringBuilder();
        /**
         * 3、可能组合的结果集
         */
        List<String> result = new ArrayList<>();
        /**
         * 4、对字符串进行递归，寻找可能的组合
         */
        recursionExecute(digits, stringBuilder, numberStrMap, result);
        return result;
    }

    /**
     * 递归寻找可以组合的字符
     *
     * @param digits        给定的目标字符串
     * @param stringBuilder 拼接字符串的StringBuilder
     * @param numberStrMap  数字和字符之间的映射Map
     */
    private static void recursionExecute(String digits
            , StringBuilder stringBuilder
            , Map<Character, List<String>> numberStrMap
            , List<String> result) {
        // 1、递归终止条件：当StringBuilder的长度达到了给定字符串的长度，递归终止
        // 因为可能组合的长度就是给定字符串的长度，给定字符串中一个数字一次只能匹配一个字符
        if (stringBuilder.length() >= digits.length()) {
            return;
        }
        // 2、确认当前需要从哪个数字中寻找字符
        // 当前拼接字符串的长度就决定了从第几个字符中寻找可拼接的字符
        int index = stringBuilder.length();
        Character character = digits.charAt(index);
        // 获取当前数字对应的字符集
        List<String> numbers = numberStrMap.get(character);
        // 3、遍历数组寻找可用的字符串进行拼接
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
            // 当前拼接一个字符后进行下一个字符的拼接
            recursionExecute(digits, stringBuilder, numberStrMap, result);
            // 拼接完成后，将长度符合拼接标准的字符串放入集合中
            if (stringBuilder.length() == digits.length()) {
                result.add(stringBuilder.toString());
            }
            // 将已经放入stringBuilder的元素清除：递归结束则当前选择的字符已经用完，清除后选择下一个字符
            stringBuilder.delete(index, stringBuilder.length());
        }
    }

}
