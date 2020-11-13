package com.wp.main.Examination;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Deque;

/**
 * @Classname Exam1
 * @Description 一对中括号代表一组鱼群，中括号里面的中括号代表下一层深度
 * 一对中括号中的数字之和是鱼群中鱼的数量
 * 需要求出不同深度的鱼的数量
 * @Date 2020/11/13 14:07
 * @Created by wangpeng116
 */
public class Exam1 {
    public static void main(String[] args) {
//        String fish = "[1,[4,[6]]]";
//        String fish = "[[1,1],6,[1,2]]";
        String fish = "[[1,1],[[2]],[[2]],[[7,3]],[1,1]]";
        int[] result = new int[fish.length()];
        //堆栈存储括号以及括号的索引位置
        Deque<Integer> data = Lists.newLinkedList();
        for (int i = 0; i < fish.length(); i++) {
            Character str = fish.charAt(i);
            if (str.equals('[')) {
                //如果是左括号，则存储括号索引的位置
                data.push(i);
            } else if (str.equals(']')) {
                //如果是右括号，那么堆栈顶部的左括号一定和他是一组的
                Integer leftIndex = data.pop();
                String subString = fish.substring(leftIndex + 1, i);
                //找到一组括号后将括号内的数字加和即为该鱼群的数量
                String[] split = subString.split(",");
                int sum = 0;
                for (int j = 0; j < split.length; j++) {
                    if (!split[j].contains("[") && !split[j].contains("]")) {
                        sum += Integer.valueOf(split[j]);
                    }
                }
                result[data.size()] += sum;
            }
        }
        //输出结果
        System.out.println(Arrays.toString(result));
    }
}
