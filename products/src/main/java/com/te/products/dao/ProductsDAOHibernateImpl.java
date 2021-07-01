package com.te.products.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.products.beans.Products;

public class ProductsDAOHibernateImpl implements ProductDAO{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public boolean deleteProductData(int id) {
		
		boolean isDeleted = false;
		try {
			et.begin();
			Products bean = em.find(Products.class, id);
			em.remove(bean);
			et.commit();
			isDeleted = true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}

		return isDeleted;
	}

	@Override
	public boolean addProduct(Products productInfoBean) {
		boolean isInserted = false;
		try {
			et.begin();
			em.persist(productInfoBean);
			et.commit();
			isInserted=true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return isInserted;
	}

	@Override
	public boolean updateRecord(Products productInfoBean) {
		boolean isUpdated = false;
		try {
			et.begin();
			Products actualInfo = em.find(Products.class, productInfoBean.getPid());

			if (productInfoBean.getPname() != null && productInfoBean.getPname() != "") {
				actualInfo.setPname(productInfoBean.getPname());
			}
			if (productInfoBean.getMgDate() != null) {
				actualInfo.setMgDate(productInfoBean.getMgDate());

			}
			if (productInfoBean.getExDate() != null) {
				actualInfo.setExDate(productInfoBean.getExDate());
			}
			if (productInfoBean.getPrice() > 0) {
				actualInfo.setPrice(productInfoBean.getPrice());
			}
			if (productInfoBean.getQuantity() > 0) {
				actualInfo.setQuantity(productInfoBean.getQuantity());
			}

			et.commit();
			isUpdated = true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public List<Products> getAllProduct() {
		Query query=em.createQuery("from products");
		ArrayList<Products> list=new ArrayList<Products>();
		try {
			list=(ArrayList<Products>) query.getResultList();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			list=null;
		}
		return list;
	}

	

}
