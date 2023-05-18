import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
public class Librarian{
	String password;
	String username= "";
	String ppassword;
	
	public int AddLibraian(String name, String id, int age,String location, String username, String password){
		int status = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://https://www.db4free.net/phpMyAdmin/:3306/sifat_test","sifat","mdjerinSIFAT,");
			PreparedStatement ps=con.prepareStatement("INSERT INTO `librarian`(`name`, `id`, `age`, `location`, `username`, `password`) VALUES (?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,id);
			ps.setInt(3,age);
			ps.setString(4,location);
			ps.setString(5,username);
			ps.setString(6,password);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}	
		JOptionPane.showMessageDialog(null,"Librarian Info Saved");
		return status;
		
	}
	
	public void updateInfo(String name, String id, String age,String location, String username, String password){
		int status =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			PreparedStatement ps=con.prepareStatement("UPDATE `librarian` SET `name`=?,`id`=?,`age`=?,`location`=?,`password`=? WHERE username ="+"'"+username+"'");
			ps.setString(1,name);
			ps.setString(2,id);
			ps.setString(3,age);
			ps.setString(4,location);
			ps.setString(5,password);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}	
		if(status == 1)
		{
			JOptionPane.showMessageDialog(null,"Information Updated");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Unable to Update Info");
		}
	}
	public void checkpass(String username)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT `password` FROM `librarian` WHERE `username` ="+"'"+username+"'");
			rs.next();
			if(rs.getString(1).isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Password is Wrong","Warning Message",-1);
			}
			else
			{
				
				this.ppassword = rs.getString(1);
			}
		}catch(Exception e){System.out.println(e);}
	}
	public int usernamecheck(String name){
		int b =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT `password` FROM `librarian` WHERE `username` ="+"'"+name+"'");
			rs.next();
			this.password = rs.getString(1);
			this.username=name;
			
		}catch(Exception e){System.out.println(e);}	
		return b;
	}

	public void AddMember(String name, String id, int age,String location,String username,String password){
		Member temp = new Member();
		temp.AddMember(name,id,age,location,username,password);
		
	}
	
	public int AddBook(String name, String isbn,String quantity){
		int status = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO `book`(`name`, `isbn`, `quantity`) VALUES (?,?,?)");
			ps.setString(1,name);
			ps.setString(2,isbn);
			ps.setString(3,quantity);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}	
		JOptionPane.showMessageDialog(null,"Book Added ");
		return status;
		
	}
	public int DeleteMember(String name){
		System.out.println("Deleting Member "+name);
		int status = 0;
		String temp=name;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			status = stmt.executeUpdate("DELETE FROM `member` WHERE name = "+"'"+name+"'");
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null,"Member Deleted","",-1);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Member Not Found","",-1);
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}	
		return status;
		
		
	}
	public int DeleteBook(String name){
		int status = 0;
		String temp=name;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			status = stmt.executeUpdate("DELETE FROM `book` WHERE name = "+"'"+name+"'");
			if(status==1)
			{
				JOptionPane.showMessageDialog(null,"Book Deleted","",-1);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Book Not Found","",-1);
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}	
		return status;
		
	}
	public int SearchBook(String name){
		System.out.println("Info of Book :"+name);
		int status = 0;
		String temp=name;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `book` WHERE name = "+"'"+name+"'");
			//System.out.println("Name"+"   "+"ISBN"+"   "+"Quantity");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			}
			con.close();
		}catch(Exception e){System.out.println(e);}	
		return status;
		
	} 
	public int showAllBook(){
		System.out.println("Book List");
		int status = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `book`");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
			}
			con.close();
		}catch(Exception e){System.out.println(e);}	
		return status;
	}
	
}