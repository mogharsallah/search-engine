package com.searchengine.app.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.searchengine.app.dao.PagePatternDao;
import com.searchengine.app.dao.SearchPatternDao;
import com.searchengine.app.dao.WebsiteDao;
import com.searchengine.app.entities.Website;

@Transactional
public class WebsiteBusinessImp implements WebsiteBusiness {
	private WebsiteDao wdao;
	private SearchPatternDao spdao;
	private PagePatternDao ppdao;

	public WebsiteDao getWdao() {
		return wdao;
	}

	public void setWdao(WebsiteDao wdao) {
		this.wdao = wdao;
	}

	public SearchPatternDao getSpdao() {
		return spdao;
	}

	public void setSpdao(SearchPatternDao spdao) {
		this.spdao = spdao;
	}

	public PagePatternDao getPpdao() {
		return ppdao;
	}

	public void setPpdao(PagePatternDao ppdao) {
		this.ppdao = ppdao;
	}

	@Override
	public Website addWebsite(Website w) {

		return wdao.addWebsite(w);
	}

	@Override
	public Website getWebsite(Long wId) {
		return wdao.getWebsite(wId);
	}

	@Override
	public List<Website> getWebsitesBySearchPattern(Long sId) {

		return wdao.getWebsitesBySearchPattern(spdao.getSearchPattern(sId));
	}

	@Override
	public List<Website> getWebsites() {
		return wdao.getWebsites();
	}

	@Override
	public Website updateWebsite(Website w) {
		return wdao.updateWebsite(w);
	}

	@Override
	public void removeWebsite(Long wId) {
		wdao.removeWebsite(wId);
	}

	@Override
	public List<Website> getWebsitesByPagePattern(Long pId) {
		return wdao.getWebsitesByPagePattern(ppdao.getPagePattern(pId));
	}
}
