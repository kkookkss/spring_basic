<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>t=utf-8" %>
<html>
<head>
	<title>YoilTellerMVC</title>
</head>
<body>
<h1>year=<%=request.getParameter("year") %></h1>
<h1>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일입니다.</h1>
</body>
</html>