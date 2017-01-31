import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.mail.MessagingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;

public class LoginForm {

	private JFrame frmHumanResourcesManagement;
	private JComboBox jobcombo;
	private JLabel lblUsername;
	private JTextField usernametext;
	private JLabel lblPassword;
	private JPasswordField passtext;
	private JButton btnNewButton;
	private JButton btnEn;

	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmHumanResourcesManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//public static StringBuilder  Language;
	public LoginForm() {
		initialize();
	}

	private void initialize() {
		
		frmHumanResourcesManagement = new JFrame();
		frmHumanResourcesManagement.setForeground(new Color(240, 240, 240));
		frmHumanResourcesManagement.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		frmHumanResourcesManagement.setBounds(100, 100, 615, 596);
		frmHumanResourcesManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoginAs.setForeground(Color.CYAN);
		lblLoginAs.setBounds(10, 29, 272, 14);
		
		jobcombo = new JComboBox();
		jobcombo.setBounds(10, 47, 579, 20);
		jobcombo.addItem("HRM");
		jobcombo.addItem("CEO");
		jobcombo.addItem("Manager");
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setForeground(Color.CYAN);
		lblUsername.setBounds(10, 100, 272, 14);
		
		usernametext = new JTextField();
		usernametext.setBounds(10, 118, 579, 20);
		usernametext.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(Color.CYAN);
		lblPassword.setBounds(10, 171, 272, 14);
		
		passtext = new JPasswordField();
		passtext.setBounds(10, 189, 579, 20);
		frmHumanResourcesManagement.getContentPane().setLayout(null);
		frmHumanResourcesManagement.getContentPane().add(lblLoginAs);
		frmHumanResourcesManagement.getContentPane().add(jobcombo);
		frmHumanResourcesManagement.getContentPane().add(lblUsername);
		frmHumanResourcesManagement.getContentPane().add(usernametext);
		frmHumanResourcesManagement.getContentPane().add(lblPassword);
		frmHumanResourcesManagement.getContentPane().add(passtext);
		PassingVar var = new PassingVar();
		SqlConn connsql = new SqlConn();
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorderPainted(true);
		btnLogin.setContentAreaFilled(true);
		btnLogin.setFocusPainted(true);
		JLabel backgroundlbl = new JLabel("");

		
		int messageType = JOptionPane.ERROR_MESSAGE;
	    String[] options = {"OK"};
	    
	    
	    
	    
	    
	    
	    
	    String[] Title = {"Failed to Login", "Please try again"};
	    String[] TitleEmpt1 = {"Empty", "You must fill username and password field"};
	    String[] TitleEmpt2 = {"Empty", "You must fill username field"};
	    String[] TitleEmpt3 = {"Empty", "You must fill password field"};

//-------------------------Listeners---------------------------------------------------------------
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String username = usernametext.getText();
					String password = passtext.getText();
					String job = jobcombo.getSelectedItem().toString();	
					SqlStatements sqls = new SqlStatements();
					
					if (username.isEmpty() && password.isEmpty())
					{
						JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),TitleEmpt1[1], TitleEmpt1[0], 0, messageType, null, options,null);
					}
					else if(username.isEmpty())
					{
						JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),TitleEmpt2[1], TitleEmpt2[0], 0, messageType, null, options,null);
					}
					else if(password.isEmpty())
					{
						JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),TitleEmpt3[1], TitleEmpt3[0], 0, messageType, null, options,null);
					}
					else
					{
						 boolean result = sqls.LoginAction(username,password,job);
			
						if (result)
						{	
							PassingVar pv = new PassingVar();
							pv.setJPos(jobcombo.getSelectedItem().toString());
							AfterLoginForm editwindow = new AfterLoginForm();
							editwindow.main(null);
							frmHumanResourcesManagement.dispose();
						}
						else 
						{
							JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),Title[1], Title[0], 0, messageType, null, options,null);              //----------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>
						}
					}
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,er);
				}
			}
		});
		btnLogin.setBounds(207, 373, 220, 23);
		frmHumanResourcesManagement.getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Manager? Register now!!");
		btnSignUp.setFocusPainted(false);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration editwindow = new Registration();
				editwindow.RegistationMain(null);	
			}
		});
		btnSignUp.setBounds(207, 418, 220, 23);
		frmHumanResourcesManagement.getContentPane().add(btnSignUp);
//-------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		btnEn = new JButton("EN");
		btnEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassingVar var = new PassingVar();
				var.setLang("ENG");
				Title[0]="Incorrect";
			    Title[1]="Your username/password was incorrect";
				lblLoginAs.setText("Login As");
				lblUsername.setText("Username");
				lblPassword.setText("Password");
				btnLogin.setText("Login");
				btnSignUp.setText("Manager? Register now!!");
			}
		});

		
		btnEn.setBounds(537, 0, 52, 36);
		frmHumanResourcesManagement.getContentPane().add(btnEn);
		
		JButton btnGr = new JButton("GR");
		URL x2 =getClass().getResource("./er/gr.png");

		btnGr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				var.setLang("GR");
				Title[0]="Λάθος";
			    Title[1]="Το όνομα χρήστη ή ο κωδικός σας είναι λάθος";
				lblLoginAs.setText("Συνδεθείτε ως");
				lblUsername.setText("Όνομα Χρήστη");
				lblPassword.setText("Κωδικός Xρήστη");
				btnLogin.setText("Σύνδεση");
				btnSignUp.setText("Είστε Manager? Κάντε εγγραφή τώρα!!");
			}
		});
		btnGr.setBounds(475, 0, 52, 36);
		frmHumanResourcesManagement.getContentPane().add(btnGr);
		
		
		backgroundlbl.setBounds(-72, -175, 781, 760);
		frmHumanResourcesManagement.getContentPane().add(backgroundlbl);
		
	}
}
