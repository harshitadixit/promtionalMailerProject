<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>





<html>
<head>
<h3>Customer-Provided-By-us</h3>
</head>
<body>
<table border="2">
<tr>
			<th>cid</th>
			<th>cname</th>
			<th>caddress</th>
			<th>cemail</th>
			<th>cmobile</th>
			<th>cpassword</th>
		

			
		</tr>
		<c:forEach items="${customer}" var="customer">
			<tr>
				<td>${customer.cid}</td>
				<td>${customer.cname}</td>
				 <td>${customer.caddress}</td>
				 <td>${customer.cemail}</td>
                <td>${customer.cmobile}</td>
                <td>${customer.cpassword}</td>
                
                <td><a href="messageform?customerid=${customer.cemail }">msg</a></td>
				<c:url var="deleteLink" value="deleteCustomer">
					<c:param name="cid" value="${customer.cid}" />
				</c:url>
				<td><a href="${deleteLink}">[X]</a></td>
				<c:url var="changeLink" value="updatecustomer">
					<c:param name="cid" value="${customer.cid}" />
				</c:url>
				
				<td><a href="${changeLink}">change</a></td>
                </c:forEach>`
</table>
<a href="adminhome.jsp">Admin-Home</a>
</body>
</html>
