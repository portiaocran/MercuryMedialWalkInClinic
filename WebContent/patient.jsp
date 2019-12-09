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
<link rel="stylesheet" href="CSS/css.css">
</head>
<body>
	<form action="CreatePatient" method="POST">
	
	 <div class="container">
	 
	 <h2><b>Healthcard Information</b></h2>
    
    <label for="ohipNum"><b>OHIP Number</b></label>
    <input type="text" placeholder="OHIP Number" name="ohipNum"  pattern="[1-9]{1}[0-9]{9}" required>

    <label for="ohipVer"><b>OHIP Version</b></label>
    <input type="text" placeholder="OHIP Version" name="ohipVer" required>
    
    <label for="DOB"><b>Date of Birth</b></label>
    <input type="date" placeholder="OHIP Version" name="DOB" required>
    <br><br>
    
    <b>Gender</b>
	<select name="gender">
		<option value="F">Female</option>
		<option value="M">Male</option><br>
	</select>
	<br>
	<br>
	  <button type="submit" >Create Profile</button>
	
	</div>


  <div class="container" style="background-color: #6F1A68">
    <button type="button" class="cancelbtn">Cancel</button>
    
  </div>
	
	</form>
</body>
</html>