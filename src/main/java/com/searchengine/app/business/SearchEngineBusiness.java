package com.searchengine.app.business;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.searchengine.app.entities.Website;
import com.searchengine.app.jsonquery.JSONProducts;

public interface SearchEngineBusiness {
	public Document getDocument(Website w, String keyword);
	public Elements getElements(Website w, String keyword);
	public JSONProducts getProducts (String keyword);
}
