<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<link href="front/css/bootstrap.min.css" rel="stylesheet">
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=charset=UTF-8">
<title>Project menu</title>
</head>
<body class="container">
	<p>Project
	<table class="table table-bordered table-condensed">
		<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Manager</th>
		</tr>
		<c:forEach var="p" items="${proj}">
			<tr>
				<td><c:out value="${p.getName()}" />
				<td><c:out value="${p.getDate()}" />
				<td><c:out value="${p.getManager()}" />
			<tr />
		</c:forEach>
	</table>
	<security:authorize access="hasRole('ROLE_man')">
		<p>Add project</p>
		<s:url var="saveUrl" value="/addProject" />
		<form:form modelAttribute="proj" method="POST" action="${saveUrl}">
			<br>
			<input type="hidden" name="operation" value="Add"> 
		name: <input class="form-control" name="name" type="text">
			<br />
		date <input class="form-control" name="date" type="text">
			<br />
		manager <input class="form-control" name="manager" type="text">
			<br />
			<input type="submit" value="Save Project" class="btn btn-success" />
		</form:form>
	</security:authorize>
	<p>Task</p>
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
			<tr />
		</c:forEach>
	</table>
	<p>Add Task	<p>
		<s:url var="saveUrl" value="/addTask" />
		<form:form modelAttribute="Task" method="POST" action="${saveUrl}">
       	project:
		<input type="hidden" name="operation" value="Add">
			<select name="g" class="form-control">
				<c:forEach items="${proj}" var="p">
					<option value="${p.getName()}">${p.getName()}</option>
				</c:forEach>

			</select>
			<br />
		
		name <input class="form-control" name="name" type="text">
			<br />
		Date <input class="form-control" name="date" type="text">
			<br />
		manager <input class="form-control" name="manager" type="text">
			<br />
		developer <input class="form-control" name="developer" type="text">
			<br />
		importance <input class="form-control" name="importance" type="text">
			<br />
		status  <select class="form-control" name="s">

				<option value="Свободно" selected>Свободно</option>
				<option value="Готово">Готово</option>
				<option value="В процессе">В процессе</option>

			</select>

			<br>
			<input type="submit" value="Save Task" class="btn btn-success" />
		</form:form>

		<security:authorize access="hasRole('ROLE_dev')">
			<p>Обновить таск
				<s:url var="saveUrl" value="/UpdateStatusTask" />
				<form:form modelAttribute="Task" method="POST" action="${saveUrl}">
       	Task:
		<input class="form-control" type="hidden" name="operation" value="Add">
					<select name="h" class="form-control">
						<c:forEach items="${task}" var="t">
							<option value="${t.getName()}">${t.getName()}</option>
						</c:forEach>
					</select>
					<br />

					<input type="hidden" name="operation" value="Add">
			status  <select name="j" class="form-control">
						<option disabled>Выберите статуc</option>
						<option value="Свободно" selected>Свободно</option>
						<option value="Готово">Готово</option>
						<option value="В процессе">В процессе</option>

					</select>
					<br>
					<input type="submit" value="Обновить статус"
						class="btn btn-success" />
				</form:form>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_man')">
		<p>Назначить таск
			<s:url var="saveUrl" value="/addDevTask" />
			<form:form modelAttribute="Task" method="POST" action="${saveUrl}">
       	Task:
		<input type="hidden" name="operation" value="Add">
				<select class="form-control" name="t">
					<c:forEach items="${task}" var="t">
						<option value="${t.getName()}">${t.getName()}</option>
					</c:forEach>

				</select>
				<br />
		Developer:
		<input type="hidden" name="operation" value="Add">
				<select class="form-control" name="d">
					<c:forEach items="${dev}" var="d">
						<option value="${d.getUsername()}">${d.getUsername()}</option>
					</c:forEach>
				</select>
				<br>
				<input type="submit" value="Назначить таск" class="btn btn-success" />
			</form:form>
		</security:authorize>
		<form:form>

			<c:url var="logout" value="/logout" />
			<a href="${logout}" class="btn btn-warning">Logout</a>
		</form:form>
</body>

</html>