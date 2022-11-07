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
	
		<div>
			<h3><a href="/songs/new">Add New</a>
			<a href="/search/topTen">Top Ten</a></h3>
			<form action="/search" class="search" method="get">
				<input type="text" name="artist"/>
				<button type="submit">Search Artists</button>
			</form>
		</div>


		<table border="5" align="center">
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td><a href="/songs/${ song.id }">${ song.title }</a></td>
					<td>${ song.rating }</td>
					<td>
						<form action="/songs/<c:out value="${song.id}"/>" method="post">
					    	<input type="hidden" name="_method" value="delete">
		    				<input type="submit" value="delete">
					    </form>
					</td>
				</tr>
			</c:forEach>
			
		</table>

</body>
</html>