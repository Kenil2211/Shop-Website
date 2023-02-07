package bean;


public class UserBean 
{
	
	private String name;
	private String email;
	private String password;
	private int userId;
	
	public UserBean() 
	{
		
	}
	
	public UserBean(String name,String email,String password)
	{
		this.name=name;
		this.email=email;
		this.password=password;
		
	}
	
	public UserBean(int userId,String name,String email,String password)
	{
		this.userId=userId;
		this.name=name;
		this.email=email;
		this.password=password;
		
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}		
}
