<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Functions</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f7e6; /* Light green background */
            margin: 0;
            padding: 0;
            text-align: center;
        }

        h1 {
            font-size: 24px;
            color: #006600; /* Dark green text */
            margin-top: 50px;
        }

        form {
            background-color: #ffffff; /* White form background */
            border-radius: 8px;
            width: 300px;
            margin: 20px auto;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 4px;
            margin-bottom: 10px;
            border: 1px solid #006600; /* Dark green border */
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #009900; /* Green button background */
            color: #ffffff; /* White button text color */
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #007700; /* Dark green button background on hover */
        }
    </style>
</head>
<body>
<h1>Admin Functions</h1>
	<form action="addproduct">
	
	Enter Product Number:<input type="text" name="prod_no"/><br/>
	Enter Product Name:<input type="text" name="pname"/><br/>
	Enter Product Price:<input type="text" name="price"/><br/>
	Enter Product Quantity:<input type="text" name="quantity"/><br/>
	Enter Product Discount:<input type="text" name="discount"/><br/>
	
	<input type="submit" value="Add Products"/>
	</form><br/><br/>
	
	<form action="showproduct">
	<input type="submit" value="Show Products"/>
	</form><br/><br/>
	
	<form action="addCustomer">
	Enter Customer id:<input type="text" name="c_id"/><br/>
	Enter Username:<input type="text" name="c_username"/><br/>
	Enter Password:<input type="password" name="c_password"/><br/>
	Enter Wallet Balance:<input type="text" name="wallet_balance"/><br/>
	
	<input type="submit" value="Add customer's account "/>
	</form><br/><br/>
	
	<form action="removeCustomer">
	Enter Username to remove:<input type="text" name="c_username"/><br/>
	<input type="submit" value="Remove customer's account "/>
	</form>
	
	
	
	</body>
</html>