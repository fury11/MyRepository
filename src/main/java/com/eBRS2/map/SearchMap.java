package com.eBRS2.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eBRS2.models.SearchModel;

public class SearchMap implements RowMapper<SearchModel> {

	@Override
	public SearchModel mapRow(ResultSet rs, int row) throws SQLException {
		SearchModel sp = new SearchModel();
		sp.setId(rs.getInt("ID"));
		sp.setBusname(rs.getString("BNAME"));
		sp.setOwner(rs.getString("OWNER"));
		sp.setBustype(rs.getString("BTYPE"));
		sp.setBrgy(rs.getString("BRGY"));
		sp.setBusaddress(rs.getString("ADDRESS"));
		return sp;
	}

}
