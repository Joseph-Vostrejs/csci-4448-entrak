public class User {

	protected String firstName;
	protected String lastName;
	private String username;
	private String password;
	protected String email;
	
	String getUsername() {
		return username;
	}

	void setUsername(String username) {
		this.username = username;
	}

	String getPassword() {
		return password;
	}

	void setPassword(String password) {
		this.password = password;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	public User(String firstname, String lastname, String username, String password, String email)
	{
		String query = "INSERT INTO Users (first,last,username,password,email) VALUES ('"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+email+"')";
		try{
		DB.post(query);
		}catch(Exception e){System.out.println(e);}
	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new User("nathan","welch","welchnathan","password","fakeemail@colorado.edu");
	}

}
