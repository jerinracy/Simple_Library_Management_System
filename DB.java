import java.sql.*;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","","");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from info");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
			}
			
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}

}