package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyProjectInDb {
  
	public static void main(String[] args) throws SQLException
	{
		Connection conn=null;
		String project_name="onbuy.com";
		try
		{
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			 conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			 Statement statement = conn.createStatement();
			 String Querry="select * from project";
			 ResultSet result = statement.executeQuery(Querry);
			 boolean flag = false;
			 while (result.next())
			 {
			    String value = result.getString(4);
			    if (value.equalsIgnoreCase(project_name)) 
			    {
				  System.out.println("project is created");	
				  flag=true;
				  break;
				  
				}
				 
				 if (flag)
				 {
					 System.out.println("project is not created");		
				}
			}
			 
			 
		}
		finally {
			conn.close();
		}
	}
}