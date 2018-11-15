package jdbc_coffee.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc_coffee.jdbc.ConnectionProvider;
import jdbc_coffee.jdbc.LogUtil;
import jdbc_coffee.ui.ProductName;


public class ProductNameDaoImpl implements ProductNameDao {

	

	@Override
	public ProductName getName(ProductName code) throws SQLException {
		 String sql = "select code, name from product where code = ?";
	      
		 ProductName product = code;
	      try(Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);){

	    	  pstmt.setString(1, code.getCode());
	         
	         try(ResultSet rs = pstmt.executeQuery()){
	            if(rs.next()) {
	               product = getProductName(rs);
	            }
	         }
	      } catch(SQLException e1) {
	         e1.printStackTrace();
	      }
	      return product;


	}
	 private ProductName getProductName(ResultSet rs) throws SQLException {
		  String code = rs.getString("code");
		  String name = rs.getString("name");


	      return new ProductName(code,name);
	   }

}
