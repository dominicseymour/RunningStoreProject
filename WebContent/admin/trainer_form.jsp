<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">

	<title>
		<c:if test="${trainer != null}">
			Edit Trainer
		</c:if>
		<c:if test="${trainer == null}">
			Create New Trainer
		</c:if>
	</title>

	<link rel="stylesheet" href="../css/style.css" >
	<link rel="stylesheet" href="../css/jquery-ui.min.css">

	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2 class="page_heading">
			<c:if test="${trainer != null}">
				Edit Trainer
			</c:if>
			<c:if test="${trainer == null}">
				Create New Trainer
			</c:if>			
		</h2>
	</div>
	
	<div align="center">
		<c:if test="${trainer != null}">
			<form action="update_trainer" method="post" id="trainerForm">
			<input type="hidden" name="trainerId" value="${trainer.trainerId}">
		</c:if>
		<c:if test="${trainer == null}">
			<form action="create_trainer" method="post" id="trainerForm">
		</c:if>
		
			<table class="form">
				<tr>
					<td align="right">Category:</td>
					<td>
						<select name="category">
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.categoryId}">
									${category.name}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			
				<tr>
					<td align="right">Brand:</td>
					<td align="left">
						<input type="text" id="brand" name="brand" size="20" value="${trainer.brand}">
					</td>
				</tr>
				<tr>
					<td align="right">Model:</td>
					<td align="left">
						<input type="text" id="model" name="model" size="20" value="${trainer.model}">
					</td>
				</tr>
				<tr>
					<td align="right">Release Date:</td>
					<td align="left">
						<input type="text" id="releaseDate" name="releaseDate" value="${trainer.releaseDate}">
					</td>
				</tr>
				<tr>
					<td align="right">Trainer Image:</td>
					<td align="left">
						<input type="file" id="trainerImage" name="trainerImage" size="20"/><br/>
						<img id="thumbnail" alt="Image Preview" style="width : 20%; margin-top : 10px"/>
					</td>
				</tr>
				<tr>
					<td align="right">Price:</td>
					<td align="left">
						<input type="text" id="price" name="price" size="20" value="${trainer.price}">
					</td>
				</tr>
				<tr>
					<td align="right">Description::</td>
					<td align="left">
						<textarea rows="5" cols="50" name="description" id="description"></textarea>
					</td>
				</tr>
				<tr> 
					<td colspan="2" align="center">
						<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
						<button id="buttonCancel">Cancel</button>
					</td>
				</tr>								
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>

<script type="text/javascript">

		$(document).ready(function () {
		
		$( '#releaseDate' ).datepicker();
		
		$( '#trainerImage' ).change(function () {
			showImageThumbnail(this);
		});
		
		$( '#trainerForm' ).validate({
			
			rules : {
					
				brand : "required",
				model : "required",				
				releaseDate : "required",
				trainerImage : "required",				
				price : "required",
				description : "required"
	
			},
			
			messages : {
	
				brand : "Please enter brand",	
				model : "Please enter model",
				releaseDate : "Please enter release date",
				trainerImage : "Please enter trainer image",
				price : "Please enter price",
				description : "Please enter description"
				
			}
		});
		
		$("button#cancelButton").click(function() {
			window.history.back();	
		});
		
	});
	
	function showImageThumbnail(fileInput) {
		
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
		
		};

</script>


</html>