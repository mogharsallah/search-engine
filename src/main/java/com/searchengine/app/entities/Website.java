package com.searchengine.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="WEBSITES")
public class Website implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String url;
	private String search_url;
	private boolean actif;
	@ManyToOne
	private PagePattern page;
	@ManyToOne
	private SearchPattern search;
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
	public String geturl() {
		return url;
	}
	public void seturl(String url) {
		this.url = url;
	}
	public String getSearch_url() {
		return search_url;
	}
	public void setSearch_url(String search_url) {
		this.search_url = search_url;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public PagePattern getPage() {
		return page;
	}
	public void setPage(PagePattern page) {
		this.page = page;
	}
	public SearchPattern getSearch() {
		return search;
	}
	public void setSearch(SearchPattern search) {
		this.search = search;
	}
	public Website(String name, String url, String search_url, boolean actif) {
		super();
		this.name = name;
		this.url = url;
		this.search_url = search_url;
		this.actif = actif;
	}
	public Website() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
