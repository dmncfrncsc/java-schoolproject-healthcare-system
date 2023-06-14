
public class cart {
	private int id;
	private int medId;
	private String bname;
	private String gname;
	private int qty;
	private int stock;
	
	public cart(int id, int medId, String bname, String gname, int qty, int stock) {
		super();
		this.id = id;
		this.medId = medId;
		this.bname = bname;
		this.gname = gname;
		this.qty = qty;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
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

}
