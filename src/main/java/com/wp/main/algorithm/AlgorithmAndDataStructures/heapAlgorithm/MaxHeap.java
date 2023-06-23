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
    // 堆(数组)的容量
    private int capacity;

    /**
     * 构造函数创建堆，传入数组大小，用于数组的初始化
     *
     * @param capacity 堆的容量
     */
    public MaxHeap(int capacity) {
        // +1是因为我们的堆从索引为1的位置开始存储数据，这样可以和节点的序号对应上~
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 查看堆中目前多少个元素(堆对象为private，所以外部无法通过data.size()查看元素个数)
     * 注意这个count和数组的size不同，数组的size是容量一共可以放入多少个元素，这个count是当前数据中真实存在的元素数量
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入元素
     *
     * @param item 待插入的元素
     */
    public void insert(int item) {
        // 防止超过容量
        if (capacity < count + 1) {
            throw new RuntimeException("容量已达上限，无法继续插入数据");
        }
        // 1、元素放入到数组中(最后一个元素的后面)
        data[count + 1] = item;
        // 容量+1
        count++;
        // 2、移动新增的元素至合适的位置，保证最大完全堆的性质
        shiftUp(count);
    }

    /**
     * 向上移动新增的元素
     *
     * @param position 新增元素所在的位置
     */
    private void shiftUp(int position) {
        // 如果当前位置的元素比父节点大，那么就交换当前节点和父节点的位置。按照此逻辑不断的移动新增的元素直到合适的位置即可。
        // 防止数组越界等问题需要判断当前位置如果已经是数的根节点那么循环终止
        while (position > 1 && data[position / 2] < data[position]) {
            int temp = data[position / 2];
            data[position / 2] = data[position];
            data[position] = temp;
            // 移动过程中修改新增元素当前所在的最新位置
            position = position / 2;
        }
    }

    /**
     * 移出元素(根节点元素)
     *
     * @return 返回根节点元素
     */
    public int remove() {
        // 数组不为空才可以移出
        if (count > 0) {
            int currentRoot = data[1];
            // 将最后一个节点移动到根节点
            data[1] = data[count];
            count--;
            // 移动新的根节点，将其放入到合适的位置保证最大完全堆的性质
            shiftDown(1);
            return currentRoot;
        } else {
            throw new RuntimeException("数组为空，无法取出元素");
        }
    }

    /**
     * 移动根节点元素到达合适的位置
     *
     * @param position
     */
    private void shiftDown(int position) {
        // 只要当前索引位置拥有左节点，则意味着当前节点没有抵达叶子节点，就需要判断该元素是否需要继续下移。不需要判断右节点就是因为完全二叉树的性质都是左侧聚簇的，不可能存在只有右节点没有左节点
        while (position * 2 <= count) {
            // 1、当前position位置的元素与其左右节点更大的元素比较，小的话换位置；否则不需要处理，循环结束。
            int left = position * 2;
            int right = left + 1;
            // 当前position位置的元素要和左右哪个节点进行位置交换，默认是左节点因为完全二叉树只要有子节点必然有左侧节点
            int exchange = left;
            // 如果存在右节点且右节点比左节点大
            if (right <= count && data[right] > data[left]) {
                exchange = right;
            }
            // 2、如果当前position节点位置的元素比最大的子节点还大，那么就不需要处理，否则的话交换2个元素的位置即可
            if (data[position] >= data[exchange]) {
                break;
            } else {
                int current = data[position];
                data[position] = data[exchange];
                data[exchange] = current;
                position = exchange;
            }
        }
    }

    /**
     * 基础堆排序：时间复杂度为nlogn，因为无论是insert()还是remove()背后的逻辑复杂度都是logn，对n个元素的操作就是nlogn
     *
     * @param arr 需要被排序的数组
     * @param n   数组的大小
     */
    public static void heapSort1(int[] arr, int n) {
        // 1、将要被排序的数组放入堆结构中
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        // 2、将堆中的元素按顺序取出。
        // 因为创建的是最大堆，每次取出的都是当前堆的最大值，因此如果按照顺序赋值到数组中就是从高到低的顺序，因此要从后往前赋值，即从n-1的位置往0的方向开始赋值即可
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Heapify
     * 基于基础堆排序的优化：时间复杂度为O(n)
     * （1）前置条件：堆数组从索引1的位置开始存储元素。
     * （2）整个过程的逻辑是先将数据放入数组中构建最大堆，然后再逐个取出完成排序。取出的过程没有可以改造的，但是构建堆的过程其实可以优化
     * 优化逻辑就是：完全二叉树想变成最大堆，那肯定是针对那些有子节点的节点进行最大堆逻辑的转换。而完全二叉树中(数组)索引最大的具有叶子节点的索引值为整个数组大小的1/2，即count/2。
     * 很好理解，因为count就是整个数组的最后一个节点，除以2就是其父节点，最后一个节点的父节点那就是整个堆中最后一个具有子节点的节点。
     * 然后就从该节点开始通过shiftdown的方式将其放入合适的位置，直到最终的根节点。这样就把该堆中所有具有子节点的节点都进行了最大堆逻辑的转换。
     * tips：以上的过程其实简单理解为将每个节点视为根节点的一个堆，然后对每个子堆进行shiftdown操作那么最后就是对整个堆的shiftdown操作，相当于分治法~
     * （3）比基础堆排序优化的点就是不需要对没有叶子节点的节点也进行最大堆的逻辑处理，减少了无用的操作处理过程。
     */
    MaxHeap(int[] arr, int n) {
        // 1、初始化堆数组，放入元素
        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            // 堆数组从1开始
            data[i + 1] = arr[i];
        }
        count = n;
        // 2、从索引位置为count/2的位置开始进行shiftdown()操作
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    /**
     * 原地堆排序，优化空间复杂度
     *
     * @param arr 给定数组
     * @param n   数组中元素数量
     */
    public static void heapSort(int[] arr, int n) {
        // 1、元素放入堆数组中，即一次heapify操作，将每一个具有子节点的节点进行shiftdown()操作，使得堆称为最大堆
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        // 2、排序
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆的最大值与当前i所在位置的元素互换，即相当于将当前堆的最大值放入到当前堆的最后一个位置
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 对当前0索引位置的元素进行shiftdown操作。注意因为当前数组中最后的元素已经是排序好的元素，所以此部分元素不需要进行shiftdown操作，每次就从剩余的i个元素中形成的堆进行shiftdown操作
            shiftDown(arr, i, 0);
        }
        /*for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }

    /**
     * 针对指定长度的数组，对其索引为k位置的元素进行shiftdown操作
     *
     * @param arr      给定数组（注意，数组从0开始存数据，与之前的从1开始存数据不同）
     * @param count    给定数组的元素个数
     * @param position 对索引位置的元素进行shiftdown操作
     */
    private static void shiftDown(int[] arr, int count, int position) {
        // 只要当前索引位置拥有左节点，则意味着当前节点没有抵达叶子节点，就需要判断该元素是否需要继续下移。不需要判断右节点就是因为完全二叉树的性质都是左侧聚簇的，不可能存在只有右节点没有左节点
        // 另外限制了在arr数组中只针对索引从0开始到第count-1个元素进行堆的shiftdown操作即可，count开始及其后面的元素已经按照升序排好，不能参与shiftdown操作了
        while (position * 2 + 1 < count) {
            // 1、当前position位置的元素与其左右节点更大的元素比较，小的话换位置；否则不需要处理，循环结束。
            int left = position * 2 + 1;
            int right = left + 1;
            // 当前position位置的元素要和左右哪个节点进行位置交换，默认是左节点因为完全二叉树只要有子节点必然有左侧节点
            int exchange = left;
            // 如果存在右节点且右节点比左节点大
            if (right < count && arr[right] > arr[left]) {
                exchange = right;
            }
            // 2、如果当前position节点位置的元素比最大的子节点还大，那么就不需要处理，否则的话交换2个元素的位置即可
            if (arr[position] >= arr[exchange]) {
                break;
            } else {
                int current = arr[position];
                arr[position] = arr[exchange];
                arr[exchange] = current;
                position = exchange;
            }
        }
    }

}
