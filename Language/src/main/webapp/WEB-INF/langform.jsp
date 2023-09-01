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
	<h1>Dashboard</h1>
		<hr/>
		<form:form action="/language/process" method="POST" modelAttribute="newLang">
	<div class = "form-center">
		<form:label path="name">Name:</form:label>
		<form:input path="name" type="text" />
		<form:errors path="name"/>
	</div>
	<div class = "form-center">
		<form:label path="creator">Creator:</form:label>
		<form:input path="creator" type="text"/>
		<form:errors path="creator"/>
	</div >
	<div class = "form-center">
		<form:label path="version">Version:</form:label>
		<form:input path="version" type="text"/>
		<form:errors path="version"/>
	</div>
	<form:button>SUBMIT</form:button>
	</form:form>
</body>
</html>