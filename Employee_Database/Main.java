//Q.Create a front end to enter the salary
//details of an employee. Update the details
//of an employee If prompted. List all the
//employees whose salary falls within a
//range. Given the % of increment, update
//all salaries by the % given.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

import java.util.Scanner;
public class Java  {
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) throws SQLException {
		
		//To connect to the SQLite database 
		Connection com =DriverManager.getConnection("jdbc:sqlite:Elite.db");
		Statement mystmt=com.createStatement();
		//Creating 4 different table models to display in 4 frames
		DefaultTableModel model = new DefaultTableModel(new String[] {"empid","last_name","first_name","salary","email","Designation","yearsofexperience"}, 0);
		JTable jtbl =new JTable(model);
		DefaultTableModel model1 = new DefaultTableModel(new String[] {"empid","last_name","first_name","salary","email","Designation","yearsofexperience"}, 0);
		JTable jtbl1 =new JTable(model1);
		DefaultTableModel model2 = new DefaultTableModel(new String[] {"empid","last_name","first_name","salary","email","Designation","yearsofexperience"}, 0);
		JTable jtbl2 =new JTable(model2);
		DefaultTableModel model3 = new DefaultTableModel(new String[] {"empid","last_name","first_name","salary","email","Designation","yearsofexperience"}, 0);
		JTable jtbl3 =new JTable(model3);
//		Creating 4 JFrames
		JFrame jframe= new JFrame("Employee Data");
		JFrame jframe1=new JFrame("Employee Search");
		JFrame jframe2=new JFrame("Employee Update all salary");
		JFrame jframe3=new JFrame("Employee Promotion");
//	We enter attributes (eg:name,age) by using JLabels and JTextfields
		JLabel lastnamelabel= new JLabel("Enter Last Name: ");
		JTextField lastnamefield=new JTextField(20);
		JLabel firstnamelabel= new JLabel("Enter first Name: ");
		JTextField firstnamefield=new JTextField(20);
		JLabel idlabel=new JLabel("Enter EmpID: ");
		JTextField idfield=new JTextField(20);
		JLabel emaillabel= new JLabel("Enter email ");
		JTextField emailfield=new JTextField(20);
		JLabel salarylabel=new JLabel("Enter Salary: ");
		JTextField salaryfield=new JTextField(20);
		JLabel YOElabel=new JLabel("Years Of Expirience");
		JTextField YOEtext=new JTextField(5);
		JLabel designationlabel=new JLabel("Designation");
		JTextField designationtext= new JTextField(10);
		JLabel range1label=new JLabel("Range 1");
		JTextField range1text= new JTextField(10);
		JLabel range2label=new JLabel("Range 2");
		JTextField range2text= new JTextField(10);
//		We used JButton to do operations and to move from one frame to another
		JButton Update=new JButton("Update");
		JButton Promote=new JButton("Promote");
		JButton display=new JButton("Display");
		JButton display1=new JButton("Display");
		JButton display2=new JButton("Display");
		JButton insert=new JButton("Insert");
		JButton search=new JButton("Search ");
		JButton search1=new JButton("Search on Range");
		JButton Update2=new JButton("Update");
		JButton Update3=new JButton("Update all Employees Salary");



//1. This is to insert employee details into the database
//		ActionListener is used on the java button which gives the us the option to code what happens when the user clicks that button i.e Insert
		insert.addActionListener(new ActionListener() {
			@Override
//			Override means this is to override the element in the superclass
			public void actionPerformed(ActionEvent e) {
//			.getText() gets the text from the textfield on the panel
//				We will use these variables to put them into the sql query
				String lastname=lastnamefield.getText();//
				String firstname=firstnamefield.getText();
				String id=idfield.getText();
				String email =emailfield.getText();
				Long salary=Long.parseLong(salaryfield.getText());
				int yoe=Integer.parseInt(YOEtext.getText());			
				String desig= designationtext.getText();
				PreparedStatement mystmt=null;

				try {
//					Class.forName :This returns the class object associated with the class or interface at run time
					Class.forName("org.sqlite.JDBC");
//					we put our insert query in the prepared statement. We use question marks cause we 
					mystmt=com.prepareStatement(" Insert into employee(id,last_name,first_name,salary,email,yearsofexperience,Designation) " +"values (?,?,?,?,?,?,?)");
//					setString fills the variables instead of the '?' but we have to give them in numbering order
					mystmt.setString(1,id);
					mystmt.setString(2, lastname);
					mystmt.setString(3, firstname);
					mystmt.setLong(4, salary);
					mystmt.setString(5, email);
					mystmt.setInt(6,yoe);
					mystmt.setString(7,desig);
//					this executes the prepared Statement
					mystmt.execute();
					
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
			
		});
		display.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("org.sqlite.JDBC");					
						ResultSet MyRs= mystmt.executeQuery("select * from employee");

						while(MyRs.next()) {
							
							String er=MyRs.getString("id");
							String n=MyRs.getString("last_name");
							String f=MyRs.getString("first_name");
							String d=MyRs.getString("email");
							Long s=MyRs.getLong("salary");
							int y=MyRs.getInt("yearsofexperience");
							String de= MyRs.getString("Designation");
							
							model.addRow(new Object[] {er,n,f,d,s,y,de});
						}
						}
						catch(Exception exc) {
							exc.printStackTrace();
						}
			

			
				}
		});
		
