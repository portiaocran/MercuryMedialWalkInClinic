<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/../header.jsp" %>
<%@ include file="/../sidebar.jsp" %>
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
	 <h2><b>Book Appointment</b></h2>
	</div>
	
	<form action="bookAppointment" method="POST">
	
	 <div class="container">
	    
	<h3>Appointment booked for : ${user.firstName} ${user.lastName} </h3> 
	<h4>Day and Time : ${dtDis}</h4>   
	<h4>Reason for Visit : ${appt.reasonForVisit}</h4>   

	</section>
	
</body>
</html>