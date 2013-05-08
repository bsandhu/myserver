<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP in action</title>
</head>
<body>
	Foo: <c:out value="${foo}" />
	<br/>
	Host: <c:out value="${header[\"host\"]}" />
	<br/>
	<%=System.currentTimeMillis()%>
</body>
</html>