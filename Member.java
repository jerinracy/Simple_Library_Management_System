import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
class Member{
	
	String ppassword;
	String eepassword;
	
	public int AddMember(String name, String id, int age,String location,String username,String password){
		int status = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO `member`(`name`, `id`, `age`, `location`, `username`, `password`) VALUES ("+"'"+name+"',"+"'"+id+"',"+age+","+"'"+location+"',"+"'"+username+"',"+"'"+password+"')");
			JOptionPane.showMessageDialog(null,"Member Added");
			con.close();
		}catch(Exception e){System.out.println(e);}	
		System.out.println("Member Added");
		return status;
		
	}
	public int usernamecheck(String name){
		int b =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT `password` FROM `member` WHERE `username` ="+"'"+name+"'");
			rs.next();
			this.eepassword = rs.getString(1);
		}catch(Exception e){System.out.println(e);}	
		return b;
	}
	
	public void getPassword(String username)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT `password` FROM `member` WHERE `username` ="+"'"+username+"'");
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
			PreparedStatement ps=con.prepareStatement("UPDATE `member` SET `name`=?,`id`=?,`age`=?,`location`=?,`password`=? WHERE username ="+"'"+username+"'");
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
	
	
	public void showAllBook(){
		Librarian temp = new Librarian();
		temp.showAllBook();
	}
	
	public void SearchBook(String name){
		Librarian temp = new Librarian();
		temp.SearchBook(name);
	}
	
}