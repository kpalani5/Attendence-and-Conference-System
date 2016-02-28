package Users;

public class Person {
	private String fname;
	private String lname;
	private String DOB;
	private String place;
	private int phone;
	
	public void setfname(String n)
	{
		fname=n;
	}
	
	public void setlname(String n)
	{
		lname=n;
	}
	
	public void setDOB(String n)
	{
		DOB=n;
	}
	
	public void setPlace(String n)
	{
		place=n;
	}
	
	public void setPhone(int n)
	{
		phone=n;
	}
	
	public String getfname()
	{
		return fname;
	}
	
	public String getlname()
	{
		return lname;
	}
	
	public String getDOB()
	{
		return DOB;
	}
	
	public String getPlace()
	{
		return place;
	}
	
	public int getPhone()
	{
		return phone;
	}
	
}
