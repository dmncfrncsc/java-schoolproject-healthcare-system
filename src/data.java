import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;
import java.text.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.time.Period;

public class data {
	 Connection conn = dbConnection.getdbConnection();
	 String query;
	 Statement st;
	 ResultSet rs;
	private String sortTerm;
	private static final data INSTANCE = new data();
	private int id;
	private int cartid;
	private int transid;
	String names;
	int attempt;
	
	public static data getInstance() {
		return INSTANCE;
	}
	
	
	private List<users> userList = new ArrayList<>();
	
	private List<medicines> medList = new ArrayList<>();
	
	private List<residentInfo> residentList = new ArrayList<>();
	
	private List<orderList>orderList = new ArrayList<>();
	
	private List<cart>cartList = new ArrayList<>();
	
	private List<transactionList> transList = new ArrayList<>();
	
	private List<babyInfo>babyList = new ArrayList<>();
	
	private List<vaccInfo>vacList = new ArrayList<>();
	
	private List<vaccineList>vaccineList = new ArrayList<>();
	
	private List<vaccinerecord>vaccineRecordList = new ArrayList<>();
	
	private List<tblVaccineRecord>tblVaccineRecordList = new ArrayList<>();
	
	private List<residentRecord>residentRecordList = new ArrayList<>();
	
	private List<medRecordInfo>medRecordInfoList = new ArrayList<>();
	
	private List<allVaccineRecord>allVaccineRecordList= new ArrayList<>();
	
	
	public List<allVaccineRecord>getAllVaccineRecordList(){
		return this.allVaccineRecordList;
	}

	public List<medRecordInfo>getMedRecordInfoList(){
		return this.medRecordInfoList;
	}
	
	public List<residentRecord>getResidentRecordList(){
		return this.residentRecordList;
	}
	public List<tblVaccineRecord>getTblVaccineRecordList(){
		return this.tblVaccineRecordList;
	}
	
	public List<vaccinerecord>getVaccineRecordList(){
		return this.vaccineRecordList;
	}
	public List<vaccineList>getVaccineList(){
		return this.vaccineList;
	}
	public List<vaccInfo>getvaccList(){
		return this.vacList;
	}
	public List<babyInfo>getBabyList(){
		return this.babyList;
	}
	public List<transactionList>getTransList(){
		return this.transList;
	}
	public List<cart>getCartList(){
		return this.cartList;
	}
	public List<orderList>getOrderList(){
		return this.orderList;
	}
	public List<users> getUserList() {
		return this.userList;
	}

	public List<medicines> getMedList() {
		return this.medList;
	}

	public List<residentInfo> getResidentList(){
		return this.residentList;
	}
	
