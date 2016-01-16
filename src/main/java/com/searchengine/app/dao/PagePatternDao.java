package com.searchengine.app.dao;

import java.util.List;

import com.searchengine.app.entities.PagePattern;

public interface PagePatternDao {
	public PagePattern addPagePattern(PagePattern p);
	public PagePattern getPagePattern(Long pId);
	public List<PagePattern> getPagePatterns();
	public void removePagePattern (Long pId);
	public PagePattern updatePagePattern(PagePattern p);
}
