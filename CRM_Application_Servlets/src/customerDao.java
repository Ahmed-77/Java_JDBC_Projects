package com.CRM;

import java.sql.*;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class customerDao {
	static Connection con1 ;
	
	static PreparedStatement ps1;
//	static ResultSet rs;
	public int registercustomer(customer c) throws ClassNotFoundException , SQLException {
		Class.forName("org.sqlite.JDBC");
		
		System.out.print("Connecting...");
		int result=0;
		
		try {
			con1=DriverManager.getConnection("jdbc:sqlite:/home/ahmed/eclipse-workspace/CR/RM.sqlite");
//			Class.forName("org.sqlite.JDBC");
			System.out.print("Connection to sqlite");
			//Inserting values into the info table.
			//info table contents :-
			//create table info(userid varchar(10),landlord varchar(20),tenant varchar(20),address varchar(40),city varchar(20),doa varchar(10),
			//dor varchar(10),duration varchar(10),rent numeric,deposit numeric,witness varchar(10));
			
			
			ps1 = con1.prepareStatement("Insert into Customer1(cusid,cusname,cusphno,cusaddress,cuscity)" +  " values(?,?,?,?,?)");
			System.out.println(Integer.parseInt(c.getCusid()))	;
			ps1.setInt(1, Integer.parseInt(c.getCusid()));
			ps1.setString(2, c.getCusname());
			ps1.setString(3, c.getCusphno());
			ps1.setString(4, c.getCusaddress());
			ps1.setString(5, c.getCuscity());
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

