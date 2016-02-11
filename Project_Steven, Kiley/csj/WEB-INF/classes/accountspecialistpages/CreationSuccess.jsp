<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#section {width:1200px;height: 800px; float:left;padding:10px;}


</style></head><body>
<%@ page import = "java.text.DecimalFormat, accounts.Customer, javax.servlet.http.*, javax.servlet.*, PublicUtils.CustomerData, java.util.ArrayList, services.*;" %>

<div id="header"><h1>
Wide Cast
<img src="https://media.licdn.com/media/AAEAAQAAAAAAAANPAAAAJGI4OTBhMmFhLWQ4YzktNDRjNC1hNzliLWI2NjE5YjJiZjI2ZQ.png" alt="Blue Stuff" style="width: 50px;height:50px"></h1></div>


<div id="section"; div align = "left";>
<h1><strong>Creation Successful!</strong></h1><hr>

<%
	Customer c = (Customer)session.getAttribute("Account");
	String username = c.getUsername();
	String password = c.getPassword();
	ArrayList<RecurringService> recurs = c.getRecur();
	ArrayList<SingleService> singles = c.getOneTime();
	CustomerData d = c.getPersonalInfo();
	String street = d.getStreet();
	String city = d.getCity();
	String state = d.getState();
	int zip = d.getZip();
	int ccn = d.getCreditCardNum();
	String exp = d.getCreditCardExp();
	RecurringService rs = null;
	SingleService ss = null;
	DecimalFormat dc = new DecimalFormat("####.00");
	String niceFormat = "";
%>

<h2>New customer information.</h2>

<fieldset>
<legend><strong>Login information</strong></legend>
<strong>Username:</strong>&nbsp;&nbsp;<%=username%> <br>
<strong>Password:</strong>&nbsp;&nbsp;&nbsp;<%=password%>
</fieldset>

<fieldset>
<legend><strong>Current services</strong></legend>
Regular services: <br>
<table border="1">
<tr>
	<th>Service</th><th>Description</th><th>Cost</th>
</tr>
<%
	String name = "";
	String description = "";
	double cost = 0;
	for(int i =0; i < recurs.size(); i++){
		rs = recurs.get(i);
		name = rs.getName();
		description = rs.getDescription();
		cost = rs.getPrice();
		niceFormat = dc.format(cost);
		%>
		<tr>
			<td><%=name%></td><td><%=description%></td><td>$<%=niceFormat%></td>
		</tr>
		
	<%}%>
	</table>
	<br>
	
	One time services:<br>
	<%
	for(int j = 0; j < singles.size(); j++){
		ss = singles.get(j);
		name = ss.getName().replace("_", " ");
		description = ss.getDescription();
		cost = ss.getPrice();
		niceFormat = dc.format(cost);%>
		<tr>
			<td><%=name%></td><td><%=description%></td><td><%=niceFormat%></td>
		</tr>
		
	<%}%>
	</table>
</fieldset>

<fieldset>
<legend><strong>Personal Information</strong></legend>
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