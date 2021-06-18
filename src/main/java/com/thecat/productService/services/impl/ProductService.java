package com.thecat.productService.services.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.thecat.productService.model.Product;


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
	 *  This method create a connection to the database.
	 *
	 * @return {@link Connection}
	 * @throws Exception
	 */
	private Connection getDatabaseConnection() throws Exception {

		System.out.println( "getDatabaseConnection" );

		Context context = new InitialContext();
		Context envContext = (Context) context.lookup( "java:/comp/env");

		DataSource dataSource = (DataSource) envContext.lookup("jdbc/postgres");

		try {
			Connection connection = dataSource.getConnection();

			if ( connection != null ) {
				System.out.println( "got a connection" );
				return connection;
			} else {
				return null;
			}
		} catch ( Exception e ) {
			System.out.println("connect " + e );
			throw e;
		}
	}

	/**
	 * Find all the product.
	 *
	 * @return
	 */
	public List<Product> findProducts() {
		List<Product> productList = null;

		try {
			Connection connection = getDatabaseConnection();

			if ( connection != null ) {
				System.out.println( "find product" );
				String query = "select * from cs_product.product";
				PreparedStatement stmt = connection.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				if (rs != null ) {
					System.out.println( "rs not null" );
					productList = parseProductResult( rs );
				}

				rs.close();
				connection.close();
			} else {
				System.out.println( "no connection" );
			}
		} catch (Exception e ) {
			System.out.println( e );
		}

		return productList;
	}

	/**
	 * Find a given product.
	 *
	 * @param id  {@link String}
	 * @return {@link Product}
	 */
	public Product findProductById(String id) {
		Product product = null;

		try {
			Connection connection = getDatabaseConnection();

			if ( connection != null ) {
				String query = "select * from CS_PRODUCT.PRODUCT where id = ?";
				PreparedStatement stmt = connection.prepareStatement(query);

				stmt.setInt(1, Integer.parseInt(id) );

				ResultSet rs = stmt.executeQuery();

				if (rs != null ) {
					product = parseProductResult( rs ).get(0);
				}

				rs.close();
				connection.close();
			} else {
				System.out.println( "no connection" );
			}
		} catch (Exception e ) {
			System.out.println( e );
		}

		return product;
	}

	/**
	 * Find Products that contains the given name
	 *
	 * @param name
	 * @return
	 */
	public List<Product> findProductsByName(String name) {
		List<Product> productList = null;

		try {
			Connection connection = getDatabaseConnection();

			if ( connection != null ) {
				String query = "SELECT * FROM CS_PRODUCT.PRODUCT\n" +
						"WHERE UPPER(NAME) LIKE UPPER(?)";

				PreparedStatement stmt = connection.prepareStatement(query);
				stmt.setString(1, "%" + name + "%" );

				ResultSet rs = stmt.executeQuery();

				if (rs != null ) {
					productList = parseProductResult( rs );
				}

				rs.close();
				connection.close();
			} else {
				System.out.println( "no connection" );
			}
		} catch (Exception e ) {
			System.out.println( e );
		}

		return productList;
	}

	/**
	 * Parse the result from the database query.
	 *
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Product> parseProductResult(ResultSet rs) throws SQLException {
		List<Product> listProduct = new ArrayList<>();

		while (rs.next() ) {
			Product p  = new Product();
			p.setId(rs.getInt( "id" ) );
			p.setName( rs.getString( "name") );
			p.setDescription( rs.getString( "description" ) );
			p.setSize( rs.getString( "size" ) );
			p.setPrice( rs.getString( "price" ) );

			listProduct.add( p );
		}

		return listProduct;
	}
}
