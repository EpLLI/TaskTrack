<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="front/css/bootstrap.min.css" rel="stylesheet"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Вход</title>
</head>
<body class="container">


	<h1 >Введите входные данные</h1>
	<center>
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post" class="form-horizontal">
			 <div >
				<c:if test="${not empty error}">
					<b>${error}</b>
				</c:if>
			</div>
			<br>
			<div style="text-align: center">
				<c:if test="${not empty exception}">
					<b><em>${exception}</em></b>
				</c:if>
			</div>
			<br>
			<div class="input-group input-sm">
				<label class="input-group-addon" for="username"><i
					class="fa fa-user"></i></label> <input type="text" class="form-control"
					id="username" name="username" placeholder="Enter Username"
					required="required"><jsp:text /></input>
			</div>
			<div class="input-group input-sm">
				<label class="input-group-addon" for="password"><i
					class="fa fa-lock"></i></label> <input type="password" class="form-control"
					id="password" name="password" placeholder="Enter Password"
					required="required"><jsp:text /></input>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"><jsp:text /></input>

			<div class="form-actions">
				<input type="submit" class="btn btn-block btn-primary btn-default"
					value="Log in" />
			</div>
		</form>
	</center>

</body>
</head>
</html>