<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>

<html>
<head>

</head>
<body>
<h3>Scheme-update-form</h3>
<pre>
<fr:form action="savechanges" modelAttribute="scheme">
Sid      <fr:input path="sid"/>
Stit     <fr:input path="stit"/>
Sdis     <fr:input path="sdis"/>
Sluncdate<fr:input path="slundate"/>
Snenddate<fr:input path="senddate"/>
Sdis     <fr:input path="sdis"/>
<input type="submit" value="save"/>
</pre>
</fr:form>
</body>
</html>
