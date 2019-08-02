package com.revature.projectdemo.servlets;
import com.revature.projectdemo.models.*;
import com.revature.projectdemo.util.ConnectionUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       

// }

public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    String u = req.getParameter("uname");
    String p = req.getParameter("psw");
    
//     try{
//         Players cPlayer = get_curPlayer(u, p);
//         //String pic = cPlayer.get_pic(u, p);
//         HttpSession session = req.getSession();
//         //session.setAttribute("picture", pic);
//         session.setAttribute("username", u);
//         session.setAttribute("player", cPlayer);
//         resp.sendRedirect("profile.jsp");
//     }catch (SQLException e) {
//         e.printStackTrace();
//     }
// }
    try 
    {
    if(validate(u, p)) {
        HttpSession session = req.getSession();
        Players cPlayer = get_curPlayer(u, p);
        String first = cPlayer.getFirst();
        String last = cPlayer.getLast();
        session.setAttribute("username", u);
        session.setAttribute("player", cPlayer);
        session.setAttribute("first", first);
        session.setAttribute("last", last);
        resp.sendRedirect("profile.jsp");
    }
    else{
        resp.sendRedirect("index.html");
    }
}catch (SQLException e) {
    e.printStackTrace();
}
}
    // RequestDispatcher rd = req.getRequestDispatcher("playerprofile");
    // rd.forward(req, resp);

public boolean validate(String u, String p)  throws FileNotFoundException, SQLException{
    ConnectionUtil connectionUtil = new ConnectionUtil();
    Players player = new Players(connectionUtil.getConnection());
    boolean check = player.checkPlayer(u, p);
    connectionUtil.close();
    return check;
}

public Players get_curPlayer(String u, String p) throws FileNotFoundException, SQLException{
    ConnectionUtil connectionUtil = new ConnectionUtil();
    Players player = new Players(connectionUtil.getConnection());
    Players curPlayer = player.getPlayer(u, p);
    connectionUtil.close();
    return curPlayer;
}

public String get_picture(String u, String p) throws FileNotFoundException, SQLException{
    ConnectionUtil connectionUtil = new ConnectionUtil();
    Players player = new Players(connectionUtil.getConnection());
    String picture = player.get_pic(u, p);
    connectionUtil.close();
    return picture;
}
}