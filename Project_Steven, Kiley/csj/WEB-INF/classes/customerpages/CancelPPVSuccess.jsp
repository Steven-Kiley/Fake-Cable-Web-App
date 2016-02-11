<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1200px;height: 800px; float:left;padding:10px;}


</style></head><body>
<%@ page import = "accounts.Customer, javax.servlet.http.*, javax.servlet.*, PublicUtils.CustomerData, java.util.ArrayList, services.*, java.text.DecimalFormat, java.util.Date" %>

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
<h1><strong>Cancelled PPV Event Order!</strong></h1><hr>

<%
	Customer c = (Customer)session.getAttribute("Account");
	if(c == null){System.out.println("Nothing at c");}
	double total = c.totalDue();
	ArrayList<RecurringService> recur = c.getRecur();
	ArrayList<SingleService> singles = c.getOneTime();
	DecimalFormat dc = new DecimalFormat("####.00");
	double subRecur = 0;
	double subSingle = 0;
	String niceFormat = "";
%>

<h2>Your new service plan.</h2>
<fieldset>
<legend>Regular Services</legend>
<table border="1">
	<tr>
		<th>Service</th> <th>Description</th> <th>Price</th>
	</tr>
	<%
		RecurringService r = null;
		String n1 = "";
		String d1 = "";
		String pr1 = "";
		String sr = "";
		for(int i = 0; i < recur.size(); i++){
			r = recur.get(i);
			n1 = r.getName();
			d1 = r.getDescription();
			pr1 = dc.format(r.getPrice());
			subRecur += r.getPrice();
			sr = dc.format(subRecur);
			%>
			
			<tr>
				<td><%=n1%></td><td><%=d1%></td><td> $ <%=pr1%></td>
			</tr>	
			
		<%	
		}
	%>
	</table>
	<strong>Subtotal: $<%=sr %></strong>
</fieldset>	<br>

<fieldset>
<legend>One Time Services</legend>
<table border="1">
	<tr>
		<th>Service</th> <th>Description</th> <th>Price</th><th>Event Date</th>
	</tr>
	<%
		SingleService s = null;
		String n = "";
		String d = "";
		String pr = "";
		String ss = "";
		Date eventDate = null;
		String eventString = "";
		for(int j = 0; j < singles.size(); j++){
			s = singles.get(j);
			n = s.getName();
			niceFormat = n.replace("_", " ");
			d = s.getDescription();
			pr = dc.format(s.getPrice());
			subSingle += s.getPrice();
			ss = dc.format(subSingle);
			eventDate = s.getEventDate();
			if(eventDate != null){eventString = eventDate.toString();}
			if(eventDate == null){eventString = "N/A";}
			%>
			
			<tr>
				<td><%=niceFormat%></td><td><%=d%></td><td> $ <%=pr%></td><td><%=eventString%></td>
			</tr>	
			
		<%	
		}
	%>
	</table>
	<strong>Subtotal: $<%=ss%>
</fieldset>	<br>
<% String formattedTotal = dc.format(total); %>
<strong>Total Monthly Amount Due: $<%= formattedTotal %></strong>

</div>



</body>
</html>