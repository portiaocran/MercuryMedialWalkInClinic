<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/css.css">
<title>Mercury Medical Walk-In Clinic</title>
</head>
<body>

	<form action= "UserProfile" method="POST">	
	 <div class="imgcontainer">
	 <h2>Mercury Medical Walk-In Clinic</h2>
	 
    <img src="images/walkin.jpg" alt="Avatar" class="avatar">
  </div>
	
		<div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>

  </div>

  <div class="container" style="background-color: #6F1A68">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw"><font color="white">Don't have an account? <a href="register.jsp">Register Now.</a></font></span>
  </div>
	
	</form>

</body>
</html>