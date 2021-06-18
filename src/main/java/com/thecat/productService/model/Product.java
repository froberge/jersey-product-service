package com.thecat.productService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

	private int id;
	private String name;
	private String description;
	private String size;
	private String price;

	/**
	 * @return {@link int}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id {@link int}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return {@link String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name {@link String}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return {@link String}
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description {@link String}
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return {@link String}
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size {@link String}
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return {@link String}
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price {@link String}
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer( "Information on the product: \n" );

		sb.append("id [ " + this.id + "]\n");
		sb.append("name [ " + this.name + "]\n");
		sb.append("description [ " + this.description + "]\n");
		sb.append("Size [ " + this.size + "]\n");
		sb.append("Price [ " + this.price + "]\n");

		return sb.toString();
	}
}
