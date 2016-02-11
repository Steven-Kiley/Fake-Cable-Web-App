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
<h1><strong>Ticket Controller:</strong></h1><hr><br>

<%	
	Enumeration en = request.getParameterNames();
	String name = "";
	while (en.hasMoreElements()) {
        name = (String)en.nextElement();
	}
	TechnicalSupport t = (TechnicalSupport)session.getAttribute("Tech");
	Date start = null;
	ConcurrentHashMap<String, Ticket> tickets = t.getTickets();
	Set keys = tickets.keySet();
	Iterator it = keys.iterator();
	Ticket temp = null;
	if(name!= null && name.equals("initial")){%>
	<fieldset>
	<legend><strong>Select a ticket</strong></legend>
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
	<%}
	if(name == null || !(name.equals("initial"))){
		String ID = request.getParameter("ticket");
		System.out.println(ID);
		temp = tickets.get(ID);
		start = temp.getStartDate();
		ArrayList<String> log = temp.getTicketLog();
	%>
	
	<fieldset>
	<legend><strong>Ticket Information</strong></legend>
	<table border="1">
		Ticket Data:<br>
		<tr>
			<th>Ticket ID</th><th>Description</th><th>Start Date</th><th>Scheduled Date</th>
		</tr>
		<tr>
			<td><%=temp.getID()%></td><td><%=temp.getDescription()%></td><td><%=start.toString()%></td><td><%=temp.getScheduledDate()%></td>
		</tr>
		</table>
		<br><br>
		<p align = "left">
		<strong>Ticket Log:</strong><br>
		<%
			int num = 0;
			String message = "";
			for(int i = 0; i < log.size(); i++){
				message = log.get(i);
				num = i + 1;
				%>
				
				<strong>Log Entry # <%=num%>:</strong><%=message%><br>
				
			<%}%>
			</p>
			
	</fieldset><br><br>
	
	<fieldset>
	<legend><strong>Schedule Ticket</strong></legend>
	<form action="TicketControllerServlet"><br>
	<strong>Set Date for Onsite Work:</strong><input type="date" name="scheduledate" value="mm/dd/yyyy">
	<br><br>
	<input type="submit" name="schedule" value="Schedule">
	<input type="hidden" name="ticketID" value=<%=temp.getID()%>>
	</form>
	</fieldset>
		
	<fieldset>
	<legend><strong>Update Ticket</strong></legend>
	<form action="TicketControllerServlet"><br>
	<strong>Update text:</strong><input type="text" name="updatetext">
	<br><br>
	<input type="submit" name="update" value="Update">
	<input type="hidden" name="ticketID" value=<%=temp.getID()%>>
	</form>
	</fieldset>	
		
	<fieldset>
	<legend><strong>Close Ticket</strong></legend>
	<form action="TicketControllerServlet"><br>
	<strong>Final Remark:</strong><input type="text" name="finalremark">
	<br><br>
	<input type="submit" name="close" value="Close">
	<input type="hidden" name="ticketID" value=<%=temp.getID()%>>
	</form>
	</fieldset>

	<fieldset>
	<legend><strong>Cancel Ticket</strong></legend>
	<form action="TicketControllerServlet"><br>
	<strong>This will delete the ticket from the ticket queue! Are you sure you'd like to do this?</strong>
	<br><br>
	<input type="submit" name="cancel" value="Yes, I'm sure!">
	<input type="hidden" name="ticketID" value=<%=temp.getID()%>>
	</form>
	</fieldset>
	<%}%>
	<br><br><br>
</div>

</body>
</html>