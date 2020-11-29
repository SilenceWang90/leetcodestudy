package com.wp.main.algorithm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wp.main.leetcode.common.BiddingSupplierInfo;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @Classname RecursiveAlgorithm
 * @Description 递归算法
 * 递归的三要素(递归函数A，1,2代表递归次数)：
 * 1、明确递归终止条件，即递归深度。如果没有终止条件将无限递归导致堆栈溢出。终止条件一般都是方法体最先判断的代码
 * 2、递归方法要做什么处理，每次递归所有的处理方式都应相同（这一点一般是递归逻辑最复杂的点）：可以简单的把递归就是当做一个方法的调用，你调用这个方法要做什么，通常只
 * 需要2层递归(A1,A2)，即可把当前递归函数的逻辑全部整理出来。
 * 3、给出递归终止时的处理办法：其实就是上一层调用下一层，下一层结束后返回，上一层要做什么处理：简说就是A1调用A2，A2结束返回，A1要做什么处理。
 * <p>
 * <p>
 * 如下例子就是：
 * 1、递归函数要做的内容：每次递归就是遍历当前可选的数字，并通过for循环选择一个数字放入堆栈
 * 2、终止条件：只要堆栈不满足需要的深度，那么就继续递归选择，直到堆栈深度满足要求，递归结束。
 * 3、递归结束处理：下一层递归结束返回，是因为堆栈满足深度条件，为了继续遍历选择其他组合，要将堆栈头部的数据抛出
 * @Date 2020/11/23 15:12
 * @Created by wangpeng116
 */
public class RecursiveAlgorithm {

    private static BigDecimal optimal;

