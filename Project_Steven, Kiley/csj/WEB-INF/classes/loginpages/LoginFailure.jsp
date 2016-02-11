<!DOCTYPE html>
<html>
<body>

<div align="center">
<h1><font color="red"><strong>Invalid username or password!</strong></h1>
<hr><img src="http://images.askmen.com/entertainment/guy_gear_150/157_cable-television-service-no-more-guy-gear-flash.jpg" alt="Cable" style="width:250px;height:200px;"><br>
<h3>Please choose your login type and enter your username and passoword:</h3>
<br>
<fieldset>
<legend align="center">Login Information</legend>
<form action="LoginServlet" method="post">
Username:<input type="text" name="username"><br>
Password:<input type="password" name="password"><br>
Login Type:<br>
<input type="radio" name="ltype" value="Customer" checked>Customer
<input type="radio" name="ltype" value="AccountSpecialist">Account Specialist
<input type="radio" name="ltype" value="Manager">Manager
<input type="radio" name="ltype" value="Technician">Technician

<br><br>
<input type="submit" value="Submit">
</form>
</fieldset>
</div>
</body>
</html>
