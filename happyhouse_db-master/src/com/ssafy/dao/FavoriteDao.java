package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.FavoriteDto;

public interface FavoriteDao {

	void register(FavoriteDto favoriteDto);
	List<FavoriteDto> searchById(String user_id);
	List<FavoriteDto> searchAll();
	void deleteFavorite(String user_id, String dongcode);
	
}