//2.Update details when promoted
		Update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PreparedStatement Mystmt=null;
				ResultSet a=null;
//				ResultSet is an object which we can used to store the results of a sql query
				try {
					Class.forName("org.sqlite.JDBC");
					Mystmt=com.prepareStatement("Select * from employee where yearsofexperience >10");
//					resultset 'a' contains the results of the prepared statement
					a =Mystmt.executeQuery();
//					a.next is too traverse to the results of the table
					while(a.next()) {
						int eid= a.getInt("id");
						String fname= a.getString("first_name");
						//This takes the input to update and promote the employees using Dialogue box
						String desig=JOptionPane.showInputDialog("Enter the new designation for employee  "+eid+"\t  "+fname);
						
						long newsal=Long.parseLong(JOptionPane.showInputDialog("Enter the new Salary for employee  "+eid+"\t  "+fname));
						Mystmt=com.prepareStatement("Update employee set salary=?,Designation=? where id=?");
						Mystmt.setLong(1, newsal);
						Mystmt.setString(2, desig);
						Mystmt.setInt(3, eid);
						Mystmt.execute();
						
					}
				
			}
				catch(Exception exc) {
					exc.printStackTrace();
				}
		
			}
		});

		search.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe1.setVisible(true);
				jframe1.setSize(1000,800);
				jframe1.setLayout(new GridLayout(2,1));
						
			}
		});
		
		search1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				jframe1.setVisible(true);
				try {
					Class.forName("org.sqlite.JDBC");
					long range1=Long.parseLong(range1text.getText());
					long range2=Long.parseLong(range2text.getText());
					myStmt = com.prepareStatement("select * from employee where salary between "+range1+" and "+range2);
					
					
					
					myRs = myStmt.executeQuery();
					
					while (myRs.next()) {
						String er=myRs.getString("id");
						String n=myRs.getString("last_name");
						String f=myRs.getString("first_name");
						String d=myRs.getString("email");
						Long s=myRs.getLong("salary");
						int y=myRs.getInt("yearsofexperience");
						String de= myRs.getString("Designation");
						model1.addRow(new Object[] {er,n,f,d,s,y,de});
					}
					
					
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			
			}
			
		});
		Update2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PreparedStatement Mystmt=null;
				PreparedStatement MyStmt=null;
				ResultSet a=null;
				jframe2.setVisible(true);
				try {
					Class.forName("org.sqlite.JDBC");
					Mystmt=com.prepareStatement("Select * from employee");
					a =Mystmt.executeQuery();
					int up=Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of increment % :"));
					while(a.next()) {
						
						int eid = a.getInt("id");
						long m=a.getLong("salary") ;
						long newsal=((m * up)/100)+m;
						MyStmt=com.prepareStatement("Update employee set salary=? where id=?");
						MyStmt.setLong(1, newsal);
						MyStmt.setInt(2, eid);
						
						MyStmt.execute();
						
					}
				
			}
				catch(Exception exc) {
					exc.printStackTrace();
				}
		
			}
		});
		
		Update3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2.setVisible(true);
				jframe2.setSize(1000,800);
				jframe2.setLayout(new GridLayout(2,1));
						
			}
		});
		
		Promote.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe3.setVisible(true);
				jframe3.setSize(1000,800);
				jframe3.setLayout(new GridLayout(2,1));
						
			}
		});
		
		display1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");					
					ResultSet MyRs= mystmt.executeQuery("select * from employee");

					while(MyRs.next()) {
						
						String er=MyRs.getString("id");
						String n=MyRs.getString("last_name");
						String f=MyRs.getString("first_name");
						String d=MyRs.getString("email");
						Long s=MyRs.getLong("salary");
						int y=MyRs.getInt("yearsofexperience");
						String de= MyRs.getString("Designation");
						
						model2.addRow(new Object[] {er,n,f,d,s,y,de});
					}
					}
					catch(Exception exc) {
						exc.printStackTrace();
					}
		

		
			}
	});
		display2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");					
					ResultSet MyRs= mystmt.executeQuery("select * from employee");

					while(MyRs.next()) {
						
						String er=MyRs.getString("id");
						String n=MyRs.getString("last_name");
						String f=MyRs.getString("first_name");
						String d=MyRs.getString("email");
						Long s=MyRs.getLong("salary");
						int y=MyRs.getInt("yearsofexperience");
						String de= MyRs.getString("Designation");
						
						model3.addRow(new Object[] {er,n,f,d,s,y,de});
					}
					}
					catch(Exception exc) {
						exc.printStackTrace();
					}
		

		
			}
	});
		
		
		
