
public class medRecordInfo {
	private String brandname;
	private String genericname;
	int quantity;
	private String date;
	public medRecordInfo(String brandname, String genericname, int quantity, String date) {
		super();
		this.brandname = brandname;
		this.genericname = genericname;
		this.quantity = quantity;
		this.date = date;
	}
	public String getBrandName() {
		return brandname;
	}
	public void setBrandName(String vacname) {
		this.brandname = vacname;
	}
	public String getGenericname() {
		return genericname;
	}
	public void setGenericname(String genericname) {
		this.genericname = genericname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
