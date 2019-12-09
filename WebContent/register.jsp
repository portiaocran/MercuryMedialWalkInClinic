<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
	overflow-x: hidden;	
}
</style>
<title>Create Profile</title>
<link rel ="stylesheet" href="CSS/css.css">
</head>
<body>

	<form action="CreatePerson" method="POST">
	
	 <div class="container">
	 
	 <h2><b>Personal Information</b></h2>
    
    <label for="fName"><b>First Name</b></label>
    <input type="text" placeholder="First Name" name="fName" maxlength="45" required>

	<label for="midInitials"><b>Middle Initial</b></label>
    <input type="text" placeholder="Middle Initial" name="midInitials" maxlength="3">
	
    <label for="lName"><b>Last Name</b></label>
    <input type="text" placeholder="Last Name" name="lName" maxlength="45" required>

	</div>
  
  	 <div class="container">
    
    <h3><b>Login Information</b></h3>
    <label for="userName"><b>User Name</b></label>
    <input type="text" placeholder="Choose a User Name" name="userName" maxlength="45" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Choose a password" name="password" maxlength="45" required>
	<br><br>
	<b>Are you a patient or a doctor?</b>
	<select name="role">
	
		<option value="2">Patient</option>
		<option value="1">Doctor</option><
	</select><br><br>
	
    <button type="submit" >Next</button>

  </div>

  <div class="container" style="background-color: #6F1A68">
    <button type="button" class="cancelbtn">Cancel</button>
    
  </div>
	
	</form>

</body>
</html>