//  Here we create panels and add them to the frames where we need to add all the labels,buttons and all textfields	
		JPanel jp1= new JPanel();
		jframe.add(jp1);
		jp1.add(lastnamelabel);
		jp1.add(lastnamefield);
		jp1.add(firstnamelabel);
		jp1.add(firstnamefield);
		jp1.add(idlabel);
		jp1.add(idfield);
		jp1.add(emaillabel);
		jp1.add(emailfield);
		jp1.add(salarylabel);
		jp1.add(salaryfield);
		jp1.add(YOElabel);
		jp1.add(YOEtext);
		jp1.add(designationlabel);
		jp1.add(designationtext);
		
		

		jp1.add(insert);
		jp1.add(display);

		
		JPanel jp2= new JPanel();
		jframe.add(jp2);
		jp2.add(Promote);
		jp2.add(search);
		jp2.add(Update3);
//		SetVisible displays the frame on the screen
		jframe.setVisible(true);
		jframe.setSize(1000,800);
		jframe.setLayout(new GridLayout(2,1));
		jp1.setLayout(new GridLayout(8,4));
		jp2.setLayout(new GridLayout(7,5));
		jframe.add(jtbl);
		
		JPanel jp3=new JPanel();
		jframe1.add(jp3);
		jp3.add(range1label);
		jp3.add(range1text);
		jp3.add(range2label);
		jp3.add(range2text);
		jp3.add(search1);
		
		jframe1.add(jtbl1);
		
		JPanel jp4=new JPanel();
		jframe2.add(jp4);
		jp4.add(Update2);
		jp4.add(display1);
		jframe2.add(jtbl2);
		
		JPanel jp5=new JPanel();
		jframe3.add(jp5);
		jp5.add(Update);
		jp5.add(display2);
		jframe3.add(jtbl3);
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
