/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.PasswordDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.PasswordDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class PasswordDAOImpl implements PasswordDAO{

    private Connection conn;

    public PasswordDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<PasswordDTO> getAll() throws Exception {
        
        String sql="select * from password";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<PasswordDTO> passwords=new ArrayList<>();
        while(rst.next()){
            PasswordDTO password=new PasswordDTO(rst.getString("user_name"),rst.getString("password"));
            passwords.add(password);
        }
        return passwords;
    }

    @Override
    public boolean updatePassword(String userName, String password,String lastName) throws Exception {

        String sql="update password set user_name=?,password=? where user_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, userName);
        stm.setObject(2, password);
        stm.setObject(3, lastName);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
    

}
