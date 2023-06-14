
public class tblVaccineRecord {
	private String vacciname;
	private 	int dozes;
	private String date;
	public String getVacciname() {
		return vacciname;
	}
	public void setVacciname(String vacciname) {
		this.vacciname = vacciname;
	}
	public int getDozes() {
		return dozes;
	}
	public void setDozes(int dozes) {
		this.dozes = dozes;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public tblVaccineRecord(String vacciname, int dozes, String date) {
		super();
		this.vacciname = vacciname;
		this.dozes = dozes;
		this.date = date;
	}
	
	

}
