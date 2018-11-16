package jdbc_coffee.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import jdbc_coffee.jdbc.dao.SaleDetailDao;
import jdbc_coffee.jdbc.dao.SaleDetailDaoImpl;
import jdbc_coffee.jdbc.dto.SaleDetail;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class RankFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private SaleDetailDao Dao;
	private NonEditableModel model;
	private List<SaleDetail> lists;
	


	/**
	 * Create the frame.
	 */
	public RankFrame(Boolean a) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		Tilesetting(a);
		lists = new ArrayList<>();
		Dao = new SaleDetailDaoImpl();
		try {
			
			lists = Dao.getRank(a) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액"
			}
			
		
		));
		loadDatas();
		contentPane.add(table, BorderLayout.CENTER);
	}



	private void loadDatas() {
		model = new NonEditableModel(getDatas(), getColumnNames());
		table.setModel(model);
		setAlignWith();
		
	}



	private void setAlignWith() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableCellAlignment(SwingConstants.RIGHT, 2, 3, 4, 5, 6);
		tableSetWidth(150, 200, 100, 100, 100, 100, 100);
		
	}



	private void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}



	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}



	private Object[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
		
	}



	private Object[][] getDatas() {
		
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getStudentArray(lists.get(i));
		}
		return datas;
	}



	private Object[] getStudentArray(SaleDetail lists) {
		return new Object[] { lists.getRank(), lists.getCode(), lists.getName(), lists.getPrice(),
				lists.getSaleCnt(), lists.getSupplyPrice(),lists.getTax(),lists.getSalePrice(),lists.getMargin(),lists.getMargin() };
	}



	private void Tilesetting(Boolean a) {
		if(a==true) {
			setTitle("판매금액 순위");
			
		}else {
			setTitle("마진액 순위");
		}
	}

}
