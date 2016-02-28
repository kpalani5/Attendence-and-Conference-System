package Users;


class User extends Person{
	String email;
	String ID;
	String desig;
	String type;
	
	public void setEmail(String n)
	{
		email=n;
	}
	
	public void setID(String n)
	{
		ID=n;
	}
	
	public void setDesig(String n)
	{
		desig=n;
	}
	
	public void setType(String n)
	{
		type=n;
	}
}

public class RegisterUser {
	
	User u;
	RegisterUser()
	{
		u = new User();
	}

}
