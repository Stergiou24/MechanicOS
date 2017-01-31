import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Registration {
	private JFrame frame;
	public static void RegistationMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registration() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 384, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		
		JLabel lblAuth = new JLabel("");
		lblAuth.setBounds(10, 36, 350, 58);
		
		Label label = new Label("");
		label.setBounds(14, 103, 104, 22);
		
		Label label_1 = new Label("");
		label_1.setBounds(14, 137, 104, 22);
		
		TextField usernametext = new TextField();
		usernametext.setBounds(124, 103, 211, 22);
		
		JPasswordField passtext = new JPasswordField();
		passtext.setBounds(124, 137, 211, 22);
		JButton button = new JButton("");
		button.setBounds(56, 198, 282, 22);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(56, 231, 282, 22);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblAuth);
		frame.getContentPane().add(label);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(usernametext);
		frame.getContentPane().add(passtext);
		frame.getContentPane().add(button);
		frame.getContentPane().add(button_1);
		
		JLabel TopRegLbl = new JLabel("");
		TopRegLbl.setBounds(10, 11, 287, 14);
		frame.getContentPane().add(TopRegLbl);
		

//------------------------------Listeners-------------------------------------------------
		SqlConn connsql = new SqlConn();
		SqlStatements sqls = new SqlStatements();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try 
				{
					
					if(sqls.Registration(usernametext.getText(), passtext.getText()))
					{	
						Manager window = new Manager();
						window.ManagerMain(null);
						frame.dispose();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
					}
				}
				catch(Exception er)
				{
					System.out.println(er);
				}
			}
		});
//---------------------------------------------Αλλαγη Γλωσσας-------------------------------------
		PassingVar passingvar = new PassingVar();
		
		String language = passingvar.language;
		if(language=="GR")
		{
			TopRegLbl.setText("Εγγραφή Manager");
			lblAuth.setText("Eπιβεβαιώστε αυτήν την εγγραφή ως:");
			button.setText("Επιβεβαίωση");
			button_1.setText("Άκυρο");
			label.setText("Όνομα Χρήστη");
			label_1.setText("Κωδικός");
			lblAuth.setText("<html><u>Οδηγείες</u><br>Παρακαλώ συμπληρώστε την φόρμα με το όνομα χρήστη και τον κωδικό που παραλάβατε στο email σας</html>");
		}
		else
		{
			TopRegLbl.setText("Manager registration");
			lblAuth.setText("Autheticate this registration as:");
			button.setText("Authenticate");
			button_1.setText("Cancel");
			label.setText("Username");
			label_1.setText("Password");
			lblAuth.setText("<html><u>Instructions</u><br>Please fill the form with the username and password you received in you email. </html>");
		}
//-----------------------------------------------------------------------
	}
}
