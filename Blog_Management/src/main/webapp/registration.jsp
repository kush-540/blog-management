<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Blog</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- owl stylesheets --> 
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesoeet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
  <style>
body{background-image:url("images/register.jpg" );
background-size:100% 70%;
background-repeat:no-repeat;
 }
 
</style>
  
   </head>
   <%@include file="header.jsp" %>
   <br>
   <br>
   <center>
   <h1><b>Registration Page</b></h1>


<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.print(msg);
}
%>
<form action="registrationservlet">
<table>
<tr>
       <td> <label for="firstname"><b>First Name</b></label></td>
       <td> <input type="text" name="t1" ><br><br></td>
    </tr>
       
    <tr>
        
        <td><label for="last name"><b>Last Name</b></label></td>
       <td> <input type="text" name="t2"><br><br></td>
    </tr>

    <tr>
    <td><label for="contact"><b>Contact</b></label></td>
<td>  <input type="text" name="t3" ><br><br></td>
    </tr>
<tr>
<td> <label for="Address"><b>Address</b></label></td>
<td>  <input type="text" name="t4"><br><br></td>
    </tr>

<tr>
<td><label for="age"><b>Age</b></label></td>
<td>  <input type="text" name="t5"><br><br></td>
    </tr>
        
<tr>
    <td> <label for="E-mail"><b>E-mail</b></label></td>
<td> <input type="text" name="t6"><br><br></td>
    </tr>
    <tr>
    <td> <label for="password"><b>password</b></label></td>
<td> <input type="Password" name="t7" ><br><br></td>
    </tr>




</table>
<input type="submit" value="Register Here">
<a href="login.jsp"><b>Back To Login</b></a>

</form>
</center>
<br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
