
public class residentInfo {
	private int id;
	private String lname;
	private String fname;
	private String mname;
	private String street;
	private String brgy;
	private String city;
	private String province;
	private String gender;
	private String bdate;
	private String civilStatus;

	private String category;
	private String pwdSpecify;
	private String occupation;
	private String position;
	private String photo;
	
	
	
	public residentInfo(int id, String lname, String fname, String mname, String street, String brgy, String city,
			String province, String gender, String bdate, String civilStatus, String category, String pwdSpecify,
			String occupation, String position, String photo) {
		super();
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.mname = mname;
		this.street = street;
		this.brgy = brgy;
		this.city = city;
		this.province = province;
		this.gender = gender;
		this.bdate = bdate;
		this.civilStatus = civilStatus;
		this.category = category;
		this.pwdSpecify = pwdSpecify;
		this.occupation = occupation;
		this.position = position;
		this.photo = photo;/// eto yun.
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBrgy() {
		return brgy;
	}
	public void setBrgy(String brgy) {
		this.brgy = brgy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
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
	public String getPwdSpecify() {
		return pwdSpecify;
	}
	public void setPwdSpecify(String pwdSpecify) {
		this.pwdSpecify = pwdSpecify;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhoto() {
		return photo;
	}
	//okay lang naman walng setter dito kasi nag seset ka naman sa constructor mo e ahh sige po sir
	//pero kung sanay ka naman na may ganyan eh okay lang kaya lang eh reduntant kumbaga..
	///public void setPhoto(byte[] photo) {
		///this.photo = photo;
	//}

}
