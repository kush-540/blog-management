package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbs.DBService;
import com.dto.Postdto;
import com.mysql.cj.Session;


@WebServlet("/DeleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		int pid =0;
		try {
			pid = Integer.parseInt(request.getParameter("b1"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		HttpSession s = request.getSession();
		s.setAttribute("pid", pid);
		Enumeration<String> uri =  request.getAttributeNames();
		while(uri.hasMoreElements())
		{
			System.out.println(uri.nextElement());
		}
		
		if(request.getParameter("comm")!=null)
		{
			RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/CommentServlet");
			rd1.forward(request, response);
		}
		System.out.println("pid = "+pid);
		DBService db = new DBService();
		int x = db.deleteBlog(pid);
		
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
