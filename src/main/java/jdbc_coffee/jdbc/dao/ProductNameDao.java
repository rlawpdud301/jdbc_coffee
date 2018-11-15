package jdbc_coffee.jdbc.dao;

import java.sql.SQLException;
import java.util.List;


import jdbc_coffee.ui.ProductName;

public interface ProductNameDao {
	
	ProductName getName(ProductName coffee) throws SQLException;	
	
}
