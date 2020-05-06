<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
    <h1>All artists</h1>

    <ol>
        <c:forEach items="${ artists }" var="artist">
            <li>
               <c:out value="${ artist.getName() }" />
            </li>
        </c:forEach>
    </ol>
</body>
</html>