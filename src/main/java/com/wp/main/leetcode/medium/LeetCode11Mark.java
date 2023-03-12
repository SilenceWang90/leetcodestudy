package com.wp.main.leetcode.medium;


/**
 * MARK：
 * 1、针对数组遍历，如果想只遍历一次，可以考虑双指针移动法！！！！！！双指针移动法的终止条件是左指针和右指针重合，因此循环中可以用while(left<right)作为循环逻辑。
 * 双指针移动：left从数组最左侧开始向右移动，right从数组最右侧开始向左移动
 * 原理：
 * 双指针使用的时候省略了大量不必要的遍历。原因是：当以左右指针作为边界时，我们已经求得了当前的边界值，此时由于我们已知边界值和目标值的差距，
 * 且数组是按照顺序排列，那么为了达到我们希望的结果，我们此时需要对指针进行移动。而被移动的那个指针就是当前指针作为边界的情况下，最值的结果，如果不移动这个指针，移动
 * 另一个指针只会离我们的结果渐行渐远，因此我们相当于已经找到了某个指针的最值，如果最值都不满足那么该指针作为边界的情况下，另一个指针如何移动都不可能得到我们希望的结果
 * 所以我们只能移动该指针~。
 * 比如升序数组中，我们求2个元素加和可以为0的2个元素。如果最开始左指针和右指针的和大于0，那么我们肯定只能移动右指针。因为此时右指针作为边界都大于0，如果还移动左指针，那么加和结果只能越来越大
 * 因此右指针此时的位置已经不可能得到答案，只能移动右指针。
 * 相当于通过边界极限问题省去了大量不需要的循环~
 * 2、整数向上取整方式：x/y+(x%y==0?0:1)
 */

/**
 * @Description 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * @Date 2023/02/23 11:33:00
 * @Created by wangpeng
 */
public class LeetCode11Mark {

    public static void main(String[] args) {
        int[] target = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] target = new int[]{1, 1};
//        individualExecute(target);
//        individualExecuteOptimize(target);
        standardExecute(target);
    }

    /**
     * 思路：双指针移动，x从数组最左侧开始向右移动，y从数组最右侧开始向左移动
     * 步骤：当确定两条线时，分别用x指针和y指针指向这两条线，当前面积取决于高度最矮的那条线。假设如果我们不移动最矮的那条线，那么移动
     * 过程中x轴的值一定变小，由于最矮的那条线没动，所以y轴最大值只能是最矮的那条线，此移动无意义。因此我们肯定移动最矮的那条线，虽然
     * x轴的值依然会变小，但是y轴的值可能变大，这样最矮的线的高度有可能增加，这样整体面积是有机会增大的。
     * 所以用这种方式我们不断移动x指针和y指针对应的最小值，这样只需遍历一次即可得到最小值。
     *
     * @param target 目标参数
     * @return 最大水量
     */
    private static int standardExecute(int[] target) {
        // 最大面积
        int result = 0;
        // 左指针
        int xLeft = 0;
        // 右指针
        int xRight = target.length - 1;
        // 两指针未相遇则不停止计算
        while (xLeft < xRight) {
            int height = Math.min(target[xLeft], target[xRight]);
            result = Math.max(result, height * (xRight - xLeft));
            if (target[xLeft] < target[xRight]) {
                xLeft++;
            } else {
                xRight--;
            }
        }
        System.out.println("最大面积为：" + result);
        return result;
    }

    /**
     * 思路：
     * 1、遍历数组，按序将当前索引与下一位索引之间组成的面积进行乘积计算，计算结果即二者的面积(储水量)
     * 2、每个索引与右侧所有的线进行计算，并不断比较最大值，最终最大值就是期望的结果。
     *
     * @param target 目标参数
     * @return 最大水量
     */
    private static int individualExecute(int[] target) {
        int result = 0;
        // 因为储水需要2条线，因此最后一条线不需要进行遍历
        for (int i = 0; i < target.length - 1; i++) {
            // 当前线的高度
            int height = target[i];
            // 遍历右侧线，计算当前线与其他线可组成的面积，并记录最大值
            for (int j = i + 1; j < target.length; j++) {
                // 当前计算的面积
                int currentResult;
                if (target[j] > height) {
                    currentResult = height * (j - i);
                } else {
                    currentResult = target[j] * (j - i);
                }
                // 记录较大的面积
                result = Math.max(currentResult, result);
            }

        }
        System.out.println("最大面积为：" + result);
        return result;
    }

    /**
     * 思路：
     * 从最右侧开始向左移动，由于X减小，若想面积增加或保持不变，Y一定是增加的。且Y一定不会超过初始线的值(能装多少水取决于最矮的线)
     *
     * @param target 目标参数
     * @return 最大水量
     */
    private static int individualExecuteOptimize(int[] target) {
        int result = 0;
        // 因为储水需要2条线，因此最后一条线不需要进行遍历
        for (int i = 0; i < target.length - 1; i++) {
            // 当前线的高度
            int height = target[i];
            // 记录遍历过程中的面积
            int acreage;
            // 从最右侧开始遍历
            for (int j = target.length - 1; j > i; j--) {
                // 当前所得面积
                acreage = (j - i) * Math.min(height, target[j]);
                result = Math.max(acreage, result);
                // 当前面积下，y值最大的时候对于x的最小值。左移的过程x不断减小，当x小于该值时，由于y再增加无意义，因此要终止循环返回结果。
                // 求余如果为0，则表示可以整除，除法结果就是result/height；如果不等于0就是不能整除，除法结果+1就是向上取整的结果。
                int maxAxis = result / height + (result % height != 0 ? 1 : 0);
                if (j < maxAxis) {
                    break;
                }
            }
        }
        System.out.println("最大面积为：" + result);
        return result;
    }


}
