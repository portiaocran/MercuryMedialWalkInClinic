<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<link rel = "stylesheet" href="CSS/css.css">
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/mercury"
user="root" password="Aitrop31" />

<sql:query dataSource="${db}" var="result">SELECT * FROM
provinces</sql:query>

	<form action="CreatePractitioner" method="POST">
	
	 <div class="container">
	 
	 <h2><b>Practitioner Information</b></h2>
    
    <label for="CPSO"><b>CPSO Number</b></label>
    <input type="number" placeholder="CPSO Number" name="CPSO" required>

    <label for="pracName"><b>Practice Name</b></label>
    <input type="text" placeholder="Practice Name" name="pracName" required>
    
    <br><br>
    <b> Practice Information</b><br><br>
    <label for="street"><b>Street Address</b></label>
    <input type="text" placeholder="Address" name="street" required>
    
    <label for="street2"><b>Street Address 2</b></label>
    <input type="text" placeholder="Address 2" name="street2">

    <label for="aptUnit"><b>Apt or Unit Number</b></label>
    <input type="text" placeholder="Apt/ Unit Number" name="aptUnit">

    <label for="city"><b>City</b></label>
    <input type="text" placeholder="City" name="city" required>
    
    <label for="province"><b>Province</b></label> 
		<select name="province">
			<c:forEach var="row" items="${result.rows}">
				<option value="${row.provinceCode}"><h3>${row.province}</h3></option>
			</c:forEach>
		</select>
    <br><br>
    <label for="postalCode"><b>Postal Code</b></label>
    <input type="text" placeholder="Postal Code" name="postalCode" required>
	
	<b>Type:</b><br><br>
	<select name="type">
		<option value="Home">Home</option>
		<option value="Office">Office</option>
	</select><br><br>
	
	  <button type="submit" >Create Profile</button>
	
	</div>


  <div class="container" style="background-color: #6F1A68">
    <button type="button" class="cancelbtn">Cancel</button>
    
  </div>
	
	</form>
	
</body>
</html>