import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;

public class handoutMed extends JFrame {
	private DefaultTableModel tblCartModel;
	private JPanel contentPane;
	private JPanel pnlSearch;
	private JTable tblResident;
	private DefaultTableModel tblResidentModel;
	private data Data;
	private JLabel lblNewLabel;
	private JTextField txtSearchBar;
	private JPanel pnlCart;
	private JScrollPane scrollPane_1;
	private DefaultTableModel tblMedModel;
	private JTable tblMed;
	private JButton btnChangeQty;
	private JScrollPane scrollPane_2;
	private JButton btnDelete;
	private int qty;
	
	private int quantity;
	private String resId="";
	private String fullName="";
	private int newQuantity;
	private JTable tblCart;
	private JButton btnConfirm;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btnBackCart;
	private JButton btnBackMed;
	int remainingQty;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox cbSort;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					handoutMed frame = new handoutMed();
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
	public handoutMed() {
		Data = data.getInstance();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//setBounds(100, 100, 1034, 461);
		setBounds(100, 100, 887, 461);
		//setBounds(100, 100, 903, 493);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(36,46,50));
		panel_1.setBounds(0, 0, 887, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnBackCart = new JButton("");
		btnBackCart.setVisible(false);
		btnBackCart.setRequestFocusEnabled(false);
		btnBackCart.setFocusable(false);
		btnBackCart.setFocusTraversalKeysEnabled(false);
		btnBackCart.setFocusPainted(false);
		btnBackCart.setContentAreaFilled(false);

		btnBackCart.setOpaque(false);
		btnBackCart.setBorder(null);
		btnBackCart.setBorderPainted(false);
		btnBackCart.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnBackCart.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnBackCart.setBounds(0, 0, 58, 36);
		panel_1.add(btnBackCart);
		
		btnBackMed = new JButton("");
		btnBackMed.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\outline_arrow_back_white_24dp.png"));
		btnBackMed.setRequestFocusEnabled(false);
		btnBackMed.setOpaque(false);
		btnBackMed.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnBackMed.setFocusable(false);
		btnBackMed.setFocusTraversalKeysEnabled(false);
		btnBackMed.setFocusPainted(false);
		btnBackMed.setContentAreaFilled(false);
		btnBackMed.setBorderPainted(false);
		btnBackMed.setBorder(null);
		btnBackMed.setBounds(0, 0, 58, 36);
		panel_1.add(btnBackMed);
						
						pnlCart = new JPanel();
						pnlCart.setBackground(new Color(74,94,104));
						pnlCart.setVisible(false);
						pnlCart.setBounds(0, 0, 1034, 461);
						contentPane.add(pnlCart);
						pnlCart.setLayout(null);
						
						scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(5, 118, 627, 325);
						scrollPane_1.getViewport().setBackground(new Color(36,46,50));
						pnlCart.add(scrollPane_1);
						
						tblMed = new JTable();
						tblMed.setForeground(new Color(255, 255, 255));
						tblMed.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
						scrollPane_1.setViewportView(tblMed);
						tblMed.setBackground(new Color(36,46,50));
						textField = new JTextField();
						textField.setBounds(94, 78, 181, 29);
						pnlCart.add(textField);
						textField.setColumns(10);
						
						JPanel panel = new JPanel();
						panel.setBackground(new Color(36,46,50));
						panel.setBounds(637, 0, 397, 461);
						pnlCart.add(panel);
						panel.setLayout(null);
						
						btnChangeQty = new JButton("CHANGE QUANTITY");
						btnChangeQty.setFont(new Font("SansSerif", Font.PLAIN, 12));
						btnChangeQty.setBounds(10, 407, 119, 36);
						panel.add(btnChangeQty);
						
								btnChangeQty.setBackground(SystemColor.activeCaption);
								btnChangeQty.setBorder(null);
								
								scrollPane_2 = new JScrollPane();
								scrollPane_2.setBounds(10, 76, 375, 320);
								panel.add(scrollPane_2);
								
								tblCart = new JTable();
								
												scrollPane_2.setViewportView(tblCart);
												
												btnDelete = new JButton("DELETE");
												btnDelete.setFont(new Font("SansSerif", Font.PLAIN, 12));
												
												btnDelete.setBounds(139, 407, 119, 36);
												panel.add(btnDelete);
												btnDelete.setBorder(null);
												btnDelete.setBackground(new Color(255, 182, 193));
												
												btnConfirm = new JButton("CONFIRM");
												btnConfirm.setFont(new Font("SansSerif", Font.PLAIN, 12));
												
																btnConfirm.setBounds(266, 407, 119, 36);
																panel.add(btnConfirm);
																btnConfirm.setBorder(null);
																btnConfirm.setBackground(new Color(153, 255, 153));
																
																lblNewLabel_4 = new JLabel("ITEM/S");
																lblNewLabel_4.setOpaque(true);
																lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
																lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
																lblNewLabel_4.setForeground(Color.WHITE);
																lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 20));
																lblNewLabel_4.setBackground(new Color(36, 46, 50));
																lblNewLabel_4.setBounds(88, 44, 245, 27);
																panel.add(lblNewLabel_4);
																
