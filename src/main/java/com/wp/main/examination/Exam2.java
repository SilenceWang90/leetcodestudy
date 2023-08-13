package com.wp.main.examination;

/**
 * @Description 合并两个有序数组
 * @Author admin
 * @Date 2023/8/1 18:46
 */
public class Exam2 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        for(int num : individualExecution(a, b)){
            System.out.print(num+" ");
        }
    }

    /**
     * 默认a和
     * 思路：
     * 1、while循环，判断数组a和b是否不为空：共有3种情况
     * （1）a未遍历完成
     * （2）b未遍历完成
     * （3）a、b未遍历完成：取值，比较大小，小
     *
     * @param a
     * @param b
     */
    private static int[] individualExecution(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        // i是a当前遍历到的索引位置，j是b当前遍历到的索引位置，k是result最终合并后数组的索引位置
        int i = 0, j = 0, k = 0;
        while (i < a.length || j < b.length) {
            // 如果a、b均未遍历完成
            if (i < a.length && j < b.length) {
                if (a[i] >= b[j]) {
                    result[k] = b[j];
                    j++;
                } else {
                    result[k] = a[i];
                    i++;
                }
            } else if (i < a.length) {
                // b已经遍历完成，只有a有剩余
                result[k] = a[i];
                i++;
            } else {
                // a已经遍历完成，只有b有剩余
                result[k] = b[j];
                j++;
            }
            k++;
        }
        return result;
    }


}
