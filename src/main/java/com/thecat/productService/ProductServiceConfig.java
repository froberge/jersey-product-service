package com.thecat.productService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.thecat.productService.endpoint.ProductServiceEndpoint;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author froberge
 */
@ApplicationPath("api")
public class ProductServiceConfig extends Application {
    private Set<Object> singletons = new HashSet<>();

    public ProductServiceConfig() {
        singletons.add(new ProductServiceEndpoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
