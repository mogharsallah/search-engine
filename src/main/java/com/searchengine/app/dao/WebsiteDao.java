package com.searchengine.app.dao;
import java.util.List;
import com.searchengine.app.entities.Website;
import com.searchengine.app.entities.SearchPattern;
import com.searchengine.app.entities.PagePattern;

public interface WebsiteDao {
	public Website addWebsite(Website w);
	public Website getWebsite(Long wId);
	public List<Website> getWebsitesBySearchPattern(SearchPattern s);
	public List<Website> getWebsitesByPagePattern(PagePattern p);
	public List<Website> getWebsites();
	public Website updateWebsite(Website w);
	public void removeWebsite (Long wId);
}
