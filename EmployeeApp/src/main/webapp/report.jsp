<% if(session.getAttribute("name")==null) { response.sendRedirect("login.jsp"); } %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = null;
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Report | Employee App</title>
    </head>
    <body>
        <div id="content">
            <h1>Report</h1>
            <hr />
            <br />
            <table cellspacing="0">
                <tr>
                    <td>Employee_ID_Number</td>
                    <td>First_Name</td>
                    <td>Last_Name</td>
                    <td>Date_of_Birth</td>
                    <td>Contact_Number</td>
                    <td>Job_Role</td>
                    <td>Monthly_Salary</td>
                    <td>Yearly_Bonu</td>
                </tr>
                <tr>
                	<td>1</td>
                    <td>Harsh</td>
                    <td>Prakash</td>
                    <td>2000-11-20</td>
                    <td>8873005391</td>
                    <td>SDE</td>
                    <td>100000</td>
                    <td>5000</td>
                </tr>
                <%
                	try{ con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","harsh","harsh"); PreparedStatement pst =
                	con.prepareStatement("Select * from employeedetails_111915041 as d join salarydeatail_111915041 as s where d.Employee_ID_Number=s.Employee_ID_Number");
                	ResultSet rs=pst.executeQuery();
                	while(rs.next()){
                %>
                <tr>
                    <td><%=rs.getInt("Employee_ID_Number") %></td>
                </tr>
                <%
                }
                	con.close();
                } catch (Exception e) {
                	e.printStackTrace();
                }
                %>
            </table>
            <br /><br /><br />
            
            <h1>Update</h1>
            <hr>
            <form action="./Signup" method="post">
            	Empolyee ID : <input type="number" name="id" /><br /><br />
                First Name : <input type="text" name="firstname" /><br /><br />
                Last Name : <input type="text" name="lastname" /><br /><br />
                Date of Birth : <input type="date" name="dob" /><br /><br />
                Contact Number : <input type="text" name="contact" /><br /><br />
                Job Role : <input type="text" name="role" /><br /><br />
                Monthly salary : <input type="number" name="salary" /><br /><br />
                Yearly Bonus : <input type="number" name="bonus" /><br /><br />
                <input type="submit" value="Register" />
            </form>
            <br><br><br>
            <a href="./index.jsp">Home</a>
        </div>
    </body>
</html>
