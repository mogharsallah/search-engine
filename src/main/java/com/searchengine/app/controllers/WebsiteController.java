package com.searchengine.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.searchengine.app.business.PagePatternBusiness;
import com.searchengine.app.business.SearchPatternBusiness;
import com.searchengine.app.business.WebsiteBusiness;
import com.searchengine.app.entities.Website;

@Controller
public class WebsiteController {

	@Autowired
	private WebsiteBusiness business;
	@Autowired
	private PagePatternBusiness pageBusiness;
	@Autowired
	private SearchPatternBusiness searchBusiness;

	@RequestMapping(value = "/website")
	public String Website(Model model) {
		model.addAttribute("website", new Website());
		model.addAttribute("message", "Add a new Website ");
		model.addAttribute("websites", this.business.getWebsites());
		model.addAttribute("pages", this.pageBusiness.getPagePatterns());
		model.addAttribute("searchs", this.searchBusiness.getSearchPatterns());
		return "website";
	}

	@RequestMapping(value = "/website/{message}")
	public String WebsiteWithMessage(Model model, @PathVariable("message") String message) {
		model.addAttribute("website", new Website());
		model.addAttribute("websites", this.business.getWebsites());
		model.addAttribute("pages", this.pageBusiness.getPagePatterns());
		model.addAttribute("searchs", this.searchBusiness.getSearchPatterns());
		
		return "website";
	}
	
	@RequestMapping(value = "/website/add")
	public String addWebsite(@ModelAttribute("Websites") Website p,@ModelAttribute("pId") int pId, @ModelAttribute("sId") int sId ) {
		p.setPage(this.pageBusiness.getPagePattern(Long.valueOf(pId)));
		p.setSearch(this.searchBusiness.getSearchPattern(Long.valueOf(sId)));
		if (p.getId() == 0) {

			this.business.addWebsite(p);
			return "redirect:/website/Successfully added the new Website ";
		} else {

			this.business.updateWebsite(p);
			return "redirect:/website/Successfully updated the Website ";
		}

	}

	@RequestMapping("/website/remove/{id}")
	public String removeWebsite(@PathVariable("id") int id) {
		this.business.removeWebsite(Long.valueOf(id));
		return "redirect:/website/Successfully removed the Website ";
	}

	@RequestMapping("/website/edit/{id}")
	public String editWebsite(@PathVariable("id") int id, Model model) {
		model.addAttribute("website", this.business.getWebsite(Long.valueOf(id)));
		model.addAttribute("websites", this.business.getWebsites());
		model.addAttribute("message", "Edit Website ");
		model.addAttribute("pages", this.pageBusiness.getPagePatterns());
		model.addAttribute("searchs", this.searchBusiness.getSearchPatterns());
		return "website";
	}

}