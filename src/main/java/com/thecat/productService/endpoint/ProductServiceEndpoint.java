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
    public Product product() {
        return ProductService.getInstance().selectAllProduct();
	}

	/**
	 * Endpoint responsible to return a product
	 *
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public Product findById(@PathParam( "id" ) String id) {
		return new Product();
	}

	/**
	 * Endpoint responsible to return a product with a given name
	 *
	 * @return
	 */
	@GET
	@Path("search/{name}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public Product findByName(@PathParam( "name" ) String name) {
		return ProductService.getInstance().selectAllProduct();
	}


}