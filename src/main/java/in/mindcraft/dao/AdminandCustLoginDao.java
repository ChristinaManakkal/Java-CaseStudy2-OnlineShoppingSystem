package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.mindcraft.pojos.Admin;
import in.mindcraft.pojos.Customer;
import in.mindcraft.utils.DButils;

public class AdminandCustLoginDao {
	private Connection cn;
	private PreparedStatement pst3;
	private PreparedStatement pst4;
	private PreparedStatement pst5;
	
	public void addAdmin(Admin admin) throws SQLException, ClassNotFoundException {
//		cn=DButils.openConnection();
//		pst3=cn.prepareStatement("insert into admin values(?,?)");
//		pst3.setString(1,admin.getUsername());
//		pst3.setInt(2,admin.getPassword());
//		
//		pst3.execute();
//		cn.commit();
		//DButils.closeConnection();
		cn = DButils.openConnection();
	    pst3 = cn.prepareStatement("INSERT INTO admin (username, password) VALUES (?, ?)");

	    // Hardcoded admin username and password
	    pst3.setString(1, "admin");
	    pst3.setString(2, "admin");

	    pst3.execute();
	    //cn.commit();
	    DButils.closeConnection();
	}
	
	public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		cn=DButils.openConnection();
		pst4=cn.prepareStatement("insert into customers values(?,?,?,?)");
		pst4.setInt(1,customer.getC_id());
		pst4.setString(2,customer.getC_username());
		pst4.setInt(3,customer.getC_password());
		pst4.setDouble(4,customer.getWallet_balance());
		
		pst4.execute();
		//cn.commit();
		DButils.closeConnection();
		
	}
	
	public void removeCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		cn=DButils.openConnection();
		pst5=cn.prepareStatement("DELETE FROM customer WHERE c_username = ?");
		pst5.setString(1,customer.getC_username());
		
		
		
		int rowsDeleted = pst5.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Account closed successfully!");
        } else {
            System.out.println("Customer not found.");
        }
		//cn.commit();
		DButils.closeConnection();
		
	}
	
	
}
