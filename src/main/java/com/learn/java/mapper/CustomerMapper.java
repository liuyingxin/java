package com.learn.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import  com.learn.java.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 客户信息表(Customer)Mapper类
 *
 * @author mybatisplus_my
 * @since 2020-11-04 20:56:10
 */
@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

}