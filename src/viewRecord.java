import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class viewRecord extends JFrame {

	private JButton btnBack;
	private JPanel panel;
	private JButton btnClose;
	private JPanel contentPane;
	private JTable tblRecordedInfants;
	private data Data;
	private DefaultTableModel tblRecordedInfantsModel;
	private DefaultTableModel tblVaccineListModel;
	private JPanel pnlViewInfo;
	private JTable tblVaccineList;
	private JTextField txtChildsName;
	private JTextField txtDob;
	private JTextField txtGender;
	private JTextField txtBirthplace;
	private JTextField txtAddress;
	private JTextField txtMothersname;
	private JTextField txtFathersname;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JPanel pnlRegInfants;
	private int resid=0;
	private JLabel lblNewLabel_2;
	private JButton btnBackImmun;
	private String name;
	private String dob;
	private String birthplace;
	private String Gender;
	private String moname;
	private String faname;
	private String height;
	private String weight;
	private String address;
	private JTable tblAvailVaccineList;
	private DefaultTableModel tblAvailVaccineModel;
	private JLabel imgHolder;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewRecord frame = new viewRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewRecord() {
		Data = data.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 500);
		//setBounds(100, 100, 750, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 633, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeeFrame emp = new employeeFrame();
				emp.setVisible(true);
			}
		});
		btnBack.setFocusable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setOpaque(false);
		btnBack.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnBack.setBounds(0, 0, 36, 36);
		panel.add(btnBack);
		
		 btnClose = new JButton("");		
		 btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Close program", JOptionPane.YES_NO_OPTION);
				if(sel==0){
					System.exit(0);
				}
			}
		});
		btnClose.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\close-window-48.png"));
		btnClose.setOpaque(false);
		btnClose.setFocusable(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setBorder(null);
		btnClose.setBounds(597, 0, 36, 36);
		panel.add(btnClose);
		
		btnBackImmun = new JButton("");
		btnBackImmun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?","System Message", JOptionPane.YES_NO_OPTION);
				if(sel==0){
					btnClose.setBounds(597, 0, 36, 36);
					setBounds(100, 100, 647, 500);
					panel.setBounds(0, 0, 633, 36);
					btnBack.setVisible(true);
					btnBackImmun.setVisible(false);
					pnlRegInfants.setVisible(true);
					pnlViewInfo.setVisible(false);
				}
			}
		});
		btnBackImmun.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnBackImmun.setVisible(false);
		btnBackImmun.setOpaque(false);
		btnBackImmun.setFocusable(false);
		btnBackImmun.setContentAreaFilled(false);
		btnBackImmun.setBorderPainted(false);
		btnBackImmun.setBorder(null);
		btnBackImmun.setBounds(0, 0, 36, 36);
		panel.add(btnBackImmun);
		
		pnlViewInfo = new JPanel();
		pnlViewInfo.setVisible(false);
		pnlViewInfo.setBounds(0, 0, 734, 577);
		contentPane.add(pnlViewInfo);
		pnlViewInfo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHILD'S NAME:");
		lblNewLabel.setBounds(10, 70, 73, 14);
		pnlViewInfo.add(lblNewLabel);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
		lblDateOfBirth.setBounds(10, 95, 80, 14);
		pnlViewInfo.add(lblDateOfBirth);
		
		JLabel lblSex = new JLabel("SEX:");
		lblSex.setBounds(10, 120, 22, 14);
		pnlViewInfo.add(lblSex);
		
		JLabel lblAddress = new JLabel("BIRTHPLACE:");
		lblAddress.setBounds(10, 145, 65, 14);
		pnlViewInfo.add(lblAddress);
		
		JLabel lblMothersName = new JLabel("MOTHER'S NAME:");
		lblMothersName.setBounds(271, 70, 85, 14);
		pnlViewInfo.add(lblMothersName);
		
		JLabel lblFathersName = new JLabel("FATHER'S NAME:");
		lblFathersName.setBounds(271, 95, 82, 14);
		pnlViewInfo.add(lblFathersName);
		
		JLabel lblHeight = new JLabel("HEIGHT:");
		lblHeight.setBounds(271, 120, 41, 14);
		pnlViewInfo.add(lblHeight);
		
		JLabel lblAddress_1 = new JLabel("ADDRESS:");
		lblAddress_1.setBounds(10, 170, 50, 14);
		pnlViewInfo.add(lblAddress_1);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setBounds(271, 145, 40, 14);
		pnlViewInfo.add(lblWeight);
		
		imgHolder = new JLabel("");
		imgHolder.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\pngfind.png"));
		imgHolder.setBounds(584, 44, 140, 140);
		pnlViewInfo.add(imgHolder);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 252, 714, 314);
		pnlViewInfo.add(scrollPane_1);
		
		tblVaccineList = new JTable();
		scrollPane_1.setViewportView(tblVaccineList);
		
		txtChildsName = new JTextField();
		txtChildsName.setEnabled(false);
		txtChildsName.setOpaque(false);
		txtChildsName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtChildsName.setBounds(93, 67, 168, 17);
		pnlViewInfo.add(txtChildsName);
		txtChildsName.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setEnabled(false);
		txtDob.setOpaque(false);
		txtDob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDob.setColumns(10);
		txtDob.setBounds(93, 92, 168, 17);
		pnlViewInfo.add(txtDob);
		
		txtGender = new JTextField();
		txtGender.setEnabled(false);
		txtGender.setOpaque(false);
		txtGender.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtGender.setColumns(10);
		txtGender.setBounds(93, 117, 168, 17);
		pnlViewInfo.add(txtGender);
		
		txtBirthplace = new JTextField();
		txtBirthplace.setEnabled(false);
		txtBirthplace.setOpaque(false);
		txtBirthplace.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtBirthplace.setColumns(10);
		txtBirthplace.setBounds(93, 142, 168, 17);
		pnlViewInfo.add(txtBirthplace);
		
		txtAddress = new JTextField();
		txtAddress.setEnabled(false);
		txtAddress.setOpaque(false);
		txtAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtAddress.setColumns(10);
		txtAddress.setBounds(93, 167, 366, 17);
		pnlViewInfo.add(txtAddress);
		
		txtMothersname = new JTextField();
		txtMothersname.setEnabled(false);
		txtMothersname.setOpaque(false);
		txtMothersname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtMothersname.setColumns(10);
		txtMothersname.setBounds(366, 67, 168, 17);
		pnlViewInfo.add(txtMothersname);
		
		txtFathersname = new JTextField();
		txtFathersname.setEnabled(false);
		txtFathersname.setOpaque(false);
		txtFathersname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtFathersname.setColumns(10);
		txtFathersname.setBounds(366, 92, 168, 17);
		pnlViewInfo.add(txtFathersname);
		
		txtHeight = new JTextField();
		txtHeight.setEnabled(false);
		txtHeight.setOpaque(false);
		txtHeight.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtHeight.setColumns(10);
		txtHeight.setBounds(366, 117, 93, 17);
		pnlViewInfo.add(txtHeight);
		
		txtWeight = new JTextField();
		txtWeight.setEnabled(false);
		txtWeight.setOpaque(false);
		txtWeight.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtWeight.setColumns(10);
		txtWeight.setBounds(366, 142, 93, 17);
		pnlViewInfo.add(txtWeight);
		
		textField = new JTextField();
		textField.setBounds(93, 211, 176, 30);
		pnlViewInfo.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress_1_1 = new JLabel("SEARCH:");
		lblAddress_1_1.setBounds(10, 219, 50, 14);
		pnlViewInfo.add(lblAddress_1_1);
		
		pnlRegInfants = new JPanel();
		pnlRegInfants.setBounds(0, 0, 633, 461);
		contentPane.add(pnlRegInfants);
		pnlRegInfants.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 613, 338);
		pnlRegInfants.add(scrollPane);
		
		tblRecordedInfants = new JTable();
		scrollPane.setViewportView(tblRecordedInfants);
		
		lblNewLabel_2 = new JLabel("VIEW IMMUNIZATION INFORMATION");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 21));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(109, 46, 398, 44);
		pnlRegInfants.add(lblNewLabel_2);
		
		JPanel pnlVaccineList = new JPanel();
		pnlVaccineList.setVisible(false);
		pnlVaccineList.setBounds(0, 36, 633, 425);
		contentPane.add(pnlVaccineList);
		pnlVaccineList.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 101, 633, 263);
		pnlVaccineList.add(scrollPane_2);
		
		tblAvailVaccineList = new JTable();
		scrollPane_2.setViewportView(tblAvailVaccineList);
		
		JButton btnNewButton = new JButton("DONE");
		
		btnNewButton.setBounds(544, 391, 89, 34);
		pnlVaccineList.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlViewInfo.setVisible(true);
				pnlVaccineList.setVisible(false);
				setBounds(100, 100, 750, 616);
				Data.populateVacList(resid);
				btnClose.setBounds(698, 0, 36, 36);
				panel.setBounds(0, 0, 734, 36);
				
			}
		});
		generateTableInfant(Data);
		centerScreen();
	}

	public void generateTableInfant(data Data) {
		Data.populateTblInfantRegisteredBabies();
		String[] colsMenu = {"Image", "Fullname","","id"};
		tblRecordedInfantsModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {
				if(column==0) {
					return Icon.class;
					}
				return Object.class;
				}
			};
		
		List<babyInfo> babyList = Data.getBabyList();
		for(babyInfo o: babyList) {
			String img = o.getPhoto();
			ImageIcon newImage = null;
			
			if(img==null) {

				newImage=null;
			}else {				
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(100, 100 ,Image.SCALE_SMOOTH);
                newImage = new ImageIcon(myImg);
			}
			Object[] newRow = {newImage, o.getFullname(),"VIEW INFO",o.getId()};
			tblRecordedInfantsModel.addRow(newRow);
		}
		tblRecordedInfants.setModel(tblRecordedInfantsModel);
		tblRecordedInfants.setRowHeight(100);
		tblRecordedInfants.getColumnModel().getColumn(0).setMaxWidth(100);
		tblRecordedInfants.getColumnModel().getColumn(0).setMinWidth(100);
		
		tblRecordedInfants.getColumnModel().getColumn(2).setMaxWidth(100);
		tblRecordedInfants.getColumnModel().getColumn(2).setMinWidth(100);
		tblRecordedInfants.removeColumn(tblRecordedInfants.getColumnModel().getColumn(3));
		 Action viewInfo = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ImageIcon newImage = null;
					int rowIndex = Integer.valueOf(e.getActionCommand());
					resid = Integer.parseInt(String.valueOf(tblRecordedInfants.getModel().getValueAt(rowIndex, 3)));
					setBounds(100, 100, 750, 616);
					Data.populateVacList(resid);
					btnClose.setBounds(698, 0, 36, 36);
					panel.setBounds(0, 0, 734, 36);
					generateVacList(Data);
					Data.query="select CONCAT(r.ResidentFirstName,' ', r.ResidentMiddleName,' ', r.ResidentLastName)"
							+ " as fullname, CONCAT(r.StreetAddress, ', ', r.BarangayAddress, ', ', r.CityAddress, ', '"
							+ ", r.ProvinceAddress) as address, r.gender,r.imagepath,"
							+ "r.birthdate, i.birthplace, i.mothersname, "
							+ "i.fathersname, i.height, i.weight from residents r inner join infantinfo i on "
							+ "r.residentid=i.resid where i.resid="+resid;
					try {
						Data.st=Data.conn.createStatement();
						Data.rs=Data.st.executeQuery(Data.query);
						while(Data.rs.next()) {
							
							String img = Data.rs.getString("imagepath");
							System.out.print(img);
							if(img==null || img.equals("")) {
								newImage = new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\pngfind.png");
							}else {
								ImageIcon image = new ImageIcon(img);
					             Image im = image.getImage();
					             Image myImg = im.getScaledInstance(140, 140 ,Image.SCALE_SMOOTH);
					             newImage = new ImageIcon(myImg);
							}
							imgHolder.setIcon(newImage);
							name = Data.rs.getString("fullname");
							dob = Data.rs.getString("birthdate");
							birthplace = Data.rs.getString("birthplace");
							
							address = Data.rs.getString("address");
							Gender = Data.rs.getString("gender");
							moname = Data.rs.getString("mothersname");
							faname = Data.rs.getString("fathersname");
							height = Data.rs.getString("height");
							weight = Data.rs.getString("weight");
							
							txtChildsName.setText(name);
							txtDob.setText(dob);
							txtBirthplace.setText(birthplace);
							txtAddress.setText(address);
							txtGender.setText(Gender);
							txtMothersname.setText(moname);
							txtFathersname.setText(faname);
							txtHeight.setText(height);
							txtWeight.setText(weight);
							Data.updateInfantInfo(resid, Gender, name, dob, address);
							//image
						}
					
						btnBackImmun.setVisible(true);
						btnBack.setVisible(false);
						pnlViewInfo.setVisible(true);
						pnlRegInfants.setVisible(false);
					}catch(Exception es) {
						System.out.println(es);
					}
				}
			};
		ButtonColumn buttonColumn = new ButtonColumn(tblRecordedInfants, viewInfo, 2);
		
		
	}
	
	public void generateVacList(data Data) {
		Data.populateTblVaccineRecord(resid);
		String[] colsMenu = {"Vaccine Name", "Dozes","Date Vaccinated"};
		tblVaccineListModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		List<tblVaccineRecord> vacList = Data.getTblVaccineRecordList();
		for(tblVaccineRecord o: vacList) {
		
			Object[] newRow = {o.getVacciname(), o.getDozes(), o.getDate()};
			tblVaccineListModel.addRow(newRow);
		}
		tblVaccineList.setModel(tblVaccineListModel);

		tblVaccineList.setRowHeight(50);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
