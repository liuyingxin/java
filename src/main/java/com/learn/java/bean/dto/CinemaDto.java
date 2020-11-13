package com.learn.java.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CinemaDto {
    
    @ApiModelProperty(value = "${column.comment}",required = true)
    private Integer id;
    
    @ApiModelProperty(value = "${column.comment}",required = true)
    private String movie;
    
    @ApiModelProperty(value = "${column.comment}",required = true)
    private String description;
    
    @ApiModelProperty(value = "${column.comment}",required = true)
    private Object rating;


}