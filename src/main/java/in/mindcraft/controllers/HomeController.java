package in.mindcraft.controllers;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.CustomerDao;

@Controller
public class HomeController {
	
	
	@RequestMapping("/checkStatus")
	public ModelAndView checkStatus(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println("Admin Login SuccesFully Completed!!");
			mv.setViewName("index.jsp");
		} else {
			System.out.println("Invalid Username or Password!!");	
		}
		return mv;
	}
	
	

	@RequestMapping("/checkCustomer")
	public ModelAndView checkCustomer(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String c_username = request.getParameter("c_username");
		String c_password = request.getParameter("c_password");
		ModelAndView mv1 = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("c_username", c_username);

		
		CustomerDao customerDao = new CustomerDao();

	    // Check if the customer credentials are valid using the DAO
	    boolean isAuthenticated = customerDao.checkCustomer(c_username, c_password);

	    if (isAuthenticated) {
	        System.out.println("Customer Login Successfully Completed!!");
	        mv1.setViewName("cart.jsp"); // Redirect to cart.jsp upon successful login
	    } else {
	        System.out.println("Invalid Username or Password!!");
	    }
	    return mv1;
		
		

}}
