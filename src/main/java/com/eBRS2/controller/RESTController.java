package com.eBRS2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eBRS2.models.RegModel;
import com.eBRS2.models.SearchModel;
import com.eBRS2.service.DataService;

@RestController
public class RESTController {
	
	@Autowired
	DataService daoService;
	
	@RequestMapping(value="/searchREST/{txtcategory}", method = RequestMethod.GET, headers="Accept=application/json" )
	public ResponseEntity<List<SearchModel>> listAllUser(@PathVariable(value = "txtcategory") String category){
		try {
			    List<SearchModel> list = daoService.getSearchAll(category, "");			 
				return new ResponseEntity<List<SearchModel>>(list, HttpStatus.OK);				
		} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<List<SearchModel>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value="/addUser/", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Void> add(@RequestBody RegModel rm){	
		HttpHeaders header = new HttpHeaders();
		try {
				daoService.userSave(rm);		
				return new ResponseEntity<Void>(header, HttpStatus.OK);
		} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<Void>(header, HttpStatus.NO_CONTENT);
		}
	}
}
