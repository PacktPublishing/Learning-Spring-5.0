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
	<form:form modelAttribute="myPerson" method="POST" action="addPerson.htm">
		<h2>
			<center>Enter the Person Details</center>
		</h2>

		<table width="100%" height="150" align="center" border="0">
			<tr>
				<td width="50%" align="right">First Name of the Person</td>
				<td width="50%" align="left">
						<form:input path="firstName" size="30" />
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">last Name of the Person</td>
				<td width="50%" align="left">
						<form:input path="lastName" size="30" />
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">Hobby Select</td>
				<td width="50%" align="left">
					<form:select path="hobby" items="${hobbies}" itemLabel="hobbyName" itemValue="hobbyId">
					</form:select>
				</td>
    		</tr>
            <tr>
				<td width="50%" align="right">Hobby Options</td>
				<td width="50%" align="left">
					<form:select path="hobby" >
						<form:options items="${hobbies}" itemLabel="hobbyName" itemValue="hobbyId"/>   
					</form:select>

				</td>
    		</tr>

			<tr>
				<td width="50%" align="right">Hobby CheckBoxes</td>
				<td width="50%" align="left">
					<form:checkboxes path="hobby" items="${hobbies}" itemLabel="hobbyName" itemValue="hobbyId"/>

				</td>
    		</tr>

          <tr>
				<td width="50%" align="right">Hobby Radio Buttons</td>
				<td width="50%" align="left">
					<form:radiobuttons path="hobby" items="${hobbies}" itemLabel="hobbyName" itemValue="hobbyId"/>

				</td>
    		</tr>
          
			<tr>
				<td colspan="2" align="center"><input type="submit"	value="Add Person"></td>
			</tr>

		</table>

	</form:form>

</body>
</html>