package guiPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection 
{
	private static final String url			= "jdbc:mysql://localhost:3306/";
    private static final String user 		= "root";
    private static final String password 	= "kp";
    private static final String dbname		= "das"; 
    private Connection connection			= null;
    
    public MyConnection()
    {
        
        try
        {
        		
                connection = DriverManager.getConnection(url+dbname, user, password);
                System.out.println("Connection Established");
        } 
        catch (Exception e)
        {
                e.printStackTrace();
        }         
    }

	public Connection getConnection() 
	{
		return connection;
	}    

}
