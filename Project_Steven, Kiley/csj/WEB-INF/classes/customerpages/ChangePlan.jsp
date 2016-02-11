<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1200px;height: 800px; float:left;padding:10px;}


</style></head><body>
<%@ page import = "accounts.Customer, javax.servlet.http.*, javax.servlet.*, services.*, java.text.DecimalFormat, java.util.HashMap, java.util.Set, java.util.ArrayList, PublicUtils.ServiceType" %>

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
<h1><strong>Change your Regular Services:</strong></h1><hr>

<%
	Customer c = (Customer)session.getAttribute("Account");
	ArrayList<RecurringService> services = c.getRecur();
	DecimalFormat dc = new DecimalFormat("####.00");
	HashMap<String, RecurringService> map = Services.getRecurs();
	Set keys = map.keySet();
	ArrayList<RecurringService> tv = new ArrayList<RecurringService>();
	ArrayList<RecurringService> internet = new ArrayList<RecurringService>();
	RecurringService showMe = null;
	Object[] temp = keys.toArray();
	String z = "";
		for(int j = 0; j < temp.length; j++){
			z = (String)temp[j];
			showMe = map.get(z);
			if(showMe.getType() == ServiceType.Cable){tv.add(showMe);}
			if(showMe.getType() == ServiceType.Internet){internet.add(showMe);}
		}
%>

<h2>Your current Services.</h2>
<fieldset>
<legend> Current Plan Information</legend>
<table border="1">
<tr>
	<th>Service</th><th>Description</th><th>Cost</th>
</tr>
<%
	RecurringService rs = null;
	for(int i =0; i < services.size(); i++){
		rs = services.get(i); 
		String x = dc.format(rs.getPrice());%>
		<tr>
			<td><%=rs.getName()%>;</td><td><%=rs.getDescription()%> </td><td><%=x%></td>
		</tr>
		
<%
	} 
%>
		
<br>
</table>
</fieldset>

<fieldset>
<legend>Cable Plans</legend>
<p align="right">
<form action="ChangeServiceServlet" method="post">
<table border="1">
<tr>
	<th>Service</th><th>Description</th><th>Cost</th><th><input type="radio" name="tvchoice" value="none" checked>None</th>
</tr>
<%
		for(int k = 0; k < tv.size(); k++){
			showMe = tv.get(k);
			String xx = dc.format(showMe.getPrice());
			%>
			
			<tr>
				<td><%=showMe.getName()%></td><td><%=showMe.getDescription()%></td><td><%=xx%></td><td><input type="radio" name="tvchoice" value=<%=showMe.getName()%> ><%=showMe.getName()%></td>
			</tr>
			
		<%
		}
		%>
</table>
</p>
</fieldset>

<br>

<fieldset>
<legend>Internet Plans</legend>
<p align="left">
<table border="1">
<tr>
	<th>Service</th><th>Description</th><th>Cost</th><th><input type="radio" name="internetchoice" value="none" checked>None</th>
</tr>
<%
		for(int l = 0; l < internet.size(); l++){
			showMe = internet.get(l);
			String zz = dc.format(showMe.getPrice());
			%>
			
			<tr>
				<td><%=showMe.getName()%></td><td><%=showMe.getDescription()%></td><td><%=zz%></td><td><input type="radio" name="internetchoice" value=<%=showMe.getName()%> ><%=showMe.getName()%></td>
			</tr>
			
		<%
		}
		%>

</table>		
</p>
</fieldset>

<br>

<input type="submit" value="Change to Selected Plans">

</form>
</div>



</body>
</html>