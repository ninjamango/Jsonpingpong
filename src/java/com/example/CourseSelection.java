package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name = "CourseSelection", value = "/CourseSelection")
public class CourseSelection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String CName = request.getParameter("CName");

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", "root", "Singh12345");
            PreparedStatement ps = con.prepareStatement("select * from thecourses where Coursetitle = ? ");

            ps.setString(1, CName);

            out.print("<table width=75% border = 10");
            out.print("<caption>Student Result : </caption>");

            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int totalcol = rsmd.getColumnCount();
            out.print("<tr>");
            for (int i = 1; i <= totalcol; i++) {




                out.print("<th>" + rsmd.getColumnName(i) + "</th>" );
            }
            out.print("<tr>");
            while(rs.next()){

                out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td></tr>");



            }
            out.print("</table >");


        }catch (Exception e){





        }












    }
}
