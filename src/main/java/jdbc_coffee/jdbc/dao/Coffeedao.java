package jdbc_coffee.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

import jdbc_coffee.jdbc.dto.Coffee;



public interface Coffeedao {
	List<Coffee> selectCoffeedaoByAll();
	int insertCoffeedao(Coffee coffee) throws SQLException;	
	int deleteCoffeedao(Coffee coffee) throws SQLException;
	int updateCoffeedao(Coffee coffee) throws SQLException;
	Coffee selectCoffeedaoByCode(Coffee coffee) throws SQLException;
	
}
