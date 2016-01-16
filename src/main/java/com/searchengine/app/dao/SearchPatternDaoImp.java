package com.searchengine.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.searchengine.app.entities.SearchPattern;

public class SearchPatternDaoImp implements  SearchPatternDao {
	
	
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public SearchPattern addSearchPattern(SearchPattern s) {
		
		em.persist(s);
		return s;
	}
	
	@Override
	public SearchPattern getSearchPattern(Long sId) {
		SearchPattern sp = em.find(SearchPattern.class, sId);
		if (sp == null) {
			throw new RuntimeException("Search Pattern not found");
		}

		return sp;
	}

	@Override
	public List<SearchPattern> getSearchPatterns() {
		Query req = em.createQuery("select s from SearchPattern s");
		return req.getResultList();
	}

	@Override
	public SearchPattern updateSearchPattern(SearchPattern s) {
		em.merge(s);
		return null;
	}

	@Override
	public void removeSearchPattern(Long sId) {
		SearchPattern p = em.find(SearchPattern.class, sId);
		em.remove(p);
		
	}
}
