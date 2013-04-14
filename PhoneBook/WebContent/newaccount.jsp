<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Contact</title>
</head>
<body>
		<body>
        <form method="post" action="CreateAccount">
        <div class="form">
            <p>
                <label>First Name:</label>
                <input class="contact" type="text" name="firstname">
                
            </p>
            <p>
                <label>Last Name:</label>
                <input class="contact" type=text name="lastname">
                
            </p>
            <p>
                <label>Contact No:</label>
                <input class="contact" type="text" name="contactno">
                
            </p>
            <p>
                <label>E-mail:</label>
                <input class="contact" type="text" name="email">
               
            </p>
            <p>
                <label>Address:</label>
                <input class="contact" type="text" name="address"><br><br>
               
            </p>
            
            <button class="add" type="submit">Add</button>
        </div>
</body>
</html>