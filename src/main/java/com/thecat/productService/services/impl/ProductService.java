package com.thecat.productService.services.impl;

import com.thecat.productService.entities.Product;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

		List<Product> listProduct = null;

		try {
			URL url = new URL("http://dbservice:8080/DatabaseService/api/db/products");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			if ( conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException( "Failed : HTTP error code : " + conn.getResponseCode() );
			}

			listProduct = parseListProductOutput(new BufferedReader(new InputStreamReader((conn.getInputStream()))));
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listProduct;
	}

	/**
	 * Create the response from what was return in the service.
	 *
	 * @param response {@link BufferedReader}
	 * @return
	 */
	private List<Product> parseListProductOutput(BufferedReader response) throws IOException {
		try {
			List<Product> listProduct = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = response.readLine()) != null) {
				sb.append(line);
			}

			String a = sb.toString().replace( "[","" );
			String b = a.replace("]", "" );
			String finalString = b.replace("},{", "};{" );

			String[] stringArray = finalString.split(";" );

			for (int i = 0; i <= stringArray.length ; i++) {
				System.out.println( "line [ " + i + "] = " + stringArray[i] + "\n" );
				JSONObject obj = new JSONObject( stringArray[i] );
				Product p = new Product();
				p.setId( obj.getString( "id") );
				p.setName( obj.getString( "name") );
				p.setCategory( obj.getString( "category") );
				p.setSubCategory_1( obj.getString( "subCategory_1") );
				p.setSubCategory_2( obj.getString( "subCategory_2") );
				p.setPrice( obj.getString( "price") );

				listProduct.add( p );
			}

			return listProduct;
		} catch (IOException ioe) {
			throw ioe;
		}
	}
}
