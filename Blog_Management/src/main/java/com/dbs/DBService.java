package com.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PostBlogServlet;
import com.dto.Postdto;
import com.dto.UserInfo;

public class DBService {
	Connection con=null;
 public DBService() {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_management?user=root&password=kush04");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error in loading driver and making connection");
	}
	 
 }
 public boolean checkUser(UserInfo u)
 {
	 boolean isvalid=false;
	 try {
	 PreparedStatement ps=con.prepareStatement("select * from UserInfo where Email=? and password=?");
		 
			
		 ps.setString(1, u.getEmail());
		 ps.setString(2, u.getPassword());
		 
		ResultSet rs= ps.executeQuery();
		if(rs.next()==true)
		{
			isvalid=true;
		}
		else
		{
			isvalid=false;
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error in sql statement"+e);
	}
	return isvalid;
 }
 public int addUser(UserInfo u)
 {
	 int x=0;
	try {
		PreparedStatement ps=con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?)");
		ps.setString(1, u.getFirst_name());
		ps.setString(2, u.getLast_name());
		ps.setString(3, u.getContact());
		ps.setString(4,u.getAddress());
		
		ps.setInt(5, u.getAge());
		
		ps.setString(6, u.getEmail());
		 ps.setString(7, u.getPassword());
		 x=ps.executeUpdate();
		 
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error in sql query"+e);
	}
	return x;
 }
 public int updateUser(UserInfo u )
	{
		int x=0;
		try 
		{
			PreparedStatement ps = con.prepareStatement(
			"update UserInfo set"
			+ " first_name= ?,last_name = ?,contact=?, Address=?,Age=?,password=?"
			+ " where Email = ?");
			
			ps.setString(1, u.getFirst_name());
			ps.setString(2, u.getLast_name());
			ps.setString(3, u.getContact());
			ps.setString(4,u.getAddress());
			
			ps.setInt(5, u.getAge());
			
			ps.setString(7, u.getEmail());
			 ps.setString(6, u.getPassword());
			 
			x = ps.executeUpdate();
			
			
		}
		catch (Exception e) 
		{
		System.out.println(e);
		}
		return x;
	}
 public UserInfo getUser(String user)
 {
	 UserInfo u = new UserInfo();
	try {
		PreparedStatement ps=con.prepareStatement("select * from userinfo where email = ?");
		ps.setString(1, user);
		 
		 ResultSet rs =ps.executeQuery();
		 if(rs.next()==true)
		 {
			 u.setFirst_name(rs.getString("first_name"));
			 u.setLast_name(rs.getString("last_name"));
			 u.setContact(rs.getString("contact"));
			 u.setAddress(rs.getString("address"));
			 u.setAge(rs.getInt("age"));
			 u.setEmail(rs.getString("email"));
			 u.setPassword(rs.getString("password"));
			 
		 }
		 
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error in sql query"+e);
	}
	return u;
 }
 public int addPost(Postdto pd)
 {
	 int x=0;
	try {
		PreparedStatement ps=con.prepareStatement("insert into Post(Title,Category,Blog,email) values(?,?,?,?)");
		
		ps.setString(1,pd.getTitle());
		ps.setString(2,pd.getCategory());
		ps.setString(3,pd.getBlog());
		ps.setString(4,pd.getEmail());
		 x=ps.executeUpdate();
		 
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error in sql query"+e);
	}
	return x;
 }
 
 public ArrayList<Postdto> getAllBlogs()
	{
		ArrayList<Postdto>al = new ArrayList<Postdto>();
		try 
		{
			PreparedStatement ps = con.prepareStatement(
			"select * from post");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Postdto pd = new Postdto();
				pd.setPid(rs.getInt("pid"));
				pd.setEmail(rs.getString("email"));
				pd.setTitle(rs.getString("Title"));
				pd.setCategory(rs.getString("category"));
				pd.setBlog(rs.getString("blog"));
				al.add(pd);
			}
			System.out.println("al.size()"+al.size());
			
			
		}
		catch (Exception e) 
		{
		System.out.println("dbs post"+e);
		}
		return al;
	}
 public int deleteBlog(int pid)
	{
		int x=0;
		try 
		{
			PreparedStatement ps = con.prepareStatement(
			"delete from post"
			+ " where pid = ?");
			
			ps.setInt(1, pid);
			x = ps.executeUpdate();
			
			
		}
		catch (Exception e) 
		{
		System.out.println("delete blogs"+e);
		}
		return x;
	}

public int addComment(int pid,String comm,String email)
{
	int x=0;
	try 
	{
		PreparedStatement ps = con.prepareStatement(
		"insert into comments"
		+ " values(?,?,?)");
		
		ps.setInt(1, pid);
		ps.setString(2, comm);
		ps.setString(3, email);
		x = ps.executeUpdate();
		
		
	}
	catch (Exception e) 
	{
	System.out.println("comment blogs"+e);
	}
	return x;
}
}


