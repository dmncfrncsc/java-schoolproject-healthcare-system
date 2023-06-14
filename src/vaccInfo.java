import java.util.Date;

public class vaccInfo {
private int id;
private String vaccName;
private int qty;
private Date manudate;
private Date expdate;
public vaccInfo(int id, String vaccName, int qty, Date manudate, Date expdate) {
	super();
	this.id = id;
	this.vaccName = vaccName;
	this.qty = qty;
	this.manudate = manudate;
	this.expdate = expdate;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getVaccName() {
	return vaccName;
}
public void setVaccName(String vaccName) {
	this.vaccName = vaccName;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public Date getManudate() {
	return manudate;
}
public void setManudate(Date manudate) {
	this.manudate = manudate;
}
public Date getExpdate() {
	return expdate;
}
public void setExpdate(Date expdate) {
	this.expdate = expdate;
}


}
