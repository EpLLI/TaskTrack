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
	<p>Task	</p>
	<table class="table table-bordered table-condensed">
		<tr>
			<th>Project</th>
			<th>Name</th>
			<th>Date</th>
			<th>Manager</th>
			<th>Developer</th>
			<th>importance</th>
			<th>Status</th>
		</tr>
		<c:forEach var="z" items="${task}">
			<tr>
				<td><c:out value="${z.getProject()}" />
				<td><c:out value="${z.getName()}" />
				<td><c:out value="${z.getDate()}" />
				<td><c:out value="${z.getManager()}" />
				<td><c:out value="${z.getDeveloper()}" />
				<td><c:out value="${z.getImportance()}" />
				<td><c:out value="${z.getStatus()}" />
				<td><a href="Comments?Name=${z.getName()}">Коментарии</a>
			<tr />
		</c:forEach>
	</table>



	<br>
	<p>Добавить коментарий
	<p>
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
			<input type="submit" value="Save Comment" class="btn btn-success" />
		</form:form>
		<br />
	<form:form>

		<c:url var="logout" value="/logout" />
		<a href="${logout}" class="btn btn-warning">Logout</a>
	</form:form>
</body>
</html>