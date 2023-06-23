package com.wp.main.algorithm.AlgorithmAndDataStructures.heapAlgorithm;

/**
 * @Description 索引堆（最大堆）
 * @Author admin
 * @Date 2023/4/14 15:42
 */
public class IndexMaxHeap {
    // 存储堆数据的数组
    private int[] data;
    // 存储索引的数组
    private int[] indexes;
    // 堆(数组)中元素个数
    private int count;
    // 堆(数组)的容量
    private int capacity;

    /**
     * 构造函数创建堆，传入数组大小，用于数组的初始化
     *
     * @param capacity 堆的容量
     */
    public IndexMaxHeap(int capacity) {
        // +1是因为我们的堆从索引为1的位置开始存储数据，这样可以和节点的序号对应上~
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
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
     * @param i    插入元素的索引
     * @param item 待插入的元素
     */
    public void insert(int i, int item) {
        // 防止超过容量
        if (capacity >= count + 1 && i + 1 >= 1 && i + 1 <= capacity) {
            throw new RuntimeException("容量已达上限，无法继续插入数据");
        }
        // 外部使用时从0开始，内部使用从1开始，因此消除此差异需要i+1；
        i++;
        // 1、元素放入到数组中(最后一个元素的后面)，数据放入data数组，索引加入到indexes数组
        data[i] = item;
        indexes[count + 1] = i;
        // 容量+1
        count++;
        // 2、移动新增的元素至合适的位置，保证最大完全堆的性质
        shiftUp(count);
    }

    /**
     * 向上移动新增的元素，移动indexes索引数组的元素
     *
     * @param position 新增元素所在的位置
     */
    private void shiftUp(int position) {
        // 如果当前位置的元素比父节点大，那么就交换当前节点和父节点的位置。按照此逻辑不断的移动新增的元素直到合适的位置即可。
        // 防止数组越界等问题需要判断当前位置如果已经是数的根节点那么循环终止
        // 注意：索引堆比较值得大小，比较完成后交换的是index索引位置
        while (position > 1 && data[indexes[position / 2]] < data[indexes[position]]) {
            int temp = indexes[position / 2];
            indexes[position / 2] = indexes[position];
            indexes[position] = temp;
            // 移动过程中修改新增元素当前所在的最新位置
            position = position / 2;
        }
    }

    /**
     * 移出元素(根节点元素)，返回元素的索引值
     *
     * @return 返回根节点元素
     */
    public int removeIndex() {
        // 数组不为空才可以移出
        if (count > 0) {
            // 取出根元素索引并返回，由于堆从1开始存储数据，但返回时要按照标准数组存储逻辑进行处理，因此要进行-1操作
            int currentRootIndex = indexes[1] - 1;
            // 将最后一个节点移动到根节点
            indexes[1] = indexes[count];
            count--;
            // 移动新的根节点，将其放入到合适的位置保证最大完全堆的性质
            shiftDown(1);
            return currentRootIndex;
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
            if (right <= count && data[indexes[right]] > data[indexes[left]]) {
                exchange = right;
            }
            // 2、如果当前position节点位置的元素比最大的子节点还大，那么就不需要处理，否则的话交换2个元素的位置即可
            if (data[indexes[position]] >= data[indexes[exchange]]) {
                break;
            } else {
                int current = indexes[position];
                indexes[position] = indexes[exchange];
                indexes[exchange] = current;
                position = exchange;
            }
        }
    }

    /**
     * 获取任一索引位置的元素
     *
     * @param i 索引
     * @return 该索引对应位置的元素
     */
    public int getData(int i) {
        return data[i + 1];
    }

    /**
     * 将指定索引i位置的元素替换成newData
     *
     * @param i       指定位置的元素
     * @param newData 要替换的元素
     */
    public void change(int i, int newData) {
        // 堆从1开始存储，外部用户使用的时候还是默认从1开始，因此要做转换
        i++;
        // 元素替换
        data[i] = newData;
        // 保证堆结构要进行shiftup和shiftdown操作
        // 对data数组中的i操作其实就是找到indexes数组中i所在的位置，然后对其进行shiftup和shiftdown
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                break;
            }
        }

    }
}
