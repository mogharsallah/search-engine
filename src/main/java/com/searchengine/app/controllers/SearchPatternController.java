package com.searchengine.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.searchengine.app.business.SearchPatternBusiness;
import com.searchengine.app.entities.SearchPattern;

@Controller
public class SearchPatternController {

	@Autowired
	private SearchPatternBusiness business;


	@RequestMapping(value="/search")
	public String search(Model model) {
		model.addAttribute("searchPattern", new SearchPattern());
		model.addAttribute("message", "Add a new Search Pattern");
		model.addAttribute("searchPatterns", this.business.getSearchPatterns());
		return "search";
	}
	
	@RequestMapping(value="/search/{message}")
	public String searchWithMessage(Model model,@PathVariable("message") String message) {
		model.addAttribute("searchPattern", new SearchPattern());
		model.addAttribute("searchPatterns", this.business.getSearchPatterns());
		return "search";
	}
	
	@Transactional 
	@RequestMapping(value = "/search/add")
	public String addSearch(@ModelAttribute("searchPatterns") SearchPattern p) {

		
		if (p.getId() == 0) {
			
			this.business.addSearchPattern(p);
			return "redirect:/search/Successfully added the new Search Pattern";
		} else {
			
			this.business.updateSearchPattern(p);
			return "redirect:/search/Successfully updated the Search Pattern";
		}

		

	}

	@RequestMapping("/search/remove/{id}")
	public String removeSearch(@PathVariable("id") int id) {

		if (business.isSearchPatternClean(Long.valueOf(id))) {
			this.business.removeSearchPattern(Long.valueOf(id));
			return "redirect:/search/Successfully removed the Search Pattern";
		}
		return	"redirect:/search/Search Pattern is in use";

	}

	@RequestMapping("/search/edit/{id}")
	public String editSearch(@PathVariable("id") int id, Model model) {
		model.addAttribute("searchPattern", this.business.getSearchPattern(Long.valueOf(id)));
		model.addAttribute("searchPatterns", this.business.getSearchPatterns());
		model.addAttribute("message", "Edit Search Pattern");
		return "search";
	}

}