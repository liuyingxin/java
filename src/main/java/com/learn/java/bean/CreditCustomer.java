package com.uxin.fin.web.sp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("credit_customer")
public class CreditCustomer {

    /**
     * 授信客户自增id
     */
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    /**
     * 客户姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 客户电话
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 购车城市
     */
    @TableField("city_id")
    private Integer cityId;

    /**
     * 客户性别(1：男，2：女)
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 客户身份证
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 文化程度(1:小学; 2:初中; 3:高中; 4:大专; 5:大学本科; 6:技术学校；7:中专；8:硕士；9:博士)
     */
    @TableField("education_level")
    private Integer educationLevel;

    /**
     * 家庭住址
     */
    @TableField("home_address")
    private String homeAddress;

    /**
     * 用户银行账户
     */
    @TableField("bank_account")
    private String bankAccount;

    /**
     * 用户银行预留电话
     */
    @TableField("bank_mobile")
    private String bankMobile;

    /**
     * 单位性质(1:国家行政单位;2:事业单位;3:国有企业;4:外资企业;5:合资企业;6:私营企业;7:个体户;8:无业;)
     */
    @TableField("company_property")
    private Integer companyProperty;

    /**
     * 婚姻状况 ( 1:未婚; 2:已婚; 3:离异; 4:丧偶; 5:已婚有子女; 6:已婚无子女)
     */
    @TableField("marital_status")
    private Integer maritalStatus;

    /**
     * 配偶姓名
     */
    @TableField("spouse_name")
    private String spouseName;

    /**
     * 配偶手机号
     */
    @TableField("spouse_mobile")
    private String spouseMobile;

    /**
     * 配偶身份证
     */
    @TableField("spouse_id_card")
    private String spouseIdCard;

    /**
     * 月收入
     */
    @TableField("monthly_income")
    private BigDecimal monthlyIncome;

    /**
     * 单位名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 单位电话
     */
    @TableField("company_mobile")
    private String companyMobile;

    /**
     * 户籍地--省code
     */
    @TableField("domicile_province_code")
    private Integer domicileProvinceCode;

    /**
     * 户籍地--省名称
     */
    @TableField("domicile_province_name")
    private String domicileProvinceName;

    /**
     * 户籍地--市code
     */
    @TableField("domicile_city_code")
    private Integer domicileCityCode;

    /**
     * 户籍地--市名称
     */
    @TableField("domicile_city_name")
    private String domicileCityName;

    /**
     * 居住地--省code
     */
    @TableField("habitation_province_code")
    private Integer habitationProvinceCode;

    /**
     * 居住地--省名称
     */
    @TableField("habitation_province_name")
    private String habitationProvinceName;

    /**
     * 居住地--市code
     */
    @TableField("habitation_city_code")
    private Integer habitationCityCode;

    /**
     * 居住地--市名称
     */
    @TableField("habitation_city_name")
    private String habitationCityName;

    /**
     * 居住地--区code
     */
    @TableField("habitation_area_code")
    private Integer habitationAreaCode;

    /**
     * 居住地--区名称
     */
    @TableField("habitation_area_name")
    private String habitationAreaName;
    /**
     * 居住地--街道
     */
    @TableField("habitation_street")
    private String habitationStreet;
    /**
     * 居住地--详细地址
     */
    @TableField("habitation_address")
    private String habitationAddress;

    /**
     * 单位地--省code
     */
    @TableField("company_province_code")
    private Integer companyProvinceCode;

    /**
     * 单位地--省名称
     */
    @TableField("company_province_name")
    private String companyProvinceName;

    /**
     * 单位地--市code
     */
    @TableField("company_city_code")
    private Integer companyCityCode;

    /**
     * 单位地--市名称
     */
    @TableField("company_city_name")
    private String companyCityName;

    /**
     * 单位地--区code
     */
    @TableField("company_area_code")
    private Integer companyAreaCode;

    /**
     * 单位地--区名称
     */
    @TableField("company_area_name")
    private String companyAreaName;

    /**
     * 单位地--详细地址
     */
    @TableField("company_address")
    private String companyAddress;

    /**
     * 删除标记 0：删除 1：正常
     */
    @TableField("valid")
    private Integer valid;

    /**
     * 备注信息
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

}