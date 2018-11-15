package jdbc_coffee.ui;

public class ProductName {
	private String code;
	private String name;
	public ProductName() {
		// TODO Auto-generated constructor stub
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
	public ProductName(String code) {
		this.code = code;
	}
	public ProductName(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
