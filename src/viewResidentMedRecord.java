import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class viewResidentMedRecord extends JFrame {


	private JButton btnBack;
	private JPanel panel;
	private JButton btnClose;
	private JPanel contentPane;
	private JTable tblResidentRecords;
	private data Data;
	private DefaultTableModel tblResidentRecordsModel;
	private DefaultTableModel tblMedListModel;
	private JPanel pnlViewInfo;
	private JTable tblMedList;
	private JTextField txtFullname;
	private JTextField txtDob;
	private JTextField txtGender;
	private JTextField txtAddress;
	private JPanel pnlRegInfants;
	private int resid=0;
	private JLabel lblNewLabel_2;
	private JButton btnBackImmun;
	private String fullname;
	private String address;
	private String gender;
	private String birthdate;
	private String civilStatus;
	private String category;
	private String pwd;
	private String occupation;
	private DefaultTableModel tblAvailVaccineModel;
	private JLabel imgHolder;
	private JTextField textField;
	private JLabel lblCivilStatus;
	private JTextField txtCivilStatus;
	private JLabel lblCategory;
	private JTextField txtPwdSpec;
	private JLabel lblPwdSpecification;
	private JTextField txtCategory;
	private JLabel lblOccupation;
	private JTextField txtOccupation;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewResidentMedRecord frame = new viewResidentMedRecord();
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
	public viewResidentMedRecord() {
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
		
		JLabel lblNewLabel = new JLabel("FULLNAME:");
		lblNewLabel.setBounds(10, 70, 73, 14);
		pnlViewInfo.add(lblNewLabel);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
		lblDateOfBirth.setBounds(10, 126, 80, 14);
		pnlViewInfo.add(lblDateOfBirth);
		
		JLabel lblSex = new JLabel("GENDER");
		lblSex.setBounds(10, 151, 40, 14);
		pnlViewInfo.add(lblSex);
		
		JLabel lblAddress_1 = new JLabel("ADDRESS:");
		lblAddress_1.setBounds(10, 98, 50, 14);
		pnlViewInfo.add(lblAddress_1);
		
		imgHolder = new JLabel("");
		imgHolder.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\pngfind.png"));
		imgHolder.setBounds(584, 44, 140, 140);
		pnlViewInfo.add(imgHolder);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 252, 714, 314);
		pnlViewInfo.add(scrollPane_1);
		
		tblMedList = new JTable();
		scrollPane_1.setViewportView(tblMedList);
		
		txtFullname = new JTextField();
		txtFullname.setEnabled(false);
		txtFullname.setOpaque(false);
		txtFullname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtFullname.setBounds(93, 67, 267, 17);
		pnlViewInfo.add(txtFullname);
		txtFullname.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setEnabled(false);
		txtDob.setOpaque(false);
		txtDob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDob.setColumns(10);
		txtDob.setBounds(93, 123, 132, 17);
		pnlViewInfo.add(txtDob);
		
		txtGender = new JTextField();
		txtGender.setEnabled(false);
		txtGender.setOpaque(false);
		txtGender.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtGender.setColumns(10);
		txtGender.setBounds(93, 148, 132, 17);
		pnlViewInfo.add(txtGender);
		
		txtAddress = new JTextField();
		txtAddress.setEnabled(false);
		txtAddress.setOpaque(false);
		txtAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtAddress.setColumns(10);
		txtAddress.setBounds(93, 95, 267, 17);
		pnlViewInfo.add(txtAddress);
		
		textField = new JTextField();
		textField.setBounds(70, 211, 176, 30);
		pnlViewInfo.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress_1_1 = new JLabel("SEARCH:");
		lblAddress_1_1.setBounds(10, 219, 50, 14);
		pnlViewInfo.add(lblAddress_1_1);
		
		lblCivilStatus = new JLabel("CIVIL STATUS:");
		lblCivilStatus.setBounds(10, 176, 71, 14);
		pnlViewInfo.add(lblCivilStatus);
		
		txtCivilStatus = new JTextField();
		txtCivilStatus.setEnabled(false);
		txtCivilStatus.setOpaque(false);
		txtCivilStatus.setColumns(10);
		txtCivilStatus.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCivilStatus.setBounds(93, 173, 132, 17);
		pnlViewInfo.add(txtCivilStatus);
		
		lblCategory = new JLabel("CATEGORY:");
		lblCategory.setBounds(256, 151, 58, 14);
		pnlViewInfo.add(lblCategory);
		
		txtPwdSpec = new JTextField();
		txtPwdSpec.setEnabled(false);
		txtPwdSpec.setOpaque(false);
		txtPwdSpec.setColumns(10);
		txtPwdSpec.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPwdSpec.setBounds(370, 175, 132, 17);
		pnlViewInfo.add(txtPwdSpec);
		
		lblPwdSpecification = new JLabel("PWD SPECIFICATION");
		lblPwdSpecification.setBounds(256, 176, 104, 14);
		pnlViewInfo.add(lblPwdSpecification);
		
		txtCategory = new JTextField();
		txtCategory.setEnabled(false);
		txtCategory.setOpaque(false);
		txtCategory.setColumns(10);
		txtCategory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCategory.setBounds(370, 150, 132, 17);
		pnlViewInfo.add(txtCategory);
		
		lblOccupation = new JLabel("OCCUPATION:");
		lblOccupation.setBounds(256, 126, 71, 14);
		pnlViewInfo.add(lblOccupation);
		
		txtOccupation = new JTextField();
		txtOccupation.setEnabled(false);
		txtOccupation.setOpaque(false);
		txtOccupation.setColumns(10);
		txtOccupation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtOccupation.setBounds(370, 117, 132, 17);
		pnlViewInfo.add(txtOccupation);
		
		pnlRegInfants = new JPanel();
		pnlRegInfants.setBounds(0, 0, 633, 461);
		contentPane.add(pnlRegInfants);
		pnlRegInfants.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 613, 338);
		pnlRegInfants.add(scrollPane);
		
		tblResidentRecords = new JTable();
		scrollPane.setViewportView(tblResidentRecords);
		
		lblNewLabel_2 = new JLabel("VIEW RESIDENT RECORD");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 21));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(109, 46, 398, 44);
		pnlRegInfants.add(lblNewLabel_2);
		generateResidentRecord(Data);
		centerScreen();
	
	}
	public void generateResidentRecord(data Data) {
		centerScreen();
		Data.populateTblResidentRecord();
		String[] colsMenu = {"Image", "Fullname","","id"};
		tblResidentRecordsModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {
				if(column==0) {
					return Icon.class;
					}
				return Object.class;
				}
			};
		
		List<residentRecord> residentRecordList = Data.getResidentRecordList();
		for(residentRecord o: residentRecordList) {
			String img = o.getImagepath();
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
			tblResidentRecordsModel.addRow(newRow);
		}
		tblResidentRecords.setModel(tblResidentRecordsModel);
		tblResidentRecords.setRowHeight(100);
		tblResidentRecords.getColumnModel().getColumn(0).setMaxWidth(100);
		tblResidentRecords.getColumnModel().getColumn(0).setMinWidth(100);
		
		tblResidentRecords.getColumnModel().getColumn(2).setMaxWidth(100);
		tblResidentRecords.getColumnModel().getColumn(2).setMinWidth(100);
		tblResidentRecords.removeColumn(tblResidentRecords.getColumnModel().getColumn(3));
		 Action viewInfo = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ImageIcon newImage = null;
					int rowIndex = Integer.valueOf(e.getActionCommand());
					resid = Integer.parseInt(String.valueOf(tblResidentRecords.getModel().getValueAt(rowIndex, 3)));
					setBounds(100, 100, 750, 616);
					
					Data.populateVacList(resid);
					btnClose.setBounds(698, 0, 36, 36);
					panel.setBounds(0, 0, 734, 36);
					generateMedRecord(Data);
					Data.query="select CONCAT(ResidentFirstName, ' ' , ResidentMiddleName, ' ', ResidentLastName) as fullname, "
							+ "CONCAT(StreetAddress, BarangayAddress, CityAddress, ProvinceAddress) as address, gender, "
							+ "birthdate, CivilStatus, Category, PWDSpecification, Occupation, imagepath, ResidentId "
							+ "from Residents where residentid="+resid;
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
							fullname=Data.rs.getString("fullname");
							address = Data.rs.getString("Address");
							gender = Data.rs.getString("gender");
							birthdate = Data.rs.getString("birthdate");
							civilStatus = Data.rs.getString("CivilStatus");
							category = Data.rs.getString("Category");
							pwd = Data.rs.getString("PWDSpecification");
							occupation = Data.rs.getString("Occupation");
							
							txtFullname.setText(fullname);
							txtAddress.setText(address);
							txtGender.setText(gender);
							txtDob.setText(birthdate);
							txtCivilStatus.setText(civilStatus);
							txtCategory.setText(category);
							txtPwdSpec.setText(pwd);
							txtOccupation.setText(occupation);
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
		ButtonColumn buttonColumn = new ButtonColumn(tblResidentRecords, viewInfo, 2);
		
		
	}
	
	public void generateMedRecord(data Data) {
		centerScreen();
		Data.populateTblMedRecord(resid);
		String[] colsMenu = {"Brand Name", "Generic Name","Quantity","Last Transaction Date"};
		tblMedListModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		List<medRecordInfo> medRecordInfoList = Data.getMedRecordInfoList();
		for(medRecordInfo o: medRecordInfoList) {
		
			Object[] newRow = {o.getBrandName(), o.getGenericname(), o.getQuantity(), o.getDate()};
			tblMedListModel.addRow(newRow);
		}
		
		tblMedList.setModel(tblMedListModel);

		tblMedList.setRowHeight(50);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
