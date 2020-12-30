package com.learn.java.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.learn.java.bean.CustomerVo;
import com.learn.java.bean.dto.ListDto;
import com.learn.java.entity.Customer;
import com.learn.java.response.ApiResult;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = {"个人信息增删"})
@RequestMapping(value = {"/customer"})
public interface CustomerApi {
    @ApiOperation("分页查询列表")
    @PostMapping("/getList")
    ApiResult<PageInfo<CustomerVo>> getList(@Validated @RequestBody ListDto listDto);

    @ApiOperation("新增数据")
    @PostMapping("addInfomation")
    ApiResult<CustomerVo> addInfomation(@RequestBody @Validated(CustomerDto.ReturnCheck.class) CustomerDto c2);

    @ApiOperation("修改数据")
    @PostMapping("updateInfomation")
    ApiResult updateInfomation(@RequestBody CustomerDto c1);

    @ApiOperation("通过id查询详情")
    @GetMapping("selectInfomationById/{id}")
    ApiResult<CustomerVo> selectInfomationById(@ApiParam(value = "ID", example = "1", required = true)
                                               @NotNull @PathVariable Integer id);

    @ApiOperation("通过id删除数据")
    @PostMapping("deleteInfomation")
    ApiResult deleteInfo(@ApiParam(value = "ID", example = "1", required = true)
                         @NotNull @PathVariable Integer id);

    @ApiOperation(value = "数据导出")
    @PostMapping("/excel")
    void getExcel(@RequestBody List<Integer> ids, HttpServletResponse response);


}