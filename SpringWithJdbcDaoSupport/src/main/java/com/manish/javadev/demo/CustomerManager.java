package com.manish.javadev.demo;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.manish.javadev.service.CustomerService;
import com.manish.javadev.to.CustomerTO;

public class CustomerManager {

	public static void main(String[] args) throws Exception {

		CustomerTO cust = null;
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"Spring-Context.xml");

		CustomerService customerService = (CustomerService) ctx
				.getBean("customerservice");

		// Add Operation
		CustomerTO custo1 = new CustomerTO(1, "Manish SE", "Srivastava", 27,
				"LKO");
		CustomerTO custo2 = new CustomerTO(2, "Divya SE", "Srivastava", 24,
				"LKO");
		CustomerTO custo3 = new CustomerTO(3, "Ajay PCS", "Srivastava", 34,
				"LKO");
		CustomerTO custo4 = new CustomerTO(4, "Pawan Lead", "Vishnoi", 27,
				"LKO");
		CustomerTO custo5 = new CustomerTO(5, "Rajesh Lead", "Srivastava", 34,
				"LKO");
		CustomerTO custo6 = new CustomerTO(6, "Ashish", "Srivastava", 32, "LKO");
		CustomerTO custo7 = new CustomerTO(7, "Dinesh", "Srivastava", 55, "LKO");

		customerService.addCustomer(custo1);
		customerService.addCustomer(custo2);
		customerService.addCustomer(custo3);
		customerService.addCustomer(custo4);
		customerService.addCustomer(custo5);
		customerService.addCustomer(custo6);
		customerService.addCustomer(custo7);
		System.out.println("Add Customer Operation Done");
		System.out.println("======================");

		// Add Operation
		custo1 = new CustomerTO(11, "Manish SE", "Srivastava", 27, "LKO");
		custo2 = new CustomerTO(22, "Divya SE", "Srivastava", 24, "LKO");
		custo3 = new CustomerTO(33, "Ajay PCS", "Srivastava", 34, "LKO");
		custo4 = new CustomerTO(44, "Pawan Lead", "Vishnoi", 27, "LKO");
		custo5 = new CustomerTO(55, "Rajesh Lead", "Srivastava", 34, "LKO");
		custo6 = new CustomerTO(66, "Ashish", "Srivastava", 32, "LKO");
		custo7 = new CustomerTO(77, "Dinesh", "Srivastava", 55, "LKO");

		customerService.addCustomerWithPreparedStatementCreateor(custo1);
		customerService.addCustomerWithPreparedStatementCreateor(custo2);
		customerService.addCustomerWithPreparedStatementCreateor(custo3);
		customerService.addCustomerWithPreparedStatementCreateor(custo4);
		customerService.addCustomerWithPreparedStatementCreateor(custo5);
		customerService.addCustomerWithPreparedStatementCreateor(custo6);
		customerService.addCustomerWithPreparedStatementCreateor(custo7);
		System.out.println("Add Customer Done");
		System.out.println("======================");

		// Retrieve Operation
		List<CustomerTO> list = customerService.getAllCustomer();
		System.out.println(list);
		System.out.println("Get All Customer Operation Done");
		System.out.println("======================");

		// Retrieve Operation
		cust = customerService.getCustomerById(4);
		System.out.println(cust);
		System.out.println("Get Customer By Id Operation Done");
		System.out.println("======================");

		// Update Operation
		cust = customerService.getCustomerById(4);
		System.out.println(cust);
		System.out.println("Update Customer By Id Operation Done");
		System.out.println("======================");

		// Delete Operation
		customerService.deleteCustomer(1);
		System.out.println("Delete Customer By Id Operation Done");
		System.out.println("======================");
	}
}