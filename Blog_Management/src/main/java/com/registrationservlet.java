package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbs.DBService;
import com.dto.UserInfo;

@WebServlet("/registrationservlet")
public class registrationservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		
		UserInfo u = new  UserInfo();
		u.setFirst_name(request.getParameter("t1"));
		u.setLast_name(request.getParameter("t2"));
		u.setContact(request.getParameter("t3"));
		u.setAddress(request.getParameter("t4"));
		try {
			u.setAge(Integer.parseInt(request.getParameter("t5")));
		} catch (NumberFormatException e) {
			System.out.println("Age Only In Number Year.");
		}
		
		
		u.setEmail(request.getParameter("t6"));
		u.setPassword(request.getParameter("t7"));

		DBService db = new DBService();
		int x = db.addUser(u);
		if(x>0)
		{
			request.setAttribute("msg", "<font color = green>User Register Successfully</font>");
		}
		else
		{
			request.setAttribute("msg", "<font color = red>User Could Not Be Register/Already Exist</font>");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/registration.jsp");
		rd.forward(request, response);
		
	
	}

}
