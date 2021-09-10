package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.ShopDto;

public interface ShopDao {

	List<ShopDto> searchBydong(String dongcode);
	List<ShopDto> searchAll();
	
}
