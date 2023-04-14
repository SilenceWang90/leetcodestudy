package com.wp.main.algorithm.heapAlgorithm;

import lombok.Data;

/**
 * @Description 堆（最大堆）
 * @Author admin
 * @Date 2023/4/14 15:42
 */
public class MaxHeap {
    private int[] data;

    /**
     * 构造函数创建堆，传入数组大小，用于数组的初始化
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        // +1是因为我们的堆从1开始存储数据，这样可以和节点的序号对应上~
        data = new int[capacity + 1];
    }
}
