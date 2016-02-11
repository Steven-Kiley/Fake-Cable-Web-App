<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1000px;height: 500px; float:left;padding:10px;}


</style></head><body>

<%@page import="services.*, PublicUtils.ServiceType, accounts.Customer, java.util.ArrayList, java.text.DecimalFormat"%>

<div id="header"><h1>
Wide Cast
<img src="https://media.licdn.com/media/AAEAAQAAAAAAAANPAAAAJGI4OTBhMmFhLWQ4YzktNDRjNC1hNzliLWI2NjE5YjJiZjI2ZQ.png" alt="Blue Stuff" style="width: 50px;height:50px"></h1></div>

<div id="nav"; div align = "left";><center><strong>Select Which Action to Take</strong></center><hr>

<FORM ACTION="ManagerServlet">
<input type="submit" name="update" value="Update Order"><br>
</form>

<FORM ACTION="ManagerServlet">
<input type="submit" name="delete" value="Delete Order"><br>
</form>

<FORM ACTION="ManagerServlet">
<input type="submit" name ="cancel" value="Cancel Order"><br>
</form>

</div>

<%
	Customer c = (Customer)session.getAttribute("Account");
	ArrayList<RecurringService> recurs = c.getRecur();
	ArrayList<SingleService> singles = c.getOneTime();
	SingleService ss = null;
	RecurringService rs = null;
	DecimalFormat dc = new DecimalFormat("$####.00");
	String niceFormat = "";
	double cost = 0;
	String choice = (String)session.getAttribute("choice");
	String putMe = choice + "-" + "selected";
%>

<div id="section"; div align = "center";>
<h1><strong>Manager order <%=choice%> page:</strong></h1><hr><h2>Please select the customer order to <%=choice%>.<h2><br>

<form action="ManagerProcessingServlet">

<fieldset>
<legend><strong>Customer orders</strong></legend>

<br>
<%if(choice.equals("delete") || choice.equals("update")){%>

<strong>Regular services:</strong><br>
<table border="1">
<tr>
	<th>Service</th><th>Description</th><th>Cost</th><th>Choice</th>
</tr>

<%
	for(int i =0; i < recurs.size(); i++){
		rs = recurs.get(i);
		cost = rs.getPrice();%>
		
		<tr>
			<td><%=rs.getName()%></td><td><%=rs.getDescription()%></td><td><%=dc.format(cost)%></td><td><input type="radio" name="service" value=<%=rs.getName()%>><%=rs.getName()%></td>
		</tr>
	
	<%}%>
	</table>
<%}%>
	

	<br>
<%if(choice.equals("delete") || choice.equals("cancel")){%>	
	<strong>One time services:</strong><br>
	<table border="1">
<tr>
	<th>Service</th><th>Description</th><th>Cost</th><th>Choice</th>
</tr>

<%
	for(int i =0; i < singles.size(); i++){
		ss = singles.get(i);
		cost = ss.getPrice();
		niceFormat = ss.getName().replace("_", " ");%>
		
		<tr>
			<td><%=niceFormat%></td><td><%=ss.getDescription()%></td><td><%=dc.format(cost)%></td><td><input type="radio" name="service" value=<%=ss.getName()%>><%=niceFormat%></td>
		</tr>
	
	<%}%>
</table>
<%}%>
	
	
	<br>

</fieldset>
<br><br>
<input type="submit" value=<%=putMe%>>

</form>
</div>
</body>
</html>