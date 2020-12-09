package com.learn.java;

import lombok.Data;

/**
 * 银行信息
 */
@Data
public class BankInfo {

    /**
     * 银行缩写
     */
    private String bankAbbreviation;
    /**
     * 主行联行号
     */
    private String bankCode;
    /**
     * 主行名称
     */
    private String bankName;
    /**
     * 卡类型 1:借记卡 2:贷记卡， 其他值：未识别
     */
    private String cardType;

}