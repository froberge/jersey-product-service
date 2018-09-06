package com.thecat.productService.services.impl;

import com.thecat.productService.entities.Product;

import java.io.*;
import java.sql.*;
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
	 *  This method create a connection to the database.
	 *
	 * @return {@link Connection}
	 * @throws Exception
	 */
	private Connection getDatabaseConnection() throws Exception {
		StringBuffer dbUrl = new StringBuffer( "jdbc:postgresql://" );
		dbUrl.append( System.getenv( "POSTGRESQL_SERVICE_HOST" ) );
		dbUrl.append( "/" );
		dbUrl.append( System.getenv( "POSTGRESQL_DATABASE" ) );

		String username = System.getenv( "POSTGRESQL_USER" );
		String password = System.getenv( "PGPASSWORD" );

		try {

			Connection connection = DriverManager.getConnection( dbUrl.toString(), username, password );

			if ( connection != null ) {
				return connection;
			} else {
				return null;
			}
		} catch ( Exception e ) {
			throw e;
		}
	}

	/**
	 * Create the product Schema inside the database for the applications
	 * This is a work around to speed things up.
	 *
	 * @return boolean
	 */
	public boolean createSchema() {

		boolean response = false;
		BufferedReader in = null;

		try {
			Connection connection = getDatabaseConnection();

			if (connection != null) {
				Statement stmt = connection.createStatement();
				String scriptFile = "dbscripts/creationScript.sql";
				in = new BufferedReader(new FileReader( scriptFile ) );
				String line;
				StringBuffer sb = new StringBuffer();

				//Read the script
				while ((line = in.readLine()) != null) {
					sb.append(line + "\n ");
				}

				in.close();
				stmt.executeUpdate(sb.toString());
				response = true;
			}
		} catch( Exception e ) {
			System.out.println("problem creating the script \n " + e.getMessage());
		}

		return response;
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
				String query = "select * from PRODUCTS";
				PreparedStatement stmt = connection.prepareStatement(query);

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
				String query = "select * from PRODUCTS where id = ?";
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
				String query = "SELECT * FROM PRODUCTS\n" +
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
			p.setId(rs.getString( "ID" ) );
			p.setName( rs.getString( "NAME") );
			p.setDescription( rs.getString( "DECRIPTION" ) );
			p.setCategory( rs.getString( "CATEGORY" ) );
			p.setSubCategory_1( rs.getString( "SUB_CATEGORY_1" ) );
			p.setSubCategory_2( rs.getString( "SUB_CATEGORY_2" ) );
			p.setPrice( rs.getString( "PRICE" ) );

			listProduct.add( p );
		}

		return listProduct;
	}
}
