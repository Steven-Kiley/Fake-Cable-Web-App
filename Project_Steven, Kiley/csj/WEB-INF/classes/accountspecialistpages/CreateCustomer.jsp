<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html><head><style>

#header {background-color:lightblue; color:black;text-align:center;padding:5px;}

#nav {line-height:30px;background-color:lightblue;height:500px;width:120px;float:left;padding:5px;border-type:solid;border-color:black;}

#section {width:1000px; height:1200px; float:left;padding:10px;}


</style></head><body>

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

<div id="section"; div align = "center";>
<h1><strong>Welcome to the User Account Creation Menu:</strong></h1><hr><h2>Please fill out all information before continuing.<h2><br>

<form action="CreateUserServlet" method="post">

<fieldset>
<legend><strong>Login information:</strong></legend>
Enter login information to be used by new customer: <br>
Username:<input type="text" name="username" required><br>
Password:&nbsp;<input type="password" name="password" required><br> 

</fieldset>
<br><br>

<fieldset>
<legend><strong>Personal information:</strong></legend>
<p align = "left">
First Name: <input type="text" name="firstname" required>
Address: <input type="text" name="street" required><br>
Last Name:&nbsp; <input type="text" name="lastname" required>
City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="city" required>&nbsp;&nbsp;State:<input type="text" name ="state" size = "2" required>   <br>
Email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" required>
Zip Code:<input type="text" name="zip" required><br><br>
Credit Card Number:<input type="number" name="ccn" required> <br>
Expiration Date:&nbsp;&nbsp;&nbsp; <input type="date" name="exp" value="mm/dd/yyyy" required><br>

</p>
</fieldset>
<br><br>

<fieldset>
<legend><strong>Service Choices</strong></legend>

Cable Services:<br>
<input type = "radio" name="cablechoice" value="none">None
<input type = "radio" name="cablechoice" value="Basic-Package" checked>Basic Package
<input type = "radio" name="cablechoice" value="Basic-Plus-Package">Basic Package Plus
<input type = "radio" name="cablechoice" value="Ultimate-Package">Ultimate Package
<br><br>
Internet services:<br>
<input type = "radio" name="cablechoice" value="none">None
<input type = "radio" name="internetchoice" value="Speedlane-Internet" checked>Speedlane Internet
<input type = "radio" name="internetchoice" value="Lightlane-Internet">Lightlane Internet

</fieldset>
<br>

<input type="submit" value="Submit Informatiion">
</form>
</div>
</body>
</html>