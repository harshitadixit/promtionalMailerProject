<%@page isELIgnored="false" %>
<html>
<head>
<%
	String s[]=session.getValueNames();
	for(String str:s){
		out.println(str);
	}
%>
</head>
<body>
<h3>Welcome to EmpDasboard</h3>
<pre>
<a href="newschemes">Add-New-scheme</a>
<a href="viewallscheme">View-All-scheme</a>
<a href="sendschemedislist">Send-schemedis-list</a>
<a href="newcustomer">Add-new-Customer</a>
<a href="viewallcustomer">View-All-Customer</a>

<a href="Inbox">Customer-Inbox</a>

<a href="logout">Logout</a>


</pre>
</body>
</html>
