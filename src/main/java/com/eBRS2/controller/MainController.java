package com.eBRS2.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eBRS2.models.AddBusModel;
import com.eBRS2.models.RegModel;
import com.eBRS2.service.DataService;


@Controller
public class MainController {
	
	@Autowired           
	DataService dao;
	
	@RequestMapping(value = {"/", "/login"})
	public String welcomePage(Model model) {
		return "login";
	}
	
	@RequestMapping(value = {"/SuccessRegistration"})
	public String successReg(Model model) {
		return "SuccessRegistration";
	}
	
	@RequestMapping(value = {"/Success"})
	public String success(Model model, Principal principal) {
		model.addAttribute("userLog", principal.getName());
		model.addAttribute("resultBus", "addBus");
		return "Success";
	}
	
	@RequestMapping(value = "/AddNewBusiness")
	public ModelAndView openAddNew() {
		return new ModelAndView("AddNewBusiness", "command", new AddBusModel());
	}
	
	@RequestMapping(value = "/Registration")
	public ModelAndView openReg() {
		return new ModelAndView("Registration", "command", new RegModel());
	}
	
	@RequestMapping(value = "/Home")
	public String homePage(Model model) {
		return "Home";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if(principal != null) {
			model.addAttribute("message",  principal.getName());	
		}else {
			model.addAttribute("message",  "Guest");
			model.addAttribute("noUser",  "none");
		}
		return "403Page";
	}
	
	@RequestMapping(value = "/Admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "Admin";
	}
	
    @ModelAttribute("brgyList")
	public List<String> getStats(){
		List<String> lists = new ArrayList<String>();
		lists.addAll(dao.getBrgyList());
	    return lists;
    }
    
    @ModelAttribute("categoryList")
	public List<String> getCategory(){
		List<String> lists = new ArrayList<String>();
		lists.add("busname");
		lists.add("owner");
		lists.add("bustype");
	    return lists;
    }
	
}
