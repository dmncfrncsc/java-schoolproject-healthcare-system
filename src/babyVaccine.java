import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.*;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class babyVaccine extends JFrame {
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
	private JButton btnSaveInfo;
	private JButton btnCancel;
	private JPanel pnlVaccineList;
	private JButton btnEditInfo;
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
	private JButton btnCancelEdiInfo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtSearch;
	private JButton btnAddVaccine;
	private JButton btnEditAdd;
	private JLabel lblNewLabel_5;
	private JTextField txtSearchInfantInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					babyVaccine frame = new babyVaccine();
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
	public babyVaccine() {
		Data = data.getInstance();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 500);
		//setBounds(100, 100, 750, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(36,46,50));
		panel.setBounds(0, 0, 647, 36);
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
		 btnClose.setBounds(611, 0, 36, 36);
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
				 						 				
				 						 				pnlRegInfants = new JPanel();
				 						 				pnlRegInfants.setBackground(new Color(74,94,104));
				 						 				pnlRegInfants.setBounds(0, 0, 647, 500);
				 						 				contentPane.add(pnlRegInfants);
				 						 				pnlRegInfants.setLayout(null);
				 						 				
				 						 				JScrollPane scrollPane = new JScrollPane();
				 						 				scrollPane.setBorder(null);
				 						 				scrollPane.setBounds(10, 151, 613, 338);
				 						 				scrollPane.getViewport().setBackground(new Color(36,46,50));
				 						 				pnlRegInfants.add(scrollPane);
				 						 				
				 						 				tblRecordedInfants = new JTable();
				 						 				tblRecordedInfants.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				tblRecordedInfants.setForeground(new Color(255, 255, 255));
				 						 				tblRecordedInfants.setBackground(new Color(36,46,50));
				 						 				scrollPane.setViewportView(tblRecordedInfants);
				 						 				
				 						 				lblNewLabel_2 = new JLabel("VIEW IMMUNIZATION INFORMATION");
				 						 				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 21));
				 						 				lblNewLabel_2.setForeground(Color.WHITE);
				 						 				lblNewLabel_2.setOpaque(true);
				 						 				lblNewLabel_2.setBackground(new Color(36,46,50));
				 						 				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				 						 				lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
				 						 				lblNewLabel_2.setBounds(109, 46, 398, 44);
				 						 				pnlRegInfants.add(lblNewLabel_2);
				 						 				
				 						 				lblNewLabel_5 = new JLabel("SEARCH:");
				 						 				lblNewLabel_5.setForeground(new Color(255, 255, 255));
				 						 				lblNewLabel_5.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
				 						 				lblNewLabel_5.setBounds(10, 115, 75, 25);
				 						 				pnlRegInfants.add(lblNewLabel_5);
				 						 				
				 						 				txtSearchInfantInfo = new JTextField();
				 						 				txtSearchInfantInfo.addKeyListener(new KeyAdapter() {
				 						 					@Override
				 						 					public void keyReleased(KeyEvent e) {
				 						 						if (txtSearchInfantInfo.getText().equals(null) || txtSearchInfantInfo.getText().equals("")) {
				 						 							Data.populateTblInfantRegisteredBabies();
				 						 							generateTableInfant(Data);
				 						 							}else {
				 						 								Data.searchInfantInfoRecord(txtSearchInfantInfo.getText());
				 						 								generateTableInfant(Data);
				 						 							}
				 						 					}
				 						 				});
				
				 						 				txtSearchInfantInfo.setBounds(95, 116, 174, 25);
				 						 				pnlRegInfants.add(txtSearchInfantInfo);
				 						 				txtSearchInfantInfo.setColumns(10);
				 						 				
				 						 				pnlViewInfo = new JPanel();
				 						 				pnlViewInfo.setBackground(new Color(74,94,104));
				 						 				pnlViewInfo.setVisible(false);
				 						 				pnlViewInfo.setBounds(0, 0, 750, 616);
				 						 				contentPane.add(pnlViewInfo);
				 						 				pnlViewInfo.setLayout(null);
				 						 				
				 						 				JLabel lblNewLabel = new JLabel("CHILD'S NAME:");
				 						 				lblNewLabel.setForeground(new Color(255, 255, 255));
				 						 				lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblNewLabel.setBounds(10, 117, 91, 20);
				 						 				pnlViewInfo.add(lblNewLabel);
				 						 				
				 						 				JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
				 						 				lblDateOfBirth.setForeground(new Color(255, 255, 255));
				 						 				lblDateOfBirth.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblDateOfBirth.setBounds(10, 142, 96, 20);
				 						 				pnlViewInfo.add(lblDateOfBirth);
				 						 				
				 						 				JLabel lblSex = new JLabel("SEX:");
				 						 				lblSex.setForeground(new Color(255, 255, 255));
				 						 				lblSex.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblSex.setBounds(10, 167, 25, 20);
				 						 				pnlViewInfo.add(lblSex);
				 						 				
				 						 				JLabel lblAddress = new JLabel("BIRTHPLACE:");
				 						 				lblAddress.setForeground(new Color(255, 255, 255));
				 						 				lblAddress.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblAddress.setBounds(10, 192, 77, 20);
				 						 				pnlViewInfo.add(lblAddress);
				 						 				
				 						 				JLabel lblMothersName = new JLabel("MOTHER'S NAME:");
				 						 				lblMothersName.setForeground(new Color(255, 255, 255));
				 						 				lblMothersName.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblMothersName.setBounds(289, 117, 109, 20);
				 						 				pnlViewInfo.add(lblMothersName);
				 						 				
				 						 				JLabel lblFathersName = new JLabel("FATHER'S NAME:");
				 						 				lblFathersName.setForeground(new Color(255, 255, 255));
				 						 				lblFathersName.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblFathersName.setBounds(289, 142, 102, 20);
				 						 				pnlViewInfo.add(lblFathersName);
				 						 				
				 						 				JLabel lblHeight = new JLabel("HEIGHT:");
				 						 				lblHeight.setForeground(new Color(255, 255, 255));
				 						 				lblHeight.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblHeight.setBounds(289, 167, 47, 20);
				 						 				pnlViewInfo.add(lblHeight);
				 						 				
				 						 				JLabel lblAddress_1 = new JLabel("ADDRESS:");
				 						 				lblAddress_1.setForeground(new Color(255, 255, 255));
				 						 				lblAddress_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblAddress_1.setBounds(10, 217, 59, 20);
				 						 				pnlViewInfo.add(lblAddress_1);
				 						 				
				 						 				JLabel lblWeight = new JLabel("WEIGHT");
				 						 				lblWeight.setForeground(new Color(255, 255, 255));
				 						 				lblWeight.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				lblWeight.setBounds(289, 192, 48, 20);
				 						 				pnlViewInfo.add(lblWeight);
				 						 				
				 						 				imgHolder = new JLabel("");
				 						 				imgHolder.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\pngfind.png"));
				 						 				imgHolder.setBounds(600, 117, 140, 140);
				 						 				pnlViewInfo.add(imgHolder);
				 						 				
				 						 				JScrollPane scrollPane_1 = new JScrollPane();
				 						 				scrollPane_1.setBounds(10, 315, 730, 290);
				 						 				scrollPane_1.getViewport().setBackground(new Color(36,46,50));
				 						 				pnlViewInfo.add(scrollPane_1);
				 						 				
				 						 				tblVaccineList = new JTable();
				 						 				tblVaccineList.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
				 						 				tblVaccineList.setForeground(new Color(255, 255, 255));
				 						 				tblVaccineList.setBackground(new Color(36,46,50));
				 						 				scrollPane_1.setViewportView(tblVaccineList);
				 						 				
				 						 				txtChildsName = new JTextField();
				 						 				txtChildsName.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtChildsName.setForeground(new Color(255, 255, 255));
				 						 				txtChildsName.setEnabled(false);
				 						 				txtChildsName.setOpaque(false);
				 						 				txtChildsName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtChildsName.setBounds(111, 120, 168, 17);
				 						 				pnlViewInfo.add(txtChildsName);
				 						 				txtChildsName.setColumns(10);
				 						 				
				 						 				txtDob = new JTextField();
				 						 				txtDob.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtDob.setForeground(new Color(255, 255, 255));
				 						 				txtDob.setEnabled(false);
				 						 				txtDob.setOpaque(false);
				 						 				txtDob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtDob.setColumns(10);
				 						 				txtDob.setBounds(111, 145, 168, 17);
				 						 				pnlViewInfo.add(txtDob);
				 						 				
				 						 				txtGender = new JTextField();
				 						 				txtGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtGender.setForeground(new Color(255, 255, 255));
				 						 				txtGender.setEnabled(false);
				 						 				txtGender.setOpaque(false);
				 						 				txtGender.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtGender.setColumns(10);
				 						 				txtGender.setBounds(111, 170, 168, 17);
				 						 				pnlViewInfo.add(txtGender);
				 						 				
				 						 				txtBirthplace = new JTextField();
				 						 				txtBirthplace.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtBirthplace.setForeground(new Color(255, 255, 255));
				 						 				txtBirthplace.setEnabled(false);
				 						 				txtBirthplace.setOpaque(false);
				 						 				txtBirthplace.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtBirthplace.setColumns(10);
				 						 				txtBirthplace.setBounds(111, 195, 168, 17);
				 						 				pnlViewInfo.add(txtBirthplace);
				 						 				
				 						 				txtAddress = new JTextField();
				 						 				txtAddress.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtAddress.setForeground(new Color(255, 255, 255));
				 						 				txtAddress.setEnabled(false);
				 						 				txtAddress.setOpaque(false);
				 						 				txtAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtAddress.setColumns(10);
				 						 				txtAddress.setBounds(111, 221, 366, 17);
				 						 				pnlViewInfo.add(txtAddress);
				 						 				
				 						 				txtMothersname = new JTextField();
				 						 				txtMothersname.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtMothersname.setForeground(new Color(255, 255, 255));
				 						 				txtMothersname.setEnabled(false);
				 						 				txtMothersname.setOpaque(false);
				 						 				txtMothersname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtMothersname.setColumns(10);
				 						 				txtMothersname.setBounds(401, 117, 189, 17);
				 						 				pnlViewInfo.add(txtMothersname);
				 						 				
				 						 				txtFathersname = new JTextField();
				 						 				txtFathersname.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtFathersname.setForeground(new Color(255, 255, 255));
				 						 				txtFathersname.setEnabled(false);
				 						 				txtFathersname.setOpaque(false);
				 						 				txtFathersname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtFathersname.setColumns(10);
				 						 				txtFathersname.setBounds(401, 142, 189, 17);
				 						 				pnlViewInfo.add(txtFathersname);
				 						 				
				 						 				txtHeight = new JTextField();
				 						 				txtHeight.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtHeight.setForeground(new Color(255, 255, 255));
				 						 				txtHeight.setEnabled(false);
				 						 				txtHeight.setOpaque(false);
				 						 				txtHeight.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtHeight.setColumns(10);
				 						 				txtHeight.setBounds(401, 167, 135, 17);
				 						 				pnlViewInfo.add(txtHeight);
				 						 				
				 						 				txtWeight = new JTextField();
				 						 				txtWeight.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
				 						 				txtWeight.setForeground(new Color(255, 255, 255));
				 						 				txtWeight.setEnabled(false);
				 						 				txtWeight.setOpaque(false);
				 						 				txtWeight.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				 						 				txtWeight.setColumns(10);
				 						 				txtWeight.setBounds(401, 192, 135, 17);
				 						 				pnlViewInfo.add(txtWeight);
				 						 				
				 						 				btnEditAdd = new JButton("EDIT INFO/ADD VACCINE");
				 						 				btnEditAdd.setForeground(new Color(255, 255, 255));
				 						 				btnEditAdd.setBackground(new Color(36,46,50));
				 						 				btnEditAdd.setBorder(null);
				 						 				btnEditAdd.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 				
				 						 				btnEditAdd.setBounds(10, 268, 215, 36);
				 						 				pnlViewInfo.add(btnEditAdd);
				 						 				
				 						 				btnEditInfo = new JButton("EDIT INFO");
				 						 				btnEditInfo.setForeground(new Color(255, 255, 255));
				 						 				btnEditInfo.setBackground(new Color(36,46,50));
				 						 				btnEditInfo.setBorder(null);
				 						 				btnEditInfo.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 				
				 						 						btnEditInfo.setVisible(false);
				 						 						btnEditInfo.setBounds(10, 268, 121, 36);
				 						 						pnlViewInfo.add(btnEditInfo);
				 						 						
				 						 						 btnAddVaccine = new JButton("ADD VACCINE");
				 						 						 btnAddVaccine.setForeground(new Color(255, 255, 255));
				 						 						 btnAddVaccine.setBackground(new Color(36,46,50));
				 						 						 btnAddVaccine.setBorder(null);
				 						 						 btnAddVaccine.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 						 
				 						 						 
				 						 						 btnAddVaccine.setVisible(false);
				 						 						 btnAddVaccine.setBounds(141, 268, 121, 36);
				 						 						 pnlViewInfo.add(btnAddVaccine);
				 						 						 
				 						 						 btnSaveInfo = new JButton("SAVE");
				 						 						 btnSaveInfo.setForeground(new Color(255, 255, 255));
				 						 						 btnSaveInfo.setBackground(new Color(36,46,50));
				 						 						 btnSaveInfo.setBorder(null);
				 						 						 btnSaveInfo.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 						 
				 						 						 btnSaveInfo.setVisible(false);
				 						 						 btnSaveInfo.setBounds(10, 268, 121, 36);
				 						 						 pnlViewInfo.add(btnSaveInfo);
				 						 						 
				 						 						 btnCancel = new JButton("CANCEL");
				 						 						 btnCancel.setForeground(new Color(255, 255, 255));
				 						 						 btnCancel.setBackground(new Color(36,46,50));
				 						 						 btnCancel.setBorder(null);
				 						 						 btnCancel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 						 
				 						 						 btnCancel.setVisible(false);
				 						 						 btnCancel.setBounds(141, 268, 121, 36);
				 						 						 pnlViewInfo.add(btnCancel);
				 						 						 
				 						 						 btnCancelEdiInfo = new JButton("CANCEL");
				 						 						 btnCancelEdiInfo.setForeground(new Color(255, 255, 255));
				 						 						 btnCancelEdiInfo.setBackground(new Color(36,46,50));
				 						 						 btnCancelEdiInfo.setBorder(null);
				 						 						 btnCancelEdiInfo.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 						 
				 						 						 				btnCancelEdiInfo.setVisible(false);
				 						 						 				btnCancelEdiInfo.setBounds(271, 268, 121, 36);
				 						 						 				pnlViewInfo.add(btnCancelEdiInfo);
				 						 						 				
				 						 						 				lblNewLabel_1 = new JLabel("INFANT INFORMATION");
				 						 						 				lblNewLabel_1.setBackground(new Color(36,46,50));
				 						 						 				lblNewLabel_1.setOpaque(true);
				 						 						 				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				 						 						 				lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
				 						 						 				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				 						 						 				lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
				 						 						 				lblNewLabel_1.setBounds(187, 46, 349, 49);
				 						 						 				pnlViewInfo.add(lblNewLabel_1);
				 						 						 				
				 						 						 				pnlVaccineList = new JPanel();
				 						 						 				pnlVaccineList.setBackground(new Color(74,94,104));
				 						 						 				pnlVaccineList.setVisible(false);
				 						 						 				pnlVaccineList.setBounds(0, 0, 633, 461);
				 						 						 				contentPane.add(pnlVaccineList);
				 						 						 				pnlVaccineList.setLayout(null);
				 						 						 				
				 						 						 				JScrollPane scrollPane_2 = new JScrollPane();
				 						 						 				scrollPane_2.getViewport().setBackground(new Color(36,46,50));
				 						 						 				scrollPane_2.setBorder(null);
				 						 						 				scrollPane_2.setBounds(0, 137, 633, 263);
				 						 						 				pnlVaccineList.add(scrollPane_2);
				 						 						 				
				 						 						 				tblAvailVaccineList = new JTable();
				 						 						 				tblAvailVaccineList.setBackground(new Color(36,46,50));
				 						 						 				tblAvailVaccineList.setForeground(new Color(255,255,255));
				 						 						 				tblAvailVaccineList.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
				 						 						 				scrollPane_2.setViewportView(tblAvailVaccineList);
				 						 						 				
				 						 						 				JButton btnNewButton = new JButton("DONE");
				 						 						 				
				 						 						 				btnNewButton.setBounds(539, 411, 94, 39);
				 						 						 				pnlVaccineList.add(btnNewButton);
				 						 						 				
				 						 						 				lblNewLabel_3 = new JLabel("VACCINE LIST");
				 						 						 				lblNewLabel_3.setBackground(new Color(36,46,50));
				 						 						 				lblNewLabel_3.setOpaque(true);
				 						 						 				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				 						 						 				lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
				 						 						 				lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
				 						 						 				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				 						 						 				lblNewLabel_3.setBounds(146, 47, 326, 43);
				 						 						 				pnlVaccineList.add(lblNewLabel_3);
				 						 						 				
				 						 						 				lblNewLabel_4 = new JLabel("SEARCH:");
				 						 						 				lblNewLabel_4.setForeground(new Color(255, 255, 255));
				 						 						 				lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
				 						 						 				lblNewLabel_4.setBounds(10, 101, 66, 25);
				 						 						 				pnlVaccineList.add(lblNewLabel_4);
				 						 						 				
				 						 						 				txtSearch = new JTextField();
				 						 						 				txtSearch.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						if (txtSearch.getText().equals(null) || txtSearch.getText().equals("")) {
				 						 						 								Data.populatetblVac();
				 						 						 								generateAvailVaccine(Data);
				 						 						 							}else {
				 						 						 								Data.searchVaccineList(txtSearch.getText());
				 						 						 								generateAvailVaccine(Data);
				 						 						 						}
				 						 						 					}
				 						 						 				});
				 						 						 				txtSearch.setBounds(86, 101, 174, 25);
				 						 						 				pnlVaccineList.add(txtSearch);
				 						 						 				txtSearch.setColumns(10);
				 						 						 				btnNewButton.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						btnBackImmun.setVisible(true);
				 						 						 						pnlViewInfo.setVisible(true);
				 						 						 						pnlVaccineList.setVisible(false);
				 						 						 						setBounds(100, 100, 750, 616);
				 						 						 						Data.populateVacList(resid);
				 						 						 						btnClose.setBounds(698, 0, 36, 36);
				 						 						 						panel.setBounds(0, 0, 734, 36);
				 						 						 						btnEditInfo.setVisible(false);
				 						 						 						btnAddVaccine.setVisible(false);
				 						 						 						btnSaveInfo.setVisible(false);
				 						 						 						btnEditAdd.setVisible(true);
				 						 						 						btnCancel.setVisible(false);
				 						 						 						btnCancelEdiInfo.setVisible(false);
				 						 						 					}
				 						 						 				});
				 						 						 				btnEditAdd.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						btnEditInfo.setVisible(true);
				 						 						 						btnAddVaccine.setVisible(true);
				 						 						 						btnSaveInfo.setVisible(false);
				 						 						 						btnEditAdd.setVisible(false);
				 						 						 						btnCancel.setVisible(false);
				 						 						 						btnCancelEdiInfo.setVisible(true);

				 						 						 					
				 						 						 					}
				 						 						 				});
				 						 						 				btnEditInfo.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						btnEditInfo.setVisible(false);
				 						 						 						btnAddVaccine.setVisible(false);
				 						 						 						btnSaveInfo.setVisible(true);
				 						 						 						btnEditAdd.setVisible(false);
				 						 						 						btnCancel.setVisible(true);
				 						 						 						btnCancelEdiInfo.setVisible(false);
				 						 						 						txtMothersname.setEnabled(true);
				 						 						 						txtFathersname.setEnabled(true);
				 						 						 						txtBirthplace.setEnabled(true);
				 						 						 						txtHeight.setEnabled(true);
				 						 						 						txtWeight.setEnabled(true);
				 						 						 					}
				 						 						 				});
				 						 						 				btnCancel.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						int sel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Edit information", JOptionPane.YES_NO_OPTION);
				 						 						 						if(sel==0) {
				 						 						 							btnCancelEdiInfo.setVisible(true);
				 						 						 							btnEditInfo.setVisible(true);
				 						 						 							btnAddVaccine.setVisible(true);
				 						 						 							btnSaveInfo.setVisible(false);
				 						 						 							btnEditAdd.setVisible(false);
				 						 						 							btnCancel.setVisible(false);
				 						 						 							txtMothersname.setEnabled(false);
				 						 						 							txtFathersname.setEnabled(false);
				 						 						 							txtBirthplace.setEnabled(false);
				 						 						 							txtHeight.setEnabled(false);
				 						 						 							txtWeight.setEnabled(false);		
				 						 						 							txtBirthplace.setText(birthplace);
				 						 						 							txtMothersname.setText(moname);
				 						 						 							txtFathersname.setText(faname);
				 						 						 							txtHeight.setText(height);
				 						 						 							txtWeight.setText(weight);
				 						 						 							

				 						 						 						}
				 						 						 					}
				 						 						 				});
				 						 						 				
				 						 						 				btnSaveInfo.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						int sel = JOptionPane.showConfirmDialog(null, "Are you sure you want to update information?", "Edit information", JOptionPane.YES_NO_OPTION);
				 						 						 						if(sel==0) {
				 						 						 							String mname = txtMothersname.getText();
				 						 						 							String fname= txtFathersname.getText();
				 						 						 							String bplace= txtBirthplace.getText();
				 						 						 							String height =txtHeight.getText();
				 						 						 							String weight= txtWeight.getText();
				 						 						 							txtMothersname.setEnabled(false);
				 						 						 							txtFathersname.setEnabled(false);
				 						 						 							txtBirthplace.setEnabled(false);
				 						 						 							txtHeight.setEnabled(false);
				 						 						 							txtWeight.setEnabled(false);

				 						 						 							btnEditInfo.setVisible(false);
				 						 						 							btnAddVaccine.setVisible(false);
				 						 						 							btnSaveInfo.setVisible(false);
				 						 						 							btnEditAdd.setVisible(true);
				 						 						 							btnCancel.setVisible(false);
				 						 						 							btnCancelEdiInfo.setVisible(false);
				 						 						 							Data.updateInfantInfo2(resid, mname,fname,bplace,height,weight);
				 						 						 							JOptionPane.showMessageDialog(null, "Information Updated Successfully", "Infant Information",JOptionPane.INFORMATION_MESSAGE);
				 						 						 							
				 						 						 						}
				 						 						 						
				 						 						 					}
				 						 						 				});
				 						 						 				btnAddVaccine.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 							generateAvailVaccine(Data);
				 						 						 							pnlRegInfants.setVisible(false);
				 						 						 							pnlViewInfo.setVisible(false);
				 						 						 							pnlVaccineList.setVisible(true);
				 						 						 							
				 						 						 							generateAvailVaccine(Data);
				 						 						 							setBounds(100, 100, 633 , 461);
				 						 						 							panel.setBounds(0, 0, 633, 36);
				 						 						 							btnClose.setBounds(597, 0, 36, 36);
				 						 						 							btnBack.setVisible(false);
				 						 						 							btnBackImmun.setVisible(false);
				 						 						 					}
				 						 						 				});
				 						 						 				btnCancelEdiInfo.addActionListener(new ActionListener() {
				 						 						 					public void actionPerformed(ActionEvent e) {
				 						 						 						btnCancelEdiInfo.setVisible(false);
				 						 						 						btnEditInfo.setVisible(false);
				 						 						 						btnAddVaccine.setVisible(false);
				 						 						 						btnSaveInfo.setVisible(false);
				 						 						 						btnEditAdd.setVisible(true);
				 						 						 						btnCancel.setVisible(false);
				 						 						 					}
				 						 						 				});
		generateTableInfant(Data);
		Data.populatetblVac();
		Data.populateTblInfantRegisteredBabies();
		generateTableInfant(Data);
	}
	
	public void generateTableInfant(data Data) {

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
					panel.setBounds(0, 0, 750, 36);
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
		centerScreen();
		Data.populateVacList(resid);
		String[] colsMenu = {"Vaccine Name", "Dozes","Remaining Dozes", "Remarks"," ", "id"};
		tblVaccineListModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		List<vaccineList> vacList = Data.getVaccineList();
		for(vaccineList o: vacList) {
		
			if(Data.checkIfRemainingDozesIsZero(o.getStock())) {
				Data.updateRemarks(o.getId(),resid);
			}else {
				Data.removeRemark(o.getId(),resid);
			}
			Object[] newRow = {o.getVacname(), o.getQty(), o.getStock(),o.getStatus(),"VACCINE",o.getId()};
			tblVaccineListModel.addRow(newRow);
		}
		tblVaccineList.setModel(tblVaccineListModel);
		
		
		 Action update = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int rowIndex = Integer.valueOf(e.getActionCommand());
					int sel=JOptionPane.showConfirmDialog(null, "Confirm Dialog Message Here.", "Message Dialog", JOptionPane.YES_NO_OPTION);
					if(sel==0) {
						int vacid = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(rowIndex, 5)));
						String pattern = "yyyy-MM-dd";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						String today = simpleDateFormat.format(new Date());
						int remainingdozes = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(rowIndex, 2)));
						String vaccineName = String.valueOf(tblVaccineList.getModel().getValueAt(rowIndex, 0));
						String residentFullName = txtChildsName.getText();
						if(String.valueOf(tblVaccineList.getModel().getValueAt(rowIndex, 3)).equalsIgnoreCase("complete")) {
							JOptionPane.showMessageDialog(null, "VACCINATION IS COMPLETE","Vaccine",JOptionPane.WARNING_MESSAGE);
						}else {
							int newDozes = remainingdozes-1;
							Data.updateRemainingDozes(vacid, newDozes);
							Data.addrecordInInfantVaccinated(resid,residentFullName, vacid,vaccineName, 1, today);
							
							Data.populateVacList(resid);
							generateVacList(Data);
							centerScreen();
						}
					}
				}
				
		 };
		ButtonColumn buttonColumn = new ButtonColumn(tblVaccineList, update, 4);
		tblVaccineList.setRowHeight(50);
		tblVaccineList.getColumnModel().getColumn(4).setMaxWidth(100);
		tblVaccineList.getColumnModel().getColumn(4).setMinWidth(100);
		tblVaccineList.removeColumn(tblVaccineList.getColumnModel().getColumn(5));
	}
	
	public void generateAvailVaccine(data Data) {
		centerScreen();
		String[] colsMenu = {"Fullname", "Remaining Dozes","","id"};
		tblAvailVaccineModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<vaccInfo> vacList = Data.getvaccList();
		for(vaccInfo o: vacList) {
			if(o.getQty() !=0 && o.getQty()>0) {
				Object[] newRow = {o.getVaccName(),o.getQty(),"ADD", o.getId()};
				tblAvailVaccineModel.addRow(newRow);
			}
		}
		tblAvailVaccineList.setModel(tblAvailVaccineModel);
		tblAvailVaccineList.setRowHeight(40);
		tblAvailVaccineList.getColumnModel().getColumn(2).setMaxWidth(100);
		tblAvailVaccineList.getColumnModel().getColumn(2).setMinWidth(100);
		tblAvailVaccineList.removeColumn(tblAvailVaccineList.getColumnModel().getColumn(3));
		 Action addVaccine = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int quantity=0;
				// TODO Auto-generated method stub
				int sel = JOptionPane.showConfirmDialog(null, "Do you want to add this vaccine?", "Add vaccine", JOptionPane.YES_NO_OPTION);
				if(sel==0) {
					System.out.print(resid);
					String input = JOptionPane.showInputDialog(null, "Enter quantity",0);
					int rowIndex = Integer.valueOf(e.getActionCommand());
					
					quantity = Integer.parseInt(input);
					
					int qty = Integer.parseInt(String.valueOf(tblAvailVaccineList.getModel().getValueAt(rowIndex, 1)));
					if(quantity>qty|| quantity<0) {
						JOptionPane.showMessageDialog(null, "Invalid quantity value");
					}else if(input.isEmpty()|| quantity==0 || input ==null ) {
						JOptionPane.showMessageDialog(null, "Please input value");
					}else if(input.equals("")){
						return;
					}else{
						int idmed = Integer.parseInt(String.valueOf(tblAvailVaccineList.getModel().getValueAt(rowIndex, 3)));
						String vacName = String.valueOf(tblAvailVaccineList.getModel().getValueAt(rowIndex, 0));
						int oStock = qty;
						
						int newQty = oStock - quantity;
					
						if(Data.checkDupVacineInTable(idmed)) {
							Data.addDupInTable(idmed,quantity, resid);
							
							Data.updateVaccineQty(idmed, newQty);
						
							Data.populateVacList(resid);
							generateVacList(Data);
							generateAvailVaccine(Data);
							
						}else {
							
							System.out.print(resid);
							Data.updateVaccineQty(idmed, newQty);
							Data.addVaccineInTable(Data.getmaxId(), idmed, vacName, quantity, quantity,resid, "");
						
							Data.populateVacList(resid);
							generateVacList(Data);
							generateAvailVaccine(Data);
						}
						generateAvailVaccine(Data);
					}
				}
			}
			 
		 };
		ButtonColumn buttonColumn = new ButtonColumn(tblAvailVaccineList, addVaccine, 2);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
