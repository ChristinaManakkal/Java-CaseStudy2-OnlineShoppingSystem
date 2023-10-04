package in.mindcraft.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.CartDao;
import in.mindcraft.dao.CustomerDao;
import in.mindcraft.dao.ProductDao;
import in.mindcraft.pojos.Cart;
import in.mindcraft.pojos.Product;

@Controller
public class CustomerController {
	
	private ProductDao productdao = new ProductDao();
	private CustomerDao customerdao = new CustomerDao();
	private CartDao cartdao =  new CartDao();


	
	
	@RequestMapping("/addtoCart")
	public ModelAndView addtoCart() throws ClassNotFoundException, SQLException {
		ModelAndView mv = new ModelAndView();
		List<Product> list = productdao.getProducts();
		
		mv.setViewName("addtocart.jsp");
		
		mv.addObject("list",list);
		
		return mv;
	}
	
	@RequestMapping("/addItems")
	public ModelAndView addItems(HttpServletRequest request, HttpServletResponse response, @RequestParam("prod_no") int prod_no, @RequestParam("pname") String pname, @RequestParam("price") double price, @RequestParam("discount") double discount) throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		ModelAndView mv = new ModelAndView();
//		List<Product> list = productdao.showProduct();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		//String invoiced = "No";
		int quantity = 1;
		cartdao.addItems( prod_no, pname, price, quantity, discount);
				
		mv.setViewName("result.jsp");

		response.setContentType("text/html"); // Set the content type
		PrintWriter out = response.getWriter(); // Get the response writer

		out.println("<p>Item Inserted within Cart!!!</p>");
		out.close();

		return mv;
		
	}



	@RequestMapping("/showCart")
	public ModelAndView showCart(HttpServletRequest request, HttpServletResponse reponse) throws ClassNotFoundException, SQLException {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String pname = (String) session.getAttribute("pname");
		
		List<Cart> list = cartdao.showCart(pname);
		
		mv.setViewName("display_cart.jsp");
		
		mv.addObject("list",list);
		
		System.out.println("Showing all Cart Items!!!");
		
		return mv;
	}
	
	@RequestMapping("/removeFromCart")
	public ModelAndView removeFromCart(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
	    ModelAndView mv = new ModelAndView();

	    HttpSession session = request.getSession();
	    String prodNo = request.getParameter("prod_no");

	    // Assuming cartdao.removeProductFromCart is a method to remove a product from the cart
	    // Pass the product information (e.g., prodNo) to the removeProductFromCart method
	    cartdao.removeProductFromCart(prodNo);

	    // Redirect back to the cart page to show the updated cart
	    mv.setViewName("redirect:/showCart");
	    return mv;
	}

	@RequestMapping("/checkWalletBalance")
    public ModelAndView checkWalletBalance(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        
        // Get the user's username from the session or request, or pass it as a parameter
        String c_username = "c_username"; // Replace with actual username retrieval

        // Call the getWalletBalance method to retrieve the wallet balance
        double walletBalance;
        try {
            walletBalance = customerdao.getWalletBalance(c_username);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
            walletBalance = 0.0; // Set a default value or handle the error case
        }

        // Set the wallet balance as a model attribute
        mv.addObject("wallet", walletBalance);

        // Set the view name for the JSP page to display the wallet balance
        mv.setViewName("wallet"); // Assuming "wallet.jsp" as your view

        return mv;
    }
	
	
	
	//////////
//	@RequestMapping("/purchase")
//    public ModelAndView purchase(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
//        ModelAndView mv = new ModelAndView();
//
//        HttpSession session = request.getSession();
//        String c_username = (String) session.getAttribute("c_username");
//
//        // Calculate the total cost from the cart
//        double totalCost = cartdao.calculateTotalCost();
//
//        // Get the customer's wallet balance
//        double walletBalance = customerdao.getWalletBalance(c_username);
//
//        if (walletBalance >= totalCost) {
//            // Deduct the total cost from the wallet balance
//            double newBalance = walletBalance - totalCost;
//
//            // Update the customer's wallet balance in the database
//            customerdao.updateWalletBalance(c_username, newBalance);
//
//            // Clear the cart after successful purchase
//            //cartdao.clearCart();
//
//            // Add total cost and new wallet balance to the ModelAndView
//            mv.addObject("totalCost", totalCost);
//            mv.addObject("newWalletBalance", newBalance);
//
//            mv.setViewName("purchaseSuccess.jsp");
//        } else {
//            mv.setViewName("insufficientBalance.jsp");
//        }
//
//        return mv;
//    }
	
	
	
	@RequestMapping("/purchase")
	public ModelAndView purchase(HttpServletRequest request) throws ClassNotFoundException, SQLException {
	    ModelAndView mv = new ModelAndView();

	    HttpSession session = request.getSession();
	    String c_username = (String) session.getAttribute("c_username");

	    // Calculate the total cost from the cart
	    double totalCost = cartdao.calculateTotalCost();

	    // Get the customer's wallet balance
	    double walletBalance = customerdao.getWalletBalance(c_username);

	    if (walletBalance >= totalCost) {
	        // Deduct the total cost from the wallet balance
	        double newBalance = walletBalance - totalCost;

	        // Update the customer's wallet balance in the database
	        customerdao.updateWalletBalance(c_username, newBalance);

	        // Clear the cart after successful purchase
	        // cartdao.clearCart();

	        // Add total cost and new wallet balance to the ModelAndView
	        mv.addObject("totalCost", totalCost);
	        mv.addObject("newWalletBalance", newBalance);

	        mv.setViewName("purchase_success"); // Redirect to purchase_success.jsp
	    } else {
	        mv.setViewName("insuff_balance"); // Redirect to insuff_balance.jsp
	    }

	    return mv;
	}

}


