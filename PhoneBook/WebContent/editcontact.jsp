<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
<form method="post" action="ContactsEdit?contactid=${editcontact._contactid}">
        <div class="form">
            <p>
                <label>First Name:&nbsp</label>
                <input class="contact" type="text" name="firstname" value="${editcontact._firstname}">
                
            </p>
            <p>
                <label>Last Name:&nbsp</label>
                <input class="contact" type=text name="lastname" value="${editcontact._lastname}">
                
            </p>
            <p>
                <label>Contact No:</label>
                <input class="contact" type="text" name="contactno" value="${editcontact._contactno}">
                
            </p>
            <p>
                <label>E-mail:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
                <input class="contact" type="text" name="email" value="${editcontact._email}">
               
            </p>
            <p>
                <label>Address:&nbsp&nbsp&nbsp&nbsp&nbsp</label>
                <input class="contact" type="text" name="address" value="${editcontact._address}"><br>
               
            </p>
            
            <button class="add" type="submit">Edit</button></form>
</body>
</html>