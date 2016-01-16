package com.searchengine.app.business;

import java.util.List;

import com.searchengine.app.entities.PagePattern;

public interface PagePatternBusiness {
	public PagePattern addPagePattern(PagePattern p);
	public PagePattern getPagePattern(Long pId);
	public List<PagePattern> getPagePatterns();
	public void removePagePattern (Long pId);
	public PagePattern updatePagePattern(PagePattern p);
	public Boolean isPagePatternClean(Long pId);
}
