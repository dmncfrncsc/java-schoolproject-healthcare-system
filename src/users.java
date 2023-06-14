
public class users {
    private int id;
    private String lname;
    private String fname;
    private String mname;
    private String position;
    private String username;
    private String password;
    private String status;
    
	public users(int id, String lname, String fname, String mname, String position, String username, String password, String status) {
		
		super();
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.mname = mname;
		this.position = position;
		this.username = username;
		this.password = password;
		this.status = status;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
	
    
}
