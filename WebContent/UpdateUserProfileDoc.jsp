<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="CSS/css2.css">
<meta charset="ISO-8859-1">
<style>
section {
  margin-top: 4.7px;
  top: 195px;
  padding: 20px;
  width: 76.4%;
  max-width: 100%;
    height: 100%;
  font-family: Arial;
  background-color: #f1f1f1;
  margin-left: 255px;
     position: absolute;
  
}

body{
	overflow-x: hidden;
	overflow-y: auto;
	
}

.main{
	text-align: center;
}


</style>
<title>Update User Profile</title>
</head>
<body>

	<section>
	<div style = "text-align: center">
	 <h2><b>Update User Profile</b></h2>
	</div>
	
	<form action="CreatePerson" method="POST">
	
	 <div class="container">
	    
    <label for="fName"><b>First Name</b></label>
    <br><input type="text" placeholder="${user.firstName}" name="fName" required>

	<br><label for="midInitials"><b>Middle Initial</b></label>
    <br><input type="text" placeholder="${user.middleInitials}" name="midInitials" required>
	
    <br><label for="lName"><b>Last Name</b></label>
    <br><input type="text" placeholder="${user.lastName}" name="lName" required>

	<br><label for="cpso"><b>CPSO</b></label>
    <br><input type="text" placeholder="${user.CPSO}" name="cpso" required>

	<br><label for="pracName"><b>Practice Name</b></label>
    <br><input type="text" placeholder="${pracName}" name="cpso" required>


    <h3><b>Login Information</b></h3>
    <label for="userName"><b>User Name</b></label>
    <br><input type="text" placeholder="${username}" name="userName" required>

    <button type="submit" >Update Profile</button>


    <button type="button" class="cancelbtn">Cancel</button>
    </div>
	</form>
	
	</section>
	
</body>
</html>