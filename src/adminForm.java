import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class adminForm extends JFrame {
	private static DefaultTableModel tblMenuModel;
	private JPanel contentPane;
	private static data Data;
	private static JTable table;
	private static JTextField txtFname;
	private static JTextField txtMname;
	private static JTextField txtLname;
	private static JTextField txtUsername;
	private static JPasswordField txtPw;
	private static JPasswordField txtCPw;
	private static JTextField txtBrandName;
	private static JTextField txtGenericName;
	private static JTable tblMeds;
	private static DefaultTableModel tblMedsModel;
	private static DefaultTableModel tblVaccinesModel;
	private static DefaultTableModel tblMedicineModel;
	private JDateChooser dcVacManu;
	private static JTextField txtQty;
	private static int idholder;
	private static JComboBox cbPosition;
	private static JDateChooser jdcManuDate;
	private static JDateChooser jdcExpDate;
	private static JComboBox cbMedCategory;
	private static JComboBox cbStatus;
	private JTextField txtFn;
	private JTextField txtMn;
	private JTextField txtLn;
	private JTextField txtSt;
	private JTextField txtBgy;
	private JTextField txtCity;
	private JTextField txtPro;
	private JTextField txtOccu;
	private JTextField txtPwd;
	private JLabel lblTime;
	private JTable tblResident;
	private static JLabel imgHolder;
	private DefaultTableModel tblResidentModel;
	private JDateChooser dcBdateRes;
	private JComboBox cbPosRes;
	private JComboBox cbCivil;
	private JComboBox cbCategory;
	private JComboBox cbResGen;
	private JButton btnUpload;
	private JLabel lblNumExpMed;
	String filename = null;
	private File f;
	private JFileChooser chooser;
	private JTable tblVaccines;
	private JTextField txtVacName;
	private JTextField txtVacQty;
	private JDateChooser dcVacExpi;
	private JLabel lblDate;
	private JTable tblVaccine;
	private static DefaultTableModel tblVaccineModel;
	private JTable tblMedicine;
	private JTextField txtSearch;
	private JTextField txtSearchMeds;
	private JTextField txtSearchVac;
	private JTextField txtUserSearch;
	private JTextField txtSearchMedTable;
	private JTextField txtSearchResident;
	private static JTextField txtMeas;
	private  static JComboBox cbMeasurement;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Data = data.getInstance();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminForm frame = new adminForm();
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
	public adminForm() {

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		setResizable(false);
		Data = data.getInstance();

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1406, 544);
		setBounds(100, 100, 1102, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36,46,50));
		panel.setBounds(0, 0, 232, 544);
		contentPane.setLayout(null);
		
		int num = Data.getNumberOfUsers();
		String formattedNum = String.format("%02d", num);
		
		
		int numEmp = Data.getEmpCount();
		String formattedNum2 = String.format("%02d", numEmp);
		
		
		int numAdmin = Data.getAdminCount();
		String formattedNum3 = String.format("%02d", numAdmin);
		
		int numOfmed = Data.countMedicines();
		String numMedFormat = String.format("%02d", numOfmed);

		
		int stockZero = Data.countZeroQty();
		String stock = String.format("%02d", stockZero);
		
		
		int vaccineZero = Data.countZeroQtyVaccine();
		String stock1 = String.format("%02d", vaccineZero);
		
		JPanel pnlMedicines = new JPanel();
		pnlMedicines.setVisible(false);
		pnlMedicines.setBackground(new Color(74,94,104));
		pnlMedicines.setBounds(231, 0, 871, 544);
		contentPane.add(pnlMedicines);
		pnlMedicines.setLayout(null);
		
		JLabel lblBrandName = new JLabel("BRAND NAME:");
		lblBrandName.setForeground(Color.WHITE);
		lblBrandName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblBrandName.setBounds(445, 174, 113, 25);
		pnlMedicines.add(lblBrandName);
		
		txtBrandName = new JTextField();
		txtBrandName.setForeground(Color.BLACK);
		txtBrandName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		txtBrandName.setBounds(650, 168, 194, 27);
		pnlMedicines.add(txtBrandName);
		txtBrandName.setEnabled(false);
		txtBrandName.setColumns(10);
		
		JLabel lblGenericName = new JLabel("GENERIC NAME:");
		lblGenericName.setForeground(Color.WHITE);
		lblGenericName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGenericName.setBounds(445, 138, 125, 25);
		pnlMedicines.add(lblGenericName);
		
		txtGenericName = new JTextField();
		txtGenericName.setForeground(Color.BLACK);
		txtGenericName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		txtGenericName.setBounds(650, 130, 194, 27);
		pnlMedicines.add(txtGenericName);
		txtGenericName.setEnabled(false);
		txtGenericName.setColumns(10);
		
		JLabel lblMedCategory = new JLabel("CATEGORY:");
		lblMedCategory.setForeground(Color.WHITE);
		lblMedCategory.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblMedCategory.setBounds(445, 397, 90, 25);
		pnlMedicines.add(lblMedCategory);
		
		cbMedCategory = new JComboBox();
		cbMedCategory.setForeground(Color.BLACK);
		cbMedCategory.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		cbMedCategory.setBounds(650, 396, 174, 27);
		pnlMedicines.add(cbMedCategory);
		cbMedCategory.setEnabled(false);
		
		JLabel lblManuDate = new JLabel("MANUFACTURED DATE:");
		lblManuDate.setForeground(Color.WHITE);
		lblManuDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblManuDate.setBounds(445, 325, 183, 25);
		pnlMedicines.add(lblManuDate);
		lblManuDate.setHorizontalAlignment(SwingConstants.LEFT);
		
		jdcManuDate = new JDateChooser();
		jdcManuDate.setBounds(650, 323, 174, 27);
		pnlMedicines.add(jdcManuDate);
		jdcManuDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		jdcManuDate.setEnabled(false);
		jdcManuDate.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblExpirationDate = new JLabel("EXPIRATION DATE:");
		lblExpirationDate.setForeground(Color.WHITE);
		lblExpirationDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblExpirationDate.setBounds(445, 361, 144, 25);
		pnlMedicines.add(lblExpirationDate);
		lblExpirationDate.setHorizontalTextPosition(SwingConstants.LEFT);
		
		 jdcExpDate = new JDateChooser();
		 jdcExpDate.setBounds(650, 358, 174, 27);
		 jdcExpDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 pnlMedicines.add(jdcExpDate);
		 jdcExpDate.setDateFormatString("yyyy-MM-dd");
		 jdcExpDate.setEnabled(false);
		 
		 JButton btnAddMed = new JButton("ADD");
		 btnAddMed.setForeground(Color.BLACK);
		 btnAddMed.setBorderPainted(false);
		 btnAddMed.setBackground(Color.LIGHT_GRAY);
		 btnAddMed.setBorder(null);
		 btnAddMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 btnAddMed.setBounds(500, 480, 108, 36);
		 pnlMedicines.add(btnAddMed);
		 
		 JButton btnUpdateMed = new JButton("UPDATE");
		 btnUpdateMed.setForeground(Color.BLACK);
		 btnUpdateMed.setBorderPainted(false);
		 btnUpdateMed.setBackground(Color.LIGHT_GRAY);
		 btnUpdateMed.setBorder(null);
		 btnUpdateMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 btnUpdateMed.setBounds(618, 480, 108, 36);
		 pnlMedicines.add(btnUpdateMed);
		 
		 JButton btnDeleteMed = new JButton("DELETE");
		 btnDeleteMed.setForeground(Color.BLACK);
		 btnDeleteMed.setBorderPainted(false);
		 btnDeleteMed.setBackground(Color.LIGHT_GRAY);
		 btnDeleteMed.setBorder(null);
		 btnDeleteMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 btnDeleteMed.setBounds(736, 480, 108, 36);
		 pnlMedicines.add(btnDeleteMed);
		 
		 JButton btnConfirmAddMed = new JButton("CONFIRM");
		 btnConfirmAddMed.setForeground(Color.BLACK);
		 btnConfirmAddMed.setBorderPainted(false);
		 btnConfirmAddMed.setBackground(Color.LIGHT_GRAY);
		 btnConfirmAddMed.setBorder(null);
		 btnConfirmAddMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 btnConfirmAddMed.setBounds(500, 480, 108, 36);
		 pnlMedicines.add(btnConfirmAddMed);
		 
		 JButton btnCancelMed = new JButton("CANCEL");
		 btnCancelMed.setForeground(Color.BLACK);
		 btnCancelMed.setBorderPainted(false);
		 btnCancelMed.setBackground(Color.LIGHT_GRAY);
		 btnCancelMed.setBorder(null);
		 btnCancelMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 btnCancelMed.setBounds(618, 480, 108, 36);
		 pnlMedicines.add(btnCancelMed);
		 
		 JButton btnConfirmUpdateMed = new JButton("CONFIRM");
		 btnConfirmUpdateMed.setForeground(Color.BLACK);
		 btnConfirmUpdateMed.setBorderPainted(false);
		 btnConfirmUpdateMed.setBackground(Color.LIGHT_GRAY);
		 btnConfirmUpdateMed.setBorder(null);
		 btnConfirmUpdateMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 btnConfirmUpdateMed.setBounds(500, 480, 108, 36);
		 pnlMedicines.add(btnConfirmUpdateMed);
		 tblMeds = new JTable();
		 tblMeds.setRowSelectionAllowed(false);
		 tblMeds.setFocusable(false);
		 tblMeds.setFocusTraversalKeysEnabled(false);
		 tblMeds.setSelectionBackground(Color.DARK_GRAY);
		 tblMeds.setRequestFocusEnabled(false);
		 tblMeds.setGridColor(new Color(74,94,104));
		 tblMeds.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		 tblMeds.setBackground(new Color(36,46,50));
		 tblMeds.setForeground(new Color(255, 255, 255));
		 tblMeds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 tblMeds.setOpaque(false);
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(10, 130, 415, 386);
		 pnlMedicines.add(scrollPane_1);
		 scrollPane_1.getViewport().setBackground(new Color(36,46,50));
		 scrollPane_1.getViewport().setBorder(null);
		 scrollPane_1.getViewport().setRequestFocusEnabled(false);
		 
		 scrollPane_1.setBorder(null);
		 scrollPane_1.setOpaque(false);
		 
		 		 scrollPane_1.setViewportView(tblMeds);
		 		 
		 		 JLabel lblNewLabel = new JLabel("QUANTITY:");
		 		 lblNewLabel.setForeground(Color.WHITE);
		 		 lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 		 lblNewLabel.setBounds(445, 286, 86, 25);
		 		 pnlMedicines.add(lblNewLabel);
		 		 
		 		 txtQty = new JTextField();
		 		 txtQty.setForeground(Color.BLACK);
		 		 txtQty.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 		 txtQty.setEnabled(false);
		 		 txtQty.setBounds(650, 285, 90, 27);
		 		 pnlMedicines.add(txtQty);
		 		 txtQty.setColumns(10);
		 		 
		 		 JLabel lblNewLabel_1 = new JLabel("MEDICINES");
		 		 lblNewLabel_1.setBackground(new Color(36,46,50));
		 		 lblNewLabel_1.setForeground(Color.WHITE);
		 		 lblNewLabel_1.setOpaque(true);
		 		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 		 lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
		 		 lblNewLabel_1.setBounds(234, 24, 393, 42);
		 		 pnlMedicines.add(lblNewLabel_1);
		 		 
		 		 JLabel lblNewLabel_14 = new JLabel("SEARCH:");
		 		 lblNewLabel_14.setForeground(new Color(255, 255, 255));
		 		 lblNewLabel_14.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		 		 lblNewLabel_14.setBounds(10, 85, 94, 34);
		 		 pnlMedicines.add(lblNewLabel_14);
		 		 
		 		 txtSearchMedTable = new JTextField();
		 		 txtSearchMedTable.addKeyListener(new KeyAdapter() {
		 		 	@Override
		 		 	public void keyReleased(KeyEvent e) {
		 		 	if (txtSearchMedTable.getText().equals(null) || txtSearchMedTable.getText().equals("")) {
						 															 											Data.populateTblMeds();
						 															 											generateMeds(Data);
						 															 										}else {
						 															 											Data.searchMedicineTable(txtSearchMedTable.getText());
						 															 											generateMeds(Data);
						 															 											}
		 		 	}
		 		 });
		 		 txtSearchMedTable.setBounds(114, 85, 311, 34);
		 		 pnlMedicines.add(txtSearchMedTable);
		 		 txtSearchMedTable.setColumns(10);
		 		 
		 		 JLabel lblEnterMeasurements = new JLabel("METRIC MEASUREMENT:");
		 		 lblEnterMeasurements.setForeground(Color.WHITE);
		 		 lblEnterMeasurements.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 		 lblEnterMeasurements.setBounds(445, 211, 188, 25);
		 		 pnlMedicines.add(lblEnterMeasurements);
		 		 
		 		 cbMeasurement = new JComboBox();
		 		 cbMeasurement.setModel(new DefaultComboBoxModel(new String[] {"", "MG", "ML"}));
		 		 cbMeasurement.setForeground(Color.BLACK);
		 		 cbMeasurement.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 		 cbMeasurement.setEnabled(false);
		 		 cbMeasurement.setBounds(650, 210, 90, 27);
		 		 pnlMedicines.add(cbMeasurement);
		 		 
		 		 JLabel lblEnterMeasurement = new JLabel("ENTER MEASUREMENT:");
		 		 lblEnterMeasurement.setForeground(Color.WHITE);
		 		 lblEnterMeasurement.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 		 lblEnterMeasurement.setBounds(445, 248, 188, 25);
		 		 pnlMedicines.add(lblEnterMeasurement);
		 		 
		 		 txtMeas = new JTextField();
		 		 txtMeas.setForeground(Color.BLACK);
		 		 txtMeas.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		 		 txtMeas.setEnabled(false);
		 		 txtMeas.setColumns(10);
		 		 txtMeas.setBounds(650, 247, 90, 27);
		 		 pnlMedicines.add(txtMeas);
		 		 
		 		 btnConfirmUpdateMed.addMouseListener(new MouseAdapter() {
		 		 	public void mouseClicked(MouseEvent e) {
		 		 		int sel = JOptionPane.showConfirmDialog(null,"Confirm Update Medicine?","Update Medicine", JOptionPane.YES_NO_OPTION);
		 		 		
		 		 		 String gname= txtGenericName.getText();
		 		 		 String bname= txtBrandName.getText();;
		 		 		 String category=(String) cbMedCategory.getSelectedItem();
		 		 		 Date manuDate = jdcManuDate.getDate();
		 		 		 Date expiDate = jdcExpDate.getDate();
		 		 		 int qty = Integer.parseInt(txtQty.getText());
		 		 		 int measure = Integer.parseInt(txtMeas.getText());
		 		 		 String mMeasure = (String) cbMeasurement.getSelectedItem();
		 		 		 if(sel==0) {
		 		 			 if(txtGenericName.getText().isEmpty()
                  		 ||txtBrandName.getText().isEmpty()
                  		 //||cbMedCategory.getSelectedItem().equals("")
                  		 ||jdcManuDate.getDate()==null
                  		 ||jdcExpDate.getDate()==null
                  		 ||txtMeas.getText().isEmpty()
                  		 ||cbMeasurement.getSelectedItem().equals("")){
                       JOptionPane.showMessageDialog(null,"Empty field detected.\n Please fill up the form","Update Medicine",JOptionPane.WARNING_MESSAGE);

                    }else {
                    	if(manuDate.after(expiDate)) {
		 		 				 JOptionPane.showMessageDialog(null, "Date values are invalid", "Invalid Values",JOptionPane.WARNING_MESSAGE);
                    	}else{
                    		JOptionPane.showMessageDialog(null,"Medicine successfully Updated!","Success",JOptionPane.INFORMATION_MESSAGE);
                    	
                 			Data.updateMeds(idholder,qty, bname, gname, category, manuDate, expiDate,mMeasure, measure); 
                         	refreshMed();
                           	generateMeds(Data);
                  			txtQty.setText("");
         
              				txtBrandName.setText("");
              				txtGenericName.setText("");
              				cbMedCategory.setSelectedItem("");
              				txtMeas.setText("");
              				cbMeasurement.setSelectedItem("");
              				jdcManuDate.setDate(null);
              				jdcExpDate.setDate(null);
              				btnAddMed.setVisible(true);
            				btnUpdateMed.setVisible(true);
            				btnDeleteMed.setVisible(true);
            				btnConfirmAddMed.setVisible(false);
            				btnCancelMed.setVisible(false);
            				tblMeds.setEnabled(true);
            				txtMeas.setEnabled(false);
            				cbMeasurement.setEnabled(false);
            				txtBrandName.setEnabled(false);
            				txtGenericName.setEnabled(false);
            				cbMedCategory.setEnabled(false);
            				jdcManuDate.setEnabled(false);
            				jdcExpDate.setEnabled(false);
            				txtQty.setEnabled(false);
                    	}

                   	}
		 		 		 }
		 		 	}
		 		 });
		 		 btnCancelMed.addActionListener(new ActionListener() {
		 		 	@Override
		 		 	public void actionPerformed(ActionEvent e) {
		 		 		tblMeds.setEnabled(true);
		 		 		txtQty.setEnabled(false);
		 		 		txtBrandName.setEnabled(false);
		 		 		txtGenericName.setEnabled(false);
		 		 		cbMedCategory.setEnabled(false);
		 		 		jdcManuDate.setEnabled(false);
		 		 		jdcExpDate.setEnabled(false);
		 		 	
		 		 		btnAddMed.setVisible(true);
		 		 		btnUpdateMed.setVisible(true);
		 		 		btnDeleteMed.setVisible(true);
		 		 		btnConfirmUpdateMed.setVisible(false);
		 		 		btnConfirmAddMed.setVisible(false);
		 		 		btnCancelMed.setVisible(false);
		 		 		txtQty.setText("");
		 		 		txtBrandName.setText("");
		 		 		txtGenericName.setText("");
		 		 		cbMedCategory.setSelectedItem("");
		 		 		jdcManuDate.setDate(null);
		 		 		jdcExpDate.setDate(null);
		 		 		btnConfirmUpdateMed.setVisible(false);
		 		 		
		 		 	}
		 		 });
		 		 btnConfirmAddMed.addMouseListener(new MouseAdapter() {
		 		 	@Override
		 		 	public void mouseClicked(MouseEvent e) {
		 		 		 int sel = JOptionPane.showConfirmDialog(null,"Confirm Add Medicine?","Add Medicine", JOptionPane.YES_NO_OPTION);
		 		 		 int id = Data.getMaxIdMed();
		 		 		 String gname= txtGenericName.getText();
		 		 		 String bname= txtBrandName.getText();;
		 		 		 String category=(String) cbMedCategory.getSelectedItem();
		 		 		 Date manuDate = jdcManuDate.getDate();
		 		 		 int qty = Integer.parseInt(txtQty.getText());
		 		 		 Date expiDate = jdcExpDate.getDate();
		 		 		 String mMeasure = (String) cbMeasurement.getSelectedItem();
		 		 		 int measure = Integer.parseInt(txtMeas.getText());
		 		 		 
		 		 		 if(sel==0) {
		 		 			 if(manuDate.after(expiDate)) {
		 		 				 JOptionPane.showMessageDialog(null, "Date values are invalid", "Invalid Values",JOptionPane.WARNING_MESSAGE);
		 		 			 }else if(//txtIdMeds.getText().isEmpty()||
		 		 					 txtGenericName.getText().isEmpty()
                   		 ||txtBrandName.getText().isEmpty()
                   		 //||cbMedCategory.getSelectedItem().equals("")
                   		 ||jdcManuDate.getDate()==null
                   		 ||jdcExpDate.getDate()==null
                   		 ||txtQty.getText().isEmpty()
                   		 ||txtMeas.getText().isEmpty()
                   		 ||cbMeasurement.getSelectedItem().equals("")){
                        JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Add Medicine",JOptionPane.WARNING_MESSAGE);

                     }else {
                    	
                    		 JOptionPane.showMessageDialog(null,"Medicine successfully added!","Success",JOptionPane.INFORMATION_MESSAGE);
                    		 Data.addMedicines(id, qty, bname, gname, category, manuDate, expiDate, mMeasure, measure);
                   			 refreshMed();
                   			 generateMeds(Data);
                   			 
            				txtBrandName.setText("");
            				txtGenericName.setText("");
            				cbMedCategory.setSelectedItem("");
            				jdcManuDate.setDate(null);
            				jdcExpDate.setDate(null);
            				txtQty.setText("");
            				txtMeas.setText("");
            				cbMeasurement.setSelectedItem("");
            				
            				
            				txtMeas.setEnabled(false);
            				cbMeasurement.setEnabled(false);
            				txtBrandName.setEnabled(false);
            				txtGenericName.setEnabled(false);
            				cbMedCategory.setEnabled(false);
            				jdcManuDate.setEnabled(false);
            				jdcExpDate.setEnabled(false);
            				txtQty.setEnabled(false);
            				
            				btnAddMed.setVisible(true);
            				btnUpdateMed.setVisible(true);
            				btnDeleteMed.setVisible(true);
            				btnConfirmUpdateMed.setVisible(false);
            				btnConfirmAddMed.setVisible(false);
            				btnCancelMed.setVisible(false);
	                     
                     }
		 		 		 }
		 		 	}
		 		 });
		 		 btnDeleteMed.addActionListener(new ActionListener() {
		 		 	public void actionPerformed(ActionEvent e) {
		 		 		 if(txtBrandName.getText().isEmpty()
                   		 ||txtGenericName.getText().isEmpty()
                   		// ||cbPosition.getSelectedItem().equals("")
                   		 ||jdcManuDate.getDate()==null
                   		 ||jdcExpDate.getDate()==null){
                        JOptionPane.showMessageDialog(null,"Please select medicine to delete.","Delete Medicine",JOptionPane.WARNING_MESSAGE);

                     }else {
                    	 int sel = JOptionPane.showConfirmDialog(null,"Confirm Delete Medicine?","Delete Medicine", JOptionPane.YES_NO_OPTION);
                    	 if(sel==0) {
                    		 txtMeas.setText("");
                    		 cbMeasurement.setSelectedItem("");
            				txtQty.setText("");
            				txtBrandName.setText("");
            				txtGenericName.setText("");
            				cbMedCategory.setSelectedItem("");
            				jdcManuDate.setDate(null);
            				jdcExpDate.setDate(null);
             				Data.deleteMed(idholder);
             				refreshMed();
             				JOptionPane.showMessageDialog(null,"Successfully deleted medicine.","Delete Medicine",JOptionPane.INFORMATION_MESSAGE);
                    	 }else {
                    		 JOptionPane.showMessageDialog(null,"Please select medicine to delete.","Delete Medicine",JOptionPane.INFORMATION_MESSAGE);
                    	 }
                     }
		 		 	}
		 		 });
		 		 btnUpdateMed.addMouseListener(new MouseAdapter() {
		 		 	@Override
		 		 	public void mouseClicked(MouseEvent e) {
		 		 		if(txtBrandName.getText().isEmpty()
		 		 				||txtGenericName.getText().isEmpty()
		 		 				//||cbMedCategory.getSelectedItem().equals("")
		 		 				||jdcManuDate.getDate() == null
		 		 				||jdcExpDate.getDate()==null) {
		 		 			JOptionPane.showMessageDialog(null,"Please select medicine to update.","UPDATE MEDICINE",JOptionPane.WARNING_MESSAGE);
		 		 			
		 		 		}else {
		 		 			tblMeds.setEnabled(false);
		 		 			
		 		 			txtQty.setEnabled(true);
		 		 			txtBrandName.setEnabled(true);
		 		 			txtGenericName.setEnabled(true);
		 		 			cbMedCategory.setEnabled(true);
		 		 			jdcManuDate.setEnabled(true);
		 		 			jdcExpDate.setEnabled(true);
		 		 			txtMeas.setEnabled(true);
		 		 			cbMeasurement.setEnabled(true);
		 		 			txtBrandName.setEnabled(true);
		 		 			txtGenericName.setEnabled(true);
		 		 			btnAddMed.setVisible(false);
		 		 			btnUpdateMed.setVisible(false);
		 		 			btnDeleteMed.setVisible(false);
		 		 			btnConfirmAddMed.setVisible(false);
		 		 			btnConfirmUpdateMed.setVisible(true);
		 		 			btnCancelMed.setVisible(true);
		 		 		}

		 		 	}
		 		 });
		 		 btnAddMed.addMouseListener(new MouseAdapter() {
		 		 	@Override
		 		 	public void mouseClicked(MouseEvent e) {
		 		 		System.out.print(Data.getMaxIdMed());
		 		 		txtQty.setEnabled(true);
		 		 		txtBrandName.setEnabled(true);
		 		 		txtGenericName.setEnabled(true);
		 		 		cbMedCategory.setEnabled(true);
		 		 		jdcManuDate.setEnabled(true);
		 		 		jdcExpDate.setEnabled(true);
		 		 		
		 		 		txtMeas.setEnabled(true);
		 		 		cbMeasurement.setEnabled(true);
		 		 		txtBrandName.setEnabled(true);
		 		 		txtGenericName.setEnabled(true);
		 		 		btnAddMed.setVisible(false);
		 		 		btnUpdateMed.setVisible(false);
		 		 		btnDeleteMed.setVisible(false);
		 		 		btnConfirmAddMed.setVisible(true);
		 		 		btnCancelMed.setVisible(true);
	
		 		 		txtBrandName.setText("");
		 		 		txtGenericName.setText("");
		 		 		cbMedCategory.setSelectedItem("");
		 		 		jdcManuDate.setDate(null);
		 		 		jdcExpDate.setDate(null);
		 		 		txtQty.setText("");
		 		 	}
		 		 });
												
		JButton btnAddUser = new JButton("USER");
		btnAddUser.setFocusable(false);
		btnAddUser.setRequestFocusEnabled(false);
		btnAddUser.setRolloverEnabled(false);
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnAddUser.setBorder(null);
		btnAddUser.setBackground(new Color(36,46,50));
		btnAddUser.setBounds(0, 111, 231, 53);

		panel.setLayout(null);
		panel.add(btnAddUser);
		
		JButton btnMedicine = new JButton("MEDICINES");
		btnMedicine.setFocusable(false);
		btnMedicine.setRequestFocusEnabled(false);
		btnMedicine.setRolloverEnabled(false);
		btnMedicine.setForeground(Color.WHITE);
		btnMedicine.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnMedicine.setFocusPainted(false);

		btnMedicine.setBackground(new Color(36,46,50));
		btnMedicine.setBorder(null);
		btnMedicine.setBounds(0, 175, 231, 53);
		panel.add(btnMedicine);
		contentPane.add(panel);
		
		JButton btnResidents = new JButton("RESIDENTS");
		btnResidents.setFocusable(false);
		btnResidents.setRequestFocusEnabled(false);
		btnResidents.setRolloverEnabled(false);

		btnResidents.setForeground(Color.WHITE);
		btnResidents.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnResidents.setFocusPainted(false);
		btnResidents.setBorder(null);
		btnResidents.setBackground(new Color(36,46,50));
		btnResidents.setBounds(0, 239, 231, 53);
		panel.add(btnResidents);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFocusable(false);
		btnLogout.setRequestFocusEnabled(false);
		btnLogout.setRolloverEnabled(false);
		
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnLogout.setFocusPainted(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(36,46,50));
		btnLogout.setBounds(0, 431, 231, 53);
		panel.add(btnLogout);
		
		JButton btnVaccine = new JButton("VACCINE");
		btnVaccine.setFocusable(false);
		btnVaccine.setRequestFocusEnabled(false);
		btnVaccine.setRolloverEnabled(false);

		btnVaccine.setForeground(Color.WHITE);
		btnVaccine.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnVaccine.setFocusPainted(false);
		btnVaccine.setBorder(null);
		btnVaccine.setBackground(new Color(36,46,50));
		btnVaccine.setBounds(0, 303, 231, 53);
		panel.add(btnVaccine);
		
		JButton btnRecords = new JButton("RECORDS");
		btnRecords.setFocusable(false);
		btnRecords.setRequestFocusEnabled(false);
		btnRecords.setRolloverEnabled(false);
		
		btnRecords.setForeground(Color.WHITE);
		btnRecords.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnRecords.setFocusPainted(false);
		btnRecords.setBorder(null);
		btnRecords.setBackground(new Color(36,46,50));
		btnRecords.setBounds(0, 367, 231, 53);
		panel.add(btnRecords);
		
		JButton btnNewButton_1 = new JButton("DASHBOARD");
		
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_dashboard_white_36dp.png"));
		btnNewButton_1.setToolTipText("See dashboard.");
		btnNewButton_1.setRequestFocusEnabled(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(0, 26, 231, 74);
		panel.add(btnNewButton_1);
						 				
						 				JPanel pnlRecord = new JPanel();
						 				pnlRecord.setVisible(false);
						 				pnlRecord.setBackground(new Color(74,94,104));
						 				pnlRecord.setBounds(231, 0, 871, 544);
						 				contentPane.add(pnlRecord);
						 				pnlRecord.setLayout(null);
						 				
						 				JScrollPane scrollPane_4 = new JScrollPane();
						 				scrollPane_4.setBounds(10, 193, 416, 340);
						 				pnlRecord.add(scrollPane_4);
						 				
						 				tblVaccine = new JTable();
						 				scrollPane_4.setViewportView(tblVaccine);
						 				
						 				JScrollPane scrollPane_4_1 = new JScrollPane();
						 				scrollPane_4_1.setBounds(445, 193, 416, 340);
						 				pnlRecord.add(scrollPane_4_1);
						 				
						 				tblMedicine = new JTable();
						 				scrollPane_4_1.setViewportView(tblMedicine);
						 				
						 				JLabel lblNewLabel_10 = new JLabel("REPORT");
						 				lblNewLabel_10.setOpaque(true);
						 				lblNewLabel_10.setBackground(new Color(36,46,50));
						 				lblNewLabel_10.setForeground(new Color(255, 255, 255));
						 				lblNewLabel_10.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
						 				lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_10.setBounds(251, 11, 362, 51);
						 				pnlRecord.add(lblNewLabel_10);
						 				
						 				JLabel lblNewLabel_11 = new JLabel("VACCINE");
						 				lblNewLabel_11.setOpaque(true);
						 				lblNewLabel_11.setBackground(new Color(36,46,50));
						 				lblNewLabel_11.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_11.setForeground(new Color(255, 255, 255));
						 				lblNewLabel_11.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_11.setBounds(10, 96, 416, 39);
						 				pnlRecord.add(lblNewLabel_11);
						 				
						 				JLabel lblNewLabel_11_1 = new JLabel("MEDICINE");
						 				lblNewLabel_11_1.setOpaque(true);
						 				lblNewLabel_11_1.setBackground(new Color(36,46,50));
						 				lblNewLabel_11_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_11_1.setForeground(Color.WHITE);
						 				lblNewLabel_11_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_11_1.setBounds(445, 96, 416, 39);
						 				pnlRecord.add(lblNewLabel_11_1);
						 				
						 				txtSearch = new JTextField();
						 				txtSearch.addKeyListener(new KeyAdapter() {
						 					@Override
						 					public void keyReleased(KeyEvent e) {
						 						if (txtSearch.getText().equals(null) || txtSearch.getText().equals("")) {
						 							Data.populateTblAllVacRecord();
						 							generateTableVaccineRecord(Data);
						 						}else {
						 							Data.searchVaccine(txtSearch.getText());
						 							generateTableVaccineRecord(Data);
						 						}
						 					}
						 				});
						 				txtSearch.setBounds(125, 146, 301, 36);
						 				pnlRecord.add(txtSearch);
						 				txtSearch.setColumns(10);
						 				
						 				JLabel lblNewLabel_12 = new JLabel("SEARCH");
						 				lblNewLabel_12.setForeground(new Color(255, 255, 255));
						 				lblNewLabel_12.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_12.setBounds(10, 146, 105, 41);
						 				pnlRecord.add(lblNewLabel_12);
						 				
						 				txtSearchMeds = new JTextField();
						 				txtSearchMeds.addKeyListener(new KeyAdapter() {
						 					@Override
						 					public void keyReleased(KeyEvent e) {
						 						if (txtSearchMeds.getText().equals(null) || txtSearchMeds.getText().equals("")) {
						 							Data.populateTransactionRecords();
						 							generateTblMedicineRecord(Data);
						 						}else {
						 							Data.searchMediccine(txtSearchMeds.getText());
						 							generateTblMedicineRecord(Data);
						 						}
						 					}
						 				});
						 				txtSearchMeds.setColumns(10);
						 				txtSearchMeds.setBounds(560, 146, 301, 36);
						 				pnlRecord.add(txtSearchMeds);
						 				
						 				JLabel lblNewLabel_12_1 = new JLabel("SEARCH");
						 				lblNewLabel_12_1.setForeground(Color.WHITE);
						 				lblNewLabel_12_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_12_1.setBounds(445, 146, 105, 41);
						 				pnlRecord.add(lblNewLabel_12_1);
						 				
						 						
						 						JPanel pnlVaccine = new JPanel();
						 						pnlVaccine.setVisible(false);
						 						pnlVaccine.setBackground(new Color(74,94,104));
						 						pnlVaccine.setBounds(231, 0, 871, 544);
						 						contentPane.add(pnlVaccine);
						 						pnlVaccine.setLayout(null);
						 						
						 						JLabel lblNewLabel_1_1 = new JLabel("VACCINES");
						 						lblNewLabel_1_1.setOpaque(true);
						 						lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 						lblNewLabel_1_1.setForeground(Color.WHITE);
						 						lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
						 						lblNewLabel_1_1.setBackground(new Color(36, 46, 50));
						 						lblNewLabel_1_1.setBounds(228, 38, 393, 42);
						 						pnlVaccine.add(lblNewLabel_1_1);
						 						
						 						JScrollPane scrollPane_3 = new JScrollPane();
						 						scrollPane_3.setBounds(10, 172, 407, 361);
						 						pnlVaccine.add(scrollPane_3);
						 						
						 						tblVaccines = new JTable();
						 						scrollPane_3.setViewportView(tblVaccines);
						 						
						 						JLabel lblNewLabel_4 = new JLabel("VACCINE NAME:");
						 						lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
						 						lblNewLabel_4.setForeground(new Color(255, 255, 255));
						 						lblNewLabel_4.setBounds(497, 172, 157, 30);
						 						pnlVaccine.add(lblNewLabel_4);
						 						
						 						txtVacName = new JTextField();
						 						txtVacName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 						txtVacName.setEnabled(false);
						 						txtVacName.setBounds(497, 202, 281, 30);
						 						pnlVaccine.add(txtVacName);
						 						txtVacName.setColumns(10);
						 						
						 						JLabel lblNewLabel_4_1 = new JLabel("VACCINE QUANTITY:");
						 						lblNewLabel_4_1.setForeground(Color.WHITE);
						 						lblNewLabel_4_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
						 						lblNewLabel_4_1.setBounds(497, 243, 198, 30);
						 						pnlVaccine.add(lblNewLabel_4_1);
						 						
						 						txtVacQty = new JTextField();
						 						txtVacQty.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 						txtVacQty.setEnabled(false);
						 						txtVacQty.setColumns(10);
						 						txtVacQty.setBounds(497, 273, 157, 30);
						 						pnlVaccine.add(txtVacQty);
						 						
						 						JLabel lblNewLabel_4_1_1 = new JLabel("MANUFACTURED DATE:");
						 						lblNewLabel_4_1_1.setForeground(Color.WHITE);
						 						lblNewLabel_4_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
						 						lblNewLabel_4_1_1.setBounds(497, 314, 225, 30);
						 						pnlVaccine.add(lblNewLabel_4_1_1);
						 						
						 						dcVacManu = new JDateChooser();
						 						dcVacManu.setBounds(497, 345, 225, 30);
						 						dcVacManu.setEnabled(false);
						 						dcVacManu.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 						pnlVaccine.add(dcVacManu);
						 						
						 						JLabel lblNewLabel_4_1_1_1 = new JLabel("EXPIRATION DATE:");
						 						lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
						 						lblNewLabel_4_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
						 						lblNewLabel_4_1_1_1.setBounds(497, 386, 177, 30);
						 						pnlVaccine.add(lblNewLabel_4_1_1_1);
						 						
						 						dcVacExpi = new JDateChooser();
						 						dcVacExpi.setBounds(497, 417, 225, 30);
						 						dcVacExpi.setEnabled(false);
						 						dcVacExpi.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 						pnlVaccine.add(dcVacExpi);
						 						
						 						JButton btnAddVac = new JButton("ADD");
						 						
						 								btnAddVac.setForeground(Color.WHITE);
						 								btnAddVac.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 								btnAddVac.setFocusable(false);
						 								btnAddVac.setFocusTraversalKeysEnabled(false);
						 								btnAddVac.setFocusPainted(false);
						 								btnAddVac.setBorder(null);
						 								btnAddVac.setBackground(new Color(36, 46, 50));
						 								btnAddVac.setBounds(474, 484, 107, 37);
						 								pnlVaccine.add(btnAddVac);
						 								
						 								JButton btnUpdateVac = new JButton("UPDATE");
						 								
						 								btnUpdateVac.setForeground(Color.WHITE);
						 								btnUpdateVac.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 								btnUpdateVac.setFocusable(false);
						 								btnUpdateVac.setFocusTraversalKeysEnabled(false);
						 								btnUpdateVac.setFocusPainted(false);
						 								btnUpdateVac.setBorder(null);
						 								btnUpdateVac.setBackground(new Color(36, 46, 50));
						 								btnUpdateVac.setBounds(591, 484, 107, 37);
						 								pnlVaccine.add(btnUpdateVac);
						 								
						 								JButton btnDeleteVac = new JButton("DELETE");
						 								btnDeleteVac.setForeground(Color.WHITE);
						 								btnDeleteVac.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 								btnDeleteVac.setFocusable(false);
						 								btnDeleteVac.setFocusTraversalKeysEnabled(false);
						 								btnDeleteVac.setFocusPainted(false);
						 								btnDeleteVac.setBorder(null);
						 								btnDeleteVac.setBackground(new Color(36, 46, 50));
						 								btnDeleteVac.setBounds(708, 484, 107, 37);
						 								pnlVaccine.add(btnDeleteVac);
						 								
						 								JButton btnCfAddVac = new JButton("CONFIRM");
						 								
						 								btnCfAddVac.setVisible(false);
						 								btnCfAddVac.setForeground(Color.WHITE);
						 								btnCfAddVac.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 								btnCfAddVac.setFocusable(false);
						 								btnCfAddVac.setFocusTraversalKeysEnabled(false);
						 								btnCfAddVac.setFocusPainted(false);
						 								btnCfAddVac.setBorder(null);
						 								btnCfAddVac.setBackground(new Color(36, 46, 50));
						 								btnCfAddVac.setBounds(474, 484, 107, 37);
						 								pnlVaccine.add(btnCfAddVac);
						 								
						 								JButton btnCfUpVac = new JButton("CONFIRM");
						 								btnCfUpVac.setVisible(false);
						 								btnCfUpVac.setForeground(Color.WHITE);
						 								btnCfUpVac.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 								btnCfUpVac.setFocusable(false);
						 								btnCfUpVac.setFocusTraversalKeysEnabled(false);
						 								btnCfUpVac.setFocusPainted(false);
						 								btnCfUpVac.setBorder(null);
						 								btnCfUpVac.setBackground(new Color(36, 46, 50));
						 								btnCfUpVac.setBounds(474, 484, 107, 37);
						 								pnlVaccine.add(btnCfUpVac);
						 								
						 								JButton btnCancelVac = new JButton("CANCEL");
						 								btnCancelVac.setVisible(false);
						 								btnCancelVac.setForeground(Color.WHITE);
						 								btnCancelVac.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 								btnCancelVac.setFocusable(false);
						 								btnCancelVac.setFocusTraversalKeysEnabled(false);
						 								btnCancelVac.setFocusPainted(false);
						 								btnCancelVac.setBorder(null);
						 								btnCancelVac.setBackground(new Color(36, 46, 50));
						 								btnCancelVac.setBounds(591, 484, 107, 37);
						 								pnlVaccine.add(btnCancelVac);
						 								
						 								JLabel lblNewLabel_13 = new JLabel("SEARCH:");
						 								lblNewLabel_13.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
						 								lblNewLabel_13.setForeground(new Color(255, 255, 255));
						 								lblNewLabel_13.setBounds(10, 129, 88, 32);
						 								pnlVaccine.add(lblNewLabel_13);
						 								
						 								txtSearchVac = new JTextField();
						 								txtSearchVac.addKeyListener(new KeyAdapter() {
						 									@Override
						 									public void keyReleased(KeyEvent e) {
						 										if (txtSearchVac.getText().equals(null) || txtSearchVac.getText().equals("")) {
						 												Data.populatetblVac();
						 												generateTblVaccines(Data);
						 											}else {
						 												Data.searchVaccineList(txtSearchVac.getText());
						 												generateTblVaccines(Data);
						 										}
						 									}
						 								});
						 								
						 										txtSearchVac.setBounds(108, 129, 309, 32);
						 										pnlVaccine.add(txtSearchVac);
						 										txtSearchVac.setColumns(10);
						 										 		 
						 										 		 										 table = new JTable();
						 										 		 										 table.setRowSelectionAllowed(false);
						 										 		 										 table.setFocusable(false);
						 										 		 										 table.setFocusTraversalKeysEnabled(false);
						 										 		 										 table.setSelectionBackground(Color.DARK_GRAY);
						 										 		 										 table.setRequestFocusEnabled(false);
						 										 		 										 table.setGridColor(new Color(74,94,104));
						 										 		 										 table.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
						 										 		 										 table.setBackground(new Color(36,46,50));
						 										 		 										 table.setForeground(new Color(255, 255, 255));
						 										 		 										 table.setFillsViewportHeight(true);
						 										 		 										 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						 										 		 										 table.setOpaque(false);
						 										 		 										 JPanel pnlUser = new JPanel();
						 										 		 										 pnlUser.setVisible(false);
						 										 		 										 pnlUser.setBackground(new Color(74,94,104));
						 										 		 										 pnlUser.setBounds(231, 0, 871, 544);
						 										 		 										 cbPosition = new JComboBox();
						 										 		 										 cbPosition.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 cbPosition.setFocusTraversalKeysEnabled(false);
						 										 		 										 cbPosition.setFocusable(false);
						 										 		 										 cbPosition.setLightWeightPopupEnabled(false);
						 										 		 										 cbPosition.setOpaque(false);
						 										 		 										 cbPosition.setRequestFocusEnabled(false);
						 										 		 										 cbPosition.setBorder(null);
						 										 		 										 cbPosition.setEnabled(false);
						 										 		 										 cbPosition.setModel(new DefaultComboBoxModel(new String[] {"", "ADMIN", "EMPLOYEE"}));
						 										 		 										 
						 										 		 										 
						 										 		 										 cbPosition.setBounds(639, 267, 140, 27);
						 										 		 										 JScrollPane scrollPane = new JScrollPane();
						 										 		 										 scrollPane.getViewport().setBackground(new Color(36,46,50));
						 										 		 										 scrollPane.getViewport().setBorder(null);
						 										 		 										 scrollPane.getViewport().setRequestFocusEnabled(false);
						 										 		 										 
						 										 		 										 scrollPane.setBorder(null);
						 										 		 										 scrollPane.setOpaque(false);
						 										 		 										 
						 										 		 										 scrollPane.setBounds(10, 131, 416, 402);
						 										 		 										 
						 										 		 										 JLabel lblFname = new JLabel("FIRST NAME:");
						 										 		 										 lblFname.setForeground(new Color(255, 255, 255));
						 										 		 										 lblFname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 lblFname.setBounds(437, 153, 108, 27);
						 										 		 										 
						 										 		 										 JLabel lblMname = new JLabel("MIDDLE NAME:");
						 										 		 										 lblMname.setForeground(new Color(255, 255, 255));
						 										 		 										 lblMname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 lblMname.setBounds(436, 191, 130, 27);
						 										 		 										 
						 										 		 										 JLabel lblLname = new JLabel("LAST NAME:");
						 										 		 										 lblLname.setForeground(new Color(255, 255, 255));
						 										 		 										 lblLname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 lblLname.setBounds(436, 229, 105, 27);
						 										 		 										 
						 										 		 										 JLabel lblPosition = new JLabel("POSITION:");
						 										 		 										 lblPosition.setForeground(new Color(255, 255, 255));
						 										 		 										 lblPosition.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 lblPosition.setBounds(436, 267, 89, 27);
						 										 		 										 
						 										 		 										 txtFname = new JTextField();
						 										 		 										 txtFname.setForeground(Color.WHITE);
						 										 		 										 txtFname.setDisabledTextColor(Color.LIGHT_GRAY);
						 										 		 										 txtFname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 txtFname.setOpaque(false);
						 										 		 										 txtFname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						 										 		 										 txtFname.setEnabled(false);
						 										 		 										 
						 										 		 										 		txtFname.setBounds(639, 153, 202, 27);
						 										 		 										 		txtFname.setColumns(10);
						 										 		 										 		
						 										 		 										 		txtMname = new JTextField();
						 										 		 										 		txtMname.setForeground(Color.WHITE);
						 										 		 										 		txtMname.setDisabledTextColor(Color.LIGHT_GRAY);
						 										 		 										 		txtMname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 		txtMname.setOpaque(false);
						 										 		 										 		txtMname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						 										 		 										 		txtMname.setEnabled(false);
						 										 		 										 		txtMname.setEditable(false);
						 										 		 										 		txtMname.setBounds(639, 191, 202, 27);
						 										 		 										 		txtMname.setColumns(10);
						 										 		 										 		
						 										 		 										 		txtLname = new JTextField();
						 										 		 										 		txtLname.setForeground(Color.WHITE);
						 										 		 										 		txtLname.setDisabledTextColor(Color.LIGHT_GRAY);
						 										 		 										 		txtLname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 		txtLname.setOpaque(false);
						 										 		 										 		txtLname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						 										 		 										 		txtLname.setEnabled(false);
						 										 		 										 		
						 										 		 										 				txtLname.setBounds(639, 229, 202, 27);
						 										 		 										 				txtLname.setColumns(10);
						 										 		 										 				
	
						 										 		 										 				
						 										 		 										 				JLabel lblUsername = new JLabel("USERNAME:");
						 										 		 										 				lblUsername.setForeground(new Color(255, 255, 255));
						 										 		 										 				lblUsername.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				lblUsername.setBounds(436, 343, 102, 27);
						 										 		 										 				
						 										 		 										 				txtUsername = new JTextField();
						 										 		 										 				txtUsername.setForeground(Color.WHITE);
						 										 		 										 				txtUsername.setDisabledTextColor(Color.LIGHT_GRAY);
						 										 		 										 				txtUsername.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				txtUsername.setOpaque(false);
						 										 		 										 				txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						 										 		 										 				txtUsername.setEnabled(false);
						 										 		 										 				txtUsername.setEditable(false);
						 										 		 										 				txtUsername.setBounds(639, 343, 202, 27);
						 										 		 										 				txtUsername.setColumns(10);
						 										 		 										 				
						 										 		 										 				txtPw = new JPasswordField();
						 										 		 										 				txtPw.setForeground(Color.WHITE);
						 										 		 										 				txtPw.setDisabledTextColor(Color.LIGHT_GRAY);
						 										 		 										 				txtPw.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				txtPw.setOpaque(false);
						 										 		 										 				txtPw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						 										 		 										 				txtPw.setEnabled(false);
						 										 		 										 				txtPw.setEditable(false);
						 										 		 										 				txtPw.setBounds(639, 381, 202, 27);
						 										 		 										 				
						 										 		 										 				JLabel lblPassword = new JLabel("PASSWORD:");
						 										 		 										 				lblPassword.setForeground(new Color(255, 255, 255));
						 										 		 										 				lblPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				lblPassword.setBounds(436, 381, 105, 27);
						 										 		 										 				
						 										 		 										 				JLabel lblConfirmPass = new JLabel("CONFIRM PASSWORD:");
						 										 		 										 				lblConfirmPass.setForeground(new Color(255, 255, 255));
						 										 		 										 				lblConfirmPass.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				lblConfirmPass.setBounds(436, 419, 193, 27);
						 										 		 										 				
						 										 		 										 				txtCPw = new JPasswordField();
						 										 		 										 				txtCPw.setForeground(Color.WHITE);
						 										 		 										 				txtCPw.setDisabledTextColor(Color.LIGHT_GRAY);
						 										 		 										 				txtCPw.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				txtCPw.setOpaque(false);
						 										 		 										 				txtCPw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
						 										 		 										 				txtCPw.setEnabled(false);
						 										 		 										 				txtCPw.setEditable(false);
						 										 		 										 				txtCPw.setBounds(639, 419, 202, 27);
						 										 		 										 				
						 										 		 										 				JButton btnAddUsers = new JButton("ADD");
						 										 		 										 				btnAddUsers.setForeground(new Color(255, 255, 255));
						 										 		 										 				btnAddUsers.setBackground(new Color(36,46,50));
						 										 		 										 				btnAddUsers.setBorder(null);
						 										 		 										 				btnAddUsers.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 				btnAddUsers.setFocusPainted(false);
						 										 		 										 				btnAddUsers.setFocusTraversalKeysEnabled(false);
						 										 		 										 				btnAddUsers.setFocusable(false);
						 										 		 										 				btnAddUsers.setBounds(500, 479, 107, 37);
						 										 		 										 				
						 										 		 										 						JButton btnUpdate = new JButton("UPDATE");
						 										 		 										 						btnUpdate.setForeground(new Color(255, 255, 255));
						 										 		 										 						btnUpdate.setBackground(new Color(36,46,50));
						 										 		 										 						btnUpdate.setBorder(null);
						 										 		 										 						btnUpdate.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 						btnUpdate.setFocusPainted(false);
						 										 		 										 						btnUpdate.setFocusTraversalKeysEnabled(false);
						 										 		 										 						btnUpdate.setFocusable(false);
						 										 		 										 						
						 										 		 										 						btnUpdate.setBounds(617, 479, 107, 37);
						 										 		 										 						
						 										 		 										 						JButton btnDelete = new JButton("DELETE");
						 										 		 										 						btnDelete.setForeground(new Color(255, 255, 255));
						 										 		 										 						btnDelete.setBackground(new Color(36,46,50));
						 										 		 										 						btnDelete.setBorder(null);
						 										 		 										 						btnDelete.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 						btnDelete.setFocusPainted(false);
						 										 		 										 						btnDelete.setFocusTraversalKeysEnabled(false);
						 										 		 										 						btnDelete.setFocusable(false);
						 										 		 										 						btnDelete.setBounds(734, 479, 107, 37);
						 										 		 										 						
						 										 		 										 						pnlUser.setLayout(null);
						 										 		 										 						
						 										 		 										 						
						 										 		 										 								scrollPane.setViewportView(table);
						 										 		 										 								pnlUser.add(scrollPane);
						 										 		 										 								pnlUser.add(lblLname);
						 										 		 										 								pnlUser.add(lblMname);
						 										 		 										 								pnlUser.add(lblFname);
						 										 		 										 								pnlUser.add(txtLname);
						 										 		 										 								pnlUser.add(txtMname);
						 										 		 										 								pnlUser.add(txtFname);
						 										 		 										 								pnlUser.add(lblPassword);
						 										 		 										 								pnlUser.add(lblConfirmPass);
						 										 		 										 								pnlUser.add(lblUsername);
						 										 		 										 								pnlUser.add(lblPosition);
						 										 		 										 								pnlUser.add(cbPosition);
						 										 		 										 								pnlUser.add(txtCPw);
						 										 		 										 								pnlUser.add(txtPw);
						 										 		 										 								pnlUser.add(txtUsername);
						 										 		 										 								pnlUser.add(btnAddUsers);
						 										 		 										 								pnlUser.add(btnUpdate);
						 										 		 										 								pnlUser.add(btnDelete);
						 										 		 										 								
						 										 		 										 								JButton btnConfirm = new JButton("CONFIRM");
						 										 		 										 								btnConfirm.setForeground(new Color(255, 255, 255));
						 										 		 										 								btnConfirm.setBackground(new Color(36,46,50));
						 										 		 										 								btnConfirm.setBorder(null);
						 										 		 										 								btnConfirm.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 								btnConfirm.setFocusPainted(false);
						 										 		 										 								btnConfirm.setFocusTraversalKeysEnabled(false);
						 										 		 										 								btnConfirm.setFocusable(false);
						 										 		 										 								btnConfirm.setBounds(500, 479, 107, 37);
						 										 		 										 								pnlUser.add(btnConfirm);
						 										 		 										 								btnConfirm.hide();
						 										 		 										 								
						 										 		 										 								JButton btnCancelUser = new JButton("CANCEL");
						 										 		 										 								btnCancelUser.setForeground(new Color(255, 255, 255));
						 										 		 										 								btnCancelUser.setBackground(new Color(36,46,50));
						 										 		 										 								btnCancelUser.setBorder(null);
						 										 		 										 								btnCancelUser.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 								btnCancelUser.setFocusPainted(false);
						 										 		 										 								btnCancelUser.setFocusTraversalKeysEnabled(false);
						 										 		 										 								btnCancelUser.setFocusable(false);
						 										 		 										 								btnCancelUser.setBounds(617, 479, 107, 37);
						 										 		 										 								pnlUser.add(btnCancelUser);
						 										 		 										 								
						 										 		 										 								JButton btnConfirmUpdate = new JButton("CONFIRM");
						 										 		 										 								btnConfirmUpdate.setForeground(new Color(255, 255, 255));
						 										 		 										 								btnConfirmUpdate.setBackground(new Color(36,46,50));
						 										 		 										 								btnConfirmUpdate.setBorder(null);
						 										 		 										 								btnConfirmUpdate.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 								btnConfirmUpdate.setFocusPainted(false);
						 										 		 										 								btnConfirmUpdate.setFocusTraversalKeysEnabled(false);
						 										 		 										 								btnConfirmUpdate.setFocusable(false);
						 										 		 										 								btnConfirmUpdate.setBounds(500, 479, 107, 37);
						 										 		 										 								pnlUser.add(btnConfirmUpdate);
						 										 		 										 								btnConfirmUpdate.hide();
						 										 		 										 								contentPane.add(pnlUser);
						 										 		 										 								
						 										 		 										 								JLabel lblNewLabel_2 = new JLabel("USER INFORMATION");
						 										 		 										 								lblNewLabel_2.setForeground(new Color(255, 255, 255));
						 										 		 										 								lblNewLabel_2.setOpaque(true);
						 										 		 										 								lblNewLabel_2.setBackground(new Color(36,46,50));
						 										 		 										 								lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
						 										 		 										 								lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
						 										 		 										 								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						 										 		 										 								lblNewLabel_2.setBounds(203, 19, 456, 47);
						 										 		 										 								pnlUser.add(lblNewLabel_2);
						 										 		 										 								
						 										 		 										 								JLabel lblSearchl = new JLabel("SEARCH:");
						 										 		 										 								lblSearchl.setForeground(Color.WHITE);
						 										 		 										 								lblSearchl.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 								lblSearchl.setBounds(10, 93, 89, 27);
						 										 		 										 								pnlUser.add(lblSearchl);
						 										 		 										 								
						 										 		 										 								txtUserSearch = new JTextField();
						 										 		 										 								txtUserSearch.addKeyListener(new KeyAdapter() {
						 										 		 										 									@Override
						 										 		 										 									public void keyReleased(KeyEvent e) {
						 										 		 										 										if (txtUserSearch.getText().equals(null) || txtUserSearch.getText().equals("")) {
						 										 		 										 											Data.populateJtable();
						 										 		 										 											generateUser(Data);
						 										 		 										 										}else {
						 										 		 										 											Data.searchUser(txtUserSearch.getText());
						 										 		 										 											generateUser(Data);
						 										 		 										 									}
						 										 		 										 									}
						 										 		 										 								});
						 										 		 										 								txtUserSearch.setBounds(109, 93, 317, 27);
						 										 		 										 								pnlUser.add(txtUserSearch);
						 										 		 										 								txtUserSearch.setColumns(10);
						 										 		 										 								
						 										 		 										 								JLabel lblStatus = new JLabel("STATUS:");
						 										 		 										 								lblStatus.setForeground(Color.WHITE);
						 										 		 										 								lblStatus.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 								lblStatus.setBounds(436, 305, 89, 27);
						 										 		 										 								pnlUser.add(lblStatus);
						 										 		 										 								
						 										 		 										 								cbStatus = new JComboBox();
						 										 		 										 								cbStatus.setModel(new DefaultComboBoxModel(new String[] {"", "LOCKED", "ACTIVE"}));
						 										 		 										 								cbStatus.setRequestFocusEnabled(false);
						 										 		 										 								cbStatus.setOpaque(false);
						 										 		 										 								cbStatus.setLightWeightPopupEnabled(false);
						 										 		 										 								cbStatus.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
						 										 		 										 								cbStatus.setFocusable(false);
						 										 		 										 								cbStatus.setFocusTraversalKeysEnabled(false);
						 										 		 										 								cbStatus.setEnabled(false);
						 										 		 										 								cbStatus.setBorder(null);
						 										 		 										 								cbStatus.setBounds(639, 305, 140, 27);
						 										 		 										 								pnlUser.add(cbStatus);
						 										 		 										 								
						 										 		 										 								JPanel pnlResidents = new JPanel();
						 										 		 										 								pnlResidents.setVisible(false);
						 										 		 										 								pnlResidents.setBackground(new Color(74,94,104));
						 										 		 										 								pnlResidents.setBounds(231, 0, 1175, 544);
						 										 		 										 								contentPane.add(pnlResidents);
						 										 		 										 								pnlResidents.setLayout(null);
						 										 		 										 								
						 										 		 										 								JLabel lblNewLabel_2_1 = new JLabel("RESIDENTS");
						 										 		 										 								lblNewLabel_2_1.setBounds(352, 11, 525, 47);
						 										 		 										 								lblNewLabel_2_1.setOpaque(true);
						 										 		 										 								lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 										 		 										 								lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
						 										 		 										 								lblNewLabel_2_1.setForeground(Color.WHITE);
						 										 		 										 								lblNewLabel_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
						 										 		 										 								lblNewLabel_2_1.setBackground(new Color(36,46,50));
						 										 		 										 								pnlResidents.add(lblNewLabel_2_1);
						 										 		 										 								
						 										 		 										 								JScrollPane scrollPane_2 = new JScrollPane();
						 										 		 										 								scrollPane_2.setBounds(10, 143, 439, 390);
						 										 		 										 								pnlResidents.add(scrollPane_2);
						 										 		 										 								scrollPane_2.getViewport().setBackground(new Color(36,46,50));
						 										 		 										 								scrollPane_2.getViewport().setBorder(null);
						 										 		 										 								scrollPane_2.getViewport().setRequestFocusEnabled(false);
						 										 		 										 								
		scrollPane_2.setBorder(null);
		scrollPane_2.setOpaque(false);
		
		tblResident = new JTable();
		tblResident.setRowSelectionAllowed(false);
		tblResident.setFocusable(false);
		tblResident.setFocusTraversalKeysEnabled(false);
		tblResident.setSelectionBackground(Color.DARK_GRAY);
		tblResident.setRequestFocusEnabled(false);
		tblResident.setGridColor(new Color(74,94,104));
		tblResident.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		tblResident.setBackground(new Color(36,46,50));
		tblResident.setForeground(new Color(255, 255, 255));
		tblResident.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResident.setOpaque(false);
		scrollPane_2.setViewportView(tblResident);
		
		imgHolder = new JLabel("");
		imgHolder.setHorizontalAlignment(SwingConstants.CENTER);
		imgHolder.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\pngfind.png"));
		imgHolder.setBounds(459, 143, 122, 122);
		pnlResidents.add(imgHolder);
		
		JLabel lblNewLabel_3 = new JLabel("FIRST NAME");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(591, 177, 119, 26);
		pnlResidents.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("MIDDLE NAME");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(775, 177, 137, 26);
		pnlResidents.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("LAST NAME");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(959, 177, 111, 26);
		pnlResidents.add(lblNewLabel_3_1_1);
		
		txtFn = new JTextField();
		txtFn.setForeground(new Color(255, 255, 255));
		txtFn.setOpaque(false);
		txtFn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		txtFn.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		txtFn.setEnabled(false);
		txtFn.setBounds(591, 200, 174, 25);
		pnlResidents.add(txtFn);
		txtFn.setColumns(10);
		
		txtMn = new JTextField();
		
				txtMn.setForeground(new Color(255, 255, 255));
				txtMn.setOpaque(false);
				txtMn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
				txtMn.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
				txtMn.setEnabled(false);
				txtMn.setColumns(10);
				txtMn.setBounds(775, 200, 174, 25);
				pnlResidents.add(txtMn);
				
				txtLn = new JTextField();
				txtLn.setForeground(new Color(255, 255, 255));
				txtLn.setOpaque(false);
				txtLn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
				txtLn.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
				txtLn.setEnabled(false);
				txtLn.setColumns(10);
				txtLn.setBounds(959, 200, 174, 25);
				pnlResidents.add(txtLn);
				
				btnUpload = new JButton("UPLOAD");
				btnUpload.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ImageIcon newImage = null;
						chooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter(".image","png","jpg","jpeg");
						chooser.setFileFilter(filter);
						int result = chooser.showOpenDialog(null);
						if(result==JFileChooser.APPROVE_OPTION) {
						f = chooser.getSelectedFile();
						filename=f.getAbsolutePath();
						ImageIcon image = new ImageIcon(filename);
						Image im = image.getImage();
                Image myImg = im.getScaledInstance(140, 140 ,Image.SCALE_SMOOTH);
                newImage = new ImageIcon(myImg);
                imgHolder.setIcon(newImage);
						}else {
							return;
						}
					}
				});
				btnUpload.setBounds(459, 271, 122, 23);
				pnlResidents.add(btnUpload);
				
				JLabel lblNewLabel_3_2_1 = new JLabel("GENDER");
				lblNewLabel_3_2_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_3_2_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
				lblNewLabel_3_2_1.setBounds(591, 248, 83, 26);
				pnlResidents.add(lblNewLabel_3_2_1);
				
				cbResGen = new JComboBox();
				cbResGen.setRequestFocusEnabled(false);
				cbResGen.setOpaque(false);
				cbResGen.setFocusTraversalKeysEnabled(false);
				cbResGen.setFocusable(false);
				cbResGen.setForeground(new Color(255, 255, 255));
				cbResGen.setBackground(new Color(74,94,104));
				cbResGen.setLightWeightPopupEnabled(false);
				cbResGen.setBorder(null);
				cbResGen.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
				cbResGen.setEnabled(false);
				cbResGen.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
				cbResGen.setBounds(591, 271, 155, 25);
				pnlResidents.add(cbResGen);
				
				
				JLabel lblNewLabel_3_2_1_1 = new JLabel("BIRTHDATE");
				lblNewLabel_3_2_1_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_3_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
				lblNewLabel_3_2_1_1.setBounds(756, 248, 110, 26);
				pnlResidents.add(lblNewLabel_3_2_1_1);
				
				dcBdateRes = new JDateChooser();
				dcBdateRes.setBounds(756, 271, 155, 25);
				dcBdateRes.setEnabled(false);
				dcBdateRes.setBackground(new Color(74,94,104));
				dcBdateRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
				dcBdateRes.setForeground(new Color(255, 255, 255));
				
						pnlResidents.add(dcBdateRes);
						
						JLabel lblNewLabel_3_2_1_1_1 = new JLabel("POSITION IN FAMILY");
						lblNewLabel_3_2_1_1_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_1_1.setBounds(921, 248, 199, 26);
						pnlResidents.add(lblNewLabel_3_2_1_1_1);
						
						cbPosRes = new JComboBox();
						cbPosRes.setRequestFocusEnabled(false);
						cbPosRes.setOpaque(false);
						cbPosRes.setFocusTraversalKeysEnabled(false);
						cbPosRes.setFocusable(false);
						cbPosRes.setForeground(new Color(255, 255, 255));
						cbPosRes.setBackground(new Color(74,94,104));
						cbPosRes.setBorder(null);
						cbPosRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						cbPosRes.setEnabled(false);
						cbPosRes.setModel(new DefaultComboBoxModel(new String[] {"", "HEAD OF THE FAMILY", "MEMBER"}));
						cbPosRes.setBounds(921, 270, 155, 25);
						pnlResidents.add(cbPosRes);
						
						JLabel lblNewLabel_3_2_1_2 = new JLabel("STREET");
						lblNewLabel_3_2_1_2.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2.setBounds(459, 315, 77, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2);
						
						txtSt = new JTextField();
						txtSt.setForeground(new Color(255, 255, 255));
						txtSt.setOpaque(false);
						txtSt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
						txtSt.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						txtSt.setEnabled(false);
						txtSt.setColumns(10);
						txtSt.setBounds(459, 338, 159, 25);
						pnlResidents.add(txtSt);
						
						JLabel lblNewLabel_3_2_1_2_1 = new JLabel("BARANGAY");
						lblNewLabel_3_2_1_2_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_1.setBounds(628, 315, 109, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_1);
						
						txtBgy = new JTextField();
						txtBgy.setForeground(new Color(255, 255, 255));
						txtBgy.setOpaque(false);
						txtBgy.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
						txtBgy.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						txtBgy.setEnabled(false);
						txtBgy.setColumns(10);
						txtBgy.setBounds(628, 338, 155, 25);
						pnlResidents.add(txtBgy);
						
						txtCity = new JTextField();
						txtCity.setForeground(new Color(255, 255, 255));
						txtCity.setOpaque(false);
						txtCity.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
						txtCity.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						txtCity.setEnabled(false);
						txtCity.setColumns(10);
						txtCity.setBounds(959, 338, 155, 25);
						pnlResidents.add(txtCity);
						
						txtPro = new JTextField();
						txtPro.setForeground(new Color(255, 255, 255));
						txtPro.setOpaque(false);
						txtPro.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
						txtPro.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						txtPro.setEnabled(false);
						txtPro.setColumns(10);
						txtPro.setBounds(793, 338, 155, 25);
						pnlResidents.add(txtPro);
						
						JLabel lblNewLabel_3_2_1_2_1_1 = new JLabel("CITY");
						lblNewLabel_3_2_1_2_1_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_1_1.setBounds(959, 315, 46, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_1_1);
						
						JLabel lblNewLabel_3_2_1_2_1_1_1 = new JLabel("PROVINCE");
						lblNewLabel_3_2_1_2_1_1_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_1_1_1.setBounds(793, 315, 102, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_1_1_1);
						
						JLabel lblNewLabel_3_2_1_2_2 = new JLabel("OCCUPATION");
						lblNewLabel_3_2_1_2_2.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_2.setBounds(459, 383, 130, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_2);
						
						JLabel lblNewLabel_3_2_1_2_2_1 = new JLabel("CIVIL STATUS");
						lblNewLabel_3_2_1_2_2_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_2_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_2_1.setBounds(628, 383, 132, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_2_1);
						
						JLabel lblNewLabel_3_2_1_2_2_1_1 = new JLabel("CATEGORY");
						lblNewLabel_3_2_1_2_2_1_1.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_2_1_1.setBounds(793, 383, 112, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_2_1_1);
						
						JLabel lblNewLabel_3_2_1_2_2_1_2 = new JLabel("PWD SPECIFICATION");
						lblNewLabel_3_2_1_2_2_1_2.setForeground(new Color(255, 255, 255));
						lblNewLabel_3_2_1_2_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
						lblNewLabel_3_2_1_2_2_1_2.setBounds(959, 383, 203, 26);
						pnlResidents.add(lblNewLabel_3_2_1_2_2_1_2);
						
						txtOccu = new JTextField();
						txtOccu.setDisabledTextColor(Color.GRAY);
						
						txtOccu.setForeground(new Color(255, 255, 255));
						txtOccu.setOpaque(false);
						txtOccu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
						txtOccu.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						txtOccu.setEnabled(false);
						txtOccu.setColumns(10);
						txtOccu.setBounds(459, 406, 159, 25);
						pnlResidents.add(txtOccu);
						
						 cbCivil = new JComboBox();
						 cbCivil.setRequestFocusEnabled(false);
						 cbCivil.setOpaque(false);
						 cbCivil.setFocusTraversalKeysEnabled(false);
						 cbCivil.setFocusable(false);
						 cbCivil.setBackground(new Color(74,94,104));
						 cbCivil.setBorder(null);
						 cbCivil.setForeground(new Color(255, 255, 255));
						 cbCivil.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 cbCivil.setEnabled(false);
						 cbCivil.setModel(new DefaultComboBoxModel(new String[] {"", "SINGLE", "MARRIED", "WIDOWED", "DIVORCED", "SEPARATED"}));
						 cbCivil.setBounds(628, 406, 159, 25);
						 pnlResidents.add(cbCivil);
						 
						 cbCategory = new JComboBox();
						 cbCategory.setRequestFocusEnabled(false);
						 cbCategory.setOpaque(false);
						 cbCategory.setFocusTraversalKeysEnabled(false);
						 cbCategory.setFocusable(false);
						 cbCategory.setBackground(new Color(74,94,104));
						 cbCategory.setBorder(null);
						 cbCategory.setForeground(new Color(255, 255, 255));
						 cbCategory.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 cbCategory.setEnabled(false);
						 cbCategory.setModel(new DefaultComboBoxModel(new String[] {"", "", "N/A", "PWD", "SENIOR", "INFANT", "PREGNANT"}));
						 cbCategory.setBounds(793, 406, 159, 25);
						 pnlResidents.add(cbCategory);
						 
						 txtPwd = new JTextField();
						 txtPwd.setForeground(new Color(255, 255, 255));
						 txtPwd.setOpaque(false);
						 txtPwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
						 txtPwd.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						 txtPwd.setEnabled(false);
						 txtPwd.setColumns(10);
						 txtPwd.setBounds(959, 406, 159, 25);
						 pnlResidents.add(txtPwd);
						 
						 JButton btnDeleteRes = new JButton("DELETE");
						 btnDeleteRes.setForeground(new Color(255, 255, 255));
						 btnDeleteRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
						 btnDeleteRes.setFocusable(false);
						 btnDeleteRes.setFocusTraversalKeysEnabled(false);
						 btnDeleteRes.setFocusPainted(false);
						 btnDeleteRes.setBackground(new Color(36,46,50));
						 btnDeleteRes.setBorder(null);
						 btnDeleteRes.setBounds(1024, 470, 109, 46);
						 pnlResidents.add(btnDeleteRes);
						 
						 JButton btnAddRes = new JButton("ADD");
						 btnAddRes.setForeground(new Color(255, 255, 255));
						 btnAddRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
						 btnAddRes.setFocusable(false);
						 btnAddRes.setFocusTraversalKeysEnabled(false);
						 btnAddRes.setFocusPainted(false);
						 btnAddRes.setBackground(new Color(36,46,50));
						 btnAddRes.setBorder(null);
						 
						 		btnAddRes.setBounds(779, 470, 109, 46);
						 		pnlResidents.add(btnAddRes);
						 		
						 		JButton btnUpdateRes = new JButton("UPDATE");
						 		btnUpdateRes.setForeground(new Color(255, 255, 255));
						 		btnUpdateRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
						 		btnUpdateRes.setFocusable(false);
						 		btnUpdateRes.setFocusTraversalKeysEnabled(false);
						 		btnUpdateRes.setFocusPainted(false);
						 		btnUpdateRes.setBackground(new Color(36,46,50));
						 		btnUpdateRes.setBorder(null);
						 		btnUpdateRes.setBounds(905, 470, 109, 46);
						 		pnlResidents.add(btnUpdateRes);
						 		
						 		JButton btnConfirmUpdateRes = new JButton("CONFIRM");
						 		btnConfirmUpdateRes.setForeground(new Color(255, 255, 255));
						 		btnConfirmUpdateRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
						 		btnConfirmUpdateRes.setFocusable(false);
						 		btnConfirmUpdateRes.setFocusTraversalKeysEnabled(false);
						 		btnConfirmUpdateRes.setFocusPainted(false);
						 		btnConfirmUpdateRes.setBackground(new Color(36,46,50));
						 		btnConfirmUpdateRes.setBorder(null);
						 		btnConfirmUpdateRes.setBounds(779, 470, 109, 46);
						 		pnlResidents.add(btnConfirmUpdateRes);
						 		
						 		JButton btnCancelRes = new JButton("CANCEL");
						 		btnCancelRes.setForeground(new Color(255, 255, 255));
						 		btnCancelRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
						 		btnCancelRes.setFocusable(false);
						 		btnCancelRes.setFocusTraversalKeysEnabled(false);
						 		btnCancelRes.setFocusPainted(false);
						 		btnCancelRes.setBackground(new Color(36,46,50));
						 		btnCancelRes.setBorder(null);
						 		
						 				btnCancelRes.setBounds(905, 470, 109, 46);
						 				pnlResidents.add(btnCancelRes);
						 				
						 				JButton btnConfirmAddRes = new JButton("CONFIRM");
						 				btnConfirmAddRes.setForeground(new Color(255, 255, 255));
						 				btnConfirmAddRes.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
						 				btnConfirmAddRes.setFocusable(false);
						 				btnConfirmAddRes.setFocusTraversalKeysEnabled(false);
						 				btnConfirmAddRes.setFocusPainted(false);
						 				btnConfirmAddRes.setBackground(new Color(36,46,50));
						 				btnConfirmAddRes.setBorder(null);
						 				btnConfirmAddRes.setBounds(779, 470, 109, 46);
						 				pnlResidents.add(btnConfirmAddRes);
						 				
						 				JLabel lblNewLabel_14_1 = new JLabel("SEARCH:");
						 				lblNewLabel_14_1.setForeground(Color.WHITE);
						 				lblNewLabel_14_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
						 				lblNewLabel_14_1.setBounds(10, 98, 94, 34);
						 				pnlResidents.add(lblNewLabel_14_1);
						 				
						 				txtSearchResident = new JTextField();
						 				txtSearchResident.addKeyListener(new KeyAdapter() {
						 					@Override
						 					public void keyReleased(KeyEvent e) {
						 						if (txtSearchResident.getText().equals("") || txtSearchResident.getText().isEmpty()
						 								|| txtSearchResident.getText().isBlank()) {
						 							Data.populatetblResident();
						 							generateResidents(Data);
						 						} else {
						 							String search = txtSearchResident.getText();
						 							Data.searchResident(search);
						 							generateResidents(Data);
						 						}
						 					}
						 				});
						 				txtSearchResident.setBounds(114, 98, 335, 34);
						 				pnlResidents.add(txtSearchResident);
						 				txtSearchResident.setColumns(10);
						 				
						 				JPanel pnlDashBoard = new JPanel();
						 				pnlDashBoard.setBackground(new Color(74,94,104));
						 				pnlDashBoard.setBounds(231, 0, 871, 544);
						 				contentPane.add(pnlDashBoard);
						 				pnlDashBoard.setLayout(null);
						 				
						 				JLabel lblNewLabel_7_2 = new JLabel("NUMBER OF MEDICINES");
						 				lblNewLabel_7_2.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_2.setForeground(Color.WHITE);
						 				lblNewLabel_7_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
						 				lblNewLabel_7_2.setBounds(111, 410, 198, 28);
						 				pnlDashBoard.add(lblNewLabel_7_2);
						 				
						 				JLabel lblNewLabel_5 = new JLabel("ADMIN DASHBOARD");
						 				lblNewLabel_5.setBackground(new Color(36,46,50));
						 				lblNewLabel_5.setOpaque(true);
						 				lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 35));
						 				lblNewLabel_5.setForeground(new Color(255, 255, 255));
						 				lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_5.setBounds(141, 85, 589, 62);
						 				pnlDashBoard.add(lblNewLabel_5);
						 				
						 				JLabel lblNewLabel_7 = new JLabel("NUMBER OF USERS");
						 				lblNewLabel_7.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7.setForeground(new Color(255, 255, 255));
						 				lblNewLabel_7.setFont(new Font("Segoe UI Light", Font.PLAIN, 28));
						 				lblNewLabel_7.setBounds(26, 158, 267, 48);
						 				pnlDashBoard.add(lblNewLabel_7);
						 				
						 				JLabel lblNewLabel_8 = new JLabel("");
						 				lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_people_white_24dp.png"));
						 				lblNewLabel_8.setBounds(111, 217, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8);
						 				JLabel lblNewLabel_9 = new JLabel(formattedNum);
						 				lblNewLabel_9.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
						 				lblNewLabel_9.setForeground(new Color(255, 255, 255));
						 				lblNewLabel_9.setBounds(169, 218, 37, 47);
						 				pnlDashBoard.add(lblNewLabel_9);
						 				
						 				JLabel lblNewLabel_6 = new JLabel("");
						 				lblNewLabel_6.setBackground(new Color(36,46,50));
						 				lblNewLabel_6.setOpaque(true);
						 				lblNewLabel_6.setBounds(26, 158, 267, 119);
						 				pnlDashBoard.add(lblNewLabel_6);
						 				
						 				JLabel lblNewLabel_7_1 = new JLabel("NUMBER OF EMPLOYEES");
						 				lblNewLabel_7_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_1.setForeground(Color.WHITE);
						 				lblNewLabel_7_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
						 				lblNewLabel_7_1.setBounds(303, 158, 267, 48);
						 				pnlDashBoard.add(lblNewLabel_7_1);
						 				
						 				JLabel lblNewLabel_8_1 = new JLabel("");
						 				lblNewLabel_8_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_badge_white_24dp.png"));
						 				lblNewLabel_8_1.setBounds(388, 217, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_1);
						 				JLabel lblNewLabel_9_1 = new JLabel(formattedNum2);
						 				lblNewLabel_9_1.setForeground(Color.WHITE);
						 				lblNewLabel_9_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
						 				lblNewLabel_9_1.setBounds(446, 218, 37, 47);
						 				pnlDashBoard.add(lblNewLabel_9_1);
						 				
						 				JLabel lblNewLabel_6_1 = new JLabel("");
						 				lblNewLabel_6_1.setOpaque(true);
						 				lblNewLabel_6_1.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_1.setBounds(303, 158, 267, 119);
						 				pnlDashBoard.add(lblNewLabel_6_1);
						 				
						 				JLabel lblNewLabel_7_1_1 = new JLabel("NUMBER OF ADMINS");
						 				lblNewLabel_7_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_7_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
						 				lblNewLabel_7_1_1.setBounds(580, 158, 267, 48);
						 				pnlDashBoard.add(lblNewLabel_7_1_1);
						 				
						 				JLabel lblNewLabel_8_1_1 = new JLabel("");
						 				lblNewLabel_8_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_admin_panel_settings_white_24dp.png"));
						 				lblNewLabel_8_1_1.setBounds(665, 217, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_1_1);
						 				JLabel lblNewLabel_9_1_1 = new JLabel(formattedNum3);
						 				lblNewLabel_9_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_9_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
						 				lblNewLabel_9_1_1.setBounds(723, 218, 37, 47);
						 				pnlDashBoard.add(lblNewLabel_9_1_1);
						 				
						 				JLabel lblNewLabel_6_1_1 = new JLabel("");
						 				lblNewLabel_6_1_1.setOpaque(true);
						 				lblNewLabel_6_1_1.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_1_1.setBounds(580, 158, 267, 119);
						 				pnlDashBoard.add(lblNewLabel_6_1_1);
						 				
						 				JLabel lblNewLabel_8_2 = new JLabel("");
						 				lblNewLabel_8_2.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_medication_white_24dp.png"));
						 				lblNewLabel_8_2.setBounds(156, 447, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_2);
						 				JLabel lblNewLabel_8_2_1 = new JLabel(numMedFormat);
						 				lblNewLabel_8_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_8_2_1.setForeground(Color.WHITE);
						 				lblNewLabel_8_2_1.setBounds(216, 454, 30, 41);
						 				pnlDashBoard.add(lblNewLabel_8_2_1);
						 				
						 				JLabel lblNewLabel_6_2_1_1 = new JLabel("");
						 				lblNewLabel_6_2_1_1.setOpaque(true);
						 				lblNewLabel_6_2_1_1.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_2_1_1.setBounds(111, 408, 198, 96);
						 				pnlDashBoard.add(lblNewLabel_6_2_1_1);
						 				
						 				JLabel lblNewLabel_8_2_2 = new JLabel("");
						 				lblNewLabel_8_2_2.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_event_busy_white_24dp.png"));
						 				lblNewLabel_8_2_2.setBounds(55, 342, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_2_2);
						 				
						 				lblNumExpMed = new JLabel("06");
						 				lblNumExpMed.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNumExpMed.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNumExpMed.setForeground(Color.WHITE);
						 				lblNumExpMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNumExpMed.setBounds(115, 349, 30, 41);
						 				pnlDashBoard.add(lblNumExpMed);
						 				
						 				JLabel lblNewLabel_7_2_1 = new JLabel("EXPIRED MEDICINES");
						 				lblNewLabel_7_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1.setForeground(Color.WHITE);
						 				lblNewLabel_7_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
						 				lblNewLabel_7_2_1.setBounds(10, 303, 198, 28);
						 				pnlDashBoard.add(lblNewLabel_7_2_1);
						 				
						 				JLabel lblNewLabel_6_2 = new JLabel("");
						 				lblNewLabel_6_2.setOpaque(true);
						 				lblNewLabel_6_2.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_2.setBounds(10, 303, 198, 96);
						 				pnlDashBoard.add(lblNewLabel_6_2);
						 				
						 				JLabel lblNewLabel_7_2_1_1 = new JLabel("OUT OF STOCK MEDICINE");
						 				lblNewLabel_7_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_7_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
						 				lblNewLabel_7_2_1_1.setBounds(218, 303, 198, 28);
						 				pnlDashBoard.add(lblNewLabel_7_2_1_1);
						 				
						 				JLabel lblNewLabel_8_2_2_1 = new JLabel("");
						 				lblNewLabel_8_2_2_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_production_quantity_limits_white_24dp.png"));
						 				lblNewLabel_8_2_2_1.setBounds(268, 342, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_2_2_1);
						 				JLabel lblNewLabel_8_2_1_1_1 = new JLabel(stock);
						 				lblNewLabel_8_2_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_8_2_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_8_2_1_1_1.setBounds(328, 349, 30, 41);
						 				pnlDashBoard.add(lblNewLabel_8_2_1_1_1);
						 				
						 				JLabel lblNewLabel_6_2_1 = new JLabel("");
						 				lblNewLabel_6_2_1.setOpaque(true);
						 				lblNewLabel_6_2_1.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_2_1.setBounds(218, 303, 198, 96);
						 				pnlDashBoard.add(lblNewLabel_6_2_1);
						 				
						 				JLabel lblNewLabel_7_2_1_1_1 = new JLabel("OUT OF STOCK VACCINE");
						 				lblNewLabel_7_2_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_7_2_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
						 				lblNewLabel_7_2_1_1_1.setBounds(663, 301, 198, 28);
						 				pnlDashBoard.add(lblNewLabel_7_2_1_1_1);
						 				
						 				JLabel lblNewLabel_8_2_2_1_1 = new JLabel("");
						 				lblNewLabel_8_2_2_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_cancel_white_24dp.png"));
						 				lblNewLabel_8_2_2_1_1.setBounds(719, 342, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_2_2_1_1);
						 				JLabel lblNewLabel_8_2_1_1_1_1 = new JLabel(stock1);
						 				lblNewLabel_8_2_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1_1_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_8_2_1_1_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_8_2_1_1_1_1.setBounds(779, 349, 30, 41);
						 				pnlDashBoard.add(lblNewLabel_8_2_1_1_1_1);
						 				
						 				JLabel lblNewLabel_7_2_1_2 = new JLabel("EXPIRED VACCINE");
						 				lblNewLabel_7_2_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_2_1_2.setForeground(Color.WHITE);
						 				lblNewLabel_7_2_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
						 				lblNewLabel_7_2_1_2.setBounds(455, 301, 198, 28);
						 				pnlDashBoard.add(lblNewLabel_7_2_1_2);
						 				
						 				JLabel lblNumExpMed_1 = new JLabel("00");
						 				lblNumExpMed_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNumExpMed_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNumExpMed_1.setForeground(Color.WHITE);
						 				lblNumExpMed_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNumExpMed_1.setBounds(560, 347, 30, 41);
						 				pnlDashBoard.add(lblNumExpMed_1);
						 				
						 				JLabel lblNewLabel_8_2_2_2 = new JLabel("");
						 				lblNewLabel_8_2_2_2.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_schedule_white_24dp.png"));
						 				lblNewLabel_8_2_2_2.setBounds(500, 340, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_2_2_2);
						 				
						 				JLabel lblNewLabel_6_2_2 = new JLabel("");
						 				lblNewLabel_6_2_2.setOpaque(true);
						 				lblNewLabel_6_2_2.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_2_2.setBounds(455, 301, 198, 96);
						 				pnlDashBoard.add(lblNewLabel_6_2_2);
						 				
						 				JLabel lblNewLabel_6_2_1_2 = new JLabel("");
						 				lblNewLabel_6_2_1_2.setOpaque(true);
						 				lblNewLabel_6_2_1_2.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_2_1_2.setBounds(663, 301, 198, 96);
						 				pnlDashBoard.add(lblNewLabel_6_2_1_2);
						 				
						 				JLabel lblNewLabel_7_2_2 = new JLabel("NUMBER OF VACCINES");
						 				lblNewLabel_7_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_7_2_2.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_7_2_2.setForeground(Color.WHITE);
						 				lblNewLabel_7_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
						 				lblNewLabel_7_2_2.setBounds(558, 410, 198, 28);
						 				pnlDashBoard.add(lblNewLabel_7_2_2);
						 				
						 				JLabel lblNewLabel_8_2_1_1 = new JLabel("06");
						 				lblNewLabel_8_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						 				lblNewLabel_8_2_1_1.setForeground(Color.WHITE);
						 				lblNewLabel_8_2_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
						 				lblNewLabel_8_2_1_1.setBounds(663, 454, 30, 41);
						 				pnlDashBoard.add(lblNewLabel_8_2_1_1);
						 				
						 				JLabel lblNewLabel_8_2_3 = new JLabel("");
						 				lblNewLabel_8_2_3.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_vaccines_white_24dp.png"));
						 				lblNewLabel_8_2_3.setBounds(603, 447, 48, 48);
						 				pnlDashBoard.add(lblNewLabel_8_2_3);
						 				
						 				JLabel lblNewLabel_6_2_1_1_1 = new JLabel("");
						 				lblNewLabel_6_2_1_1_1.setOpaque(true);
						 				lblNewLabel_6_2_1_1_1.setBackground(new Color(36, 46, 50));
						 				lblNewLabel_6_2_1_1_1.setBounds(558, 408, 198, 96);
						 				pnlDashBoard.add(lblNewLabel_6_2_1_1_1);
						 				
						 				lblDate = new JLabel("DATE");
						 				lblDate.setHorizontalTextPosition(SwingConstants.LEFT);
						 				lblDate.setHorizontalAlignment(SwingConstants.LEFT);
						 				lblDate.setForeground(Color.WHITE);
						 				lblDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
						 				lblDate.setBounds(141, 11, 253, 62);
						 				pnlDashBoard.add(lblDate);
						 				
						 				lblTime = new JLabel("06:09:38 am");
						 				lblTime.setHorizontalTextPosition(SwingConstants.RIGHT);
						 				lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
						 				lblTime.setForeground(Color.WHITE);
						 				lblTime.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
						 				lblTime.setBounds(504, 11, 226, 62);
						 				pnlDashBoard.add(lblTime);
						 				
						 				btnAddRes.addActionListener(new ActionListener() {
						 					public void actionPerformed(ActionEvent e) {
						 						imgHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
						 						tblResident.setEnabled(false);
						 						txtFn.setEnabled(true);
						 						txtMn.setEnabled(true);
						 						txtLn.setEnabled(true);
						 						cbResGen.setEnabled(true);
						 						dcBdateRes.setEnabled(true);
						 						cbPosRes.setEnabled(true);
						 						txtSt.setEnabled(true);
						 						txtBgy.setEnabled(true);
						 						txtCity.setEnabled(true);
						 						txtPro.setEnabled(true);
						 						txtOccu.setEnabled(true);
						 						cbCivil.setEnabled(true);
						 						cbCategory.setEnabled(true);
						 						txtPwd.setEnabled(true);
						 						btnUpload.setEnabled(true);
						 						tblResident.setEnabled(false);
						 						btnDeleteRes.setVisible(false);
						 						btnUpdateRes.setVisible(false);
						 						btnAddRes.setVisible(false);
						 						btnConfirmAddRes.setVisible(true);
						 						btnCancelRes.setVisible(true);
						 						btnConfirmUpdateRes.setVisible(false);
						 						 txtFn.setText("");
						 						 txtMn.setText("");
						 						 txtLn.setText("");
						 						cbResGen.setSelectedItem("");
						 						dcBdateRes.setDate(null);
						 						cbPosRes.setSelectedItem("");
						 						txtSt.setText("");
						 						txtBgy.setText("");
						 						txtCity.setText("");
						 						txtPro.setText("");
						 						txtOccu.setText("");
						 						cbCivil.setSelectedItem("");;
						 						cbCategory.setSelectedItem("");
						 						txtPwd.setText("");
						 					}
						 				});
						 				
						 				btnUpdateRes.addActionListener(new ActionListener() {
						 					public void actionPerformed(ActionEvent e) {

						 						if(txtFn.getText().isEmpty() || txtMn.getText().isEmpty()
						 								|| txtLn.getText().isEmpty() || cbResGen.getSelectedItem().equals("")||
						 								dcBdateRes.getDate().equals(null)|| cbPosRes.getSelectedItem().equals("")||
						 								txtSt.getText().isEmpty()||txtCity.getText().isEmpty()||
						 								txtPro.getText().isEmpty()||txtBgy.getText().isEmpty()||txtOccu.getText().isEmpty()||
						 								cbCivil.getSelectedItem().equals("")||cbCategory.getSelectedItem().equals("")||
						 								txtPwd.getText().isEmpty()) {
						 							JOptionPane.showMessageDialog(null, "Please select Resident to Update.","No resident selected", JOptionPane.WARNING_MESSAGE);
						 							
						 						}else {
						 							tblResident.setEnabled(false);
						 							txtFn.setEnabled(true);
						 							txtMn.setEnabled(true);
						 							txtLn.setEnabled(true);
						 							cbResGen.setEnabled(true);
						 							dcBdateRes.setEnabled(true);
						 							cbPosRes.setEnabled(true);
						 							txtSt.setEnabled(true);
						 							txtBgy.setEnabled(true);
						 							txtCity.setEnabled(true);
						 							txtPro.setEnabled(true);
						 							txtOccu.setEnabled(true);
						 							cbCivil.setEnabled(true);
						 							cbCategory.setEnabled(true);
						 							txtPwd.setEnabled(true);
						 							btnUpload.setEnabled(true);
						 							tblResident.setEnabled(false);
						 							btnDeleteRes.setVisible(false);
						 							btnUpdateRes.setVisible(false);
						 							btnAddRes.setVisible(false);
						 							btnConfirmAddRes.setVisible(false);
						 							btnCancelRes.setVisible(true);
						 							btnConfirmUpdateRes.setVisible(true);
						 						}
						 					}
						 				});
						 				btnDeleteRes.addActionListener(new ActionListener() {

						 					@Override
						 					public void actionPerformed(ActionEvent e) {
						 						// TODO Auto-generated method stub
						 						if(txtFn.getText().isEmpty() || txtMn.getText().isEmpty()
						 								|| txtLn.getText().isEmpty() || cbResGen.getSelectedItem().equals("")||
						 								dcBdateRes.getDate().equals(null)|| cbPosRes.getSelectedItem().equals("")||
						 								txtSt.getText().isEmpty()||txtCity.getText().isEmpty()||
						 								txtPro.getText().isEmpty()||txtBgy.getText().isEmpty()||txtOccu.getText().isEmpty()||
						 								cbCivil.getSelectedItem().equals("")||cbCategory.getSelectedItem().equals("")||
						 								txtPwd.getText().isEmpty()) {
						 							JOptionPane.showMessageDialog(null, "Please select Resident to Update.","No resident selected", JOptionPane.WARNING_MESSAGE);
						 							
						 						}else {
						 							int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this resident information?","Delete Resident Information",JOptionPane.YES_NO_OPTION);
						 							if(sel==0) {
						 								Data.deleteRes(idholder);
						 								Data.populatetblResident();
						 								generateResidents(Data);
						 							}
						 						}
						 					}
						 					
						 				});
						 				btnConfirmAddRes.addActionListener(new ActionListener() {
						 					public void actionPerformed(ActionEvent e) {
						 						if(txtFn.getText().isEmpty() || txtMn.getText().isEmpty()
						 								|| txtLn.getText().isEmpty() || cbResGen.getSelectedItem().equals("")||
						 								dcBdateRes.getDate().equals(null)|| cbPosRes.getSelectedItem().equals("")||
						 								txtSt.getText().isEmpty()||txtCity.getText().isEmpty()||
						 								txtPro.getText().isEmpty()||txtBgy.getText().isEmpty()||txtOccu.getText().isEmpty()||
						 								cbCivil.getSelectedItem().equals("")||cbCategory.getSelectedItem().equals("")||
						 								txtPwd.getText().isEmpty()) {
						 							JOptionPane.showMessageDialog(null, "Please fill up empty fields.","Empty fileds detected", JOptionPane.WARNING_MESSAGE);
						 							
						 						}else {
						 							int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to update resident information?","Update Information",JOptionPane.YES_NO_OPTION);
						 							if(sel==0) {
						 								String fname = txtFn.getText();
						 								String mname = txtMn.getText();
						 								String lname = txtLn.getText();
						 								String street = txtSt.getText();
						 								String bgy =txtBgy.getText() ;
						 								String city = txtCity.getText();
						 								String province = txtPro.getText();
						 								String category = cbCategory.getSelectedItem().toString();
						 								String pwdSpecification = txtPwd.getText();
						 								String occu = txtOccu.getText();
						 								String gender = cbResGen.getSelectedItem().toString();
						 								String civilS = cbCivil.getSelectedItem().toString();
						 								String pos =  cbPosRes.getSelectedItem().toString();
						 								Date bday = dcBdateRes.getDate();
						 								Data.registerResident(filename,fname,
						 										mname, lname, street, bgy, 
						 										city, province, gender, bday,
						 										civilS, category,pwdSpecification, occu, pos);
						 								Data.populatetblResident();
						 								generateResidents(Data);
						 								 txtFn.setText("");
						 								 txtMn.setText("");
						 								 txtLn.setText("");
						 								cbResGen.setSelectedItem("");
						 								dcBdateRes.setDate(null);
						 								cbPosRes.setSelectedItem("");
						 								txtSt.setText("");
						 								txtBgy.setText("");
						 								txtCity.setText("");
						 								txtPro.setText("");
						 								txtOccu.setText("");
						 								cbCivil.setSelectedItem("");;
						 								cbCategory.setSelectedItem("");
						 								txtPwd.setText("");
						 								tblResident.setEnabled(true);
						 								txtFn.setEnabled(false);
						 								txtMn.setEnabled(false);
						 								txtLn.setEnabled(false);
						 								cbResGen.setEnabled(false);
						 								dcBdateRes.setEnabled(false);
						 								cbPosRes.setEnabled(false);
						 								txtSt.setEnabled(false);
						 								txtBgy.setEnabled(false);
						 								txtCity.setEnabled(false);
						 								txtPro.setEnabled(false);
						 								txtOccu.setEnabled(false);
						 								cbCivil.setEnabled(false);
						 								cbCategory.setEnabled(false);
						 								btnUpload.setEnabled(false);
						 								txtPwd.setEnabled(false);
						 								btnDeleteRes.setVisible(true);
						 								btnUpdateRes.setVisible(true);
						 								btnAddRes.setVisible(true);
						 								btnConfirmAddRes.setVisible(false);
						 								btnCancelRes.setVisible(false);
						 								btnConfirmUpdateRes.setVisible(false);
						 							}
						 						}
						 					}
						 				});
						 				btnConfirmUpdateRes.addActionListener(new ActionListener() {
						 					public void actionPerformed(ActionEvent e) {
						 						if(txtFn.getText().isEmpty() || txtMn.getText().isEmpty()
						 								|| txtLn.getText().isEmpty() || cbResGen.getSelectedItem().equals("")||
						 								dcBdateRes.getDate().equals(null)|| cbPosRes.getSelectedItem().equals("")||
						 								txtSt.getText().isEmpty()||txtCity.getText().isEmpty()||
						 								txtPro.getText().isEmpty()||txtBgy.getText().isEmpty()||txtOccu.getText().isEmpty()||
						 								cbCivil.getSelectedItem().equals("")||cbCategory.getSelectedItem().equals("")||
						 								txtPwd.getText().isEmpty()) {
						 							JOptionPane.showMessageDialog(null, "Please fill up empty fields.","Empty fileds detected", JOptionPane.WARNING_MESSAGE);
						 							
						 						}else {
						 							int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to update resident information?","Update Information",JOptionPane.YES_NO_OPTION);
						 							if(sel==0) {
						 								Data.updateResident(idholder, txtFn.getText(), txtMn.getText(),txtLn.getText(),cbResGen.getSelectedItem().toString(),dcBdateRes.getDate(),cbPosRes.getSelectedItem().toString(),
						 										txtSt.getText(),txtBgy.getText(),txtCity.getText(),txtPro.getText(),txtOccu.getText(),cbCivil.getSelectedItem().toString(),
						 										cbCategory.getSelectedItem().toString(),txtPwd.getText(),filename);
						 								Data.populatetblResident();
						 								generateResidents(Data);
						 								JOptionPane.showMessageDialog(null, "Information updated successfully","Update Residents",JOptionPane.INFORMATION_MESSAGE);
						 								 imgHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
						 								 txtFn.setText("");
						 								 txtMn.setText("");
						 								 txtLn.setText("");
						 								cbResGen.setSelectedItem("");
						 								dcBdateRes.setDate(null);
						 								cbPosRes.setSelectedItem("");
						 								txtSt.setText("");
						 								txtBgy.setText("");
						 								txtCity.setText("");
						 								txtPro.setText("");
						 								txtOccu.setText("");
						 								cbCivil.setSelectedItem("");;
						 								cbCategory.setSelectedItem("");
						 								txtPwd.setText("");
						 								tblResident.setEnabled(true);
						 								txtFn.setEnabled(false);
						 								txtMn.setEnabled(false);
						 								txtLn.setEnabled(false);
						 								cbResGen.setEnabled(false);
						 								dcBdateRes.setEnabled(false);
						 								cbPosRes.setEnabled(false);
						 								txtSt.setEnabled(false);
						 								txtBgy.setEnabled(false);
						 								txtCity.setEnabled(false);
						 								txtPro.setEnabled(false);
						 								txtOccu.setEnabled(false);
						 								cbCivil.setEnabled(false);
						 								cbCategory.setEnabled(false);
						 								txtPwd.setEnabled(false);
						 								btnUpload.setEnabled(false);
						 								btnDeleteRes.setVisible(true);
						 								btnUpdateRes.setVisible(true);
						 								btnAddRes.setVisible(true);
						 								btnConfirmAddRes.setVisible(false);
						 								btnCancelRes.setVisible(false);
						 								btnConfirmUpdateRes.setVisible(false);
						 							}
						 						}
						 					}
						 				});
						 				
						 				btnCancelRes.addActionListener(new ActionListener() {
						 					public void actionPerformed(ActionEvent e) {
						 						int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?","Residents information",JOptionPane.YES_NO_OPTION);
						 						if(sel==0) {
						 							
						 							 imgHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
						 							 txtFn.setText("");
						 							 txtMn.setText("");
						 							 txtLn.setText("");
						 							cbResGen.setSelectedItem("");
						 							dcBdateRes.setDate(null);
						 							cbPosRes.setSelectedItem("");
						 							txtSt.setText("");
						 							txtBgy.setText("");
						 							txtCity.setText("");
						 							txtPro.setText("");
						 							txtOccu.setText("");
						 							cbCivil.setSelectedItem("");;
						 							cbCategory.setSelectedItem("");
						 							txtPwd.setText("");
						 							tblResident.setEnabled(true);
						 							txtFn.setEnabled(false);
						 							txtMn.setEnabled(false);
						 							txtLn.setEnabled(false);
						 							cbResGen.setEnabled(false);
						 							dcBdateRes.setEnabled(false);
						 							cbPosRes.setEnabled(false);
						 							txtSt.setEnabled(false);
						 							txtBgy.setEnabled(false);
						 							txtCity.setEnabled(false);
						 							txtPro.setEnabled(false);
						 							txtOccu.setEnabled(false);
						 							cbCivil.setEnabled(false);
						 							cbCategory.setEnabled(false);
						 							txtPwd.setEnabled(false);
						 							btnDeleteRes.setVisible(true);
						 							btnUpdateRes.setVisible(true);
						 							btnAddRes.setVisible(true);
						 							btnConfirmAddRes.setVisible(false);
						 							btnCancelRes.setVisible(false);
						 							btnConfirmUpdateRes.setVisible(false);
						 							btnUpload.setEnabled(false);
						 						}
						 					}
						 				});
						 										 		 										 								
						 										 		 										 								  btnAddUsers.addActionListener(new ActionListener() { 
						 										 		 										 									  public void actionPerformed(ActionEvent e) {
						 										 		 										 								  
						 										 		 										 								  btnAddUsers.setVisible(false); btnDelete.setVisible(false);
						 										 		 										 								  btnUpdate.setVisible(false); btnConfirm.setVisible(true);
						 										 		 										 								  btnCancelUser.setVisible(true); 
						 										 		 										 								  
						 										 		 										 								  txtFname.setEnabled(true); 
						 										 		 										 								  txtMname.setEnabled(true);
						 										 		 										 								  txtLname.setEnabled(true); 
						 										 		 										 								  cbPosition.setEnabled(true);
						 										 		 										 								  txtCPw.setEnabled(true); 
						 										 		 										 								  txtPw.setEnabled(true);
						 										 		 										 								  txtUsername.setEnabled(true);
						 										 		 										 								 cbStatus.setSelectedItem("ACTIVE");
      
      	txtFname.setText("");
      	txtMname.setText("");
      	txtLname.setText("");
      	cbPosition.setSelectedItem("");
      	txtCPw.setText("");
      	txtPw.setText("");
      	txtUsername.setText("");
						 										 		 										 								 
						 										 		 										 								  txtMname.setEditable(true); txtLname.setEditable(true);
						 										 		 										 								  
						 										 		 										 								  txtCPw.setEditable(true); txtPw.setEditable(true);
						 										 		 										 								  txtUsername.setEditable(true);
						 										 		 										 								  
						 										 		 										 								  
						 										 		 										 								  } });
						 										 		 										 								  
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int sel = JOptionPane.showConfirmDialog(null,"Confirm Add User?","Add User", JOptionPane.YES_NO_OPTION);
				 idholder = Data.getMaxIdUsers();
				String fname = txtFname.getText();
				String lname = txtLname.getText();
				String mname = txtMname.getText();
				String pos =  (String) cbPosition.getSelectedItem();
				String user = txtUsername.getText();
				String pass = txtPw.getText();
				String status = cbStatus.getSelectedItem().toString();
				 if(sel==0) {
					 if(txtFname.getText().isEmpty()
                   		 ||txtMname.getText().isEmpty()
                   		 ||txtLname.getText().isEmpty()
                   		 ||cbPosition.getSelectedItem().equals("")
                   		 ||txtPw.getText().isEmpty()
                   		 ||txtUsername.getText().isEmpty()
                   		 ||txtCPw.getText().isEmpty()
                   		 ||cbStatus.getSelectedItem().equals("")){
                        JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Add Users",JOptionPane.WARNING_MESSAGE);

                     }else {
                   	  
                    	 if(Data.checkDupUsername(user)) {
                   		 JOptionPane.showMessageDialog(null,"The username "+txtUsername.getText()+" has already been taken.","Add Users",JOptionPane.WARNING_MESSAGE);
                   	 }else if(!txtCPw.getText().equals(pass)){
                   		 JOptionPane.showMessageDialog(null,"Password not match","Password Mismatch",JOptionPane.WARNING_MESSAGE);
                   		 
                   	 }else {
                   		 JOptionPane.showMessageDialog(null,"User successfully added!","Success",JOptionPane.INFORMATION_MESSAGE);
	                        	Data.addUsers(idholder, lname, fname, mname, pos, user, pass, status);
	                        	refreshUser();
	                        	cbStatus.setSelectedItem("");
	                        	txtFname.setText("");
	                        	txtMname.setText("");
	                        	txtLname.setText("");
	                        	cbPosition.setSelectedItem("");
	                        	txtCPw.setText("");
	                        	txtPw.setText("");
	                        	txtUsername.setText("");
	                			btnAddUsers.setVisible(true);
	                			btnDelete.setVisible(true);
	                			btnUpdate.setVisible(true);
	                			btnConfirm.setVisible(false);
	                			btnCancelUser.setVisible(false);
                   	 }

                     }
	              
				 }
			}
		});
		
		btnCancelUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddUsers.setVisible(true);
				btnDelete.setVisible(true);
				btnUpdate.setVisible(true);
				btnConfirm.setVisible(false);
				btnCancelUser.setVisible(false);
				cbStatus.setEnabled(false);
				
				txtFname.setEnabled(false);
				txtMname.setEnabled(false);
				txtLname.setEnabled(false);
				cbPosition.setEnabled(false);
				txtCPw.setEnabled(false);
				txtPw.setEnabled(false);
				txtUsername.setEnabled(false);
				
	
				txtFname.setEditable(false);
				txtMname.setEditable(false);
				txtLname.setEditable(false);
				txtCPw.setEditable(false);
				txtPw.setEditable(false);
				txtUsername.setEditable(false);
			}
			
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(txtFname.getText().isEmpty()
                   		 ||txtMname.getText().isEmpty()
                   		 ||txtLname.getText().isEmpty()
                   		 ||cbPosition.getSelectedItem().equals("")
                   		 ||txtPw.getText().isEmpty()
                   		 ||txtUsername.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please select user to update.","UPDATE USER",JOptionPane.WARNING_MESSAGE);

                     }else {
                    	 
                    	btnAddUsers.setVisible(false);
 						btnDelete.setVisible(false);
 						btnUpdate.setVisible(false);
 						btnConfirmUpdate.setVisible(true);
 						btnCancelUser.setVisible(true);
 						cbStatus.setEnabled(true);
 						txtFname.setEnabled(true);
 						txtMname.setEnabled(true);
 						txtLname.setEnabled(true);
 						cbPosition.setEnabled(true);
 						txtCPw.setEnabled(true);
 						txtPw.setEnabled(true);;
 						txtUsername.setEnabled(true);
 					
 						txtFname.setEditable(true);
 						txtMname.setEditable(true);
 						txtLname.setEditable(true);

 						txtCPw.setEditable(true);
 						txtPw.setEditable(true);
 						
 						txtUsername.setEditable(true);		
                     }
						
			}
		});
		
		btnConfirmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = JOptionPane.showConfirmDialog(null,"Confirm Update User?","Update User", JOptionPane.YES_NO_OPTION);
				//int id = Integer.parseInt(txtIDUsers.getText());
				String fname = txtFname.getText();
				String lname = txtLname.getText();
				String mname = txtMname.getText();
				String pos =  (String) cbPosition.getSelectedItem();
				String user = txtUsername.getText();
				String pass = txtPw.getText();
				String status = cbStatus.getSelectedItem().toString();
				 if(sel==0) {
					 if(	txtFname.getText().isEmpty()
                   		 ||txtMname.getText().isEmpty()
                   		 ||txtLname.getText().isEmpty()
                   		 ||cbPosition.getSelectedItem().equals("")
                   		 ||txtPw.getText().isEmpty()
                   		 ||txtUsername.getText().isEmpty()
                   		 ||txtCPw.getText().isEmpty()
						||cbStatus.getSelectedItem().equals("")){
                        JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Update User",JOptionPane.WARNING_MESSAGE);

                     }else {
                    	 if(Data.checkIfSameUsername(user, idholder)) {
                    		 if(!txtCPw.getText().equals(pass)){
                           		 JOptionPane.showMessageDialog(null,"Password not match","Password Mismatch",JOptionPane.WARNING_MESSAGE);
                           	}else {
                           			JOptionPane.showMessageDialog(null,"User updated successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
        	                        	Data.updateUser(idholder, lname, fname, mname, pos, user, pass,status);
        	                        	refreshUser();
        	                        	cbStatus.setEnabled(false);
        	                        	cbStatus.setSelectedItem("");
        	                        	txtFname.setText("");
        	                        	txtMname.setText("");
        	                        	txtLname.setText("");
        	                        	cbPosition.setSelectedItem("");
        	                        	txtCPw.setText("");
        	                        	txtPw.setText("");
        	                        	txtUsername.setText("");
        	    						btnAddUsers.setVisible(true);
        	    						btnDelete.setVisible(true);
        	    						btnUpdate.setVisible(true);
        	    						btnConfirmUpdate.setVisible(false);
        	    						btnCancelUser.setVisible(false);
        	    						txtFname.setEnabled(false);
        	     						txtMname.setEnabled(false);
        	     						txtLname.setEnabled(false);
        	     						cbPosition.setEnabled(false);
        	     						txtCPw.setEnabled(false);
        	     						txtPw.setEnabled(false);
        	     						txtUsername.setEnabled(false);

        	     						
                           		 }
                    	 }
                    	 else if(Data.checkDupUsername(user)) {
                    		 JOptionPane.showMessageDialog(null,"The username "+txtUsername.getText()+" has already been taken.","Add Users",JOptionPane.WARNING_MESSAGE);
                    	 }else if(!txtCPw.getText().equals(pass)){
                   		 JOptionPane.showMessageDialog(null,"Password not match","Password Mismatch",JOptionPane.WARNING_MESSAGE);
                   		 }else {
                   		 JOptionPane.showMessageDialog(null,"User updated successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
	                        	Data.updateUser(idholder, lname, fname, mname, pos, user, pass, status);
	                        	refreshUser();
	                       
	                        	txtFname.setText("");
	                        	txtMname.setText("");
	                        	txtLname.setText("");
	                        	cbPosition.setSelectedItem("");
	                        	txtCPw.setText("");
	                        	txtPw.setText("");
	                        	txtUsername.setText("");
	    						btnAddUsers.setVisible(true);
	    						btnDelete.setVisible(true);
	    						btnUpdate.setVisible(true);
	    						btnConfirmUpdate.setVisible(false);
	    						btnCancelUser.setVisible(false);
	    						txtFname.setEnabled(false);
	     						txtMname.setEnabled(false);
	     						txtLname.setEnabled(false);
	     						cbPosition.setEnabled(false);
	     						txtCPw.setEnabled(false);
	     						txtPw.setEnabled(false);
	     						txtUsername.setEnabled(false);
	     						
	     						
	     						txtFname.setEditable(false);
	     						txtMname.setEditable(false);
	     						txtLname.setEditable(false);

	     						txtCPw.setEditable(false);
	     						txtPw.setEditable(false);
	     						txtUsername.setEditable(false);	

                   		 }

                     }
	              
				 }
					
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(txtFname.getText().isEmpty()
                   		 ||txtMname.getText().isEmpty()
                   		 ||txtLname.getText().isEmpty()
                   		 ||cbPosition.getSelectedItem().equals("")
                   		 ||txtPw.getText().isEmpty()
                   		 ||txtUsername.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please select user to delete.","Delete User",JOptionPane.WARNING_MESSAGE);

                     }else {
                    	 int sel = JOptionPane.showConfirmDialog(null,"Confirm Delete User?","Delete User", JOptionPane.YES_NO_OPTION);
                    	 if(sel==0) {
                    		
             				Data.deleteUser(idholder);
             				refreshUser();
             				cbStatus.setSelectedItem("");
                        	txtFname.setText("");
                        	txtMname.setText("");
                        	txtLname.setText("");
                        	cbPosition.setSelectedItem("");
                        	txtCPw.setText("");
                        	txtPw.setText("");
                        	txtUsername.setText("");
                    	 }else {
                    		 JOptionPane.showMessageDialog(null,"Please select user to delete.","Delete User",JOptionPane.INFORMATION_MESSAGE);
                    	 }
                     }
			}
		});
						 										
						 										btnAddVac.addActionListener(new ActionListener() {
						 											public void actionPerformed(ActionEvent e) {
						 												btnAddVac.setVisible(false);
						 												btnUpdateVac.setVisible(false);
						 												btnDeleteVac.setVisible(false);
						 												btnCfAddVac.setVisible(true);
						 												btnCfUpVac.setVisible(false);
						 												btnCancelVac.setVisible(true);
						 												txtVacName.setEnabled(true);
						 												txtVacQty.setEnabled(true);
						 												dcVacManu.setEnabled(true);
						 												dcVacExpi.setEnabled(true);
						 												txtVacName.setText("");
						 												txtVacQty.setText("");
						 												dcVacManu.setDate(null);
						 												dcVacExpi.setDate(null);
						 												
						 											}
						 										});
						 										
						 										btnCfAddVac.addActionListener(new ActionListener() {
						 											public void actionPerformed(ActionEvent e) {
						 												
						 												
						 												if(txtVacName.getText().isEmpty()||
						 													txtVacQty.getText().isEmpty()||
						 													dcVacManu.getDate().equals(null)||
						 													dcVacExpi.getDate().equals(null)) {
						 													JOptionPane.showMessageDialog(null,"Empty fields detected.","Empty spaces detected",JOptionPane.WARNING_MESSAGE);
						 													
						 												}else if(Integer.parseInt(txtVacQty.getText())<=0 ){
						 													 JOptionPane.showMessageDialog(null, "Cannot input zero or negative value.", "Invalid Values",JOptionPane.WARNING_MESSAGE);
						 												}else if(dcVacManu.getDate().after(dcVacExpi.getDate())) {
						 													 JOptionPane.showMessageDialog(null, "Date values are invalid", "Invalid Values",JOptionPane.WARNING_MESSAGE);
						 												}else {
						 													String vacname = txtVacName.getText();
						 													int qty = Integer.parseInt(txtVacQty.getText());
						 													String newManuDate = simpleDateFormat.format(dcVacManu.getDate());
						 													String newExpidate = simpleDateFormat.format(dcVacExpi.getDate());
						 													Data.addVaccine(vacname,qty,newManuDate,newExpidate);
						 													JOptionPane.showMessageDialog(null, "Vaccine added successfully!");
						 													generateTblVaccines(Data);
						 													btnAddVac.setVisible(true);
						 													btnUpdateVac.setVisible(true);
						 													btnDeleteVac.setVisible(true);
						 													btnCfAddVac.setVisible(false);
						 													btnCfUpVac.setVisible(false);
						 													btnCancelVac.setVisible(false);
						 													txtVacName.setEnabled(false);
						 													txtVacQty.setEnabled(false);
						 													dcVacManu.setEnabled(false);
						 													dcVacExpi.setEnabled(false);
						 													txtVacName.setText("");
						 													txtVacQty.setText("");
						 													dcVacManu.setDate(null);
						 													dcVacExpi.setDate(null);
						 													
						 												}
						 											}
						 										});
						 										btnUpdateVac.addActionListener(new ActionListener() {
						 											public void actionPerformed(ActionEvent e) {
						 												if(txtVacName.getText().isEmpty()) {
						 													JOptionPane.showMessageDialog(null,"Please select an item to update.","Update Vaccines",JOptionPane.WARNING_MESSAGE);
						 												}else {
						 													btnAddVac.setVisible(false);
						 													btnUpdateVac.setVisible(false);
						 													btnDeleteVac.setVisible(false);
						 													btnCfAddVac.setVisible(false);
						 													btnCfUpVac.setVisible(true);
						 													btnCancelVac.setVisible(true);
						 													txtVacName.setEnabled(true);
						 													txtVacQty.setEnabled(true);
						 													dcVacManu.setEnabled(true);
						 													dcVacExpi.setEnabled(true);
						 												}
						 											}
						 										});
						 										
						 										btnCfUpVac.addActionListener(new ActionListener() {
						 											public void actionPerformed(ActionEvent e) {
						 												if(txtVacName.getText().isEmpty()||
						 														txtVacQty.getText().isEmpty()||
						 														dcVacManu.getDate().equals(null)||
						 														dcVacExpi.getDate().equals(null)) {
						 														JOptionPane.showMessageDialog(null,"Empty fields detected.","Empty spaces detected",JOptionPane.WARNING_MESSAGE);
						 														
						 													}else if(Integer.parseInt(txtVacQty.getText())<=0 ){
						 														 JOptionPane.showMessageDialog(null, "Cannot input zero or negative value.", "Invalid Values",JOptionPane.WARNING_MESSAGE);
						 													}else if(dcVacManu.getDate().after(dcVacExpi.getDate())) {
						 														 JOptionPane.showMessageDialog(null, "Date values are invalid", "Invalid Values",JOptionPane.WARNING_MESSAGE);
						 													}else {
						 														String newManuDate = simpleDateFormat.format(dcVacManu.getDate());
						 														String newExpidate = simpleDateFormat.format(dcVacExpi.getDate());
						 														Data.updateVaccine(idholder, txtVacName.getText(), Integer.parseInt(txtVacQty.getText()), newManuDate, newExpidate);
						 														JOptionPane.showMessageDialog(null, "Vaccine updated successfully!");
						 														generateTblVaccines(Data);
						 														btnAddVac.setVisible(true);
						 														btnUpdateVac.setVisible(true);
						 														btnDeleteVac.setVisible(true);
						 														btnCfAddVac.setVisible(false);
						 														btnCfUpVac.setVisible(false);
						 														btnCancelVac.setVisible(false);
						 														txtVacName.setEnabled(false);
						 														txtVacQty.setEnabled(false);
						 														dcVacManu.setEnabled(false);
						 														dcVacExpi.setEnabled(false);
						 														txtVacName.setText("");
						 														txtVacQty.setText("");
						 														dcVacManu.setDate(null);
						 														dcVacExpi.setDate(null);
						 													}
						 											}
						 										});
						 										btnDeleteVac.addActionListener(new ActionListener() {
						 											public void actionPerformed(ActionEvent e) {
						 												if(txtVacName.getText().isEmpty()||
						 														txtVacQty.getText().isEmpty()||
						 														dcVacManu.getDate().equals(null)||
						 														dcVacExpi.getDate().equals(null)) {
						 														JOptionPane.showMessageDialog(null,"Please select a vaccine to delete.","Delete Vaccines",JOptionPane.WARNING_MESSAGE);
						 														
						 												}else {
						 														int sel = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected vaccine?","Vaccine delete", JOptionPane.YES_NO_OPTION);
						 														if(sel==0) {
						 															
						 															JOptionPane.showMessageDialog(null, "Vaccine deleted successfully");
						 														
						 															Data.deleteVaccine(idholder);
						 															generateTblVaccines(Data);
						 															txtVacName.setText("");
						 															txtVacQty.setText("");
						 															dcVacManu.setDate(null);
						 															dcVacExpi.setDate(null);
						 														}
						 												}
						 											}
						 										});
	
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRecord.setVisible(false);
				pnlDashBoard.setVisible(false);
				pnlMedicines.setVisible(false);
				pnlUser.setVisible(true);

				pnlResidents.setVisible(false);;
				setBounds(100, 100, 1102, 544);
				//panel_2.setBounds(0, 0, 1096, 39);
				pnlVaccine.setVisible(false);
				
					btnAddUser.setBackground(new Color(25, 31, 34));
					btnAddUser.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
					btnMedicine.setBackground(new Color(36, 46, 50));
					btnResidents.setBackground(new Color(36, 46, 50));
					btnVaccine.setBackground(new Color(36, 46, 50));
					btnRecords.setBackground(new Color(36, 46, 50));
					btnLogout.setBackground(new Color(36, 46, 50));
					btnRecords.setBorder(null);
					btnVaccine.setBorder(null);
					btnResidents.setBorder(null);
					btnMedicine.setBorder(null);
					btnVaccine.setBorder(null);
					btnLogout.setBorder(null);
				
			}
		});
		btnMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateMeds(Data);
				pnlRecord.setVisible(false);
		
				pnlUser.setVisible(false);
				pnlMedicines.setVisible(true);
				pnlResidents.setVisible(false);
				pnlVaccine.setVisible(false);
				pnlDashBoard.setVisible(false);
				setBounds(100, 100, 1102, 544);
				//panel_2.setBounds(0, 0, 1096, 39);

				btnMedicine.setBackground(new Color(25, 31, 34));
				btnMedicine.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
				
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnResidents.setBackground(new Color(36, 46, 50));
				btnVaccine.setBackground(new Color(36, 46, 50));
				btnRecords.setBackground(new Color(36, 46, 50));
				btnLogout.setBackground(new Color(36, 46, 50));
				btnRecords.setBorder(null);
				btnVaccine.setBorder(null);
				btnResidents.setBorder(null);
				btnAddUser.setBorder(null);
				btnVaccine.setBorder(null);
				btnLogout.setBorder(null);
			}
		});
		
		btnResidents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRecord.setVisible(false);
				pnlUser.setVisible(false);
				pnlVaccine.setVisible(false);
				pnlMedicines.setVisible(false);
				pnlResidents.setVisible(true);
				pnlDashBoard.setVisible(false);
				setBounds(100, 100, 1406, 544);
			//	panel_2.setBounds(0, 0, 1403, 39);
				btnResidents.setBackground(new Color(25, 31, 34));
				btnResidents.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
				
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnMedicine.setBackground(new Color(36, 46, 50));
				btnVaccine.setBackground(new Color(36, 46, 50));
				btnRecords.setBackground(new Color(36, 46, 50));
				btnLogout.setBackground(new Color(36, 46, 50));
				btnRecords.setBorder(null);
				btnVaccine.setBorder(null);
				btnMedicine.setBorder(null);
				btnAddUser.setBorder(null);
				btnVaccine.setBorder(null);
				btnLogout.setBorder(null);
			}
		});
		btnVaccine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRecord.setVisible(false);
				pnlUser.setVisible(false);

				pnlDashBoard.setVisible(false);

				pnlMedicines.setVisible(false);
				pnlResidents.setVisible(false);
				pnlVaccine.setVisible(true);
				setBounds(100, 100, 1102, 544);
				
				btnVaccine.setBackground(new Color(25, 31, 34));
				btnVaccine.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
				
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnMedicine.setBackground(new Color(36, 46, 50));
				btnResidents.setBackground(new Color(36, 46, 50));
				btnRecords.setBackground(new Color(36, 46, 50));
				btnLogout.setBackground(new Color(36, 46, 50));
				btnRecords.setBorder(null);
				btnResidents.setBorder(null);
				btnMedicine.setBorder(null);
				btnAddUser.setBorder(null);

				btnLogout.setBorder(null);
			}
		});
		generateTblVaccines(Data);
		Data.populatetblResident();
		generateResidents(Data);
		
		btnRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRecord.setVisible(true);
				pnlDashBoard.setVisible(false);
				pnlMedicines.setVisible(false);
				pnlUser.setVisible(false);
			
				pnlResidents.setVisible(false);
				setBounds(100, 100, 1102, 544);
				//panel_2.setBounds(0, 0, 1096, 39);
				pnlVaccine.setVisible(false);
				
				

				btnRecords.setBackground(new Color(25, 31, 34));
				btnRecords.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
				
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnMedicine.setBackground(new Color(36, 46, 50));
				btnResidents.setBackground(new Color(36, 46, 50));
				btnVaccine.setBackground(new Color(36, 46, 50));
				btnLogout.setBackground(new Color(36, 46, 50));
				btnVaccine.setBorder(null);
				btnResidents.setBorder(null);
				btnMedicine.setBorder(null);
				btnAddUser.setBorder(null);

				btnLogout.setBorder(null);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRecord.setVisible(false);
				pnlDashBoard.setVisible(true);
				pnlVaccine.setVisible(false);
				pnlUser.setVisible(false);
				pnlMedicines.setVisible(false);
				pnlResidents.setVisible(false);
				
				btnMedicine.setBackground(new Color(36, 46, 50));
				btnResidents.setBackground(new Color(36, 46, 50));
				btnVaccine.setBackground(new Color(36, 46, 50));
				btnRecords.setBackground(new Color(36, 46, 50));
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnLogout.setBackground(new Color(36, 46, 50));
				btnLogout.setBorder(null);
				btnRecords.setBorder(null);
				btnVaccine.setBorder(null);
				btnResidents.setBorder(null);
				btnMedicine.setBorder(null);
				btnVaccine.setBorder(null);
				btnAddUser.setBorder(null);
			}
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogout.setBackground(new Color(25, 31, 34));
				btnLogout.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
				btnMedicine.setBackground(new Color(36, 46, 50));
				btnResidents.setBackground(new Color(36, 46, 50));
				btnVaccine.setBackground(new Color(36, 46, 50));
				btnRecords.setBackground(new Color(36, 46, 50));
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnRecords.setBorder(null);
				btnVaccine.setBorder(null);
				btnResidents.setBorder(null);
				btnMedicine.setBorder(null);
				btnVaccine.setBorder(null);
				btnAddUser.setBorder(null);
				int sel = JOptionPane.showConfirmDialog(null, "Do you want to logout?","Logout Employee", JOptionPane.YES_NO_OPTION);
				if(sel==0) {
					dispose();
					loginForm login = new loginForm();
					login.setVisible(true);
					
				}
				btnMedicine.setBackground(new Color(36, 46, 50));
				btnResidents.setBackground(new Color(36, 46, 50));
				btnVaccine.setBackground(new Color(36, 46, 50));
				btnRecords.setBackground(new Color(36, 46, 50));
				btnAddUser.setBackground(new Color(36, 46, 50));
				btnLogout.setBackground(new Color(36, 46, 50));
				btnLogout.setBorder(null);
				btnRecords.setBorder(null);
				btnVaccine.setBorder(null);
				btnResidents.setBorder(null);
				btnMedicine.setBorder(null);
				btnVaccine.setBorder(null);
				btnAddUser.setBorder(null);
				
			}
		});
		Data.populateTblAllVacRecord();
		checkExpiredVacciners();
		initiateClock();
		generateTblMedicineRecord(Data);
		generateTableVaccineRecord(Data);
		checkExpiredMedicines();
		Data.populateJtable();
		generateUser(Data);
		Data.populateTransactionRecords();
		Data.populateTblMeds();
		centerScreen();
	}
	
	public static void generateUser(data Data){

	        String[] colsMenu = {"FULLNAME","POSITION","USERNAME","", "ID"};
	        tblMenuModel = new DefaultTableModel(colsMenu, 0){
	            public Class getColumnClass(int column){
	                return getValueAt(0,column).getClass();
	            }
	        };

	        List<users> userList = Data.getUserList();
	        for (users o: userList){
	        			String fullname = o.getFname() + " " + o.getMname()+" "+o.getLname();
	                    Object[] newRow = {fullname,o.getPosition(), o.getUsername(),"VIEW", o.getId()};
	                    tblMenuModel.addRow(newRow);
	        }
	        
	        Action viewInfo = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtFname.setEnabled(false);
					txtMname.setEnabled(false);
					txtLname.setEnabled(false);
					txtFname.setEnabled(false);
					txtMname.setEnabled(false);
					txtLname.setEnabled(false);
					cbPosition.setEnabled(false);
					txtUsername.setEnabled(false);
					txtCPw.setEnabled(false);
					txtPw.setEnabled(false);
					try {
						int rowIndex = Integer.valueOf(e.getActionCommand());
						idholder = Integer.parseInt(String.valueOf(table.getModel().getValueAt(rowIndex, 4)));
						for (users o : userList) {
							if(o.getId() == idholder) {
									txtFname.setText(o.getFname());
									txtMname.setText(o.getMname());
									txtLname.setText(o.getLname());
									cbStatus.setSelectedItem(o.getStatus());
									cbPosition.setSelectedItem(o.getPosition().toUpperCase());
									txtUsername.setText(o.getUsername());
									txtCPw.setText("");
									txtPw.setText(o.getPassword());
									
							}
						}
					}catch(Exception es) {
						System.out.println(es);
					}
				}
			};
	        table.setModel(tblMenuModel);
	        ButtonColumn buttonColumn = new ButtonColumn(table, viewInfo, 3);
	        table.setRowHeight(100);
	        table.removeColumn(table.getColumnModel().getColumn(4));

	 }
	public static void refreshUser() {
		
		tblMenuModel.setRowCount(0);
		Data.populateJtable();
		generateUser(Data);
	
	}
	public static void generateMeds(data Data) {
        String[] colsMenu = {"BRAND NAME", "GENERIC NAME", "STOCK"," ", "ID","Date"};
        tblMedsModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
  
        List<medicines> medLists = Data.getMedList();
        for (medicines o: medLists){
        	/*SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String manuDateFormatted = format1.format(o.getManuDate());
			String expiDateFormatted = format1.format(o.getExpirationDate());*/
        	
                    Object[] newRow = {o.getbName()+" "+o.getMeasure()+o.getMetricmeasure(), o.getgName(), o.getQty(), "VIEW", o.getId(),o.getExpirationDate()};
                    
                    tblMedsModel.addRow(newRow);
        }
        tblMeds.setModel(tblMedsModel);

        Action viewInfo = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtGenericName.setEnabled(false);
				txtBrandName.setEnabled(false);
				txtQty.setEnabled(false);
				jdcManuDate.setEnabled(false);
				jdcExpDate.setEnabled(false);
				cbMedCategory.setEnabled(false);
				txtMeas.setEnabled(false);
				cbMeasurement.setEnabled(false);
				try {
					int rowIndex = Integer.valueOf(e.getActionCommand());
					idholder = Integer.parseInt(String.valueOf(tblMeds.getModel().getValueAt(rowIndex, 4)));
					for(medicines o: medLists) {
						if(o.getId()==idholder) {
							SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							String manuDateFormatted = format1.format(o.getManuDate());
							String expiDateFormatted = format1.format(o.getExpirationDate());
							txtGenericName.setText(o.getgName());
							txtBrandName.setText(o.getgName());
							txtQty.setText(String.valueOf(o.getQty()));
							jdcManuDate.setDate(format1.parse(manuDateFormatted));
							jdcExpDate.setDate(format1.parse(expiDateFormatted));
							cbMedCategory.setSelectedItem(o.getCategory().toString());
							txtMeas.setText(String.valueOf(o.getMeasure()));
							cbMeasurement.setSelectedItem(o.getMetricmeasure());
							
						}
						
					}
				}catch(Exception es) {
					System.out.println(es);
				}
			}
        	
        };
        ButtonColumn buttonColumn = new ButtonColumn(tblMeds, viewInfo, 3);
        tblMeds.setRowHeight(100);
               
        tblMeds.removeColumn(tblMeds.getColumnModel().getColumn(4));
        tblMeds.removeColumn(tblMeds.getColumnModel().getColumn(4));
        
	}
	public static void refreshMed() {
		
		tblMedsModel.setRowCount(0);
		Data.populateTblMeds();
		generateMeds(Data);
	}
	
	public  void generateResidents(data Data) {

		/*String[] colsMenu = {"Image", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "ADDRESS", "GENDER", "BIRTHDATE", "CIVIL STATUS", 
				"CATEGORY", "PWD SPECIFICATION", "OCCUPATION", "POSITION IN FAMILY"};*/
		String[] colsMenu = {"Image", "Fullname","","id"};
		tblResidentModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {
			
				 	if(column==0) {
				 		return Icon.class;
				 	}

				 	  return Object.class;
				
			}
			
		};
		
		List<residentInfo> residentList = Data.getResidentList();
		for (residentInfo o : residentList) {
			//String address =o.getStreet()+", "+o.getBrgy()+", "+o.getCity()+", "+o.getProvince();
			//byte[]img = o.getPhoto();
			String img = o.getPhoto();
			ImageIcon newImage = null;
			
			if(img==null) {

				newImage=null;
			}else {
				
				
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(100, 100 ,Image.SCALE_SMOOTH);//this ikaw na bahala mag snet ng size
                newImage = new ImageIcon(myImg);
				

			}
			Object[] newRow = {newImage, o.getFname()+" "+o.getMname()+" "+o.getLname(),"VIEW INFO",o.getId()};
			tblResidentModel.addRow(newRow);
			
		}
		
		tblResident.setModel(tblResidentModel);

		
		 Action view = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtFn.setEnabled(false);
					txtMn.setEnabled(false);
					txtLn.setEnabled(false);
					cbResGen.setEnabled(false);
					dcBdateRes.setEnabled(false);
					cbPosRes.setEnabled(false);
					txtSt.setEnabled(false);
					txtBgy.setEnabled(false);
					txtCity.setEnabled(false);
					txtPro.setEnabled(false);
					txtOccu.setEnabled(false);
					cbCivil.setEnabled(false);
					cbCategory.setEnabled(false);
					txtPwd.setEnabled(false);
					btnUpload.setEnabled(false);
					try {
						int rowIndex = Integer.valueOf(e.getActionCommand());
						idholder = Integer.parseInt(String.valueOf(tblResident.getModel().getValueAt(rowIndex, 3)));
						for (residentInfo o : residentList) {
							if(o.getId()==idholder) {
								
								try {
									String bdate = o.getBdate();
									
								    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
									txtFn.setText(o.getFname());
									txtMn.setText(o.getMname());
									txtLn.setText(o.getLname());
									txtSt.setText(o.getStreet());
									txtBgy.setText(o.getBrgy());
									txtCity.setText(o.getCity());
									txtPro.setText(o.getProvince());
									cbResGen.setSelectedItem(o.getGender());
									Date birthdate = formatter1.parse(bdate);
									dcBdateRes.setDate(birthdate);
									cbCivil.setSelectedItem(o.getCivilStatus());
									txtOccu.setText(o.getOccupation());
									cbPosRes.setSelectedItem(o.getPosition());
									cbCategory.setSelectedItem(o.getCategory());
									txtPwd.setText(o.getPwdSpecify());
									String img = o.getPhoto();
									filename=o.getPhoto();
									ImageIcon newImage = null;
									System.out.print(img);
									if(img==null) {
										newImage=new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png");
									}else {
										ImageIcon image = new ImageIcon(img);
						                Image im = image.getImage();
						                Image myImg = im.getScaledInstance(140, 140 ,Image.SCALE_SMOOTH);//this ikaw na bahala mag snet ng size
						                newImage = new ImageIcon(myImg);
									}
									imgHolder.setIcon(newImage);
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						}
						
					}catch(ArrayIndexOutOfBoundsException ex) {
						System.out.print(ex);;
					}
				}
				
				
	        };
        ButtonColumn buttonColumn = new ButtonColumn(tblResident, view, 2);
        tblResident.setRowHeight(100);
		
		tblResident.getColumnModel().getColumn(0).setMaxWidth(100);
		tblResident.getColumnModel().getColumn(0).setMinWidth(100);
		tblResident.getColumnModel().getColumn(2).setPreferredWidth(10);
		tblResident.removeColumn(tblResident.getColumnModel().getColumn(3));

	
		//tblResidents.getColumnModel().getColumn(11).setCellRenderer(new WordWrapCellRenderer());
		
	}
	
	public void generateTblVaccines(data Data) {
		Data.populatetblVac();
		 String[] colsMenu = {"Vaccine Name", "Vaccine Quantity", "Manufactured Date","ExpirationDate"," ", "ID"};
		 
		 tblVaccinesModel = new DefaultTableModel(colsMenu, 0){
	            public Class getColumnClass(int column){
	            	  return Object.class;
	            }
	        };
	        List<vaccInfo>vacList = Data.getvaccList();
	        for(vaccInfo o: vacList) {
	        	 Object[] newRow = {o.getVaccName(), o.getVaccName(), o.getManudate(), o.getExpdate(), "VIEW", o.getId()};
	        	 tblVaccinesModel.addRow(newRow);
	        }
	       tblVaccines.setModel(tblVaccinesModel);

			 Action view = new AbstractAction() {

					@Override
					public void actionPerformed(ActionEvent e) {
						txtVacName.setEnabled(false);
						txtVacQty.setEnabled(false);
						dcVacManu.setEnabled(false);
						dcVacExpi.setEnabled(false);
						try {
							int rowIndex = Integer.valueOf(e.getActionCommand());
							idholder = Integer.parseInt(String.valueOf(tblVaccines.getModel().getValueAt(rowIndex, 5)));
							for(vaccInfo o: vacList) {
								
								if(o.getId()==idholder) {
									SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
									String manuDateFormatted = format1.format(o.getManudate());
									String expiDateFormatted = format1.format(o.getExpdate());
									txtVacName.setText(o.getVaccName());
									txtVacQty.setText(String.valueOf(o.getQty()));
									dcVacManu.setDate(format1.parse(manuDateFormatted));
									dcVacExpi.setDate(format1.parse(expiDateFormatted));
								}
							}
						}catch(Exception es) {
							System.out.println(es);
						}
					}
			};
			
			tblVaccines.setRowHeight(100);
	       ButtonColumn buttonColumn = new ButtonColumn(tblVaccines, view, 4);
	       tblVaccines.removeColumn(tblVaccines.getColumnModel().getColumn(5));
	}
	
	public void checkExpiredMedicines() {
		int numberOfExpired = 0;
		data Data = data.getInstance();
		Data.populateTblMeds();
		 List<medicines> medLists = Data.getMedList();
	        for (medicines o: medLists){
	        	Date date = o.getExpirationDate();
	        	
		      if(date.before(new Date())) {
		    	  numberOfExpired+=1;
		      }
	        	
	        }
		;
			String expiredFormat = String.format("%02d", numberOfExpired);

	        lblNumExpMed.setText(String.valueOf(expiredFormat));
	      
	}
	
	public void checkExpiredVacciners() {
		int numberOfExpired = 0;
		data Data = data.getInstance();
		Data.populatetblVac();
		 List<vaccInfo> vacList = Data.getvaccList();
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd h:m");
	        for (vaccInfo o: vacList){
	        	Date date = o.getExpdate();
	        	
			      if(date.before(new Date())) {
			    	  numberOfExpired+=1;
			      }
		        	
			    
	        }
		;
			String expiredFormat = String.format("%02d", numberOfExpired);

	        lblNumExpMed.setText(String.valueOf(expiredFormat));
	      
	}
	
	public void initiateClock() {
		
		Thread initiateClock = new Thread() {
			public void run() {
				try {
					
					for(;;) {
						Calendar cal = new GregorianCalendar();

						int month = cal.get(Calendar.MONTH);
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int year = cal.get(Calendar.YEAR);
						int min = cal.get(Calendar.MINUTE);
						int hr = cal.get(Calendar.HOUR);
						String pattern = "MMMMM dd, yyyy";
						Date date = new Date();
						SimpleDateFormat dates = new SimpleDateFormat(pattern);
						String formattedDate = dates.format(date);
						lblDate.setText(formattedDate);
					
						Date time = new Date();
						String timePattern ="hh:mm aaa";
						SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
						
						String newTime = timeFormat.format(time);
						lblTime.setText(newTime.toUpperCase());
					
						sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		initiateClock.start();
		
		
		
	}
	public void generateTblMedicineRecord(data Data) {

		String[] colsMenu = {"Resident Fullname", "Brand Name","Generic Name","Quantity","Transaction Date"};
		tblMedicineModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<transactionList> transList = Data.getTransList();
		for(transactionList o: transList) {

			Object[] newRow = {o.getResidentFullName(), o.getBrandName(), o.getGenericName(), o.getQuantity(), o.getDate()};
			tblMedicineModel.addRow(newRow);
		}
		tblMedicine.setModel(tblMedicineModel);
	}
	public void generateTableVaccineRecord(data Data) {
	
		String[] colsMenu = {"Infant Fullname ", "Vaccine name","Dozes","Date Vaccinated"};
		tblVaccineModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<allVaccineRecord> allVaccineRecord = Data.getAllVaccineRecordList();
		for(allVaccineRecord o: allVaccineRecord) {

			Object[] newRow = {o.getFullname(), o.getVacname(), o.getDozes(), o.getDatevaccinated()};
			tblVaccineModel.addRow(newRow);
		}
		tblVaccine.setModel(tblVaccineModel);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
