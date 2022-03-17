package com.empolyee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String contact = request.getParameter("contact");
		String role = request.getParameter("role");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int bonus = Integer.parseInt(request.getParameter("bonus"));
		int id = Integer.parseInt(request.getParameter("id"));
		

		response.sendRedirect("signup.jsp");
		RequestDispatcher dispatcher= null;
		Connection con=null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/employee","harsh","harsh"); 
			PreparedStatement pst = con.prepareStatement("Update employeedetails_111915041 SET First_Name=?,Last_Name=?,Date_of_Birth=?,Contact_Number=? WHERE Employee_ID_Number=?;");
			PreparedStatement pst2 = con.prepareStatement("UPDATE into salarydeatail_111915041 Job_Role=?,Monthly_Salary=?,Yearly_Bonus=? WHERE Employee_ID_Number=?;");
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, dob);
			pst.setString(4, contact);
			pst.setInt(5, id);
			pst2.setString(1, role);
			pst2.setInt(2, salary);
			pst2.setInt(3, bonus);
			pst2.setInt(4, id);
			int rowCount =pst.executeUpdate();
			int rowCount2 =pst2.executeUpdate();
			dispatcher = request.getRequestDispatcher("signup.jsp");
			if(rowCount>0) {
				request.setAttribute("status", "Success");
			}
			else {
				request.setAttribute("status", "Failed");

			}
		} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
