package jdbc_coffee;

import jdbc_coffee.jdbc.MyDataSource;

public class Main {
	public static void main(String[] args) {
		MyDataSource mds = MyDataSource.getInstance();
	}
}
