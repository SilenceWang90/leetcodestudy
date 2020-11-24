package com.wp.main.leetcode.medium;

import com.google.common.collect.Lists;
import com.wp.main.leetcode.common.BiddingSupplierInfo;

import java.math.BigDecimal;
import java.util.Deque;
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
        /*BiddingSupplierInfo sup4 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(37)).setSectionId("标段一");
        BiddingSupplierInfo sup5 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(8)).setSectionId("标段一");
        BiddingSupplierInfo sup6 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(24)).setSectionId("标段一");
        BiddingSupplierInfo sup7 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段二");
        BiddingSupplierInfo sup8 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");*/
        //数据集合
//        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3, sup4, sup5, sup6, sup7, sup8);
        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3);
        //已选集合(堆栈，因为我们为了让选择[1,2][1,3][1,n]组合，就必须在每次递归结束后清除栈顶数据，这样才能保证找出所有需要选择的数据)
        Deque<BiddingSupplierInfo> selectedStack = Lists.newLinkedList();
        //结果集合
        List<List<BiddingSupplierInfo>> result = Lists.newArrayList();
        calculate(0, 2, selectedStack, list, result);
        System.out.println(result.toString());
    }

    /**
     * 思路：递归
     * （1）递归终点：选择到了足够的供应商
     * （2）每个递归要做的事情：从begin到n(队列长度)之间选择供应商
     * （3）递归结束后：
     *
     * @param begin         起始位置，从begin到队列长度之间选一个数据
     * @param select        要选出几个数据
     * @param selectedStack 当前遍历已选的供应商数量
     * @param list          所有供应商数据
     * @param result        选出的组合结果
     */
    public static void calculate(int begin, int select, Deque<BiddingSupplierInfo> selectedStack
            , List<BiddingSupplierInfo> list, List<List<BiddingSupplierInfo>> result) {
        //选到了足够的供应商，则加入到最终队列中作为结果集的数据
        if (selectedStack.size() == select) {
            result.add(Lists.newArrayList(selectedStack));
            return;
        }
        //未选择足够供应商，继续从begin到n之间选择
        for (int i = begin; i < list.size(); i++) {
            selectedStack.addLast(list.get(i));
            calculate(i + 1, 2, selectedStack, list, result);
            selectedStack.removeLast();
        }
    }


}
