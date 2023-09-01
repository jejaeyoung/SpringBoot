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
		<table border="2" align="center">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			<c:forEach var="theLang" items="${ langlist }">
			<tr>
				<td> 
					<a href="/language/show${ theLang.langid }">${ theLang.name }</a>
				</td>
				<td> ${ theLang.creator }</td>
				<td> ${ theLang.version }</td>
				<td>
					<form action="/delete/lang/${ theLang.langid }" method="post">
					    <input type="hidden" name="_method" value="delete">
    					<input type="submit" onclick="return confirm('are you sure?');" value="Delete">
					<a href="/edit/lang/${ theLang.langid }">EDIT </a>||
				</form>
				</td>
			</tr>
			</c:forEach>
		</table>
		<form:form action="/language/process" method="POST" modelAttribute="newLang">
	<div>
		<form:label path="name">Name:</form:label>
		<form:input path="name" type="text" />
		<form:errors path="name"/>
	</div>
	<div>
		<form:label path="creator">Creator:</form:label>
		<form:input path="creator" type="text"/>
		<form:errors path="creator"/>
	</div>
	<div>
		<form:label path="version">Version:</form:label>
		<form:input path="version" type="text"/>
		<form:errors path="version"/>
	</div>
	
	<form:button>Submit</form:button>
	</form:form>
</body>
</html>