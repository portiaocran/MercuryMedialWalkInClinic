<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="CSS/css2.css">
<meta charset="ISO-8859-1">
<title>View Appointments</title>
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

	h3, h2 {
	text-align: center;
	}
	
</style>

</head>
<body>

	<section>
	
		<h2>Upcoming Appointments</h2><br>

		
		<c:choose>
			  <c:when test="${empty apptList}">You have no upcoming appointments. <a href="userProfile.jsp">User Profile</a></c:when>
			  <c:otherwise>
			  	
			  		<table id="appointments">
			  		<tr>
			  		<th>Reason For Visit</th>
			  		<th>Date and Time</th>
			  	</tr>
			
					<c:forEach var ="row" items="${apptList}">
						<tr>
							<td><b>${row.reasonForVisit}</b></td>
							<td><b>${row.dateTime}</b></td>
						</tr>
					</c:forEach>
						</table>
						</c:otherwise>
					
			
		
		</c:choose>
	</section>
	
	</body>
		

</html>