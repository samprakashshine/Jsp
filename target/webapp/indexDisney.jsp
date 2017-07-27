<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>


<html>
<head>
<title>JSTL</title>
</head>
<body>


<c:forEach items="${disneyCharacters}" var="item">
${item}<br/>
</c:forEach>


</body>
</html>