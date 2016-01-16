package com.searchengine.app.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SEARCHP")
public class SearchPattern {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String keyword;
	private String page;
	private boolean paged;
	
	@OneToMany(mappedBy="search")
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public boolean isPaged() {
		return paged;
	}
	public void setPaged(boolean paged) {
		this.paged = paged;
	}
	public SearchPattern() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchPattern(String name, String keyword, String page, boolean paged) {
		super();
		this.name = name;
		this.keyword = keyword;
		this.page = page;
		this.paged = paged;
	}
	
}

