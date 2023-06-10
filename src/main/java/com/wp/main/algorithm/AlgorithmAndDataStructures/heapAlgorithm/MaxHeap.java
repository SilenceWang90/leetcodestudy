package com.wp.main.algorithm.AlgorithmAndDataStructures.heapAlgorithm;

/**
 * @Description 堆（最大堆）
 * @Author admin
 * @Date 2023/4/14 15:42
 */
public class MaxHeap {
    // 存储堆数据的数组
    private int[] data;
    // 堆(数组)中元素个数
    private int count;

    /**
     * 构造函数创建堆，传入数组大小，用于数组的初始化
     *
     * @param capacity 堆的容量
     */
    public MaxHeap(int capacity) {
        // +1是因为我们的堆从索引为1的位置开始存储数据，这样可以和节点的序号对应上~
        data = new int[capacity + 1];
        count = 0;
    }

    /**
     * 查看堆中目前多少个元素(堆对象为private，所以外部无法通过data.size()查看元素个数)
     * 注意这个count和数组的size不同，数组的size是容量一共可以放入多少个元素，这个count是当前数据中真实存在的元素数量
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }
}
