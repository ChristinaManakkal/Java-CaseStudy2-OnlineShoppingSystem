<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Online Shopping System</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #E6F7E6; /* Light green background */
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            font-size: 36px;
            color: #006600; /* Dark green text color */
            margin-top: 50px;
        }

        .login-form {
            text-align: center;
            margin: 20px auto;
            padding: 20px;
            background-color: #FFFFFF; /* White form background */
            border-radius: 8px;
            width: 300px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .login-button {
            background-color: #009900; /* Green button background */
            color: #FFFFFF; /* White button text color */
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 16px;
            margin-top: 20px;
        }

        .login-button:hover {
            background-color: #007700; /* Darker green button background on hover */
        }
    </style>
</head>
<body>
    <h1>Welcome to Online Shopping System!</h1>
    <div class="login-form">
        <form action="adminlogin.jsp">
            Login as:
            <br/><br/>
            <input class="login-button" type="submit" value="Administrator"/>
        </form>

        <form action="customerlogin.jsp">
            <br/><br/>
            <input class="login-button" type="submit" value="Customer"/>
        </form>
    </div>
</body>
</html>
