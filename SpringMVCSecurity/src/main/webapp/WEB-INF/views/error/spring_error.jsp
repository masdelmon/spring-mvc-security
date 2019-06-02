
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<body>

	<c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
	
</body>
</html>