package com.thecat.productService.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Service use to interact with the product
 * 
 * @author froberge
 * @since September 20189
 */
@Path( "/product" )
public class ProductServiceEndpoint {

	
    /**
     * Endpoint responsible to return the menu
     * 
     * @param UserJson user
     * @return
     */
	@POST
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
    public Response product() {
        return Response.ok().build();
	}
}