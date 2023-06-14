
public class residentRecord {
	private String fullname;
	private String address;
	private String gender;
	private String bdate;
	private String civilStatus;
	private String category;
	private String pwd;
	private String occupation;
	private String imagepath;
	private int id;
	public residentRecord(String fullname, String address, String gender, String bdate, String civilStatus,
			String category, String pwd, String occupation, String imagepath, int id) {
		super();
		this.fullname = fullname;
		this.address = address;
		this.gender = gender;
		this.bdate = bdate;
		this.civilStatus = civilStatus;
		this.category = category;
		this.pwd = pwd;
		this.occupation = occupation;
		this.imagepath = imagepath;
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getCivilStatus() {
		return civilStatus;
	}
	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
