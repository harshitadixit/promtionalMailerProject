<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>




<html>
<head>
<h3>Scheme-Provided-By-us</h3>
</head>
<body>
<table border="2">
<tr>
			<th>Sid</th>
			<th>Stit</th>
			<th>Sdes</th>
			<th>Slundate</th>
			<th>SEnddate</th>
			<th>Sdis</th>
		</tr>
		<c:forEach items="${scheme}" var="scheme">
			<tr>
				<td>${scheme.sid}</td>
				<td>${scheme.stit}</td>
				 <td>${scheme.sdes}</td>
				 <td>${scheme.slundate}</td>
                <td>${scheme.senddate}</td>
               
                <td>${scheme.sdis}</td>
                
				<c:url var="deleteLink" value="deletescheme">
					<c:param name="sid" value="${scheme.sid}" />
				</c:url>
				<td><a href="${deleteLink}">[X]</a></td>
				<c:url var="changeLink" value="updatescheme">
					<c:param name="sid" value="${scheme.sid}" />
				</c:url>
				
				<td><a href="${changeLink}">change</a></td>
                </c:forEach>
</table>
<a href="adminhome.jsp">Admin-Home</a>
</body>
</html>
