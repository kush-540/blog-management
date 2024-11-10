package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbs.DBService;
import com.dto.Postdto;
import com.dto.UserInfo;


@WebServlet("/PostBlogServlet")
public class PostBlogServlet extends HttpServlet {
	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String User =(String) session.getAttribute("user");
		System.out.println(User);
		
        UserInfo u=new UserInfo();	

		Postdto pd=new Postdto();
		pd.setEmail(User);
		//pd.setEmail(request.getParameter("Email"));
		pd.setTitle(request.getParameter("Title"));
		pd.setCategory(request.getParameter("Category"));
		pd.setBlog(request.getParameter("postdata"));
		//pd.setEmail(User);
		String target="";
		int x=0;
		DBService db=new DBService();
	    x= db.addPost(pd);
		if(x>0)
		{
			target="/PostBlog.jsp";
//			HttpSession session = request.getSession(true);
			session.setAttribute("user", pd.getEmail());
			request.setAttribute("msg", "<center><font color = green>Post Successfully</font></center>");
		}
		
		else
		{
			target="/PostBlog.jsp";
			request.setAttribute("msg", "<center><font color=red>not post</font></center>");
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
}
}
