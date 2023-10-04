package in.mindcraft.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.AdminandCustLoginDao;
import in.mindcraft.dao.CartDao;
import in.mindcraft.dao.ProductDao;
import in.mindcraft.pojos.Customer;
import in.mindcraft.pojos.Product;

@Controller
public class ProductController {
	
	private ProductDao productDao=new ProductDao(); //object of dao class
	private CartDao cartdao=new CartDao();
	private AdminandCustLoginDao ACDao=new AdminandCustLoginDao();
	
	@RequestMapping("/addproduct")
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		int prod_no=Integer.parseInt(request.getParameter("prod_no"));
		String pname=request.getParameter("pname");
		double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		double discount=Double.parseDouble(request.getParameter("discount"));
		
		Product product= new Product(prod_no,pname,price,quantity,discount);
		
		productDao.addProduct(product);
	}
	
	@RequestMapping("/showproduct")
	public ModelAndView showLaptops() throws ClassNotFoundException {
		ModelAndView mv=new ModelAndView();
		try {
			List<Product> list=productDao.getProducts();
			System.out.println(list);
			mv.setViewName("result.jsp");
			mv.addObject("list",list);
			
		}catch(SQLException e) {
			
		}
		return mv;
	}
	
	@RequestMapping("/addtocart")
	public ModelAndView addtocart() throws ClassNotFoundException {
		ModelAndView mv=new ModelAndView();
		try {
			List<Product> list=productDao.getProducts();
			System.out.println(list);
			mv.setViewName("addtocart.jsp");
			mv.addObject("list",list);
			
		}catch(SQLException e) {
			
		}
		return mv;
	}
	
	


	
	
	@RequestMapping("/addCustomer")
	public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		int c_id =Integer.parseInt(request.getParameter("c_id"));
		String c_username=request.getParameter("c_username");
		int c_password =Integer.parseInt(request.getParameter("c_password"));
		double wallet_balance =Double.parseDouble(request.getParameter("wallet_balance"));
		
		Customer customer= new Customer(c_id,c_username,c_password,wallet_balance);
		
		ACDao.addCustomer(customer);
	}
	
	@RequestMapping("/removeCustomer")
	public void removeCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
	    String c_username = request.getParameter("c_username");
	    Customer customer= new Customer(1,c_username,9,1.0);
	    // Call the method to remove customer from the DAO
	    ACDao.removeCustomer(customer);
	}
	
	
	
	

	
}
