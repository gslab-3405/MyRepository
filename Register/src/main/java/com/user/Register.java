package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		//getting all the incoming details from the request...
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email=request.getParameter("user_email");
		out.println(name);
		out.println(password);
		out.println(email);
		
		
		//connection......
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/adjtpluse","root","root");
			String q = "insert into user(name,password,email) values(?,?,?)";
			PreparedStatement pstm= con.prepareStatement(q);
			pstm.setString(1, name);
			pstm.setString(2, password);
			pstm.setString(3, email);
			pstm.executeUpdate();
			out.println("<h1>done......</h1>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("<h1>error......</h1>");
			
		}
		//query........
		//...................
		
		
		
		
	}

}
