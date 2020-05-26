<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manage Categories - Running Trainer Outlet Administration</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2 class="page_heading">Category Management</h2>
	
		<h3><a href="category_form.jsp">Create New Category</a></h3>
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
				<th>Name</th>
				<th>Action</th>
			</tr>		
			<c:forEach var="category" items="${categoryList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${category.categoryId}</td>					
					<td>${category.name}</td>					
					<td>
						<a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp;
						<a href="javascript:void(0);" id="${category.categoryId}" class="delete_link">Delete</a>
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
				categoryId = $(this).attr("id"); 
				if (confirm("Are you sure you want to delete category with id " + categoryId + "?")) {
					window.location = "delete_category?id=" + categoryId;
				}
			});
		});		
	});
		
		function confirmDelete(categoryId) {
			
			if (confirm("Are you sure you want to delete category with id " + categoryId + "?")) {
				window.location = "delete_category?id=" + categoryId;
			}
		}
	
	</script>

</body>
</html>