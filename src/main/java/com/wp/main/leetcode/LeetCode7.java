package com.wp.main.leetcode;

/**
 * @Classname LeetCode7
 * @Description 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Date 2020/11/4 15:56
 * @Created by wangpeng116
 */
public class LeetCode7 {
    public static void main(String[] args) {
        Integer x = Integer.valueOf("1435230921");
        Integer y = Integer.valueOf("-843523094");
//        standardExecute(x);
//        standardExecute(y);
        myExecute(String.valueOf(x));
        myExecute(String.valueOf(y));
    }

    /**
     * 解题思路：
     * 1、通过整型数值对10求余(%10)，选出末尾数值；然后通过除法(/10)，相当于将末尾数去掉（25/10=2）。如此循环相当于不断得到尾数
     * 2、每一次循环对得到的尾数乘以10，然后加上求余得到的数值，这样就不断的将整数进行了翻转。
     * 3、翻转过程中防止数值溢出需要做判断：
     * 整型数值范围-2147483648至2147483647
     * 3.1、
     * 3.2、
     *
     * @param x：对目标数值进行翻转
     */
    private static void standardExecute(Integer x) {
        Integer result = 0;
        while (x != 0) {
            //获取尾数
            Integer pop = x % 10;
            //去掉尾数
            x = x / 10;
            //防止溢出：上限
            //（1）result>Integer.MAX_VALUE / 10：意味着该值去掉末位都大于去掉末位的最大值，那么该值乘以10之后肯定溢出
            //（2）result == Integer.MAX_VALUE / 10 && pop > 7：意味着去掉末位后数值一样大，但是末位比最大值的末位(7)还大，那肯定溢出
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7) {
                System.out.println("数据翻转时溢出上限，暂停翻转");
                return;
            }
            //防止溢出：下限
            //（1）result < Integer.MIN_VALUE / 10：意味着该值去掉末位都小于去掉最小值的末位，那么该值乘以10之后肯定溢出
            //（2）result == Integer.MIN_VALUE / 10 && pop < -8：意味着去掉末位后数值一样大，但是末位比最小值的末位(-8)还小，那肯定溢出
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8) {
                System.out.println("数据翻转时溢出下限，暂停翻转");
                return;
            }
            //溢出判断通过，即可尾数重新拼接实现倒序（乘以10是进位，加上循环得到的尾数）
            result = result * 10 + pop;
        }
        System.out.println("翻转结果为：" + result);
    }

    private static void myExecute(String x) {
        StringBuilder stringBuilder = new StringBuilder(x);
        String symbol = stringBuilder.substring(0, 1);
        if (symbol.equals("-") || symbol.equals("+")) {
            String figure = stringBuilder.reverse().substring(0, x.length() - 1);
            String reverseStr = symbol + figure;
            try {
                Integer result = Integer.valueOf(reverseStr);
                System.out.println("转换结果为：" + result);
            } catch (Exception e) {
                System.out.println("数据转换溢出：" + e);
            }
        }else{
            try{
                Integer result = Integer.valueOf(stringBuilder.reverse().toString());
                System.out.println("转换结果为：" + result);
            }catch(Exception e){
                System.out.println("数据转换溢出：" + e);
            }
        }
    }
}
