package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Item;

@Repository
public class MercariRepository {

	private static final RowMapper<Item> ITEMS_ROW_MAPPER = (rs, i) -> {
		Item item = new Item();

		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));

		return item;
	};
	
	@Autowired
	private JdbcTemplate jcJdbcTemplate;

	
	public List<Item> selectIdAndName() {
		String sql = "select id, name from items where id > 0 and id < 50";
		
		List<Item> itemList = jcJdbcTemplate.query(sql, ITEMS_ROW_MAPPER);
		
		return itemList;
		
	}
}
