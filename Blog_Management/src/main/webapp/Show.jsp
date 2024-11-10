<!DOCTYPE html>
<%@page import="com.dto.Postdto"%>
<%@page import="java.util.ArrayList"%>
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
background-size:100% 150%;
background-repeat:no-repeat;
 }
 </style>
  </head>
   <body>
      <!-- header section start -->
      <%@include file= "header.jsp"%>
      
      <div class="login_section">
     <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center"> All Blogs</h5>
            <br>
            <br>

			
			
			<form action="DeleteBlogServlet" method="post">
			
			
			<%
			
			Postdto p=null;
			ArrayList<Postdto> al =(ArrayList) request.getAttribute("allblogs");
		if(al!=null)
		{
			for(int i=0; i<al.size(); i++)
			{
				
				 p = al.get(i);
				%>
				E-Mail I'd :
				
					<%= p.getEmail()%>
					<br><br>
					Title :
					
					<%= p.getTitle()%>
					<br><br>
					Category :
					<%= p.getCategory()%>
					<br><br>
					Blog :
					
					<%= p.getBlog()%><br>
					<br>
					
					<button type="submit"  name="b1" value="<%=p.getPid()%>">Delete</button>
					<br>
					
					Comment:<input type="text" name="comm">
					<button type="submit"  name="b1" value="<%=p.getPid()%>">Post Comment</button>
					<br><br><br>
					
					<!--<button type="submit"  name="b1" id="showcomm" value="<%=p.getPid()%>">Show Comments</button>-->
					
				<%
			}
			
		}
		%>
			
			</form>

					
					
            <a href="UserIndex.jsp">Back To Index Page</a><br><br>
            
          </div>
        </div>
      </div>
    </div>
  </div>
    </div>
  </div>
  <!-- login section end-->
      
      
      
      
      
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
  