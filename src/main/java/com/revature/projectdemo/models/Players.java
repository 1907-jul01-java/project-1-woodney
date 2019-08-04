package com.revature.projectdemo.models;
import com.revature.projectdemo.dao.*;
import java.sql.*;
import com.revature.projectdemo.util.*;


/**
 * 
 */
 public class Players implements PlayerDao{
     
    Connection connection;

    public Players(Connection connection) {
        this.connection = connection;
    }
   
    private String first;
    private String last;
    private String uname;
    private String psw;
    private int age;    

    public Players getPlayer(String u, String p) {
        
        Players disPlayer = new Players();
        try {
            PreparedStatement pst = connection.prepareStatement("select * from players where username = ? and user_password = ?");
            pst.setString(1, u);
            pst.setString(2, p);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                disPlayer.setFirst(rs.getString(2));
                disPlayer.setLast(rs.getString(3));
                disPlayer.setUname(rs.getString(4));
                disPlayer.setPsw(rs.getString(5));
                disPlayer.setAge(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return disPlayer;
    }

    public boolean checkPlayer(String u, String p){
        boolean success = false;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from players where username = ? and user_password = ?");
            pStatement.setString(1, u);
            pStatement.setString(2, p);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                
                if(rs.getString("username").compareTo(u) == 0 && rs.getString("user_password").compareTo(p) == 0) {
                    success = true;
                }
            }

        } catch (SQLException e) {

        }
        return success;
    }

    public String get_pic(String u, String p){
        String picture ="";
        try {
            PreparedStatement pStatement = connection.prepareStatement("select profile_picture from players where username = ? and user_password = ?");
            pStatement.setString(1, u);
            pStatement.setString(2, p);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                picture = rs.getString("profile_picture");
            }

        } catch (SQLException e) {

        }

        return picture;
    }

    public int get_id(String f, String l){
        int id = 0;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select id from players where firstName = ? and lastName = ?");
            pStatement.setString(1, f);
            pStatement.setString(2, l);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {

        }

        return id;
    }

    public void submit_request(String f, String l, String d){
        try{
        PreparedStatement pst = connection.prepareStatement("insert into request(firstName, lastName, deal, status) values (?,?,?,?)");
            pst.setString(1, f);
            pst.setString(2, l);
            pst.setString(3, d);
            pst.setString(4, "Pending");
            pst.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public void update_age(int i, String u){
        try {
            PreparedStatement pst = connection.prepareStatement("update players set age = ? where username = ?");
            pst.setInt(1, i);
            pst.setString(2, u);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public void update_first(String f, String u){
        try {
            PreparedStatement pst = connection.prepareStatement("update players set firstName = ? where username = ?");
            pst.setString(1, f);
            pst.setString(2, u);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public void update_last(String l, String u){
        try {
            PreparedStatement pst = connection.prepareStatement("update players set lastName = ? where username = ?");
            pst.setString(1, l);
            pst.setString(2, u);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public void update_user(String user, String u){
        try {
            PreparedStatement pst = connection.prepareStatement("update players set username = ? where username = ?");
            pst.setString(1, user);
            pst.setString(2, u);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public void update_pass(String p, String u){
        try {
            PreparedStatement pst = connection.prepareStatement("update players set user_password = ? where username = ?");
            pst.setString(1, p);
            pst.setString(2, u);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public Players(){
        super();
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    @Override
    public String toString() {
        return "Player [age=" + age + ", first=" + first + ", last=" + last + ", psw=" + psw + ", uname=" + uname + "]";
    }


    
 }