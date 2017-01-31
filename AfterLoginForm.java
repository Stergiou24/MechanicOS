import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.util.logging.*;
import javax.swing.ImageIcon;

public class AfterLoginForm {
	public JFrame frmHumanResourcesManagement;
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLoginForm window = new AfterLoginForm();
					window.frmHumanResourcesManagement.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AfterLoginForm() {

		initialize();
	}
	public void initialize() {
		frmHumanResourcesManagement = new JFrame();
		frmHumanResourcesManagement.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		frmHumanResourcesManagement.setBounds(100, 100, 604, 478);
		frmHumanResourcesManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHumanResourcesManagement.getContentPane().setLayout(null);
//-------------------------------------Create elements------------------------------------
		java.awt.List ValList = new java.awt.List();
		JButton ViewBtn = new JButton("");
		ViewBtn.setEnabled(false);
		
		SqlConn connsql = new SqlConn();
		
		SqlStatements sqls = new SqlStatements();
		
		java.awt.List Emplist = new java.awt.List();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		JLabel lblChooseDepartment = new JLabel("");
		JButton CreateBtn1 = new JButton("");
		JButton EditBtn1 = new JButton("");
		EditBtn1.setEnabled(false);
		JButton DelBtn1 = new JButton("");
		DelBtn1.setEnabled(false);
		
		java.awt.List Deplist = new java.awt.List();
		JLabel lblChooseEmployee = new JLabel("");
		JButton EditBtn2 = new JButton("");
		JButton DelBtn2 = new JButton("");
		JButton btnSearch = new JButton("");
		JButton CreateBtn3 = new JButton("");
		JButton EditBtn3 = new JButton("");
		JButton DelBtn3 = new JButton("");
		
		JButton CreateBtn2 = new JButton("");
		JLabel lblChooseValuation = new JLabel("");
		
		tabbedPane.setBounds(10, 47, 568, 347);
		frmHumanResourcesManagement.getContentPane().add(tabbedPane);
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("", null, panel1, null);
		tabbedPane.setEnabledAt(0, true);
		panel1.setLayout(null);		

		lblChooseDepartment.setBounds(7, 7, 140, 14);
		panel1.add(lblChooseDepartment);
		
		
		CreateBtn1.setBounds(7, 259, 110, 23);
		CreateBtn1.setEnabled(true);
		panel1.add(CreateBtn1);
		EditBtn1.setBounds(193, 259, 110, 23);
		panel1.add(EditBtn1);
		DelBtn1.setBounds(355, 259, 110, 23);
		panel1.add(DelBtn1);

		Deplist.setBounds(10, 27, 455, 226);
		panel1.add(Deplist);
		
		JButton DepViewBtn = new JButton("");
		DepViewBtn.setEnabled(false);
		DepViewBtn.setBounds(193, 314, 110, 23);
		panel1.add(DepViewBtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("", null, panel, null);
		lblChooseEmployee.setBounds(7, 7, 189, 14);
		panel.add(lblChooseEmployee);
		
		CreateBtn2.setBounds(7, 259, 110, 23);
		panel.add(CreateBtn2);
		
		EditBtn2.setEnabled(false);
		EditBtn2.setBounds(182, 259, 110, 23);
		panel.add(EditBtn2);
		
		DelBtn2.setEnabled(false);
		DelBtn2.setBounds(355, 259, 110, 23);
		panel.add(DelBtn2);
		
		Emplist.setBounds(10, 27, 455, 226);
		panel.add(Emplist);

		btnSearch.setBounds(7, 314, 110, 23);
		panel.add(btnSearch);
		
		JButton btnView = new JButton("");
		btnView.setEnabled(false);

		btnView.setBounds(355, 314, 110, 23);
		panel.add(btnView);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("", null, panel_1, null);
			
		lblChooseValuation.setBounds(7, 7, 140, 14);
		panel_1.add(lblChooseValuation);

		CreateBtn3.setBounds(7, 259, 110, 23);
		panel_1.add(CreateBtn3);
		
		EditBtn3.setEnabled(false);
		EditBtn3.setBounds(184, 259, 110, 23);
		panel_1.add(EditBtn3);	

		DelBtn3.setEnabled(false);
		DelBtn3.setBounds(355, 259, 110, 23);
		panel_1.add(DelBtn3);
		
		ValList.setBounds(10, 27, 455, 226);
		panel_1.add(ValList);
		
		ViewBtn.setBounds(184, 308, 110, 23);
		panel_1.add(ViewBtn);
		
		JButton Mngbtn = new JButton("");

		Mngbtn.setBounds(111, 405, 220, 23);
		frmHumanResourcesManagement.getContentPane().add(Mngbtn);
		
		JButton btnLogout = new JButton("");
		btnLogout.setBounds(498, 11, 80, 32);
		frmHumanResourcesManagement.getContentPane().add(btnLogout);
		
		JLabel TopLabel = new JLabel("");
		TopLabel.setBounds(10, 11, 220, 14);
		frmHumanResourcesManagement.getContentPane().add(TopLabel);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmHumanResourcesManagement.dispose();
					LoginForm lf = new LoginForm();
					lf.main(null);
					JOptionPane.showMessageDialog(null, "Log out successful");  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		int messageType = JOptionPane.QUESTION_MESSAGE;
	    String[] options = {"", ""};
	    String[] Title = {"", "","", ""};
	    String TopLblD;
	    String TopLblE;
	    String TopLblV;
		PassingVar passingvar = new PassingVar();
		String language = passingvar.language;
	  //----------------------------------------------------------------------------------
	  		if(passingvar.jpos=="HRM")
	  		{
	  			tabbedPane.setEnabledAt(2, false);
	  			Mngbtn.setEnabled(false);
	  		}
	  		else if(passingvar.jpos=="CEO")
	  		{
	  			tabbedPane.setEnabledAt(0, false);
	  			tabbedPane.setEnabledAt(1, false);
	  			tabbedPane.setSelectedIndex(2);
	  			ViewBtn.setEnabled(false);
	  			CreateBtn3.setEnabled(false);
	  			DelBtn3.setEnabled(false);
	  			EditBtn3.setEnabled(false);
	  		}
	  		else if(passingvar.jpos=="Manager")
	  		{
	  			tabbedPane.setEnabledAt(1, false);
	  			tabbedPane.setEnabledAt(0, false);
	  			tabbedPane.setSelectedIndex(2);
	  			ViewBtn.setEnabled(false);
	  			Mngbtn.setEnabled(false);
	  		}	
//----------------------------------------------------------------------
//---------------------Choose Language-------------------------------------------------------------------------------------		
		if(language=="GR")
		{
			lblChooseEmployee.setText("Επιλέξτε ID του εργαζομένου");
			lblChooseDepartment.setText("Επιλέξτε Tμήμα");
			lblChooseValuation.setText("Επιλέξτε Εργαζόμενο");
			btnSearch.setText("Αναζήτηση");
			CreateBtn1.setText("Δημιουργία");
			CreateBtn2.setText("Δημιουργία");
			CreateBtn3.setText("Δημιουργία");
			EditBtn1.setText("Επεξεργασία");
			EditBtn2.setText("Επεξεργασία");
			EditBtn3.setText("Επεξεργασία");
			DelBtn1.setText("Διαγραφή");
			DelBtn2.setText("Διαγραφή");
			DelBtn3.setText("Διαγραφή");
			btnView.setText("Προβολή");
			ViewBtn.setText("Προβολή");
			DepViewBtn.setText("Προβολή");
			Mngbtn.setText("Δημιουργήστε νέο HRM Χρήστη");
			tabbedPane.setTitleAt(0, "Τμήματα");
			tabbedPane.setTitleAt(1, "Εργαζομένοι");
			tabbedPane.setTitleAt(2, "Αξιολογήσεις");
			Title[0]="Διαγραφή";
		    Title[1]="Είστε σίγουρος ότι θέλετε να διαγράψετε αυτό το τμήμα?";
		    Title[2]="Είστε σίγουρος ότι θέλετε να διαγράψετε αυτόν τον υπάλληλο?";
		    Title[3]="Είστε σίγουρος ότι θέλετε να διαγράψετε αυτην την αξιολόγηση?";
		    options[0]="Ναι";
		    options[1]="Όχι";
		    btnLogout.setText("Aποσύνδεση");
		    TopLblD="Διαχείριση Τμημάτων";
		    TopLblE="Διαχείριση Εργαζομένων";
		    TopLblV="Διαχείριση Αξιολογήσεων";
		    if (tabbedPane.getSelectedIndex() == 0 )
	           {
	        	TopLabel.setText(TopLblD); 
	           }
	         else if (tabbedPane.getSelectedIndex() == 1 )
	           {
	        	TopLabel.setText(TopLblE); 
	           }
	         else  if (tabbedPane.getSelectedIndex() == 2 )
	           {
	        	TopLabel.setText(TopLblV); 
	           }
		}
		else
		{
		    TopLblD="Manage Departments";
		    TopLblE="Manage Empolyees";
		    TopLblV="Manage Valuations";
			lblChooseEmployee.setText("Choose Employee's Name");
			lblChooseDepartment.setText("Choose Department");
			lblChooseValuation.setText("Choose Employee");
			btnSearch.setText("Search");
			CreateBtn1.setText("Create");
			CreateBtn2.setText("Create");
			CreateBtn3.setText("Create");
			EditBtn1.setText("Edit");
			EditBtn2.setText("Edit");
			EditBtn3.setText("Edit");
			DelBtn1.setText("Delete");
			DelBtn2.setText("Delete");
			DelBtn3.setText("Delete");	
			btnView.setText("View");
			ViewBtn.setText("View");
			DepViewBtn.setText("View");
			Mngbtn.setText("Create NEW HRΜ");
			tabbedPane.setTitleAt(0, "Departments");
			tabbedPane.setTitleAt(1, "Employees");
			tabbedPane.setTitleAt(2, "Valuation");
			Title[0]="Delete";
		    Title[1]="Are you sure you want to delete this department";
		    Title[2]="Are you sure you want to delete this employee";
		    Title[3]="Are you sure you want to delete this valuation";
		    options[0]="Yes";
		    options[1]="No";
		    btnLogout.setText("Logout");
		    if (tabbedPane.getSelectedIndex() == 0 )
	           {
	        	TopLabel.setText(TopLblD); 
	           }
	         else if (tabbedPane.getSelectedIndex() == 1 )
	           {
	        	TopLabel.setText(TopLblE); 
	           }
	         else  if (tabbedPane.getSelectedIndex() == 2 )
	           {
	        	TopLabel.setText(TopLblV); 
	           }
		}

//------------------------Loading Lists--------------------------------------------		
		try 
		{
			String sql1 = "SELECT Title FROM department";
			
			PreparedStatement pre = null;
			pre = connsql.getConnection().prepareStatement(sql1);
			ResultSet result1 = pre.executeQuery();
			while(result1.next())
			{
				String res = result1.getString(1);
				Deplist.add(res);
			}
			
			String sql2 = "SELECT fname,lname FROM employees";
			PreparedStatement pre2 = null;
			pre2 = connsql.getConnection().prepareStatement(sql2);
			ResultSet result2 = pre2.executeQuery();
			while(result2.next())
			{
				Emplist.add(result2.getString(1)+" "+result2.getString(2));	
			}
			String sql3 = "SELECT id FROM valuation";	
			PreparedStatement pre3 = null;
			pre3 = connsql.getConnection().prepareStatement(sql3);
			ResultSet result3 = pre3.executeQuery();
			while(result3.next())
			{
				ValList.add(result3.getString(1));	
			}
		}
		catch(Exception er)
		{
		}
//---------------------------------------------------------------------------------------------------
		
//---------ActionListener----------------------------------------------------------------------------
		ValList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passingvar.jpos!="CEO")
				{
					EditBtn3.setEnabled(true);
					DelBtn3.setEnabled(true);
					ViewBtn.setEnabled(true);
				}
				else if(passingvar.jpos=="CEO")
				{
					ViewBtn.setEnabled(true);
				}
			}
		});
		
		Deplist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditBtn1.setEnabled(true);
				DelBtn1.setEnabled(true);
				DepViewBtn.setEnabled(true);
			}
		});
		
		CreateBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentForm editwindow = new DepartmentForm();
				PassingVar var = new PassingVar();
				var.setMode("CR");
				editwindow.initialize();
				editwindow.Dep();
				frmHumanResourcesManagement.dispose();
			}
		});

		EditBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepartmentForm editwindow = new DepartmentForm();
				PassingVar var = new PassingVar();
				var.setMode("ED");
				var.setDepId(Deplist.getSelectedItem());
				editwindow.initialize();
				editwindow.Dep();
				frmHumanResourcesManagement.dispose();
			}
		});
		
		DelBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
				    int code = JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),Title[1], Title[0], 0, messageType, null, options,null);
				    if(code==0)
				    {
				    	String DeplistS = Deplist.getSelectedItem();
						sqls.AfterLoginFormDeleteAction(DeplistS);
						Deplist.remove(Deplist.getSelectedIndex());
				    }
					
				}
				catch(Exception er)
				{
				
				}
			}
		});
		
		CreateBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassingVar var = new PassingVar();
				var.setMode("CR");
				var.setEmpId(Emplist.getSelectedItem());
				EmployeeForm editwindow = new EmployeeForm();
				editwindow.EmployeeFormMain2(null);
				frmHumanResourcesManagement.dispose();
			}
		});

		EditBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassingVar var = new PassingVar();
				var.setMode("ED");
				var.setEmpId(Emplist.getSelectedItem());
				EmployeeForm editwindow = new EmployeeForm();
				editwindow.EmployeeFormMain2(null);
				frmHumanResourcesManagement.dispose();
			}
		});
	
		DelBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try 
					{
						int code = JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),Title[2], Title[0], 0, messageType, null, options,null);
					    if(code==0)
					    {
					    	String[] part =Emplist.getSelectedItem().toString().split(" ");
					    	sqls.AfterLoginFormDelete1Action(part[0],part[1]);
					    	Emplist.remove(Emplist.getSelectedIndex());
					    }
					}
					catch(Exception er)
					{
	
					}
				}
			});
		
		CreateBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassingVar var = new PassingVar();
				var.setMode("CR");
				ValuationForm editwindow = new ValuationForm();
				editwindow.main(null);
				frmHumanResourcesManagement.dispose();
			}
		});
		
		EditBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassingVar var = new PassingVar();
				var.setMode("ED");
				String idval = ValList.getSelectedItem();
				var.setValId(idval);
				ValuationForm editwindow = new ValuationForm();
				editwindow.main(null);
				frmHumanResourcesManagement.dispose();
			}
		});
		
		DelBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					int code = JOptionPane.showInternalOptionDialog(frmHumanResourcesManagement.getContentPane(),Title[3], Title[0], 0, messageType, null, options,null);
				    if(code==0)
				    {
				    	String ValistS = ValList.getSelectedItem();
				    	sqls.AfterLoginFormDelete2Action(ValistS);
				    	ValList.remove(ValList.getSelectedIndex());
				    	return;
				    }
				}
				catch(Exception er)
				{
				
				}
			}
		});
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployee editwindow = new SearchEmployee();
				editwindow.SearchEmployeeMain(null);
				frmHumanResourcesManagement.dispose();
			}
		});
		
		Emplist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditBtn2.setEnabled(true);
				DelBtn2.setEnabled(true);
				btnView.setEnabled(true);
			}
		});	
		
		
		Mngbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpForm editwindow = new SignUpForm();
				editwindow.main(null);
				passingvar.SignUpId(false);
				frmHumanResourcesManagement.dispose();
				
			}
		});
		
		ViewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassingVar var = new PassingVar();
				var.setMode("VI");
				String idval = ValList.getSelectedItem();
				var.setValId(idval);
				ValuationForm editwindow = new ValuationForm();
				editwindow.main(null);
				frmHumanResourcesManagement.dispose();
			}
		});
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassingVar var = new PassingVar();
				var.setMode("VI");
				var.setEmpId(Emplist.getSelectedItem());
				EmployeeForm editwindow = new EmployeeForm();
				editwindow.EmployeeFormMain2(null);
				frmHumanResourcesManagement.dispose();
			}
		});
		
		DepViewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentForm editwindow = new DepartmentForm();
				PassingVar var = new PassingVar();
				var.setMode("VI");
				var.setDepId(Deplist.getSelectedItem());
				editwindow.initialize();
				editwindow.Dep();
				frmHumanResourcesManagement.dispose();
			}
		});

		   tabbedPane.addChangeListener(new ChangeListener() {
		        public void stateChanged(ChangeEvent e) {
		         if (tabbedPane.getSelectedIndex() == 0 )
		           {
		        	TopLabel.setText(TopLblD); 
		           }
		         else if (tabbedPane.getSelectedIndex() == 1 )
		           {
		        	TopLabel.setText(TopLblE); 
		           }
		         else  if (tabbedPane.getSelectedIndex() == 2 )
		           {
		        	TopLabel.setText(TopLblV); 
		           }
		        }
		    });
//--------------------------------------------------------------------------------------------
	}
}