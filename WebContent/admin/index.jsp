<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Running Trainer Outlet Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>

	<div align="center">
		<h2>Administrative Dashboard</h2>
	</div>
	
	<hr width="50%" />	
	<div align="center">
		<h2>Quick Actions:</h2>
		<b>
		<a href="create_trainer">New Trainer</a> &nbsp
		<a href="create_user">New User</a> &nbsp
		<a href="create_category">New Category</a> &nbsp
		<a href="create_customer">New Customer</a> &nbsp
		</b>
	</div>
		<hr width="50%" />	
	<div align="center">
		<h2>Recent Sales:</h2>
	</div>
		<hr width="50%" />	
	<div align="center">
		<h2>Recent Reviews:</h2>
	</div>
		<hr width="50%" />	
	<div align="center">
		<h2>Statistics:</h2>
	</div>
	<hr width="50%" />	
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>