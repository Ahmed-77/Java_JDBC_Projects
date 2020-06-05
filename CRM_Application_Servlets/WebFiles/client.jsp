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
<h1>Insert CLIENT Details</h1>
</div>
<hr/>

<img src="/home/ahmed/Downloads/copypasteinwebcontentfolderinmainfolderandchanget/test5.png" width="1050"
         height="250">
    
<a href="index.jsp"> Move back to Home</a>
<form action ='clientserv' method="post">
	

<table>
<tr><td>Client ID:</td><td><input type="text" name="clid"></td>
<tr><td>Client Name:</td><td><input type="text" name="cliname"></td>
<tr><td>Client Phone:</td><td><input type="text" name="cliphno"></td>
<tr><td>Client Address :</td><td><input type="text" name="cliaddress"></td>
<tr><td>Company name:</td><td><input type="text" name="companyname"></td>

<tr><td><input type="submit" name = "submit" value="Submit"></td></tr>
</table>

</form>
</div>

</body>
</html>
