package com.searchengine.app.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.searchengine.app.dao.PagePatternDao;
import com.searchengine.app.dao.WebsiteDao;
import com.searchengine.app.entities.PagePattern;

@Transactional

public class PagePatternBusinessImp implements PagePatternBusiness {

	private PagePatternDao ppdao;
	private WebsiteDao wdao;

	public PagePattern addPagePattern(PagePattern p) {
		return ppdao.addPagePattern(p);
	}

	public PagePattern getPagePattern(Long pId) {
		return ppdao.getPagePattern(pId);
	}

	public PagePatternDao getPpdao() {
		return ppdao;
	}

	public void setPpdao(PagePatternDao ppdao) {
		this.ppdao = ppdao;
	}

	public WebsiteDao getWdao() {
		return wdao;
	}

	public void setWdao(WebsiteDao wdao) {
		this.wdao = wdao;
	}

	public List<PagePattern> getPagePatterns() {
		return ppdao.getPagePatterns();
	}

	public void removePagePattern(Long pId) {
		ppdao.removePagePattern(pId);
	}

	public Boolean isPagePatternClean(Long pId) {
		if (wdao.getWebsitesByPagePattern(getPagePattern(pId)).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public PagePattern updatePagePattern(PagePattern p) {
		return ppdao.updatePagePattern(p);
	}
}