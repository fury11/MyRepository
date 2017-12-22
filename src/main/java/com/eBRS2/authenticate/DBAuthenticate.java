package com.eBRS2.authenticate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eBRS2.models.UserLog;
import com.eBRS2.service.DataService;

@Service
public class DBAuthenticate implements UserDetailsService{
	
	@Autowired
	DataService dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLog ul = dao.findUserInfo(username);
		if(ul == null) {
			throw new UsernameNotFoundException("User" + username + "not found!");
		}
		
		List<String> roles = dao.getUserRoles(username);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		if(roles != null) {
			for(String role: roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
				grantList.add(authority);
			}
		}
		
		UserDetails userDetails = (UserDetails) new User(ul.getUsername(), ul.getPassword(), grantList);
		
		return userDetails;
	}

}
