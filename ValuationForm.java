import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.List;

public class ValuationForm {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValuationForm window = new ValuationForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ValuationForm() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 474, 492);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("HUMAN RESOURCES MANAGEMENT SOFTWARE");
		
		PassingVar var = new PassingVar();
		JLabel lblProductivity = new JLabel("");
		lblProductivity.setBounds(212, 45, 108, 14);
		frame.getContentPane().add(lblProductivity);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(326, 42, 118, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("★");
		comboBox.addItem("★★");
		comboBox.addItem("★★★");
		comboBox.addItem("★★★★");
		comboBox.addItem("★★★★★");
		
		JLabel lblCommunication = new JLabel("");
		lblCommunication.setBounds(212, 96, 108, 14);
		frame.getContentPane().add(lblCommunication);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(326, 93, 118, 20);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("★");
		comboBox_1.addItem("★★");
		comboBox_1.addItem("★★★");
		comboBox_1.addItem("★★★★");
		comboBox_1.addItem("★★★★★");
		
		JLabel lblCapability = new JLabel("");
		lblCapability.setBounds(212, 147, 108, 14);
		frame.getContentPane().add(lblCapability);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(326, 144, 118, 20);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem("★");
		comboBox_2.addItem("★★");
		comboBox_2.addItem("★★★");
		comboBox_2.addItem("★★★★");
		comboBox_2.addItem("★★★★★");
		
		JLabel lblOrganisation = new JLabel("");
		lblOrganisation.setBounds(212, 198, 108, 14);
		frame.getContentPane().add(lblOrganisation);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(326, 195, 118, 20);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addItem("★");
		comboBox_3.addItem("★★");
		comboBox_3.addItem("★★★");
		comboBox_3.addItem("★★★★");
		comboBox_3.addItem("★★★★★");
		
		JLabel lblTeamwork = new JLabel("");
		lblTeamwork.setBounds(212, 249, 108, 14);
		frame.getContentPane().add(lblTeamwork);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(326, 246, 118, 20);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addItem("★");
		comboBox_4.addItem("★★");
		comboBox_4.addItem("★★★");
		comboBox_4.addItem("★★★★");
		comboBox_4.addItem("★★★★★");
		
		JLabel lblAdaptabillity = new JLabel("");
		lblAdaptabillity.setBounds(212, 300, 108, 14);
		frame.getContentPane().add(lblAdaptabillity);
		
		JLabel TopLbl = new JLabel("");
		TopLbl.setBounds(10, 11, 434, 14);
		frame.getContentPane().add(TopLbl);

		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(326, 297, 118, 20);
		frame.getContentPane().add(comboBox_5);
		comboBox_5.addItem("★");
		comboBox_5.addItem("★★");
		comboBox_5.addItem("★★★");
		comboBox_5.addItem("★★★★");
		comboBox_5.addItem("★★★★★");
		
		JLabel lblDedication = new JLabel("");
		lblDedication.setBounds(212, 351, 108, 14);
		frame.getContentPane().add(lblDedication);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(326, 348, 118, 20);
		frame.getContentPane().add(comboBox_6);
		comboBox_6.addItem("★");
		comboBox_6.addItem("★★");
		comboBox_6.addItem("★★★");
		comboBox_6.addItem("★★★★");
		comboBox_6.addItem("★★★★★");
		
		JButton btnNewButton = new JButton("");
		
		
		JButton btnCancel = new JButton("");
		btnCancel.setBounds(252, 420, 192, 23);
		frame.getContentPane().add(btnCancel);
		
		List list = new List();
		list.setBounds(10, 65, 196, 378);
		frame.getContentPane().add(list);
		
		JLabel lblChooseEmplyee = new JLabel("");
		lblChooseEmplyee.setBounds(10, 45, 196, 14);
		frame.getContentPane().add(lblChooseEmplyee);
		
		SqlStatements sqls = new SqlStatements();
		String TopLblC;
		String TopLblE;
		String TopLblV;
//-------------------------------Listeners---------------------------------------------------------------\
		
		if (var.language=="GR")
		{
			lblChooseEmplyee.setText("Διαλέξτε Διαθέσιμο Υπάλληλο");
			lblProductivity.setText("Επίδοση");
			lblCommunication.setText("Επικοινωνία");
			lblCapability.setText("Ικανότητα");
			lblOrganisation.setText("Οργανωτικότητα");
			lblTeamwork.setText("Ομαδικότητα");
			lblAdaptabillity.setText("Προσαρμοστικότητα");
			lblDedication.setText("Ποσήλωση");
			btnNewButton.setText("Αποθήκευση");
			btnCancel.setText("Άκυρο");
		    TopLblC="Νέα Αξιολόγηση";
		    TopLblE="Επεξεργασία Αξιολόγισης";
		    TopLblV="Προβολή Αξιολόγησης";
		}
		else
		{
			lblChooseEmplyee.setText("Choose Emplοyee");
			lblProductivity.setText("Productivity");
			lblCommunication.setText("Communication");
			lblCapability.setText("Capability");
			lblOrganisation.setText("Organisation");
			lblTeamwork.setText("Teamwork");
			lblAdaptabillity.setText("Adaptabillity");
			lblDedication.setText("Dedication");
			btnNewButton.setText("Submit");
			btnCancel.setText("Cancel");
		    TopLblC="New Valuation";
		    TopLblE="Edit Valuation";
		    TopLblV="View Valuation";
		}
//-------------------------------------------------------------------------------------------------------
//----------------------------View Mode------------------------------------------------------------------
		if(var.mode=="VI")
		{
			btnNewButton.setVisible(false);
			comboBox_1.setEnabled(false);
			comboBox.setEnabled(false);
			comboBox_2.setEnabled(false);
			comboBox_3.setEnabled(false);
			comboBox_4.setEnabled(false);
			comboBox_5.setEnabled(false);
			comboBox_6.setEnabled(false);
			TopLbl.setText(TopLblV);
		}
		else if(var.mode=="CR")
		{TopLbl.setText(TopLblC);}
		else if(var.mode=="ED")
		{TopLbl.setText(TopLblE);}
//-------------------------------------------------------------------------------------------------------
//-------------------------------Listeners---------------------------------------------------------------
		SqlConn connsql = new SqlConn();
		try{	
			if (var.mode=="CR")
			{
					ResultSet result3 = sqls.ValuationCreate();
					while(result3.next())
					{
						list.addItem(result3.getString("id"));
					}
				
			}
			else if ((var.mode=="ED")||(var.mode=="VI"))
			{
					list.addItem(var.idVal);
					ResultSet result4 = sqls.ValuationEdit(var.idVal);
					while(result4.next())
					{
						comboBox.setSelectedIndex(result4.getInt("prod"));
						comboBox_1.setSelectedIndex(result4.getInt("comm"));
						comboBox_2.setSelectedIndex(result4.getInt("cap"));
						comboBox_3.setSelectedIndex(result4.getInt("org"));
						comboBox_4.setSelectedIndex(result4.getInt("team"));
						comboBox_5.setSelectedIndex(result4.getInt("adap"));
						comboBox_6.setSelectedIndex(result4.getInt("dedic"));
					}
			}
		}
		catch(Exception error)
		{
			
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try
			{
				sqls.ValuationCreateAction(list.getSelectedItem(), comboBox.getSelectedIndex(), comboBox_1.getSelectedIndex(), comboBox_2.getSelectedIndex(), comboBox_3.getSelectedIndex(), comboBox_4.getSelectedIndex(), comboBox_5.getSelectedIndex(), comboBox_6.getSelectedIndex(),var.mode);
				JOptionPane.showMessageDialog(null, "Valuation has been successfully created");  
				frame.dispose();
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
			}
			catch(Exception error)
			{
				
			}
			}
		});
		btnNewButton.setBounds(252, 388, 192, 23);
		frame.getContentPane().add(btnNewButton);

		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				var.setMode(null);
				AfterLoginForm alf = new AfterLoginForm();
				alf.main(null);
			}
		});
//------------------------------------------------------------------------------------------------------
	}
}
