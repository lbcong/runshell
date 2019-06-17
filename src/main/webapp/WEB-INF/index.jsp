<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head></head>
<body>
    <s:url value="addcount" var="addcount"/>
<form action="${addcount}" method="get">
<input style="width:100%;height:100%" type="submit" value="submit"/>
</form>

</body>


</html>

