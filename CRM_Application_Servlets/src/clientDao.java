package com.CRM;

import java.sql.*;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class clientDao {
	static Connection con1 ;
	
	static PreparedStatement ps1;
	static ResultSet rs;
	public int registerclient(client c2) throws ClassNotFoundException , SQLException {
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
			
			
			ps1 = con1.prepareStatement("Insert into Client(clid,cliname,cliphno,cliaddress,companyname)" +  " values(?,?,?,?,?)");
			ps1.setInt(1, Integer.parseInt(c2.getClid()));
			ps1.setString(2, c2.getCliname());
			ps1.setString(3, c2.getCliphno());
			ps1.setString(4, c2.getCliaddress());
			ps1.setString(5, c2.getCompanyname());
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

