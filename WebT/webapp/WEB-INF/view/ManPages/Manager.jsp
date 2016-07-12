<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link href="front/css/bootstrap.min.css" rel="stylesheet"> 
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=charset=UTF-8">
<title>Admin menu</title>
</head>
<body class="container">
	<table class="table table-bordered table-condensed" >
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Role</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="p" items="${user}">
			<tr>
				<td><c:out value="${p.getUsername()}" />
				<td><c:out value="${p.getPassword()}" />
				<td><c:out value="${p.getRole()}" />
				<td><a class="btn btn-success" href="delete?id=${p.getId()}">delete</a>
			<tr />
		</c:forEach>
	</table>

	<h4>Add Developer</h4>
	<s:url var="saveUrl" value="/addUser" />
	<form:form modelAttribute="user" method="POST" action="${saveUrl}">
		<br>
		<input   type="hidden" name="operation" value="Add"> 
		username: <input class="form-control" name="username" type="text">
		<br />
		password: <input  class="form-control"  name="password" type="text">
		<br />
		role: <input  class="form-control"   name="role" type="text">
		<br />
		<input type="submit" value="Save User" class="btn btn-success" />
	</form:form>
	<h4>Update Developer</h4>
	<s:url var="saveUrl" value="/UpdateDev" />
	<form:form modelAttribute="User" method="POST" action="${saveUrl}">
		<input type="hidden" name="operation" value="UpdateDev">
		Id: <input class="form-control" name="id" type="text"> <br />
		Role: <input class="form-control" name="role" type="text"><br />
		
		<input type="submit" value="UpdateDev" class="btn btn-success" />
	</form:form>

	<form:form>
		<c:url var="logout" value="/logout" />
		<a href="${logout}" class="btn btn-warning">Logout</a>
	</form:form>
</body>
</html>