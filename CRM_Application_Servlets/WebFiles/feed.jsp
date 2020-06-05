<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FeedBack</title>
</head>
<body>
<div align="center">
<h1>Enter FeedBack</h1>
</div>
<hr/>
<div align="center">
<form action ='feedserv' method="post">
<a href="index.jsp"> Move back to Home</a>	

<table>
<tr><td>Please Enter ID:</td><td><input type="text" name="id"></td>
<tr><td>Enter Name:</td><td><input type="text" name="name"></td>
<tr><td>Rating For Experience:</td><td><input type="text" name="rating"></td>
<tr><td>FeedBack :</td><td><input type="text" name="feed"></td>
<tr><td>Anyway we could improve:</td><td><input type="text" name="improv"></td>
<tr><td>Phone number:</td><td><input type="text" name="phno"></td>


<tr><td><input type="submit" name = "submit" value="Submit"></td></tr>
</table>

</form>
</div>

</body>
</html>