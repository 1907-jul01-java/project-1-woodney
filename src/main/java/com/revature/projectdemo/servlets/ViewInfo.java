package com.revature.projectdemo.servlets;
import com.revature.projectdemo.models.*;
import com.revature.projectdemo.util.ConnectionUtil;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/view")
public class ViewInfo extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.sendRedirect("submitted.html");
    }
}





