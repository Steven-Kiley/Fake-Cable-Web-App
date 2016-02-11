<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1200px;height: 800px; float:left;padding:10px;}


</style></head><body>
<%@ page import = "accounts.Customer, javax.servlet.http.*, javax.servlet.*, PublicUtils.CustomerData" %>

<div id="header"><h1>
Wide Cast
<img src="https://media.licdn.com/media/AAEAAQAAAAAAAANPAAAAJGI4OTBhMmFhLWQ4YzktNDRjNC1hNzliLWI2NjE5YjJiZjI2ZQ.png" alt="Blue Stuff" style="width: 50px;height:50px"></h1></div>

<div id="nav"; div align = "left";><center><strong>Select Which Action to Take</strong></center><hr>

<FORM ACTION="UpdateCustomer">
<input type="submit" value="Update Record"><br>
</form>

<FORM ACTION="CreateCustomer">
<input type="submit" value="Create Account"<br>
</form>

<FORM ACTION="CreateTicket">
<input type="submit" name="initial" value="Create Ticket"><br>
</form>

<FORM ACTION="SpecialistOrderPPV">
<input type="submit" name="AccountSpecialist" value="Order PPV"><br>
</form>


</div>

<div id="section"; div align = "left";>
<h1><strong>Update Customer Information:</strong></h1><hr>

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

<h2>Current customer data.</h2>
<fieldset>
<legend> Current Information</legend>
<strong>Street:</strong>&nbsp;&nbsp;<%=street%> <br>
<strong>City:</strong>&nbsp;&nbsp;<%=city%>&nbsp;&nbsp;&nbsp;<strong>State:</strong><%=state%> 
<br>
<strong>Zip:</strong>&nbsp;&nbsp;<%=zip%>
<br><br>
<strong>Credit Card Number:</strong>&nbsp;&nbsp; <%=ccn%>
<br>
<strong>Expiration Date:</strong> &nbsp;&nbsp; <%=exp%>
</fieldset>
<br><br>
<h2>Please fill out all fields.<h2><br>

<fieldset>
<legend>New Information</legend>
<p align="right">
<form action="UpdateServlet" method="post">
<input type="text" name="street" required>Street<br>
<input type="text" name="city" required>City
<input type="text" name="state" style="width: 30px; maxlength="2" required>State <br>
<input type="number" name="zip" min="11111" max="99999" required>Zip

<br><br>

<input type ="number" name="ccn" max="99999999" required>Credit Card Number <br>
<input type ="text" name="exp" value="mm/dd/yyyy" required>Expiration Date
<br><br>
<input type="submit" value="Submit">
</form>
</p>
</fieldset>


</div>



</body>
</html>