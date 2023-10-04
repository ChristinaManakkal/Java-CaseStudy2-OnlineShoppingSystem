<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Login</title>
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
    <h1>Customer Login</h1>
    <form action="checkCustomer" method="post">
        Username: <input type="text" name="c_username"><br>
        Password: <input type="password" name="c_password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
