/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.SectorDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.SectorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class SectorDAOImpl implements SectorDAO{
    
    private Connection conn;

    public SectorDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<SectorDTO> getAll() throws Exception {

        String sql="select * from sector";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<SectorDTO> list=new ArrayList<>();
        while(rst.next()){
            SectorDTO sd=new SectorDTO(rst.getString("sec_name"));
            list.add(sd);
        }
        return list;
    }

    @Override
    public boolean add(SectorDTO dto) throws Exception {
        String sql="insert into sector values(?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getSecName());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String id) throws Exception {

        String sql="delete from sector where sec_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean rename(String rename, String curName) throws Exception {

        String sql="update sector set sec_name=? where sec_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, rename);
        stm.setObject(2, curName);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(String secName) throws Exception {

        String sql="insert into sector values(?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, secName);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
    
}
