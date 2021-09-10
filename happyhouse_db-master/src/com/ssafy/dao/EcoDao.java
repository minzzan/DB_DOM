package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.EcoDto;

public interface EcoDao {

	void register(EcoDto ecoDto);
	EcoDto searchById(int idx);
	List<EcoDto> searchAll();
	void update(EcoDto ecoDto);
	void delete(int idx);
	
}
