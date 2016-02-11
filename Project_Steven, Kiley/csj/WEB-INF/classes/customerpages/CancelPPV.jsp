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

<FORM ACTION="UpdateRecord">
<input type="submit" value="Update Record"><br>
</form>

<FORM ACTION="MakePayment">
<input type="submit" name="initial" value="Make Payment"<br>
</form>

<FORM ACTION="RentGame">
<input type="submit" value="Rent Game"><br>
</form>

<FORM ACTION="OrderPPV">
<input type="submit" value="PPV Events"><br>
</form>

<FORM ACTION="CancelPPV">
<input type="submit" value="Cancel PPV"><br>
</form>

<FORM ACTION="ChangePlan">
<input type="submit" value="Change Plan"><br>
</form>

</div>

<div id="section"; div align = "left";>
<h1><strong>Cancel PPV Event:</strong></h1><hr>

<%
	Customer c = (Customer)session.getAttribute("Account");
	if(c == null){System.out.println("null customer account in CancelPPV");}
	System.out.println(c.getUsername());
	ArrayList<SingleService> oneTimes = c.getOneTime();
	DecimalFormat dc = new DecimalFormat("####.00");
	Date eventDate = null;
	String eventString = "";
	String niceFormat = "";
%>

<h2>Your current PPV Events.</h2>
<fieldset>
<legend> Current Events</legend>
<table border="1">
<form action="CancelPPVServlet" method="post">
<tr>
	<th>Event</th><th>Description</th><th>Cost</th><th>Event Date</th><th><input type="radio" name="eventchoice" value="none" checked>None</th> 
</tr>
<%
	SingleService ss = null;
	for(int i =0; i < oneTimes.size(); i++){
		ss = oneTimes.get(i); 
		if(ss.getType() == ServiceType.PPVSport){	
			niceFormat = ss.getName().replace("_", " ");
			String x = dc.format(ss.getPrice());
			eventDate = ss.getEventDate();
			if(eventDate == null){eventString = "N/A";}
			if(eventDate != null){eventString = eventDate.toString();}
			%>
			<tr>
				<td><%=niceFormat%>;</td><td><%=ss.getDescription()%> </td><td><%=x%></td><td><%=eventString%></td><td><input type="radio" name="eventchoice" value= <%=ss.getName()%>> <%=niceFormat%></td>
			</tr>
		
<%	
		}
	} 
%>
		
<br>
</table>
</fieldset>

<br>
<input type="submit" value="Remove selected PPV">
<br><br><br>
</form>
</div>



</body>
</html>