package com.learn.java.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ListDto {

    @ApiModelProperty(value = "页码，从1开始，默认1", example = "1")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页条数，默认10，最大50", example = "20")
    private Integer pageSize = 10;

}
