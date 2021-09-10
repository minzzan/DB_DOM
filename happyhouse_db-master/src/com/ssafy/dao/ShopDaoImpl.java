package com.ssafy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.ShopDto;
import com.ssafy.util.DBClose;
import com.ssafy.util.DBconnection;


//DAO : DataBase Access Object
public class ShopDaoImpl implements ShopDao {

	private static ShopDao shopDao;

	private ShopDaoImpl() {}

	public static ShopDao getshopDao() {
		if (shopDao == null)
			shopDao = new ShopDaoImpl();
		return shopDao;
	}

	
	@Override
	public List<ShopDto> searchBydong(String dongcode) {
		List<ShopDto> list = new ArrayList<>();
		PreparedStatement pstmt = null;

		try (Connection conn = DBconnection.getConnection();) {

			String sql = "select *\n";
			sql += "from shop\n";
			sql += "where 법정동코드 = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongcode);
			
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					ShopDto shopDto = new ShopDto();
					shopDto.setDongcode(rs.getString("법정동코드"));
					shopDto.setShopName(rs.getString("상호명"));
					shopDto.setShopkind(rs.getString("상권업종대분류명"));
					shopDto.setShopAddress(rs.getString("도로명주소"));

					list.add(shopDto);
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
	public List<ShopDto> searchAll() {
		List<ShopDto> list = new ArrayList<>();

		try (Connection conn = DBconnection.getConnection();) {

			String sql = "select *\n";
			sql += "from shop";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					ShopDto shopDto = new ShopDto();
					shopDto.setDongcode(rs.getString("법정동코드"));
					shopDto.setShopName(rs.getString("상호명"));
					shopDto.setShopkind(rs.getString("상권업종대분류명"));
					shopDto.setShopAddress(rs.getString("도로명주소"));

					list.add(shopDto);
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
