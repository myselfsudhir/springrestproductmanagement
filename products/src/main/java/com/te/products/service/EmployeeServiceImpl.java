package com.te.products.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.products.beans.EmployeeInfoBean;
import com.te.products.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired(required = false)
	EmployeeDAO dao;

	@Override
	public EmployeeInfoBean verification(int id, String Password) {
		// TODO Auto-generated method stub
		return dao.verification(id, Password);
	}
	
}
