package jdbc_coffee.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import jdbc_coffee.jdbc.ConnectionProvider;
import jdbc_coffee.jdbc.LogUtil;
import jdbc_coffee.jdbc.dao.CoffeeDaoImpl;
import jdbc_coffee.jdbc.dao.Coffeedao;
import jdbc_coffee.jdbc.dto.Coffee;
import jdbc_coffee.jdbc.dto.ProductName;
import jdbc_coffee.jdbc.dto.SaleDetail;
import jdbc_coffee.jdbc_service.CoffeeService;

import javax.swing.SwingConstants;

public class Coffeeui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textCode;
	private JTextField textPrice;
	private JTextField textCnt;
	private JTextField textMarg;
	private JButton btnOut1;
	private JButton btnInsert;
	private Coffeedao dao;
	private JButton btnOut2;


	/**
	 * Create the frame.
	 */
	public Coffeeui() {
		dao = new CoffeeDaoImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("제품코드");
		panel_2.add(lblCode);
		
		textCode = new JTextField();
		panel_2.add(textCode);
		textCode.setColumns(10);
		
		JLabel lblPrice = new JLabel("제품단가");
		panel_2.add(lblPrice);
		
		textPrice = new JTextField();
		panel_2.add(textPrice);
		textPrice.setColumns(10);
		
		JLabel lblCnt = new JLabel("판매수량");
		panel_2.add(lblCnt);
		
		textCnt = new JTextField();
		panel_2.add(textCnt);
		textCnt.setColumns(10);
		
		JLabel lblMarg = new JLabel("마진률");
		panel_2.add(lblMarg);
		
		textMarg = new JTextField();
		panel_2.add(textMarg);
		textMarg.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("제품명 :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		textCode.getDocument().addDocumentListener(new MydocumentListener() {

			@Override
			public void warning() {
				if(textCode.getText().length()>=4) {
					 String code = textCode.getText().trim();
					
					 ProductName pdt = new ProductName(code);
		               try {
		            	   CoffeeService name = new CoffeeService();
		            	   ProductName searchPdt = name.searchProduct(pdt);
		            	   lblNewLabel_4.setText(searchPdt.getName());
		            	   String a =lblNewLabel_4.getText();
		            	   System.out.println(a);
		            	   if(lblNewLabel_4.getText()==null) {
		            		   lblNewLabel_4.setText("해당 제품이 없음");
		            	   }
		               } catch (SQLException e) {
		                  // TODO Auto-generated catch block
		                  e.printStackTrace();
		               } catch(NullPointerException e) {
		            	   lblNewLabel_4.setText("해당 제품이 없음");
		               }

						
					
				}
				
				
			}
				
		});
		
		
				//getProductName();
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(this);
		panel_1.add(btnInsert);
		
		btnOut1 = new JButton("출력1");
		btnOut1.addActionListener(this);
		panel_1.add(btnOut1);
		
		btnOut2 = new JButton("출력2");
		btnOut2.addActionListener(this);
		panel_1.add(btnOut2);
	}

	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOut2) {
			do_btnOut2_actionPerformed(e);
		}
		if (e.getSource() == btnInsert) {
			do_btnInsert_actionPerformed(e);
		}
		if (e.getSource() == btnOut1) {
			do_btnOut1_actionPerformed(e);
		}
		
	}
	
	protected void do_btnOut1_actionPerformed(ActionEvent e) {
		RankFrame newFame = new RankFrame(true);
		
		newFame.setVisible(true);
	}
	
	protected void do_btnOut2_actionPerformed(ActionEvent e) {
		RankFrame newFame = new RankFrame(false);
		
		
		newFame.setVisible(true);
	}



	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		
		try {
			Coffee newCoffee = getCoffee();
			int rowAffected = dao.insertCoffeedao(newCoffee);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			dao = null;
		} catch (Exception e1) {
			// TODO: handle exception
		}
	}

	private Coffee getCoffee() {
		int i =0;
		String code = textCode.getText().trim();		
		int price = (int) Double.parseDouble(textPrice.getText().trim());
		int cnt = (int) Double.parseDouble(textCnt.getText().trim());
		int margen = (int) Double.parseDouble(textMarg.getText().trim());
		return new Coffee(i,code, price, cnt, margen);
	}
	
}
