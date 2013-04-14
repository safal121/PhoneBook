<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div id="login"><form class="form-signin" method="Post" action="ValidateLogin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="login" class="input-block-level" placeholder="Email address" name="username">
        <input type="password" class="login" class="input-block-level" placeholder="Password" name="password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form></div>
<div id="signup">
			<form class="form-signup">
        <h2>Don't have an Account</h2>
        Email: <input type="text" class="login" class="input-block-level" placeholder="Email address" name="username"><br>
        Password: <input type="password" class="input-block-level" placeholder="Password" name="password"><br>
        Re-Enter Password:<input type="password" class="input-block-level" placeholder="Password" name="repassword"><br>
       
        <button class="btn btn-large btn-primary" type="submit">Sign Up</button>
      </form>
         </div>
</body>
</html>