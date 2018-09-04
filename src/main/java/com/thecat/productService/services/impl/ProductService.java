package com.thecat.productService.services.impl;

import java.io.IOException;

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
	 * With get a given product.
	 * 
	 * @throws IOException
	 */
	public void getAProduct() throws IOException {
		
	}
}
