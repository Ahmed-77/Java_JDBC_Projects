<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerDetails</title>
</head>
<body>
<div align="center">
<h1>Insert Customer Details</h1>
<a href="index.jsp"> Move back to Home</a>
</div>
<hr/>
<div align="center">
<form action ='MyServlet' method="post">
	

<table>
<tr><td>Customer ID:</td><td><input type="text" name="cusid"></td>
<tr><td>Customer Name:</td><td><input type="text" name="cusname"></td>
<tr><td>Customer Phone:</td><td><input type="text" name="cusphno"></td>
<tr><td>Customer Address :</td><td><input type="text" name="cusaddress"></td>
<tr><td>Customer City:</td><td><input type="text" name="cuscity"></td>

<tr><td><input type="submit" name = "submit" value="Submit"></td></tr>
</table>

</form>
</div>

</body>
</html>