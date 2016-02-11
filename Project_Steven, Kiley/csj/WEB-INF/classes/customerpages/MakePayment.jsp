<!DOCTYPE html>
<html>
<body>
<%@ page import = "java.util.Random, accounts.Customer, javax.servlet.http.*, javax.servlet.*, services.*, java.text.DecimalFormat, java.util.HashMap, java.util.Set, java.util.ArrayList, PublicUtils.ServiceType, java.util.Enumeration" %>


    <%  
			Customer c = (Customer)session.getAttribute("Account");
			ArrayList<RecurringService> r = c.getRecur();
			ArrayList<SingleService> s = c.getOneTime();
            Enumeration en = request.getParameterNames();
			DecimalFormat dc = new DecimalFormat("####.00");
			String firstName=null;
			String lastName=null;
			int conf = 0;
			Random rand= new Random();
			boolean ret = false;
            while (en.hasMoreElements()) {
                String parameterName = (String) en.nextElement();
				if(parameterName.equals("initial")){%>
					<form action="MakePayment" method="post">
						<fieldset>
						<legend>Current Bill Due</legend>
						<%
							double subSS = 0;
							double subRS = 0;
							double total = 0;
							String subSingle = "";
							String subRecur = "";
							String niceTotal = "";
							RecurringService tr = null;
							SingleService ts = null;
							for(int i = 0; i < r.size(); i++){
								tr = r.get(i);
								subRS += tr.getPrice();
							}
							
							for(int j = 0; j < s.size(); j++){
								ts = s.get(j);
								subSS += ts.getPrice();
							}
							total = subSS + subRS;
							subSingle = dc.format(subSS);
							subRecur = dc.format(subRS);
							niceTotal = dc.format(total);
						%>
						<p align="left">
						<strong>Subtotal for regular services:</strong>$<%=subRecur%>
						<br>
						<strong>Subtotal for one-time services:</strong>$<%=subSingle%>
						<br><br>
						<strong>Total amount due:</strong>$<%=niceTotal%>
						</p>
						</fieldset>
						<br><br>
						
						<fieldset>
						<legend><strong>Personal information:</strong></legend>
						First Name: <input type="text" name="firstname" required>
						Address: <input type="text" name="street" required><br>
						Last Name:&nbsp; <input type="text" name="lastname" required>
						City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="city" required>&nbsp;&nbsp;State:<input type="text" name ="state"        size = "2" required>   <br>
						Email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" required>
						Zip Code:<input type="text" name="zip" required><br>
						</fieldset>
						<br><br>

						<fieldset>
						<legend><strong>Payment information</strong></legend>
						<input type="radio" name="card" value="masetercard" checked="checked">Mastercard
						<input type="radio" name="card" value="visa">Visa
						<input type="radio" name="card" value="americanexpress">American Express<br>
						Card Number:<input type="number" name="cardnumber" required> <br>
						Exp Date: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="exp" required> 
						<br><br>
						Payment Amount:&nbsp;&nbsp;<input type="number" name="amount" min="0" step="0.01" required>
						</fieldset><br>
						<input type="submit" name="storeit" value="Complete Purchase">
				</form>


				<%
				break;
				}
				else{
					ret = true;
					break;
				}
			}
			if(ret == true){
				firstName = request.getParameter("firstname");
				lastName = request.getParameter("lastname");
				String amount = request.getParameter("amount");
				double amt = Double.parseDouble(amount);
				String name = firstName + " " + lastName;
				conf = rand.nextInt(999999999);
				String prettyPayment = dc.format(amt);
				%>
				<h1>Payment Made!</h1>
				<br>
				
				<strong>Your confirmation number is:</strong>&nbsp;&nbsp;&nbsp; <%=conf%> <br>
				Payment in the amount of $<%=prettyPayment%> was charged to the credit card provided. Please allow up to 48 hours for your account to register payment. 
				
			<% } %> 		 
			 

</body>
</html>