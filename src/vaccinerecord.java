
public class vaccinerecord {
 private int id;
 private int vacid;
 private String vacname;
 private int dozes;
 private int remainingdozes;
 private int resid;
public vaccinerecord(int id, int vacid, String vacname, int dozes, int remainingdozes, int resid) {
	super();
	this.id = id;
	this.vacid = vacid;
	this.vacname = vacname;
	this.dozes = dozes;
	this.remainingdozes = remainingdozes;
	this.resid = resid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getVacid() {
	return vacid;
}
public void setVacid(int vacid) {
	this.vacid = vacid;
}
public String getVacname() {
	return vacname;
}
public void setVacname(String vacname) {
	this.vacname = vacname;
}
public int getDozes() {
	return dozes;
}
public void setDozes(int dozes) {
	this.dozes = dozes;
}
public int getRemainingdozes() {
	return remainingdozes;
}
public void setRemainingdozes(int remainingdozes) {
	this.remainingdozes = remainingdozes;
}
public int getResid() {
	return resid;
}
public void setResid(int resid) {
	this.resid = resid;
}


 
}
