<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD CLIENT</title>
</head>
<body>
<div align="center">
<h1>Enter Contact Details</h1>
</div>
<hr/>
<div align="center">
<form action ='contactserv' method="post">
<a href="index.jsp"> Move back to Home</a>	

<table>
<tr><td>Contact ID:</td><td><input type="text" name="coid"></td>
<tr><td>Contact Name:</td><td><input type="text" name="coname"></td>
<tr><td>Contact Phone:</td><td><input type="text" name="cophno"></td>
<tr><td>Contact Email :</td><td><input type="text" name="coemail"></td>


<tr><td><input type="submit" name = "submit" value="Submit"></td></tr>
</table>

</form>
</div>

</body>
</html>