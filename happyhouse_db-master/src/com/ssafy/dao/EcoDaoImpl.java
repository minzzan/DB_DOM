package com.ssafy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.EcoDto;
import com.ssafy.util.DBClose;
import com.ssafy.util.DBconnection;


//DAO : DataBase Access Object
public class EcoDaoImpl implements EcoDao {

	private static EcoDao ecoDao;

	private EcoDaoImpl() {}

	public static EcoDao getEcoDao() {
		if (ecoDao == null)
			ecoDao = new EcoDaoImpl();
		return ecoDao;
	}

	@Override
	public void register(EcoDto ecoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "insert into eco (company_name, license_number, business_code, business_name, inspection_date, agency_code, agency_name, is_disposed, inspection, road_address)\r\n"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ecoDto.getCompanyName());
			pstmt.setString(2, ecoDto.getLicenseNumber());
			pstmt.setString(3, ecoDto.getBusinessCode());
			pstmt.setString(4, ecoDto.getBusinessName());
			pstmt.setString(5, ecoDto.getInspectionDate());
			pstmt.setString(6, ecoDto.getAgencyCode());
			pstmt.setString(7, ecoDto.getAgencyName());
			pstmt.setString(8, ecoDto.getIsDisposed());
			pstmt.setString(9, ecoDto.getInspection());
			pstmt.setString(10, ecoDto.getRoadAddress());

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
	public void update(EcoDto ecoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "update eco ";
			sql += "set company_name=?, license_number=?, business_code=?, business_name=?, inspection_date=?, agency_code=?, agency_name=?, is_disposed=?, inspection=?, road_address =? ";
			sql += "where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ecoDto.getCompanyName());
			pstmt.setString(2, ecoDto.getLicenseNumber());
			pstmt.setString(3, ecoDto.getBusinessCode());
			pstmt.setString(4, ecoDto.getBusinessName());
			pstmt.setString(5, ecoDto.getInspectionDate());
			pstmt.setString(6, ecoDto.getAgencyCode());
			pstmt.setString(7, ecoDto.getAgencyName());
			pstmt.setString(8, ecoDto.getIsDisposed());
			pstmt.setString(9, ecoDto.getInspection());
			pstmt.setString(10, ecoDto.getRoadAddress());
			pstmt.setInt(11, ecoDto.getIdx());

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
	public void delete(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "delete from eco where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

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
	public EcoDto searchById(int idx) {
		EcoDto ecoDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconnection.getConnection();
			String sql = "select idx, company_name, license_number, business_code, business_name, inspection_date, agency_code, agency_name, is_disposed, inspection, road_address ";
			sql += "from eco \n";
			sql += "where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				ecoDto = new EcoDto();
				ecoDto.setIdx(rs.getInt("idx"));
				ecoDto.setCompanyName(rs.getString("company_name"));
				ecoDto.setLicenseNumber(rs.getString("license_number"));
				ecoDto.setBusinessCode(rs.getString("business_code"));
				ecoDto.setBusinessName(rs.getString("business_name"));
				ecoDto.setInspectionDate(rs.getString("inspection_date"));
				ecoDto.setAgencyCode(rs.getString("agency_code"));
				ecoDto.setAgencyName(rs.getString("agency_name"));
				ecoDto.setIsDisposed(rs.getString("is_disposed"));
				ecoDto.setInspection(rs.getString("inspection"));
				ecoDto.setRoadAddress(rs.getString("road_address"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return ecoDto;
	}

	@Override
	public List<EcoDto> searchAll() {
		List<EcoDto> list = new ArrayList<>();

		try (Connection conn = DBconnection.getConnection();) {

			String sql = "select idx, company_name, license_number, business_code, business_name, inspection_date, agency_code, agency_name, is_disposed, inspection, road_address ";
			sql += "from eco ";
			sql += "order by idx desc ";
			sql += "limit 100";
			
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					EcoDto ecoDto = new EcoDto();
					ecoDto.setIdx(rs.getInt("idx"));
					ecoDto.setCompanyName(rs.getString("company_name"));
					ecoDto.setLicenseNumber(rs.getString("license_number"));
					ecoDto.setBusinessCode(rs.getString("business_code"));
					ecoDto.setBusinessName(rs.getString("business_name"));
					ecoDto.setInspectionDate(rs.getString("inspection_date"));
					ecoDto.setAgencyCode(rs.getString("agency_code"));
					ecoDto.setAgencyName(rs.getString("agency_name"));
					ecoDto.setIsDisposed(rs.getString("is_disposed"));
					ecoDto.setInspection(rs.getString("inspection"));
					ecoDto.setRoadAddress(rs.getString("road_address"));

					list.add(ecoDto);
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
