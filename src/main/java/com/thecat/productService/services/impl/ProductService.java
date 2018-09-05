package com.thecat.productService.services.impl;

import com.thecat.productService.entities.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author froberge
 * @since September 2018
 */
public class ProductService {

	private static ProductService productService = null;
	
	/**
	 * Private constructor to prevent the creation of the Product Service
	 */
	private ProductService(){
		
	}
	
	public static ProductService getInstance() {
		if ( productService == null ) {
			productService = new ProductService();
		}
		
		return productService;
	}

	/**
	 * Retrive a list of all the product
	 * 
	 * @throws IOException
	 */
	public List<Product> selectAllProduct() { // throws IOException {

		List<Product> returnList = new ArrayList<>();

		Product p = new Product();
		p.setId("1");
		p.setName("test product");
		p.setCategory("category");
		p.setSubCategory_1("subcategory 1");
		p.setSubCategory_2("subcategory 2");
		p.setPrice("100.00");
		p.setCreateDate("2018-09-04");

		returnList.add( p );

		return returnList;
		
	}
}
