package com.wp.main.leetcode.common;

import lombok.Data;

/**
 * @Classname ListNode
 * @Description 链表
 * @Date 2020/11/16 13:10
 * @Created by wangpeng116
 */
@Data
public class ListNode {
    private Integer value;
    private ListNode next;

    public ListNode(Integer value) {
        this.value = value;
    }
}
