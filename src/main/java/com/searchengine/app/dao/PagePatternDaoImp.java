package com.searchengine.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.searchengine.app.entities.PagePattern;

public class PagePatternDaoImp implements PagePatternDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public PagePattern addPagePattern(PagePattern p){
		em.persist(p);
		return p;
	}
	
	@Override
	public PagePattern getPagePattern(Long pId) {
		PagePattern pp = em.find(PagePattern.class, pId);
		if (pp == null) {
			throw new RuntimeException("Page Pattern not found");
		}
		return pp;
	}

	@Override
	public List<PagePattern> getPagePatterns() {
		Query req = em.createQuery("select p from PagePattern p ");
		return req.getResultList();
	}

	@Override
	public void removePagePattern(Long pId) {
		PagePattern p = em.find(PagePattern.class, pId);
		em.remove(p);
		
	}

	@Override
	public PagePattern updatePagePattern(PagePattern p) {
		em.merge(p);
		return null;
	}
}
