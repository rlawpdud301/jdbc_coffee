package jdbc_coffee.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import jdbc_coffee.jdbc.ConnectionProvider;
import jdbc_coffee.jdbc.LogUtil;
import jdbc_coffee.jdbc.dto.Coffee;




public class CoffeeDaoImpl implements Coffeedao {

	@Override
	public List<Coffee> selectCoffeedaoByAll() {
		List<Coffee> list = new ArrayList<>();
		String sql = "select no, code, price,saleCnt,marginRate from sale";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			while (rs.next()) {
				list.add(getCoffee(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
		
		
	}

	private Coffee getCoffee(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String code = rs.getString("deptname");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");		
		int marginRate = rs.getInt("marginRate");
		return new Coffee(no, code,price,saleCnt,marginRate);
	}

	@Override
	public int insertCoffeedao(Coffee coffee) throws SQLException {
		LogUtil.prnLog("insertCoffee()");
		String sql = "insert into sale values(null, ?, ?,?,?);";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, coffee.getCode());
			pstmt.setInt(2, coffee.getPrice());
			pstmt.setInt(3, coffee.getSaleCnt());
			pstmt.setInt(4, coffee.getMarginRate());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int deleteCoffeedao(Coffee coffee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCoffeedao(Coffee coffee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Coffee selectCoffeedaoByCode(Coffee coffee) throws SQLException {
		  LogUtil.prnLog("selectCoffeeByCode()");
	      coffee = null;
	      
	      String sql = "select name from product where code=?;";
	      
	      try (Connection conn = ConnectionProvider.getConnection(); 
	    	PreparedStatement pstmt = conn.prepareStatement(sql)) {
	         pstmt.setString(1, coffee.getCode());
	         LogUtil.prnLog(pstmt);
	         try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	               coffee = getCoffee(rs);
	               System.out.println(conn);
	            }
	         }
	      }
	      return coffee;

	}

	

}
