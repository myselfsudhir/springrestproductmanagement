package com.te.products.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.te.products.beans.EmployeeInfoBean;
import com.te.products.customexp.ProductException;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public EmployeeInfoBean verification(int id, String Password) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em = emf.createEntityManager();
		EmployeeInfoBean bean = em.find(EmployeeInfoBean.class, id);

		if (bean != null) {
			if (bean.getPassword().equals(Password)) {
				return bean;
			} else {
				throw new ProductException("password is worng");
			}
		}else {
			throw new ProductException("id is wrong");
		}
	
	}
	
}
