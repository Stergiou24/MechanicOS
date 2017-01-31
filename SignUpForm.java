import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.lang.RandomStringUtils;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Label;

public class SignUpForm {
	private JFrame frame;
	private JTextField mailtext;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpForm window = new SignUpForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUpForm() {
		initialize();
	}

	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 425, 251);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		
		JLabel Inslbl = new JLabel("");
		Inslbl.setBounds(10, 0, 389, 128);
		frame.getContentPane().add(Inslbl);
		
		mailtext = new JTextField();
		mailtext.setBounds(40, 138, 359, 20);
		frame.getContentPane().add(mailtext);
		mailtext.setColumns(10);
		JButton Createbtn = new JButton("");
		Createbtn.setBounds(10, 182, 269, 23);
		frame.getContentPane().add(Createbtn);
		JButton btnCancel = new JButton("");
		btnCancel.setBounds(310, 182, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 141, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		SqlStatements sqls = new SqlStatements();
//------------------------------Listeners-------------------------------------------------------		
		PassingVar passingv = new PassingVar();
		if(passingv.language=="GR")
		{
		Createbtn.setText("Αποστολή");
		btnCancel.setText("Ακυρο");
		Inslbl.setText("<html><u>Οδηγείες</u><br>Παρακαλώ συμπληρώστε το παρακάτω κειμενογράφο με το email σας. Σε αυτό το email θα λάβετε το όνομα χρήστη και τον κωδικό σας για να μπορείτε να εγγραφείτε και να προσθέσετε τα προσωπηκά σας στοιχεία. Μετά την εγγραφή μπορείτε να αλλάξετε το όνομα χρήστη και τον κωδικό σας. </html>");
		}
		else
		{
			Createbtn.setText("Send");
			btnCancel.setText("Cancel");
			Inslbl.setText("<html><u>Instructions</u><br>Please fill the following text with your email. In these email you will receive the username and password so that you can sign up and add your personal data. After the signup you can change your username and password.</html>");
		}
//----------------------------------------------------------------------------------------------		
//------------------------------Listeners-------------------------------------------------------		
		SqlConn connsql = new SqlConn();
		
		Createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					PassingVar passv = new PassingVar();
				
					sqls.SignUpFormActions(RandomStringUtils.randomAlphabetic(5).toUpperCase(), RandomStringUtils.randomAlphabetic(5).toUpperCase(), mailtext.getText());

					JOptionPane.showMessageDialog(null, "Successfull!!");
					frame.dispose();
					AfterLoginForm alf = new AfterLoginForm();
					alf.main(null);
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null, "Tο mail σταλθηκε επιτυχως");
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
			}
		});
//------------------------------------------------------------------------------------------------------
	}
}
