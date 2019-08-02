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


@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String f = req.getParameter("first");
        String l = req.getParameter("last");
        int a = Integer.parseInt(req.getParameter("age"));
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Players curPlayer = new Players(connectionUtil.getConnection());
        if(f != null){
        curPlayer.update_first(f, u);
        }
        if(l != null){
        curPlayer.update_last(l, u);
        }
        if(a != 0){
        curPlayer.update_age(a, u);
        }
        if(u != null){
        curPlayer.update_user(u, u);
        }
        if(p != null){
        curPlayer.update_pass(p, u);
        }
        resp.sendRedirect("submitted.html");
    }
}





