package com.learn.java.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CinemaVo {

    @ApiModelProperty(value = "${column.comment}")
    private Integer id;

    @ApiModelProperty(value = "${column.comment}")
    private String movie;

    @ApiModelProperty(value = "${column.comment}")
    private String description;

    @ApiModelProperty(value = "${column.comment}")
    private Object rating;

}