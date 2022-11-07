<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		
			<a href="/dashboard">Dashboard</a>
	
		
			<form:form action="/songs/process" method="POST" modelAttribute="song">
			<p>	
				<form:label path="title">Title</form:label>
				<form:input path="title"/>
				<form:errors path="title"/>
			
			</p>
			<p> 
				<form:label path="artist">Artist</form:label>
				<form:input path="artist"/>
				<form:errors path="artist"/>
			</p>
			<p> 
				<form:label path="rating">Rating (1-10)</form:label>
				<form:errors path="rating"/>
				<form:input type="number" path="rating"/>
			</p>
			<input type="submit" value="Add Song"/>
			</form:form>
		
	
</body>
</html>