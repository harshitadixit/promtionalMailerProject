<%@page isELIgnored="false" %>
<html>
<%
  String s=request.getParameter("empid");
%>
<body>
<h4>Sending Message to <%=s%></h4>
<h3>Message form</h3>
<form action="savemessage">
<pre>
  To:      <input type="text" name="messageto" value="<%=s%>"/>
  Form:    <input type="text" name="messageForm" value="${empid}"/>
  Message: <input type="text" name="message"/>
           <input type="submit" value="Message"/>

</pre>
</form>
</body>
</html>