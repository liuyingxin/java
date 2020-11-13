package com.learn.java.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (Cinema)实体类
 *
 * @author mybatisplus_my
 * @since 2020-11-13 14:49:15
 */
@Data
@TableName("cinema")
public class Cinema {

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    @TableField("movie")
    private String movie;

    @TableField("description")
    private String description;

    @TableField("rating")
    private BigDecimal rating;

}