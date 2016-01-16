package com.searchengine.app.business;

import java.util.List;

import com.searchengine.app.entities.SearchPattern;

public interface SearchPatternBusiness {
	public SearchPattern addSearchPattern(SearchPattern s);
	public SearchPattern getSearchPattern(Long sId);
	public List<SearchPattern> getSearchPatterns();
	public SearchPattern updateSearchPattern(SearchPattern s);
	public void removeSearchPattern (Long sId);
	public Boolean isSearchPatternClean(Long sId);
}
