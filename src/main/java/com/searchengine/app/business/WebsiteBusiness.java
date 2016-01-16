package com.searchengine.app.business;

import java.util.List;

import com.searchengine.app.entities.Website;

public interface WebsiteBusiness {
	
	public Website addWebsite(Website w);
	public Website getWebsite(Long wId);
	public List<Website> getWebsitesBySearchPattern(Long sId);
	public List<Website> getWebsitesByPagePattern(Long pId);
	public List<Website> getWebsites();
	public Website updateWebsite(Website w);
	public void removeWebsite (Long wId);
}
