package com.eBRS2.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eBRS2.models.UserLog;

public class UserLogMap implements RowMapper<UserLog> {

	@Override
	public UserLog mapRow(ResultSet rs, int row) throws SQLException {
//		String username = rs.getString("user_name");
//		String password = rs.getString("user_password");
//		String brgy = rs.getString("brgy");
//		return new UserLog(username, password, brgy);
		return null;
	}

}
