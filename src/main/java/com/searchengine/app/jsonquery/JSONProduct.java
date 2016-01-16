package com.searchengine.app.jsonquery;

import java.io.Serializable;

public class JSONProduct implements Serializable {
	
	private String title= "";
	private String image= "";
	private String price= "";
	private String description= "";
	private String website= "";
	private String url= "";
	public JSONProduct() {
	}
	public JSONProduct(String title, String image, String price, String description, String website, String url) {
		super();
		this.title = title;
		this.image = image;
		this.price = price;
		this.description = description;
		this.website = website;
		this.url= url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

}
