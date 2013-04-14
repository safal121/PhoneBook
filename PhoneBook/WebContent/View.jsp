<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css"  type="text/css"></link>
<style type="text/css">.link{background-color:moroon;
								font-size:25px;
								color:white;
								text-decoration:none;}</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>
<body>
<div id="nav"><form method="get" action="SearchContacts"><a class="link" href="ViewContacts">Home</a> &nbsp<a class="link" href="newaccount.jsp" class="link">AddContact</a> &nbsp <a href="LogOut" class="link">LogOut</a>&nbsp&nbsp&nbsp<input class="search" name="search" type="text"/><button id='search-button' type='submit'><span>Search</span></button></form></div><br><br>

<table border="1" class="hovertable">
<tr><th>FirstName</th><th>LastName</th><th>ContactNo</th><th>Email</th><th>Address</th><th>Option</tr>
<c:forEach var="contact" items="${contacts}" >
	<tr>
		<td><c:out value="${contact._firstname}"></c:out></td>
		<td>${contact._lastname}</td>
		<td>${contact._contactno}</td>
		<td>${contact._email}</td>
		<td>${contact._address}</td>
		<td>
		
		<a href="EditContact?contactid=${contact._contactid}"><font color="violet">Edit</font></a> 
		<a href="DeleteContact?contactid=${contact._contactid}"><font color="red">Delete</font></a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>