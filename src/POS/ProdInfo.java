package POS;

public class ProdInfo {
	private String productCode;
	private String description;
	private String supplier;
	private int qty;
	private String price;
	
	public ProdInfo(String productCode, String description, String supplier, int qty, String price) {
		super();
		this.productCode = productCode;
		this.description = description;
		this.supplier = supplier;
		this.qty = qty;
		this.price = price;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
