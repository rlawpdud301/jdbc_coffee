package jdbc_coffee.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_coffee.jdbc.dto.ProductName;
import jdbc_coffee.jdbc.dto.SaleDetail;




public interface SaleDetailDao {
	
	List<SaleDetail> getRank(Boolean boolean1) throws SQLException;	
	
}
