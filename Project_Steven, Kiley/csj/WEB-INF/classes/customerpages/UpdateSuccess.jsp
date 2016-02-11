<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#section {width:1200px;height: 800px; float:left;padding:10px;}


</style></head><body>
<%@ page import = "accounts.Customer, javax.servlet.http.*, javax.servlet.*, PublicUtils.CustomerData" %>

<div id="header"><h1>
Wide Cast
<img src="https://media.licdn.com/media/AAEAAQAAAAAAAANPAAAAJGI4OTBhMmFhLWQ4YzktNDRjNC1hNzliLWI2NjE5YjJiZjI2ZQ.png" alt="Blue Stuff" style="width: 50px;height:50px"></h1></div>


<div id="section"; div align = "left";>
<h1><strong>Update Successful!</strong></h1><hr>

<%
	Customer c = (Customer)session.getAttribute("Account");
	CustomerData d = c.getPersonalInfo();
	String street = d.getStreet();
	String city = d.getCity();
	String state = d.getState();
	int zip = d.getZip();
	int ccn = d.getCreditCardNum();
	String exp = d.getCreditCardExp();
%>

<h2>Your new information.</h2>
<fieldset>
<legend> Updated Information</legend>
<strong>Street:</strong>&nbsp;&nbsp;<%=street%> <br>
<strong>City:</strong>&nbsp;&nbsp;<%=city%>&nbsp;&nbsp;&nbsp;<strong>State:</strong><%=state%> 
<br>
<strong>Zip:</strong>&nbsp;&nbsp;<%=zip%>
<br><br>
<strong>Credit Card Number:</strong>&nbsp;&nbsp; <%=ccn%>
<br>
<strong>Expiration Date:</strong> &nbsp;&nbsp; <%=exp%>

</fieldset>

</div>



</body>
</html>