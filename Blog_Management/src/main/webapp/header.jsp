<div class="header_section">
         <div class="container-fluid header_main">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
               <a class="logo" href="index.jsp"><img src="images/blogwebp.jpg" width="100" height="50"></a>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
               </button>
               <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                     <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="about.jsp">About</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="blog.jsp">Blog</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="features.jsp">Features</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contact Us</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Log in</a>
                     </li>
                      <li class="nav-item">
                        <a class="nav-link" href="registration.jsp">Register</a>
                     </li>
                      <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="#"><img src="images/serach-icon.png"></a>
                     </li>
                  </ul>
               </div>
            </nav>
                  <h1>WELCOME
      <%
      
      String username = (String)session.getAttribute("user");
      if(username!=null)
      {
    	  out.print(username);
      }
      %>
      </h1>
         </div>