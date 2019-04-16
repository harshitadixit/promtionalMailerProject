<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<html>
<head>
<h3>Error-Message</h3>
</head>
<body>
<hr>
<fr:errors path="emp.*"/>
<fr:errors path="customer.*"/>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>