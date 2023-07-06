package com.jspider.DemoJdbc;

import java.sql.*;
import java.util.Scanner;

//1.import package
// 2. load& register driver
//3.create the connection
//4.establish the connection
//5.create the statement
//6.execute the query
public class Demo {
	@SuppressWarnings("resource")
	static boolean flag=true;
	public static void main(String[] args) throws Exception {

		while(flag) {
			
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Insert \n2.Update \n3.Delete \n4.Fetch Data By id \n5. Exit");
		System.out.println("Enter your Choice Options");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			insertData();
			break;

		case 2:
			UpdateStudent();
			break;

		case 3:
			deleteStudentById();
			break;

		case 4:
			fetchDataById();
			break;

		case 5:
			System.exit(2200);
			break;

		default:
			System.out.println("Invalid Option");
		}
		// insertData();
		// UpdateStudent();
		// fetchDataById();
		//deleteStudentById();
		}
	}

	private static void deleteStudentById() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the StudentID");
		int id = scanner.nextInt();

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loded");
		try {
			Connection con = Utility.getConnection();
			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
			// "root");
			String query = "DELETE FROM student.std_table WHERE (std_id = ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			boolean flag1 = ps.execute();
			if (!flag1) {
				System.out.println("Deleted  Successfully...");
			} else {
				System.out.println(" NOt Deleted Successfully...");
			}
			ps.close();
			con.close();
			flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void UpdateStudent() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the StudentID");
		int id = scanner.nextInt();
	
		System.out.println("Enter the Student Email");
		String studemail = scanner.next();
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loded");
		try {
			Connection con = Utility.getConnection();
			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
			// "root");
			String query = "UPDATE student.std_table SET  std_email= ? WHERE std_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, studemail);
			ps.setInt(2, id);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Updated Successfully...");
			} else {
				System.out.println(" NOt Updated Successfully...");
			}
			ps.close();
			con.close();
			flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertData() throws ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the StudentID");
		int id = scanner.nextInt();

		System.out.println("Enter the Student Name");
		String studName = scanner.next();

		System.out.println("Enter the Student Email");
		String studemail = scanner.next();

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loded");
		Connection con = Utility.getConnection();
		// Connection con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
		// "root");

		String query = "INSERT INTO student.std_table (std_id, std_name, std_email) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, studName);
		ps.setString(3, studemail);

		int count = ps.executeUpdate();
		if (count > 0) {
			System.out.println("Inserted Successfully...");
		} else {
			System.out.println(" NOt Inserted Successfully...");
		}
		ps.close();
		con.close();
		flag=false;
	}

	private static void fetchDataById() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loded");
		// Connection con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
		// "root");
		Connection con = Utility.getConnection();
		Statement st = con.createStatement();

		ResultSet resultSet = st.executeQuery("SELECT * FROM std_table ;");

		while (resultSet.next()) {
			String result = resultSet.getString("std_id") + " " + resultSet.getString("std_name");
			System.out.println(result);
		}
		st.close();
		con.close();
		flag=false;
	}

}
