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


@WebServlet("/request")
public class Request extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String f = req.getParameter("firstname");
        String l = req.getParameter("lastname");
        String d = req.getParameter("deal");
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Players curPlayer = new Players(connectionUtil.getConnection());
        curPlayer.submit_request(f, l, d);
        resp.sendRedirect("submitted.html");
    }
}





