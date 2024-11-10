package com;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dbs.DBService;
import com.dto.Postdto;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String comm = request.getParameter("comm");
		int pid = 0;
		HttpSession s = request.getSession();
		pid =(Integer) s.getAttribute("pid");
		String email = (String)s.getAttribute("user");
		DBService db = new DBService();
		int x = db.addComment(pid,comm,email);
		
		ArrayList<Postdto> al=null;
		if(x>0)
		{
		al = db.getAllBlogs();
		
		request.setAttribute("allblogs", al);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Show.jsp");
		rd.forward(request, response);
	}
}
