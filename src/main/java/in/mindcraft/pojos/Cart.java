package in.mindcraft.pojos;

public class Cart {
	
	private int prod_no;
	private String pname;
	private double price;
	private int quantity;
	private double discount;
	

	public Cart() {
		super();
	}

	public Cart( int prod_no, String pname, double price, int quantity, double discount) {
		super();
		
		this.prod_no = prod_no;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		
	}



	public int getProd_no() {
		return prod_no;
	}

	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}



	@Override
	public String toString() {
		return "Cart [ prod_no=" + prod_no + ", pname=" + pname + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + "]";
	}

	
	
	
	
	
}
