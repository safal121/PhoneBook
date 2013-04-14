<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/header.jsp" %>
</head>
<body>
<br><br>

<form method="post" action="PhoneBook">
<label for="firstname">First Name:</label><input type="text" name="firstname" placeholder="Enter your Firstname"/><br><br>
<label for="middlename">Middle Name:</label><input type="text" name="middlename" placeholder="Enter your Middlename"/><br><br>
<label for="lastname">Last Name:</label><input type="text" name="lastname" placeholder="Enter your Lastname"/><br><br>
<label for="contact">Contact No:</label><input type="text" name="contactno" placeholder="Enter your Contact No"/><br><br>
<label for="email">Email:</label><input type="text" name="email" placeholder="Enter your Email"/><br><br>
<label for="address">Address:</label><input type="text" name="address" placeholder="Enter your Address"/><br><br>
<br>
<button class="btnExample" type="submit" name="submit">SUBMIT</button></form>
</body>
</html>