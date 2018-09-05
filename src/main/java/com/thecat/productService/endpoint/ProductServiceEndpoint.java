package com.thecat.productService.endpoint;

import com.thecat.productService.entities.Product;
import com.thecat.productService.services.impl.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Service use to interact with the product
 * 
 * @author froberge
 * @since September 20189
 */
@Path( "/products" )
public class ProductServiceEndpoint {

	/**
	 * Endpoint responsible to return all the products
	 *
	 * @return
	 */
	@GET
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public List<Product> selectProducts() {

		return ProductService.getInstance().findProducts();
	}

	/**
	 * Endpoint responsible to return a product
	 *
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public Product selectByProductId(@PathParam( "id" ) String id) {

		return ProductService.getInstance().findProductById( id );
	}

	/**
	 * Select a given product
	 *
	 * @param name
	 * return
	 */
	@GET
	@Path("search/{name}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public List<Product> selectProductByName(@PathParam( "name" ) String name) {

		return ProductService.getInstance().findProductsByName( name );
	}
}