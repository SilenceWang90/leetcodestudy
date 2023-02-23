package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

/**
 * MARK：
 * 链表：ListNode类是链表节点，ListNode类定义如下：存储下一个链表节点的引用，以及当前节点的内容
 * public class ListNode {
 *     private Integer value;
 *     private ListNode next;
 *
 *     public ListNode(Integer value) {
 *         this.value = value;
 *     }
 * }
 */


/**
 * @Classname LeetCode2
 * @Description 两数相加
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Date 2020/11/17 20:07
 * @Created by wangpeng116
 */
public class LeetCode2Mark {
    public static void main(String[] args) {
        //链表1：l1是链表1的头
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(9);
//        ListNode l15 = new ListNode(14);
        l1.setNext(l11);
        l11.setNext(l12);
        l12.setNext(l13);
        l13.setNext(l14);
//        l14.setNext(l15);
        //链表2：l2是链表2的头
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        ListNode l24 = new ListNode(6);
//        ListNode l25 = new ListNode(13);
//        ListNode l26 = new ListNode(14);
        l2.setNext(l22);
        l22.setNext(l23);
        l23.setNext(l24);
//        l24.setNext(l25);
//        l25.setNext(l26);
        //3、获取最终链表
        ListNode result = standardExecute(l1, l2);
        //4、输出链表的值
        while (result != null && result.getValue() != null) {
            System.out.println(result.getValue());
            result = result.getNext();
        }
    }

    /**
     * 思路：
     * 1、定义一个最终链表result，该链表始终有一个尾部对象tail
     * 2、迭代：只要l1和l2有一个不为空就取出链表头进行计算(因为是逆序，所以链表头开始是个位，十位，百位...)
     * 只所以迭代结束不是判断两个都不为空，是因为即使有一个链表取值完成，那么另一个链表也不能直接接到result链表的末尾，
     * 因为加和可能出现进位，所以直接拼接最终链表和剩余链表是错误的操作。
     * 3、加和：取出数字加和，对最终链表赋值并记录是否有进位信息carry(对10做除法)。加和时对进位信息也要加和
     * 4、赋值：最终链表末尾赋值加和求余的结果
     * 5、移动：当前加和处理完成后，两个链表头部信息后移，进行下一位的计算，如此往复。
     * 6、如果迭代结束了进位信息还有，那就需要额外拼接进位的信息
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode standardExecute(ListNode l1, ListNode l2) {
        //初始化最终链表
        ListNode result = new ListNode(-1);
        //最终链表的末尾对象
        ListNode tail = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //取值加和
            int l1Val = l1 != null ? l1.getValue() : 0;
            int l2Val = l2 != null ? l2.getValue() : 0;
            int sum = l1Val + l2Val + carry;
            //加和后记录进位信息
            int resultVal = sum % 10;
            carry = sum / 10;
            //最终链表加入当前计算结果，tail后移到尾部
            ListNode currentNode = new ListNode(resultVal);
            tail.setNext(currentNode);
            tail = tail.getNext();
            //各链表后移便于下一次计算
            l1 = l1 != null ? l1.getNext() : null;
            l2 = l2 != null ? l2.getNext() : null;
        }
        //所有链表计算结束后依然有进位信息，则需要额外新增链表对象保留进位信息
        if (carry != 0) {
            ListNode currentNode = new ListNode(carry);
            tail.setNext(currentNode);
        }
        //不需要首位
        return result.getNext();
    }
}
