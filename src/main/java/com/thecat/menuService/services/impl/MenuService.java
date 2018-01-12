package com.thecat.menuService.services.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 
 * @author froberge
 * @since January 2017
 */
public class MenuService {

	private static MenuService menuService = null;
	
	/**
	 * Private constructor to prevent the creation of the Logger Service
	 */
	private MenuService(){
		
	}
	
	public static MenuService getInstance() {
		if ( menuService == null ) {
			menuService = new MenuService();
		}
		
		return menuService;
	}

	/**
	 * Write the given information to a file
	 * 
	 * @throws IOException
	 */
	public void getMenu() throws IOException {
		
	}
}
