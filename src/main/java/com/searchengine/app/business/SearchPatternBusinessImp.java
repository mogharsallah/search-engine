package com.searchengine.app.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.searchengine.app.dao.SearchPatternDao;
import com.searchengine.app.dao.WebsiteDao;
import com.searchengine.app.entities.SearchPattern;

@Transactional
public class SearchPatternBusinessImp  implements SearchPatternBusiness{
	private SearchPatternDao spdao;
	private WebsiteDao wdao;
	public SearchPatternDao getSpdao() {
		return spdao;
	}
	public void setSpdao(SearchPatternDao spdao) {
		this.spdao = spdao;
	}
	public WebsiteDao getWdao() {
		return wdao;
	}
	public void setWdao(WebsiteDao wdao) {
		this.wdao = wdao;
	}
	public SearchPattern addSearchPattern(SearchPattern s) {
		
		return spdao.addSearchPattern(s);
	}
	public SearchPattern getSearchPattern(Long sId) {
		return spdao.getSearchPattern(sId);
	}
	
	public List<SearchPattern> getSearchPatterns() {
		return spdao.getSearchPatterns();
	}
	public SearchPattern updateSearchPattern(SearchPattern s) {
		return spdao.updateSearchPattern(s);
	}
	
	public void removeSearchPattern(Long sId) {
		spdao.removeSearchPattern(sId);
	}

	public Boolean isSearchPatternClean(Long sId) {

		if (wdao.getWebsitesBySearchPattern(getSearchPattern(sId)).isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
