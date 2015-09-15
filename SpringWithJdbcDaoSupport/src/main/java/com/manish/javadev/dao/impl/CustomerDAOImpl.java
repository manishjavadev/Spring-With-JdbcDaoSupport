package com.manish.javadev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manish.javadev.dao.CustomerDAO;
import com.manish.javadev.helper.CustomerRowMapper;
import com.manish.javadev.to.CustomerTO;

public class CustomerDAOImpl extends JdbcDaoSupport implements CustomerDAO {

	//Without PreparedStatementCreator to Add Customer
	public void addCustomer(CustomerTO cust) {
		String sql = "insert into Customer values(?,?,?,?,?)";
		Object args[] = { cust.getCustId(), cust.getFirstName(),
				cust.getLastName(), cust.getAge(), cust.getCity() };
		getJdbcTemplate().update(sql, args);
	}

	//With PreparedStatementCreator to Add Customer
	public void addCustomerWithPreparedStatementCreateor(final CustomerTO cust) {

		final String sql = "insert into Customer values(?,?,?,?,?)";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, cust.getCustId());
				ps.setString(2, cust.getFirstName());
				ps.setString(3, cust.getLastName());
				ps.setInt(4, cust.getAge());
				ps.setString(5, cust.getCity());
				return ps;
			}
		};
		getJdbcTemplate().update(psc);
	}

	//Update Customer
	public void updateCustomer(CustomerTO cust) {
		String sql = "Update Customer set firstName=?,lastName=? where custId=?";
		Object args[] = { cust.getFirstName(), cust.getLastName(),
				cust.getCustId() };
		getJdbcTemplate().update(sql, args);

	}

	//Delete Customer By Id
	public void deleteCustomer(int custId) {
		String sql = "delete from customer where custid=?";
		Object args[] = { custId };
		getJdbcTemplate().update(sql, args);
	}

	//Get All Customer
	public List<CustomerTO> getAllCustomer() {
		String quiry = "Select * from Customer";
		return getJdbcTemplate().query(quiry, new CustomerRowMapper());
	}

	//Get Customer By Id
	public CustomerTO getCustomerById(int custId) {
		String sql = "Select * from Customer where custId=?";
		Object args[] = { custId };
		return (CustomerTO) getJdbcTemplate().queryForObject(sql, args,
				new CustomerRowMapper());
	}
}
