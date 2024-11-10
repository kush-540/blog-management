<!DOCTYPE html>
<%@page import="com.dto.UserInfo"%>
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
   <body>
      <!-- header section start -->
      <%@include file= "header.jsp"%>
  <table>
 
<tr>
<td><a href="UpdateServlet"><h2>Update profile</h2></a></td>
</tr>
<tr>
<td><a href="PostBlog.jsp"><h2>Post Blog</h2></a></td>
</tr>
<tr>
<td> <a href="ShowServlet"><h2>Show Blog</h2></a></td>
</tr>
<tr>
<td><a href="logout.jsp"><h2>Log out</h2></a></td>
</tr>
</table>
    <center>  <h1><b>Update Profile</b></h1></center>
      <%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.print(msg);
}
%>
<form action="SaveServlet">
<center>
<%
UserInfo u = (UserInfo)session.getAttribute("userobj");
if(u!=null)
{
%>
<table>
<tr>
       <td> <label for="firstname">First Name</label></td>
       <td> <input type="text" name="t1" value="<%=u.getFirst_name() %>"><br><br></td>
    </tr>
       
    <tr>
        
        <td><label for="last name">Last Name</label></td>
       <td> <input type="text" name="t2" value="<%=u.getLast_name() %>"><br><br></td>
    </tr>

    <tr>
    <td><label for="contact">Contact</label></td>
<td>  <input type="text" name="t3"   value="<%=u.getContact() %>"><br><br></td>
    </tr>
<tr>
<td> <label for="Address">Address</label></td>
<td>  <input type="text" name="t4" value="<%=u.getAddress() %>"><br><br></td>
    </tr>

<tr>
<td><label for="age">Age</label></td>
<td>  <input type="text" name="t5"  value="<%=u.getAge() %>"><br><br></td>
    </tr>
        
<tr>
    <td> <label for="E-mail">E-mail</label></td>
<td> <input type="text" name="t6"  value="<%=u.getEmail()%>"><br><br></td>
    </tr>
    <tr>
    <td> <label for="password">password</label></td>
<td> <input type="Password" name="t7" value="<%=u.getPassword()%>"><br><br></td>
    </tr>




</table>
<%} %>
 </center>
 <center>
      <input type="submit" name="Update" value="Update">
      </center>
      </form>
      
      
      <%@include file="footer.jsp"%>
      <!-- footer section end -->
      <!-- copyright section start -->
      <div class="copyright_section">
         <div class="container">
            <p class="copyright_text">Copyright 2020 All Right Reserved By.<a href="https://html.design"> Free  html Templates</a></p>
         </div>
      </div>
      <!-- copyright section end -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <!-- javascript --> 
      <script src="js/owl.carousel.js"></script>
      <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
   </body>
</html>

