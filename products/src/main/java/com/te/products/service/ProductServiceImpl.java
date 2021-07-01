package com.te.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.products.beans.Products;
import com.te.products.dao.ProductDAO;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO dao;

	@Override
	public boolean deleteProductData(int id) {
		// TODO Auto-generated method stub
		return dao.deleteProductData(id);
	}

	@Override
	public boolean addProduct(Products productInfoBean) {
		// TODO Auto-generated method stub
		return dao.addProduct(productInfoBean);
	}

	@Override
	public boolean updateRecord(Products productInfoBean) {
		// TODO Auto-generated method stub
		return dao.updateRecord(productInfoBean);
	}

	@Override
	public List<Products> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

	

}