																lblNewLabel_1 = new JLabel("SEARCH:");
																lblNewLabel_1.setForeground(new Color(255, 255, 255));
																lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
																lblNewLabel_1.setBounds(5, 83, 79, 24);
																pnlCart.add(lblNewLabel_1);
																
																lblNewLabel_5 = new JLabel("SORT BY:");
																lblNewLabel_5.setForeground(Color.WHITE);
																lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 18));
																lblNewLabel_5.setBounds(313, 83, 94, 24);
																pnlCart.add(lblNewLabel_5);
																
																cbSort = new JComboBox();
																cbSort.addItemListener(new ItemListener() {
																	public void itemStateChanged(ItemEvent e) {
																		if(cbSort.getSelectedItem().equals("")) {
																			Data.populateTblMeds();
																			generateAvailableMed(Data);
																		}else {
																			Data.medicineSort(cbSort.getSelectedItem().toString());
																			generateAvailableMed(Data);
																		}
																	}
																});
												
																cbSort.setModel(new DefaultComboBoxModel(new String[] {"", "BRAND NAME", "GENERIC NAME", "CATEGORY", "MANUFACTURED DATE", "EXPIRATION DATE", "QUANTITY", "METRIC MEASUREMENT", "MEASUREMENT"}));
																cbSort.setForeground(Color.WHITE);
																cbSort.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
																cbSort.setBackground(new Color(36, 46, 50));
																cbSort.setBounds(417, 80, 215, 27);
																pnlCart.add(cbSort);
																
																lblNewLabel_3 = new JLabel("MEDICINE");
																lblNewLabel_3.setBounds(148, 36, 370, 30);
																pnlCart.add(lblNewLabel_3);
																lblNewLabel_3.setOpaque(true);
																lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
																lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
																lblNewLabel_3.setForeground(Color.WHITE);
																lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 30));
																lblNewLabel_3.setBackground(new Color(36, 46, 50));
																
																pnlSearch = new JPanel();
																pnlSearch.setBackground(new Color(74,94,104));
																pnlSearch.setBounds(0, 0, 887, 461);
																contentPane.add(pnlSearch);
																pnlSearch.setLayout(null);
																
																JScrollPane scrollPane = new JScrollPane();
																scrollPane.setBounds(10, 135, 867, 315);
																pnlSearch.add(scrollPane);
																
																tblResident = new JTable();
																tblResident.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
																tblResident.setForeground(new Color(255, 255, 255));
																tblResident.setGridColor(new Color(255, 255, 255));
																tblResident.setBackground(new Color(36,46,50));
																scrollPane.setViewportView(tblResident);
																
																lblNewLabel = new JLabel("SEARCH:");
																lblNewLabel.setForeground(new Color(255, 255, 255));
																lblNewLabel.setBounds(10, 97, 70, 25);
																pnlSearch.add(lblNewLabel);
																lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
																
																txtSearchBar = new JTextField();
																txtSearchBar.setBounds(90, 96, 185, 28);
																pnlSearch.add(txtSearchBar);
																
																		txtSearchBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
																		txtSearchBar.setColumns(10);
																		
																		JLabel lblNewLabel_2 = new JLabel("HANDOUT MEDICINE");
																		lblNewLabel_2.setBackground(new Color(36,46,50));
																		lblNewLabel_2.setOpaque(true);
																		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
																		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
																		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
																		lblNewLabel_2.setForeground(new Color(255, 255, 255));
																		lblNewLabel_2.setBounds(231, 44, 403, 41);
																		pnlSearch.add(lblNewLabel_2);
																		
																		txtSearchBar.addKeyListener(new KeyAdapter() {
																			@Override
																			public void keyReleased(KeyEvent e) {
																				if (txtSearchBar.getText().equals("") || txtSearchBar.getText().isEmpty()
																						|| txtSearchBar.getText().isBlank()) {
																					Data.populatetblResident();
																					generateResident(Data);
																				} else {
																					String search = txtSearchBar.getText();
																					Data.searchResident(search);
																					generateResident(Data);
																				}
																			}
																		});
																
																
																btnChangeQty.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		int row=tblCart.getSelectedRow();
																		if(row ==-1) {
																			JOptionPane.showMessageDialog(null, "Please select an item.");
																		}else {
																			

																			
																			
																			String input = JOptionPane.showInputDialog(null, "Enter quantity",0);
																			int cartid=Integer.parseInt(String.valueOf(tblCart.getModel().getValueAt(row, 5)));
																			int originalStock=Integer.parseInt(String.valueOf(tblCart.getModel().getValueAt(row, 4)));
																			int medId=Integer.parseInt(String.valueOf(tblCart.getModel().getValueAt(row, 0)));
																			int inputtedQuantity = Integer.parseInt(String.valueOf(tblCart.getModel().getValueAt(row,3)));
																			String brandName = String.valueOf(tblCart.getModel().getValueAt(row, 1));
																			
																			if("0".equals(input)) {
																				JOptionPane.showMessageDialog(null,"Please input a value", "Change Quantity",JOptionPane.INFORMATION_MESSAGE);
																			}
																			if(input == null || (input != null && ("0".equals(input))))   
																			{
																			   int quant = originalStock - inputtedQuantity;
																			   Data.updateQuantity(medId, quant);
																			  

																			}else if(originalStock < Integer.parseInt(input)){
																				JOptionPane.showMessageDialog(null,"Original quantity of "+brandName+" is "+originalStock+".\n"
																						+ "Cannot input more than original quantity.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
																			}else {
																				Data.updateQuantity(medId, originalStock);
																				int in = Integer.parseInt(String.valueOf(input));
																				int newQty = originalStock - in;
																				Data.updateQuantity(medId, newQty);
																				
																				Data.updateCart(cartid, in);
																				generateCart(Data);
																				
																				Data.populateTblMeds();
																				generateAvailableMed(Data);
																		
																			}
																		}
																	}
																});
																
																	btnDelete.addMouseListener(new MouseAdapter() {
																		@Override
																		public void mouseClicked(MouseEvent e) {
																			int row=tblCart.getSelectedRow();
																			if(row ==-1) {
																				JOptionPane.showMessageDialog(null, "Please select an item.");
																			}else {
																				int originalStock=Integer.parseInt(String.valueOf(tblCart.getModel().getValueAt(row, 4)));
																				int medId=Integer.parseInt(String.valueOf(tblCart.getModel().getValueAt(row, 0)));
																				int sel = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?","Remove Item",JOptionPane.YES_NO_OPTION);
																				if(sel==0) {
																					Data.deleteFromCart(medId);
																					Data.updateQuantity(medId, originalStock);
																					
																					generateCart(Data);
																					
																					Data.populateTblMeds();
																					generateAvailableMed(Data);
																				}
																			}
																		}
																	});
																	
																	btnConfirm.addActionListener(new ActionListener() {
																		public void actionPerformed(ActionEvent e) {
																			int sel = JOptionPane.showConfirmDialog(null, "Do you want to proceed?","Process Transacation",JOptionPane.YES_NO_OPTION);
																			if(sel==0) {
																				int transid=0;

																				Date transDate = new Date();
																			    List<cart>cartList = Data.getCartList();
																		        for (cart o: cartList){
																					if(Data.CheckIfTransIsempty()) {
																						transid=1;
																					}else {
																						transid = Data.getMaximumTransactionId();
																					}
																		        	Data.addTransactionRecord(transid, o.getBname(), o.getGname(), o.getQty(), transDate,Integer.parseInt(resId),fullName);
																		        	
																		        }
																		        Data.clearCart();
																	        	JOptionPane.showMessageDialog(null, "Transaction recorded successfully","Transaction Record",JOptionPane.INFORMATION_MESSAGE);
																	        	
																	        	generateCart(Data);
																				setBounds(100, 100, 1034, 461);
																				panel_1.setBounds(0, 0, 1034, 36);
																				pnlCart.setVisible(false);
																				pnlSearch.setVisible(true);
																				btnBackMed.setVisible(true);
																				btnBackCart.setVisible(false);
																				setBounds(100, 100, 887, 461);
																				panel_1.setBounds(0, 0, 887, 36);
																				centerScreen();
																			}
																		}
																	});
		Data.populatetblResident();
		generateResident(Data);
		Data.clearCart();
		centerScreen();
		centerScreen();
		btnBackMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			employeeFrame emp = new employeeFrame();
			emp.setVisible(true);
				
			}
		});
		
		btnBackCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 1034, 461);
				panel_1.setBounds(0, 0, 1034, 36);
				pnlCart.setVisible(false);
				pnlSearch.setVisible(true);
				btnBackMed.setVisible(true);
				btnBackCart.setVisible(false);
				
				setBounds(100, 100, 887, 461);
				panel_1.setBounds(0, 0, 887, 36);
				centerScreen();
			}
		});
		
	}

	public void generateResident(data Data) {
		
		String[] colsMenu = {"Image", "FULL NAME", "ADDRESS", "BIRTHDATE", "CATEGORY", "PWD SPECIFICATION", " "," "};
		
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
			String address =o.getStreet()+", "+o.getBrgy()+", "+o.getCity()+", "+o.getProvince();
			String img = o.getPhoto();
			String fullName = o.getFname()+" "+o.getMname()+" "+o.getLname();
			ImageIcon newImage=null;
			if(img==null) {
				newImage=null;
			}else {
				
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                
                Image myImg = im.getScaledInstance(100, 100 ,Image.SCALE_SMOOTH);//this ikaw na bahala mag snet ng size
                 newImage = new ImageIcon(myImg);
                 
				
			}
			Object[] newRow = {newImage, fullName, address, o.getBdate(), o.getCategory(),o .getPwdSpecify(), "GIVE MEDICINE",o.getId()};//sige po sir thank you po okay thanks din makakatulog na ko hahahahaha
			
			tblResidentModel.addRow(newRow);
			
		}
		Action GiveMed = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					int sel = JOptionPane.showConfirmDialog(null, "Hand out medicine to this patient?", "Medicine Handout", JOptionPane.YES_NO_OPTION);
					if(sel==0) {
						int rowIndex = Integer.valueOf(e.getActionCommand());
						fullName= String.valueOf(tblResident.getModel().getValueAt(rowIndex,1));
						resId=String.valueOf(tblResident.getModel().getValueAt(rowIndex,7));
						System.out.println(resId+" "+fullName);
						
						setBounds(100, 100, 1034, 461);
						panel_1.setBounds(0, 0, 1034, 36);
						pnlCart.setVisible(true);
						pnlSearch.setVisible(false);
						Data.populateTblMeds();
						generateAvailableMed(Data);
						btnBackCart.setVisible(true);
						btnBackMed.setVisible(false);
						
					}
					
				}catch(ArrayIndexOutOfBoundsException ex) {
					System.out.print(ex);;
				}
			}
        };
        
	
		tblResident.setModel(tblResidentModel);
		//for buttonColumn
		ButtonColumn buttonColumn = new ButtonColumn(tblResident, GiveMed, 6);
		tblResident.setRowHeight(100);
		
		TableColumnModel tableColumnModel = tblResident.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(7));
        tblResident.getColumnModel().getColumn(6).setPreferredWidth(100);
	}

	public void generateAvailableMed(data Data) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		String[] colsMenu = {"ID","Brand Name","Generic Name","Metric Measurement","Measurement","Manufactured Date","Expiration Date","Quantity"," "};
        tblMedModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
            	  return Object.class;
            }
        };

        List<medicines> medLists = Data.getMedList();
        for (medicines o: medLists){
        	if(o.getQty() != 0 && o.getQty()>=0 && o.getExpirationDate().after(new Date())) {
            	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    			String manuDateFormatted = format1.format(o.getManuDate());
    			String expiDateFormatted = format1.format(o.getExpirationDate());
                        Object[] newRow = {o.getId(), o.getbName(),o.getgName(),o.getMetricmeasure(),o.getMeasure(),manuDateFormatted,expiDateFormatted, o.getQty(),"SELECT"};
                        tblMedModel.addRow(newRow);
        	}
        	
        }
        

        tblMed.setModel(tblMedModel);
        
        Action select = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					int sel = JOptionPane.showConfirmDialog(null, "Select this Medicine?", "Medicine Handout", JOptionPane.YES_NO_OPTION);
					if(sel==0) {
						
						int rowIndex = Integer.valueOf(e.getActionCommand());
						String input = JOptionPane.showInputDialog(null, "Enter quantity",0);
						qty = Integer.parseInt(input);
						
						quantity = Integer.parseInt(String.valueOf(tblMed.getModel().getValueAt(rowIndex, 7)));
						if(qty>quantity) {
							JOptionPane.showMessageDialog(null, "Invalid quantity value");
						}else if(input.isEmpty()|| qty==0){
							
							JOptionPane.showMessageDialog(null, "Please input value");
						}else {
							int id = Integer.parseInt(String.valueOf(tblMed.getModel().getValueAt(rowIndex, 0)));
							String brandname = String.valueOf(tblMed.getModel().getValueAt(rowIndex, 1));
							String gname = String.valueOf(tblMed.getModel().getValueAt(rowIndex, 2));
							 int medid=id;
							 newQuantity = quantity - qty;
							if(Data.checkDupItem(brandname)) {
							
								Data.addSameItem(medid, qty);
								generateCart(Data);
								
								Data.updateQuantity(id,newQuantity);
								Data.populateTblMeds();
								generateAvailableMed(Data);
							
							}else {
								
								 Data.updateQuantity(id,newQuantity);
								 
								
								 Data.addCart(medid, brandname,gname,qty,quantity);
								 generateCart(Data);
								Data.populateTblMeds();
								generateAvailableMed(Data);
							}
						}
					}
					
				}catch(ArrayIndexOutOfBoundsException ex) {
					System.out.print(ex);;
				}
			}
        };
        ButtonColumn buttonColumn = new ButtonColumn(tblMed, select, 8);
        tblMed.setRowHeight(100);
        TableColumnModel tableColumnModel = tblMed.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(0));
	}
	
	public void generateCart(data Data) {
		String[] colsMenu = {"MedId","Brand Name","Generic Name","Quantity","OriginalStock","Id"};
        tblCartModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
        
        List<cart>cartList = Data.getCartList();
        for (cart o: cartList){
        	Object[] newRow = {o.getMedId(),o.getBname(),o.getGname(),o.getQty(),o.getStock(),o.getId()};
            tblCartModel.addRow(newRow);
        }
        
       tblCart.setModel(tblCartModel);
       
	     tblCart.removeColumn(tblCart.getColumnModel().getColumn(0));
	     tblCart.removeColumn(tblCart.getColumnModel().getColumn(3));
	     tblCart.removeColumn(tblCart.getColumnModel().getColumn(3));
	}
	
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
