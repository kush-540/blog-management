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
import com.mysql.cj.Session;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String user =(String) session.getAttribute("user");
		DBService db =new DBService();
		UserInfo u =  db.getUser(user);
		session.setAttribute("userobj", u);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Update.jsp");
		rd.forward(request, response);
	}
}
