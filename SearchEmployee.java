import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.ibm.icu.util.BytesTrie.Result;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JTextField;

public class SearchEmployee {
	private JFrame frame;
	public static void SearchEmployeeMain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmployee window = new SearchEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SearchEmployee() {
		initialize();

	}
	public static String listres=null;
	public static String fn=null;
	public static String ln=null;
	public static String sec=null;
	public static String posit=null;
	public static String m=null;
	public static String tel=null;
	public static String add=null;
	public static String wg=null;
	public static String yinc=null;

	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 724, 378);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		
		Label label = new Label("");
		label.setBounds(6, 6, 134, 22);
		frame.getContentPane().add(label);
		
		JTextField idtext = new JTextField();
		idtext.setBounds(175, 6, 205, 22);
		frame.getContentPane().add(idtext);
		
		Label label_1 = new Label("");
		label_1.setBounds(6, 34, 134, 22);
		frame.getContentPane().add(label_1);
		
		JTextField ftext = new JTextField();
		ftext.setBounds(175, 34, 205, 22);
		frame.getContentPane().add(ftext);
		
		Label label_2 = new Label("");
		label_2.setBounds(6, 62, 134, 22);
		frame.getContentPane().add(label_2);
		
		JTextField ltext = new JTextField();
		ltext.setBounds(175, 62, 205, 22);
		frame.getContentPane().add(ltext);
		
		Label label_3 = new Label("");
		label_3.setBounds(6, 90, 134, 22);
		frame.getContentPane().add(label_3);
		
		JTextField deptext = new JTextField();
		deptext.setBounds(175, 90, 205, 22);
		frame.getContentPane().add(deptext);
		
		Label label_4 = new Label("");
		label_4.setBounds(6, 118, 134, 22);
		frame.getContentPane().add(label_4);
		
		JTextField postext = new JTextField();
		postext.setBounds(175, 118, 205, 22);
		frame.getContentPane().add(postext);
		
		Label label_5 = new Label("");
		label_5.setBounds(6, 146, 134, 22);
		frame.getContentPane().add(label_5);
		
		JTextField mailtext = new JTextField();
		mailtext.setBounds(175, 146, 205, 22);
		frame.getContentPane().add(mailtext);
		
		Label label_6 = new Label("");
		label_6.setBounds(6, 174, 134, 22);
		frame.getContentPane().add(label_6);
		
		JTextField phtext = new JTextField();
		phtext.setBounds(175, 174, 205, 22);
		frame.getContentPane().add(phtext);
		
		Label label_7 = new Label("");
		label_7.setBounds(6, 202, 134, 22);
		frame.getContentPane().add(label_7);
		
		JTextField adtext = new JTextField();
		adtext.setBounds(175, 202, 205, 22);
		frame.getContentPane().add(adtext);
		
		Label label_8 = new Label("");
		label_8.setBounds(6, 230, 134, 22);
		frame.getContentPane().add(label_8);
		
		JTextField wgtext = new JTextField();
		wgtext.setBounds(175, 230, 205, 22);
		frame.getContentPane().add(wgtext);
		
		Label label_9 = new Label("");
		label_9.setBounds(6, 258, 134, 22);
		frame.getContentPane().add(label_9);
		
		JTextField yictext = new JTextField();
		yictext.setBounds(175, 258, 205, 22);
		frame.getContentPane().add(yictext);


		JButton btnClear = new JButton("");
		btnClear.setBounds(140, 307, 110, 23);
		frame.getContentPane().add(btnClear);
		
		List list = new List();
		list.setBounds(386, 6, 312, 324);
		frame.getContentPane().add(list);
		JButton btnCancel = new JButton("");
		btnCancel.setBounds(270, 307, 110, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnSearch = new JButton();
		btnSearch.setBounds(10, 307, 110, 23);
		frame.getContentPane().add(btnSearch);
		SqlStatements sqls = new SqlStatements();
		
//-----------------------------------Language----------------------------------------------
		PassingVar passingvar = new PassingVar();
		String language = passingvar.language;
		if(language=="GR")
		{
			btnSearch.setText("Αποδοχή");
			btnClear.setText("Καθαρισμός");
			btnCancel.setText("Άκυρο");
			label.setText("ID");
			label_1.setText("Όνομα");
			label_2.setText("Επίθετο");
			label_3.setText("Τμήμα");
			label_4.setText("Θέση");
			label_5.setText("E-Mail");
			label_6.setText("Τηλέφωνο");
			label_7.setText("Διεύθηνση");
			label_8.setText("Μισθός");
			label_9.setText("Χρόνια στην εταιρία");
			listres="Αποτελέσματα Αναζήτησης";
			fn="Όνομα";
			ln="Επίθετο";
			sec="Τμήμα";
			posit="Θέση";
			m="E-Mail";
			tel="Τηλέφωνο";
			add="Διεύθηνση";
			wg="Μισθός";
			yinc="Χρόνια στην εταιρία";
		}
		else
		{
			btnSearch.setText("Submit");
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
			listres="Search Results";
			fn="First Name";
			ln="Last Name";
			sec="Department";
			posit="Position";
			m="E-Mail";
			tel="Phone Number";
			add="Address";
			wg="Wage";
			yinc="Years in company";
		}
//-----------------------------------------------------------------------------------------
//----------------------------Listeners----------------------------------------------------		
		SqlConn connsql = new SqlConn();

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					list.removeAll();
					list.add(listres);
					ResultSet result1 = sqls.SearchEmployee(idtext.getText(), ftext.getText(), ltext.getText(), deptext.getText(), postext.getText(), mailtext.getText(),  phtext.getText(), adtext.getText(), wgtext.getText(), yictext.getText());
					while(result1.next())
					{
						list.add("ID : "+result1.getString("id"));
						list.add(fn+" : "+result1.getString("fname"));
						list.add(ln+" : "+result1.getString("lname"));
						list.add(sec+" : "+result1.getString("dep"));
						list.add(posit+" : "+result1.getString("pos"));
						list.add(m+" : "+result1.getString("mail"));
						list.add(tel+" : "+result1.getString("phone"));
						list.add(add+" : "+result1.getString("address"));
						list.add(wg+" : "+result1.getString("wage"));
						list.add(yinc+" : "+result1.getString("yic"));
						list.add("---------------------------");
					}
				}
				catch(Exception er)
				{
					System.out.println(er);
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idtext.setText("");
				ftext.setText("");
				ltext.setText("");
				deptext.setText("");
				postext.setText(""); 
				mailtext.setText("");
				wgtext.setText("");
				adtext.setText("");
				phtext.setText("");
				yictext.setText("");
				list.removeAll();
			}
		});
//-------------------------------------------------------------------------------------------------
	}
}
