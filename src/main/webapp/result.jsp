<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
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
<h1>Products List</h1>
    <table border="1">
        <tr>
            <th>Product No</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Discount</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td>${product.prod_no}</td>
                <td>${product.pname}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.discount}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>