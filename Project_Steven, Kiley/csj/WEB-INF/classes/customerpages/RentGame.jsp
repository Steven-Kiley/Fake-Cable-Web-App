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
<h1><strong>Game Headquarters:</strong></h1><hr>

<%
	Customer c = (Customer)session.getAttribute("Account");
	ArrayList<SingleService> oneTimes = c.getOneTime();
	DecimalFormat dc = new DecimalFormat("####.00");
	HashMap<String, SingleService> map = Services.getSingles();
	Set keys = map.keySet();
	ArrayList<SingleService> games = new ArrayList<SingleService>();
	SingleService showMe = null;
	Object[] temp = keys.toArray();
	String niceFormat = "";
	String z = "";
		for(int j = 0; j < temp.length; j++){
			z = (String)temp[j];
			showMe = map.get(z);
			if(showMe.getType() == ServiceType.Game){games.add(showMe);}
		}
%>

<h2>Your monthly game rentals.</h2>
<fieldset>
<legend> Current Games</legend>
<table border="1">
<tr>
	<th>Game</th><th>Description</th><th>Cost</th>
</tr>
<%
	SingleService ss = null;
	for(int i =0; i < oneTimes.size(); i++){
		ss = oneTimes.get(i); 
		if(ss.getType() == ServiceType.Game){	
			niceFormat = ss.getName().replace("_", " ");
			String x = dc.format(ss.getPrice());
			%>
			<tr>
				<td><%=niceFormat%>;</td><td><%=ss.getDescription()%> </td><td><%=x%></td>
			</tr>
		
<%	
		}
	} 
%>
		
<br>
</table>
</fieldset>

<fieldset>
<legend>Available Games</legend>
<p align="right">
<form action="AddGameServlet" method="post">
<table border="1">
<tr>
	<th>Title</th><th>Description</th><th>Cost</th><th><input type="radio" name="gamechoice" value="none" checked>None</th>
</tr>
<%
		for(int k = 0; k < games.size(); k++){
			showMe = games.get(k);
			String xx = dc.format(showMe.getPrice());
			niceFormat = showMe.getName().replace("_", " ");
			%>
			
			<tr>
				<td><%=niceFormat%></td><td><%=showMe.getDescription()%></td><td><%=xx%></td><td><input type="radio" name="gamechoice" value=<%=showMe.getName()%>> <%=niceFormat%></td>
			</tr>
			
		<%
		}
		%>
</table>
</p>
</fieldset>

<br>

<input type="submit" value="Add selected Game">
<br><br><br>
</form>
</div>



</body>
</html>