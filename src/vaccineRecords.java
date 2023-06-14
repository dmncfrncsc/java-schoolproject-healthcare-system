import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class vaccineRecords extends JFrame {
	private DefaultTableModel tblVaccineRecordsModel;
	private JPanel contentPane;
	private JTable tblVaccineRecords;
	private JTextField txtSearch;
	private JPanel panel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vaccineRecords frame = new vaccineRecords();
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
	public vaccineRecords() {
		data Data = data.getInstance();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(74,94,104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 254, 698, 378);
		contentPane.add(scrollPane);
		
		tblVaccineRecords = new JTable();
		scrollPane.setViewportView(tblVaccineRecords);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSearch.getText().equals(null) || txtSearch.getText().equals("")) {
						Data.populateTblAllVacRecord();
						generateTableVaccineRecord(Data);
					}else {
						Data.searchVaccine(txtSearch.getText());
						generateTableVaccineRecord(Data);
				}
			}
		});
		txtSearch.setBounds(124, 191, 195, 32);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SEARCH:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 191, 104, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("VACCINE RECORD");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(36,46,50));
		lblNewLabel_1.setBounds(160, 49, 378, 56);
		contentPane.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(36,46,50));
		panel.setBounds(0, 0, 718, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeeFrame emp = new employeeFrame();
				emp.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(0, 0, 58, 38);
		panel.add(btnNewButton);
		
		JDateChooser dcFrom = new JDateChooser();
		dcFrom.setBounds(438, 168, 171, 32);
		contentPane.add(dcFrom);
		
		JLabel lblFrom = new JLabel("FROM:");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblFrom.setBounds(364, 168, 56, 32);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("UNTIL:");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblTo.setBounds(364, 211, 55, 32);
		contentPane.add(lblTo);
		
		JDateChooser dcUntil = new JDateChooser();
		dcUntil.setBounds(438, 211, 171, 32);
		contentPane.add(dcUntil);
		
		JButton btnNewButton_1 = new JButton("SHOW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				Date fromDate = dcFrom.getDate();
				Date untilDate = dcUntil.getDate();
				if(fromDate.after(untilDate)) {
	 				 JOptionPane.showMessageDialog(null, "Date values are invalid", "Invalid Values",JOptionPane.WARNING_MESSAGE);
				}else if(dcFrom.getDate().equals(null)||dcUntil.getDate().equals(null)) {
					JOptionPane.showMessageDialog(null, "Please input date", "Invalid Values",JOptionPane.WARNING_MESSAGE);
				}else{
					String fdate = simpleDateFormat.format(fromDate);
					String udate = simpleDateFormat.format(untilDate);
					Data.sortVaccineByDate(fdate, udate);
					generateTableVaccineRecord(Data);
					
				}
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(36, 46, 50));
		btnNewButton_1.setBounds(619, 185, 89, 41);
		contentPane.add(btnNewButton_1);
		Data.populateTblAllVacRecord();
		generateTableVaccineRecord(Data);
		 centerScreen();
	}
	
	public void generateTableVaccineRecord(data Data) {
		 centerScreen();
		String[] colsMenu = {"Infant Fullname ", "Vaccine name","Dozes","Date Vaccinated"};
		tblVaccineRecordsModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				return Object.class;
				}
			};
		
		List<allVaccineRecord> allVaccineRecord = Data.getAllVaccineRecordList();
		for(allVaccineRecord o: allVaccineRecord) {

			Object[] newRow = {o.getFullname(), o.getVacname(), o.getDozes(), o.getDatevaccinated()};
			tblVaccineRecordsModel.addRow(newRow);
		}
		tblVaccineRecords.setModel(tblVaccineRecordsModel);
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}