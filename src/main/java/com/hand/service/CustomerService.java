package com.hand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dto.Customer;
import com.hand.mapper.CustomerMapper;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	public void insertSelective(Customer customer){
		customerMapper.insertSelective(customer);
	}
	
    public List<Customer> select(Customer customer){
    	return customerMapper.select(customer);
    }
    
    public Integer countById(Short customerId){
    	return customerMapper.countById(customerId);
    }
    
    public Integer deleteById(Short customerId){
    	return customerMapper.deleteById(customerId);
    }
}
