package com.wp.main.common;

import lombok.Data;

import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @Classname CalibrationCalculcationParam
 * @Description 定标推荐计算参数
 * @Date 2020/12/3 13:48
 * @Created by wangpeng116
 */
@Data
public class CalibrationCalculcationParam {
    //起始位置，从begin到队列长度之间选一个数据
    private int begin;
    //要选出几个数据
    private int select;
    //当前遍历已选的供应商数量
    private Deque<BiddingSupplierInfo> selectedStack;
    //所有参与计算的供应商数据
    private List<BiddingSupplierInfo> list;
    //选出的组合结果
    private List<List<BiddingSupplierInfo>> result;
    //保存已选择的供应商id，在插入队列前判断是否重复
    private Map<String, String> selectedSupplierIdMap;
    //每个标段应选供应商个数 key标段id，value供应商数量
    private Map<String, Integer> proposedBidNum;
    //每个标段已选供应商个数 key标段id，value供应商数量
    private Map<String, Integer> currentProposedBidNum;
}
