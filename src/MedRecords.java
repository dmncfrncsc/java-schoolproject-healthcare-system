import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

public class MedRecords extends JFrame {
	private DefaultTableModel tblMedicineRecordsModel;
	private JPanel contentPane;
	private JTable tblMedicineRecords;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MedRecords frame = new MedRecords();
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
	public MedRecords() {
		data Data = data.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(74,94,104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 698, 402);
		contentPane.add(scrollPane);
		
		tblMedicineRecords = new JTable();
		scrollPane.setViewportView(tblMedicineRecords);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtSearch.getText().equals(null) || txtSearch.getText().equals("")) {
						Data.populateTransactionRecords();
						generateMedicineRecord(Data);
					}else {
						Data.searchMediccine(txtSearch.getText());
						generateMedicineRecord(Data);
				}
			}
		});
		txtSearch.setBounds(94, 170, 171, 32);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH:");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 170, 74, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MEDICINE RECORDS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 36));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(36,46,50));
		lblNewLabel_1.setBounds(173, 57, 346, 58);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36,46,50));
		panel.setBounds(0, 0, 718, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeeFrame emp = new employeeFrame();
				emp.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(0, 0, 48, 46);
		panel.add(btnNewButton);
		
		JDateChooser dcFrom = new JDateChooser();
		dcFrom.setBounds(438, 144, 171, 32);
		contentPane.add(dcFrom);
		
		JDateChooser dcUntil = new JDateChooser();
		dcUntil.setBounds(438, 187, 171, 32);
		contentPane.add(dcUntil);
		
		JLabel lblTo = new JLabel("UNTIL:");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblTo.setBounds(364, 187, 55, 32);
		contentPane.add(lblTo);
		
		JLabel lblFrom = new JLabel("FROM:");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblFrom.setBounds(364, 144, 56, 32);
		contentPane.add(lblFrom);
		
		JButton btnNewButton_1 = new JButton("SHOW");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				Date fromDate = dcFrom.getDate();
				Date untilDate = dcUntil.getDate();
				
				if(fromDate.after(untilDate)) {
	 				 JOptionPane.showMessageDialog(null, "Date values are invalid", "Invalid Values",JOptionPane.WARNING_MESSAGE);
				}else if(dcFrom.getDate().equals(null)||dcUntil.getDate().equals(null)||dcFrom.getDate()==null||dcUntil.getDate()==null) {
					JOptionPane.showMessageDialog(null, "Please input date", "Invalid Values",JOptionPane.WARNING_MESSAGE);
				}else{
					String fdate = simpleDateFormat.format(fromDate);
					
					String udate = simpleDateFormat.format(untilDate);
					
					Data.sortMedByDate(fdate, udate);
					
					generateMedicineRecord(Data);
				
				}
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(36, 46, 50));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnNewButton_1.setBounds(619, 161, 89, 41);
		contentPane.add(btnNewButton_1);
		Data.populateTransactionRecords();
		generateMedicineRecord(Data);
		 centerScreen();
	
	}
	public void generateMedicineRecord(data Data) {
		 centerScreen() ;
		String[] colsMenu = {"Resident Fullname", "Brand Name","Generic Name","Measurement","Metric Measurement","Quantity","Transaction Date"};
		tblMedicineRecordsModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<transactionList> transList = Data.getTransList();
		for(transactionList o: transList) {
			Object[] newRow = {o.getResidentFullName(), o.getBrandName(), o.getGenericName(),o.getMeasurement(),o.getMetricMeasurement(), o.getQuantity(), o.getDate()};
			
			tblMedicineRecordsModel.addRow(newRow);
			
		}
		
		tblMedicineRecords.setModel(tblMedicineRecordsModel);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
