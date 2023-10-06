package com.wp.main.leetcode.easy;

import com.wp.main.common.ListNode;

/**
 * @Description 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * @Author admin
 * @Date 2023/10/6 12:01
 */
public class LeetCode206 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ListNode result = individualExecution(node1);
        while (result != null) {
            System.out.print(result.getValue() + " ");
            result = result.getNext();
        }
    }

    /**
     * 个人思路：递归到最后一个节点，然后回归时从后往前拼接当前为当前链表的尾节点
     *
     * @param head
     * @return
     */
    private static ListNode individualExecution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode targetHead = new ListNode(0);
        recursion(head, targetHead);
        return targetHead.getNext();
    }

    private static ListNode recursion(ListNode origin, ListNode targetHead) {
        /**1、递归终止条件：递归找到队列的尾节点/**/
        if (origin.getNext() == null) {
            // 找到队列尾结点，队列开始转向
            targetHead.setNext(origin);
            return origin;
        }
        /**2、递归逻辑：获取当前节点，origin向下推进**/
        // 获取当前节点的目的是为了从后向前拼接的时候直接拼接当前节点为新链表的尾结点
        ListNode current = origin;
        origin = origin.getNext();
        ListNode tempHead = recursion(origin, targetHead);
        /**3、递归终止操作**/
        tempHead.setNext(current);
        return current;
    }
}
