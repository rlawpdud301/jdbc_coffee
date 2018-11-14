package jdbc_coffee;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_coffee.jdbc.LogUtil;
import jdbc_coffee.jdbc.dao.CoffeeDaoImpl;
import jdbc_coffee.jdbc.dao.Coffeedao;
import jdbc_coffee.jdbc.dto.Coffee;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CoffeeDaoTest {
	static Coffeedao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start CoffeeDaoTest");
		dao = new CoffeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End CoffeeDaoTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectCoffeeByAll() {
		List<Coffee> lists = dao.selectCoffeedaoByAll();
		LogUtil.prnLog(lists.toString());
		Assert.assertNotNull(lists);
	}

	@Test
	public void test02InsertCoffee() {
		try {
			
			Coffee newCoffee = new Coffee("A003",4500,150,10);
			int rowAffected = dao.insertCoffeedao(newCoffee);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 부서 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}

	/*@Test
	public void test04DeleteDepartment() {
		try {
			Department delDept = new Department();
			delDept.setDeptNo(10);
			int rowAffected = dao.deleteDepartment(delDept);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1451) {
				LogUtil.prnLog("해당 부서에 소속된 사원이 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}

	@Test
	public void test03UpdateDepartment() {
		try {
			Department updateDept = new Department(10, "총무2", 10);
			int rowAffected = dao.updateDepartment(updateDept);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		}
	}

	@Test
	public void test05SelectDepartmentByNo() {
		try {
			Department selDept = new Department();
			selDept.setDeptNo(1);
			Department department = dao.selectDepartmentByNo(selDept);
			LogUtil.prnLog(String.format("%s - %s", department.getClass().getSimpleName(), department));
			Assert.assertNotNull(department);
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		}
	}
*/
}
