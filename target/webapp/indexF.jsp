<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>


<html>
<head>
<title>JSTL</title>
</head>
<body>


<c:forEach items="${fruitList}" var="item">
${item[0]}<br/>
</c:forEach>
<c:forEach var="fruitList" items="${fruitList}" >
  ${fruitList.name}
</c:forEach>

<c:forEach items="${disneyCharacters}" var="item">
${item}<br/>
</c:forEach>
</body>
</html>
