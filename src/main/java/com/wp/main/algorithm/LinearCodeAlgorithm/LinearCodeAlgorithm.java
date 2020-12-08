package com.wp.main.algorithm.LinearCodeAlgorithm;

/**
 * @Classname LinearCodeAlgorithm
 * @Description 线性规约算法
 * 参考：https://wenku.baidu.com/view/3eb3366f7375a417866f8fcd.html
 * https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/onmde-jie-fa-xiong-ya-li-suan-fa-by-code_zy/
 * 思路：
 * 1、二维矩阵(数组，横向是去重的供应商，纵向是标段，数据是每个供应商在每个标段的报价，如果没有在该标段报价则默认值是所有报价数据中的最大值+1，目的是最终选择时选不到这些没有报价的数据)
 * 2、补齐矩阵为n*n：
 * 2.1、首先以各标段拟中标单位数为目标，增加标段数量(标段一的拟中标单位数为2则需要两列标段一，供应商信息一样)。
 * 2.2、标段信息补全后，以标段数量和供应商数量的最大值为标准，补齐矩阵为n*n。其中补齐的标段或供应商为虚拟数据，随意定义(最终选到也无所谓，因为只是为了实现算法补齐的数据，不会被采纳到最终结果)，报价都必须是0。
 * 3、与最小值做差值计算：每行、每列的报价与该行或该列的最小值做差值，最小值设为0，差值为每个报价的结果数据，记录在二维矩阵中。如果该行或该列已经存在0则不需要做差值计算。
 * 4、查找最终结果：
 * 4.1、画盖0线：用最少的横线和竖线覆盖所有的0。
 * （1）如果横、竖线的个数同n，则可直接推荐出方案；
 * （2）如果个数不足n则需要特殊处理：从没有被横竖线覆盖的数据中找到最小值，然后所有没有被覆盖的值减去该最小值，同时被横线和竖线覆盖的元素加上该最小值(即非画线行减1，画线列+1)。
 *      该操作的原理就是行、列同时加减值，最终推荐结果不变。
 * （3）第一步和第二步处理后，画盖0线，如果盖0线的数量还不足n，则不断循环第一步和第二步，直到满足“盖0线的数量同n”为止。
 * 4.2、
 * @Date 2020/12/6 14:08
 * @Created by wangpeng116
 */
public class LinearCodeAlgorithm {
    public static void main(String[] args) {

    }

    private static void calculate() {

    }
}
