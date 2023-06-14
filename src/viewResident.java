import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class viewResident extends JFrame {

	private JPanel panel;
	private JTextField txtSearchBar;
	private static DefaultTableModel tblResidentModel;
	private data Data;
	private JTable tblResidents;
	private static String sort;
	private Icon icon = null;
	private JLabel imgHolder;
	private JLabel lblImageHolder;
	private JTextField txtFname;
	private JTextField txtMname;
	private JLabel lblImageHolder_2;
	private JTextField txtLname;
	private JLabel lblImageHolder_3;
	private JTextField txtStreet;
	private JLabel lblImageHolder_4;
	private JTextField txtBgy;
	private JLabel lblImageHolder_5;
	private JTextField txtCity;
	private JLabel lblImageHolder_6;
	private JLabel lblImageHolder_7;
	private JComboBox cbGender;
	private JLabel lblImageHolder_8;
	private JTextField txtPwd;
	private JTextField txtOccupation;
	private JDateChooser dcBdate;
	private JComboBox cbCivilStatus;
	private JComboBox cbCategory;
	private JButton btnUpload;
	private JTextField txtProvince;
	private JButton btnUpdate;
	private JButton btnConfirm;
	private int id;
	byte[] photo = null;
	String filename = null;
	private File f;
	private JFileChooser chooser;
	private JComboBox cbPosition;
	private JButton btnBack;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewResident frame = new viewResident();
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
	public viewResident() {
		Data = data.getInstance();

		Data.populatetblResident();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1223, 580);
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(74,94,104));
		panel.setBorder(null);
		setContentPane(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(36,46,50));
		scrollPane.setBounds(10, 134, 478, 414);
		panel.add(scrollPane);
		
		tblResidents = new JTable();
		tblResidents.setForeground(new Color(255, 255, 255));
		tblResidents.setGridColor(new Color(74,94,104));
		tblResidents.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));

		tblResidents.setShowVerticalLines(false);
		tblResidents.setFillsViewportHeight(true);
		tblResidents.setBackground(new Color(36,46,50));
		scrollPane.setViewportView(tblResidents);
		
		
		generateResidents(Data);
		
		//populateJTable();
		txtSearchBar = new JTextField();

		txtSearchBar.setBorder(null);
		txtSearchBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSearchBar.setBounds(86, 95, 235, 28);
		panel.add(txtSearchBar);
		txtSearchBar.setColumns(10);

		JLabel lblNewLabel = new JLabel("SEARCH:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 96, 66, 25);
		panel.add(lblNewLabel);
		
		imgHolder = new JLabel("");
		imgHolder.setHorizontalTextPosition(SwingConstants.CENTER);
		imgHolder.setHorizontalAlignment(SwingConstants.CENTER);
		imgHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
		imgHolder.setBounds(498, 165, 150, 140);
		panel.add(imgHolder);
		
		lblImageHolder = new JLabel("FIRST NAME:");
		lblImageHolder.setForeground(new Color(255, 255, 255));
		lblImageHolder.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder.setBounds(655, 205, 125, 26);
		panel.add(lblImageHolder);
		
		txtFname = new JTextField();
		txtFname.setOpaque(false);
		txtFname.setForeground(new Color(255, 255, 255));
		txtFname.setBackground(Color.LIGHT_GRAY);
		txtFname.setEnabled(false);
		txtFname.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtFname.setColumns(10);
		txtFname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtFname.setBounds(655, 233, 174, 25);
		panel.add(txtFname);
		
		JLabel lblImageHolder_1 = new JLabel("MIDDLE NAME:");
		lblImageHolder_1.setForeground(new Color(255, 255, 255));
		lblImageHolder_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_1.setBounds(839, 205, 143, 26);
		panel.add(lblImageHolder_1);
		
		txtMname = new JTextField();
		txtMname.setOpaque(false);
		txtMname.setForeground(new Color(255, 255, 255));
		txtMname.setBackground(Color.LIGHT_GRAY);
		txtMname.setEnabled(false);
		txtMname.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtMname.setColumns(10);
		txtMname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtMname.setBounds(839, 233, 174, 25);
		panel.add(txtMname);
		
		lblImageHolder_2 = new JLabel("LAST NAME:");
		lblImageHolder_2.setForeground(new Color(255, 255, 255));
		lblImageHolder_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_2.setBounds(1023, 205, 117, 26);
		panel.add(lblImageHolder_2);
		
		txtLname = new JTextField();
		txtLname.setOpaque(false);
		txtLname.setForeground(new Color(255, 255, 255));
		txtLname.setBackground(Color.LIGHT_GRAY);
		txtLname.setEnabled(false);
		txtLname.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtLname.setColumns(10);
		txtLname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtLname.setBounds(1023, 233, 174, 25);
		panel.add(txtLname);
		
		lblImageHolder_3 = new JLabel("STREET:");
		lblImageHolder_3.setForeground(new Color(255, 255, 255));
		lblImageHolder_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_3.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_3.setBounds(498, 371, 83, 26);
		panel.add(lblImageHolder_3);
		
		txtStreet = new JTextField();
		txtStreet.setOpaque(false);
		txtStreet.setForeground(new Color(255, 255, 255));
		txtStreet.setBackground(new Color(74,94,104));
		txtStreet.setEnabled(false);
		txtStreet.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		txtStreet.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtStreet.setBounds(498, 399, 165, 25);
		panel.add(txtStreet);
		
		lblImageHolder_4 = new JLabel("BARANGAY:");
		lblImageHolder_4.setForeground(new Color(255, 255, 255));
		lblImageHolder_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_4.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_4.setBounds(673, 371, 115, 26);
		panel.add(lblImageHolder_4);
		
		txtBgy = new JTextField();
		txtBgy.setOpaque(false);
		txtBgy.setForeground(new Color(255, 255, 255));
		txtBgy.setBackground(new Color(74,94,104));
		txtBgy.setEnabled(false);
		txtBgy.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtBgy.setColumns(10);
		txtBgy.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtBgy.setBounds(673, 399, 165, 25);
		panel.add(txtBgy);
		
		lblImageHolder_5 = new JLabel("CITY:");
		lblImageHolder_5.setForeground(new Color(255, 255, 255));
		lblImageHolder_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_5.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_5.setBounds(848, 371, 52, 26);
		panel.add(lblImageHolder_5);
		
		txtCity = new JTextField();
		txtCity.setOpaque(false);
		txtCity.setForeground(new Color(255, 255, 255));
		txtCity.setBackground(new Color(74,94,104));
		txtCity.setEnabled(false);
		txtCity.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtCity.setBounds(848, 399, 165, 25);
		panel.add(txtCity);
		
		lblImageHolder_6 = new JLabel("PROVINCE:");
		lblImageHolder_6.setForeground(new Color(255, 255, 255));
		lblImageHolder_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_6.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_6.setBounds(1023, 371, 108, 26);
		panel.add(lblImageHolder_6);
		
		lblImageHolder_7 = new JLabel("GENDER:");
		lblImageHolder_7.setForeground(new Color(255, 255, 255));
		lblImageHolder_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_7.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_7.setBounds(655, 285, 89, 26);
		panel.add(lblImageHolder_7);
		
		cbGender = new JComboBox();
		cbGender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbGender.setBackground(new Color(74,94,104));
		cbGender.setFocusTraversalKeysEnabled(false);
		cbGender.setFocusable(false);
		cbGender.setOpaque(false);
		cbGender.setRequestFocusEnabled(false);
		cbGender.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		cbGender.setForeground(new Color(255, 255, 255));

		cbGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cbGender.setEnabled(false);
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
		cbGender.setBounds(655, 313, 161, 25);


		panel.add(cbGender);
		
		
		lblImageHolder_8 = new JLabel("BIRTHDATE:");
		lblImageHolder_8.setForeground(new Color(255, 255, 255));
		lblImageHolder_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_8.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_8.setBounds(826, 285, 116, 26);
		panel.add(lblImageHolder_8);
		
		dcBdate = new JDateChooser();
		dcBdate.setBounds(826, 313, 161, 25);
		panel.add(dcBdate);
		dcBdate.setEnabled(false);
		dcBdate.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		JLabel lblImageHolder_7_1 = new JLabel("CIVIL STATUS:");
		lblImageHolder_7_1.setForeground(new Color(255, 255, 255));
		lblImageHolder_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_7_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_7_1.setBounds(674, 443, 138, 26);
		panel.add(lblImageHolder_7_1);
		
		cbCivilStatus = new JComboBox();
		cbCivilStatus.setBackground(new Color(74,94,104));
		cbCivilStatus.setFocusTraversalKeysEnabled(false);
		cbCivilStatus.setFocusable(false);
		cbCivilStatus.setRequestFocusEnabled(false);
		cbCivilStatus.setOpaque(false);
		cbCivilStatus.setBorder(null);
		cbCivilStatus.setForeground(new Color(255, 255, 255));

		cbCivilStatus.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cbCivilStatus.setEnabled(false);
		cbCivilStatus.setModel(new DefaultComboBoxModel(new String[] {"", "SINGLE", "MARRIED", "WIDOWED", "DIVORCED", "SEPARATED"}));
		cbCivilStatus.setBounds(674, 471, 165, 25);
		panel.add(cbCivilStatus);
		
		JLabel lblImageHolder_7_1_1 = new JLabel("CATEGORY:");
		lblImageHolder_7_1_1.setForeground(new Color(255, 255, 255));
		lblImageHolder_7_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_7_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_7_1_1.setBounds(848, 443, 118, 26);
		panel.add(lblImageHolder_7_1_1);
		
		cbCategory = new JComboBox();
		cbCategory.setBackground(new Color(74,94,104));
		cbCategory.setFocusTraversalKeysEnabled(false);
		cbCategory.setFocusable(false);
		cbCategory.setRequestFocusEnabled(false);
		cbCategory.setOpaque(false);
		cbCategory.setBorder(null);
		cbCategory.setForeground(new Color(255, 255, 255));

		cbCategory.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cbCategory.setEnabled(false);
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"", "N/A", "PWD", "SENIOR", "INFANT", "PREGNANT"}));
		cbCategory.setBounds(848, 471, 165, 25);
		panel.add(cbCategory);
		
		txtPwd = new JTextField();
		txtPwd.setOpaque(false);
		txtPwd.setForeground(new Color(255, 255, 255));
		txtPwd.setBackground(new Color(74,94,104));
		txtPwd.setEnabled(false);
		txtPwd.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPwd.setColumns(10);
		txtPwd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtPwd.setBounds(1023, 471, 165, 25);
		panel.add(txtPwd);
		
		JLabel lblImageHolder_3_1 = new JLabel("PWD SPECIFICATION:");
		lblImageHolder_3_1.setForeground(new Color(255, 255, 255));
		lblImageHolder_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_3_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_3_1.setBounds(1023, 443, 209, 26);
		panel.add(lblImageHolder_3_1);
		
		JLabel lblImageHolder_3_1_1 = new JLabel("POSITION IN FAMILY:");
		lblImageHolder_3_1_1.setForeground(new Color(255, 255, 255));
		lblImageHolder_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_3_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_3_1_1.setBounds(997, 285, 205, 26);
		panel.add(lblImageHolder_3_1_1);
		
		JLabel lblImageHolder_3_1_1_1 = new JLabel("OCCUPATION:");
		lblImageHolder_3_1_1_1.setForeground(new Color(255, 255, 255));
		lblImageHolder_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageHolder_3_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblImageHolder_3_1_1_1.setBounds(498, 443, 136, 26);
		panel.add(lblImageHolder_3_1_1_1);
		
		txtOccupation = new JTextField();
		txtOccupation.setOpaque(false);
		txtOccupation.setForeground(new Color(255, 255, 255));
		txtOccupation.setBackground(new Color(74,94,104));
		txtOccupation.setEnabled(false);
		txtOccupation.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtOccupation.setColumns(10);
		txtOccupation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtOccupation.setBounds(498, 471, 165, 25);
		panel.add(txtOccupation);
		
		btnUpload = new JButton("UPLOAD PICTURE");
		btnUpload.setForeground(new Color(255, 255, 255));
		btnUpload.setBorder(null);
		btnUpload.setBackground(new Color(36,46,50));
		btnUpload.setBorderPainted(false);
		
		btnUpload.setMargin(new Insets(0, 0, 0, 0));
		
		btnUpload.setEnabled(false);
		btnUpload.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		btnUpload.setBounds(498, 305, 150, 38);
		panel.add(btnUpload);
		
		txtProvince = new JTextField();
		txtProvince.setOpaque(false);
		txtProvince.setForeground(new Color(255, 255, 255));
		txtProvince.setBackground(new Color(74,94,104));
		txtProvince.setEnabled(false);
		txtProvince.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtProvince.setColumns(10);
		txtProvince.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(36,46,50)));
		txtProvince.setBounds(1023, 399, 165, 25);
		panel.add(txtProvince);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setToolTipText("Update Resident's Information");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(36,46,50));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));

		btnUpdate.setBounds(1054, 516, 150, 41);
		panel.add(btnUpdate);
		
		btnConfirm = new JButton("CONFIRM");
		btnConfirm.setToolTipText("Confirm update resident's information.");
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setBackground(new Color(36,46,50));
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnConfirm.setBounds(1054, 518, 148, 39);
		panel.add(btnConfirm);
		
		cbPosition = new JComboBox();
		cbPosition.setBackground(new Color(74,94,104));
		cbPosition.setFocusTraversalKeysEnabled(false);
		cbPosition.setFocusable(false);
		cbPosition.setRequestFocusEnabled(false);
		cbPosition.setOpaque(false);
		cbPosition.setBorder(null);
		cbPosition.setForeground(new Color(255, 255, 255));

		cbPosition.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cbPosition.setModel(new DefaultComboBoxModel(new String[] {"", "MEMBER", "HEAD OF THE FAMILY"}));
		cbPosition.setEnabled(false);
		cbPosition.setBounds(997, 313, 161, 25);
		panel.add(cbPosition);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(36,46,50));
		panel_1.setBounds(0, 0, 1223, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BARANGAY BALUCUC HEALTH CARE SYSTEM");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(724, 0, 489, 34);
		panel_1.add(lblNewLabel_1);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeeFrame emp = new employeeFrame();
				emp.setVisible(true);;
			}
		});
		btnBack.setToolTipText("Go back.");
		btnBack.setBorder(null);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusPainted(false);
		btnBack.setFocusTraversalKeysEnabled(false);
		btnBack.setFocusable(false);
		btnBack.setOpaque(false);
		btnBack.setRequestFocusEnabled(false);
		btnBack.setRolloverEnabled(false);
		btnBack.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnBack.setBounds(0, 0, 62, 38);
		panel_1.add(btnBack);
		
		lblNewLabel_2 = new JLabel("VIEW RESIDENTS");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(36,46,50));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(383, 49, 472, 49);
		panel.add(lblNewLabel_2);
		txtSearchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtSearchBar.getText().equals("") || txtSearchBar.getText().isEmpty()
						|| txtSearchBar.getText().isBlank()) {
					Data.populatetblResident();
					generateResidents(Data);
				} else {
					String search = txtSearchBar.getText();
					Data.searchResident(search);
					generateResidents(Data);
				}
			}
		});
		
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
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=tblResidents.getSelectedRow();
				if(row ==-1) {
					JOptionPane.showMessageDialog(null, "Please select a resident to update.");
				}else {
					txtFname.setEnabled(true);
					txtMname.setEnabled(true);
					txtLname.setEnabled(true);
					cbGender.setEnabled(true);
					dcBdate.setEnabled(true);
					cbPosition.setEnabled(true);
					txtStreet.setEnabled(true);
					txtBgy.setEnabled(true);
					txtCity.setEnabled(true);
					txtProvince.setEnabled(true);
					txtOccupation.setEnabled(true);
					cbCivilStatus.setEnabled(true);
					cbCategory.setEnabled(true);
					txtPwd.setEnabled(true);
					btnUpdate.setVisible(false);
					btnConfirm.setVisible(true);
					btnUpload.setEnabled(true);
				}

			}
		});
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFname.getText().isEmpty() || txtMname.getText().isEmpty()
						|| txtLname.getText().isEmpty() || cbGender.getSelectedItem().equals("")||
						dcBdate.getDate().equals(null)|| cbPosition.getSelectedItem().equals("")||
						txtStreet.getText().isEmpty()||txtCity.getText().isEmpty()||
						txtProvince.getText().isEmpty()||txtBgy.getText().isEmpty()||txtOccupation.getText().isEmpty()||
						cbCivilStatus.getSelectedItem().equals("")||cbCategory.getSelectedItem().equals("")||
						txtPwd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill up empty fields.","Empty fileds detected", JOptionPane.WARNING_MESSAGE);
					
				}else {
					int sel=JOptionPane.showConfirmDialog(null, "Are you sure you want to update resident information?","Update Information",JOptionPane.YES_NO_OPTION);
					if(sel==0) {
						System.out.print(filename);
						Data.updateResident(id, txtFname.getText(), txtMname.getText(),txtLname.getText(),cbGender.getSelectedItem().toString(),dcBdate.getDate(),cbPosition.getSelectedItem().toString(),
								txtStreet.getText(),txtBgy.getText(),txtCity.getText(),txtProvince.getText(),txtOccupation.getText(),cbCivilStatus.getSelectedItem().toString(),
								cbCategory.getSelectedItem().toString(),txtPwd.getText(),filename);
						generateResidents(Data);
						JOptionPane.showMessageDialog(null, "Information updated successfully","Update Residents",JOptionPane.INFORMATION_MESSAGE);
						 imgHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
						txtFname.setText("");
						txtMname.setText("");
						txtLname.setText("");
						cbGender.setSelectedItem("");
						dcBdate.setDate(null);
						cbPosition.setSelectedItem("");
						txtStreet.setText("");
						txtBgy.setText("");
						txtCity.setText("");
						txtProvince.setText("");
						txtOccupation.setText("");
						cbCivilStatus.setSelectedItem("");;
						cbCategory.setSelectedItem("");
						txtPwd.setText("");
						
						txtFname.setEnabled(false);
						txtMname.setEnabled(false);
						txtLname.setEnabled(false);
						cbGender.setEnabled(false);
						dcBdate.setEnabled(false);
						cbPosition.setEnabled(false);
						txtStreet.setEnabled(false);
						txtBgy.setEnabled(false);
						txtCity.setEnabled(false);
						txtProvince.setEnabled(false);
						txtOccupation.setEnabled(false);
						cbCivilStatus.setEnabled(false);
						cbCategory.setEnabled(false);
						txtPwd.setEnabled(false);
						btnUpdate.setVisible(true);
						btnConfirm.setVisible(false);
						btnUpload.setEnabled(false);
					}
				}

			}
		});
		
	}

	public void generateResidents(data Data) {
		centerScreen();
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
		
		tblResidents.setModel(tblResidentModel);

		

		
		
		 Action view = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtFname.setEnabled(false);
					txtMname.setEnabled(false);
					txtLname.setEnabled(false);
					cbGender.setEnabled(false);
					dcBdate.setEnabled(false);
					cbPosition.setEnabled(false);
					txtStreet.setEnabled(false);
					txtBgy.setEnabled(false);
					txtCity.setEnabled(false);
					txtProvince.setEnabled(false);
					txtOccupation.setEnabled(false);
					cbCivilStatus.setEnabled(false);
					cbCategory.setEnabled(false);
					txtPwd.setEnabled(false);
					btnUpdate.setVisible(true);
					btnConfirm.setVisible(false);
					btnUpload.setEnabled(false);
					try {
						int rowIndex = Integer.valueOf(e.getActionCommand());
						id = Integer.parseInt(String.valueOf(tblResidents.getModel().getValueAt(rowIndex, 3)));
						for (residentInfo o : residentList) {
							if(o.getId()==id) {
								
								try {
									String bdate = o.getBdate();
									
								    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
									txtFname.setText(o.getFname());
									txtMname.setText(o.getMname());
									txtLname.setText(o.getLname());
									txtStreet.setText(o.getStreet());
									txtBgy.setText(o.getBrgy());
									txtCity.setText(o.getCity());
									txtProvince.setText(o.getProvince());
									cbGender.setSelectedItem(o.getGender());
									Date birthdate = formatter1.parse(bdate);
									dcBdate.setDate(birthdate);
									cbCivilStatus.setSelectedItem(o.getCivilStatus());
									txtOccupation.setText(o.getOccupation());
									cbPosition.setSelectedItem(o.getPosition());
									cbCategory.setSelectedItem(o.getCategory());
									txtPwd.setText(o.getPwdSpecify());
									String img = o.getPhoto();
									filename = o.getPhoto();
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
        ButtonColumn buttonColumn = new ButtonColumn(tblResidents, view, 2);
		tblResidents.setRowHeight(100);
		
		tblResidents.getColumnModel().getColumn(0).setMaxWidth(100);
		tblResidents.getColumnModel().getColumn(0).setMinWidth(100);
		tblResidents.getColumnModel().getColumn(2).setPreferredWidth(10);
		tblResidents.removeColumn(tblResidents.getColumnModel().getColumn(3));
		
		
	
		//tblResidents.getColumnModel().getColumn(11).setCellRenderer(new WordWrapCellRenderer());
		
	
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
