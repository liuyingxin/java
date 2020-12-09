package com.learn.java.bean;

import com.learn.java.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeanMapper {

    BeanMapper MAPPER = Mappers.getMapper(BeanMapper.class);

    CustomerVo toCustomerVo(Customer customer);

    List<CustomerVo> toCustomerListVo(List<Customer> customer);
}
