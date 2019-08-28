package com.lms;

import java.util.Scanner;
import java.sql.*;
import java.io.*;

public class CRUD {
	Connection con;
	PreparedStatement ps;
	book b = new book();

	public static void main(String[] args) {
		library();
	}

	public void insertbook() {
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

	public void updatebook() {
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

	public void deletebook() {
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

	public void dispAnbook() {
		try {

			ps = con.prepareStatement("select * from addbook where '" + book.getBooknumber() + "'");
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.print(res.getString(1) + "\n");
				System.out.print(res.getString(2) + "\n");
				System.out.print(res.getString(3) + "\n");
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void library() {
		book b = new book();
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
					b.setBooknumber(a.nextInt());
					System.out.println("Enter Book Name");
					b.setBookname(a.nextLine());
					System.out.println("Enter Book price");
					b.setBookprice(a.nextInt());
					obj.insertbook();
					break;
				}
				case 2: {

					System.out.println("Enter Book number");
					b.setBooknumber(a.nextInt());
					System.out.println("Enter Book name");
					b.setBookname(a.nextLine());
					System.out.println("Enter Book Price");
					b.setBookprice(a.nextInt());
					obj.updatebook();
					break;
				}
				case 3: {
					System.out.println("Enter Book number to delete record");
					b.setBooknumber(a.nextInt());
					obj.deletebook();
					break;
				}
				case 4: {
					obj.dispAll();

					break;
				}
				case 5: {
					System.out.println("Enter Book number to display record");
					b.setBooknumber(a.nextInt());
					obj.dispAnbook();
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

					if (a1 != b1) 
					{
						library();
						
					} else 
					{

						System.exit(0);
					}
					
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
