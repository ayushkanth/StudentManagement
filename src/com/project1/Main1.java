package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student";
			String user="root";
			String password ="Ayush";
			
			Connection con =  DriverManager.getConnection(url,user,password);
			Scanner sc =new Scanner(System.in);
			
			
			  label:
				while(true) {
					System.out.println("MAIN MENU");
					System.out.println("===========");
					System.out.println("Press 1 for adding data");
					System.out.println("Press 2 for deleting data");
					System.out.println("Press 3 for showing data");
					System.out.println("Press 4 for exit");
					int option=sc.nextInt();
					System.out.println("\n");
					
					Statement st= con.createStatement();
					
					switch(option) {
					case 1:  
							Scanner sc1 =new Scanner(System.in);
							
							
							System.out.println("Enter name: ");
							String name=sc1.nextLine();
							
							System.out.println("Enter age: ");
							String age=sc1.nextLine();
							
							System.out.println("Enter city: ");
							String city=sc1.nextLine();
							
							 String q="insert into student(S_Name,S_Age,S_City) values(?,?,?)";
					         PreparedStatement pstmt=con.prepareStatement(q);
					          pstmt.setString(1,name);
					          pstmt.setString(2, age);
					          pstmt.setString(3, city);
					          pstmt.execute();
					         System.out.println("\nAdded Successful \n");
							break;
							
					case 2:	String id;
							System.out.println("Enter id to be deleted: ");
							id=sc.next();
							String q2="delete from student where s_id=?";
			         		PreparedStatement pstmt2=con.prepareStatement(q2);
			         		pstmt2.setString(1,id);
			         		pstmt2.execute();
			         		System.out.println("\nDeleted Successful \n");
			         		break;
						
					case 3: String query="SELECT * FROM student";
							ResultSet set=st.executeQuery(query);
							
							while(set.next()) {
								System.out.println("--------------------------");
								System.out.println("Student Id: "+ set.getString("S_ID"));
								System.out.println("Student Age: "+ set.getString("S_Name"));
								System.out.println("Student Age: "+ set.getString("S_Age"));
								System.out.println("Student City: "+ set.getString("S_City"));
								System.out.println("--------------------------\n");
							}
							
							break;
							
					case 4: break label;
					
					default:	System.out.println("Wrong input!!");
					
					}
				
				
			}
				
				System.out.println("Thanks!!");
				
			
			
			
//			if(con != null) {
//				System.out.println("Connection is successful");
//			}
//			else {
//				System.out.println("Connection interrupted!");
//			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
