package attendancePackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Users.Person; 
import guiPackage.MyConnection;

public class Student extends Person{
	
	private long regno;
	private String course;
	private int sem;
	private String section;
	@SuppressWarnings("unused")
	private Attendance data;

	public void setRegno(long n)
	{
		regno=n;
	}
	
	public void setCourse(String n)
	{
		course=n;
	}
	
	public void setsem(int n)
	{
		sem=n;
	}
	
	public void setSection(String n)
	{
		section=n;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public String getSection()
	{
		return section;
	}
	
	public int getsem()
	{
		return sem;
	}
	
	public void addNew()
	{
		MyConnection con=new MyConnection();
		try 
		{
			
			PreparedStatement stmt=con.getConnection().prepareStatement("insert into student values(?,?,?,?,?,?)");
			stmt.setLong(1,regno);
			stmt.setString(2,this.getfname());
			stmt.setString(3,this.getlname());
			stmt.setString(4,course);
			stmt.setInt(5,sem);
			stmt.setString(6,section);
			stmt.execute();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid Details!");
			//e.printStackTrace();
		}
	}
	
	public void remove()
	{
		MyConnection con=new MyConnection();
		try 
		{
			
			PreparedStatement stmt=con.getConnection().prepareStatement("delete from student where regno=?");
			stmt.setLong(1,regno);
			stmt.execute();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid Details!");
			//e.printStackTrace();
		}
	}
	
	public Student retrieve(long reg)
	{
		MyConnection con=new MyConnection();
		Student a=new Student();
		try 
		{
			
			PreparedStatement stmt=con.getConnection().prepareStatement("select * from student where regno=?");
			stmt.setLong(1,reg);
			ResultSet rs=stmt.executeQuery();
			if(rs.first())
			{
				a.setRegno(reg);
				a.setfname(rs.getString(2));
				a.setlname(rs.getString(3));
				a.setCourse(rs.getString(4));
				a.setsem(Integer.parseInt(rs.getString(5)));
				a.setSection(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
}
