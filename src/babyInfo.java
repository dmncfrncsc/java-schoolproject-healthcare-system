import java.util.Date;

public class babyInfo {
private int id;
private String fullname;
private String address;
private String gender;
private String bday;
private String photo;
public babyInfo(int id, String fullname, String address, String gender, String bday, String photo) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.address = address;
	this.gender = gender;
	this.bday = bday;
	this.photo = photo;
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
public String getBday() {
	return bday;
}
public void setBday(String bday) {
	this.bday = bday;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}


}
