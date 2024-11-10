package com;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbs.DBService;
import com.dto.*;
import java.util.*;
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	DBService dbs = new DBService();
	ArrayList<Postdto> al = dbs.getAllBlogs();
	
	request.setAttribute("allblogs", al);
	
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Show.jsp");
	rd.forward(request, response);
}

}

