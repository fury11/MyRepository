package com.eBRS2.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.eBRS2.models.AddBusModel;
import com.eBRS2.models.RegModel;
import com.eBRS2.models.SearchModel;
import com.eBRS2.models.UserLog;
import com.eBRS2.models.printModel;

public interface DataAccess {
	
	public UserLog findUserInfo(String username);
	public List<String> getUserRoles(String username);
	public void userSave(RegModel rm);
	public void addRole(String username);
	public void saveBus(AddBusModel ab, Authentication authentication);
	public Timestamp dateNow();
	public String getUserBrgy(String username);
	public List<String> getBrgyList();
	public List<SearchModel> getSearch(String category, String search, Authentication authentication);
	public List<SearchModel> getSearchAll(String category, String search);
	public List<SearchModel> getPrintSearch(printModel pm);
	public List<SearchModel> getPrintSearchOne(printModel pm);

}
