import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.border.MatteBorder;
public class registerResidentForm extends JFrame {
	private static data Data;
	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtMname;
	private JTextField txtLname;
	private JTextField txtOccupation;
	private JTextField txtSpecify;
	byte[] photo = null;
	String filename = null;
	private File f;
	private JFileChooser chooser;
	private JLabel imageHolder;
	private JTextField txtStreet;
	private JTextField txtBgy;
	private JTextField txtCity;
	private JTextField txtProvince;
	private ButtonGroup btnGroup;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerResidentForm frame = new registerResidentForm();
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
	public registerResidentForm() {
		btnGroup = new ButtonGroup();
		Data = data.getInstance();
		setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(74,94,104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(250, 142, 76, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME:");
		lblMiddleName.setForeground(new Color(255, 255, 255));
		lblMiddleName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMiddleName.setBounds(474, 142, 97, 20);
		contentPane.add(lblMiddleName);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(698, 142, 76, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("GENDER:");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(698, 187, 85, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("BIRTHDATE:");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(474, 187, 116, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CIVIL STATUS:");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(56, 362, 132, 27);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("CATEGORY:");
		lblNewLabel_1_4_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_4_1_1.setBounds(280, 362, 108, 27);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		JLabel lblOccupation = new JLabel("OCCUPATION:");
		lblOccupation.setForeground(new Color(255, 255, 255));
		lblOccupation.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblOccupation.setBounds(504, 362, 133, 27);
		contentPane.add(lblOccupation);
		
		JLabel lblNewLabel_1_4_1_3 = new JLabel("POSITION IN FAMILY:");
		lblNewLabel_1_4_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4_1_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_4_1_3.setBounds(250, 185, 203, 27);
		contentPane.add(lblNewLabel_1_4_1_3);
		
		txtFname = new JTextField();
		txtFname.setForeground(new Color(255, 255, 255));
		txtFname.setOpaque(false);
		txtFname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtFname.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtFname.setBounds(250, 115, 214, 27);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		txtMname = new JTextField();
		txtMname.setForeground(new Color(255, 255, 255));
		txtMname.setOpaque(false);
		txtMname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtMname.setColumns(10);
		txtMname.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));

		txtMname.setBounds(474, 115, 214, 27);
		contentPane.add(txtMname);
		
		txtLname = new JTextField();
		txtLname.setForeground(new Color(255, 255, 255));
		txtLname.setOpaque(false);
		txtLname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtLname.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtLname.setColumns(10);
		txtLname.setBounds(698, 115, 214, 27);
		contentPane.add(txtLname);
		
		txtOccupation = new JTextField();
		txtOccupation.setForeground(new Color(255, 255, 255));
		txtOccupation.setOpaque(false);
		txtOccupation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtOccupation.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtOccupation.setColumns(10);
		txtOccupation.setBounds(504, 390, 214, 27);
		contentPane.add(txtOccupation);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setForeground(new Color(255, 255, 255));
		cbGender.setOpaque(false);
		cbGender.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 0, 0)));
		cbGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE"}));
		cbGender.setBounds(698, 214, 214, 27);
		contentPane.add(cbGender);
		
		JComboBox cbCivil = new JComboBox();
		cbCivil.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cbCivil.setModel(new DefaultComboBoxModel(new String[] {"", "SINGLE", "MARRIED", "WIDOWED", "DIVORCED", "SEPARATED"}));
		cbCivil.setBounds(56, 389, 214, 27);
		contentPane.add(cbCivil);
		
		JButton btnCancelReg = new JButton("CANCEL");
		btnCancelReg.setToolTipText("Go back to previous frame.");
		btnCancelReg.setForeground(new Color(255, 255, 255));
		btnCancelReg.setFocusable(false);
		btnCancelReg.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\outline_arrow_back_ios_black_24dp.png"));
		btnCancelReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data.generateId();
				 int sel = JOptionPane.showConfirmDialog(null,"Are you sure you want to go back?","Register Form", JOptionPane.YES_NO_OPTION);
				 if (sel==0) {
					 employeeFrame eframe = new employeeFrame();
					 dispose();
					 eframe.setVisible(true);
				 }

				
			}
		});
		btnCancelReg.setBorder(null);
		btnCancelReg.setBackground(new Color(36,46,50));
		btnCancelReg.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		btnCancelReg.setBounds(216, 448, 150, 39);
		contentPane.add(btnCancelReg);
		
		JButton btnRegisterResident = new JButton("REGISTER");
		btnRegisterResident.setToolTipText("Save resident's information.");
		btnRegisterResident.setForeground(new Color(255, 255, 255));



		btnRegisterResident.setFocusable(false);

		btnRegisterResident.setIconTextGap(2);
		btnRegisterResident.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\outline_done_black_24dp.png"));
		btnRegisterResident.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		btnRegisterResident.setBorder(null);
		btnRegisterResident.setBackground(new Color(36,46,50));
		btnRegisterResident.setBounds(56, 448, 150, 39);
		contentPane.add(btnRegisterResident);
		
		JDateChooser dcBdate = new JDateChooser();
		dcBdate.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		dcBdate.setBounds(474, 214, 214, 27);
		dcBdate.setDateFormatString("yyyy-dd-MM");
		contentPane.add(dcBdate);
		
		JLabel lblRegisterResident = new JLabel("REGISTER RESIDENT");
		lblRegisterResident.setOpaque(true);
		lblRegisterResident.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegisterResident.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterResident.setBackground(new Color(36,46,50));
		lblRegisterResident.setBounds(202, 11, 572, 51);
		contentPane.add(lblRegisterResident);
		lblRegisterResident.setForeground(new Color(255, 255, 255));
		lblRegisterResident.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));

		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"", "N/A", "PWD", "SENIOR", "INFANT", "PREGNANT"}));
		cbCategory.setBounds(280, 389, 214, 27);
		contentPane.add(cbCategory);
		
		JLabel lblSpecifyPwd = new JLabel("PLEASE SPECIFY:");
		lblSpecifyPwd.setForeground(new Color(255, 255, 255));
		lblSpecifyPwd.setVisible(false);
		lblSpecifyPwd.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblSpecifyPwd.setBounds(504, 362, 154, 27);
		contentPane.add(lblSpecifyPwd);
		
		txtSpecify = new JTextField();
		txtSpecify.setForeground(new Color(255, 255, 255));
		txtSpecify.setOpaque(false);
		txtSpecify.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 0, 0)));
		txtSpecify.setVisible(false);
		txtSpecify.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtSpecify.setColumns(10);
		txtSpecify.setBounds(504, 390, 214, 27);
		contentPane.add(txtSpecify);
		txtSpecify.setText("N/A");
		JButton btnUpload = new JButton("CHOOSE IMAGE");
		
		btnUpload.setBounds(56, 243, 150, 23);
		contentPane.add(btnUpload);
		imageHolder = new JLabel("");
		imageHolder.setHorizontalAlignment(SwingConstants.CENTER);
		imageHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
		imageHolder.setBounds(56, 91, 150, 150);
		contentPane.add(imageHolder);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ADDRESS:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(56, 278, 118, 27);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtStreet = new JTextField();
		txtStreet.setForeground(new Color(255, 255, 255));
		txtStreet.setOpaque(false);
		txtStreet.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtStreet.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		txtStreet.setBounds(56, 304, 214, 27);
		contentPane.add(txtStreet);
		
		JLabel lblFullName = new JLabel("FULL NAME:");
		lblFullName.setForeground(new Color(255, 255, 255));
		lblFullName.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFullName.setBounds(250, 91, 104, 25);
		contentPane.add(lblFullName);
		
		JRadioButton rbHead = new JRadioButton("HEAD OF THE FAMILY");
		rbHead.setForeground(new Color(255, 255, 255));
		rbHead.setName("HEAD OF THE FAMILY");
		rbHead.setFocusable(false);
		rbHead.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rbHead.setOpaque(false);
		rbHead.setBounds(250, 212, 163, 20);
		rbHead.setActionCommand("HEAD OF THE FAMILY");
		contentPane.add(rbHead);
		btnGroup.add(rbHead);
		JRadioButton rbMember = new JRadioButton("MEMBER OF THE FAMILY");
		rbMember.setForeground(new Color(255, 255, 255));
		rbMember.setFocusable(false);
		rbMember.setOpaque(false);
		rbMember.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rbMember.setBounds(250, 235, 183, 20);
		rbMember.setActionCommand("MEMBER OF THE FAMILY");
		contentPane.add(rbMember);
		btnGroup.add(rbMember);
		
		JLabel lblYearmonthday = new JLabel("YEAR/MONTH/DAY");
		lblYearmonthday.setForeground(new Color(255, 255, 255));
		lblYearmonthday.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblYearmonthday.setBounds(474, 241, 125, 20);
		contentPane.add(lblYearmonthday);
		
		JLabel lblStreetAddress = new JLabel("STREET ADDRESS");
		lblStreetAddress.setForeground(new Color(255, 255, 255));
		lblStreetAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblStreetAddress.setBounds(56, 331, 108, 20);
		contentPane.add(lblStreetAddress);
		
		txtBgy = new JTextField();
		txtBgy.setForeground(new Color(255, 255, 255));
		txtBgy.setOpaque(false);
		txtBgy.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtBgy.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtBgy.setColumns(10);
		txtBgy.setBounds(280, 304, 214, 27);
		contentPane.add(txtBgy);
		
		JLabel lblBarangay = new JLabel("BARANGAY");
		lblBarangay.setForeground(new Color(255, 255, 255));
		lblBarangay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBarangay.setBounds(280, 331, 71, 20);
		contentPane.add(lblBarangay);
		
		txtCity = new JTextField();
		txtCity.setForeground(new Color(255, 255, 255));
		txtCity.setOpaque(false);
		txtCity.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCity.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBounds(504, 304, 214, 27);
		contentPane.add(txtCity);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCity.setBounds(504, 331, 28, 20);
		contentPane.add(lblCity);
		
		txtProvince = new JTextField();
		txtProvince.setForeground(new Color(255, 255, 255));
		txtProvince.setOpaque(false);
		txtProvince.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtProvince.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtProvince.setColumns(10);
		txtProvince.setBounds(728, 304, 214, 27);
		contentPane.add(txtProvince);
		
		JLabel lblProvince = new JLabel("PROVINCE");
		lblProvince.setForeground(new Color(255, 255, 255));
		lblProvince.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProvince.setBounds(728, 331, 66, 20);
		contentPane.add(lblProvince);
		
		
		
		
		
		btnRegisterResident.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(txtFname.getText().isEmpty()||
						
						txtLname.getText().isEmpty()||
						txtMname.getText().isBlank()||
						cbCategory.getSelectedItem().equals("")||
						txtSpecify.getText().isEmpty()||
						txtOccupation.getText().isEmpty()||
						cbGender.getSelectedItem().equals("")||
						cbCivil.getSelectedItem().equals("")||
						btnGroup.getSelection()==null||
						txtStreet.getText().isEmpty()||
						txtBgy.getText().isEmpty()||
						txtCity.getText().isEmpty()||
						txtProvince.getText().isEmpty()||
						dcBdate.getDate()==null) {
					JOptionPane.showMessageDialog(null, "Empty Field/s Detected.","Register Resident", JOptionPane.WARNING_MESSAGE);
				}else {
					int sel = JOptionPane.showConfirmDialog(null,"Do you want to register resident?","Register Form", JOptionPane.YES_NO_OPTION);
					 if (sel==0) {
						String fname = txtFname.getText();
						String mname = txtMname.getText();
						String lname = txtLname.getText();
						String street = txtStreet.getText();
						String bgy =txtBgy.getText() ;
						String city = txtCity.getText();
						String province = txtProvince.getText();
						String category = cbCategory.getSelectedItem().toString();
						String pwdSpecification = txtSpecify.getText();
						String occu = txtOccupation.getText();
						String gender = cbGender.getSelectedItem().toString();
						String civilS = cbCivil.getSelectedItem().toString();
						String pos = btnGroup.getSelection().getActionCommand();
						Date bday = dcBdate.getDate();
					
						Data.registerResident(filename,fname, mname, lname, street, bgy, city, province, gender, bday, civilS, category,pwdSpecification, occu, pos);
						txtFname.setText("");
						txtMname.setText("");
						txtLname.setText("");
						//txtReligion.setText("");
						txtSpecify.setText("");
						txtOccupation.setText("");
						cbCategory.setSelectedItem("");
						cbGender.setSelectedItem("");
						cbCivil.setSelectedItem("");
						//cbFam.setSelectedItem("");
						txtStreet.setText("");
						txtBgy.setText("");
						txtCity.setText("");
						txtProvince.setText("");
						dcBdate.setDate(null);
						JOptionPane.showMessageDialog(null, "Successfully added record!");
						imageHolder.setIcon(new ImageIcon("..\\HealthCareSystem\\icons\\pngfind.png"));
						
					 }
				}
				 
			}
		});
		
		cbCategory.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(cbCategory.getSelectedItem().equals("PWD")) {

					txtSpecify.setText("");
					lblSpecifyPwd.setVisible(true);
					txtSpecify.setVisible(true);
					lblOccupation.setBounds(729, 385, 133, 27);
					txtOccupation.setBounds(729, 413, 214, 27);
				}else {
					lblSpecifyPwd.setVisible(false);
					txtSpecify.setVisible(false);
					lblOccupation.setBounds(505,385,133,27);
					txtOccupation.setBounds(505,413,214,27);
					txtSpecify.setText("N/A");
				}
				
			}
			
		});
		
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".image","png","jpg","jpeg");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(null);
				
				if(result==JFileChooser.APPROVE_OPTION) {
				f = chooser.getSelectedFile();
				filename=f.getAbsolutePath();
				imageHolder.setIcon(resizeImage(filename,null));
				}else {
					return;
				}
				
				try {
					File image = new File(filename);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					for(int readNum; (readNum=fis.read(buf)) != -1;) {
						bos.write(buf, 0, readNum);
					}
					photo=bos.toByteArray();
				}catch(Exception e1) {
					System.out.print(e1);
				}
			}
			
		});
		centerScreen();
	}
	
	
	public ImageIcon resizeImage(String imgPath, byte[]pic) {
		ImageIcon img = null;
		if(imgPath != null) {
			System.out.println("imagePath");
			img = new ImageIcon(imgPath);
		}else {
			System.out.println("Pic");
			img = new ImageIcon(pic);
		}
		Image image = img.getImage();
		Image imageResize = image.getScaledInstance(imageHolder.getWidth(), imageHolder.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon myImage = new ImageIcon(imageResize);
		return myImage;
		
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
