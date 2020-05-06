<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Time until summer</title>
</head>
<body>

<h1>Summer countdown</h1>

<c:if test="${ !duration.isNegative() }">
	<p>
	    ${ days } days, ${ hours } hours, ${ minutes } minutes, 
	    ${ seconds } seconds until summer
	</p>
</c:if>

<c:if test="${ duration.isNegative() }">
	<p>
	    Summer is here!
	</p>
</c:if>

</body>
</html>