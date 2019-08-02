package com.revature.projectdemo.models;
import com.revature.projectdemo.dao.*;
import java.sql.*;
import com.revature.projectdemo.util.*;


/**
 * 
 */
 public class GeneralManager implements GMDao{
     
    Connection connection;

    public GeneralManager(Connection connection) {
        this.connection = connection;
    }
   

    private String uname;
    private String psw;


    public boolean checkGM(String u, String p){
        boolean success = false;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from gm where username = ? and gm_password = ?");
            pStatement.setString(1, u);
            pStatement.setString(2, p);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                
                if(rs.getString("username").compareTo(u) == 0 && rs.getString("gm_password").compareTo(p) == 0) {
                    success = true;
                }
            }

        } catch (SQLException e) {

        }
        return success;
    }

    public void approve_request(String f, String l){
      
        try {
            PreparedStatement pst = connection.prepareStatement("update request set status = 'Approved' where firstName = ? and lastName = ?");
            pst.setString(1, f);
            pst.setString(2, l);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public void deny_request(String f, String l){
      
        try {
            PreparedStatement pst = connection.prepareStatement("update request set status = 'Denied' where firstName = ? and lastName = ?");
            pst.setString(1, f);
            pst.setString(2, l);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }
    }

    public GeneralManager(){
        super();
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
    
 }