	public void searchInfantInfoRecord(String search) {

			 query="select * from residents where residentid in(select DISTINCT "
			 		+ "residentid from tblvaccinerecord) and category ='infant' and "
			 		+ "(ResidentFirstName like '%"+search+"%' OR residentLastnAme like '%"+search+"%' or residentMiddleName like '%"+search+"%')";
			 try {
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					st=conn.createStatement();
					rs=st.executeQuery(query);
					babyList.clear();
					while(rs.next()) {
						int id = rs.getInt("ResidentId");
						String fullname = rs.getString("ResidentFirstName") + " "+rs.getString("ResidentMiddleName")
						+" "+rs.getString("ResidentLastName");
						String fulladd = rs.getString("StreetAddress")+", "+rs.getString("BarangayAddress")+
								", "+rs.getString("CityAddress")+", "+rs.getString("ProvinceAddress");
						String gender = rs.getString("Gender");
						String bdate = simpleDateFormat.format(rs.getDate("Birthdate"));
						String photo = rs.getString("imagepath");
						babyInfo info = new babyInfo(id,fullname,fulladd,gender,bdate,photo);
						babyList.add(info);
						}
			 }catch(Exception e) {
				 System.out.println(e);
			 }
			 
	
	}
	public boolean checkIfLocked(String username) {
		query= "SELECT STATUS FROM USERS WHERE USERNAME='"+username+"'";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("Status").equalsIgnoreCase("locked")) {
					return true;
				}
			}
		}catch(Exception e) {
			System.out.print(e +"hello6");
		}
		return false;
	}

	public void userAttempt(String name) {
		
		if(name.equals(names)){
            attempt+=1;
            if(attempt==3) {
            	try {
            		query ="UPDATE users SET STATUS = 'LOCKED' where username = '"+name+"'";
            		st=conn.createStatement();
            		st.executeUpdate(query);
            		
            	}catch(Exception e) {
            		System.out.println(e +"hello5");
            	}
            }
          }else {
        	
        	  names = name;
        	  attempt = 1;
          }
	}
	public void searchMedicineTable(String search) {
		query = "Select * from medicines where BrandName like '%"+search+"%' OR GenericName like '%"+search+"%'";
		generateDataforMeds(query);
	}
	public void searchUser(String search) {
		query = "Select * from users where fname like '%"+search+"%' OR mname like '%"+search+"%' or fname like '%"+search+"%' or username like '%"+search+"%'";
		try {
		
			st = conn.createStatement();
			rs=st.executeQuery(query);
			userList.clear();
			while (rs.next()) {
				int id = rs.getInt("UserId");
				String lname = rs.getString("LName");
				String fname = rs.getString("FName");
				String mname = rs.getString("MName");
				String position = rs.getString("Position");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String status = rs.getString("Status");
				users newUsers = new users(id, lname, fname, mname, position, username, password,status);
				userList.add(newUsers);
			}
			/*
			 * userList.forEach(user -> { System.out.println(user.getId());
			 * System.out.println(user.getLname()); System.out.println(user.getFname());
			 * System.out.println(user.getMname()); System.out.println(user.getPosition());
			 * System.out.println(user.getUsername());
			 * System.out.println(user.getPassword()); });
			 */
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public void searchVaccineList(String search) {
		query = "Select * from vaccinelist where VaccineName like '%"+search+"%' ";
				try {
					st=conn.createStatement();
					rs=st.executeQuery(query);
					vacList.clear();
					while(rs.next()) {
						int id = rs.getInt("vaccineid");
						String vacname = rs.getString("VaccineName");
						int qty = rs.getInt("VaccineQuantity");
						Date manuDate=rs.getDate("manufacturedate");
						Date expDate = rs.getDate("expirationdate");
						vaccInfo vac= new vaccInfo(id,vacname,qty,manuDate,expDate);
						vacList.add(vac);
					}
				}catch(Exception e) {
					System.out.println(e);
				}
	}
	public void searchMediccine(String search) {
		query=" select * from transactionrecord where brandname like '%"+search+"%' OR GenericName = '%"+search+"%' OR ResidentFullName ='%"+search+"%'";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			transList.clear();
			while(rs.next()) {
				int tid= rs.getInt("TransId");
				String brandName = rs.getString("brandname");
				String genericname = rs.getString("genericname");
				int qty = rs.getInt("Quantity");
				String date = rs.getString("TransactionDate");
				int resid = rs.getInt("ResidentId");
				String fullname = rs.getString("ResidentFullName");
				String mMeasure = rs.getString("MetricMeasurement");
				int measure = rs.getInt("Measurement");
				transactionList trans = new transactionList(tid,brandName,genericname,qty,date,resid,fullname, mMeasure, measure);
				transList.add(trans);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void sortMedByDate(String from, String until) {
		query="select * from transactionrecord where transactiondate between '"+from+"' AND '"+until+"'";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			transList.clear();
			while(rs.next()) {
				int tid= rs.getInt("TransId");
				String brandName = rs.getString("brandname");
				String genericname = rs.getString("genericname");
				int qty = rs.getInt("Quantity");
				String date = rs.getString("TransactionDate");
				int resid = rs.getInt("ResidentId");
				String fullname = rs.getString("ResidentFullName");
				String mMeasure = rs.getString("MetricMeasurement");
				int measure = rs.getInt("Measurement");
				transactionList trans = new transactionList(tid,brandName,genericname,qty,date,resid,fullname, mMeasure, measure);
				transList.add(trans);
							}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	public void searchVaccine(String search) {
		query = "select * from tblinfantvaccinated where ResidentFullName like '%"+search+"%' OR VaccineName LIKE '%"+search+"%';";
		try {
			allVaccineRecordList.clear();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				int resid = rs.getInt("resid");
				String fullname = rs.getString("ResidentFullName");
				int vacid = rs.getInt("vacid");
				String vacname = rs.getString("VaccineName");
				int dozes = rs.getInt("Dozes");
				String date =rs.getString("datevaccinated");
				allVaccineRecord vac = new allVaccineRecord(resid,fullname,vacid,vacname,dozes,date);
				allVaccineRecordList.add(vac);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void sortVaccineByDate(String from, String until) {

		query="select * from tblinfantvaccinated where datevaccinated between '"+from+"' AND '"+until+"'";
		try {
			System.out.print(from+" "+until);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			allVaccineRecordList.clear();
			while(rs.next()) {
				int resid = rs.getInt("resid");
				String fullname = rs.getString("ResidentFullName");
				int vacid = rs.getInt("vacid");
				String vacname = rs.getString("VaccineName");
				int dozes = rs.getInt("Dozes");
				String date =rs.getString("datevaccinated");
				allVaccineRecord vac = new allVaccineRecord(resid,fullname,vacid,vacname,dozes,date);
				allVaccineRecordList.add(vac);
			
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public int getAdminCount() {
		int count=0;
		query="select count(*) as num from users where position='Admin'";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				count= rs.getInt("num");
				return count;	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return count;
	}
	public int getEmpCount() {
		int count=0;
		query="select count(*) as num from users where position='employee'";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				count= rs.getInt("num");
				return count;	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return count;
	}
	public int getNumberOfUsers() {
		int num =0;
		query="SELECT Count(*)as num from users";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				num= rs.getInt("num");
				return num;	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return num;
	}
	public void deleteVaccine(int id) {
		query="Delete from vaccineList where vaccineid="+id;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void updateVaccine(int id, String vacname, int vacqty, String manudate, String expidate) {
		query="UPDATE vaccinelist SET VaccineName = '"+vacname+"', VaccineQuantity="+vacqty+", manufacturedate='"+manudate+"', expirationdate='"+expidate;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public int getVaccineMaxId() {
		int maxid=0;
		query="select max(VaccineId) as id from vaccinelist";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				maxid= rs.getInt("id")+1;
				return maxid;	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return maxid;
	}
	public void addVaccine(String vacname, int vacqty, String manudate, String expidate) {
		query="INSERT INTO vaccinelist values("+getVaccineMaxId()+", '"+vacname+"', "
				+ vacqty+", '"+manudate+"', '"+expidate+"')";
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void populateTransactionRecords() {
		query = "select * from transactionrecord;";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			transList.clear();
			while(rs.next()) {
				int tid= rs.getInt("TransId");
				String brandName = rs.getString("brandname");
				String genericname = rs.getString("genericname");
				int qty = rs.getInt("Quantity");
				String date = rs.getString("TransactionDate");
				int resid = rs.getInt("ResidentId");
				String fullname = rs.getString("ResidentFullName");
				String mMeasure = rs.getString("MetricMeasurement");
				int measure = rs.getInt("Measurement");
				transactionList trans = new transactionList(tid,brandName,genericname,qty,date,resid,fullname, mMeasure, measure);
				transList.add(trans);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void populateTblAllVacRecord() {
		query = "select * from tblinfantvaccinated;";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			allVaccineRecordList.clear();
			while(rs.next()) {
				int resid = rs.getInt("resid");
				String fullname = rs.getString("ResidentFullName");
				int vacid = rs.getInt("vacid");
				String vacname = rs.getString("VaccineName");
				int dozes = rs.getInt("Dozes");
				String date =rs.getString("datevaccinated");
				allVaccineRecord vac = new allVaccineRecord(resid,fullname,vacid,vacname,dozes,date);
				allVaccineRecordList.add(vac);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void populateTblMedRecord(int id) {
		query = "select brandname, genericname, SUM(quantity) as TotalQuantity, MAX(transactiondate) as transactiondate from transactionrecord where residentid="+id+" group by brandname";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			medRecordInfoList.clear();
			while(rs.next()) {
				String brand = rs.getString("brandname");
				String genericname = rs.getString("genericname");
				String transaction = rs.getString("transactiondate");
				int qty = rs.getInt("TotalQuantity");
				medRecordInfo medrec = new medRecordInfo(brand,genericname,qty,transaction);
				medRecordInfoList.add(medrec);
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public void populateTblResidentRecord() {
		query ="select CONCAT(ResidentFirstName, ' ' , ResidentMiddleName, ' ', ResidentLastName) as fullname, "
				+ "CONCAT(StreetAddress, BarangayAddress, CityAddress, ProvinceAddress) as address, gender, "
				+ "birthdate, CivilStatus, Category, PWDSpecification, Occupation, imagepath, ResidentId from "
				+ "Residents where residentid in (select residentid from transactionrecord);";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			residentRecordList.clear();
			while(rs.next()) {
				int id = rs.getInt("ResidentId");
				String fullname=rs.getString("fullname");
				String address = rs.getString("Address");
				String gender = rs.getString("gender");
				String birthdate = rs.getString("birthdate");
				String civilStatus = rs.getString("CivilStatus");
				String category = rs.getString("Category");
				String pwd = rs.getString("PWDSpecification");
				String occupation = rs.getString("Occupation");
				String imagepath = rs.getString("imagepath");
				residentRecord res = new residentRecord(fullname,address,gender,birthdate,civilStatus,category,pwd,occupation,imagepath,id);
				
				residentRecordList.add(res);
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	public void populateTblVaccineRecord(int resid) {
		query="select v.vaccinename, SUM(i.dozes) AS Dozes, Max(i.datevaccinated) as lastvaccinated from vaccinelist v inner join tblinfantvaccinated i on v.vaccineid = i.vacid where i.resid="+resid+" group by vaccinename";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(query);
			tblVaccineRecordList.clear();
			while(rs.next()) {
				String vacname = rs.getString("vaccinename");
				int dozes = rs.getInt("dozes");
				String date = rs.getString("lastvaccinated");
				tblVaccineRecord vac = new tblVaccineRecord(vacname,dozes,date);
				tblVaccineRecordList.add(vac);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addDupInTable(int idmed, int quantity, int resid) {
		query = "UPDATE tblvaccinerecord set Dozes = Dozes +"+quantity+", remaningdozes ="+quantity+" Where vacid="+idmed+" and residentid="+resid;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			System.out.print(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean checkDupVacineInTable(int id) {
		query ="SELECT * from tblvaccinerecord";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if(rs.getInt("vacid")==id) {
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public void addVaccineInTable( int id, int vacid, String vacname,int dozes, int dozesRemaining, int resid, String status) {
		
		query="INSERT INTO tblvaccinerecord VALUES("+id+", "+ resid+", "+vacid+", '"+vacname+"', "+dozes+", "+dozesRemaining+", '"+status+"')";
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateInfantInfo2(int resid, String moname, String faname, String birthplace, String height, String weight) {
		query ="Update InfantInfo set mothersname= '"+moname+"',"
				+ " fathersname = '"+faname+"', birthplace='"+birthplace+"', height='"+height+"', weight='"+weight+"'";
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public void updateInfantInfo(int resid, String gender, String fullname, String dob, String address) {
		query="UPDATE InfantInfo set babyfullname='"+fullname+"', gender ='"+gender+"', dateofbirth ='"+dob+"', address='"+address+"'";
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public void removeRemark(int vacid, int resid) {
		for(vaccineList o: vaccineList) {
			if(o.getId()==vacid) {
				o.setStatus("");
			}
		}
		query="UPDATE tblvaccinerecord SET Status =' ' WHERE ResidentId="+resid+" AND VacId="+vacid;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void updateRemarks(int vacid, int resid) {
		
		for(vaccineList o: vaccineList) {
			if(o.getId()==vacid) {
				o.setStatus("COMPLETE");
			}
		}
		
		query="UPDATE tblvaccinerecord SET Status ='COMPLETE' WHERE ResidentId="+resid+" AND VacId="+vacid;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void addDupVaccine(int id, int quantity) {
		for(vaccineList o: vaccineList) {
			if(o.getId()==id) {
				o.setQty(o.getQty()+quantity);
			}
		}
	}
	
	public void dataRemoveFromVacList(int id) {
		   try {
	            for (vaccineList o: vaccineList){
	                if (id == o.getId()){
	                	vaccineList.remove(o);
	                    return;
	                }
	            }
	        } catch (Exception e){
	            System.out.println(e);
	        }
	}
	public void updateRemainingDozes(int id, int newDozes) {
		query = "UPDATE tblvaccinerecord set remaningdozes = "+ newDozes+" Where vacid="+id;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean checkDupVaccine(String vacname) {
		
		for(vaccineList c: vaccineList) {
			if(c.getVacname().equalsIgnoreCase(vacname)) {
				return true;
			}
		}
		return false;

	}
	public boolean checkIfRemainingDozesIsZero(int id) {
		if(id == 0) {
			return true;
		}
		return false;
	}
	public int getMaxIdInInfant() {
		int id=0;
		query="SELECT MAX(id) from tblinfantvaccinated;";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				
				if(rs.getInt("MAX(id)")==0) {
					id=1;
					System.out.print(id);
				}
				else {
					id+=rs.getInt("MAX(id)")+1;
					System.out.print(id);
				}
			}
			
			return id;
		}catch(Exception e) {
			System.out.println(e);
		}
		return id;
		
	
		
	}
	

	public void addrecordInInfantVaccinated(int resid, String fullname, int vacid, String vacname,
			int dozes, String datevaccinated) {
		query = "INSERT INTO tblinfantvaccinated values("+getMaxIdInInfant()+", "
				+ resid+", '"+fullname+"', "+vacid+", '"+vacname+"', "+dozes+", '"+datevaccinated+"')";
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void populateVacList(int resid) {
			query = "select * from tblvaccinerecord where residentid ="+resid;
			try {
				st=conn.createStatement();
				rs=st.executeQuery(query);
				vaccineList.clear();
				while(rs.next()) {
					
					int id = rs.getInt("vacid");
					String vacname = rs.getString("vacname");
					int dozes = rs.getInt("dozes");
					int remainingdozes = rs.getInt("remaningdozes");

					vaccineList vac = new vaccineList(id,vacname,dozes,remainingdozes,null);
					vaccineList.add(vac);
				}
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	public void addInfantInfo(int resid, String infantName, String dob, String birthplace,
			String gender, String address, String mothersname, String fathersname, String weight, String height) {
		query= "INSERT INTO infantinfo VALUES("+getMaxIdfromInfanInfo()+", "+resid+", '"+infantName+"',"
				+ " '"+dob+"', '"+ birthplace+"', '"+ gender+"', '"+address+"', '"
				+mothersname+"', '"+fathersname+"', '"+height+"', '"+weight+"') ";
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void deleteRes(int resid) {
		  query = "DELETE FROM residents WHERE Residentid = " + resid; 
		
	 try {
			st.executeUpdate(query);
			 st =conn.createStatement(); 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public int getMaxIdfromInfanInfo() {
		int id=0;
		query="SELECT MAX(id) from infantinfo";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				
				if(rs.getInt("MAX(id)")==0) {
					id=1;
					System.out.print(id);
				}
				else {
					id+=rs.getInt("MAX(id)")+1;
					System.out.print(id);
				}
			}
			
			return id;
		}catch(Exception e) {
			System.out.println(e);
		}
		return id;
	}
	
	public void populateTblInfantRegisteredBabies() {
		 query="select * from residents where residentid in(select DISTINCT residentid from tblvaccinerecord) and category ='infant'";
		 try {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				st=conn.createStatement();
				rs=st.executeQuery(query);
				babyList.clear();
				while(rs.next()) {
					int id = rs.getInt("ResidentId");
					String fullname = rs.getString("ResidentFirstName") + " "+rs.getString("ResidentMiddleName")
					+" "+rs.getString("ResidentLastName");
					String fulladd = rs.getString("StreetAddress")+", "+rs.getString("BarangayAddress")+
							", "+rs.getString("CityAddress")+", "+rs.getString("ProvinceAddress");
					String gender = rs.getString("Gender");
					String bdate = simpleDateFormat.format(rs.getDate("Birthdate"));
					String photo = rs.getString("imagepath");
					babyInfo info = new babyInfo(id,fullname,fulladd,gender,bdate,photo);
					babyList.add(info);
					}
		 }catch(Exception e) {
			 System.out.println(e);
		 }
		 
	}
	public int getmaxId() {
		int id=0;
		query="SELECT MAX(id) from tblvaccinerecord";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				
				if(rs.getInt("MAX(id)")==0) {
					id=1;
					System.out.print(id);
				}
				else {
					id+=rs.getInt("MAX(id)")+1;
					System.out.print(id);
				}
			}
			
			return id;
		}catch(Exception e) {
			System.out.println(e);
		}
		return id;
	}
	
	
	public void addVaccineRecord( int id, int vacid, String vacname,int dozes, int dozesRemaining, int resid, String status) {
		
		query="INSERT INTO tblvaccinerecord VALUES("+id+", "+ resid+", "+vacid+", '"+vacname+"', "+dozes+", "+dozesRemaining+", '"+status+"')";
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateVaccineQty(int id, int newQty) {
		query = "UPDATE vaccineList SET VaccineQuantity ="+newQty+" WHERE vaccineid="+id;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void addVacList(int id, String fullname, int qty, int stock) {
		vaccineList vac = new vaccineList(id,fullname,qty,stock,null);
		vaccineList.add(vac);
	}
	public boolean checkInVacList(int id) {
		try {
			query = "Select vaccineid from vaccineList where vaccineid = "+id;
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while (rs.next()) {
				if(rs.getInt("vaccineid")==id) {
					return true;
				}else {
					return false;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public void populatetblVac() {
		query = "Select * from vaccineList";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			vacList.clear();
			while(rs.next()) {
				int id = rs.getInt("vaccineid");
				String vacname = rs.getString("VaccineName");
				int qty = rs.getInt("VaccineQuantity");
				Date manuDate=rs.getDate("manufacturedate");
				Date expDate = rs.getDate("expirationdate");
				vaccInfo vac= new vaccInfo(id,vacname,qty,manuDate,expDate);
				vacList.add(vac);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void populatetblResident() {
		query = "SELECT * from residents;";
		getDatafromResident(query);
		
	}
	
	
	public boolean checkUser(String username) {
		//username="test"
		try {
			//Select Username from users where Username = 'test'
			query = "Select Username from users where Username = '"+username+"'";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while (rs.next()) {
				String uName = rs.getString("Username");
				//uNmae = "test";
				//uName == iserm
				if (uName.equalsIgnoreCase(username)) {

					return true;
				} 
				else{
					
				}return false;
				
			}
		} catch (Exception e) {
			System.out.print(e +"hello");
		}
		return false;

	}

	public void populateJtable() {

		try {
			query = "Select * from users";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			userList.clear();
			while (rs.next()) {
				int id = rs.getInt("UserId");
				String lname = rs.getString("LName");
				String fname = rs.getString("FName");
				String mname = rs.getString("MName");
				String position = rs.getString("Position");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String status = rs.getString("Status");
				users newUsers = new users(id, lname, fname, mname, position, username, password, status);
				userList.add(newUsers);
			}
			/*
			 * userList.forEach(user -> { System.out.println(user.getId());
			 * System.out.println(user.getLname()); System.out.println(user.getFname());
			 * System.out.println(user.getMname()); System.out.println(user.getPosition());
			 * System.out.println(user.getUsername());
			 * System.out.println(user.getPassword()); });
			 */
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public boolean checkIfUsernameIsAdmin(String username) {
		try {
			query = "Select Position,  Username  from users where Username = '" + username + "'";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("Username").equals(username)) {
					if(rs.getString("Position").equalsIgnoreCase("Admin")) {
						return true;
					}
				}
				return false;
			}
		}catch(Exception e) {
			
			System.out.println(e +"hello2") ;
			
		}
		return false;

	}
	public boolean checkIfEmployee(String username, String password) {
		try {
			query = "Select Position,  Username, password from users where Username = '" + username + "'";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("Username").equals(username) && rs.getString("Password").equals(password)) {
					if(rs.getString("Position").equalsIgnoreCase("Employee")) {
						return true;
					}
				}
				return false;
			}
		}catch(Exception e) {
			System.out.print(e +"hello 3");
		}
		return false;
	}
	
	public boolean checkIfAdmin(String username, String password) {

		try {
			query = "Select Position,  Username, password from users where Username = '" + username + "'";
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while (rs.next()) {
				if(rs.getString("Username").equals(username) && rs.getString("Password").equals(password)) {
					if(rs.getString("Position").equalsIgnoreCase("Admin")) {
						return true;
					}
				}
				return false;
			}
		} catch (Exception e) {
			System.out.print(e +"hello4");
		}
		return false;
	}

	public void addUsers(int id, String lname, String fname, String mname, String position, String username,
			String password, String status) {
		try {
			
			 query = "INSERT INTO users VALUES (" + id + ", '" + lname + "', '" + fname +
			 "', '" + mname + "', '" + position + "', '" + username + "', '" + password +
			 "', '"+status+"');"; st = conn.createStatement(); st.executeUpdate(query);
			  populateJtable();
			 

		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public int getMaxIdUsers() {
		int maxid=0;
		try {
			query="select max(userid) from users";
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if(rs.getInt("max(userid)") ==0) {
					maxid=1;
					return maxid;
				}else {
					maxid=rs.getInt("max(userid)")+1;
					return maxid;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return maxid;
	}
	
	public void updateUser(int id, String lname, String fname, String mname, String pos, String uname, String pass, String status) {
		try {
			
			  query = "UPDATE users SET LName ='" + lname + "', FName = '" + fname +
					  "', MName = '" + mname + "', Position = '" + pos + "', Username = '" + uname
					  + "', Password = '" + pass + "', Status='"+status+"' WHERE UserId = " + id;
			 st =conn.createStatement(); 
			 st.executeUpdate(query); 
			  populateJtable();
			 
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void deleteUser(int id) {
		try {
			
			  query = "DELETE FROM users WHERE UserId = " + id; 
			  st =conn.createStatement(); 
			  st.executeUpdate(query); populateJtable();
			 
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public String getPassword(int id) {
		String pw = "";
		try {
			
			  query = "select Password from users where UserId = " + id; 
			  st = conn.createStatement(); 
			  rs = st.executeQuery(query); 
			  while (rs.next()) {
				  pw = rs.getString("Password"); 
				  return pw; 
				}
			 

		} catch (Exception e) {
			System.out.print(e);
		}

		return pw;
	}

	public boolean checkDupUsername(String uname) {
		for (int x = 0; x < userList.size(); x++) {
			if (uname.equalsIgnoreCase(userList.get(x).getUsername().toString())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkIfSameUsername(String uname, int empId) {
		try {
			
			  query = "select Username from users where UserId = " + empId; st =
			  conn.createStatement(); rs = st.executeQuery(query); while (rs.next()) { if
			  (rs.getString("Username").equals(uname)) { return true; } }
			 

		} catch (Exception e) {

		}
		return false;
	}

	public void populateTblMeds() {
			
			query = "Select * from medicines";
			generateDataforMeds(query);
	}

	
	private void generateDataforMeds(String query2) {
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			medList.clear();
			while (rs.next()) {
				
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				int id = rs.getInt("MedId");
				String bname = rs.getString("BrandName");
				String gname = rs.getString("GenericName");
				String category = rs.getString("Category");
				String mDate = String.valueOf(rs.getDate("ManufactureDate"));
				String eDate = String.valueOf(rs.getDate("ExpirationDate"));
				Date manuDate = simpleDateFormat.parse(mDate);
				Date expiDate = simpleDateFormat.parse(eDate);
				int qty = rs.getInt("Quantity");
				String metricmeasure = rs.getString("MetricMeasurement");
				int measure = rs.getInt("Measurement");
				
				medicines newMeds = new medicines(id, bname, gname, category, manuDate, expiDate,qty,metricmeasure,measure);
				
				medList.add(newMeds);
				
	
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void searchMed(String search) {
		query="Select * from medicines WHERE BrandName LIKE '%"+search+"%' OR GenericName LIKE '%"+search+"%'";
		generateDataforMeds(query);
		
	}
	
	
	public boolean checkDupBrandName(String bname) {
		for (int x = 0; x < medList.size(); x++) {
			if (bname.equals(medList.get(x).getbName().toString())) {
				return true;
			}
		}
		return false;
	}

	public void addMedicines(int id, int qty, String bname, String gname, String category, Date manuDate, Date ExpiDate, String metric, int measure) {
		try {
			
			  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
			  String manuDateFormatted = format1.format(manuDate); 
			  String expiDateFormatted = format1.format(ExpiDate); 
			  query = "INSERT INTO medicines VALUES (" + id +", '" + bname + 
					  "', '" +gname + "', '" + category + "', '" +  manuDateFormatted + 
					  "', '" + expiDateFormatted +"', "+qty+", '"+metric+"', "+measure+");"; 
			  st= conn.createStatement(); 
			  st.executeUpdate(query); 
			  populateTblMeds();
			 
			  
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public int getMaxIdMed() {
		int maxId = 0;
		
		try {
			query = "SELECT Max(MedId) from medicines";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if(rs.getInt("Max(MedId)")==0) {
					return maxId+1;
				}else {
					maxId = rs.getInt("Max(MedId)")+1;
					return maxId;
				}
			}
		}catch(Exception e) {
			
		}
		
		return maxId;
	}
	
	public void updateMeds(int id, int qty,String bName, String gName, String category, Date ManuDate, Date expDate, String mMeasure, int measure) {
		
		try {
			
			  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
			  String manuDateFormatted = format1.format(ManuDate); 
			  String expiDateFormatted = format1.format(expDate); 
			  query = "UPDATE medicines SET BrandName ='" + bName
			  + "', GenericName = '" + gName + "', Category = '" + category +
			  "', ManufactureDate = '" + manuDateFormatted + "', ExpirationDate = '" +
			  expiDateFormatted +"', Quantity = "+qty+", MetricMeasurement='"+mMeasure+"', Measurement="+measure+" WHERE MedId = " + id; 
			  st = conn.createStatement();
			  st.executeUpdate(query); 
			  populateJtable();
			 
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public boolean updateSameBrandName(String bName, int empId) {
		try {
			
			  query = "select BrandName from medicines where MedId = " + empId; 
			  st =conn.createStatement(); 
			  rs = st.executeQuery(query); 
			  while (rs.next()) { 
				  if (rs.getString("BrandName").equals(bName)) 
				  {
			  		  return true;
			  		  } 
				  }
			 
		} catch (Exception e) {
			System.out.print(e);
		}
		return false;
	}
	
	public void deleteMed(int id) {
		
		  try { query = "DELETE FROM medicines WHERE MedId = " + id; st =
		  conn.createStatement(); st.executeUpdate(query); populateTblMeds(); } catch
		  (Exception e) { System.out.print(e); }
		 
	}
	
	public void registerResident(String imgPath, String fname, 
			String mname, String lname, String street, String brgy, String city, 
			String provi, String gender, Date bday, String cstatus, String category,
			String pwdSpecific, String occupation, String posF ) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String bdate = format1.format(bday);

		int id = generateId();
				query = "INSERT INTO residents("
						+ "ResidentId, ResidentLastName,ResidentFirstName,"
						+ "ResidentMiddleName, StreetAddress, BarangayAddress,"
						+ "CityAddress, ProvinceAddress,Gender,Birthdate,CivilStatus,"
						+ "Category,PWDSpecification,Occupation,PositionInFamily,ImagePath ) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
			try {
				//InputStream img = new FileInputStream(new File(imgPath));
				//try ko muna mag preparedstatement di ko pa pala na try sa query lang hahaha
				
				//query = "INSERT INTO residents values("+id+", '"+lname+"','"+fname+"','"+mname+"', '"+street+"', "
						//+ "'"+brgy+"', '"+city+"', '"+provi+"', '"+gender+"', '"+bdate+"', '"+cstatus+"', '"+category+"', '"+pwdSpecific+"', '"+occupation+"', '"+posF+"', '"+imgPath+"')";
				//st=conn.createStatement();
			
				
				PreparedStatement st = conn.prepareStatement(query);
				// pano ba mag uncomment dito ng maramihan HAHAHA di pala pwede sir HAHAHA
				//di ko na talaga kabisado eclipse mano mano nalang
				
				//ayon so yun ang difference kapag kasi query lang tapos mag image nakasama
				//di talaga na display ang image kaya mas okay sana kung prepared stmt .sige po sir ntoed po HAHAHAA maraming salmaat po tanda mo ba? opo sir sige kapag may problem sabihan mo ako
				// Sige po sir maraming salamat p okay thanks din
				//wait lang pala may try lang ako sa difference nung dalawa
				st.setInt(1, id);
				st.setString(2, lname);
				st.setString(3, fname);
				st.setString(4, mname);
				st.setString(5, street);
				st.setString(6, brgy);
				st.setString(7, city);
				st.setString(8, provi);
				st.setString(9, gender);
				st.setString(10, bdate);
				st.setString(11, cstatus);
				st.setString(12, category);
				st.setString(13, pwdSpecific);
				st.setString(14, occupation);
				st.setString(15, posF);
				st.setString(16, imgPath);
				st.executeUpdate();
				
			} catch (Exception e) {
				System.out.print(e);
			}
	}
	
	public int generateId() {
		
		try {
			query="SELECT MAX(ResidentId) from residents";
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				id=rs.getInt("MAX(ResidentId)")+1;
			}
			return id;
		}catch(Exception e) {
			System.out.print(e);
		}
		return id;
	}
	
	public void searchResident(String search) {
		query="SELECT * FROM RESIDENTS WHERE ResidentLastName like '"+search+"%' OR  ResidentFirstName  like '"+search+"%' OR ResidentMiddleName like '"+search+"'";
		getDatafromResident(query);
	}
	
	public void getDatafromResident(String query) {
		try {
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			st=conn.createStatement();
			rs=st.executeQuery(query);
			residentList.clear();
			while(rs.next()) {
				int id = rs.getInt("ResidentId");
				String lname =rs.getString("ResidentLastName");
				String fname=rs.getString("ResidentFirstName");
				String mname=rs.getString("ResidentMiddleName");
				String street = rs.getString("StreetAddress");
				String brngy = rs.getString("BarangayAddress");
				String city = rs.getString("CityAddress");
				String province = rs.getString("ProvinceAddress");
				String gender=rs.getString("Gender");
				String bdate = simpleDateFormat.format(rs.getDate("Birthdate"));
				String civilStatus=rs.getString("CivilStatus");
				String category=rs.getString("Category");
				String pwdSpecify=rs.getString("PWDSpecification");
				String occupation=rs.getString("Occupation");
				String position=rs.getString("PositionInFamily");

				residentInfo info = new residentInfo(id,lname,fname,mname,street,
						brngy,city,province,gender,
						bdate,civilStatus,category,
						pwdSpecify,occupation,position,rs.getString("ImagePath"));
				residentList.add(info);

			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public void medicineSort(String sort) {
		
		if(sort.equalsIgnoreCase("Generic Name")) {
			query="SELECT * FROM medicines order by GenericName";
	
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Brand Name")) {
			query="SELECT * FROM medicines order by BrandName";
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Category")) {
			query="SELECT * FROM medicines order by Category";
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Manufactured Date")) {
			query="SELECT * FROM medicines order by ManufactureDate";
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Expiration Date")) {
			query="SELECT * FROM medicines order by ExpirationDate";
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Quantity")) {
			query="SELECT * FROM medicines order by Quantity";
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Metric Measurement")) {
			query="SELECT * FROM medicines order by MetricMeasurement";
			generateDataforMeds(query);
		}
		if(sort.equalsIgnoreCase("Measurement")) {
			query="SELECT * FROM medicines order by Measurement";
			generateDataforMeds(query);
		}
		
	}
	
	public int getNumberOfResidents() {
		try {
			query = "select count(*) from residents";
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				return rs.getInt(1);
			};
		}catch(Exception e){
			System.out.print(e);
		}
		return 0;
	}
	public int getNumOfBabies() {
		try {
			query = "select count(Category) from residents Where category = 'Infant'";
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				return rs.getInt(1);
			};
		}catch(Exception e){
			System.out.print(e);
		}
		return 0;
	}
	public int getNumOfPregnants() {
		try {
			query = "select count(Category) from residents Where category = 'Pregnant'";
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) {
				return rs.getInt(1);
			};
		}catch(Exception e){
			System.out.print(e);
		}
		return 0;
	}
	
	public void updateQuantity(int medid,int qty) {
		query ="UPDATE MEDICINES SET QUANTITY= "+qty+" WHERE MedId= "+medid;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			}catch(Exception e) {
			System.out.print(e);
		}
	}
	public void addCart(int medid, String bname, String gname, int qty,int stock) {
		try {
			
			cartid = getcartId();
			query="INSERT INTO cart VALUES("+cartid+", "+medid+",'"+bname+"','"+gname+"', "+qty+","+stock+");";
			st = conn.createStatement();
			 st.executeUpdate(query); 
			 populateTblCart();
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	public int getcartId() {
		/*
		 * try { query="SELECT MAX(id) from cart"; st=conn.createStatement();
		 * rs=st.executeQuery(query);
		 * 
		 * while(rs.next()) { cartid=rs.getInt("MAX(id)")+1; } System.out.print(cartid);
		 * return cartid; }catch(Exception e){ System.out.print(e); }
		 */
		Random random = new Random();
		cartid=random.nextInt(1000)+1+2+3;
		return cartid;
	}
	public void populateTblCart() {
		// TODO Auto-generated method stub
		try {
			query = "Select * from cart";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			cartList.clear();
			while(rs.next()) {
				int id = rs.getInt("id");
				int medId = rs.getInt("MedId");
				String bname = rs.getString("BrandName");
				String gname = rs.getString("GenericName");
				int stock = rs.getInt("stock");
				int qty = rs.getInt("Quantity");
				
				cart newCart = new cart(id,medId,bname,gname,qty,stock);
				cartList.add(newCart);
				
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public void updateCart(int cartid,int qty) {
		query ="UPDATE Cart SET Quantity= "+qty+" WHERE id= "+cartid;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			populateTblCart();
			}catch(Exception e) {
			System.out.print(e);
			
		}
	}
	public void clearCart() {
		cartList.clear();
		try {
			query="Truncate cart";
			st=conn.createStatement();
			st.executeQuery(query);
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public boolean checkDupItem(String bname) {
		for(cart c: cartList) {
			if(c.getBname().equals(bname)) {
				return true;
			}
		}
		return false;
	}

	public void addSameItem(int medid, int qty) {
		query="Update cart Set Quantity = (Quantity +"+ qty+") where MedId="+medid;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			populateTblCart();
			}catch(Exception e) {
			System.out.print(e);
			
		}
	
	}
	public void deleteFromCart(int medId) {
		query = "Delete from cart where MedId="+medId;
		try {
			st=conn.createStatement();
			st.executeUpdate(query);
			populateTblCart();
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public boolean CheckIfTransIsempty() {
		query="SELECT Count(*)from transactionrecord;";
		int count=0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				count=rs.getInt("Count(*)");
			}
			if(count==0) {
				return true;
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		return false;
	}
	public int getMaximumTransactionId() {
		query="SELECT MAX(TransId) from transactionrecord";
		int transid=0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				transid=rs.getInt("MAX(TransId)")+1;
			}
			return transid;
		}catch(Exception e) {
			System.out.print(e);
		}
		return transid;
	}
	public void populateTransRecord() {
		
	}
	
	public void addTransactionRecord(int transid, String brandName, String genName, int qty, Date transDate, int resid, String resName) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String tdate = format1.format(transDate);
		
		try {
			query="INSERT INTO transactionrecord values("+transid+", '"+brandName+"','"+genName+"', "+qty+", '"+tdate+"' , "+resid+", '"+resName+"')";
			 st.executeUpdate(query);
			 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public int countMedicines() {
		int med=0;
		try {
			query ="SELECT Count(*) from medicines";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				med=rs.getInt("Count(*)");
			}
			return med;
		}catch(Exception e) {
			System.out.println(e);
		}
		return med;
	}
	
	public int countZeroQtyVaccine() {
		int count = 0;
		try {
			query="select count(*) from vaccinelist where vaccinequantity = 0";
			st=conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				count = rs.getInt("Count(*)")+1;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	public int countZeroQty() {
		int count=0;
		try {
			query ="SELECT Count(*) from medicines where Quantity = 0";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				count=rs.getInt("Count(*)");
			}
			return count;
		}catch(Exception e) {
			System.out.println(e);
		}
		return count;
	}
	public void updateResident(int resId, String fname, String mname, String lname,
			String gender, Date bdate, String position, String street, String bgy, String city
			,String province, String occupation, String civilStatus, String Category,
			String pwdSpec, String imgPath) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String newBdate = format1.format(bdate);
		query="UPDATE residents SET ResidentLastName= ?,"
				+ "ResidentFirstName= ?,"
				+ "ResidentMiddleName= ?,"
				+ "StreetAddress= ?,"
				+ "BarangayAddress= ?,"
				+ "CityAddress= ?,"
				+ "ProvinceAddress= ?,"
				+ "Gender= ?,"
				+ "Birthdate= ?,"
				+ "CivilStatus= ?,"
				+ "Category= ?,"
				+ "PWDSpecification= ?,"
				+ "Occupation= ?,"
				+ "PositionInFamily= ?,"
				+ "imagepath= ?"
				+ "WHERE ResidentId= ?;";
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, lname);
			pst.setString(2, fname);
			pst.setString(3, mname);
			pst.setString(4, street);
			pst.setString(5, bgy);
			pst.setString(6, city);
			pst.setString(7, province);
			pst.setString(8, gender);
			pst.setString(9, newBdate);
			pst.setString(10, civilStatus);
			pst.setString(11, Category);
			pst.setString(12, pwdSpec);
			pst.setString(13, occupation);
			pst.setString(14, position);
			pst.setString(15, imgPath);
			pst.setInt(16, resId);
			pst.executeUpdate();
			populatetblResident();
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void searchTblInfant(String search) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		query = "SELECT * FROM RESIDENTS WHERE RESIDENTID NOT IN(select resid from infantinfo) "
				+ "AND CATEGORY ='infant' and (ResidentFirstName like '%"+search+"%' OR "
						+ "residentLastnAme like '%"+search+"%' or residentMiddleName like '%"+search+"%');";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			babyList.clear();
			while(rs.next()) {
				int id = rs.getInt("ResidentId");
				String fullname = rs.getString("ResidentFirstName") + " "+rs.getString("ResidentMiddleName")
				+" "+rs.getString("ResidentLastName");
				String fulladd = rs.getString("StreetAddress")+", "+rs.getString("BarangayAddress")+
						", "+rs.getString("CityAddress")+", "+rs.getString("ProvinceAddress");
				String gender = rs.getString("Gender");
				String bdate = simpleDateFormat.format(rs.getDate("Birthdate"));
				String photo = rs.getString("imagepath");
				babyInfo info = new babyInfo(id,fullname,fulladd,gender,bdate,photo);
				babyList.add(info);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void populateTblInfant() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		query = "SELECT * FROM RESIDENTS WHERE RESIDENTID NOT IN(select resid from infantinfo) AND CATEGORY ='infant';";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(query);
			babyList.clear();
			while(rs.next()) {
				int id = rs.getInt("ResidentId");
				String fullname = rs.getString("ResidentFirstName") + " "+rs.getString("ResidentMiddleName")
				+" "+rs.getString("ResidentLastName");
				String fulladd = rs.getString("StreetAddress")+", "+rs.getString("BarangayAddress")+
						", "+rs.getString("CityAddress")+", "+rs.getString("ProvinceAddress");
				String gender = rs.getString("Gender");
				String bdate = simpleDateFormat.format(rs.getDate("Birthdate"));
				String photo = rs.getString("imagepath");
				babyInfo info = new babyInfo(id,fullname,fulladd,gender,bdate,photo);
				babyList.add(info);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
