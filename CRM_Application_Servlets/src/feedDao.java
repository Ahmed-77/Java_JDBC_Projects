package com.CRM;

import java.sql.*;
import java.sql.SQLException;

public class feedDao {
	static Connection con1 ;
	
	static PreparedStatement ps1;
	static ResultSet rs;
	public int registerfeed(Feedback f) throws ClassNotFoundException , SQLException {
		Class.forName("org.sqlite.JDBC");
		
		System.out.print("Connecting...");
		int result=0;
		
		try {
			con1=DriverManager.getConnection("jdbc:sqlite:/home/ahmed/eclipse-workspace/CR/RM.sqlite");
//			
			System.out.print("Connection to sqlite");
		
			int rate=Integer.parseInt(f.getRating());
			if(rate>10)
				rate=10;
			
			ps1 = con1.prepareStatement("Insert into Feedback(id,name,improv,feed,rating,phno)" +  " values(?,?,?,?,?,?)");
			ps1.setInt(1, Integer.parseInt(f.getId()));
			ps1.setString(2, f.getName());
			ps1.setString(3, f.getImprov());
			ps1.setString(4, f.getFeed());
			ps1.setInt(5, rate);
			ps1.setString(6, f.getPhno());
			
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

