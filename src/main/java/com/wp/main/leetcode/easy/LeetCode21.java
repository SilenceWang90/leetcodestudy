package com.wp.main.leetcode.easy;

import com.wp.main.leetcode.common.ListNode;

/**
 * @Classname LeetCode21
 * @Description 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：
 * listNode1：1->2->4->7
 * listNode2：1->3->4->6
 * 输出：1->1->2->3->4->4->6->7
 * @Date 2020/11/16 13:08
 * @Created by wangpeng116
 */
public class LeetCode21 {
    public static void main(String[] args) {
        //链表1：l1是链表1的头
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(13);
        ListNode l15 = new ListNode(14);
        l1.setNext(l11);
        l11.setNext(l12);
        l12.setNext(l13);
        l13.setNext(l14);
        l14.setNext(l15);
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
     * 一、定义最终结果链表：
     * 1.1、新增最终队列ListNode Result
     * 1.2、preNode记录最终链表的最末尾的值，便于指向比较后的最新值
     * 二、迭代比较
     * 2.1、比较两个链表表头的值，新链表的末尾指向小的值
     * 2.2、被指向的值的队列，队列头部节点后移（比如l1和l2的值中，l1的值小。那么result指向l1的当前值，所以l1后移一位便于继续比较）
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    private static ListNode standardExecute(ListNode listNode1, ListNode listNode2) {
        //最终队列
        ListNode result = new ListNode(-1);
        //最终队列末尾值
        ListNode preNode = result;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.getValue() < listNode2.getValue()) {
                //如果第一个链表的值小于第二个链表的值，则最终链表指向第一个链表
                preNode.setNext(listNode1);
                preNode = listNode1;
                listNode1 = listNode1.getNext();
            } else {
                //如果第一个链表的值大于等于第二个链表的值，则最终链表指向第二个链表
                preNode.setNext(listNode2);
                preNode = listNode2;
                listNode2 = listNode2.getNext();
            }
        }
        //listNode1和listNode2有一个为空才会跳出
        //所以只需要结果链表指向一个不为空的即可
        if (listNode1 == null) {
            preNode.setNext(listNode2);
        } else {
            preNode.setNext(listNode1);
        }

        return result;
    }
}
