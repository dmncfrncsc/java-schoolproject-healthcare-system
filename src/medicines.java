import java.util.Date;

public class medicines {
	private int id;
    private String bName;
    private String gName;
    private String category;
    private Date ManuDate;
    private Date ExpirationDate;
    private int qty;
	private String metricmeasure;
	private int measure;
	public medicines(int id, String bName, String gName, String category, Date manuDate, Date expirationDate, int qty,
			String metricmeasure, int measure) {
		super();
		this.id = id;
		this.bName = bName;
		this.gName = gName;
		this.category = category;
		ManuDate = manuDate;
		ExpirationDate = expirationDate;
		this.qty = qty;
		this.metricmeasure = metricmeasure;
		this.measure = measure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getManuDate() {
		return ManuDate;
	}
	public void setManuDate(Date manuDate) {
		ManuDate = manuDate;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		ExpirationDate = expirationDate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getMetricmeasure() {
		return metricmeasure;
	}
	public void setMetricmeasure(String metricmeasure) {
		this.metricmeasure = metricmeasure;
	}
	public int getMeasure() {
		return measure;
	}
	public void setMeasure(int measure) {
		this.measure = measure;
	}
	
	
}
