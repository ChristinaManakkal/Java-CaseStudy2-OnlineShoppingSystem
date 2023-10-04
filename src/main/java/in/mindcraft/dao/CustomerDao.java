// CustomerDao.java
package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.mindcraft.utils.DButils;

public class CustomerDao {
    private Connection cn;
    private PreparedStatement psmt1;
    private PreparedStatement psmt2;
    private PreparedStatement psmt3;

    public boolean checkCustomer(String c_username, String c_password) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;

        try {
            cn = DButils.openConnection();
            psmt1 = cn.prepareStatement("SELECT * FROM customer WHERE c_username = ? AND c_password = ?");
            psmt1.setString(1, c_username);
            psmt1.setString(2, c_password);

            // Execute the query
            rs = psmt1.executeQuery();

            // If a matching customer is found, return true
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
            return false;
        } finally {
            // Close database resources in the finally block
        	DButils.closeConnection();
        }
    }
    
    
    
    //////////////////////
    public boolean updateWalletBalance(String c_username, double newBalance) throws SQLException {
        try {
            cn = DButils.openConnection();

            // Assuming you have a customers table with a username column and wallet_balance column
            psmt2 = cn.prepareStatement("UPDATE customers SET wallet_balance = ? WHERE c_username = ?");
            psmt2.setDouble(1, newBalance);
            psmt2.setString(2, c_username);

            int rowsUpdated = psmt2.executeUpdate();
            return rowsUpdated > 0; // Returns true if the update was successful

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        } finally {
            DButils.closeConnection();
        }
    }
    
    
    public double getWalletBalance(String c_username) throws SQLException {
        double walletBalance = 0;

        try {
            cn = DButils.openConnection();

            // Assuming you have a customers table with a username column and wallet_balance column
            psmt3 = cn.prepareStatement("SELECT wallet_balance FROM customers WHERE c_username = ?");
            psmt3.setString(1, c_username);

            ResultSet rs = psmt3.executeQuery();
            if (rs.next()) {
               walletBalance = rs.getDouble("wallet_balance");
 //               walletBalance = rs.getDouble(1);
                System.out.println(walletBalance);
//                (walletBalance)
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.closeConnection();
        }

        return walletBalance;
    }
    
}
