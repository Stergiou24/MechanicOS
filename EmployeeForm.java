import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JComboBox;

public class EmployeeForm {	
	private JFrame frame;
	public static void EmployeeFormMain2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm window = new EmployeeForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public EmployeeForm() {
		initialize();
	}

	public static String EmpId=null;
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 467);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		PassingVar passingvar = new PassingVar();
		
		JButton btnSave = new JButton("");
		
		btnSave.setBounds(10, 378, 130, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
				frame.dispose();
			}
		});
		btnCancel.setBounds(290, 378, 130, 23);
		frame.getContentPane().add(btnCancel);
		
		Label label = new Label("");
		label.setBounds(10, 74, 130, 22);
		frame.getContentPane().add(label);
		
		TextField idtext = new TextField();
		idtext.setBounds(215, 74, 205, 22);
		frame.getContentPane().add(idtext);
		
		Label label_1 = new Label("");
		label_1.setBounds(10, 102, 130, 22);
		frame.getContentPane().add(label_1);
		
		TextField ftext = new TextField();
		ftext.setBounds(215, 102, 205, 22);
		frame.getContentPane().add(ftext);
		
		Label label_2 = new Label("");
		label_2.setBounds(10, 130, 130, 22);
		frame.getContentPane().add(label_2);
		
		TextField ltext = new TextField();
		ltext.setBounds(215, 130, 205, 22);
		frame.getContentPane().add(ltext);
		
		Label label_4 = new Label("");
		label_4.setBounds(10, 158, 130, 22);
		frame.getContentPane().add(label_4);
		
		TextField postext = new TextField();
		postext.setBounds(215, 158, 205, 22);
		frame.getContentPane().add(postext);
		
		Label label_5 = new Label("");
		label_5.setBounds(10, 186, 130, 22);
		frame.getContentPane().add(label_5);
		
		TextField mailtext = new TextField();
		mailtext.setBounds(215, 186, 205, 22);
		frame.getContentPane().add(mailtext);
		
		Label label_6 = new Label("");
		label_6.setBounds(10, 214, 130, 22);
		frame.getContentPane().add(label_6);
		
		TextField phonetext = new TextField();
		phonetext.setBounds(215, 214, 205, 22);
		frame.getContentPane().add(phonetext);
		
		Label label_7 = new Label("");
		label_7.setBounds(10, 242, 130, 22);
		frame.getContentPane().add(label_7);
		
		TextField addresstext = new TextField();
		addresstext.setBounds(215, 242, 205, 22);
		frame.getContentPane().add(addresstext);
		
		Label label_8 = new Label("");
		label_8.setBounds(10, 270, 130, 22);
		frame.getContentPane().add(label_8);
		
		TextField wagetext = new TextField();
		wagetext.setBounds(215, 270, 205, 22);
		frame.getContentPane().add(wagetext);
		
		Label label_9 = new Label("");
		label_9.setBounds(10, 298, 130, 22);
		frame.getContentPane().add(label_9);
		
		TextField yictext = new TextField();
		yictext.setBounds(215, 298, 205, 22);
		frame.getContentPane().add(yictext);
		
		JButton btnClear = new JButton("");

		btnClear.setBounds(150, 378, 130, 23);
		frame.getContentPane().add(btnClear);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(10, 326, 130, 14);
		frame.getContentPane().add(label_3);
		
		JComboBox depcombo = new JComboBox();
		depcombo.setBounds(215, 326, 205, 20);
		frame.getContentPane().add(depcombo);
		
		JLabel TopEmployeeLbl = new JLabel("");
		TopEmployeeLbl.setBounds(10, 25, 410, 14);
		frame.getContentPane().add(TopEmployeeLbl);
		
		int messageType = JOptionPane.QUESTION_MESSAGE;
	    String[] options = {"OK"};
	    String[] Title = {null,null};
	    
		SqlStatements sqls = new SqlStatements();
		String TopLblC;
		String TopLblE;
		String TopLblV;
//----------------------------------Αλλαγη Γλωσσας-------------------------------------
		
		
		String language = passingvar.language;
				if(language=="GR")
				{
					btnSave.setText("Αποδοχή");
					btnClear.setText("Καθαρισμός");
					btnCancel.setText("Άκυρο");
					label.setText("ID");
					label_1.setText("Όνομα");
					label_2.setText("Επωνυμο");
					label_3.setText("Τμήμα");
					label_4.setText("Θέση");
					label_5.setText("E-Mail");
					label_6.setText("Τηλέφωνο");
					label_7.setText("Διεύθηνση");
					label_8.setText("Μισθός");
					label_9.setText("Χρόνια στην εταιρία");
					Title[0]="Κενά";
				    Title[1]="Παρακαλώ συμπληρώστε όλα τα στοιχεία της φόρμας";
				    TopLblC="Νεος Εργαζόμενος";
				    TopLblE="Επεξεργασία Εργαζομένου";
				    TopLblV="Προβολή Εργαζομένου";
				}
				else
				{
					btnSave.setText("Submit");
					btnClear.setText("Clear");
					btnCancel.setText("Cancel");
					label.setText("ID");
					label_1.setText("First Name");
					label_2.setText("Last Name");
					label_3.setText("Department");
					label_4.setText("Position");
					label_5.setText("E-Mail");
					label_6.setText("Phone Number");
					label_7.setText("Address");
					label_8.setText("Wage");
					label_9.setText("Years in company");
					Title[0]="Empty";
				    Title[1]="Please fill all texts";
				    TopLblC="New Employee";
				    TopLblE="Edit Employee";
				    TopLblV="View Employee";
				}
				
