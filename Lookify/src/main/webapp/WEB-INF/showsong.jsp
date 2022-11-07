<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
			<a href="/dashboard">Dashboard</a>
	
			<h3>Song Title</h3>
			${ song.title }
			<h3>Artist</h3>
			${ song.artist }
			<h3>Rating</h3>
			${ song.rating }
			<form action="/songs/${ song.id }" method="post">
				<input type="hidden" name="_method" value="delete" />
				<input type="submit" value="Delete" />
			</form>
		

</body>
</html>