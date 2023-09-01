<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Section</h1>
	<hr/>
	
	<p style="text-align:right"><a href="/language">Dashboard</a></p>

	<form:form action="/lang/update/${ editLang.langid }" method="POST" modelAttribute="editLang">
	<input type="hidden" name="_method" value="put">
	<div>
		<form:label path="name">Name:</form:label>
		<form:input path="name" type="text" value="${ theLang.name }"/>
		<form:errors path="name"/>
	</div>
	<div>
		<form:label path="creator">Creator:</form:label>
		<form:input path="creator" type="text" value="${ theLang.creator }"/>
		<form:errors path="creator"/>
	</div>
	<div>
		<form:label path="version">Version:</form:label>
		<form:input path="version" type="text" value="${ theLang.version }"/>
		<form:errors path="version"/>
	</div>
	
	
		<input type="submit" value="Submit"/>
	</form:form>
	<div>
		<form action="/delete/lang/${ theLang.langid }" method="post">
		<input type="hidden" name="_method" value="delete">
    	<input type="submit" onclick="return confirm('are you sure?');" value="Delete">
    </form>
	
	</div>
	
	
	
	
	</body>
	
	

</html>