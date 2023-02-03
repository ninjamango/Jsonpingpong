package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
        PrintWriter out  = response.getWriter();

        String Userid = request.getParameter("login");
        String Pass = request.getParameter("pass");



        if(Userid.equals("harman") && Pass.equals("12345") ){

            //out.print(" this is Harman's ID <");
            RequestDispatcher red = request.getRequestDispatcher("index.jsp");
            red.forward(request,response);

        }else if(Userid.equals("gursimar") && Pass.equals("123456")  ){

            out.println(" this is Gursimar's ID ") ;

        }else{


            RequestDispatcher rd = request.getRequestDispatcher("/srf.jsp");
            rd.include(request,response);
            out.print("WRONG INFO");
        }




    }
}
