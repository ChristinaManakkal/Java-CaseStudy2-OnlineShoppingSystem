package in.mindcraft.pojos;

public class Customer {
	

	private String c_username;
	private int c_password;
	private int c_id;
	private double wallet_balance;
	
	
	
	@Override
	public String toString() {
		return "c_id=\" + c_id\r\n"
				+ "				+ \",Customer [c_username=" + c_username + ", c_password=" + c_password + ",  wallet_balance=" + wallet_balance + "]";
	}

	public Customer(int c_id,String c_username, int c_password, double wallet_balance) {
		super();
		this.c_username = c_username;
		this.c_password = c_password;
		this.c_id = c_id;
		this.wallet_balance = wallet_balance;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public double getWallet_balance() {
		return wallet_balance;
	}

	public void setWallet_balance(double wallet_balance) {
		this.wallet_balance = wallet_balance;
	}

	public Customer() {
		
	}

	

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
	}

	public int getC_password() {
		return c_password;
	}

	public void setC_password(int c_password) {
		this.c_password = c_password;
	}
	
	
}
