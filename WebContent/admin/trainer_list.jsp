<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manage Trainers - Running Trainer Outlet Administration</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2 class="page_heading">Trainer Management</h2>
	
		<h3><a href="new_trainer">Create new Trainer</a></h3>
	</div>
	
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Id</th>
				<th>Image</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Category</th>
				<th>Price</th>
				<th>Last Updated</th>
				<th>Actions</th>
			</tr>		
			<c:forEach var="trainer" items="${trainerList}" varStatus="status">
				<tr align="center">
					<td>${status.index + 1}</td>
					<td>${trainer.trainerId}</td>					
					<td>
						<img src="data:image/jpg;base64,${trainer.base64Image}" width="84" height="110"/>
					</td>					
					<td>${trainer.brand}</td>
					<td>${trainer.model}</td>
					<td>${trainer.category.name}</td>	
					<td>${trainer.price}</td>	
					<td>${trainer.lastUpdatedOn}</td>	
					<td>
						<a href="edit_trainer?id=${trainer.trainerId}">Edit</a> &nbsp;
						<a href="javascript:void(0);" id="${trainer.trainerId}" class="delete_link">Delete</a>
					</td>															
				</tr>
			</c:forEach>											
		</table>
	</div>

	<jsp:directive.include file="footer.jsp"/>

	<script>
		
	$(document).ready(function () {
		$(".delete_link").each(function () {
			$(this).on("click", function () {
				trainerId = $(this).attr("id"); 
				if (confirm("Are you sure you want to trainer user with id " + trainerId + "?")) {
					window.location = "delete_trainer?id=" + trainerId;
				}
			});
		});		
	});
		
	</script>

</body>
</html>