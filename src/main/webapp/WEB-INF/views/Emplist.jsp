<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>




<html>
<head>
<h3>Emp-Entery-List</h3>
</head>
<body>
<table border="2">
<tr>
			<th>Eid</th>
			<th>Ename</th>
			<th>Emobile</th>
			<th>Email</th>
			<th>Eaddress</th>
			<th>Esal</th> 
			<th>Escheme</th>
			                                
		</tr>
		<c:forEach items="${emp}" var="emp">
			<tr>
				<td>${emp.eid}</td>
				<td>${emp.ename}</td>
				 <td>${emp.emobile}</td>
				 <td>${emp.email}</td>
				 <th>${emp.eaddress}</th>
                <td>${emp.esal}</td>
                <th>${emp.escheme}</th>
               
           
                
				<c:url var="deleteLink" value="deleteemp">
					<c:param name="eid" value="${emp.eid}" />
				</c:url>
				<td><a href="${deleteLink}">[X]</a></td>
				<c:url var="changeLink" value="updateemp">
					<c:param name="eid" value="${emp.eid}" />
				</c:url>
				
				<td><a href="${changeLink}">change</a></td>
				 
                </c:forEach>
               
</table>
<a href="index.jsp">Admin-Home</a>

</body>
</html>
