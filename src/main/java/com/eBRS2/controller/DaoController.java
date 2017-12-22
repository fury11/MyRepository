package com.eBRS2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eBRS2.models.AddBusModel;
import com.eBRS2.models.RegModel;
import com.eBRS2.models.SearchModel;
import com.eBRS2.models.printModel;
import com.eBRS2.service.DataService;

@Controller
public class DaoController {

	@Autowired           
	DataService dao;
	
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public ModelAndView searchBrgy(@RequestParam(value = "txtcategory", defaultValue="busname", required = false) String category, 
			@RequestParam(value = "txtsearch", defaultValue = "", required = false) String search, Authentication authentication, Model model){	
		List<SearchModel> list = dao.getSearch(category, search, authentication);
		model.addAttribute("search", search);
		model.addAttribute("categ", category);
		return new ModelAndView("Search", "list", list);
	}
	
	@RequestMapping(value = "/SearchAll", method = RequestMethod.GET)
	public ModelAndView searchBrgyAll(@RequestParam(value = "txtcategory", defaultValue="busname", required = false) String category, 
			@RequestParam(value = "txtsearch", defaultValue = "", required = false) String search, Model model){	
		List<SearchModel> list = dao.getSearchAll(category, search);
		model.addAttribute("search", search);
		model.addAttribute("categ", category);
		return new ModelAndView("SearchAll", "list", list);
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("userDetails") RegModel rm) {
		dao.userSave(rm);
		dao.addRole(rm.getUsername());
		return new ModelAndView("redirect:/SuccessRegistration");
	}
	
	@RequestMapping(value = "/saveBus", method = RequestMethod.POST)
	public ModelAndView saveBus(@ModelAttribute("saveBus") AddBusModel am, Authentication authentication) {
		dao.saveBus(am, authentication);
		return new ModelAndView("redirect:/Success");
	}
	
	@RequestMapping(value = "/PrintAll", method = RequestMethod.GET)
	public ModelAndView printSearch(@ModelAttribute("printSearch") printModel pm, Model model) {
		List<SearchModel> list = dao.getPrintSearch(pm);
		model.addAttribute("PrintAllModel", pm); 
		return new ModelAndView("PrintAll", "printAllList", list);
	}
	
	@RequestMapping(value = "/Print", method = RequestMethod.GET)
	public ModelAndView printSearchOne(@ModelAttribute("printSearch") printModel pm, Model model, Authentication authentication) {
		pm.setTxtbrgy(dao.getUserBrgy(authentication.getName()));
		List<SearchModel> list = dao.getPrintSearchOne(pm);
		model.addAttribute("PrintModel", pm); 
		return new ModelAndView("Print", "printList", list);
	}
	
    @ModelAttribute("categoryList")
	public List<String> getCategory(){
		List<String> lists = new ArrayList<String>();
		lists.add("busname");
		lists.add("owner");
		lists.add("bustype");
	    return lists;
    }
    
    @ModelAttribute("brgyList")
	public List<String> getStats(){
		List<String> lists = new ArrayList<String>();
		lists.addAll(dao.getBrgyList());
	    return lists;
    }
    

}
