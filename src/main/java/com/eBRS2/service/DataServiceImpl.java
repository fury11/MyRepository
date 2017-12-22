package com.eBRS2.service;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.eBRS2.dao.DataAccess;
import com.eBRS2.models.AddBusModel;
import com.eBRS2.models.RegModel;
import com.eBRS2.models.SearchModel;
import com.eBRS2.models.UserLog;
import com.eBRS2.models.printModel;

@Service
@Transactional
public class DataServiceImpl implements DataService{
	
	DataAccess dao;

	@Autowired
	public void setDao(DataAccess dao) {
		this.dao = dao;
	}

	@Override
	public UserLog findUserInfo(String username) {
		return dao.findUserInfo(username);
	}

	@Override
	public List<String> getUserRoles(String username) {
		return dao.getUserRoles(username);
	}

	@Override
	public void userSave(RegModel rm) {
		dao.userSave(rm);
	}

	@Override
	public void addRole(String username) {
		dao.addRole(username);
	}

	@Override
	public void saveBus(AddBusModel ab, Authentication authentication) {
		dao.saveBus(ab, authentication);
	}

	@Override
	public Timestamp dateNow() {
		return dao.dateNow();
	}

	@Override
	public String getUserBrgy(String username) {
		return dao.getUserBrgy(username);
	}

	@Override
	public List<String> getBrgyList() {
		return dao.getBrgyList();
	}

	@Override
	public List<SearchModel> getSearch(String category, String search, Authentication authentication) {
		return dao.getSearch(category, search, authentication);
	}

	@Override
	public List<SearchModel> getSearchAll(String category, String search) {
		return dao.getSearchAll(category, search);
	}

	@Override
	public List<SearchModel> getPrintSearch(printModel pm) {
		return dao.getPrintSearch(pm);
	}

	@Override
	public List<SearchModel> getPrintSearchOne(printModel pm) {
		return dao.getPrintSearchOne(pm);
	}

}
