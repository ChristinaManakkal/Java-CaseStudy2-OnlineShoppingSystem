package in.mindcraft.pojos;

public class Admin {
	private String username;
	private int password;
	
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}

	public Admin() {
		
	}
	
	public Admin(String username, int password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	
	
	
	
}
