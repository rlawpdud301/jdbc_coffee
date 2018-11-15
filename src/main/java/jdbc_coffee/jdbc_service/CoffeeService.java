package jdbc_coffee.jdbc_service;

import java.sql.SQLException;

import jdbc_coffee.jdbc.dao.CoffeeDaoImpl;
import jdbc_coffee.jdbc.dao.Coffeedao;
import jdbc_coffee.jdbc.dao.ProductNameDaoImpl;
import jdbc_coffee.jdbc.dto.Coffee;
import jdbc_coffee.ui.ProductName;

public class CoffeeService {

	private static ProductNameDaoImpl dao;

	public CoffeeService() {
		dao = new ProductNameDaoImpl();
	}
	
	

	public static ProductName searchProduct(ProductName pdt) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getName(pdt);
	}
	
}
