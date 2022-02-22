package com.thecat.productService.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		String databaseURL = "jdbc:postgresql://";
		databaseURL += System.getenv( "POSTGRESQL_SERVICE_HOST" );
		databaseURL += "/" + System.getenv( "POSTGRESQL_DATABASE" );
		String username = System.getenv( "POSTGRESQL_USER" );
		String password= System.getenv( "POSTGRESQL_PASSWORD" );

		try {
			
			Connection connection = DriverManager.getConnection( databaseURL, username, password );
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
	 * Find all the product.
	 *
	 * @return
	 */
	public List<Product> findProducts() {
		List<Product> productList = null;

		try {
			Connection connection = getDatabaseConnection();

			if ( connection != null ) {
				String query = "select * from cs_product.product";
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

	/**
	 * Create the product Schema inside the database for the applications
	 * This is a work around to speed things up.
	 *
	 * @return boolean
	 */
	public boolean createSchema() {

		boolean response = false;
		BufferedReader in = null;
		String creationScript = System.getenv( "CREATION_SCRIPT" );

		try {
			Connection connection = getDatabaseConnection();

			if (connection != null) {
				Statement stmt = connection.createStatement();
				in = new BufferedReader(new FileReader( creationScript ) );
				String line;
				StringBuffer sb = new StringBuffer();

				//Read the script
				while ((line = in.readLine()) != null) {
					sb.append(line + "\n ");
				}

				in.close();


				System.out.println( " statement to execute " + sb.toString() );
				stmt.executeUpdate(sb.toString());
				response = true;
			}
		} catch( Exception e ) {
			System.out.println("problem creating the script \n " + e.getMessage());
		}

		return response;
	}
}
