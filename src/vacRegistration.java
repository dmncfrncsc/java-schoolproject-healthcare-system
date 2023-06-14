import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class vacRegistration extends JFrame {
	private DefaultTableModel tblInfantModel;
	private JPanel contentPane;
	private JTable tblInfants;
	private String fullname;
	private int resid;
	private JButton btnClose;
	private JTextField txtChildsName;
	private JTextField txtDob;
	private JTextField txtGender;
	private JTextField txtBirthPlace;
	private JTextField txtAddress;
	private JTextField txtMothersname;
	private JTextField txtFathersname;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JPanel panel;
	private JTable tblVaccineList;
	private JTable tblVaccines;
	private DefaultTableModel tblVaccinesModel;
	private DefaultTableModel tblVaccineListModel;
	private JPanel pnlRegVac;
	private JPanel pnlVaccines;
	private JPanel panel_1;
	private JButton btnEmpFrameBack;
	private JButton btnBackView;
	private JButton btnBackViewInfo;
	private JLabel imgHolder;
	private JTextField txtSearchRegister;
	private JTextField textField;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vacRegistration frame = new vacRegistration();
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
	public vacRegistration() {
		data Data = data.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//setBounds(100, 100, 633, 424);
		setBounds(100, 100, 701, 534);
		//setBounds(100, 100, 761, 624);
	//	setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(36,46,50));
		
		panel_1.setBounds(0, 0, 685, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnClose = new JButton("");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Close program", JOptionPane.YES_NO_OPTION);
				if(sel==0){
					System.exit(0);
				}
			}
		});
		btnClose.setFocusable(false);
		btnClose.setFocusTraversalKeysEnabled(false);
		btnClose.setFocusPainted(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorder(null);
		btnClose.setBorderPainted(false);
		btnClose.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\close-window-48.png"));
	
		btnClose.setBounds(649, 0, 36, 36);
		panel_1.add(btnClose);
		
		btnEmpFrameBack = new JButton("");
		btnEmpFrameBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeeFrame emp = new employeeFrame();
				emp.setVisible(true);
			}
		});
		btnEmpFrameBack.setFocusable(false);
		btnEmpFrameBack.setFocusTraversalKeysEnabled(false);
		btnEmpFrameBack.setFocusPainted(false);
		btnEmpFrameBack.setBorder(null);
		btnEmpFrameBack.setBorderPainted(false);
		btnEmpFrameBack.setContentAreaFilled(false);
		btnEmpFrameBack.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnEmpFrameBack.setBounds(0, 0, 49, 36);
		panel_1.add(btnEmpFrameBack);
		
		 btnBackView = new JButton("");
		 btnBackView.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		 btnBackView.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setBounds(100, 100, 701, 534);
		 		panel_1.setBounds(0, 0, 685, 36);
		 		btnClose.setBounds(649, 0, 36, 36);
		 		btnBackView.setVisible(false);
		 		btnEmpFrameBack.setVisible(true);
		 		btnBackViewInfo.setVisible(false);
				panel.setVisible(true);
				pnlRegVac.setVisible(false);
				pnlVaccines.setVisible(false);
		 	}
		 });
		btnBackView.setVisible(false);
		btnBackView.setFocusable(false);
		btnBackView.setFocusTraversalKeysEnabled(false);
		btnBackView.setFocusPainted(false);
		btnBackView.setContentAreaFilled(false);
		btnBackView.setBorderPainted(false);
		btnBackView.setBorder(null);
		btnBackView.setBounds(0, 0, 49, 36);
		panel_1.add(btnBackView);
		
		 btnBackViewInfo = new JButton("");
		 btnBackViewInfo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				pnlRegVac.setVisible(true);
				pnlVaccines.setVisible(false);
				
				btnEmpFrameBack.setVisible(false);
				btnBackView.setVisible(true);
				btnBackViewInfo.setVisible(false);

				setBounds(100, 100, 761, 624);
				btnClose.setBounds(709, 0, 36, 36);
				panel_1.setBounds(0, 0, 745, 36);
		 		
		 	}
		 });
		 btnBackViewInfo.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnBackViewInfo.setVisible(false);
		btnBackViewInfo.setFocusable(false);
		btnBackViewInfo.setFocusTraversalKeysEnabled(false);
		btnBackViewInfo.setFocusPainted(false);
		btnBackViewInfo.setContentAreaFilled(false);
		btnBackViewInfo.setBorderPainted(false);
		btnBackViewInfo.setBorder(null);
		btnBackViewInfo.setBounds(0, 0, 49, 36);
		panel_1.add(btnBackViewInfo);
																						
																							
																							pnlRegVac = new JPanel();
																							pnlRegVac.setBackground(new Color(74,94,104));
																							pnlRegVac.setVisible(false);
																							pnlRegVac.setBounds(0, 0, 751, 613);
																							contentPane.add(pnlRegVac);
																							pnlRegVac.setLayout(null);
																							
																							JLabel lblNewLabel = new JLabel("CHILD'S NAME:");
																							lblNewLabel.setForeground(new Color(255, 255, 255));
																							lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel.setBounds(10, 82, 97, 21);
																							pnlRegVac.add(lblNewLabel);
																							
																							JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH:");
																							lblDateOfBirth.setForeground(new Color(255, 255, 255));
																							lblDateOfBirth.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblDateOfBirth.setBounds(10, 114, 101, 21);
																							pnlRegVac.add(lblDateOfBirth);
																							
																							JLabel lblNewLabel_1_1 = new JLabel("FATHER'S NAME:");
																							lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1.setBounds(298, 114, 108, 21);
																							pnlRegVac.add(lblNewLabel_1_1);
																							
																							JLabel lblNewLabel_1_1_1 = new JLabel("ADDRESS:");
																							lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1_1.setBounds(10, 210, 62, 21);
																							pnlRegVac.add(lblNewLabel_1_1_1);
																							
																							imgHolder = new JLabel("");
																							imgHolder.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\pngfind.png"));
																							imgHolder.setBounds(595, 59, 140, 140);
																							pnlRegVac.add(imgHolder);
																							
																							JLabel lblNewLabel_1_1_1_1 = new JLabel("MOTHER'S NAME:");
																							lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1_1_1.setBounds(298, 83, 116, 21);
																							pnlRegVac.add(lblNewLabel_1_1_1_1);
																							
																							JLabel lblNewLabel_1_1_1_1_1 =  new JLabel("BIRTH PLACE:");
																							lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1_1_1_1.setBounds(10, 178, 85, 21);
																							pnlRegVac.add(lblNewLabel_1_1_1_1_1);
																							
																							JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("BIRTH HEIGHT:");
																							lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1_1_1_1_1.setBounds(298, 146, 93, 21);
																							pnlRegVac.add(lblNewLabel_1_1_1_1_1_1);
																							
																							JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("BIRTH WEIGHT:");
																							lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1_1_1_1_1_1.setBounds(298, 178, 96, 21);
																							pnlRegVac.add(lblNewLabel_1_1_1_1_1_1_1);
																							
																							JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("SEX:");
																							lblNewLabel_1_1_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
																							lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																							lblNewLabel_1_1_1_1_1_1_1_1.setBounds(10, 146, 26, 21);
																							pnlRegVac.add(lblNewLabel_1_1_1_1_1_1_1_1);
																							
																							JScrollPane scrollPane_1 = new JScrollPane();
																							scrollPane_1.setBorder(null);
																							scrollPane_1.setBounds(10, 324, 559, 278);
																							pnlRegVac.add(scrollPane_1);
																							
																							tblVaccineList = new JTable();
																							scrollPane_1.setViewportView(tblVaccineList);
																							
																							
																							
																							JButton btnAdd = new JButton("ADD VACCINE");
																							btnAdd.setForeground(new Color(255, 255, 255));
																							btnAdd.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
																							btnAdd.setBackground(new Color(36,46,50));
																							btnAdd.setBorder(null);
																							
																									btnAdd.setBounds(10, 251, 118, 37);
																									pnlRegVac.add(btnAdd);
																									
																									JButton btnRegister = new JButton("REGISTER");
																									btnRegister.setForeground(new Color(255, 255, 255));
																									btnRegister.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
																									btnRegister.setBackground(new Color(36,46,50));
																									btnRegister.setBorder(null);
																									
																										btnRegister.setBounds(595, 477, 140, 54);
																										pnlRegVac.add(btnRegister);
																										
																										JButton btnNewButton_2_1_1 = new JButton("CANCEL");
																										btnNewButton_2_1_1.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												Data.getVaccineList().clear();
																												tblVaccineListModel.setRowCount(0);
																												generateDataInfants(Data);
																												dispose();
																												employeeFrame empForm = new employeeFrame();
																												empForm.setVisible(true);
																											}
																										});
																										btnNewButton_2_1_1.setForeground(new Color(255, 255, 255));
																										btnNewButton_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
																										btnNewButton_2_1_1.setBackground(new Color(36,46,50));
																										btnNewButton_2_1_1.setBorder(null);
																										btnNewButton_2_1_1.setBounds(595, 412, 140, 54);
																										pnlRegVac.add(btnNewButton_2_1_1);
																										
																										JButton btnChangeDozes = new JButton("EDIT QUANTITY");
																										btnChangeDozes.setForeground(new Color(255, 255, 255));
																										btnChangeDozes.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
																										btnChangeDozes.setBackground(new Color(36,46,50));
																										btnChangeDozes.setBorder(null);
																										
																										btnChangeDozes.setBounds(138, 251, 118, 37);
																										pnlRegVac.add(btnChangeDozes);
																										
																										txtChildsName = new JTextField();
																										txtChildsName.setForeground(new Color(255, 255, 255));
																										txtChildsName.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																										txtChildsName.setEnabled(false);
																										txtChildsName.setRequestFocusEnabled(false);
																										txtChildsName.setOpaque(false);
																										txtChildsName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
																										txtChildsName.setBounds(117, 82, 171, 21);
																										pnlRegVac.add(txtChildsName);
																										txtChildsName.setColumns(10);
																										
																										txtDob = new JTextField();
																										txtDob.setForeground(new Color(255, 255, 255));
																										txtDob.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																										txtDob.setEnabled(false);
																										txtDob.setRequestFocusEnabled(false);
																										txtDob.setOpaque(false);
																										txtDob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
																										txtDob.setColumns(10);
																										txtDob.setBounds(117, 113, 139, 21);
																										pnlRegVac.add(txtDob);
																										
																										txtGender = new JTextField();
																										txtGender.setForeground(new Color(255, 255, 255));
																										txtGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																										txtGender.setEnabled(false);
																										txtGender.setRequestFocusEnabled(false);
																										txtGender.setOpaque(false);
																										txtGender.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
																										txtGender.setColumns(10);
																										txtGender.setBounds(117, 146, 133, 21);
																										pnlRegVac.add(txtGender);
																										
																										txtBirthPlace = new JTextField();
																										txtBirthPlace.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
																										txtBirthPlace.setColumns(10);
																										txtBirthPlace.setBounds(117, 178, 133, 21);
																										pnlRegVac.add(txtBirthPlace);
																										
																										txtAddress = new JTextField();
																										txtAddress.setForeground(new Color(255, 255, 255));
																										txtAddress.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																										txtAddress.setEnabled(false);
																										txtAddress.setRequestFocusEnabled(false);
																										txtAddress.setOpaque(false);
																										txtAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
																										txtAddress.setColumns(10);
																										txtAddress.setBounds(117, 209, 328, 21);
																										pnlRegVac.add(txtAddress);
																										
																										txtMothersname = new JTextField();
																										txtMothersname.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
																										txtMothersname.setColumns(10);
																										txtMothersname.setBounds(424, 82, 161, 21);
																										pnlRegVac.add(txtMothersname);
																										
																										txtFathersname = new JTextField();
																										txtFathersname.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
																										txtFathersname.setColumns(10);
																										txtFathersname.setBounds(424, 114, 161, 21);
																										pnlRegVac.add(txtFathersname);
																										
																										txtHeight = new JTextField();
																										txtHeight.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
																										txtHeight.setColumns(10);
																										txtHeight.setBounds(424, 144, 91, 21);
																										pnlRegVac.add(txtHeight);
																										
																										txtWeight = new JTextField();
																										txtWeight.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
																										txtWeight.setColumns(10);
																										txtWeight.setBounds(424, 178, 91, 21);
																										pnlRegVac.add(txtWeight);
																										
																										JLabel lblNewLabel_1 = new JLabel("VACCINE LIST:");
																										lblNewLabel_1.setBackground(new Color(36,46,50));
																										lblNewLabel_1.setForeground(new Color(255, 255, 255));
																										lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
																										lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
																										lblNewLabel_1.setOpaque(true);
																										lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
																										lblNewLabel_1.setBounds(10, 299, 140, 21);
																										pnlRegVac.add(lblNewLabel_1);
																										
																										panel = new JPanel();
																										panel.setBackground(new Color(74,94,104));
																										panel.setBounds(0, 0, 701, 534);
																										contentPane.add(panel);
																										panel.setLayout(null);
																										
																										JLabel lblNewLabel_3 = new JLabel("SEARCH:");
																										lblNewLabel_3.setForeground(new Color(255, 255, 255));
																										lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
																										lblNewLabel_3.setBounds(10, 161, 82, 27);
																										panel.add(lblNewLabel_3);
																										
																										JScrollPane scrollPane = new JScrollPane();
																										scrollPane.getViewport().setBackground(new Color(36,46,50));
																										scrollPane.setBounds(10, 199, 665, 324);
																										panel.add(scrollPane);
																										
																										tblInfants = new JTable();
																										tblInfants.setForeground(new Color(255, 255, 255));
																										tblInfants.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
																										tblInfants.setBackground(new Color(36,46,50));
																										scrollPane.setViewportView(tblInfants);
																										
																										JLabel lblNewLabel_2 = new JLabel("REGISTER INFANT FOR IMMUNIZATION");
																										lblNewLabel_2.setOpaque(true);
																										lblNewLabel_2.setForeground(Color.WHITE);
																										lblNewLabel_2.setBackground(new Color(36,46,50));
																										lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 24));
																										lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
																										lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
																										lblNewLabel_2.setBounds(98, 48, 488, 37);
																										panel.add(lblNewLabel_2);
																										
																										txtSearchRegister = new JTextField();
																										txtSearchRegister.addKeyListener(new KeyAdapter() {
																											@Override
																											public void keyReleased(KeyEvent e) {
																												if (txtSearchRegister.getText().equals(null) || txtSearchRegister.getText().equals("")) {
									 												Data.populateTblInfant();
									 												generateDataInfants(Data);
									 											}else {
									 												Data.searchTblInfant(txtSearchRegister.getText());
									 												generateDataInfants(Data);
									 										}
																											}
																										});
																										txtSearchRegister.setBounds(98, 161, 220, 27);
																										panel.add(txtSearchRegister);
																										txtSearchRegister.setColumns(10);
																										
																												pnlVaccines = new JPanel();
																												pnlVaccines.setBackground(new Color(74,94,104));
																												pnlVaccines.setVisible(false);
																												pnlVaccines.setBounds(0, 0, 633, 424);
																												contentPane.add(pnlVaccines);
																												pnlVaccines.setLayout(null);
																												
																												JScrollPane scrollPane_2 = new JScrollPane();
																												scrollPane_2.setBounds(10, 137, 613, 233);
																												pnlVaccines.add(scrollPane_2);
																												
																												tblVaccines = new JTable();
																												scrollPane_2.setViewportView(tblVaccines);
																												JButton btnNewButton_1_1 = new JButton("DONE");
																												btnNewButton_1_1.setForeground(new Color(255, 255, 255));
																												btnNewButton_1_1.setBackground(new Color(36,46,50));
																												btnNewButton_1_1.setBorder(null);
																												btnNewButton_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
																												
																														btnNewButton_1_1.setBounds(534, 381, 89, 32);
																														pnlVaccines.add(btnNewButton_1_1);
																														
																														JLabel lblNewLabel_4 = new JLabel("SEARCH:");
																														lblNewLabel_4.setForeground(new Color(255, 255, 255));
																														lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
																														lblNewLabel_4.setBounds(10, 102, 64, 24);
																														pnlVaccines.add(lblNewLabel_4);
																														
																														textField = new JTextField();
																														textField.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
																														textField.addKeyListener(new KeyAdapter() {
																															@Override
																															public void keyReleased(KeyEvent e) {
																																if (textField.getText().equals(null) || textField.getText().equals("")) {
																																	Data.populatetblVac();
																																	generateVaccineList(Data);
																																}else {
																																	Data.searchVaccineList(textField.getText());
																																	generateVaccineList(Data);
																															}
																															}
																														});
																														textField.setBounds(84, 102, 157, 24);
																														pnlVaccines.add(textField);
																														textField.setColumns(10);
																														
																														lblNewLabel_5 = new JLabel("VACCINE LIST");
																														lblNewLabel_5.setBackground(new Color(36,46,50));
																														lblNewLabel_5.setOpaque(true);
																														lblNewLabel_5.setForeground(new Color(255, 255, 255));
																														lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
																														lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
																														lblNewLabel_5.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
																														lblNewLabel_5.setBounds(180, 47, 277, 44);
																														pnlVaccines.add(lblNewLabel_5);
																														
																																btnNewButton_1_1.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																		panel.setVisible(false);
																																		pnlRegVac.setVisible(true);
																																		pnlVaccines.setVisible(false);
																																		setBounds(100, 100, 761, 624);
																																		btnClose.setBounds(709, 0, 36, 36);
																																		panel_1.setBounds(0, 0, 745, 36);
																																		generateVaccineList(Data);
																																		
																																		btnEmpFrameBack.setVisible(false);
																																		btnBackView.setVisible(true);
																																		btnBackViewInfo.setVisible(false);
																																		
																																	}
																																});
																										btnAdd.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												
																												panel.setVisible(false);
																												pnlRegVac.setVisible(false);
																												pnlVaccines.setVisible(true);

																												generateVaccine(Data);
																												btnClose.setBounds(582, 0, 36, 36);
																												panel_1.setBounds(0, 0, 618, 36);
																												setBounds(100, 100, 633, 424);
																												
																												btnEmpFrameBack.setVisible(false);
																												btnBackView.setVisible(false);
																												btnBackViewInfo.setVisible(true);
																												
																											}
																										});
																										
																										btnChangeDozes.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												int row=tblVaccineList.getSelectedRow();
																												if(row ==-1) {
																													JOptionPane.showMessageDialog(null, "Please select a vaccine.");
																												}else {
																													String input = JOptionPane.showInputDialog(null, "Enter quantity",0);
																													int vacId = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(row, 3)));
																													int orgStock = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(row, 4)));
																													int doze = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(row, 1)));
																													String vacName = String.valueOf(tblVaccineList.getModel().getValueAt(row, 0));
																													if("0".equals(input)) {
																														JOptionPane.showMessageDialog(null,"Please input a value", "Change Doze Number",JOptionPane.INFORMATION_MESSAGE);
																													}
																													if(input == null || (input != null && ("0".equals(input))))   
																													{
																													   int quant = orgStock - doze;
																													   Data.updateVaccineQty(vacId, quant);

																													}else if(orgStock < Integer.parseInt(input)){
																														JOptionPane.showMessageDialog(null,"Original quantity of "+vacName+" is "+orgStock+".\n"
																																+ "Cannot input more than original quantity.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
																													}else {
																														Data.updateVaccineQty(vacId, orgStock);
																														int in = Integer.parseInt(String.valueOf(input));
																														int newqty = orgStock - in;
																														Data.updateVaccineQty(vacId, newqty);
																														List<vaccineList> vaccineList = Data.getVaccineList();
																														for(vaccineList o: vaccineList) {
																															if(o.getId()==vacId) {
																																o.setQty(in);
																															}
																														}
																														generateVaccineList(Data);
																													}
																												}
																											}
																										});
																										btnRegister.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												int sel=JOptionPane.showConfirmDialog(null, "Do you want to register resident for Immunization?","Register Infant Immunization", JOptionPane.YES_NO_OPTION);
																												if(sel==0) {
																													List<vaccineList> vaccineList = Data.getVaccineList();
																													for(vaccineList o: vaccineList) {
																														Data.addVaccineRecord(Data.getmaxId(),o.getId(),o.getVacname(),o.getQty(),o.getQty(),resid, " ");
																													}
																													JOptionPane.showMessageDialog(null,"Registered Successfully","Immunization Registration", JOptionPane.INFORMATION_MESSAGE);
																													
																												
																													
																													
																													Data.addInfantInfo(resid, txtChildsName.getText(), txtDob.getText(), 
																															txtBirthPlace.getText(), txtGender.getText(), txtAddress.getText(), 
																															txtMothersname.getText(), txtFathersname.getText(), txtWeight.getText(), txtHeight.getText());
																													panel.setVisible(true);
																													
																													pnlRegVac.setVisible(false);
																													pnlVaccines.setVisible(false);
																													
																													
																												}
																												Data.getVaccineList().clear();
																												tblVaccineListModel.setRowCount(0);
																												generateDataInfants(Data);
																												dispose();
																												employeeFrame empForm = new employeeFrame();
																												empForm.setVisible(true);
																												
																											}
																										});
						generateVaccine(Data);
						Data.populateTblInfant();
						generateDataInfants(Data);
						 centerScreen();
	}
	
	public void generateDataInfants(data Data) {

		 centerScreen();
		String[] colsMenu = {"Image", "Fullname","","id"};
		tblInfantModel = new DefaultTableModel(colsMenu, 0) {
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
			Object[] newRow = {newImage, o.getFullname(),"APPLY",o.getId()};
			tblInfantModel.addRow(newRow);
		}
		tblInfants.setModel(tblInfantModel);
		tblInfants.setRowHeight(100);
		tblInfants.getColumnModel().getColumn(0).setMaxWidth(100);
		tblInfants.getColumnModel().getColumn(0).setMinWidth(100);
		
		tblInfants.getColumnModel().getColumn(1).setMaxWidth(300);
		tblInfants.getColumnModel().getColumn(1).setMinWidth(300);
		tblInfants.removeColumn(tblInfants.getColumnModel().getColumn(3));
		
		 Action view = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowIndex = Integer.valueOf(e.getActionCommand());
				resid = Integer.parseInt(String.valueOf(tblInfants.getModel().getValueAt(rowIndex, 3)));
				ImageIcon newImage = null;
				try {
					Data.query= "SELECT CONCAT(ResidentFirstname, ' ', ResidentMiddleName, ' ' , ResidentLastName) "
							+ "as Fullname, CONCAT(StreetAddress, ', ', BarangayAddress, ', ', CityAddress, ', ', ProvinceAddress) "
							+ "AS Address, Birthdate, Gender,ResidentId,imagepath  from residents Where ResidentId ="+resid;
					Data.st = Data.conn.createStatement();
					Data.rs= Data.st.executeQuery(Data.query);
					
					while(Data.rs.next()) {
						txtChildsName.setText(Data.rs.getString("Fullname"));
						txtAddress.setText(Data.rs.getString("Address"));
						txtDob.setText(Data.rs.getString("Birthdate"));
						txtGender.setText(Data.rs.getString("Gender"));
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
					}
					panel.setVisible(false);
					pnlRegVac.setVisible(true);
					pnlVaccines.setVisible(false);
					
					btnEmpFrameBack.setVisible(false);
					btnBackView.setVisible(true);
					btnBackViewInfo.setVisible(false);

					setBounds(100, 100, 761, 624);
					btnClose.setBounds(709, 0, 36, 36);
					panel_1.setBounds(0, 0, 745, 36);
				}catch(Exception es){
					System.out.println(es);
				}
				
			}
			 
		 };
		ButtonColumn buttonColumn = new ButtonColumn(tblInfants, view, 2);
	}
	public void generateVaccine(data Data) {
		 centerScreen();
		Data.populatetblVac();
		String[] colsMenu = {"Fullname", "Remaining Dozes","","id"};
		tblVaccinesModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<vaccInfo> vacList = Data.getvaccList();
		for(vaccInfo o: vacList) {
			if(o.getQty() !=0 && o.getQty()>0) {
				Object[] newRow = {o.getVaccName(),o.getQty(),"ADD", o.getId()};
				tblVaccinesModel.addRow(newRow);
			}
		}
		tblVaccines.setModel(tblVaccinesModel);
		tblVaccines.setRowHeight(40);
		tblVaccines.getColumnModel().getColumn(2).setMaxWidth(100);
		tblVaccines.getColumnModel().getColumn(2).setMinWidth(100);
		tblVaccines.removeColumn(tblVaccines.getColumnModel().getColumn(3));
		 Action addVaccine = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int quantity=0;
				// TODO Auto-generated method stub
				int sel = JOptionPane.showConfirmDialog(null, "Do you want to add this vaccine?", "Add vaccine", JOptionPane.YES_NO_OPTION);
				if(sel==0) {
					String input = JOptionPane.showInputDialog(null, "Enter quantity",0);
					int rowIndex = Integer.valueOf(e.getActionCommand());
					
					quantity = Integer.parseInt(input);
					
					int qty = Integer.parseInt(String.valueOf(tblVaccines.getModel().getValueAt(rowIndex, 1)));
					if(quantity>qty|| quantity<0) {
						JOptionPane.showMessageDialog(null, "Invalid quantity value");
					}else if(input.isEmpty()|| quantity==0 || input ==null ) {
						JOptionPane.showMessageDialog(null, "Please input value");
					}else if(input.equals("")){
						return;
					}else{
						int idmed = Integer.parseInt(String.valueOf(tblVaccines.getModel().getValueAt(rowIndex, 3)));
						String fullname = String.valueOf(tblVaccines.getModel().getValueAt(rowIndex, 0));
						int oStock = qty;
						
						int newQty = oStock - quantity;
					
						if(Data.checkDupVaccine(fullname)) {
							Data.addDupVaccine(idmed, quantity);
							generateVaccineList(Data);
							Data.updateVaccineQty(idmed, newQty);
							generateVaccine(Data);

						}else {
							Data.updateVaccineQty(idmed, newQty);
							Data.addVacList(idmed, fullname, quantity, oStock);
							generateVaccineList(Data);
							generateVaccine(Data);
						}
					
					}
				}
			}
			 
		 };
		ButtonColumn buttonColumn = new ButtonColumn(tblVaccines, addVaccine, 2);
	}
	public void generateVaccineList(data Data) {
		 centerScreen();
		String[] colsMenu = {"Vaccine Name", "Dozes","","id","stock"};
		tblVaccineListModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<vaccineList> vaccineList = Data.getVaccineList();
		for(vaccineList o: vaccineList) {

			Object[] newRow = {o.getVacname(),o.getQty(),"DELETE", o.getId(),o.getStock()};
			tblVaccineListModel.addRow(newRow);
		}
		tblVaccineList.setModel(tblVaccineListModel);
		tblVaccineList.setRowHeight(40);
		tblVaccineList.getColumnModel().getColumn(2).setMaxWidth(100);
		tblVaccineList.getColumnModel().getColumn(2).setMinWidth(100);
		tblVaccineList.removeColumn(tblVaccineList.getColumnModel().getColumn(3));
		tblVaccineList.removeColumn(tblVaccineList.getColumnModel().getColumn(3));
		
		 Action deleteVaccine = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sel = JOptionPane.showConfirmDialog(null, "Do you want to remove this vaccine?", "Remove vaccine", JOptionPane.YES_NO_OPTION);
				if(sel==0) {
					int rowIndex = Integer.valueOf(e.getActionCommand());
					int idmed = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(rowIndex, 3)));
					int originalstock = Integer.parseInt(String.valueOf(tblVaccineList.getModel().getValueAt(rowIndex, 4)));
					
					
		            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		            Data.updateVaccineQty(idmed, originalstock);
		            Data.dataRemoveFromVacList(idmed);
		            tblVaccineListModel.removeRow(tblVaccineList.getSelectedRow());
				}
			}
			 
		 };
		ButtonColumn buttonColumn = new ButtonColumn(tblVaccineList, deleteVaccine, 2);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
