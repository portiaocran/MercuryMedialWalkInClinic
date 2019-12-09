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
    height: auto;
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
<title>User Profile</title>
</head>
<body>
	<section>
	<div style = "text-align: center">
	 <h2><b>Update User Profile</b></h2>
	</div>
	
	<form action="ChangeInfo" method="POST">
	
	 <div class="container">
	    
    <label for="fName"><b>First Name</b></label>
    <br><input type="text" placeholder="${user.firstName}" name="fName">

	<br><label for="midInitials"><b>Middle Initial</b></label>
    <br><input type="text" placeholder="${user.middleInitials}" name="midInitials" >
	
    <br><label for="lName"><b>Last Name</b></label>
    <br><input type="text" placeholder="${user.lastName}" name="lName" >

	<br><label for="healthcardNumber"><b>HealthCard Number</b></label>
    <br><input type="number" placeholder="${user.OHIPNumber}" name="healthcardNumber" readonly>

	<br><label for="healthcardVer"><b>HealthCard Version</b></label>
    <br><input type="text" placeholder="${user.OHIPVersion}" name="healthcardVer">

	<br><label for="gender"><b>Gender</b></label>
    <br><input type="text" placeholder="${user.gender}" name="gender" readonly>

	<br><label for="dob"><b>Date of Birth</b></label>
    <br><input type="text" placeholder="${DOB}" name="dob" readonly>
	

    <h3><b>Login Information</b></h3>
    <label for="userName"><b>User Name</b></label>
    <br><input type="text" placeholder="${user.userName}" name="userName" readonly>

	<label for="password"><b>Password</b></label>
    <br><input type="text" placeholder="${loginInfo.password}" name="password">
	

    <button type="submit" >Update Profile</button>


    <button type="button" class="cancelbtn">Cancel</button>
    </div>
	</form>
	
	</section>
	
</body>
</html>