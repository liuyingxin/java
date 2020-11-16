package com.learn.java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.java.api.CustomerApi;
import com.learn.java.bean.BeanMapper;
import com.learn.java.bean.CustomerVo;
import com.learn.java.bean.dto.CustomerDto;
import com.learn.java.bean.dto.ListDto;
import com.learn.java.cache.SimpleCache;
import com.learn.java.entity.Customer;
import com.learn.java.mapper.CustomerMapper;
import com.learn.java.response.ApiResult;
import com.learn.java.service.CustomerService;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 客户信息表(Customer)表控制层
 *
 * @author mybatisplus_my
 * @since 2020-11-04 20:56:10
 */

@RestController
public class CustomerController implements CustomerApi {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public ApiResult<PageInfo<CustomerVo>> getList(ListDto dto) {

        Page p = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        LambdaQueryWrapper<Customer> lambdaQueryWrapper = Wrappers.<Customer>lambdaQuery()
                .orderByDesc(Customer::getUpdateTime);

        List<Customer> iPage = customerService.list(lambdaQueryWrapper);
        PageInfo<CustomerVo> customerVoPageInfo = new PageInfo(iPage);
        return ApiResult.success(customerVoPageInfo);
    }

    @Override
    public ApiResult<CustomerVo> addInfomation(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return ApiResult.success();
    }

    @Override
    public ApiResult updateInfomation(CustomerDto customerDto) {
        Customer customer = null;
        BeanUtils.copyProperties(customerDto, customer);
        customerService.updateById(customer);
        return ApiResult.success();
    }

    @Override
    @SimpleCache(key = "customer", value = "{id}")
    public ApiResult<CustomerVo> selectInfomationById(@NotNull Integer id) {
        Customer customer = customerService.getById(id);
        CustomerVo customerVo = new CustomerVo();
        customerVo = BeanMapper.MAPPER.toCustomerVo(customer);
        return ApiResult.success(customerVo);
    }

    @Override
    public ApiResult deleteInfo(@NotNull Integer id) {
        customerService.removeById(id);
        return ApiResult.success();
    }
}