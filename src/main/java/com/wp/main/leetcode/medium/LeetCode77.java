package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;
import com.wp.main.leetcode.common.BiddingSupplierInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname LeetCode77
 * @Description 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @Date 2020/11/23 17:50
 * @Created by wangpeng116
 */
public class LeetCode77 {
    public static void main(String[] args) {
        BiddingSupplierInfo sup1 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(10)).setSectionId("标段一");
        BiddingSupplierInfo sup2 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(12)).setSectionId("标段一");
        BiddingSupplierInfo sup3 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(29)).setSectionId("标段一");
        BiddingSupplierInfo sup4 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(37)).setSectionId("标段一");
        BiddingSupplierInfo sup5 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(8)).setSectionId("标段一");
        BiddingSupplierInfo sup6 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(24)).setSectionId("标段一");
        BiddingSupplierInfo sup7 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段二");
        BiddingSupplierInfo sup8 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        //数据集合
        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3, sup4, sup5, sup6, sup7, sup8);
        //结果集合
        List<List<BiddingSupplierInfo>> result = Lists.newArrayList();
    }




}
