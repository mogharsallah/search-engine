package com.searchengine.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.searchengine.app.business.PagePatternBusiness;
import com.searchengine.app.entities.PagePattern;

@Controller
public class PagePatternController {

	@Autowired
	private PagePatternBusiness business;


	@RequestMapping(value="/page")
	public String page(Model model) {
		model.addAttribute("pagePattern", new PagePattern());
		model.addAttribute("message", "Add a new Page Pattern");
		model.addAttribute("pagePatterns", this.business.getPagePatterns());
		return "page";
	}
	
	@RequestMapping(value="/page/{message}")
	public String pageWithMessage(Model model,@PathVariable("message") String message) {
		model.addAttribute("pagePattern", new PagePattern());
		model.addAttribute("pagePatterns", this.business.getPagePatterns());
		return "page";
	}
	
	@RequestMapping(value = "/page/add")
	public String addPage(@ModelAttribute("pagePatterns") PagePattern p) {

		
		if (p.getId() == 0) {
			
			this.business.addPagePattern(p);
			return "redirect:/page/Successfully added the new Page Pattern";
		} else {
			
			this.business.updatePagePattern(p);
			return "redirect:/page/Successfully updated the Page Pattern";
		}

		

	}

	@RequestMapping("/page/remove/{id}")
	public String removePage(@PathVariable("id") int id) {

		if (business.isPagePatternClean(Long.valueOf(id))) {
			this.business.removePagePattern(Long.valueOf(id));
			return "redirect:/page/Successfully removed the Page Pattern";
		}
		return	"redirect:/page/Page Pattern is in use";

	}

	@RequestMapping("/page/edit/{id}")
	public String editPage(@PathVariable("id") int id, Model model) {
		model.addAttribute("pagePattern", this.business.getPagePattern(Long.valueOf(id)));
		model.addAttribute("pagePatterns", this.business.getPagePatterns());
		model.addAttribute("message", "Edit Page Pattern");
		return "page";
	}

}