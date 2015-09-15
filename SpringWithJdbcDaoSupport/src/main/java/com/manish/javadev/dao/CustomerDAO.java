package com.manish.javadev.dao;

import java.util.List;
import com.manish.javadev.to.CustomerTO;

public interface CustomerDAO {
	void addCustomer(CustomerTO cust);
	
	void addCustomerWithPreparedStatementCreateor(CustomerTO cust);

	void updateCustomer(CustomerTO cust);

	void deleteCustomer(int custId);

	List<CustomerTO> getAllCustomer();

	CustomerTO getCustomerById(int custId);

}
