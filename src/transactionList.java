
public class transactionList {
	private int transId;
	private String brandName;
	private String GenericName;
	private int quantity;
	private String date;
	private int resId;
	private String ResidentFullName;
	private String MetricMeasurement;
	private int Measurement;
	public transactionList(int transId, String brandName, String genericName, int quantity, String date, int resId,
			String residentFullName, String metricMeasurement, int measurement) {
		super();
		this.transId = transId;
		this.brandName = brandName;
		GenericName = genericName;
		this.quantity = quantity;
		this.date = date;
		this.resId = resId;
		ResidentFullName = residentFullName;
		MetricMeasurement = metricMeasurement;
		Measurement = measurement;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getGenericName() {
		return GenericName;
	}
	public void setGenericName(String genericName) {
		GenericName = genericName;
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
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getResidentFullName() {
		return ResidentFullName;
	}
	public void setResidentFullName(String residentFullName) {
		ResidentFullName = residentFullName;
	}
	public String getMetricMeasurement() {
		return MetricMeasurement;
	}
	public void setMetricMeasurement(String metricMeasurement) {
		MetricMeasurement = metricMeasurement;
	}
	public int getMeasurement() {
		return Measurement;
	}
	public void setMeasurement(int measurement) {
		Measurement = measurement;
	}
	
	
}
