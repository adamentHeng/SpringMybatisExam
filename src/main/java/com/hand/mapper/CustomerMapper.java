package com.hand.mapper;

import java.util.List;

import com.hand.dto.Customer;

public interface CustomerMapper {
    void insertSelective(Customer customer);
    List<Customer> select(Customer customer);
    Integer countById(Short customerId);
    Integer deleteById(Short customerId);
}