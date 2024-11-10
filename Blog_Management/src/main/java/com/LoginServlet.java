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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				
				
				UserInfo u=new UserInfo();
				u.setEmail(request.getParameter("t6"));
				u.setPassword(request.getParameter("t7"));
				
				DBService db=new DBService();
				boolean isvalid=db.checkUser(u);
				String target="";
				if(isvalid==true)
				{
					target="/UserIndex.jsp";
					HttpSession session = request.getSession(true);
					session.setAttribute("user", u.getEmail());
//					System.out.println(session.getAttribute("user/"));
				}
				else
				{
					target="/login.jsp";
					request.setAttribute("msg", "invalid username/password");
				}
				RequestDispatcher rd=request.getRequestDispatcher(target);
				rd.forward(request, response);
	}

}
