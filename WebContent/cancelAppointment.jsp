<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="CSS/css2.css">
<meta charset="ISO-8859-1">
<title>Cancel an Appointment</title>
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
	
		h3, h4 {
	text-align: center;
	}
	
</style>

</head>

	<body>
	
	<section>
	
	<h3>Cancel an Appointment</h3>
	<h4>Select an appointment to cancel below:</h4>
		
		<c:choose>
			<c:when test= "${empty apptList}"> You have no appointments. <a href="userProfile.jsp">User Profile</a></c:when>	
			<c:otherwise>
				
				<form action ="apptCancelledController" method="POST">
					<select name="cancel">
						<c:forEach items="${apptList}" var="appts">
						<option value ="${appts.appointmentNumber}"><h3><b>Reason : </b> ${appts.reasonForVisit} | <b>Date & Time:</b> ${appts.dateTime} </h3></option>
						</c:forEach>
					</select>
			
			    	<button type="submit" >Cancel Appointment</button>
			    </form>
				
			</c:otherwise>
		</c:choose>
				
	</section>
	
	
</body>
	
</html>