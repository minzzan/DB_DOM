package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseDealDao {

	void register(HouseDealDto houseDealDto);
	HouseDealDto searchById(int no);
	List<HouseDealDto> searchAll();
	void update(HouseDealDto houseDealDto);
	void delete(int no);
	
}
