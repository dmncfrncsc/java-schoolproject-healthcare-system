
public class infantInfo {
	private int id;
	private String fullname;
	private String gender;
	private String dob;
	private String address;
	
	public infantInfo(int id, String fullname, String gender, String dob, String address) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
