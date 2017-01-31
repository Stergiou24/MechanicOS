import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class DepartmentForm {
	public static String  sqltitle;
	private JFrame frmHumanResourcesManagement;
	private JTextField titletext;
	private JTextField loctext;
	private JButton clbtn;

	public static void Dep() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentForm window = new DepartmentForm();
					window.frmHumanResourcesManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DepartmentForm() {
		initialize();
	}

	public void initialize() {
//---------------------------------------Create Elements-----------------------------------------	
		frmHumanResourcesManagement = new JFrame();
		frmHumanResourcesManagement.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		frmHumanResourcesManagement.setBounds(100, 100, 500, 591);
		frmHumanResourcesManagement.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHumanResourcesManagement.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(16, 45, 77, 14);
		frmHumanResourcesManagement.getContentPane().add(lblNewLabel);
		
		JLabel lblLocation = new JLabel("");
		lblLocation.setBounds(16, 76, 77, 14);
		frmHumanResourcesManagement.getContentPane().add(lblLocation);
		
		titletext = new JTextField();
		titletext.setBounds(155, 45, 319, 20);
		frmHumanResourcesManagement.getContentPane().add(titletext);
		titletext.setColumns(10);
		
		loctext = new JTextField();
		loctext.setColumns(10);
		loctext.setBounds(155, 76, 319, 20);
		frmHumanResourcesManagement.getContentPane().add(loctext);
		
		JLabel lblDec = new JLabel("");
		lblDec.setBounds(16, 104, 77, 14);
		frmHumanResourcesManagement.getContentPane().add(lblDec);
		
		JTextArea dectext = new JTextArea();
		dectext.setBounds(155, 107, 319, 278);
		frmHumanResourcesManagement.getContentPane().add(dectext);
		
		clbtn = new JButton("");
		
		JButton sbmbtn = new JButton("");
		sbmbtn.setBounds(10, 519, 130, 22);
		frmHumanResourcesManagement.getContentPane().add(sbmbtn);
				

		clbtn.setBounds(176, 519, 130, 22);
		frmHumanResourcesManagement.getContentPane().add(clbtn);

		JComboBox MngCombo = new JComboBox();
		
		JButton Mngbtn = new JButton("");
		Mngbtn.setBounds(224, 483, 250, 22);
		frmHumanResourcesManagement.getContentPane().add(Mngbtn);
		
		JButton Cnlbtn = new JButton("");
		Cnlbtn.setBounds(346, 519, 130, 22);
		frmHumanResourcesManagement.getContentPane().add(Cnlbtn);
				
		Label lblMng = new Label(":");
		lblMng.setBounds(10, 404, 83, 22);
		frmHumanResourcesManagement.getContentPane().add(lblMng);
		

		MngCombo.setBounds(155, 404, 319, 20);
		frmHumanResourcesManagement.getContentPane().add(MngCombo);
		
		JLabel lblManager = new JLabel("");
		lblManager.setBounds(16, 404, 46, 14);
		frmHumanResourcesManagement.getContentPane().add(lblManager);
		
		JLabel TopLbl = new JLabel("");
		TopLbl.setBounds(16, 11, 458, 14);
		frmHumanResourcesManagement.getContentPane().add(TopLbl);
		
		SqlStatements sqls = new SqlStatements();
		
		int messageType = JOptionPane.QUESTION_MESSAGE;
	    String[] options = {"OK"};
	    String[] Title = {null,null};
	    String LblC;
	    String LblE;
	    String LblV;
		PassingVar passingvar = new PassingVar();
//------------------------------------------------------------------------------------------]
	  //----------------------------------Αλλαγη Γλωσσας-------------------------------------
	  		if(passingvar.language=="GR")
	  		{
	  			lblNewLabel.setText("Τίτλος");
	  			lblLocation.setText("Όροφος");
	  			lblDec.setText("Περιγραφή");
	  			lblMng.setText("Προιστάμενος");
	  			Mngbtn.setText("Δημιουργήστε νέο manager τώρα!");
	  			sbmbtn.setText("Υποβολή");
	  			clbtn.setText("Καθαρισμός");
	  			Cnlbtn.setText("Κλείσιμο");
	  			Title[0]="Κενά";
	  		    Title[1]="Παρακαλώ συμπληρώστε όλα τα στοιχεία της φόρμας";
	  		    LblC="Νεο Τμήμα";
	  		    LblE="Επεξεργασία Τμήματος";
	  		    LblV="Προβολή Τμήματος";
	  		}
	  		else
	  		{
	  			lblNewLabel.setText("Title");
	  			lblLocation.setText("Location");
	  			lblDec.setText("Description");
	  			lblMng.setText("Manager");
	  			Mngbtn.setText("Create a new manager now!");
	  			sbmbtn.setText("Submit");
	  			clbtn.setText("Clear");
	  			Cnlbtn.setText("Cancel");
	  			Title[0]="Empty";
	  		    Title[1]="Please fill all texts";
	  		    LblC="New Department";
	  		    LblE="Edit Department";
	  		    LblV="View Department";
	  		}
	  //-----------------------------------------------------------------------
//----------------------------------View---------------------------------------------------

		String mode = passingvar.mode;
		if(mode=="VI")
		{
			titletext.setEditable(false);
			loctext.setEditable(false);
			dectext.setEditable(false);
			MngCombo.setEnabled(false);
			Mngbtn.setVisible(false);
			sbmbtn.setEnabled(false);
			clbtn.setEnabled(false);
			TopLbl.setText(LblV);
		}
		else if (mode=="CR")
		{
			TopLbl.setText(LblC);
		}
		else if(mode=="ED")
		{
			TopLbl.setText(LblE);
		}
//------------------------------------------------------------------------------------------
		
//----------------------------------Μodes---------------------------------------------------
				SqlConn connsql = new SqlConn();
					try
					{
						String sql4 = "SELECT fname,lname FROM manager WHERE DepId IS NULL";
						
						PreparedStatement pre4 = null;
						pre4 = connsql.getConnection().prepareStatement(sql4);
						ResultSet result4 = pre4.executeQuery();
						while(result4.next())
						{
							MngCombo.addItem(result4.getString("fname")+" "+result4.getString("lname"));	
						}
					}
					catch(Exception error)
					{
						System.out.println(error);
					}
				if ((mode=="ED") || (mode=="VI") )
				{
					try{
						ResultSet result1 = sqls.DepartmentEditCreate(passingvar.idDep);
						while(result1.next())
						{
							sqltitle = result1.getString(1);
							titletext.setText(result1.getString("Title"));
							loctext.setText(result1.getString("Location"));
							dectext.setText(result1.getString("Description"));
							MngCombo.addItem(result1.getString("MngId"));
							MngCombo.setSelectedItem(result1.getString("MngId"));
						}
					}
					catch(Exception er2){
						System.out.println(er2);
					}
				}
//---------------------------------------Listeners--------------------------------
				
				clbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						titletext.setText(" ");
						loctext.setText(" ");
						dectext.setText(" ");
					}
				});

			sbmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] part =MngCombo.getSelectedItem().toString().split(" ");
				if (titletext.getText().isEmpty() || loctext.getText().isEmpty() || dectext.getText().isEmpty())
				{
					JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),Title[1], Title[0], 0, messageType, null, options,null); 
					return;
				}
				if (mode=="ED")
				{
					try{
						String title1=titletext.getText();
						String loc1=loctext.getText();
						String dec1=dectext.getText();
						String MngComboS =  MngCombo.getSelectedItem().toString();
						sqls.DepartmentEditAction( part[0],  part[1],  title1,  loc1,  dec1, MngComboS,  sqltitle);

						passingvar.setDepId(null);//ΠΙΘΑΝΟ BUG
						JOptionPane.showMessageDialog(null, "Changes have been successfully saved!!!");   
						frmHumanResourcesManagement.dispose();
					}
					catch(Exception er2){
						System.out.println(er2);
					}
				}
				else if(mode=="CR")
				{
					try
					{	
						String titletextS = titletext.getText();
						String loctextS = loctext.getText();
						String dectextS = dectext.getText();
						String mngcomboS = MngCombo.getSelectedItem().toString();
						sqls.DepartmentCreate(part[0],titletextS,loctextS,dectextS,mngcomboS);
						frmHumanResourcesManagement.dispose();
					}
					catch(Exception eleos)
					{
						System.out.println(eleos);
					}
				}
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
			}
		});

		Mngbtn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				frmHumanResourcesManagement.dispose();
				SignUpForm editwindow = new SignUpForm();
				passingvar.SignUpId(true);
				editwindow.main(null);
			}
		});

		Cnlbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passingvar.setDepId(null);//ΠΙΘΑΝΟ BUG
				frmHumanResourcesManagement.dispose();
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
			}
		});
//-------------------------------------------------------------------------------------

	}
}
