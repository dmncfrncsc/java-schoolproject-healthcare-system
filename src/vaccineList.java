
public class vaccineList {
	private int id;
	private String vacname;
	private int qty;
	private int stock;
	private String status;
	public vaccineList(int id, String vacname, int qty, int stock, String status) {
		super();
		this.id = id;
		this.vacname = vacname;
		this.qty = qty;
		this.stock = stock;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVacname() {
		return vacname;
	}
	public void setVacname(String vacname) {
		this.vacname = vacname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
