package com.learn.java.api;

import com.learn.java.bean.CustomerVo;
import com.learn.java.bean.dto.ListDto;
import com.learn.java.response.ApiResult;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.learn.java.bean.dto.CustomerDto;

import java.util.List;

@Api(tags = "Api信息模块")
@RequestMapping(value = "/customer")
@Validated
public interface CustomerApi {
    @ApiOperation("分页查询列表")
    @PostMapping("/lists")
    ApiResult<List<CustomerVo>> getMyList(@RequestBody ListDto listDto);

    @ApiOperation("新增数据")
    @PostMapping("addInfomation")
    ApiResult<CustomerVo> addInfomation(@RequestBody CustomerDto customerDto);

    @ApiOperation("修改数据")
    @PostMapping("updateInfomation")
    ApiResult<CustomerVo> updateInfomation(@RequestBody CustomerDto customerDto);

    @ApiOperation("通过id查询详情")
    @GetMapping("selectInfomationById/{id}")
    ApiResult<CustomerVo> selectInfomationById(@ApiParam(value = "ID", example = "1", required = true)
                                  @NotNull @PathVariable Integer id);

    @ApiOperation("通过id删除数据")
    @PostMapping("deleteInfomation")
    ApiResult<CustomerVo> deleteInfo(@ApiParam(value = "ID", example = "1", required = true)
                                     @NotNull @PathVariable Integer id);

}