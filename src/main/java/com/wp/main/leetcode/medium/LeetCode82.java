package com.wp.main.leetcode.medium;

import com.wp.main.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回已排序的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * @Author admin
 * @Date 2023/9/16 9:48
 */
public class LeetCode82 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);

        ListNode result = standardExecution(listNode1);
        while (result != null) {
            System.out.println(result.getValue() + " ");
            result = result.getNext();
        }
    }


    /**
     * 一次遍历，在原链表上直接将重复的节点跳过
     * @param head
     * @return
     */
    private static ListNode standardExecution(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);
        ListNode cur = dummy;
        while (cur.getNext() != null && cur.getNext().getNext() != null) {
            if (cur.getNext().getValue() == cur.getNext().getNext().getValue()) {
                int x = cur.getNext().getValue();
                while (cur.getNext() != null && cur.getNext().getValue() == x) {
                    cur.setNext(cur.getNext().getNext());
                }
            } else {
                cur = cur.getNext();
            }
        }
        return dummy.getNext();
    }

    /**
     * 一次遍历，创建新的链表
     * @param head
     * @return
     */
    private static ListNode individualExecution(ListNode head) {
        // 设置一个top节点，便于对第一个节点的操作和其他节点相同。因为数字范围是[-100,100]，所以赋值-101相当于一个不存在的节点值
        ListNode top = new ListNode(-101);
        // 链表的尾结点，用于插入有效节点
        ListNode tail = top;
        // 记录出现的节点值出现的次数
        Map<Integer, Integer> recordMap = new HashMap<>();
        // 当前遍历的节点
        ListNode current = head;
        // 当前遍历节点相邻的前一个节点
        ListNode prev = top;
        while (current != null) {
            if (recordMap.containsKey(current.getValue())) {
                /** 1、当前节点的元素出现过 **/
                recordMap.put(current.getValue(), recordMap.get(current.getValue()) + 1);
            } else {
                /** 2、当前节点的元素未出现过 **/
                // 2.1、记录当前元素出现次数
                recordMap.put(current.getValue(), 1);
                // 2.2、当前节点的prev节点是否重复，如果没有重复则添加到链表中
                // 注意将top节点排除~
                if (recordMap.get(prev.getValue()) != null && recordMap.get(prev.getValue()) <= 1 && prev.getValue() != -101) {
                    ListNode target = new ListNode(prev.getValue());
                    tail.setNext(target);
                    tail = tail.getNext();
                }
            }
            // 节点后移
            prev = current;
            current = current.getNext();
        }
        // 结束后prev最后一个节点的处理
        if (recordMap.get(prev.getValue()) <= 1) {
            ListNode target = new ListNode(prev.getValue());
            tail.setNext(target);
            tail = tail.getNext();
        }
        return top.getNext();
    }
}


