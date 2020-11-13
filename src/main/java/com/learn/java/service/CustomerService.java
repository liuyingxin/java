package com.learn.java.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import  com.learn.java.entity.Customer;


/**
 * 客户信息表(Customer)Service类
 *
 * @author mybatisplus_my
 * @since 2020-11-04 20:56:10
 */
@DS("slave")
public interface CustomerService extends IService<Customer> {

}