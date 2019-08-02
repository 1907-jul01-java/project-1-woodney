package com.revature.projectdemo.dao;
import com.revature.projectdemo.models.*;


public interface GMDao{
    
    boolean checkGM(String u, String p);
    void approve_request(String f, String l);
    void deny_request(String f, String l);
}