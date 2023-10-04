package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojos.Product;
import in.mindcraft.utils.DButils;

public class ProductDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	
	public void addProduct(Product product) throws SQLException, ClassNotFoundException {
		cn=DButils.openConnection();
		pst1=cn.prepareStatement("insert into product values(?,?,?,?,?)");
		pst1.setInt(1,product.getProd_no());
		pst1.setString(2,product.getPname());
		pst1.setDouble(3,product.getPrice());
		pst1.setInt(4,product.getQuantity());
		pst1.setDouble(5,product.getDiscount());
		pst1.execute();
		//cn.commit();
		DButils.closeConnection();
	}
	
	public List<Product> getProducts() throws SQLException, ClassNotFoundException{
		cn=DButils.openConnection();
		List <Product> list=new ArrayList<Product>();
		pst2=cn.prepareStatement("select * from product");
		ResultSet rs=pst2.executeQuery();
		while(rs.next()) {
			list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getInt(4),rs.getDouble(5)));
		}
		DButils.closeConnection();
		return list;
	}
}
