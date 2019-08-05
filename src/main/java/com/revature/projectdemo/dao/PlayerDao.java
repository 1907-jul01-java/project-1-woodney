package com.revature.projectdemo.dao;
import com.revature.projectdemo.models.*;


public interface PlayerDao{
    
    Players getPlayer(String u, String p);
    boolean checkPlayer(String u, String p);
    String get_pic(String u, String p);
    int get_id(String f, String l);
    void submit_request(String f, String l, String d, String h);
    void update_age(int i,String u);
    void update_first(String f, String u);
    void update_last(String l, String u);
    void update_user(String user, String u);
    void update_pass(String p, String u);
}