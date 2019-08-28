package com.lms;

import java.util.Scanner;
import java.sql.*;
import java.io.*;

public class CRUD {
	Connection con;
	PreparedStatement ps;
	

	public static void main(String[] args) {
		library();
	}

	public void insertEmp(int getBooknumber, String getBookname, int getBookprice) {
		try {
			
			ps = con.prepareStatement("insert into addbook(booknumber,bookname,bookprice) values('"+ book.getBooknumber() + "','" + book.getBookname() + "','" + book.getBookprice() + "')");

			System.out.println("" + book.getBooknumber());

			int i = ps.executeUpdate();

			if (i != 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("not Inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmp(int getBooknumber, String getBookname, int getBookprice) {
		try {

			ps = con.prepareStatement("update addbook set '" + book.getBookname() + "','" + book.getBookprice()
					+ "' where '" + book.getBooknumber() + "' ");

			System.out.println("" + book.getBooknumber());

			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("updated");
			} else {
				System.out.println("not updated");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteEmp(int getBooknumber) {
		try {

			ps = con.prepareStatement("delete from addbook where '" + book.getBooknumber() + "'");
			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("deleted");
			} else {
				System.out.println("not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispAll() {
		try {

			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from addbook");
			while (res.next()) {
				System.out.print(res.getString(1) + "\n");
				System.out.print(res.getString(2) + "\n");
				System.out.print(res.getString(3) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dispAnEmp(int s) {
		try {

			ps = con.prepareStatement("select * from addbook where '" + book.getBooknumber() + "'");
			ps.setInt(1, s);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.print(res.getString(1) + "\n");
				System.out.print(res.getString(2) + "\n");
				System.out.print(res.getString(3) + "\n");
				System.out.print(res.getString(4) + "\n");
				System.out.print(res.getString(5) + "\n");
				System.out.print(res.getString(6) + "\n");
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void library() {
		Scanner a = new Scanner(System.in);
		try {

			CRUD obj = new CRUD();
			int ch = 0;
			while (true) {
				System.out.println("Library management \n" + "1. Add Book \n " + "2. Edit Book \n "
						+ "3. Delete Book \n " + "4. Display all Book \n" + "5.Display a Book");
			
				int choice=a.nextInt();
				switch (choice) {
				case 1: {

					System.out.println("Enter Book number");
					int getBooknumber = a.nextInt();
					System.out.println("Enter Book Name");
					String getBookname = a.nextLine();
					System.out.println("Enter Book price");
					int getBookprice = a.nextInt();
					obj.insertEmp(getBooknumber, getBookname, getBookprice);
					break;
				}
				case 2: {

					System.out.println("Enter Book number");
					int getBooknumber = a.nextInt();
					System.out.println("Enter Book name");
					String getBookname = a.nextLine();
					System.out.println("Enter Book Price");
					int getBookprice = a.nextInt();

					obj.updateEmp(getBooknumber, getBookname, getBookprice);
					break;
				}
				case 3: {
					System.out.println("Enter Book number to delete record");

					int getBooknumber = a.nextInt();
					obj.deleteEmp(getBooknumber);
					break;
				}
				case 4: {
					obj.dispAll();

					break;
				}
				case 5: {
					System.out.println("Enter Book number to display record");

					int getBooknumber = a.nextInt();
					obj.dispAnEmp(getBooknumber);
					break;
				}
				case 6: {
					System.exit(0);
				}
				default:

					System.out.println("Try again");
					int a1, b1 = 0;

					System.out.println("Process Continue Press 1 Or Main page Press 0");

					a1 = a.nextInt();

					if (a1 != b1) {
						library();
					} else {

						System.exit(0);
					}
					library();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
