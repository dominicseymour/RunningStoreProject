<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new user</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2>Create New User</h2>
	</div>
	
	<div align="center">
		<form action="create_user" method="post" onsubmit="return validateFormInput()">
			<table>
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email" size="20"></td>
				</tr>
				<tr>
					<td align="right">Full name:</td>
					<td align="left"><input type="text" id="fullname" name="fullname" size="20"></td>
				</tr>			
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" size="20"></td>
				</tr>					
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save">
						<input type="button" value="Cancel" onclick="javascript:history.go(-1);">
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