package com.learn.java.bean;

import com.learn.java.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanMapper {
    BeanMapper MAPPER = Mappers.getMapper(BeanMapper.class);

    CustomerVo creditCustomerToDto(Customer customer);

}
