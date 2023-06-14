
public class allVaccineRecord {

	private int resid;
	private String fullname;
	private int vacid;
	private String vacname;
	private int dozes;
	private String datevaccinated;
	public allVaccineRecord(int resid, String fullname, int vacid, String vacname, int dozes, String datevaccinated) {
		super();
		this.resid = resid;
		this.fullname = fullname;
		this.vacid = vacid;
		this.vacname = vacname;
		this.dozes = dozes;
		this.datevaccinated = datevaccinated;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public String getDatevaccinated() {
		return datevaccinated;
	}
	public void setDatevaccinated(String datevaccinated) {
		this.datevaccinated = datevaccinated;
	}
	
	
}
