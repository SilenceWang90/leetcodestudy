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
        // 如果当前位置的元素比父节点小，那么就交换当前节点和父节点的位置。 按照此逻辑不断的移动新增的元素直到合适的位置即可。
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
     * 基础堆排序
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
        // 因为创建的是最大堆，因此如果正常取出的话顺序是从高到低；如果想从低到高取出那就将取出的元素从后往前放入数组中即可
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
