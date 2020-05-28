<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internal Server Error</title>
</head>
<body>
		<div align="center">
		<div>
			<img src="${pageContext.request.contextPath}/images/logo.png"/>	
		</div>

		<div>
			<h2>The server encountered an error while trying to fulfil your request.</h2>
			<h3>Please contact an administrator or try again later.</h3>
		</div>
	
		<div>
			<a href="javascript:history.go(-1);">Go Back</a>
		</div>
	</div>
</body>
</html>