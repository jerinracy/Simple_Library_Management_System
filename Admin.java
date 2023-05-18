import java.sql.*;
import javax.swing.*;
public class Admin{
	
	String Ausername;
	String Apassword;
	String ppassword;
	
	
	public int AddNewAdmin(String name, String id, int age,String location,String username,String password){
		int status = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO `info`(`name`, `id`, `age`, `location`, `username`, `password`) VALUES (?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,id);
			ps.setInt(3,age);
			ps.setString(4,location);
			ps.setString(5,username);
			ps.setString(6,password);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}	
		
		if(status==1)
		{
			JOptionPane.showMessageDialog(null,"New Admin Created Successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"New Admin Could not be Created");
		}
		return status;
	}
	
	public int usernamecheck(String name){
		int b =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT `password` FROM `info` WHERE `username` ="+"'"+name+"'");
			rs.next();
			this.Apassword = rs.getString(1);
			this.Ausername=name;
		}catch(Exception e){System.out.println(e);}	
		return b;
	}
	
	public int AddLibraian(String name, String id, int age,String location,String username,String password){
		int status = 0;
		Librarian lib =new Librarian();
		lib.AddLibraian(name,id,age,location,username,password);
		return status;
		
	}
	public int AddClark(String name, String id, int age,String location,String username,String password){
		int status = 0;
		Clark clrk = new Clark();
		clrk.AddClark(name,id,age,location,username,password);
		return status;
	}
	
	public int DeleteLib(String name){
		
		int status = 0;
		String temp=name;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			status = stmt.executeUpdate("DELETE FROM `librarian` WHERE name = "+"'"+name+"'");
			if(status==1)
			{
				JOptionPane.showMessageDialog(null,"Librarian Deleted");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Librarian Not Found");
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}	
		return status;
		
	}
	
	public int DeleteClrk(String name){
		
		int status = 0;
		String temp=name;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt=con.createStatement();
			status = stmt.executeUpdate("DELETE FROM `clark` WHERE name = "+"'"+name+"'");
			if(status == 1)
			{
				JOptionPane.showMessageDialog(null,"Clark Deleted");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Clark Not Found");
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
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getInt(3));
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
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getInt(3));
			}
			con.close();
		}catch(Exception e){System.out.println(e);}	
		return status;
	}
	
	public void getPassword(String username)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT `password` FROM `info` WHERE `username` ="+"'"+username+"'");
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
	
	public void updateInfo(String name, String id, String age,String location, String username, String password){
		int status =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			PreparedStatement ps=con.prepareStatement("UPDATE `info` SET `name`=?,`id`=?,`age`=?,`location`=?,`password`=? WHERE username ="+"'"+username+"'");
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
	
	
}