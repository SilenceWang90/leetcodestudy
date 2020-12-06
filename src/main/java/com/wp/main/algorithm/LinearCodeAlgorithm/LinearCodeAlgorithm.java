package com.wp.main.algorithm.LinearCodeAlgorithm;

/**
 * @Classname LinearCodeAlgorithm
 * @Description 线性规约算法
 * 思路：
 * 1、二维矩阵(数组，横向是去重的供应商，纵向是标段，数据是每个供应商在每个标段的报价，如果没有在该标段报价则默认值是所有报价数据中的最大值+1，目的是最终选择时选不到这些没有报价的数据)
 * 2、补齐矩阵为n*n：
 * 2.1、首先以各标段拟中标单位数为目标，增加标段数量(标段一的拟中标单位数为2则需要两列标段一，供应商信息一样)。
 * 2.2、标段信息补全后，以标段数量和供应商数量的最大值为标准，补齐矩阵为n*n。其中补齐的标段或供应商为虚拟数据，随意定义(最终选到也无所谓，因为只是为了实现算法补齐的数据，不会被采纳到最终结果)，报价都必须是0。
 * 3、与最小值做差值计算：每行、每列的报价与该行或该列的最小值做差值，最小值设为0，差值为每个报价的结果数据，记录在二维矩阵中。如果该行或该列已经存在0则不需要做差值计算。
 * 4、查找最终结果：
 * 4.1、递归或循环查找每行每列中0数量最少的数据(这个0所在的行和列中的0的数量都必须是最少的)，该值就是最终结果中的一条数据；
 * 4.2、选中该值后去掉该行该列中的所有为0的数据（包括自己），接着选每行每列中0最少的数据，直到选出n个数据(二维矩阵边长)。
 * 4.3、如果有多个0都是行和列中数量最少的数据，则选哪一个都行，因为他俩都将是最优方案。
 * @Date 2020/12/6 14:08
 * @Created by wangpeng116
 */
public class LinearCodeAlgorithm {
    public static void main(String[] args) {

    }

    private static void calculate() {

    }
}
