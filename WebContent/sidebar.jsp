<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/sidebar.css">
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/mercury"
user="root" password="Aitrop31" />

<sql:query dataSource="${db}" var="result">SELECT * FROM
menufunctions</sql:query>


<div class="sidenav">
	<c:forEach var ="row" items="${result.rows}">
		<a href="${row.URL}"><b>${row.FunctionName}</b></a>
	</c:forEach>

</div>
</body>
</html>