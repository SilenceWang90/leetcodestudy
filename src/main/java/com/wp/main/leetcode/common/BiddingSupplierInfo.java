package com.wp.main.leetcode.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Classname BiddingSupplierInfo
 * @Description 中标单位信息
 * @Date 2020/11/23 18:44
 * @Created by wangpeng116
 */
@Data
@Accessors(chain = true)
public class BiddingSupplierInfo {
    //供应商id
    private String supplierId;
    //供应商名称
    private String supplierName;
    //投标价格(专票即专票价格，普票即普票价格)
    private BigDecimal price;
    //标段id
    private String sectionId;
}
