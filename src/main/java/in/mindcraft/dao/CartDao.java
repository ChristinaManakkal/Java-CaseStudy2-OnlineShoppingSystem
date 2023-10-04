package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojos.Cart;
import in.mindcraft.pojos.Customer;
import in.mindcraft.pojos.Product;
import in.mindcraft.utils.DButils;

public class CartDao {
	private Connection cn;
	
	private PreparedStatement psmt1;

	private PreparedStatement psmt2;
	
	private PreparedStatement psmt3;
	
	private PreparedStatement psmt4;
	
	private PreparedStatement psmt5;

	private PreparedStatement psmt6;
	
	public double calculateSum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }
	
	public void addItems(int prod_no, String pname, double price,int quantity ,double discount) throws ClassNotFoundException, SQLException {
		
		cn = DButils.openConnection();
		
		psmt1 = cn.prepareStatement("Insert into cart values(?,?,?,?,?)");
		
		psmt1.setInt(1, prod_no);
		psmt1.setString(2, pname);
		psmt1.setDouble(3, price);
		psmt1.setInt(4, quantity);
		psmt1.setDouble(5, discount);
		
		psmt1.execute();
		
		psmt2 = cn.prepareStatement("Update product set quantity = quantity - 1 where prod_no = ?"); 
		psmt2.setInt(1, prod_no);
		psmt2.execute();		
		
		DButils.closeConnection();
	}
	

	
	public List<Cart> showCart(String pname) throws SQLException, ClassNotFoundException{
		cn=DButils.openConnection();
		List <Cart> list=new ArrayList<Cart>();
		psmt2=cn.prepareStatement("select * from cart");
		ResultSet rs=psmt2.executeQuery();
		while(rs.next()) {
			list.add(new Cart(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getInt(4),rs.getDouble(5)));
		}
		DButils.closeConnection();
		return list;
	}
	
	/////////////////////////
	
	public double calculateTotalCost() throws ClassNotFoundException, SQLException {
        double totalCost = 0.0;
        cn = DButils.openConnection();

        // Calculate the total cost by summing the individual product costs (taking discount into account) in the cart
        psmt3 = cn.prepareStatement("SELECT SUM((price - (price * discount / 100)) * quantity) FROM cart");
        ResultSet rs = psmt3.executeQuery();

        if (rs.next()) {
            totalCost = rs.getDouble(1);
        }

        DButils.closeConnection();

        return totalCost;
    }
	
	public boolean processPayment(Customer customer) throws ClassNotFoundException, SQLException {
        // Calculate the total cost
        double totalCost = calculateTotalCost();

        // Check if the customer's wallet balance is sufficient for the purchase
        if (customer.getWallet_balance() >= totalCost) {
            cn = DButils.openConnection();

            // Deduct the total cost from the customer's wallet balance
            double newBalance = customer.getWallet_balance() - totalCost;

            // Update the customer's wallet balance in the database
            psmt4 = cn.prepareStatement("UPDATE customers SET wallet_balance = ? WHERE customer_id = ?");
            psmt4.setDouble(1, newBalance);
            psmt4.setInt(2, customer.getC_id());
            psmt4.executeUpdate();

            // Clear the cart after successful payment
            psmt5 = cn.prepareStatement("DELETE FROM cart");
            psmt5.executeUpdate();

            DButils.closeConnection();

            return true; // Payment successful
        } else {
            return false; // Insufficient balance
        }
    }
	
	
	public void removeProductFromCart(String prodNo) throws SQLException, ClassNotFoundException {
	    Connection cn = null;
	    PreparedStatement pst = null;

	    try {
	        cn = DButils.openConnection();
	        pst = cn.prepareStatement("DELETE FROM cart WHERE prod_no = ?");
	        pst.setString(1, prodNo);

	        int rowsDeleted = pst.executeUpdate();

	        if (rowsDeleted > 0) {
	            System.out.println("Product removed from the cart successfully!");
	        } else {
	            System.out.println("Product not found in the cart.");
	        }
	    } finally {
	        // Close resources in a finally block to ensure they are closed even if an exception occurs
	        if (pst != null) {
	            pst.close();
	        }
	        if (cn != null) {
	            cn.close();
	        }
	    }
	}

	
	
	
	
}
