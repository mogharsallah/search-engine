package com.searchengine.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PAGESP")
public class PagePattern implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String product;
	private String title;
	private String image;
	private String price;
	private String description;
	
	@OneToMany(mappedBy="page")
	private Collection<Website> websites;
	
	public Collection<Website> getWebsites() {
		return websites;
	}
	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
	public PagePattern(String name, String product, String title, String image, String price, String description) {
		super();
		this.name = name;
		this.product = product;
		this.title = title;
		this.image = image;
		this.price = price;
		this.description = description;
	}
	public PagePattern() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
