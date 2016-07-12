<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<link href="front/css/bootstrap.min.css" rel="stylesheet">
<head>

<title></title>
</head>
<body class="container">
	<p>Task
	<p>
	<table class="table table-bordered table-condensed">
		<tr>
			<th>Id</th>
			<th>Project</th>
			<th>Task</th>
			<th>Developer</th>
			<th>Text</th>
		</tr>
		<c:forEach var="c" items="${comm}">
			<tr>
				<td><c:out value="${c.getId()}" />
				<td><c:out value="${c.getProject()}" />
				<td><c:out value="${c.getTask()}" />
				<td><c:out value="${c.getDeveloper()}" />
				<td><c:out value="${c.getText()}" />
				<td><a href="deletecom?id=${c.getId()}">delete</a>
			<tr />
		</c:forEach>
	</table>
	<br>
	<p>Добавить коментарий

		<s:url var="saveUrl" value="/addComment" />
		<form:form modelAttribute="comm" method="POST" action="${saveUrl}">
		
		Task:
		<input type="hidden" name="operation" value="Add">
			<select name="t" class="form-control">
				<c:forEach items="${task}" var="t">
					<option value="${t.getName()}">${t.getName()}</option>
				</c:forEach>

			</select>
			<br />
		Developer <input class="form-control" name="developer" type="text">
		
		Text <input class="form-control" name="text" type="text">
			<br />
			<input type="submit" class="btn btn-success" value="Save Comment" />
		</form:form>
		<br />
		
		
	<h4>Update Comment</h4>
	<s:url var="updateUrl" value="/UpdateComm" />
	<form:form modelAttribute="commen" method="POST" action="${updateUrl}">
		<input type="hidden" name="operation" value="UpdateComm">
		Id: <input class="form-control" name="id" type="text"> 
		Text: <input class="form-control" name="text" type="text">
		<br />
		<input  class="btn btn-success" type="submit" value="UpdateComm" />
	</form:form>

	
	<form:form>
		<c:url var="logout" value="/logout" />
		<a href="${logout}" class="btn btn-warning">Logout</a>
	</form:form>

</body>
</html>