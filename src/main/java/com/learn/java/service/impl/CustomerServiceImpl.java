package com.learn.java.service.impl;

import com.learn.java.entity.Customer;
import com.learn.java.mapper.CustomerMapper;
import com.learn.java.service.CustomerService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 客户信息表(Customer)ServiceImpl类
 *
 * @author mybatisplus_my
 * @since 2020-11-04 20:56:10
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}