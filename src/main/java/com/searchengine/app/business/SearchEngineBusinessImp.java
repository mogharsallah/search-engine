package com.searchengine.app.business;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.transaction.annotation.Transactional;

import com.searchengine.app.jsonquery.JSONProduct;
import com.searchengine.app.jsonquery.JSONProducts;
import com.searchengine.app.dao.PagePatternDao;
import com.searchengine.app.dao.SearchPatternDao;
import com.searchengine.app.dao.WebsiteDao;
import com.searchengine.app.entities.Website;

@Transactional
public class SearchEngineBusinessImp implements SearchEngineBusiness {
	private WebsiteDao wdao;
	private SearchPatternDao spdao;
	private PagePatternDao ppdao;

	@SuppressWarnings("finally")
	@Override
	public Document getDocument(Website w, String keyword) {
		Document doc = null;
		try {
			doc = Jsoup.connect(w.getSearch_url())
					.data(w.getSearch().getKeyword(), keyword)
					.userAgent("Mozilla")
					.cookie("auth", "token")
					.timeout(3000)
					.post();
					
//			String url =w.getSearch_url()+"?"+w.getSearch().getKeyword()+"="+keyword;
//			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return doc;
		}
	}

	@Override
	public Elements getElements(Website w, String keyword) {
		return getDocument(w,keyword).getElementsByClass(w.getPage().getProduct());
	}

	@Override
	public JSONProducts getProducts(String keyword) {
		ArrayList<Website> websites = (ArrayList<Website>) wdao.getWebsites();
		JSONProducts products = new JSONProducts();
		for (Website w : websites) {
			if (w.isActif()) {
				Elements elements = this.getElements(w, keyword);
				for (Element element : elements) {
					JSONProduct product = new JSONProduct("", "", "", "", "", "");
					try {
						String image = element.select(w.getPage().getImage()).first().attr("src");
						if (!image.contains("http:/")) {
							image = w.geturl()+ image; 
						}
						
						product.setTitle(element.select(w.getPage().getTitle()).first().text());
						product.setImage(image);
						product.setPrice(element.select(w.getPage().getPrice()).first().text());
						product.setDescription(element.select(w.getPage().getDescription()).first().text());
						product.setUrl(w.geturl());
						product.setWebsite(w.getName());

					} catch (NullPointerException e) {
						System.out.println("Error");
					}
					products.add(product);
				}
			}

		}
		return products;
	}

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

}
