<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1200px;height: 800px; float:left;padding:10px;}


</style></head><body>
<%@ page import = "accounts.Customer, javax.servlet.http.*, javax.servlet.*, services.*, java.text.DecimalFormat, java.util.HashMap, java.util.Set, java.util.ArrayList, PublicUtils.ServiceType, java.util.Date" %>

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
<h1><strong>Order Pay per View Items:</strong></h1><hr>

<%
	Date eventDate = null;
	String eventString = "";
	Customer c = (Customer)session.getAttribute("Account");
	ArrayList<SingleService> oneTimes = c.getOneTime();
	DecimalFormat dc = new DecimalFormat("####.00");
	HashMap<String, SingleService> map = Services.getSingles();
	Set keys = map.keySet();
	ArrayList<SingleService> movies = new ArrayList<SingleService>();
	ArrayList<SingleService> sports = new ArrayList<SingleService>();
	SingleService showMe = null;
	Object[] temp = keys.toArray();
	String niceFormat = "";
	String z = "";
		for(int j = 0; j < temp.length; j++){
			z = (String)temp[j];
			showMe = map.get(z);
			if(showMe.getType() == ServiceType.PPVMovie){movies.add(showMe);}
			if(showMe.getType() == ServiceType.PPVSport){sports.add(showMe);}
		}
%>

<h2>Customer's current one time orders.</h2>
<fieldset>
<legend> Current PPV Events and Games</legend>
<table border="1">
<tr>
	<th>Event</th><th>Description</th><th>Cost</th><th>Event Date</th>
</tr>
<%
	SingleService ss = null;
	for(int i =0; i < oneTimes.size(); i++){
		ss = oneTimes.get(i); 
		niceFormat = ss.getName().replace("_", " ");
		String x = dc.format(ss.getPrice());
		eventDate = ss.getEventDate();
		if(eventDate != null){eventString = eventDate.toString();}
		if(eventDate == null){eventString = "N/A";}
		%>
		<tr>
			<td><%=niceFormat%>;</td><td><%=ss.getDescription()%> </td><td><%=x%></td><td><%=eventString%></td>
		</tr>
		
<%
	} 
%>
		
<br>
</table>
</fieldset>

<fieldset>
<legend>PPV Movies</legend>
<p align="right">
<form action="AddPPVServlet" method="post">
<table border="1">
<tr>
	<th>Title</th><th>Description</th><th>Cost</th><th>Event Date</th><th><input type="radio" name="moviechoice" value="none" checked>None</th>
</tr>
<%
		String noDate = "N/A";
		for(int k = 0; k < movies.size(); k++){
			showMe = movies.get(k);
			String xx = dc.format(showMe.getPrice());
			niceFormat = showMe.getName().replace("_", " ");
			%>
			
			<tr>
				<td><%=niceFormat%></td><td><%=showMe.getDescription()%></td><td><%=xx%></td><td><%=noDate%></td><td><input type="radio" name="moviechoice" value=<%=showMe.getName()%> ><%=niceFormat%></td>
			</tr>
			
		<%
		}
		%>
</table>
</p>
</fieldset>

<br>

<fieldset>
<legend>PPV Sports</legend>
<p align="left">
<table border="1">
<tr>
	<th>Event</th><th>Description</th><th>Cost</th><th>Event Date</th><th><input type="radio" name="sportschoice" value="none" checked>None</th>
</tr>
<%
		for(int l = 0; l < sports.size(); l++){
			showMe = sports.get(l);
			String zz = dc.format(showMe.getPrice());
			niceFormat = showMe.getName().replace("_", " ");
			eventDate = showMe.getEventDate();
			if(eventDate != null){eventString = eventDate.toString();}
			if(eventDate == null){eventString = "N/A";}
			%>
			
			<tr>
				<td><%=niceFormat%></td><td><%=showMe.getDescription()%></td><td><%=zz%></td><td><%=eventString%></td><td><input type="radio" name="sportschoice" value=<%=showMe.getName()%> ><%=niceFormat%></td>
			</tr>
			
		<%
		}
		%>

</table>		
</p>
</fieldset>

<br>

<input type="submit" value="Add selected PPV Items">
<br><br><br>
</form>
</div>



</body>
</html>