import java.sql.*;
import javax.swing.*;

public class Books{
	public void BorrowBook(String name){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			ResultSet r = stmt.executeQuery("SELECT name from book where name = '"+name+"'");
			r.next();
			String bname=r.getString(1);
			if(bname.equals(name))
			{
				boolean check = CheckBook(name);
				if(check == true)
				{
					UpdateBook(name);
					JOptionPane.showMessageDialog(null,"Borrowing Book Successful");
				}
				else 
					JOptionPane.showMessageDialog(null,"Requested book is not available Right Now");
				
				}
			else
			{
				JOptionPane.showMessageDialog(null,"Book Not Found");
			}
		}catch(Exception e){System.out.println(e);}
		
			
	}
	
	public boolean CheckBook(String name){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT quantity FROM book WHERE name = "+"'"+name+"'");
			rs.next();
			int qntt=rs.getInt(1);
			JOptionPane.showMessageDialog(null,"Quantity is :"+qntt);
			con.close();
			if(qntt>0)
			return true;
		
		}catch(Exception e){System.out.println(e);}	
		return false;
	}
	public void UpdateBook(String name){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT quantity FROM book WHERE name = "+"'"+name+"'");
			rs.next();
			int quantity=rs.getInt(1);
			
			Statement stmt1= con.createStatement();
			stmt1.executeUpdate("UPDATE book SET quantity = quantity-1 WHERE name = "+"'"+name+"'");
			con.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	public void ReturnBook(String name){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt= con.createStatement();
			ResultSet r = stmt.executeQuery("SELECT name from book where name = '"+name+"'");
			r.next();
			String cname=r.getString(1);
			if(cname.equals(name))
			{
				stmt.executeUpdate("UPDATE book SET quantity = quantity+1 WHERE name = "+"'"+name+"'");
				JOptionPane.showMessageDialog(null,"BOOK Successfully Returned");
			}
			else if(cname == null)
			{
				JOptionPane.showMessageDialog(null,"BOOK Not Returned");
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
	}
	
}