package com.ssafy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.FavoriteDto;
import com.ssafy.util.DBClose;
import com.ssafy.util.DBconnection;

//DAO : DataBase Access Object
public class FavoriteDaoImpl implements FavoriteDao {

	private static FavoriteDao FavoriteDao;

	private FavoriteDaoImpl() {}

	public static FavoriteDao getFavoriteDao() {
		if (FavoriteDao == null)
			FavoriteDao = new FavoriteDaoImpl();
		return FavoriteDao;
	}

	@Override
	public void register(FavoriteDto favoriteDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "insert into favorite_dong (user_id, dongcode)\r\n"
					+ "values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favoriteDto.getUser_id());
			pstmt.setString(2, favoriteDto.getDongcode());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteFavorite(String user_id, String dongcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "delete from favorite_dong where user_id = ? and dongcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, dongcode);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<FavoriteDto> searchById(String user_id) {
		List<FavoriteDto> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection conn = DBconnection.getConnection();) {
			String sql = "select user_id, dongcode\n";
			sql += "from favorite_dong\n";
			sql +="where user_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					FavoriteDto FavoriteDto = new FavoriteDto();
					FavoriteDto.setUser_id(rs.getString("user_id"));
					FavoriteDto.setDongcode(rs.getString("dongcode"));

					list.add(FavoriteDto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<FavoriteDto> searchAll() {
		List<FavoriteDto> list = new ArrayList<>();

		try (Connection conn = DBconnection.getConnection();) {

			String sql = "select user_id, dongcode\n";
			sql += "from favorite_dong";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					FavoriteDto FavoriteDto = new FavoriteDto();
					FavoriteDto.setUser_id(rs.getString("user_id"));
					FavoriteDto.setDongcode(rs.getString("dongcode"));

					list.add(FavoriteDto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
