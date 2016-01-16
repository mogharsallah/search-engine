package com.searchengine.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.searchengine.app.entities.PagePattern;
import com.searchengine.app.entities.SearchPattern;
import com.searchengine.app.entities.Website;

public class WebsiteDaoImp implements WebsiteDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Website addWebsite(Website w) {
		em.persist(w);
		return w;
	}

	@Override
	public Website getWebsite(Long wId) {
		Website w = em.find(Website.class, wId);
		if (w == null) {
			throw new RuntimeException("Website not found");
		}
		return w;
	}

	@Override
	public List<Website> getWebsitesBySearchPattern(SearchPattern s) {
		Query req = em.createQuery("select w from Website w where w.search=:x");
		req.setParameter("x", s);
		return req.getResultList();
	}

	@Override
	public List<Website> getWebsitesByPagePattern(PagePattern p) {
		Query req = em.createQuery("select w from Website w where w.page=:x");
		req.setParameter("x", p);
		return req.getResultList();
	}

	@Override
	public List<Website> getWebsites() {
		Query req = em.createQuery("select w from Website w");
		return req.getResultList();
	}

	@Override
	public Website updateWebsite(Website w) {
		em.merge(w);
		return null;
	}

	@Override
	public void removeWebsite(Long wId) {
		Website website = em.find(Website.class, wId);
		em.remove(website);
		
	}
}
