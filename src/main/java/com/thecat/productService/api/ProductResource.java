package com.thecat.productService.api;

import com.thecat.productService.model.Product;
import com.thecat.productService.services.impl.ProductService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Service use to interact with the product
 * 
 * @author froberge
 * @since September 2018
 */
@Path( "/product" )
public class ProductResource {

	/**
	 * List at the products available.
	 * @return List
	 */
	@GET
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public List<Product> listProducts() {
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
	@Path("/search/{name}")
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
	public List<Product> selectProductByName(@PathParam( "name" ) String name) {
		return ProductService.getInstance().findProductsByName( name );
	}

    @GET
	@Path( "/health")
    @Produces(MediaType.TEXT_PLAIN)
    public String health() {
        return "SUCCESS";
    }

	@GET
	@Path( "/createschema" )
	@Produces(MediaType.TEXT_PLAIN)
	public String createSchema() {
		return (ProductService.getInstance().createSchema()) ? "SUCCESS": "FALSE";
	}
}