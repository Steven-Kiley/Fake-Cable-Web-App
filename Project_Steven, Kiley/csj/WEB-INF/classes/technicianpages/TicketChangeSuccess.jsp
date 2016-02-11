<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1000px;height: 500px; float:left;padding:10px;}


</style></head><body>

<%@page import="accounts.TechnicalSupport, PublicUtils.Ticket, java.util.concurrent.ConcurrentHashMap, java.util.Date, java.util.Iterator, java.util.Set, java.util.ArrayList, java.util.Enumeration"%>

<div id="header"><h1>
Wide Cast
<img src="https://media.licdn.com/media/AAEAAQAAAAAAAANPAAAAJGI4OTBhMmFhLWQ4YzktNDRjNC1hNzliLWI2NjE5YjJiZjI2ZQ.png" alt="Blue Stuff" style="width: 50px;height:50px"></h1></div>

<div id="nav"; div align = "left";><center><strong>Select Which Action to Take</strong></center><hr>

<FORM ACTION="TicketController">
<input type="submit" name="initial" value="Ticket Home"><br>
</form>

</div>

<div id="section"; div align = "center";>
<h1><strong>Ticket Update Successful:</strong></h1><hr><br>

<%	
	TechnicalSupport t = (TechnicalSupport)session.getAttribute("Tech");
	Date start = null;
	ConcurrentHashMap<String, Ticket> tickets = t.getTickets();
	Set keys = tickets.keySet();
	Iterator it = keys.iterator();
	Ticket temp = null;
	%>
	<fieldset>
	<legend><strong>New Ticket Information:</strong></legend>
		<form action="TicketController">
		<table border="1">
		<tr>
			<th>Ticket ID</th><th>Description</th><th>Start Date</th><th>Scheduled Date</th><th>Select</th>	
		</tr>
	
	<%
		while(it.hasNext()){
			temp = tickets.get(it.next());
			start = temp.getStartDate();%>			
			<tr>
				<td><%=temp.getID()%></td><td><%=temp.getDescription()%></td><td><%=start.toString()%></td><td><%=temp.getScheduledDate()%></td><td><input type="radio" name="ticket" value=<%=temp.getID()%>></td>
			</tr>
			
		<%}%>
		</table>
		<br>
		<input type="submit" value="Select">
		</form>
		</fieldset>

	<br><br><br>
</div>

</body>
</html>