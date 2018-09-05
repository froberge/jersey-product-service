package com.thecat.productService.endpoint;

import com.thecat.productService.entities.Product;
import com.thecat.productService.services.impl.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public List<Product> product() {
        return ProductService.getInstance().selectAllProduct();
	}
}