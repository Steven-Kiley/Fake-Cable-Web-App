<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1000px;height: 500px; float:left;padding:10px;}


</style></head><body>

<%@page import="java.util.Enumeration, PublicUtils.TicketMaker"%>

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
<div id="section"; div align = "center";>
<h1><strong>Ticket Creation Console:</strong></h1><hr><br>
<%
	Enumeration en = request.getParameterNames();
	String name = "";
	while (en.hasMoreElements()) {
        name = (String)en.nextElement();
	}
	if(name != null && name.equals("initial")){%>
		<fieldset>
		<legend><strong>Customer Issue</strong></legend>
		<form action="CreateTicket">
		<br>
		<p align="left">
		Description: <input type="text" name="description">
		<br><br>
		<input type="submit" value="Submit Ticket">
		</form>
		</p>
		<br>
		</fieldset>
	
	<%}%>
<%	
	if(name!= null && name.equals("description")){
		String desc = request.getParameter("description");
		String result = TicketMaker.createTicket(desc);
		String[] useMe = result.split("-");%>
		<fieldset>
		<legend><strong>Ticket Creation Successful:</strong></legend>
		<br>
		<strong>Ticket ID Number:</strong><%=useMe[0]%> 
		<br><br>
		<strong>Ticket Assigned To:</strong><%=useMe[1]%>
		<br>
		</fieldset>
	<%}%>
	
</div>
</body>
</html>