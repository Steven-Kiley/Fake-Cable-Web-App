<!DOCTYPE html>
<html>
<body>


<h1>Manager console:<h1><hr>

<br>

<h3>Please enter the username for the account you would like to access.<h3>
<p>
<%
	String button = (String)session.getAttribute("choice");
	%>
	
	</p>
<br><br>
<fieldset align="left">
<legend><strong>Get account information for:</strong></legend>
<form action="ManagerServlet" method="post">
<br>
Username:
<input type="text" name="username">
<br><br>
<input type="submit" value="Submit">
<input type="hidden" name="choice" value=<%=button%>>
<br>
</form>
</fieldset>


</body>
</html>