//----------------------------------------------------------------------------------------------------//---------------------------------View Mode-------------------------------------------
				
				if(passingvar.mode=="VI")
				{
					btnClear.setVisible(false);
					btnSave.setVisible(false);
					
					idtext.setEditable(false);
					ftext.setEditable(false);
					ltext.setEditable(false);
					postext.setEditable(false);
					mailtext.setEditable(false);
					phonetext.setEditable(false);
					addresstext.setEditable(false);
					wagetext.setEditable(false);
					yictext.setEditable(false);
					depcombo.setEnabled(false);
					   TopEmployeeLbl.setText(TopLblV);
				}
				else if(passingvar.mode=="ED")
				{TopEmployeeLbl.setText(TopLblE);}
				else if(passingvar.mode=="CR")
				{TopEmployeeLbl.setText(TopLblC);}
		//-------------------------------------------------------------------------------------
//--------------------Create Mode---------------------------------------------------------------------
				SqlConn connsql = new SqlConn();
				
				try
				{
						String sql4="SELECT Title FROM department";
						PreparedStatement pre3 = null;
						pre3 = connsql.getConnection().prepareStatement(sql4);
						ResultSet result3 = pre3.executeQuery();
						while(result3.next())
						{
							depcombo.addItem(result3.getString(1));
						}
				}
				catch(Exception err)
				{
					System.out.println(err);
				}
				
				if((passingvar.mode=="ED") || (passingvar.mode=="VI"))
				{
					try 
					{
						String[] part =passingvar.idEmp.split(" ");
						ResultSet result5 = sqls.EmployeeEditView1(part[0],part[1]);
						while(result5.next())
						{
							EmpId=result5.getString("id");
						}
						ResultSet result1 = sqls.EmployeeEditView2(EmpId);
						while(result1.next())
						{
							idtext.setText(result1.getString(1));
							ftext.setText(result1.getString(2));
							ltext.setText(result1.getString(3));
							postext.setText(result1.getString(5));
							mailtext.setText(result1.getString(6));
							phonetext.setText(result1.getString(7));
							addresstext.setText(result1.getString(8));
							wagetext.setText(result1.getString(9));
							yictext.setText(result1.getString(10));
							depcombo.setSelectedItem(result1.getString("dep"));
						}
					}
					catch(Exception er)
					{
						System.out.println("kati"+er);
					}
				}
//-------------------------------------------------------------------------------------------------------------------
//------------------------Listeners----------------------------------------------------------------------------------
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						SqlConn connsql = new SqlConn();
						
						String idtextS =idtext.getText();
						String ftextS = ftext.getText();
						String ltextS = ltext.getText();
						String depcomboS = depcombo.getSelectedItem().toString();
						String postextS = postext.getText();
						String mailtextS = mailtext.getText();
						String phonetextS = phonetext.getText();
						String addresstextS = addresstext.getText();
						String wagetextS = wagetext.getText();
						String yictextS = yictext.getText();
						
						if(passingvar.mode=="CR")
						{	
							if (idtext.getText().isEmpty() || ftext.getText().isEmpty() || ltext.getText().isEmpty() || postext.getText().isEmpty() || mailtext.getText().isEmpty() || phonetext.getText().isEmpty() || addresstext.getText().isEmpty()  || wagetext.getText().isEmpty() || yictext.getText().isEmpty())
							{
								JOptionPane.showInternalOptionDialog(frame.getContentPane(),Title[1], Title[0], 0, messageType, null, options,null); 
								return;
							}
							try{
								sqls.EmployeeCreateAction(idtextS,ftextS,ltextS,depcomboS,postextS,mailtextS,phonetextS,addresstextS,wagetextS,yictextS);
								JOptionPane.showMessageDialog(null, "Changes have been successfully saved!!!");
								frame.dispose();
							}
							catch(Exception er2)
								{
									System.out.println(er2);
								}
							
						}
						else if(passingvar.mode=="ED")
						{
							try 
							{
								sqls.EmployeeEditAction(idtextS,ftextS,ltextS,depcomboS,postextS,mailtextS,phonetextS,addresstextS,wagetextS,yictextS,EmpId);
								JOptionPane.showMessageDialog(null, "Changes have been successfully saved!!!");  
								frame.dispose();
							}
							catch(Exception er)
							{
								System.out.println(er);
							}
						}
						
						AfterLoginForm alf = new AfterLoginForm();
						alf.main(null);
					}
				});
				
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						idtext.setText(" ");
						ftext.setText(" ");
						ltext.setText(" ");
						postext.setText(" ");
						mailtext.setText(" ");
						phonetext.setText(" ");
						addresstext.setText(" ");
						wagetext.setText(" ");
						yictext.setText(" ");
					}
				});
		
//-----------------------------------------------------------------------
	}
}
