<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book LIST</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Book NAME</td>
			<td>Book AUTHOR</td>
			<td>BOOK PRICE</td>
		</tr>
		<tr>
			<td>${book.bookName}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
		</tr>
	</table>
</body>
</html>