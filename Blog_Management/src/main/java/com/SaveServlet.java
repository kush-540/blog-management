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
import com.dto.UserInfo;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfo u=new UserInfo();
		u.setFirst_name(request.getParameter("t1"));
		u.setLast_name(request.getParameter("t2"));
		u.setContact(request.getParameter("t3"));
		u.setAddress(request.getParameter("t4"));
		try {
			u.setAge(Integer.parseInt(request.getParameter("t5")));
		} 
		catch (Exception e) 
		{
			System.out.println("save"+e);
		}
		
		u.setEmail(request.getParameter("t6"));
		u.setPassword(request.getParameter("t7"));
		
		int x=0;
		DBService db=new DBService();
	    x=db.updateUser(u);
		String target="";
		
		if(x>0)
		{
			target="/Update.jsp";
			HttpSession session = request.getSession(true);
			session.setAttribute("user", u.getEmail());
			request.setAttribute("msg", "<center><font color = green>Update Successfully</font></center>");
		}
		
		else
		{
			target="/UserIndex.jsp";
			request.setAttribute("msg", "<center><font color = red>invalid username/password</font></center>");
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
}



	}

	
	


