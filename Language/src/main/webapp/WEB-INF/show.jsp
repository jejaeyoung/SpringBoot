<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
</head>
<body>

	<p style="text-align:right"><a href="/language">Dashboard</a></p>
	<p>${ theLang.name }</p>
	<p>${ theLang.creator }</p>
	<p>${ theLang.version }</p>
	<p><a href="/edit/lang/${ theLang.langid }">EDIT </a></p>

		<form action="/delete/lang/${ theLang.langid }" method="post">
		<input type="hidden" name="_method" value="delete">
    	<input type="submit" onclick="return confirm('are you sure?');" value="Delete">
	
	</form>
</body>
</html>