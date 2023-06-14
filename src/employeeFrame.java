import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class employeeFrame extends JFrame {
	
	private JPanel contentPane;
	private static JLabel lblDate;
	private static JLabel lblTime;
	private static int numExp;
	private static JLabel lblNumExpMed;
	private static JLabel lblDate_1;
	private static JLabel lblTime_1;
	private static JLabel lblMedNum ;
	private static JLabel lblExpMed;
	private static JLabel lblDateRes;
	private static JLabel lblTimeRes;
	private JPanel pnlDashboard;
	private JPanel pnlMedicine;
	private JPanel pnlVaccine;
	private JButton btnResidents;
	private JButton btnMedicine;
	private JButton btnRecord;
	private JButton btnVaccine;
	private JButton btnLogout;
	private JPanel pnlResident;
	private JLabel lblDate_2;
	private JLabel lblTime_2;
	private JLabel lblDate_2_1;
	private JLabel lblTime_2_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeFrame frame = new employeeFrame();
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
	public employeeFrame() {
		data Data = data.getInstance();
		 
		int stockZero = Data.countZeroQty();
		String stock = String.format("%02d", stockZero);
		
		int num = Data.getNumberOfResidents();
		String formattedNum = String.format("%02d", num);

		
		int numBaby = Data.getNumOfBabies();
		String format = String.format("%02d", numBaby);
		int numPregnant = Data.getNumOfPregnants();
		String formatN = String.format("%02d", numPregnant);
		
		Date time = new Date();
		String timePattern ="hh:mm:ss aaa";
		SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
		String newTime = timeFormat.format(time);
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		setBounds(100, 100, 938, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(104,97,74,255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		int numOfmed = Data.countMedicines();
		String numMedFormat = String.format("%02d", numOfmed);
								 				
								 				pnlVaccine = new JPanel();
								 				pnlVaccine.setVisible(false);
								 				
								 				JPanel pnlRecords = new JPanel();
								 				pnlRecords.setVisible(false);
								 				pnlRecords.setBackground(new Color(74, 94, 104));
								 				pnlRecords.setBounds(249, 0, 689, 608);
								 				contentPane.add(pnlRecords);
								 				pnlRecords.setLayout(null);
								 				
								 				JButton btnInfantVacRecord = new JButton("VACCINE RECORDS");
								 				btnInfantVacRecord.addActionListener(new ActionListener() {
								 					public void actionPerformed(ActionEvent e) {
								 						dispose();
								 						vaccineRecords vac = new vaccineRecords();
								 						vac.setVisible(true);
								 					}
								 				});
								 				
								 					 				btnInfantVacRecord.setForeground(Color.WHITE);
								 					 				btnInfantVacRecord.setFont(new Font("Segoe UI", Font.PLAIN, 14));
								 					 				btnInfantVacRecord.setBorder(null);
								 					 				btnInfantVacRecord.setBackground(new Color(36, 46, 50));
								 					 				btnInfantVacRecord.setBounds(109, 444, 221, 77);
								 					 				pnlRecords.add(btnInfantVacRecord);
								 				
								 				lblDate_2_1 = new JLabel("DATE");
								 				lblDate_2_1.setHorizontalTextPosition(SwingConstants.LEFT);
								 				lblDate_2_1.setHorizontalAlignment(SwingConstants.LEFT);
								 				lblDate_2_1.setForeground(Color.WHITE);
								 				lblDate_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
								 				lblDate_2_1.setBounds(109, 77, 253, 62);
								 				pnlRecords.add(lblDate_2_1);
								 				
								 				lblTime_2_1 = new JLabel("10:28:15 pm");
								 				lblTime_2_1.setHorizontalTextPosition(SwingConstants.RIGHT);
								 				lblTime_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
								 				lblTime_2_1.setForeground(Color.WHITE);
								 				lblTime_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
								 				lblTime_2_1.setBounds(360, 77, 226, 62);
								 				pnlRecords.add(lblTime_2_1);
								 				
								 				JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("VACCINE / MEDICINE RECORDS");
								 				lblNewLabel_1_1_1_2_1_1.setOpaque(true);
								 				lblNewLabel_1_1_1_2_1_1.setIconTextGap(15);
								 				lblNewLabel_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 				lblNewLabel_1_1_1_2_1_1.setForeground(Color.WHITE);
								 				lblNewLabel_1_1_1_2_1_1.setFont(new Font("SansSerif", Font.BOLD, 27));
								 				lblNewLabel_1_1_1_2_1_1.setBackground(new Color(36, 46, 50));
								 				lblNewLabel_1_1_1_2_1_1.setBounds(109, 393, 477, 37);
								 				pnlRecords.add(lblNewLabel_1_1_1_2_1_1);
								 				
								 				JButton btnRegVac_1_1_2_1 = new JButton("MEDICINE RECORDS");
								 				btnRegVac_1_1_2_1.addActionListener(new ActionListener() {
								 					public void actionPerformed(ActionEvent e) {
								 						dispose();
								 						MedRecords med = new MedRecords();
								 						med.setVisible(true);
								 					}
								 				});
								 				btnRegVac_1_1_2_1.setForeground(Color.WHITE);
								 				btnRegVac_1_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
								 				btnRegVac_1_1_2_1.setBorder(null);
								 				btnRegVac_1_1_2_1.setBackground(new Color(36, 46, 50));
								 				btnRegVac_1_1_2_1.setBounds(365, 444, 221, 77);
								 				pnlRecords.add(btnRegVac_1_1_2_1);
								 				
								 				JLabel lblNewLabel_2 = new JLabel("");
								 				lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\test12112.png"));
								 				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								 				lblNewLabel_2.setBounds(109, 156, 477, 209);
								 				pnlRecords.add(lblNewLabel_2);
								 				
								 				
								 				pnlDashboard = new JPanel();
								 				pnlDashboard.setBackground(new Color(74, 94, 104));
								 				pnlDashboard.setBounds(249, 0, 689, 608);
								 				contentPane.add(pnlDashboard);
								 				pnlDashboard.setLayout(null);
								 				
								 						JLabel lblNewLabel_1 = new JLabel("TOTAL POPULATIONS");
								 						lblNewLabel_1.setBounds(118, 167, 477, 30);
								 						pnlDashboard.add(lblNewLabel_1);
								 						lblNewLabel_1.setForeground(Color.WHITE);
								 						lblNewLabel_1.setBackground(new Color(36, 46, 50));
								 						lblNewLabel_1.setOpaque(true);
								 						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 23));
								 						
								 						JLabel lblNewLabel_6 = new JLabel("");
								 						lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_groups_white_24dp.png"));
								 						lblNewLabel_6.setBounds(64, 248, 48, 48);
								 						pnlDashboard.add(lblNewLabel_6);
								 						lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
								 						lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
								 						
								 						JLabel lblNoRes = new JLabel("##");
								 						lblNoRes.setForeground(Color.WHITE);
								 						lblNoRes.setBounds(118, 255, 34, 41);
								 						pnlDashboard.add(lblNoRes);
								 						lblNoRes.setHorizontalTextPosition(SwingConstants.CENTER);
								 						lblNoRes.setHorizontalAlignment(SwingConstants.CENTER);
								 						lblNoRes.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 						lblNoRes.setText(String.valueOf(formattedNum));
								 						
								 						JLabel lblNewLabel_5 = new JLabel("");
								 						lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_child_friendly_white_24dp.png"));
								 						lblNewLabel_5.setBounds(291, 248, 48, 48);
								 						pnlDashboard.add(lblNewLabel_5);
								 						lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
								 						
								 						JLabel lblNoBabies = new JLabel("03");
								 						lblNoBabies.setForeground(Color.WHITE);
								 						lblNoBabies.setBounds(349, 255, 34, 41);
								 						pnlDashboard.add(lblNoBabies);
								 						lblNoBabies.setHorizontalAlignment(SwingConstants.CENTER);
								 						lblNoBabies.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 						lblNoBabies.setText(String.valueOf(format));
								 						
								 						JLabel lblPregnant = new JLabel("01");
								 						lblPregnant.setForeground(Color.WHITE);
								 						lblPregnant.setBounds(579, 255, 34, 41);
								 						pnlDashboard.add(lblPregnant);
								 						lblPregnant.setVerticalAlignment(SwingConstants.BOTTOM);
								 						lblPregnant.setHorizontalAlignment(SwingConstants.CENTER);
								 						lblPregnant.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 						lblPregnant.setText(String.valueOf(formatN));
								 						
								 						lblDate = new JLabel("DATE");
								 						lblDate.setHorizontalTextPosition(SwingConstants.LEFT);
								 						lblDate.setForeground(Color.WHITE);
								 						lblDate.setBounds(118, 63, 253, 62);
								 						pnlDashboard.add(lblDate);
								 						lblDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
								 						lblDate.setHorizontalAlignment(SwingConstants.LEFT);
								 						
								 						lblTime = new JLabel("DATE");
								 						lblTime.setHorizontalTextPosition(SwingConstants.RIGHT);
								 						lblTime.setForeground(Color.WHITE);
								 						lblTime.setBounds(369, 63, 226, 62);
								 						pnlDashboard.add(lblTime);
								 						lblTime.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
								 						lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
								 						
								 						lblTime.setText(newTime);
								 						
								 						JLabel lblNewLabel_1_1 = new JLabel("MEDICINES");
								 						lblNewLabel_1_1.setBounds(118, 387, 477, 30);
								 						pnlDashboard.add(lblNewLabel_1_1);
								 						lblNewLabel_1_1.setOpaque(true);
								 						lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						lblNewLabel_1_1.setForeground(Color.WHITE);
								 						lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 23));
								 						lblNewLabel_1_1.setBackground(new Color(36, 46, 50));
								 						
								 						 lblMedNum = new JLabel("##");
								 						 lblMedNum.setForeground(Color.WHITE);
								 						 lblMedNum.setBounds(117, 475, 34, 41);
								 						 pnlDashboard.add(lblMedNum);
								 						 lblMedNum.setVerticalAlignment(SwingConstants.BOTTOM);
								 						 lblMedNum.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 lblMedNum.setHorizontalAlignment(SwingConstants.CENTER);
								 						 lblMedNum.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 						 
								 						 		lblMedNum.setText(String.valueOf(numMedFormat));
								 						 		
								 						 		lblNumExpMed = new JLabel("##");
								 						 		lblNumExpMed.setForeground(Color.WHITE);
								 						 		lblNumExpMed.setBounds(349, 475, 34, 41);
								 						 		pnlDashboard.add(lblNumExpMed);
								 						 		lblNumExpMed.setVerticalAlignment(SwingConstants.BOTTOM);
								 						 		lblNumExpMed.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNumExpMed.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNumExpMed.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 						 		
								 						 		JLabel lblNewLabel_4_3 = new JLabel("NUMBER OF RESIDENTS");
								 						 		lblNewLabel_4_3.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		

								 						 		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3.setForeground(Color.WHITE);
								 						 		lblNewLabel_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 						 		lblNewLabel_4_3.setBounds(10, 208, 215, 48);
								 						 		pnlDashboard.add(lblNewLabel_4_3);
								 						 		
								 						 		JLabel lblNewLabel_8 = new JLabel("");
								 						 		lblNewLabel_8.setBackground(new Color(36, 46, 50));
								 						 		lblNewLabel_8.setOpaque(true);
								 						 		lblNewLabel_8.setBounds(10, 208, 215, 96);
								 						 		pnlDashboard.add(lblNewLabel_8);
								 						 		
								 						 		JLabel lblNewLabel_4_3_1 = new JLabel("NUMBER OF INFANTS");
								 						 		lblNewLabel_4_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_1.setForeground(Color.WHITE);
								 						 		lblNewLabel_4_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 						 		lblNewLabel_4_3_1.setBounds(232, 208, 215, 48);
								 						 		pnlDashboard.add(lblNewLabel_4_3_1);
								 						 		
								 						 		JLabel lblNewLabel_8_1 = new JLabel("");
								 						 		lblNewLabel_8_1.setOpaque(true);
								 						 		lblNewLabel_8_1.setBackground(new Color(36, 46, 50));
								 						 		lblNewLabel_8_1.setBounds(232, 208, 215, 96);
								 						 		pnlDashboard.add(lblNewLabel_8_1);
								 						 		
								 						 		JLabel lblNewLabel_4_3_1_1 = new JLabel("NUMBER OF PREGNANTS");
								 						 		lblNewLabel_4_3_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_1_1.setForeground(Color.WHITE);
								 						 		lblNewLabel_4_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 						 		lblNewLabel_4_3_1_1.setBounds(457, 208, 215, 48);
								 						 		pnlDashboard.add(lblNewLabel_4_3_1_1);
								 						 		
								 						 		JLabel lblNewLabel_5_4 = new JLabel("");
								 						 		lblNewLabel_5_4.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_pregnant_woman_white_24dp.png"));
								 						 		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_5_4.setBounds(521, 248, 48, 48);
								 						 		pnlDashboard.add(lblNewLabel_5_4);
								 						 		
								 						 		JLabel lblNewLabel_8_1_1 = new JLabel("");
								 						 		lblNewLabel_8_1_1.setOpaque(true);
								 						 		lblNewLabel_8_1_1.setBackground(new Color(36, 46, 50));
								 						 		lblNewLabel_8_1_1.setBounds(457, 208, 215, 96);
								 						 		pnlDashboard.add(lblNewLabel_8_1_1);
								 						 		
								 						 		JLabel lblNewLabel_4_3_2 = new JLabel("NUMBER OF MEDICINES");
								 						 		lblNewLabel_4_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_2.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_2.setForeground(Color.WHITE);
								 						 		lblNewLabel_4_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 						 		lblNewLabel_4_3_2.setBounds(10, 428, 215, 48);
								 						 		pnlDashboard.add(lblNewLabel_4_3_2);
								 						 		
								 						 		JLabel lblNewLabel_6_1 = new JLabel("");
								 						 		lblNewLabel_6_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_medication_white_24dp.png"));
								 						 		lblNewLabel_6_1.setVerticalAlignment(SwingConstants.TOP);
								 						 		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_6_1.setBounds(64, 468, 48, 48);
								 						 		pnlDashboard.add(lblNewLabel_6_1);
								 						 		
								 						 		JLabel lblNewLabel_8_2 = new JLabel("");
								 						 		lblNewLabel_8_2.setOpaque(true);
								 						 		lblNewLabel_8_2.setBackground(new Color(36, 46, 50));
								 						 		lblNewLabel_8_2.setBounds(10, 428, 215, 96);
								 						 		pnlDashboard.add(lblNewLabel_8_2);
								 						 		
								 						 		JLabel lblNewLabel_4_3_2_1 = new JLabel("EXPIRED MEDICINES");
								 						 		lblNewLabel_4_3_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_2_1.setForeground(Color.WHITE);
								 						 		lblNewLabel_4_3_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 						 		lblNewLabel_4_3_2_1.setBounds(232, 428, 215, 48);
								 						 		pnlDashboard.add(lblNewLabel_4_3_2_1);
								 						 		
								 						 		JLabel lblNewLabel_6_1_1 = new JLabel("");
								 						 		lblNewLabel_6_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_event_busy_white_24dp.png"));
								 						 		lblNewLabel_6_1_1.setVerticalAlignment(SwingConstants.TOP);
								 						 		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_6_1_1.setBounds(291, 468, 48, 48);
								 						 		pnlDashboard.add(lblNewLabel_6_1_1);
								 						 		
								 						 		JLabel lblNewLabel_8_2_1 = new JLabel("");
								 						 		lblNewLabel_8_2_1.setOpaque(true);
								 						 		lblNewLabel_8_2_1.setBackground(new Color(36, 46, 50));
								 						 		lblNewLabel_8_2_1.setBounds(232, 428, 215, 96);
								 						 		pnlDashboard.add(lblNewLabel_8_2_1);
								 						 		
								 						 		JLabel lblNewLabel_4_3_2_1_1 = new JLabel("OUT OF STOCK");
								 						 		lblNewLabel_4_3_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_4_3_2_1_1.setForeground(Color.WHITE);
								 						 		lblNewLabel_4_3_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 						 		lblNewLabel_4_3_2_1_1.setBounds(457, 428, 215, 48);
								 						 		pnlDashboard.add(lblNewLabel_4_3_2_1_1);
								 						 		
								 						 		JLabel lblNumExpMed_1 = new JLabel(stock);
								 						 		lblNumExpMed_1.setVerticalAlignment(SwingConstants.BOTTOM);
								 						 		lblNumExpMed_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 						 		lblNumExpMed_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNumExpMed_1.setForeground(Color.WHITE);
								 						 		lblNumExpMed_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 						 		lblNumExpMed_1.setBounds(579, 475, 34, 41);
								 						 		pnlDashboard.add(lblNumExpMed_1);
								 						 		
								 						 		JLabel lblNewLabel_6_1_1_1 = new JLabel("");
								 						 		lblNewLabel_6_1_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_production_quantity_limits_white_24dp.png"));
								 						 		lblNewLabel_6_1_1_1.setVerticalAlignment(SwingConstants.TOP);
								 						 		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 						 		lblNewLabel_6_1_1_1.setBounds(521, 468, 48, 48);
								 						 		pnlDashboard.add(lblNewLabel_6_1_1_1);
								 						 		
								 						 		JLabel lblNewLabel_8_2_1_1 = new JLabel("");
								 						 		lblNewLabel_8_2_1_1.setOpaque(true);
								 						 		lblNewLabel_8_2_1_1.setBackground(new Color(36, 46, 50));
								 						 		lblNewLabel_8_2_1_1.setBounds(457, 428, 215, 96);
								 						 		pnlDashboard.add(lblNewLabel_8_2_1_1);
								 				pnlVaccine.setBounds(249, 0, 689, 608);
								 				contentPane.add(pnlVaccine);
								 				pnlVaccine.setLayout(null);
								 				pnlVaccine.setBackground(new Color(74, 94, 104));
								 				
								 				JButton btnRegVac = new JButton("INFANT REGISTRATION");
								 				btnRegVac.setForeground(new Color(255, 255, 255));
								 				btnRegVac.setBackground(new Color(36, 46, 50));
								 				btnRegVac.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 				btnRegVac.setBorder(null);
								 				btnRegVac.addActionListener(new ActionListener() {
								 					public void actionPerformed(ActionEvent e) {
								 						vacRegistration vac = new vacRegistration();
								 						dispose();
								 						vac.setVisible(true);
								 					}
								 				});
								 				btnRegVac.setBounds(369, 372, 221, 77);
								 				pnlVaccine.add(btnRegVac);
								 				
								 				JButton btnViewInformation = new JButton("INFANT INFORMATION");
								 				btnViewInformation.setForeground(new Color(255, 255, 255));
								 				btnViewInformation.setBackground(new Color(36, 46, 50));
								 				btnViewInformation.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 				btnViewInformation.setBorder(null);
								 				btnViewInformation.addActionListener(new ActionListener() {
								 					public void actionPerformed(ActionEvent e) {
								 						babyVaccine vac = new babyVaccine();
								 						dispose();
								 						vac.setVisible(true);
								 					}
								 				});
								 				btnViewInformation.setBounds(113, 372, 221, 77);
								 				pnlVaccine.add(btnViewInformation);
								 				
								 				JLabel lblNewLabel_1_1_1_2 = new JLabel("INFANT VACCINATION");
								 				lblNewLabel_1_1_1_2.setIconTextGap(15);
								 				lblNewLabel_1_1_1_2.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_child_care_white_18dp.png"));
								 				lblNewLabel_1_1_1_2.setOpaque(true);
								 				lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
								 				lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
								 				lblNewLabel_1_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 30));
								 				lblNewLabel_1_1_1_2.setBackground(new Color(36, 46, 50));
								 				lblNewLabel_1_1_1_2.setBounds(113, 324, 477, 37);
								 				pnlVaccine.add(lblNewLabel_1_1_1_2);
								 				
								 				lblDate_2 = new JLabel("DATE");
								 				lblDate_2.setHorizontalTextPosition(SwingConstants.LEFT);
								 				lblDate_2.setHorizontalAlignment(SwingConstants.LEFT);
								 				lblDate_2.setForeground(Color.WHITE);
								 				lblDate_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
								 				lblDate_2.setBounds(113, 74, 253, 62);
								 				pnlVaccine.add(lblDate_2);
								 				
								 				lblTime_2 = new JLabel("10:28:15 pm");
								 				lblTime_2.setHorizontalTextPosition(SwingConstants.RIGHT);
								 				lblTime_2.setHorizontalAlignment(SwingConstants.RIGHT);
								 				lblTime_2.setForeground(Color.WHITE);
								 				lblTime_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
								 				lblTime_2.setBounds(364, 74, 226, 62);
								 				pnlVaccine.add(lblTime_2);
								 				
								 				JLabel lblNewLabel = new JLabel("");
								 				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\Test.png"));
								 				lblNewLabel.setBounds(0, 147, 689, 166);
								 				pnlVaccine.add(lblNewLabel);
								 				
								 				JPanel panel_1 = new JPanel();
								 				panel_1.setBackground(new Color(36, 46, 50));
								 				panel_1.setBounds(0, 0, 250, 608);
								 				contentPane.add(panel_1);
								 				panel_1.setLayout(null);
								 				
								 				btnRecord = new JButton("VIEW RECORDS");
								 				
								 				btnRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 				btnRecord.setRequestFocusEnabled(false);
								 				btnRecord.setFocusable(false);
								 				btnRecord.setIconTextGap(0);
								 				btnRecord.setToolTipText("View transaction records");
								 				btnRecord.setForeground(Color.WHITE);
								 				btnRecord.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
								 				btnRecord.setBorder(null);
								 				btnRecord.setBackground(new Color(36, 46, 50));
								 				btnRecord.setBounds(0, 339, 250, 63);
								 				panel_1.add(btnRecord);
								 				
								 				btnMedicine = new JButton("MEDICINE");
								 				btnMedicine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 				btnMedicine.setRequestFocusEnabled(false);
								 				btnMedicine.setFocusable(false);
								 				btnMedicine.setIconTextGap(0);
								 				btnMedicine.setBounds(0, 191, 250, 63);
								 				panel_1.add(btnMedicine);
								 				btnMedicine.setToolTipText("View or Handout Medicines");
								 				btnMedicine.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
								 				btnMedicine.setForeground(Color.WHITE);
								 				btnMedicine.setBackground(new Color(36, 46, 50));
								 				
								 						btnMedicine.setBorder(null);
								 						
								 						btnResidents = new JButton("RESIDENT");
								 						btnResidents.addMouseListener(new MouseAdapter() {
								 							@Override
								 							public void mouseClicked(MouseEvent e) {
								 								btnResidents.setBackground(new Color(25, 31, 34));
								 								btnResidents.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
		
			            
								 								btnMedicine.setBackground(new Color(36, 46, 50));
								 								btnRecord.setBackground(new Color(36, 46, 50));
								 								btnVaccine.setBackground(new Color(36, 46, 50));
								 								btnLogout.setBackground(new Color(36, 46, 50));
								 								btnMedicine.setBorder(null);
								 								btnRecord.setBorder(null);
								 								btnVaccine.setBorder(null);
								 								btnLogout.setBorder(null);
								 							}
								 						});
								 						
								 										btnResidents.setBorder(null);
								 										btnResidents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 										btnResidents.setRequestFocusEnabled(false);
								 										btnResidents.setFocusable(false);
								 										btnResidents.setIconTextGap(0);
								 										btnResidents.setToolTipText("Add resident.");
								 										btnResidents.setBounds(0, 117, 250, 63);
								 										panel_1.add(btnResidents);
								 										btnResidents.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
								 										btnResidents.setForeground(Color.WHITE);
								 										
								 														btnResidents.setBackground(new Color(36, 46, 50));
								 														
								 															btnResidents.addActionListener(new ActionListener() {
								 																public void actionPerformed(ActionEvent e) {
								 																	pnlResident.setVisible(true);
								 																	pnlDashboard.setVisible(false);
								 																	pnlMedicine.setVisible(false);
								 																	pnlVaccine.setVisible(false);
								 																   pnlRecords.setVisible(false);
								 																	
								 																}
								 															});
								 															btnResidents.setActionCommand("\r\nREGISTER RESIDENT");
								 															
								 															JButton btnNewButton_1 = new JButton("DASHBOARD");
								 															btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
								 															btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 															btnNewButton_1.setRequestFocusEnabled(false);
								 															btnNewButton_1.setOpaque(false);
								 															btnNewButton_1.setToolTipText("See dashboard.");
								 															btnNewButton_1.setBackground(Color.DARK_GRAY);
								 															btnNewButton_1.setBorderPainted(false);
								 															btnNewButton_1.setFocusable(false);
								 															btnNewButton_1.setFocusTraversalKeysEnabled(false);
								 															btnNewButton_1.setFocusPainted(false);
								 															
								 															btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_dashboard_white_36dp.png"));
								 															btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 28));
								 															btnNewButton_1.setForeground(Color.WHITE);
								 															btnNewButton_1.setBorder(null);
								 															btnNewButton_1.setBounds(0, 32, 250, 74);
								 															panel_1.add(btnNewButton_1);
								 															
								 															btnVaccine = new JButton("VACCINATION");
								 															btnVaccine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 															btnVaccine.setRequestFocusEnabled(false);
								 															btnVaccine.setFocusable(false);
								 															btnVaccine.setIconTextGap(0);
								 															
								 																			btnVaccine.setToolTipText("MEDICINE PRESCRIPTION");
								 																			btnVaccine.setForeground(Color.WHITE);
								 																			btnVaccine.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
								 																			btnVaccine.setBorder(null);
								 																			btnVaccine.setBackground(new Color(36, 46, 50));
								 																			btnVaccine.setBounds(0, 265, 250, 63);
								 																			panel_1.add(btnVaccine);
								 																			
								 																			btnLogout = new JButton("LOGOUT");
								 																			btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 																			btnLogout.setRequestFocusEnabled(false);
								 																			btnLogout.setFocusable(false);
								 																			btnLogout.addActionListener(new ActionListener() {
								 																				public void actionPerformed(ActionEvent e) {
								 																					
								 																					btnLogout.setBackground(new Color(25, 31, 34));
								 																					btnLogout.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));

			            
								 																					btnResidents.setBackground(new Color(36, 46, 50) );
								 																					btnRecord.setBackground(new Color(36, 46, 50 ));
								 																					btnMedicine.setBackground(new Color(36, 46, 50 ));
								 																					btnVaccine.setBackground(new Color(36, 46, 50 ));
								 																					btnResidents.setBorder(null);
								 																					btnRecord.setBorder(null);
								 																					btnMedicine.setBorder(null);
								 																					btnVaccine.setBorder(null);
								 																					int sel = JOptionPane.showConfirmDialog(null, "Do you want to logout?","Logout Employee", JOptionPane.YES_NO_OPTION);
								 																					if(sel==0) {
								 																						dispose();
								 																						loginForm login = new loginForm();
								 																						login.setVisible(true);
								 																					}else {
								 																						btnLogout.setBackground(new Color(36, 46, 50 ));
								 																						btnResidents.setBackground(new Color(36, 46, 50 ));
								 																						btnRecord.setBackground(new Color(36, 46, 50 ));
								 																						btnMedicine.setBackground(new Color(36, 46, 50 ));
								 																						btnVaccine.setBackground(new Color(36, 46, 50 ));
								 																						btnResidents.setBorder(null);
								 																						btnRecord.setBorder(null);
								 																						btnMedicine.setBorder(null);
								 																						btnLogout.setBorder(null);
								 																						btnVaccine.setBorder(null);
								 																						
								 																					}
								 																				}
								 																			});
								 																			btnLogout.setToolTipText("Return to login form.");
								 																			btnLogout.setIconTextGap(0);
								 																			btnLogout.setForeground(Color.WHITE);
								 																			btnLogout.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
								 																			btnLogout.setBorder(null);
								 																			btnLogout.setBackground(new Color(36, 46, 50));
								 																			btnLogout.setBounds(0, 413, 250, 63);
								 																			panel_1.add(btnLogout);
								 																					 						 		
								 																					 						 		pnlResident = new JPanel();
								 																					 						 		pnlResident.setVisible(false);
								 																					 						 		pnlResident.setBackground(new Color(74, 94, 104));
								 																					 						 		pnlResident.setBounds(249, 0, 689, 608);
								 																					 						 		contentPane.add(pnlResident);
								 																					 						 		pnlResident.setLayout(null);
								 																					 						 		
								 																					 						 		lblTimeRes = new JLabel("05:26:49 pm");
								 																					 						 		lblTimeRes.setHorizontalTextPosition(SwingConstants.RIGHT);
								 																					 						 		lblTimeRes.setForeground(Color.WHITE);
								 																					 						 		lblTimeRes.setHorizontalAlignment(SwingConstants.RIGHT);
								 																					 						 		lblTimeRes.setFont(new Font("Segoe UI Light", Font.BOLD, 40));
								 																					 						 		lblTimeRes.setBounds(345, 107, 248, 62);
								 																					 						 		pnlResident.add(lblTimeRes);
								 																					 						 		
								 																					 						 		lblDateRes = new JLabel("DATE");
								 																					 						 		lblDateRes.setHorizontalTextPosition(SwingConstants.LEFT);
								 																					 						 		lblDateRes.setForeground(Color.WHITE);
								 																					 						 		lblDateRes.setHorizontalAlignment(SwingConstants.LEFT);
								 																					 						 		lblDateRes.setFont(new Font("Segoe UI Light", Font.BOLD, 40));
								 																					 						 		lblDateRes.setBounds(115, 107, 295, 62);
								 																					 						 		pnlResident.add(lblDateRes);
								 																					 						 		
								 																					 						 		JButton btnViewRes = new JButton("VIEW RESIDENTS");
								 																					 						 		btnViewRes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 																					 						 		btnViewRes.addActionListener(new ActionListener() {
								 																					 						 			public void actionPerformed(ActionEvent e) {
								 																					 						 				dispose();
								 																					 						 				viewResident view = new viewResident();
								 																					 						 				view.setVisible(true);
								 																					 						 			}
								 																					 						 		});
								 																					 						 		btnViewRes.setForeground(Color.WHITE);
								 																					 						 		btnViewRes.setFont(new Font("SansSerif", Font.PLAIN, 18));
								 																					 						 		btnViewRes.setBorder(null);
								 																					 						 		btnViewRes.setBackground(new Color(36, 46, 50));
								 																					 						 		btnViewRes.setBounds(115, 423, 221, 77);
								 																					 						 		pnlResident.add(btnViewRes);
								 																					 						 		
								 																					 						 		JButton btnRegisterResidents = new JButton("REGISTER RESIDENTS");
								 																					 						 		btnRegisterResidents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 																					 						 		btnRegisterResidents.addActionListener(new ActionListener() {
								 																					 						 			public void actionPerformed(ActionEvent e) {
								 																					 						 				dispose();
								 																					 						 				registerResidentForm regForm = new registerResidentForm();
								 																					 						 				regForm.setVisible(true);
								 																					 						 			}
								 																					 						 		});
								 																					 						 		btnRegisterResidents.setForeground(Color.WHITE);
								 																					 						 		btnRegisterResidents.setFont(new Font("SansSerif", Font.PLAIN, 18));
								 																					 						 		btnRegisterResidents.setBorder(null);
								 																					 						 		btnRegisterResidents.setBackground(new Color(36, 46, 50));
								 																					 						 		btnRegisterResidents.setBounds(372, 423, 221, 77);
								 																					 						 		pnlResident.add(btnRegisterResidents);
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_1_1_1_1 = new JLabel("POPULATIONS");
								 																					 						 		lblNewLabel_1_1_1_1.setOpaque(true);
								 																					 						 		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
								 																					 						 		lblNewLabel_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 28));
								 																					 						 		lblNewLabel_1_1_1_1.setBackground(new Color(36, 46, 50));
								 																					 						 		lblNewLabel_1_1_1_1.setBounds(115, 207, 480, 37);
								 																					 						 		pnlResident.add(lblNewLabel_1_1_1_1);
								 																					 						 		
								 																					 						 		JLabel lblNoRes_1 = new JLabel("09");
								 																					 						 		lblNoRes_1.setForeground(Color.WHITE);
								 																					 						 		lblNoRes_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNoRes_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNoRes_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblNoRes_1.setBounds(120, 328, 34, 28);
								 																					 						 		pnlResident.add(lblNoRes_1);
								 																					 						 		
								 																					 						 		JLabel lblNoBabies_1 = new JLabel("01");
								 																					 						 		lblNoBabies_1.setForeground(Color.WHITE);
								 																					 						 		lblNoBabies_1.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 		lblNoBabies_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNoBabies_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblNoBabies_1.setBounds(346, 322, 34, 41);
								 																					 						 		pnlResident.add(lblNoBabies_1);
								 																					 						 		
								 																					 						 		JLabel lblPregnant_1 = new JLabel("00");
								 																					 						 		lblPregnant_1.setForeground(Color.WHITE);
								 																					 						 		lblPregnant_1.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 		lblPregnant_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblPregnant_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblPregnant_1.setBounds(573, 322, 34, 41);
								 																					 						 		pnlResident.add(lblPregnant_1);
								 																					 						 		lblNoRes_1.setText(String.valueOf(formattedNum));
								 																					 						 		lblNoBabies_1.setText(String.valueOf(format));
								 																					 						 		lblPregnant_1.setText(String.valueOf(formatN));
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_4_3_2_2_2 = new JLabel("NUMBER OF RESIDENTS");
								 																					 						 		lblNewLabel_4_3_2_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_4_3_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_4_3_2_2_2.setForeground(Color.WHITE);
								 																					 						 		lblNewLabel_4_3_2_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 																					 						 		lblNewLabel_4_3_2_2_2.setBounds(10, 275, 215, 48);
								 																					 						 		pnlResident.add(lblNewLabel_4_3_2_2_2);
								 																					 						 		
								 																					 						 		JLabel lblNumMed_1_1 = new JLabel("");
								 																					 						 		lblNumMed_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_groups_white_24dp.png"));
								 																					 						 		lblNumMed_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNumMed_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNumMed_1_1.setForeground(Color.WHITE);
								 																					 						 		lblNumMed_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblNumMed_1_1.setBounds(62, 328, 48, 28);
								 																					 						 		pnlResident.add(lblNumMed_1_1);
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_8_4_2 = new JLabel("");
								 																					 						 		lblNewLabel_8_4_2.setOpaque(true);
								 																					 						 		lblNewLabel_8_4_2.setBackground(new Color(36, 46, 50));
								 																					 						 		lblNewLabel_8_4_2.setBounds(10, 275, 215, 96);
								 																					 						 		pnlResident.add(lblNewLabel_8_4_2);
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_4_3_2_2_2_1 = new JLabel("NUMBER OF INFANTS");
								 																					 						 		lblNewLabel_4_3_2_2_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_4_3_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_4_3_2_2_2_1.setForeground(Color.WHITE);
								 																					 						 		lblNewLabel_4_3_2_2_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 																					 						 		lblNewLabel_4_3_2_2_2_1.setBounds(235, 275, 215, 48);
								 																					 						 		pnlResident.add(lblNewLabel_4_3_2_2_2_1);
								 																					 						 		
								 																					 						 		JLabel lblNumMed_1_1_1 = new JLabel("");
								 																					 						 		lblNumMed_1_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_child_friendly_white_24dp.png"));
								 																					 						 		lblNumMed_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNumMed_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNumMed_1_1_1.setForeground(Color.WHITE);
								 																					 						 		lblNumMed_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblNumMed_1_1_1.setBounds(288, 315, 48, 48);
								 																					 						 		pnlResident.add(lblNumMed_1_1_1);
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_8_4_2_1 = new JLabel("");
								 																					 						 		lblNewLabel_8_4_2_1.setOpaque(true);
								 																					 						 		lblNewLabel_8_4_2_1.setBackground(new Color(36, 46, 50));
								 																					 						 		lblNewLabel_8_4_2_1.setBounds(235, 275, 215, 96);
								 																					 						 		pnlResident.add(lblNewLabel_8_4_2_1);
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_4_3_2_2_2_1_1 = new JLabel("NUMBER OF PREGNANTS");
								 																					 						 		lblNewLabel_4_3_2_2_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_4_3_2_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_4_3_2_2_2_1_1.setForeground(Color.WHITE);
								 																					 						 		lblNewLabel_4_3_2_2_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 																					 						 		lblNewLabel_4_3_2_2_2_1_1.setBounds(460, 275, 215, 48);
								 																					 						 		pnlResident.add(lblNewLabel_4_3_2_2_2_1_1);
								 																					 						 		
								 																					 						 		JLabel lblNumMed_1_1_1_1 = new JLabel("");
								 																					 						 		lblNumMed_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_pregnant_woman_white_24dp.png"));
								 																					 						 		lblNumMed_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNumMed_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNumMed_1_1_1_1.setForeground(Color.WHITE);
								 																					 						 		lblNumMed_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblNumMed_1_1_1_1.setBounds(529, 315, 34, 48);
								 																					 						 		pnlResident.add(lblNumMed_1_1_1_1);
								 																					 						 		
								 																					 						 		JLabel lblNewLabel_8_4_2_1_1 = new JLabel("");
								 																					 						 		lblNewLabel_8_4_2_1_1.setOpaque(true);
								 																					 						 		lblNewLabel_8_4_2_1_1.setBackground(new Color(36, 46, 50));
								 																					 						 		lblNewLabel_8_4_2_1_1.setBounds(460, 275, 215, 96);
								 																					 						 		pnlResident.add(lblNewLabel_8_4_2_1_1);
								 																					 						 		
								 																					 						 		pnlMedicine = new JPanel();
								 																					 						 		pnlMedicine.setBorder(null);
								 																					 						 		pnlMedicine.setBackground(new Color(74, 94, 104));
								 																					 						 		pnlMedicine.setBounds(249, 0, 689, 608);
								 																					 						 		contentPane.add(pnlMedicine);
								 																					 						 		pnlMedicine.setLayout(null);
								 																					 						 		pnlMedicine.setVisible(false);
								 																					 						 		JLabel lblNewLabel_1_1_1 = new JLabel("MEDICINES");
								 																					 						 		lblNewLabel_1_1_1.setOpaque(true);
								 																					 						 		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNewLabel_1_1_1.setForeground(Color.WHITE);
								 																					 						 		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 30));
								 																					 						 		lblNewLabel_1_1_1.setBackground(new Color(36, 46, 50));
								 																					 						 		lblNewLabel_1_1_1.setBounds(116, 207, 477, 37);
								 																					 						 		pnlMedicine.add(lblNewLabel_1_1_1);
								 																					 						 		
								 																					 						 		JLabel lblNumMed = new JLabel("##");
								 																					 						 		lblNumMed.setForeground(Color.WHITE);
								 																					 						 		lblNumMed.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 		lblNumMed.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblNumMed.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblNumMed.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblNumMed.setBounds(118, 321, 34, 41);
								 																					 						 		pnlMedicine.add(lblNumMed);
								 																					 						 		lblNumMed.setText(String.valueOf(numMedFormat));
								 																					 						 		
								 																					 						 		lblExpMed = new JLabel("0");
								 																					 						 		lblExpMed.setForeground(Color.WHITE);
								 																					 						 		lblExpMed.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 		lblExpMed.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 		lblExpMed.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 		lblExpMed.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 		lblExpMed.setBounds(574, 321, 34, 41);
								 																					 						 		pnlMedicine.add(lblExpMed);
								 																					 						 		
								 																					 						 		JButton btnNewButton_2 = new JButton("VIEW MEDICINES");
								 																					 						 		btnNewButton_2.setRequestFocusEnabled(false);
								 																					 						 		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 																					 						 		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
								 																					 						 		btnNewButton_2.setForeground(Color.WHITE);
								 																					 						 		btnNewButton_2.setBackground(new Color(36, 46, 50));
								 																					 						 		btnNewButton_2.setBorder(null);
								 																					 						 		btnNewButton_2.addActionListener(new ActionListener() {
								 																					 						 			public void actionPerformed(ActionEvent e) {
								 																					 						 				dispose();
								 																					 						 				viewMedicines viewMed = new viewMedicines();
								 																					 						 				viewMed.setVisible(true);
								 																					 						 			}
								 																					 						 		});
								 																					 						 		btnNewButton_2.setBounds(116, 423, 221, 77);
								 																					 						 		pnlMedicine.add(btnNewButton_2);
								 																					 						 		
								 																					 						 		JButton btnHandOutMed = new JButton("HAND OUT MEDICINE");
								 																					 						 		btnHandOutMed.setRequestFocusEnabled(false);
								 																					 						 		btnHandOutMed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								 																					 						 		
								 																					 						 				btnHandOutMed.setForeground(Color.WHITE);
								 																					 						 				btnHandOutMed.setFont(new Font("SansSerif", Font.PLAIN, 18));
								 																					 						 				btnHandOutMed.setBorder(null);
								 																					 						 				btnHandOutMed.setBackground(new Color(36, 46, 50));
								 																					 						 				btnHandOutMed.setBounds(372, 423, 221, 77);
								 																					 						 				pnlMedicine.add(btnHandOutMed);
								 																					 						 				
								 																					 						 				JLabel lblOutOfStock = new JLabel("0");
								 																					 						 				lblOutOfStock.setForeground(Color.WHITE);
								 																					 						 				lblOutOfStock.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 				lblOutOfStock.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblOutOfStock.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblOutOfStock.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 				lblOutOfStock.setBounds(349, 321, 34, 41);
								 																					 						 				pnlMedicine.add(lblOutOfStock);
								 																					 						 				lblOutOfStock.setText(stock);
								 																					 						 				
								 																					 						 				lblDate_1 = new JLabel("DATE");
								 																					 						 				lblDate_1.setHorizontalTextPosition(SwingConstants.LEFT);
								 																					 						 				lblDate_1.setForeground(Color.WHITE);
								 																					 						 				lblDate_1.setHorizontalAlignment(SwingConstants.LEFT);
								 																					 						 				lblDate_1.setFont(new Font("Segoe UI Light", Font.BOLD, 40));
								 																					 						 				lblDate_1.setBounds(116, 105, 311, 62);
								 																					 						 				pnlMedicine.add(lblDate_1);
								 																					 						 				
								 																					 						 				lblTime_1 = new JLabel("05:26:49 pm");
								 																					 						 				lblTime_1.setHorizontalTextPosition(SwingConstants.RIGHT);
								 																					 						 				lblTime_1.setForeground(Color.WHITE);
								 																					 						 				lblTime_1.setHorizontalAlignment(SwingConstants.RIGHT);
								 																					 						 				lblTime_1.setFont(new Font("Segoe UI Light", Font.BOLD, 40));
								 																					 						 				lblTime_1.setBounds(358, 105, 235, 62);
								 																					 						 				pnlMedicine.add(lblTime_1);
								 																					 						 				
								 																					 						 				JLabel lblNewLabel_4_3_2_2 = new JLabel("NUMBER OF MEDICINES");
								 																					 						 				lblNewLabel_4_3_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblNewLabel_4_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblNewLabel_4_3_2_2.setForeground(Color.WHITE);
								 																					 						 				lblNewLabel_4_3_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 																					 						 				lblNewLabel_4_3_2_2.setBounds(10, 274, 215, 48);
								 																					 						 				pnlMedicine.add(lblNewLabel_4_3_2_2);
								 																					 						 				
								 																					 						 				JLabel lblNumMed_1 = new JLabel("");
								 																					 						 				lblNumMed_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_medication_white_24dp.png"));
								 																					 						 				lblNumMed_1.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 				lblNumMed_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblNumMed_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblNumMed_1.setForeground(Color.WHITE);
								 																					 						 				lblNumMed_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 				lblNumMed_1.setBounds(74, 321, 34, 41);
								 																					 						 				pnlMedicine.add(lblNumMed_1);
								 																					 						 				
								 																					 						 				JLabel lblNewLabel_8_4 = new JLabel("");
								 																					 						 				lblNewLabel_8_4.setOpaque(true);
								 																					 						 				lblNewLabel_8_4.setBackground(new Color(36, 46, 50));
								 																					 						 				lblNewLabel_8_4.setBounds(10, 274, 215, 96);
								 																					 						 				pnlMedicine.add(lblNewLabel_8_4);
								 																					 						 				
								 																					 						 				JLabel lblNewLabel_4_3_2_2_1 = new JLabel("OUT OF STOCK");
								 																					 						 				lblNewLabel_4_3_2_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblNewLabel_4_3_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblNewLabel_4_3_2_2_1.setForeground(Color.WHITE);
								 																					 						 				lblNewLabel_4_3_2_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 																					 						 				lblNewLabel_4_3_2_2_1.setBounds(235, 274, 215, 48);
								 																					 						 				pnlMedicine.add(lblNewLabel_4_3_2_2_1);
								 																					 						 				
								 																					 						 				JLabel lblOutOfStock_1 = new JLabel("");
								 																					 						 				lblOutOfStock_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_production_quantity_limits_white_24dp.png"));
								 																					 						 				lblOutOfStock_1.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 				lblOutOfStock_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblOutOfStock_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblOutOfStock_1.setForeground(Color.WHITE);
								 																					 						 				lblOutOfStock_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 				lblOutOfStock_1.setBounds(305, 321, 34, 41);
								 																					 						 				pnlMedicine.add(lblOutOfStock_1);
								 																					 						 				
								 																					 						 				JLabel lblNewLabel_8_4_1 = new JLabel("");
								 																					 						 				lblNewLabel_8_4_1.setOpaque(true);
								 																					 						 				lblNewLabel_8_4_1.setBackground(new Color(36, 46, 50));
								 																					 						 				lblNewLabel_8_4_1.setBounds(235, 274, 215, 96);
								 																					 						 				pnlMedicine.add(lblNewLabel_8_4_1);
								 																					 						 				
								 																					 						 				JLabel lblNewLabel_4_3_2_2_1_1 = new JLabel("EXPIRED MEDICINES");
								 																					 						 				lblNewLabel_4_3_2_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblNewLabel_4_3_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblNewLabel_4_3_2_2_1_1.setForeground(Color.WHITE);
								 																					 						 				lblNewLabel_4_3_2_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								 																					 						 				lblNewLabel_4_3_2_2_1_1.setBounds(460, 274, 215, 48);
								 																					 						 				pnlMedicine.add(lblNewLabel_4_3_2_2_1_1);
								 																					 						 				
								 																					 						 				JLabel lblOutOfStock_1_1 = new JLabel("");
								 																					 						 				lblOutOfStock_1_1.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_event_busy_white_24dp.png"));
								 																					 						 				lblOutOfStock_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
								 																					 						 				lblOutOfStock_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
								 																					 						 				lblOutOfStock_1_1.setHorizontalAlignment(SwingConstants.CENTER);
								 																					 						 				lblOutOfStock_1_1.setForeground(Color.WHITE);
								 																					 						 				lblOutOfStock_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
								 																					 						 				lblOutOfStock_1_1.setBounds(530, 321, 34, 41);
								 																					 						 				pnlMedicine.add(lblOutOfStock_1_1);
								 																					 						 				
								 																					 						 				JLabel lblNewLabel_8_4_1_1 = new JLabel("");
								 																					 						 				lblNewLabel_8_4_1_1.setOpaque(true);
								 																					 						 				lblNewLabel_8_4_1_1.setBackground(new Color(36, 46, 50));
								 																					 						 				lblNewLabel_8_4_1_1.setBounds(460, 274, 215, 96);
								 																					 						 				pnlMedicine.add(lblNewLabel_8_4_1_1);
								 																					 				btnHandOutMed.addActionListener(new ActionListener() {
								 																					 					public void actionPerformed(ActionEvent e) {
								 																					 						dispose();
								 																					 						handoutMed med = new handoutMed();
								 																					 						med.setVisible(true);
								 																					 					}
								 																					 				});
								 																			
								 																					btnVaccine.addActionListener(new ActionListener() {
								 																						public void actionPerformed(ActionEvent e) {
								 																							pnlVaccine.setVisible(true);
								 																							pnlResident.setVisible(false);
								 																							pnlMedicine.setVisible(false);
								 																							pnlDashboard.setVisible(false);
								 																						   pnlRecords.setVisible(false);
								 																							btnVaccine.setBackground(new Color(25, 31, 34));
								 																							btnVaccine.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
								 																			
								 																				            
								 																							btnResidents.setBackground(new Color(36, 46, 50 ));
								 																							btnRecord.setBackground(new Color(36, 46, 50 ));
								 																							btnMedicine.setBackground(new Color(36, 46, 50 ));
								 																							btnLogout.setBackground(new Color(36, 46, 50 ));
								 																							btnResidents.setBorder(null);
								 																							btnRecord.setBorder(null);
								 																							btnMedicine.setBorder(null);
								 																							btnLogout.setBorder(null);
								 																						}
								 																					});
								 																					btnNewButton_1.addActionListener(new ActionListener() {
								 																						public void actionPerformed(ActionEvent e) {
								 																							pnlDashboard.setVisible(true);
								 																							pnlMedicine.setVisible(false);
								 																							pnlVaccine.setVisible(false);
								 																							pnlResident.setVisible(false);
								 																							btnLogout.setBackground(new Color(36, 46, 50 ));
								 																							btnResidents.setBackground(new Color(36, 46, 50 ));
								 																							btnRecord.setBackground(new Color(36, 46, 50 ));
								 																							btnMedicine.setBackground(new Color(36, 46, 50 ));
								 																							btnVaccine.setBackground(new Color(36, 46, 50 ));
								 																							btnResidents.setBorder(null);
								 																							btnRecord.setBorder(null);
								 																							btnMedicine.setBorder(null);
								 																							btnLogout.setBorder(null);
								 																							btnVaccine.setBorder(null);
								 																							
								 																						}
								 																					});
								 																					btnMedicine.addActionListener(new ActionListener() {
								 																						public void actionPerformed(ActionEvent e) {
								 																							pnlMedicine.setVisible(true);
								 																							pnlDashboard.setVisible(false);
								 																							pnlVaccine.setVisible(false);
								 																							pnlResident.setVisible(false);
								 																					        pnlRecords.setVisible(false);
								 																							btnMedicine.setBackground(new Color(25, 31, 34));
								 																							btnMedicine.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));

	            
								 																							btnResidents.setBackground(new Color(36, 46, 50));
								 																							btnRecord.setBackground(new Color(36, 46, 50));
								 																							btnVaccine.setBackground(new Color(36, 46, 50));
								 																							btnLogout.setBackground(new Color(36, 46, 50));
								 																							btnResidents.setBorder(null);
								 																							btnRecord.setBorder(null);
								 																							btnVaccine.setBorder(null);
								 																							btnLogout.setBorder(null);
								 																						}
								 																					});
		initiateClock();
		checkExpiredMedicines();

			btnRecord.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRecord.setBackground(new Color(25, 31, 34));
						btnRecord.setBorder(new MatteBorder(0, 10, 0, 0, (Color) new Color(255, 255, 255)));
						pnlMedicine.setVisible(false);
						pnlDashboard.setVisible(false);
						pnlVaccine.setVisible(false);
						pnlResident.setVisible(false);
			            pnlRecords.setVisible(true);
						btnResidents.setBackground(new Color(36, 46, 50 ));
						btnVaccine.setBackground(new Color(36, 46, 50 ));
						btnMedicine.setBackground(new Color(36, 46, 50 ));
						btnLogout.setBackground(new Color(36, 46, 50 ));
						btnResidents.setBorder(null);
						btnVaccine.setBorder(null);
						btnMedicine.setBorder(null);
						btnLogout.setBorder(null);
					}
				});
			centerScreen();
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
						lblDate_1.setText(formattedDate);
						lblDate_2.setText(formattedDate);
						lblDate_2_1.setText(formattedDate);
						lblDateRes.setText(formattedDate);
						Date time = new Date();
						String timePattern ="hh:mm aaa";
						SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
						
						
						String newTime = timeFormat.format(time);
						lblTime.setText(newTime.toUpperCase());
						lblTime_1.setText(newTime.toUpperCase());
						lblTime_2.setText(newTime.toUpperCase());
						lblTime_2_1.setText(newTime.toUpperCase());
						lblTimeRes.setText(newTime.toUpperCase());
						sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		initiateClock.start();
		
		
		
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
	        lblExpMed.setText(expiredFormat);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
