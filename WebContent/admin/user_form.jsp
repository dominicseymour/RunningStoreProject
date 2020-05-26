<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<c:if test="${user != null}">
		Edit User
	</c:if>
	<c:if test="${user == null}">
		Create New User
	</c:if>
</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2 class="page_heading">
			<c:if test="${user != null}">
				Edit User
			</c:if>
			<c:if test="${user == null}">
				Create New User
			</c:if>			
		</h2>
	</div>
	
	<div align="center">
		<c:if test="${user != null}">
			<form action="update_user" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name="userId" value="${user.userId}">
		</c:if>
		<c:if test="${user == null}">
			<form action="create_user" method="post" onsubmit="return validateFormInput()">
		</c:if>
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email" size="20" value="${user.email}"></td>
				</tr>
				<tr>
					<td align="right">Full name:</td>
					<td align="left"><input type="text" id="fullname" name="fullname" size="20" value="${user.fullName}"></td>
				</tr>			
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" size="20" value="${user.password}"></td>
				</tr>					
				<tr> 
					<td colspan="2" align="center"> </br>
						<button type="submit">Save</button>
						&nbsp;&nbsp;&nbsp;
						<button onclick="javascript:history.go(-1);">Cancel</button>
					</td>
				</tr>								
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>

<script type="text/javascript">

	function validateFormInput() {
		
		var email = document.getElementById("email");
		
		if (email.value.length == 0) {
			alert("Email is required");
			email.focus();
			return false;
		}
		
		var fullname = document.getElementById("fullname");
		
		if (fullname.value.length == 0) {
			alert("Fullname is required");
			fullname.focus();
			return false;
		}
		var password = document.getElementById("password");
		
		if (password.value.length == 0) {
			alert("Password is required");
			password.focus();
			return false;
		}
		
		return true;
	}

</script>

</html>