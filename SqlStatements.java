import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SqlStatements {
	SqlConn connsql = new SqlConn();
	PassingVar passingvar = new PassingVar();
	
	public boolean LoginAction(String username, String password, String job) throws SQLException, Exception
	{
		String sql;
		
		if(job =="Manager")
		{
			 sql = "SELECT * FROM manager WHERE username = '"+ username +"'AND password = '"+ password +"'";
		}
		else
		{
			 sql = "SELECT * FROM login WHERE Username = '"+ username +"'AND Password = '"+ password +"'AND Job = '" + job +"'";
		}
		
		PreparedStatement pre = null;
		pre = connsql.getConnection().prepareStatement(sql);
		ResultSet result = pre.executeQuery();
		return result.next();
	}
	
// 				AfterLoginForm	
//				--------------
	public boolean AfterLoginFormDeleteAction(String DeplistS) throws SQLException, Exception 
	{
		
		String sql6 = "UPDATE manager SET DepId = NULL WHERE DepId='"+DeplistS+"'";
		PreparedStatement pre6 = null;
		pre6 = connsql.getConnection().prepareStatement(sql6);
		int result6 = pre6.executeUpdate();
		System.out.println("result6  "+result6);
		
		String sql5 = "DELETE FROM department WHERE Title = '"+DeplistS+"' ";
		PreparedStatement pre5 = null;
		pre5 = connsql.getConnection().prepareStatement(sql5);
		int result5 = pre5.executeUpdate();	
		
		if (result5==1)
		{return true;}
		else{return false;}
		
	}
	
	public boolean AfterLoginFormDelete1Action(String First, String Second) throws SQLException, Exception 
	{
		boolean ret = false;
		String sql7 = "SELECT id FROM employees WHERE fname = '"+First+"' && lname='"+Second+"'";
		String DelId = null;
		PreparedStatement pre7 = null;
		pre7 = connsql.getConnection().prepareStatement(sql7);
		ResultSet result7 = pre7.executeQuery();
		while(result7.next())
		{
			DelId=result7.getString("id");	
			ret=true;
		}
		
		String sql5 = "DELETE FROM employees WHERE id='"+DelId+"'";
		PreparedStatement pre5 = null;
		pre5 = connsql.getConnection().prepareStatement(sql5);
		int result5 =pre5.executeUpdate();		
		
		String sql6="DELETE FROM valuation WHERE id = '"+DelId+"'";
		PreparedStatement pre6 = null;
		pre6 = connsql.getConnection().prepareStatement(sql6);
		int result6 =pre6.executeUpdate();
		return ret;

	}
	
	public int AfterLoginFormDelete2Action(String valist) throws SQLException, Exception
	{
		String sql4 = "DELETE FROM valuation WHERE id = '"+valist+"' ";
		System.out.println(sql4);
		PreparedStatement pre4 = null;
		pre4 = connsql.getConnection().prepareStatement(sql4);
		int result = pre4.executeUpdate();
		
		return result;
	}

	
//			Department
	
	public ResultSet DepartmentEditCreate(String title) throws SQLException, Exception
	{
		String sql2 = "SELECT * FROM department  WHERE Title='"+title+"'";
		System.out.println(sql2);
		PreparedStatement pre = null;
		pre = connsql.getConnection().prepareStatement(sql2);
		ResultSet result1 = pre.executeQuery();
		
		return result1;
	}
	
	public boolean DepartmentEditAction(String First, String Second, String title1, String loc1, String dec1,String MngCombo, String sqltitle)throws SQLException, Exception
	{
		boolean res=false;
		String sql9 = "SELECT username FROM manager WHERE fname='"+First+"' && lname='"+Second+"'";
		String DepMngId=null;
		PreparedStatement pre9 = null;
		pre9 = connsql.getConnection().prepareStatement(sql9);
		ResultSet result9 = pre9.executeQuery();
		while(result9.next())
		{
			DepMngId=result9.getString("username");
			res=true;
		}
		
		String sql3 = "UPDATE department SET Title='"+title1+"',Location='"+loc1+"',Description='"+dec1+"',"
				+ "MngId='"+MngCombo+"'WHERE Title='"+sqltitle+"'";
				PreparedStatement pre1 = null;
				pre1 = connsql.getConnection().prepareStatement(sql3);
				int result1=pre1.executeUpdate();
				
				String sql8="UPDATE manager SET DepId='"+title1+"'"
				+ " WHERE username ='"+DepMngId+"'";
				System.out.println(sql8);
				PreparedStatement pre8 = null;
				pre8 = connsql.getConnection().prepareStatement(sql8);
				int result8=pre8.executeUpdate();
				
				System.out.println(res+" "+result1+" "+result8+" ");
				if (res==true && result1==1 && result8==1)
				{return true;}
				else
				{return false;}
	}
	
	public boolean DepartmentCreate(String First,String titletext, String loctext, String dectext, String MngCombo) throws SQLException, Exception
	{
		String sql7 = "INSERT INTO department (Title,Location,Description,MngId) VALUES "
				+ "('"+titletext+"','"+loctext+"','"+dectext+"','"+MngCombo+"')";
				PreparedStatement pre5 = null;
				pre5 = connsql.getConnection().prepareStatement(sql7);
				int result5 = pre5.executeUpdate();
				
				String sql6 = "UPDATE manager SET DepId='"+titletext+"' WHERE fname='"+First+"'";
				PreparedStatement pre4 = null;
				pre4 = connsql.getConnection().prepareStatement(sql6);
				int result4 = pre4.executeUpdate();
				System.out.println(result5+" "+result4);
				if (result5==1 && result4==1)
				{
					return true;
				}
				else
				{return false;}
				
			
	}
	
//			Employee
	
	
	public ResultSet EmployeeEditView1(String F, String L) throws SQLException, Exception
	{

		String sql5 = "SELECT id FROM employees WHERE fname ='"+F+"' && lname='"+L+"'";
		PreparedStatement pre5 = null;
		pre5 = connsql.getConnection().prepareStatement(sql5);
		ResultSet result5 = pre5.executeQuery();

		return result5;
	}
	public ResultSet EmployeeEditView2(String EmpId) throws SQLException, Exception
	{
		String sql1 = "SELECT * FROM employees WHERE id = '"+EmpId+"'";
		PreparedStatement pre = null;
		pre = connsql.getConnection().prepareStatement(sql1);
		ResultSet result1 = pre.executeQuery();
		
		return result1;
	}
	
	public boolean EmployeeCreateAction(String idtext,String ftext,String ltext,String depcombo,String postext,String mailtext,String phonetext,String addresstext,String wagetext,String yictext) throws SQLException, Exception
	{
		String sql2 = "INSERT INTO employees (id,fname,lname,dep,pos,mail,phone,address,wage,yic) VALUES ('"+idtext+"','"+ftext+"','"+ltext+"','"+depcombo+"','"+postext+"','"+mailtext+"','"+phonetext+"','"+addresstext+"','"+wagetext+"','"+yictext+"')";
		PreparedStatement pre = null;
		System.out.println(sql2);
		pre = connsql.getConnection().prepareStatement(sql2);
		int result1 = pre.executeUpdate();
		if (result1 == 1)
		{return true;}
		else
		{return false;}
	}
	
	public boolean EmployeeEditAction(String idtext,String ftext,String ltext,String depcombo,String postext,String mailtext,String phonetext,String addresstext,String wagetext,String yictext,String EmpId) throws SQLException, Exception
	{
		String sql3 = "UPDATE employees SET id='"+idtext+"',fname='"+ftext+"',lname='"+ltext+"',dep='"+depcombo+"',pos='"+postext+"',mail='"+mailtext+"',phone='"+phonetext+"',address='"+addresstext+"',wage='"+wagetext+"',yic='"+yictext+"' WHERE id='"+EmpId+"'";
		PreparedStatement pre1 = null;
		pre1 = connsql.getConnection().prepareStatement(sql3);
		int result2 = pre1.executeUpdate();
		
		if (result2 == 1)
		{return true;}
		else
		{return false;}
	}

	
//		Manager
	
	
	public boolean ManagerAction(String ftext,String ltext,String wagetext,String mailtext,String addresstext,String phonetext,String usertext,String passtext) throws SQLException, Exception
	{
		String sql = "INSERT INTO manager (fname,lname,wage,mail,address,phone,username,password) "
				+ "VALUES ('"+ftext+"','"+ltext+"','"+wagetext+"'"
				+ ",'"+mailtext+"','"+addresstext+"','"+phonetext+"'"
				+ ",'"+usertext+"','"+passtext+"')";
				PreparedStatement pre = null;
				pre = connsql.getConnection().prepareStatement(sql);
				int result = pre.executeUpdate();
				if (result == 1)
				{return true;}
				else
				{return false;}
	}

//			Registration
	
	public boolean Registration(String username,String password) throws SQLException, Exception
	{
		String sql = "SELECT * FROM login WHERE Username = "
		+ "'"+ username +"'AND Password = '"+ password +"'AND Job = 'Manager'";
		PreparedStatement pre = null;
		pre = connsql.getConnection().prepareStatement(sql);
		ResultSet result = pre.executeQuery();
		if (result.next())
		{	
			String sql2="DELETE FROM login WHERE Username = '"+username+"'";
			System.out.println(sql2);
			PreparedStatement pre2 = null;
			pre2 = connsql.getConnection().prepareStatement(sql2);
			pre2.executeUpdate();
			return true;
		}
		else
		{return false;}
		
	}
	
//				SearchEmployee
	
	public ResultSet SearchEmployee(String id, String fname, String lname, String dep, String pos, String mail, String phone, String address, String wage, String yic) throws SQLException, Exception
	{
		String sql1 = "SELECT * FROM employees WHERE ";
		if (!id.isEmpty()){
			sql1+="id='"+id+"' AND ";
		}
		if (!fname.isEmpty()){
			sql1+="fname='"+fname+"' AND ";
		}
		if (!lname.isEmpty()){
			sql1+="lname='"+lname+"' AND ";
		}
		if (!dep.isEmpty()){
			sql1+="dep='"+dep+"' AND ";
		}
		if (!pos.isEmpty()){
			sql1+="pos='"+pos+"' AND ";
		}
		if (!mail.isEmpty()){
			sql1+="mail='"+mail+"' AND ";
		}
		if (!phone.isEmpty()){
			sql1+="phone='"+phone+"' AND ";
		}
		if (!address.isEmpty()){
			sql1+="address='"+address+"' AND ";
		}
		if (!wage.isEmpty()){
			sql1+="wage='"+wage+"' AND ";
		}
		if (!yic.isEmpty()){
			sql1+="yic='"+yic+"' AND ";
		}
		sql1=sql1.substring(0, sql1.length() - 5);

		PreparedStatement pre = null;
		pre = connsql.getConnection().prepareStatement(sql1);
		ResultSet result1 = pre.executeQuery();
		return result1;
	}
	
//		SignUpForm
	
	public boolean SignUpFormActions(String username, String password, String mailtext) throws SQLException, Exception
	{
		String  sql = "INSERT INTO login (Job,Username,Password,Email) VALUES "
				 + "('Manager','"+username+"','"+password+"','"+mailtext+"')";
		 
			PreparedStatement pre = null;
			pre = connsql.getConnection().prepareStatement(sql);
			int result = pre.executeUpdate();
			Mail mail = new Mail();
			mail.generateAndSendEmail(mailtext,username, password);
			if (result == 1)
			{return true;}
			else
			{return false;}
	}
	
//			VALUATION
	
	public ResultSet ValuationCreate() throws SQLException, Exception
	{
		String sql3 = "SELECT id  FROM employees WHERE id NOT IN (SELECT id FROM valuation)";//INNER JOIN valuation ON valuation.id = employees.id";
		PreparedStatement pre3 = null;
		pre3 = connsql.getConnection().prepareStatement(sql3);
		ResultSet result3 = pre3.executeQuery();
		
		return result3;
	}
	
	
	
	public ResultSet ValuationEdit(String id) throws SQLException, Exception
	{
		
		String sql4 = "SELECT * FROM valuation  WHERE id = '"+id+"' ";
		PreparedStatement pre4 = null;
		pre4 = connsql.getConnection().prepareStatement(sql4);
		ResultSet result4 = pre4.executeQuery();
		return result4;
	}
	
	
	public boolean ValuationCreateAction(String id, int prod, int comm, int cap, int org, int team, int adap, int dedic,String mode) throws SQLException, Exception
	{
		if (mode=="CR")
		{
				
				String sql1 = "INSERT INTO valuation (id,prod,comm,cap,org,team,adap,dedic) "
				+ "VALUES ('"+id+"','"+prod+"','"+comm+"','"+cap+"','"+org+"','"+team+"'"
				+ ",'"+adap+"','"+dedic+"')";
				PreparedStatement pre = null;
				pre = connsql.getConnection().prepareStatement(sql1);
				int result1 = pre.executeUpdate();
				if (result1 == 1)
				{return true;}
				else
				{return false;}
		}
		else if (mode=="ED")
		{	
			String sql3 = "UPDATE valuation SET prod='"+prod+"',comm='"+comm+"',cap='"+cap+"'"
			+ ",org='"+org+"',team='"+team+"',adap='"+adap+"',dedic='"+dedic+"' "
			+ "WHERE id='"+id+"'";
			PreparedStatement pre1 = null;
			pre1 = connsql.getConnection().prepareStatement(sql3);
			int result2 = pre1.executeUpdate();	
			if (result2==1)
			{return true;}
			else
			{return false;}
		}
		else
			return false;
	}	
}
