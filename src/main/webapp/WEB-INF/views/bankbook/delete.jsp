<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Delete</h2>
	<form action="./delete.gm" method="get">
		<input type="hidden" name="bookNum" value="${dto.bookNum}"> 
		
		<%--<input type="hidden" name="bookname" value="${dto.bookname}">
		<input type="hidden" name="bookrate" value="${dto.bookrate}">  --%>
	</form>
</body>
</html>