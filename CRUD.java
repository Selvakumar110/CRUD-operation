package com.lms;

import java.util.Scanner;
import java.sql.*;
import java.io.*;

public class CRUD {
	
	public static void main(String[] args) {
		library();
	}

	Connection con;
	PreparedStatement ps;

	public void insertEmp(int booknumber, String bookname, int bookprice) {
		try {
			Dbconnection get = new Dbconnection();
	
			con = get.connectDb();
			
			ps = con.prepareStatement("insert into addbook(booknumber,bookname,bookprice) values(?,?,?)");

			ps.setInt(1, booknumber);
			ps.setString(2, bookname);
			ps.setInt(3, bookprice);

			System.out.println(booknumber);

			int i = ps.executeUpdate();

			if (i != 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("not Inserted");
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void updateEmp(int booknumber,String bookname,int bookprice) {
		try {
			
			Dbconnection get = new Dbconnection();
			con = get.connectDb();
			ps = con.prepareStatement("update addbook set bookname=?,bookprice=? where booknumber=?");
			
			ps.setString(1, bookname);
			
			ps.setInt(2, bookprice);
			ps.setInt(3, booknumber);
		
		System.out.println("hai"+booknumber);
			
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

	public void deleteEmp(int booknumber) {
		try {
			Dbconnection get = new Dbconnection();
			Connection con = get.connectDb();
			ps = con.prepareStatement("delete from addbook where booknumber=?");
			ps.setInt(1, booknumber);
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
			Dbconnection get = new Dbconnection();
			Connection con = get.connectDb();
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from addbook");
			while (res.next()) {
				System.out.print(res.getString(1)+"\n");
				System.out.print(res.getString(2)+"\n");
				System.out.print(res.getString(3)+"\n");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dispAnEmp(int s) {
		try {
			Dbconnection get = new Dbconnection();
			Connection con = get.connectDb();
			ps = con.prepareStatement("select * from addbook where booknumber=?");
			ps.setInt(1, s);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.print(res.getString(1)+"\n");
				System.out.print(res.getString(2)+"\n");
				System.out.print(res.getString(3)+"\n");
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public static void library(){
		try {
			Dbconnection get = new Dbconnection();
			Connection con = get.connectDb();
			CRUD obj = new CRUD();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int ch = 0;
			while (true) {
				System.out.println("Library management \n" + "1. Add Book \n " + "2. Edit Book \n "
						+ "3. Delete Book \n " + "4. Display all Book \n" + "5.Display a Book");
				String str1 = br.readLine().toString();
				ch = Integer.parseInt(str1);
				switch (ch) {
				case 1: {
					Scanner a = new Scanner(System.in);
					System.out.println("Enter Book number");
					int booknumber = a.nextInt();
					System.out.println("Enter Book Name");
					String bookname = br.readLine();
					System.out.println("Enter Book price");
					int bookprice = a.nextInt();
					obj.insertEmp(booknumber, bookname, bookprice);
					break;
				}
				case 2: {
					Scanner a = new Scanner(System.in);
					System.out.println("Enter Book number");
					int booknumber = a.nextInt();
					System.out.println("Enter Book name");
					String bookname = a.next();
					System.out.println("Enter Book Price");
					int bookprice = a.nextInt();
					
					obj.updateEmp(booknumber, bookname ,bookprice);
					break;
				}
				case 3: {
					System.out.println("Enter Book number to delete record");
					Scanner a = new Scanner(System.in);
					int booknumber = a.nextInt();
					obj.deleteEmp(booknumber);
					break;
				}
				case 4: {
					obj.dispAll();
					
					break;
				}
				case 5: {
					System.out.println("Enter Book number to display record");
					Scanner a = new Scanner(System.in);
					int booknumber = a.nextInt();
					obj.dispAnEmp(booknumber);
					break;
				}
				case 6: {
					System.exit(0);
				}
				default:
					
					System.out.println("Try again");
					int a1, b1 = 0;
					Scanner a = new Scanner(System.in);
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
