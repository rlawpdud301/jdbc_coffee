package jdbc_coffee.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_coffee.jdbc.ConnectionProvider;
import jdbc_coffee.jdbc.dto.ProductName;
import jdbc_coffee.jdbc.dto.SaleDetail;
import jdbc_coffee.jdbc.dto.SaleDetail;

public class SaleDetailDaoImpl implements SaleDetailDao {
	 

	@Override
	public List<SaleDetail> getRank(Boolean boolean1) throws SQLException {
		List<SaleDetail> lists = new ArrayList<>();
		String sql = "{call rank_product(?)}";	      
		
		
	      try(Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);){
	    	  	pstmt.setBoolean(1, boolean1);
	         
	         try(ResultSet rs = pstmt.executeQuery()){
	        	 while(rs.next()) {
	            	lists.add(getDetail(rs));
	            }
	         }
	      } catch(SQLException e1) {
	         e1.printStackTrace();
	      }
	      
		return lists ;
	}

	private SaleDetail getDetail(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int salePrice = rs.getInt("salePrice");
		int tax = rs.getInt("tax");
		int supplyPrice = rs.getInt("supplyPrice");
		int marginRate = rs.getInt("marginRate");
		int margin = rs.getInt("margin");
		int rank = rs.getInt("rank");

	      return new SaleDetail(code,name,price,saleCnt,salePrice,tax,supplyPrice,marginRate,margin,rank);
	}

}
