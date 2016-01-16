package com.searchengine.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.searchengine.app.jsonquery.JSONProducts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchengine.app.business.SearchEngineBusiness;

@Controller
public class EngineController {

	@Autowired
	private SearchEngineBusiness searchEngine;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/find/{Keyword}", method = RequestMethod.GET, headers = "Accept=application/json;charset=UTF-8")
	public @ResponseBody String searchResult(@PathVariable("Keyword") String Keyword) {
		System.out.println(Keyword);
		ObjectMapper mapper = new ObjectMapper();
		JSONProducts products =searchEngine.getProducts(Keyword);
		String responce = "";
		try {
			  responce = mapper.writeValueAsString(products);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		mapper = null;
		products = null; 
			return responce;
	}
	
}
