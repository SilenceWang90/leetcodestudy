package com.wp.main.algorithm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wp.main.common.BiddingSupplierInfo;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @Classname OriginRecursiveAlgorithm
 * @Description 原始demo
 * @Date 2020/12/3 14:07
 * @Created by wangpeng116
 */
public class OriginRecursiveAlgorithm {
    private static BigDecimal optimal;

    public static void main(String[] args) {
        BiddingSupplierInfo sup1 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(10)).setSectionId("标段一");
        BiddingSupplierInfo sup2 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(12)).setSectionId("标段一");
        BiddingSupplierInfo sup3 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(14)).setSectionId("标段一");
        BiddingSupplierInfo sup4 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(25)).setSectionId("标段一");
        BiddingSupplierInfo sup5 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(8)).setSectionId("标段一");
        BiddingSupplierInfo sup6 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(24)).setSectionId("标段一");
        BiddingSupplierInfo sup7 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段一");
        BiddingSupplierInfo sup8 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段一");
        BiddingSupplierInfo sup9 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段一");
        BiddingSupplierInfo sup10 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(21.8)).setSectionId("标段一");
        BiddingSupplierInfo sup11 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup12 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup13 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup14 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup15 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup16 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup17 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup18 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup19 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup20 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");
        BiddingSupplierInfo sup21 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(19.0)).setSectionId("标段一");

        BiddingSupplierInfo sup22 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19.9)).setSectionId("标段二");
        BiddingSupplierInfo sup23 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(12.4)).setSectionId("标段二");
        BiddingSupplierInfo sup24 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(16.6)).setSectionId("标段二");
        BiddingSupplierInfo sup25 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(27)).setSectionId("标段二");
        BiddingSupplierInfo sup26 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(32.2)).setSectionId("标段二");
        BiddingSupplierInfo sup27 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(47)).setSectionId("标段二");
        BiddingSupplierInfo sup28 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(18)).setSectionId("标段二");
        BiddingSupplierInfo sup29 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(15.9)).setSectionId("标段二");
        BiddingSupplierInfo sup30 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(16)).setSectionId("标段二");
        BiddingSupplierInfo sup31 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(22.2)).setSectionId("标段二");
        BiddingSupplierInfo sup32 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(23.1)).setSectionId("标段二");
        BiddingSupplierInfo sup33 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(8)).setSectionId("标段二");
        BiddingSupplierInfo sup34 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(10)).setSectionId("标段二");
        BiddingSupplierInfo sup35 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup36 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup37 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup38 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup39 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup40 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("21供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup41 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("22供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");
        BiddingSupplierInfo sup42 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("23供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段二");

        BiddingSupplierInfo sup43 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup44 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup45 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup46 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup47 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup48 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup49 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup50 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup51 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup52 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup53 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段三");
        BiddingSupplierInfo sup54 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段三");
        BiddingSupplierInfo sup55 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段三");
        BiddingSupplierInfo sup56 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段三");
        BiddingSupplierInfo sup57 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段三");
        BiddingSupplierInfo sup58 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段三");
        BiddingSupplierInfo sup59 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段三");
        BiddingSupplierInfo sup60 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段三");
        BiddingSupplierInfo sup61 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段三");
        BiddingSupplierInfo sup62 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段三");
        BiddingSupplierInfo sup63 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段三");

        BiddingSupplierInfo sup66 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup67 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup68 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup69 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup70 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup71 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup72 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup73 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup74 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup75 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup76 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段四");
        BiddingSupplierInfo sup77 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段四");
        BiddingSupplierInfo sup78 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段四");
        BiddingSupplierInfo sup79 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段四");
        BiddingSupplierInfo sup80 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段四");
        BiddingSupplierInfo sup81 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段四");
        BiddingSupplierInfo sup82 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段四");
        BiddingSupplierInfo sup83 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段四");
        BiddingSupplierInfo sup84 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段四");
        BiddingSupplierInfo sup85 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段四");
        BiddingSupplierInfo sup86 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段四");

        BiddingSupplierInfo sup87 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup88 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup89 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup90 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup91 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup92 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup93 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup94 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup95 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup96 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup97 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段五");
        BiddingSupplierInfo sup98 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段五");
        BiddingSupplierInfo sup99 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段五");
        BiddingSupplierInfo sup100 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段五");
        BiddingSupplierInfo sup101 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段五");
        BiddingSupplierInfo sup102 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段五");
        BiddingSupplierInfo sup103 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段五");
        BiddingSupplierInfo sup104 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段五");
        BiddingSupplierInfo sup105 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段五");
        BiddingSupplierInfo sup106 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段五");
        BiddingSupplierInfo sup107 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段五");

        BiddingSupplierInfo sup108 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup109 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup110 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup119 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup120 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup121 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup122 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup123 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup124 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup125 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup126 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段六");
        BiddingSupplierInfo sup127 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段六");
        BiddingSupplierInfo sup128 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段六");
        BiddingSupplierInfo sup111 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段六");
        BiddingSupplierInfo sup112 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段六");
        BiddingSupplierInfo sup113 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段六");
        BiddingSupplierInfo sup114 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段六");
        BiddingSupplierInfo sup115 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段六");
        BiddingSupplierInfo sup116 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段六");
        BiddingSupplierInfo sup117 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段六");
        BiddingSupplierInfo sup118 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段六");

        BiddingSupplierInfo sup129 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup130 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup131 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup132 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup133 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup134 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup135 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup136 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup137 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup138 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup139 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段七");
        BiddingSupplierInfo sup140 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段七");
        BiddingSupplierInfo sup141 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段七");
        BiddingSupplierInfo sup142 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段七");
        BiddingSupplierInfo sup143 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段七");
        BiddingSupplierInfo sup144 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段七");
        BiddingSupplierInfo sup145 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段七");
        BiddingSupplierInfo sup146 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段七");
        BiddingSupplierInfo sup147 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段七");
        BiddingSupplierInfo sup148 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段七");
        BiddingSupplierInfo sup149 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段七");

        BiddingSupplierInfo sup150 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup151 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup152 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup153 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup154 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup155 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup156 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup157 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup158 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup159 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup160 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段八");
        BiddingSupplierInfo sup161 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段八");
        BiddingSupplierInfo sup162 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段八");
        BiddingSupplierInfo sup163 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段八");
        BiddingSupplierInfo sup164 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段八");
        BiddingSupplierInfo sup165 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段八");
        BiddingSupplierInfo sup166 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段八");
        BiddingSupplierInfo sup167 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段八");
        BiddingSupplierInfo sup168 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段八");
        BiddingSupplierInfo sup169 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段八");
        BiddingSupplierInfo sup170 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段八");

        BiddingSupplierInfo sup171 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup172 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup173 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup174 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup175 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup176 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup177 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup178 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup179 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup180 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup181 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段九");
        BiddingSupplierInfo sup182 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段九");
        BiddingSupplierInfo sup183 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段九");
        BiddingSupplierInfo sup184 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段九");
        BiddingSupplierInfo sup185 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段九");
        BiddingSupplierInfo sup186 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段九");
        BiddingSupplierInfo sup187 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段九");
        BiddingSupplierInfo sup188 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段九");
        BiddingSupplierInfo sup189 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段九");
        BiddingSupplierInfo sup190 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段九");
        BiddingSupplierInfo sup191 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段九");

        BiddingSupplierInfo sup192 = new BiddingSupplierInfo().setSupplierId("1").setSupplierName("24供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup193 = new BiddingSupplierInfo().setSupplierId("2").setSupplierName("1供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup194 = new BiddingSupplierInfo().setSupplierId("3").setSupplierName("2供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup195 = new BiddingSupplierInfo().setSupplierId("4").setSupplierName("3供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup196 = new BiddingSupplierInfo().setSupplierId("5").setSupplierName("4供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup197 = new BiddingSupplierInfo().setSupplierId("6").setSupplierName("5供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup198 = new BiddingSupplierInfo().setSupplierId("7").setSupplierName("6供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup199 = new BiddingSupplierInfo().setSupplierId("8").setSupplierName("7供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup200 = new BiddingSupplierInfo().setSupplierId("9").setSupplierName("8供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup201 = new BiddingSupplierInfo().setSupplierId("10").setSupplierName("9供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup202 = new BiddingSupplierInfo().setSupplierId("11").setSupplierName("19供应商").setPrice(BigDecimal.valueOf(19)).setSectionId("标段十");
        BiddingSupplierInfo sup203 = new BiddingSupplierInfo().setSupplierId("12").setSupplierName("20供应商").setPrice(BigDecimal.valueOf(33)).setSectionId("标段十");
        BiddingSupplierInfo sup204 = new BiddingSupplierInfo().setSupplierId("13").setSupplierName("10供应商").setPrice(BigDecimal.valueOf(15.5)).setSectionId("标段十");
        BiddingSupplierInfo sup205 = new BiddingSupplierInfo().setSupplierId("14").setSupplierName("11供应商").setPrice(BigDecimal.valueOf(17.6)).setSectionId("标段十");
        BiddingSupplierInfo sup206 = new BiddingSupplierInfo().setSupplierId("15").setSupplierName("12供应商").setPrice(BigDecimal.valueOf(10.9)).setSectionId("标段十");
        BiddingSupplierInfo sup207 = new BiddingSupplierInfo().setSupplierId("16").setSupplierName("13供应商").setPrice(BigDecimal.valueOf(13.3)).setSectionId("标段十");
        BiddingSupplierInfo sup208 = new BiddingSupplierInfo().setSupplierId("17").setSupplierName("14供应商").setPrice(BigDecimal.valueOf(30)).setSectionId("标段十");
        BiddingSupplierInfo sup209 = new BiddingSupplierInfo().setSupplierId("18").setSupplierName("15供应商").setPrice(BigDecimal.valueOf(28.1)).setSectionId("标段十");
        BiddingSupplierInfo sup210 = new BiddingSupplierInfo().setSupplierId("19").setSupplierName("16供应商").setPrice(BigDecimal.valueOf(13.2)).setSectionId("标段十");
        BiddingSupplierInfo sup211 = new BiddingSupplierInfo().setSupplierId("20").setSupplierName("17供应商").setPrice(BigDecimal.valueOf(17)).setSectionId("标段十");
        BiddingSupplierInfo sup212 = new BiddingSupplierInfo().setSupplierId("21").setSupplierName("18供应商").setPrice(BigDecimal.valueOf(22)).setSectionId("标段十");
        //数据集合
        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3, sup4, sup5, sup6, sup7, sup8, sup9
                , sup10, sup11, sup12, sup13, sup14, sup15, sup16, sup17, sup18
                , sup19, sup20, sup21, sup22, sup23, sup24, sup25, sup26, sup27
                , sup28, sup29, sup30, sup31, sup32, sup33, sup34, sup35, sup36
                , sup37, sup38, sup39, sup40, sup41, sup42, sup43, sup44, sup45
                , sup46, sup47, sup48, sup49, sup50, sup51, sup52, sup53, sup54, sup55
                , sup56, sup57, sup58, sup59, sup60, sup61, sup62, sup63, sup66, sup67
                , sup68, sup69, sup70, sup71, sup72, sup73, sup74, sup75, sup76, sup77
                , sup78, sup79, sup80, sup81, sup82, sup83, sup84, sup85, sup86, sup87
                , sup88, sup89, sup90, sup91, sup92, sup93, sup94, sup95, sup96, sup97
                , sup98, sup99, sup100, sup101, sup102, sup103, sup104, sup105, sup106, sup107
                , sup108, sup109, sup110, sup111, sup112, sup113, sup114, sup115, sup116, sup117
                , sup118, sup119, sup120, sup121, sup122, sup123, sup124, sup125, sup126, sup127
                , sup128, sup129, sup130, sup131, sup132, sup133, sup134, sup135, sup136, sup137
                , sup138, sup139, sup140, sup141, sup142, sup143, sup144, sup145, sup146, sup147
                , sup148, sup149, sup150, sup151, sup152, sup153, sup154, sup155, sup156, sup157
                , sup158, sup159, sup160, sup161, sup162, sup163, sup164, sup165, sup166, sup167
                , sup168, sup169, sup170, sup171, sup172, sup173, sup174, sup175, sup176, sup177
                , sup178, sup179, sup180, sup181, sup182, sup183, sup184, sup185, sup186, sup187
                , sup188, sup189, sup190, sup191, sup192, sup193, sup194, sup195, sup196, sup197
                , sup198, sup199, sup200, sup201, sup202, sup203, sup204, sup205, sup206, sup207
                , sup208, sup209, sup210, sup211, sup212);
//        List<BiddingSupplierInfo> list = Lists.newArrayList(sup1, sup2, sup3, sup4
//                , sup10, sup16, sup17, sup18);
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
        proposedBidNum.put("标段一", 1);
        proposedBidNum.put("标段二", 1);
        proposedBidNum.put("标段三", 1);
        proposedBidNum.put("标段四", 1);
        proposedBidNum.put("标段五", 1);
        proposedBidNum.put("标段六", 1);
        proposedBidNum.put("标段七", 1);
        proposedBidNum.put("标段八", 1);
        proposedBidNum.put("标段九", 1);
        proposedBidNum.put("标段十", 1);
        Map<String, Integer> currentProposedBidNum = Maps.newHashMap();
        currentProposedBidNum.put("标段一", 0);
        currentProposedBidNum.put("标段二", 0);
        currentProposedBidNum.put("标段三", 0);
        currentProposedBidNum.put("标段四", 0);
        currentProposedBidNum.put("标段五", 0);
        currentProposedBidNum.put("标段六", 0);
        currentProposedBidNum.put("标段七", 0);
        currentProposedBidNum.put("标段八", 0);
        currentProposedBidNum.put("标段九", 0);
        currentProposedBidNum.put("标段十", 0);
        calculate(0, 5, selectedStack, list, result, selectedSupplierIdMap, proposedBidNum, currentProposedBidNum);
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
     * @param selectedStack         当前遍历已选的供应商数量
     * @param list                  所有供应商数据
     * @param selectedSupplierIdMap 保存已选择的供应商id，在插入队列前判断是否重复
     * @param result                选出的组合结果
     */
    public static void calculate(int begin, int select, Deque<BiddingSupplierInfo> selectedStack
            , List<BiddingSupplierInfo> list, List<List<BiddingSupplierInfo>> result, Map<String, String> selectedSupplierIdMap
            , Map<String, Integer> proposedBidNum, Map<String, Integer> currentProposedBidNum) {
        //选到了足够的供应商，则加入到最终队列中作为结果集的数据
        if (selectedStack.size() == select) {
            List<BiddingSupplierInfo> selectedList = Lists.newArrayList(selectedStack);
            //符合规则放入结果集中
            if (shotDemand(selectedList)) {
                //清除上一个结果，只保留最优解
                result.clear();
                result.add(selectedList);
            }
            return;
        }
        //未选择足够供应商，继续从begin到剩余可选(总数量n+1与未选数量的差值)之间选择。
        //剪枝1：不用遍历到n是因为如果从begin开始到结尾还剩不足需要组合的供应商数量可选，那么就没必要继续循环
        for (int i = begin; i < list.size() + 1 - (select - selectedStack.size()); i++) {
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
            calculate(i + 1, select, selectedStack, list, result, selectedSupplierIdMap, proposedBidNum, currentProposedBidNum);
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
     * @param selectedList
     * @return
     */
    private static boolean shotDemand(List<BiddingSupplierInfo> selectedList) {
        //1、废弃判断是否有重复：按照id分组的map容量不等于应选组合数量，则肯定是有重复，不需要放入结果集队列中
        //已通过剪枝方式优化
        /*if (selectedList.stream().collect(Collectors.groupingBy(BiddingSupplierInfo::getSupplierId)).size() != select) {
            return false;
        }*/
        //2、todo：各标段供应商数量不正确
        /*if(){
            return false;
        }*/
        //3、组合价格小于等于当前最优价格。
        BigDecimal currentPrice = selectedList.stream().map(BiddingSupplierInfo::getPrice).reduce(BigDecimal::add).orElseGet(() -> BigDecimal.valueOf(-1));
        //第一个值为-1，所以直接赋值
        if (optimal.compareTo(BigDecimal.valueOf(-1)) == 0) {
            optimal = currentPrice;
        } else if (currentPrice.compareTo(optimal) >= 0) {
            return false;
        }
        optimal = currentPrice;
        return true;
    }
}
