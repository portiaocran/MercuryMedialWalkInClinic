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
<title>Check in For Appointment</title>
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
	
	h2, h3, h4 {
		text-align: center;
	}
	
</style>

</head>

	<body>
	
	<section>

	
		<h2>Register For Appointment</h2>
		<h4>Today's appointment</h4>
		
		<c:choose>
		
			<c:when test="${empty regAppt}"> <h5>You have already checked in for today's appointment or you don't have any appointments today.</h5></c:when>
			
				<c:otherwise>
				
				<h4>Please ensure all your data is correct. If not, please <a href="UpdateUserProfile.jsp">Update your user profile</a></h4>
	
				<b>First Name: </b> ${user.firstName}<br>
				<b>Last Name: </b> ${user.lastName}<br>
				<b>DOB: </b> ${DOB}</br>
				<b>Healthcard Number : </b> ${user.OHIPNumber} ${user.OHIPVersion}</br>
				
					<h5>If your data is correct, please register for today's appointment.</h5>
					
					<form action ="checkedIn" method = "POST">
						Reason: ${regAppt.reasonForVisit} Date: ${regAppt.dateTime }
						<input type="submit" value="Register">
					</form>
					
				</c:otherwise>
				
		</c:choose>
	</section>
	
	
	</body>
	
</html>
				
	</section>
	
	
</body>
	
</html>