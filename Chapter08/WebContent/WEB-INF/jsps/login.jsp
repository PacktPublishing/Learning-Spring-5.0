<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr>
			<td><img alt="No Image Found" src="images/img1.png"
				width="100px" height="100px"></td>
		</tr>

	</table>
	<br>
	<center>
		<font color="green"><h2>L O G I N - P A G E</h2></font>
	</center>
	<br>
	<br>

  <font color="red"><h4 align="center">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4> </font>
	<form action="<c:url value='/login'/>" method="post">
		<table align="center">
			<tr style="height: 50px">
				<td align="left">User Name</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td align="left">Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td align="left">Remember ME<input type="checkbox" value="rem-me"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="LOGIN"></td>
			</tr>

			


		</table>
	</form>
	<center>
		<font color="red" style="font-style: italic; font-size: large;">
			<c:out value="${error}"></c:out>
		</font>
	</center>
</body>
</html>