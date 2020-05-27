<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<div align="center">
	<div>
		<img src="../images/admin_logo.png"/>
	
	</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div>
		Welcome, <c:out value="${sessionScope.user_email}"></c:out> | <a href="logout">Logout</a>
		<br/><br/>
	</div>
	<div id="header_menu">
		<div>
			<a href="list_users">
				<img src="../images/user.png"/><br/>Users
			</a>
		</div>
		
		<div>
			<a href="list_category">
				<img src="../images/category.png"/><br/>Categories
			</a>
		</div>

		<div>
			<a href="trainers">
				<img src="../images/trainer.png"/><br/>Trainers
			</a>
		</div>		

		<div>
			<a href="customers">
				<img src="../images/customer.png"/><br/>Customers
			</a>
		</div>				
		
		<div>
			<a href="reviews">
				<img src="../images/review.png"/><br/>Reviews
			</a>
		</div>						

		<div>
			<a href="orders">
				<img src="../images/order.png"/><br/>Orders
			</a>
		</div>						
	</div>	
</div>