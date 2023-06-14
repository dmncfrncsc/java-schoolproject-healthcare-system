
public class orderList {
	int orderId;
	String brandName;
	String genericName;
	int quantity;
	String transaction;
	
	int resId;
	String fullName;
	String middleName;
	String lastName;
	public orderList(int orderId, String brandName, String genericName, int quantity, String transaction, int resId,
			String fullName, String middleName, String lastName) {
		super();
		this.orderId = orderId;
		this.brandName = brandName;
		this.genericName = genericName;
		this.quantity = quantity;
		this.transaction = transaction;
		this.resId = resId;
		this.fullName = fullName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
