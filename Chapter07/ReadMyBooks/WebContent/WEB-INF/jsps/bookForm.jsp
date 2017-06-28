<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Form</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form:form modelAttribute="book" method="POST" action="addBook.htm">
		<h2>
			<center>Enter the Book Details</center>
		</h2>

		<table width="100%" height="150" align="center" border="0">
			<tr>
				<td width="50%" align="right">Name of the Book</td>
				<td width="50%" align="left">
						<form:input path="bookName" size="30" />
                        <font color="red"><form:errors path="bookName" /></font>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">ISBN number</td>
				<td width="50%" align="left">
						<form:input path="ISBN" size="30" />
						<font color="red"><form:errors path="ISBN" /></font>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">Name of the Author</td>
				<td width="50%" align="left">
						<form:input path="author" size="30" />
						<font color="red"><form:errors path="author" /></font>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">Price of the Book</td>
				<td width="50%" align="left">
					<form:select path="price">
						<form:options items="${priceList}" />  
					</form:select>
					<font color="red"><form:errors path="price" /></font>
				</td>
    		</tr>
			<tr>
				<td width="50%" align="right">Description of the Book</td>
				<td width="50%" align="left">
					<form:input path="description"	size="30" />
					<font color="red"><form:errors path="description" /></font>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">Publication of the Book</td>
				<td width="50%" align="left">
					<form:input path="publication"	size="30" />
					<font color="red"><form:errors path="publication" /></font>
				</td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"	value="Add Book"></td>
			</tr>

		</table>

	</form:form>

</body>
</html>