package com.hand.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dto.Customer;
import com.hand.mapper.AddressMapper;
import com.hand.service.CustomerService;

public class Step4 {
	public static void main(String[] args) {
		ApplicationContext atx = new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
		CustomerService customerService = atx.getBean(CustomerService.class);
		AddressMapper addressMapper = atx.getBean(AddressMapper.class);
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		customer.setStoreId((byte) 1);
		System.out.print("please enter first_name:");
		customer.setFirstName(scanner.nextLine());
		System.out.print("please enter last_name:");
		customer.setLastName(scanner.nextLine());
		System.out.print("please enter email:");
		customer.setEmail(scanner.nextLine());
		System.out.print("please enter address_id:");
		short addressId;
		while( addressMapper.count(addressId = scanner.nextShort()) == 0 )
			System.out.print("address_id "+ addressId +" not exist, please enter address_id again:");
		customer.setAddressId(addressId);
		customerService.insertSelective(customer);
		List<Customer> customers = customerService.select(customer);
		for( Customer c : customers ){
			System.out.println(c.getCustomerId()+ "," + c.getFirstName()+ "," + c.getLastName() + "," + c.getEmail()
			+"," + c.getAddressId() + "," + c.getCreateDate());
		}
		System.out.println("请输入要删除的Customer 的ID:");
		short customerId = 0;
		try{
			while( customerService.countById(customerId = scanner.nextShort()) == 0 )
			System.out.print("你输入的ID 为"+ customerId + "的Customer不存在, 请重新输入:");
		}catch(Exception e){
			System.out.println("存在外键关联");
		}
		if(customerService.deleteById(customerId) == 1){
			System.out.println("你输入的ID 为"+ customerId +" 的Customer 已经 删除.");
		}
	}
}
