package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.sql.*;

@WebServlet(name = "Registration", value = "/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String Name = request.getParameter("Name");
        String F_Name = request.getParameter("F_Name");
        String Address = request.getParameter("Address");
        String Country = request.getParameter("Country");

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","Singh12345");

            PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?)");

            ps.setString(1,Name);
            ps.setString(2,F_Name);
            ps.setString(3,Address);
            ps.setString(4,Country);

            int i = ps.executeUpdate();


            if(i>0){

                out.print("You are Successfully Registered");



            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
