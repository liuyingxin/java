package com.learn.java.bean;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户信息表(CreditCustomer)实体类
 *
 * @author liuying9
 * @since 2020-04-15 10:59:12
 */
@Data
public class CustomerVo {

    /**
     * 授信客户自增id
     */
    @Excel(name = "自增id", width = 10)
    private Integer id;

    /**
     * 客户姓名
     */
    @Excel(name = "客户姓名", width = 10, groupName = "客户信息")
    private String userName;

    /**
     * 客户电话
     */
    @Excel(name = "客户电话", width = 15, groupName = "客户信息")
    private String mobile;

    /**
     * 客户性别(1：男，2：女)
     */
    @Excel(name = "客户性别", width = 10,replace = {"_0","男_1","女_2"}, groupName = "客户信息")
    private Integer gender;

    /**
     * 客户身份证
     */
    @Excel(name = "客户身份证", width = 25, groupName = "客户信息")
    private String idCard;

    /**
     * 文化程度(1:小学; 2:初中; 3:高中; 4:大专; 5:大学本科; 6:技术学校；7:中专；8:硕士；9:博士)
     */
    @Excel(name = "文化程度", width = 10,replace = {"小学_1","初中_2","高中_3","大专_4","大学本科_5","技术学校_6","中专_7","硕士_8","博士_9"}, groupName = "客户信息")
    private Integer educationLevel;

    /**
     * 家庭住址
     */
    @Excel(name = "家庭住址", width = 10, groupName = "客户信息")
    private String homeAddress;

    /**
     * 用户银行账户
     */
    @Excel(name = "用户银行账户", width = 25, groupName = "客户信息")
    private String bankAccount;

    /**
     * 用户银行预留电话
     */
    @Excel(name = "用户银行预留电话", width = 25, groupName = "客户信息")
    private String bankMobile;

    /**
     * 单位性质(1:国家行政单位;2:事业单位;3:国有企业;4:外资企业;5:合资企业;6:私营企业;7:个体户;8:无业;)
     */
    @Excel(name = "单位性质", width = 10,replace = {"_0","国家行政单位_1","事业单位_2","国有企业_3","外资企业_4","合资企业_5","私营企业_6","个体户_7","无业_8"}, groupName = "客户信息")
    private Integer companyProperty;

    /**
     * 婚姻状况 ( 1:未婚; 2:已婚; 3:离异; 4:丧偶; 5:已婚有子女; 6:已婚无子女)
     */
    @Excel(name = "婚姻状况", width = 10,replace = {"未婚_1","已婚_2","离异_3","丧偶_4","已婚有子女_5","已婚无子女_6"}, groupName = "客户信息")
    private Integer maritalStatus;

    /**
     * 配偶姓名
     */
    @Excel(name = "配偶姓名", width = 10, groupName = "配偶信息")
    private String spouseName;

    /**
     * 配偶手机号
     */
    @Excel(name = "配偶手机号", width =25, groupName = "配偶信息")
    private String spouseMobile;

    /**
     * 配偶身份证
     */
    @Excel(name = "配偶身份证", width = 25, groupName = "配偶信息")
    private String spouseIdCard;

    /**
     * 月收入
     */
    @Excel(name = "月收入", width = 10, groupName = "配偶信息")
    private BigDecimal monthlyIncome;

    /**
     * 单位名称
     */
    @Excel(name = "单位名称", width = 10, groupName = "单位信息")
    private String companyName;

    /**
     * 单位电话
     */
    @Excel(name = "单位电话", width = 25, groupName = "单位信息")
    private String companyMobile;;

    /**
     * 更新时间
     */
    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss", width = 25, groupName = "时间信息")
    private Date updateTime;


}