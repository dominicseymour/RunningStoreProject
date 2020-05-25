<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<div align="center">
	<div>
		<img src="images/logo.png"/>
	</div>
	
	<div>
		<input type="text" name="keyword" size="30"/>
		<input type="button" value="search"/>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="login">Sign in</a> |
		<a href="register">Register</a> |
		<a href="view_cart">Cart</a>
		<br/><br/>
	</div>
		<c:forEach var="category" items="${categoryList}" varStatus="status">
			<a href="view_category?id=${category.categoryId}">
				<font size="+1">
					<b><c:out value="${category.name}"/></b>
				</font>	
			</a>
			<c:if test="${not status.last}">			
				&nbsp; | &nbsp;
			</c:if>	
		</c:forEach>
	<div>
		
	</div>
</div>