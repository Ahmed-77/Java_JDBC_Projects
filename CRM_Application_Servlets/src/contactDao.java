package com.CRM;

import java.sql.*;
import java.sql.SQLException;

public class contactDao {
	static Connection con1 ;
	
	static PreparedStatement ps1;
	static ResultSet rs;
	public int registercontact(contact c3) throws ClassNotFoundException , SQLException {
		Class.forName("org.sqlite.JDBC");
		
		System.out.print("Connecting...");
		int result=0;
		
		try {
			con1=DriverManager.getConnection("jdbc:sqlite:/home/ahmed/eclipse-workspace/CR/RM.sqlite");
		
			System.out.print("Connection to sqlite");
		
			
			ps1 = con1.prepareStatement("Insert into ContactDetails(coid,coname,cophno,coemail)" +  " values(?,?,?,?)");
			ps1.setInt(1, Integer.parseInt(c3.getCoid()));
			ps1.setString(2, c3.getConame());
			ps1.setString(3, c3.getCophno());
			ps1.setString(4, c3.getCoemail());
			
			System.out.println(ps1)	;
			
			result=ps1.executeUpdate();
			con1.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return result;
	}



}

