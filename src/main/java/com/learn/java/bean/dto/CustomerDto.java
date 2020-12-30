package com.learn.java.bean.dto;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CustomerDto {

    /**
     * 授信客户自增id"
     */
    @NotNull(message = "id不能为空", groups = {CustomerDto.ReturnCheck.class})
    private Integer id;

    /**
     * 客户姓名
     */

    @Pattern(regexp = "^[^\\s]*$", message = "客户姓名中，请不要输入多余空格")
    private String userName;

    /**
     * 客户电话
     */
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "请填写正确手机号")
    private String mobile;

    /**
     * 购车城市"
     */
    private Integer cityId;

    /**
     * 客户性别(1：男，2：女)"
     */
    private Integer gender;

    /**
     * 客户身份证"
     */
    private String idCard;

    /**
     * 文化程度(1:小学; 2:初中; 3:高中; 4:大专; 5:大学本科; 6:技术学校；7:中专；8:硕士；9:博士)"
     */
    private Integer educationLevel;

    /**
     * 家庭住址"
     */
    private String homeAddress;

    /**
     * 用户银行账户"
     */
    private String bankAccount;

    /**
     * 用户银行预留电话"
     */

    @Pattern(regexp = "^[0-9]*$", message = " 客户电话必须是纯数字，请仔细核对(是否含有多余空格等)")
    private String bankMobile;

    /**
     * 单位性质(1:国家行政单位;2:事业单位;3:国有企业;4:外资企业;5:合资企业;6:私营企业;7:个体户;8:无业;)"
     */
    private Integer companyProperty;

    /**
     * 婚姻状况 ( 1:未婚; 2:已婚; 3:离异; 4:丧偶; 5:已婚有子女; 6:已婚无子女)"
     */
    private Integer maritalStatus;

    /**
     * 配偶姓名"
     */
    private String spouseName;

    /**
     * 配偶手机号"
     */
    private String spouseMobile;

    /**
     * 配偶身份证"
     */
    private String spouseIdCard;

    /**
     * 月收入"
     */
    private Double monthlyIncome;

    /**
     * 单位名称"
     */
    private String companyName;

    /**
     * 单位电话"
     */
    private String companyMobile;

    /**
     * 户籍地--省code"
     */
    private Integer domicileProvinceCode;

    /**
     * 户籍地--省名称"
     */
    private String domicileProvinceName;

    /**
     * 户籍地--市code"
     */
    private Integer domicileCityCode;

    /**
     * 户籍地--市名称"
     */
    private String domicileCityName;

    /**
     * 居住地--省code"
     */
    private Integer habitationProvinceCode;

    /**
     * 居住地--省名称"
     */
    private String habitationProvinceName;

    /**
     * 居住地--市code"
     */
    private Integer habitationCityCode;

    /**
     * 居住地--市名称"
     */
    private String habitationCityName;

    /**
     * 居住地--区code"
     */
    private Integer habitationAreaCode;

    /**
     * 居住地--区名称"
     */
    private String habitationAreaName;

    /**
     * 居住地--街道"
     */
    private String habitationStreet;

    /**
     * 居住地--详细地址"
     */
    private String habitationAddress;

    /**
     * 单位地--省code"
     */
    private Integer companyProvinceCode;

    /**
     * 单位地--省名称"
     */
    private String companyProvinceName;

    /**
     * 单位地--市code"
     */
    private Integer companyCityCode;

    /**
     * 单位地--市名称"
     */
    private String companyCityName;

    /**
     * 单位地--区code"
     */
    private Integer companyAreaCode;

    /**
     * 单位地--区名称"
     */
    private String companyAreaName;

    /**
     * 单位地--详细地址"
     */
    private String companyAddress;

    /**
     * 删除标记 0：删除 1：正常"
     */
    private Integer valid;

    /**
     * 备注信息"
     */
    private String remark;

    /**
     * 创建时间"
     */
    private Date createTime;

    /**
     * 更新时间"
     */
    private Date updateTime;

    public interface ReturnCheck {

    }
}