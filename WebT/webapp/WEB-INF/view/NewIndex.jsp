
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:tiles="http://tiles.apache.org/tags-tiles">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<link href="front/css/bootstrap.min.css" rel="stylesheet"> 
<head>
<meta charset="UTF-8">

<title>menu</title>

</head>
<body class="container">

			 <security:authorize access="isAuthenticated()">
				<security:authorize access="hasRole('ROLE_man')">

		
					<form  name="User" action="Developers">
						<input type="submit" value="Developers" class="btn btn-success"/>
					</form>
					<form  name="Project" action="Project">
						<input type="submit" value="Project"  class="btn btn-success"/>
					</form>
				</security:authorize>


				<security:authorize access="hasRole('ROLE_dev')">
					<form  name="Project" action="Project">
						<input type="submit" value="Project"  class="btn btn-success"/>
					</form>
					<form  name="Comment" action="Comment">
						<input type="submit" value="Comment"  class="btn btn-success"/>
					</form>
				</security:authorize>

			</security:authorize>
	
<form:form>

		<c:url var="logout" value="/logout" />
		<a href="${logout}" class="btn btn-warning">Logout</a>
	</form:form>
</body>
</html>