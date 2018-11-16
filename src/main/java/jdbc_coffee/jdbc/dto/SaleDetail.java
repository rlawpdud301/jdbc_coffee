package jdbc_coffee.jdbc.dto;

public class SaleDetail {
	private String code;
	private String name;
	private int price;
	private int saleCnt;
	private int salePrice;
	private int tax;
	private int supplyPrice;
	private int marginRate;
	private int margin;
	private int rank;
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}
	public SaleDetail(String code, String name, int price, int saleCnt, int salePrice, int tax, int supplyPrice,
			int marginRate, int margin, int rank) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.saleCnt = saleCnt;
		this.salePrice = salePrice;
		this.tax = tax;
		this.supplyPrice = supplyPrice;
		this.marginRate = marginRate;
		this.margin = margin;
		this.rank = rank;
	}
	public SaleDetail(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleCnt() {
		return saleCnt;
	}
	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getSupplyPrice() {
		return supplyPrice;
	}
	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}
	public int getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}
	public int getMargin() {
		return margin;
	}
	public void setMargin(int margin) {
		this.margin = margin;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return String.format(
				"SaleDetail [code=%s, name=%s, price=%s, saleCnt=%s, salePrice=%s, tax=%s, supplyPrice=%s, marginRate=%s, margin=%s, rank=%s]",
				code, name, price, saleCnt, salePrice, tax, supplyPrice, marginRate, margin, rank);
	}
	
	
}
