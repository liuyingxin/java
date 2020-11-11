package com.learn.java.controller;

import com.learn.java.api.CustomerApi;
import com.learn.java.bean.CustomerVo;
import com.learn.java.bean.dto.CustomerDto;
import com.learn.java.bean.dto.ListDto;
import com.learn.java.entity.Customer;
import com.learn.java.mapper.CustomerMapper;
import com.learn.java.response.ApiResult;
import com.learn.java.service.CustomerService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ApiResult<List<CustomerVo>> getMyList(ListDto listDto) {
        return null;
    }

    @Override
    public ApiResult<CustomerVo> addInfomation(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return  ApiResult.success();
    }

    @Override
    public ApiResult<CustomerVo> updateInfomation(CustomerDto customerDto) {
        return null;
    }

    @Override
    public ApiResult<CustomerVo> selectInfomationById(@NotNull Integer id) {
        Customer customer = customerService.getById(id);
        CustomerVo customerVo = new CustomerVo();
        BeanUtils.copyProperties(customer, customerVo);
        return ApiResult.success(customerVo);
    }

    @Override
    public ApiResult<CustomerVo> deleteInfo(@NotNull Integer id) {
        return null;
    }
}