/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletspackage;

import datapackage.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author soobkey
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if (!userName.trim().isEmpty() && !password.trim().isEmpty()) {
            User user = new User(userName, password);
            UsersServlet.users.add(user);
            response.getOutputStream().println("<h4>Registered Successfully</h4>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            response.sendRedirect("register.html");
        }
    }

}