    public static void main(String[] args) {
        BiddingSupplierInfo sup1 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(10)).setSectionId("标段一");
        BiddingSupplierInfo sup2 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(12)).setSectionId("标段一");
        BiddingSupplierInfo sup3 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(29)).setSectionId("标段一");
        BiddingSupplierInfo sup4 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(37)).setSectionId("标段一");
        BiddingSupplierInfo sup5 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(8)).setSectionId("标段一");
        BiddingSupplierInfo sup6 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(24)).setSectionId("标段一");
        BiddingSupplierInfo sup7 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段一");
        BiddingSupplierInfo sup8 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段一");
        BiddingSupplierInfo sup9 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段一");
        BiddingSupplierInfo sup46 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段一");
        BiddingSupplierInfo sup47 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段一");

        BiddingSupplierInfo sup10 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup11 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup12 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup13 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup14 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup15 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup16 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup17 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup18 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup48 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup49 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");

        BiddingSupplierInfo sup19 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(8)).setSectionId("标段三");
        BiddingSupplierInfo sup20 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(10)).setSectionId("标段三");
        BiddingSupplierInfo sup21 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup22 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup23 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup24 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup25 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup26 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("21供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup27 = new BiddingSupplierInfo().setSupplierId("22").setSupplierName("22供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup50 = new BiddingSupplierInfo().setSupplierId("23").setSupplierName("23供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup51 = new BiddingSupplierInfo().setSupplierId("24").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");

        BiddingSupplierInfo sup28 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup29 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup30 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup31 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup32 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup33 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup34 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup35 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup36 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup52 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup53 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");

        BiddingSupplierInfo sup37 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup38 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup39 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup40 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup41 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup42 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup43 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup44 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup45 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup54 = new BiddingSupplierInfo().setSupplierId("26").setSupplierName("26供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup55 = new BiddingSupplierInfo().setSupplierId("27").setSupplierName("27供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");

        //数据集合
//        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3, sup4, sup5, sup6, sup7, sup8, sup9
//                , sup10, sup11, sup12, sup13, sup14, sup15, sup16, sup17, sup18
//                , sup19, sup20, sup21, sup22, sup23, sup24, sup25, sup26, sup27
//                , sup28, sup29, sup30, sup31, sup32, sup33, sup34, sup35, sup36
//                , sup37, sup38, sup39, sup40, sup41, sup42, sup43, sup44, sup45
//                , sup46, sup47, sup48, sup49, sup50, sup51, sup52, sup53, sup54, sup55);
        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3, sup4
                , sup10, sup16, sup17, sup18);
        //已选集合(堆栈，因为我们为了让选择[1,2][1,3][1,n]组合，就必须在每次递归结束后清除栈顶数据，这样才能保证找出所有需要选择的数据)
        Deque<BiddingSupplierInfo> selectedStack = Lists.newLinkedList();
        //结果集合
        List<List<BiddingSupplierInfo>> result = Lists.newArrayList();
        //初始从第一个位置开始
        long start = System.currentTimeMillis();
        //最优解(金额或得分)
        optimal = BigDecimal.valueOf(-1);
        /**满足供应商要求的判断所需要的数据组合**/
        //1、用于判断供应商是否有重复
        Map<String, String> selectedSupplierIdMap = Maps.newHashMap();
        //2、用于判断各标段数量是否满足拟中标单位数的数量
        Map<String, Integer> proposedBidNum = Maps.newHashMap();
        proposedBidNum.put("标段一", 3);
        proposedBidNum.put("标段二", 1);
        Map<String, Integer> currentProposedBidNum = Maps.newHashMap();
        currentProposedBidNum.put("标段一", 0);
        currentProposedBidNum.put("标段二", 0);
        calculate(0, 4, list.size(), selectedStack, list, result, selectedSupplierIdMap, proposedBidNum, currentProposedBidNum);
        long end = System.currentTimeMillis();
        System.out.println(result.size());
        System.out.println("执行时长：" + (end - start) + "毫秒");
        for (List<BiddingSupplierInfo> obj : result) {
            System.out.println(obj.toString());
        }
        System.out.println("最优价格是：" + optimal);
    }

    /**
     * 思路：递归
     * （1）递归终点：选择到了足够的供应商
     * （2）每个递归要做的事情：从begin到n(队列长度)之间选择供应商
     * （3）递归结束后：清除栈顶数据用于当前递归下一次遍历选择数据(不清除，已选择的栈就一直是满的，选不到新的组合)
     *
     * @param begin                 起始位置，从begin到队列长度之间选一个数据
     * @param select                要选出几个数据
     * @param n                     数据总量
     * @param selectedStack         当前遍历已选的供应商数量
     * @param list                  所有供应商数据
     * @param selectedSupplierIdMap 保存已选择的供应商id，在插入队列前判断是否重复
     * @param result                选出的组合结果
     */
    public static void calculate(int begin, int select, int n, Deque<BiddingSupplierInfo> selectedStack
            , List<BiddingSupplierInfo> list, List<List<BiddingSupplierInfo>> result, Map<String, String> selectedSupplierIdMap
            , Map<String, Integer> proposedBidNum, Map<String, Integer> currentProposedBidNum) {
        //选到了足够的供应商，则加入到最终队列中作为结果集的数据
        if (selectedStack.size() == select) {
            List<BiddingSupplierInfo> selectedList = Lists.newArrayList(selectedStack);
            //符合规则放入结果集中
            /*if (shotDemand(selectedList, select)) {
                //清除上一个结果，只保留最优解
                result.clear();
                result.add(selectedList);
            }*/
            result.add(selectedList);
            return;
        }
        //未选择足够供应商，继续从begin到剩余可选(总数量n+1与未选数量的差值)之间选择。
        //剪枝1：不用遍历到n是因为如果从begin开始到结尾还剩不足需要组合的供应商数量可选，那么就没必要继续循环
        for (int i = begin; i < n + 1 - (select - selectedStack.size()); i++) {
            //当前获取供应商信息
            BiddingSupplierInfo currentSupplier = list.get(i);
            //剪枝2：如果已选的供应商中存在了当前供应商id，则不需要继续选择了
            if (selectedSupplierIdMap.containsKey(currentSupplier.getSupplierId())) {
                continue;
            }
            //剪枝3：如果不重复，判断标段中拟中标单位数是否超过标准
            if ((currentProposedBidNum.get(currentSupplier.getSectionId()) + 1) > proposedBidNum.get(currentSupplier.getSectionId())) {
                continue;
            }
            //切记要等所有判断都做完了再处理，不能做一步处理一步，不然是逻辑bug哦~~
            //如果没有重复，则放入map和堆栈中，map的值随意。
            selectedSupplierIdMap.put(currentSupplier.getSupplierId(), "");
            //如果没有超过各标段拟入围单位数量则加入统计
            currentProposedBidNum.put(currentSupplier.getSectionId(), currentProposedBidNum.get(currentSupplier.getSectionId()) + 1);
            selectedStack.push(currentSupplier);
            calculate(i + 1, select, n, selectedStack, list, result, selectedSupplierIdMap, proposedBidNum, currentProposedBidNum);
            //下层递归结束后，清除栈顶数据用于末级递归下一次数据选择(否则堆栈一直是满的无法选到新的组合)
            selectedStack.pop();
            //下层递归结束后，清除当前参与递归的供应商id
            selectedSupplierIdMap.remove(currentSupplier.getSupplierId());
            //下层递归结束后，减去当前参与递归供应商所属标段的拟中标单位数量
            currentProposedBidNum.put(currentSupplier.getSectionId(), currentProposedBidNum.get(currentSupplier.getSectionId()) - 1);
        }
    }

    /**
     * 判断内容：先判断好判断的，依次去找不好判断的。这样效率高！！！！！！
     *
     * @param selectedStack
     * @param select
     * @return
     */
    private static boolean shotDemand(List<BiddingSupplierInfo> selectedStack, int select) {
        //1、废弃判断是否有重复：按照id分组的map容量不等于应选组合数量，则肯定是有重复，不需要放入结果集队列中
        //已通过剪枝方式优化
        /*if (selectedStack.stream().collect(Collectors.groupingBy(BiddingSupplierInfo::getSupplierId)).size() != select) {
            return false;
        }*/
        //2、todo：各标段供应商数量不正确
        /*if(){
            return false;
        }*/
        //3、todo：组合价格小于等于当前最优价格。
        BigDecimal currentPrice = selectedStack.stream().map(BiddingSupplierInfo::getPrice).reduce(BigDecimal::add).get();
        if (optimal.compareTo(BigDecimal.valueOf(-1)) == 0) {
            optimal = currentPrice;
        } else if (currentPrice.compareTo(optimal) >= 0) {
            return false;
        }
        optimal = currentPrice;
        return true;
    }

}
