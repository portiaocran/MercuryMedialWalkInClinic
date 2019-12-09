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
<title>Book an Appointment</title>
</head>
<body>
	<section>
	<div style = "text-align: center">
	 <h2><b>Book Appointment</b></h2>
	 <h5>Appointments can only be booked for the future*</h5>
	</div>
	
	<form action="bookAppointment" method="POST">
	
	 <div class="container">
	    
	<h3>Book Appointment for : ${user.firstName} ${user.lastName} </h3> 
	<h4>Healthcard Number : ${user.OHIPNumber} ${user.OHIPVersion}</h4>   
    <label for="date"><b>Date</b></label>
    <br><input type="date" name="date" min="${date}" required>
    
    <label for="time"><b>Time</b></label>
    <br><input type="time" name="time" required>

	<label for="reason"><b>Reason for Visit</b></label>
    <br><input type="text" name="reason" required maxlength="80">

	
    <button type="submit" >Book Appointment</button>


    <button type="button" class="cancelbtn">Cancel</button>
    </div>
	</form>
	
	</section>
	
</body>
</html>