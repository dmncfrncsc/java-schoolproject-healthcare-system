import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.SwingConstants;

public class viewMedicines extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchMed;
	private JTable tblMedicines;
	private data Data;
	private DefaultTableModel tblMedicineModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMedicines frame = new viewMedicines();
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
	public viewMedicines() {
		Data = data.getInstance();

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 619);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(74,94,104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 128, 74, 27);
		contentPane.add(lblNewLabel);
		
		txtSearchMed = new JTextField();
		txtSearchMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txtSearchMed.setForeground(new Color(0, 0, 0));
		txtSearchMed.setBackground(new Color(255, 255, 255));
		txtSearchMed.setBorder(null);

		txtSearchMed.setBounds(94, 128, 164, 27);
		contentPane.add(txtSearchMed);
		txtSearchMed.setColumns(10);
		
		JLabel lblSortBy = new JLabel("SORT BY:");
		lblSortBy.setForeground(Color.WHITE);
		lblSortBy.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblSortBy.setBounds(290, 128, 77, 27);
		contentPane.add(lblSortBy);
		
		JComboBox cbSort = new JComboBox();
		cbSort.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		cbSort.setForeground(Color.WHITE);
		cbSort.setBackground(new Color(36,46,50));

		cbSort.setModel(new DefaultComboBoxModel(new String[] {"", "BRAND NAME", "GENERIC NAME", "CATEGORY", "MANUFACTURED DATE", "EXPIRATION DATE", "QUANTITY", "METRIC MEASUREMENT", "MEASUREMENT"}));
		cbSort.setBounds(377, 128, 137, 27);
		contentPane.add(cbSort);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(36,46,50));
		scrollPane.setBounds(10, 166, 675, 442);
		 scrollPane.getViewport().setBackground(new Color(36,46,50));
		 scrollPane.getViewport().setBorder(null);
		 scrollPane.getViewport().setRequestFocusEnabled(false);
		 
		 scrollPane.setBorder(null);
		 scrollPane.setOpaque(false);
		contentPane.add(scrollPane);
		
		tblMedicines = new JTable();
		tblMedicines.setForeground(Color.WHITE);
		tblMedicines.setRowSelectionAllowed(false);
		tblMedicines.setFocusable(false);
		tblMedicines.setFocusTraversalKeysEnabled(false);
		 tblMedicines.setSelectionBackground(Color.DARK_GRAY);
		 tblMedicines.setRequestFocusEnabled(false);
		 tblMedicines.setGridColor(new Color(74,94,104));
		 tblMedicines.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		 tblMedicines.setBackground(new Color(36,46,50));
		 tblMedicines.setForeground(new Color(255, 255, 255));
		 tblMedicines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		scrollPane.setViewportView(tblMedicines);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36,46,50));
		panel.setBounds(0, 0, 695, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employeeFrame emp = new employeeFrame();
				emp.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(0, 0, 38, 36);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("VIEW MEDICINES");
		lblNewLabel_1.setBackground(new Color(36,46,50));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(171, 46, 343, 49);
		
		contentPane.add(lblNewLabel_1);
		scrollPane.getViewport().setBackground(new Color(36,46,50 ));
		Data.populateTblMeds();
		generateMedicine(Data);
		txtSearchMed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtSearchMed.getText().equals(null)) {
					Data.populateTblMeds();
					generateMedicine(Data);
				}else {
					Data.searchMed(txtSearchMed.getText().toString());
			
					generateMedicine(Data);
				}
			}
		});
		cbSort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbSort.getSelectedItem().equals("")) {
					Data.populateTblMeds();
					generateMedicine(Data);
				}else {
					Data.medicineSort(cbSort.getSelectedItem().toString());
					generateMedicine(Data);
				}
			}
		});
		centerScreen();
	}
	
	public void generateMedicine(data Data) {
		centerScreen();
		String[] colsMenu = {"MedId", "BrandName","GenericName","Category","Measurement","Metric Measurement","Manufactured Date","Expiration Date","Quantity"};
		tblMedicineModel = new DefaultTableModel(colsMenu, 0) {
			public Class getColumnClass(int column) {

				 	  return Object.class;
				
			}
			
		};
		
		  List<medicines> medLists = Data.getMedList();
	        for (medicines o: medLists){
	        	if(o.getQty() != 0 && o.getQty()>=0) {
	            	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    			String manuDateFormatted = format1.format(o.getManuDate());
	    			String expiDateFormatted = format1.format(o.getExpirationDate());
	                        Object[] newRow = {o.getId(), o.getbName(),o.getgName(),o.getCategory(),o.getMeasure(),o.getMetricmeasure(),manuDateFormatted, expiDateFormatted, o.getQty()};
	                        tblMedicineModel.addRow(newRow);
	        	}
	        	
	        }
	        tblMedicines.setModel(tblMedicineModel);
	        TableColumnModel tableColumnModel = tblMedicines.getColumnModel();
	        tableColumnModel.removeColumn(tableColumnModel.getColumn(0));
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
