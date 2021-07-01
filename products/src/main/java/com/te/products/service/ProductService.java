package com.te.products.service;

import java.util.List;

import com.te.products.beans.Products;

public interface ProductService {
	
	public boolean deleteProductData(int id);

	public boolean addProduct(Products productInfoBean);

	public boolean updateRecord(Products productInfoBean);

	public List<Products> getAllProduct();
	
}
