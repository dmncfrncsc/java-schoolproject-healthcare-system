
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Toolkit;

public class loginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private data Data;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
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
	public loginForm() {
	
		Data = data.getInstance();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(74,94,104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 77, 89));
		panel.setBounds(412, 1, 456, 601);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFocusTraversalKeysEnabled(false);
		btnLogin.setFocusable(false);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(36,46,50));
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		btnLogin.setBounds(86, 448, 285, 49);
		panel.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setSelectedTextColor(new Color(0, 0, 0));
		txtPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txtPassword.setFocusTraversalKeysEnabled(false);
		txtPassword.setBounds(86, 396, 285, 41);
		panel.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(86, 353, 152, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(86, 258, 146, 41);
		panel.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setSelectedTextColor(new Color(0, 0, 0));
		txtUsername.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		txtUsername.setFocusTraversalKeysEnabled(false);
		txtUsername.setBounds(86, 301, 285, 41);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\testlogo.png"));
		lblNewLabel_3.setBounds(134, 11, 181, 181);
		panel.add(lblNewLabel_3);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String user = txtUsername.getText();
				String pass = txtPassword.getText();
				
				 if(txtUsername.getText().isEmpty()||txtPassword.getText().isEmpty()){
	                    JOptionPane.showMessageDialog(null,"Please complete the form to continue","Empty Fields",JOptionPane.WARNING_MESSAGE);
	                    return;
	             }
				 //user = "test"
				if(Data.checkUser(user)) {
					if(Data.checkIfLocked(user)) {
						 JOptionPane.showMessageDialog(null,"Login Attempt Limit Reached\nYour account has been locked, please contact admin.");
						 return;
					}
					
				}
				
				if(Data.checkIfAdmin(user, pass)) {
					dispose();
					adminForm admin = new adminForm();
					admin.setVisible(true);
				}
				else if(Data.checkIfEmployee(user, pass)) {
					dispose();
					employeeFrame emp = new employeeFrame();
					emp.setVisible(true);
				}
				else {
					if(Data.checkIfUsernameIsAdmin(user)) {
						 JOptionPane.showMessageDialog(null,"Invalid username or password");
						 
					}else {
						//ramos
						Data.userAttempt(user);
						JOptionPane.showMessageDialog(null,"Invalid username or password");
					}
				}
			}
			
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\domin\\eclipse-workspace\\HealthCareSystem\\icons\\TEST1ASEASEAS.png"));
		lblNewLabel_2.setBounds(-1, -1, 869, 603);
		contentPane.add(lblNewLabel_2);
		centerScreen();
	}
	public void centerScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
