package com.thecat.menuService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.thecat.menuService.endpoint.MenuServiceEndpoint;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author froberge
 */
@ApplicationPath("api")
public class MenuServiceConfig  extends Application {
    private Set<Object> singletons = new HashSet<>();

    public MenuServiceConfig() {
        singletons.add(new MenuServiceEndpoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
