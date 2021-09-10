package com.ssafy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.HouseDealDto;
import com.ssafy.util.DBClose;
import com.ssafy.util.DBconnection;


//DAO : DataBase Access Object
public class HouseDealDaoImpl implements HouseDealDao {

	private static HouseDealDao houseDealDao;

	private HouseDealDaoImpl() {}

	public static HouseDealDao getHouseDealDao() {
		if (houseDealDao == null)
			houseDealDao = new HouseDealDaoImpl();
		return houseDealDao;
	}

	@Override
	public void register(HouseDealDto houseDealDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "insert into houseDeal (dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun, type, rentMoney, dongcode)\r\n"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, houseDealDto.getDong());
			pstmt.setString(2, houseDealDto.getAptName());
			pstmt.setString(3, houseDealDto.getCode());
			pstmt.setString(4, houseDealDto.getDealAmount());
			pstmt.setString(5, houseDealDto.getBuildYear());
			pstmt.setString(6, houseDealDto.getDealYear());
			pstmt.setString(7, houseDealDto.getDealMonth());
			pstmt.setString(8, houseDealDto.getDealDay());
			pstmt.setString(9, houseDealDto.getArea());
			pstmt.setString(10, houseDealDto.getFloor());
			pstmt.setString(11, houseDealDto.getJibun());
			pstmt.setString(12, houseDealDto.getType());
			pstmt.setString(13, houseDealDto.getRentMoney());
			pstmt.setString(14, houseDealDto.getDongCode());

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
	public void update(HouseDealDto houseDealDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "update houseDeal ";
			sql += "set dong=?, AptName=?, code=?, dealAmount=?, buildYear=?, dealYear=?, dealMonth=?, dealDay=?, area=?, floor=?, jibun=?, type=?, rentMoney=?, dongcode=? ";
			sql += "where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, houseDealDto.getDong());
			pstmt.setString(2, houseDealDto.getAptName());
			pstmt.setString(3, houseDealDto.getCode());
			pstmt.setString(4, houseDealDto.getDealAmount());
			pstmt.setString(5, houseDealDto.getBuildYear());
			pstmt.setString(6, houseDealDto.getDealYear());
			pstmt.setString(7, houseDealDto.getDealMonth());
			pstmt.setString(8, houseDealDto.getDealDay());
			pstmt.setString(9, houseDealDto.getArea());
			pstmt.setString(10, houseDealDto.getFloor());
			pstmt.setString(11, houseDealDto.getJibun());
			pstmt.setString(12, houseDealDto.getType());
			pstmt.setString(13, houseDealDto.getRentMoney());
			pstmt.setString(14, houseDealDto.getDongCode());
			
			pstmt.setInt(15, houseDealDto.getNo());
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
	public void delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "delete from houseDeal where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

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
	public HouseDealDto searchById(int no) {
		HouseDealDto houseDealDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "select no, dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun, type, rentMoney, dongcode ";
			sql += "from houseDeal \n";
			sql += "where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				houseDealDto = new HouseDealDto();
				houseDealDto.setNo(no);
				houseDealDto.setDong(rs.getString("dong"));
				houseDealDto.setAptName(rs.getString("AptName"));
				houseDealDto.setCode(rs.getString("code"));
				houseDealDto.setBuildYear(rs.getString("buildYear"));
				houseDealDto.setDealYear(rs.getString("dealYear"));
				houseDealDto.setDealMonth(rs.getString("dealMonth"));
				houseDealDto.setDealDay(rs.getString("dealDay"));
				houseDealDto.setArea(rs.getString("area"));
				houseDealDto.setFloor(rs.getString("floor"));
				houseDealDto.setJibun(rs.getString("jibun"));
				houseDealDto.setType(rs.getString("type"));
				houseDealDto.setRentMoney(rs.getString("rentMoney"));
				houseDealDto.setDongCode(rs.getString("dongcode"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return houseDealDto;
	}

	@Override
	public List<HouseDealDto> searchAll() {
		List<HouseDealDto> list = new ArrayList<>();

		try (Connection conn = DBconnection.getConnection();) {

			String sql = "select no, dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun, type, rentMoney, dongcode ";
			sql += "from houseDeal ";
			sql += "order by no desc ";
			sql += "limit 100";
			
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					HouseDealDto houseDealDto = new HouseDealDto();
					houseDealDto.setNo(rs.getInt("no"));
					houseDealDto.setDong(rs.getString("dong"));
					houseDealDto.setAptName(rs.getString("AptName"));
					houseDealDto.setCode(rs.getString("code"));
					houseDealDto.setBuildYear(rs.getString("buildYear"));
					houseDealDto.setDealYear(rs.getString("dealYear"));
					houseDealDto.setDealMonth(rs.getString("dealMonth"));
					houseDealDto.setDealDay(rs.getString("dealDay"));
					houseDealDto.setArea(rs.getString("area"));
					houseDealDto.setFloor(rs.getString("floor"));
					houseDealDto.setJibun(rs.getString("jibun"));
					houseDealDto.setType(rs.getString("type"));
					houseDealDto.setRentMoney(rs.getString("rentMoney"));
					houseDealDto.setDongCode(rs.getString("dongcode"));

					list.add(houseDealDto);
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
