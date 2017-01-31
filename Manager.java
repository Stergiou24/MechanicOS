import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Label;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import org.apache.commons.lang.RandomStringUtils;

public class Manager {
	private JFrame frame;

	public static void ManagerMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager window = new Manager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Manager() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 355);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("");
		label.setBounds(10, 66, 182, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("");
		label_1.setBounds(10, 94, 182, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("");
		label_2.setBounds(10, 122, 182, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("");
		label_3.setBounds(10, 150, 182, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("");
		label_4.setBounds(10, 178, 182, 22);
		frame.getContentPane().add(label_4);
		
		Label label_5 = new Label("");
		label_5.setBounds(10, 206, 182, 22);
		frame.getContentPane().add(label_5);
		
		TextField ftext = new TextField();
		ftext.setBounds(221, 66, 241, 22);
		frame.getContentPane().add(ftext);
		
		TextField ltext = new TextField();
		ltext.setBounds(221, 94, 241, 22);
		frame.getContentPane().add(ltext);
		
		TextField wagetext = new TextField();
		wagetext.setBounds(221, 122, 241, 22);
		frame.getContentPane().add(wagetext);
		
		TextField phonetext = new TextField();
		phonetext.setBounds(221, 206, 241, 22);
		frame.getContentPane().add(phonetext);
		
		TextField addresstext = new TextField();
		addresstext.setBounds(221, 178, 241, 22);
		frame.getContentPane().add(addresstext);
		
		TextField mailtext = new TextField();
		mailtext.setBounds(221, 150, 241, 22);
		frame.getContentPane().add(mailtext);
		
		Label label_7 = new Label("");
		
		TextField usertext = new TextField();
		usertext.setBounds(221, 10, 241, 22);
		frame.getContentPane().add(usertext);
		
		JButton sbmbtn = new JButton("");
		
		JButton btnCancel = new JButton("");
		btnCancel.setBounds(352, 286, 110, 22);
		frame.getContentPane().add(btnCancel);
		
	
		label_7.setBounds(10, 10, 182, 22);
		frame.getContentPane().add(label_7);
		
		TextField passtext = new TextField();
		passtext.setBounds(221, 38, 241, 22);
		frame.getContentPane().add(passtext);
		
		Label label_6 = new Label("");
		label_6.setBounds(10, 38, 182, 22);
		frame.getContentPane().add(label_6);
		sbmbtn.setBounds(10, 286, 110, 22);
		frame.getContentPane().add(sbmbtn);
		JButton btnClear = new JButton("");
		btnClear.setBounds(185, 286, 110, 22);
		frame.getContentPane().add(btnClear);
		
		SqlStatements sqls = new SqlStatements();
//------------------------------------------------------------------------------------------------------
		sbmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConn connsql = new SqlConn();
					try
					{	
						sqls.ManagerAction(ftext.getText(), ltext.getText(), wagetext.getText(), mailtext.getText(), addresstext.getText(), phonetext.getText(), usertext.getText(), passtext.getText());
						JOptionPane.showMessageDialog(null, "Successful!!");
						frame.dispose();
					}
					catch(Exception error)
					{
						System.out.println(error);
					}	
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usertext.setText(" ");
				ftext.setText(" ");
				ltext.setText(" ");
				wagetext.setText(" ");
				mailtext.setText(" ");
				addresstext.setText(" ");
				phonetext.setText(" ");
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LoginForm lgwindow = new LoginForm();
				try {
					lgwindow.main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//----------------------------------Αλλαγη Γλωσσας-------------------------------------
		PassingVar passingvar = new PassingVar();
		
		String language = passingvar.language;
		if(language=="GR")
		{
			sbmbtn.setText("Αποθήκευση");
			btnClear.setText("Καθαρισμός");
			btnCancel.setText("Άκυρο");
			label.setText("Όνομα");
			label_1.setText("Επίθετο");
			label_2.setText("Μισθός");
			label_3.setText("E-Mail");
			label_4.setText("Διεύθηνση");
			label_5.setText("Τηλέφωνο");
			label_6.setText("Όνομα Χρήστη");
			label_7.setText("Κωδικός");
		}
		else
		{
			sbmbtn.setText("Submit");
			btnClear.setText("Clear");
			btnCancel.setText("Cancel");
			label.setText("First Name");
			label_1.setText("Last Name");
			label_2.setText("Wage");
			label_3.setText("E-mail");
			label_4.setText("Address");
			label_5.setText("Phone Number");
			label_6.setText("Username");
			label_7.setText("Password");
		}
		
//---------------------------------------------------------------------------------
	}
}
