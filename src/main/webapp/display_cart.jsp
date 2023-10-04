<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display cart</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: green;}
</style>
</head>
<body>
	<h3>
	Cart:	
	</h3>
	
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Available Quantity</th>
            <th>Discount</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td>${product.prod_no}</td>
                <td>${product.pname}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.discount}</td>
				<td>
	                <form action="removeFromCart">
        				<input type="hidden" name="prod_no" value="${product.prod_no}"/>
        				<input type="hidden" name="pname" value="${product.pname}"/>
        				<input type="hidden" name="price" value="${product.price}"/>
        				<input type="hidden" name="discount" value="${product.discount}"/>
        				<input type="submit" value="Remove from Cart" />
        				       	
    	            </form>
				</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <form action="purchase">
    <input type="submit" value="Purchase"/>
    </form>
    
    <br/>
    <form action="wallet.jsp" >
    <input type="submit" value="Check Wallet Balance"/>
    </form>
</body>
</html>