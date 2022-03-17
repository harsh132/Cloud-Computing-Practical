package com.empolyee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String contact = request.getParameter("contact");
		
		HttpSession session=request.getSession();
		response.sendRedirect("report.jsp");
		RequestDispatcher dispatcher= null;
		Connection con=null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/employee","harsh","harsh"); 
			PreparedStatement pst = con.prepareStatement("select * from employeedetails_111915041 where First_Name=? and Contact_Number=?;");
			pst.setString(1, fname);
			pst.setString(2, contact);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				session.setAttribute("name", rs.getString("First_Name"));
				dispatcher=request.getRequestDispatcher("report.jsp");
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher=request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
