package jdbc_coffee;

import java.awt.EventQueue;

import jdbc_coffee.jdbc.MyDataSource;
import jdbc_coffee.ui.Coffeeui;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coffeeui frame = new Coffeeui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
