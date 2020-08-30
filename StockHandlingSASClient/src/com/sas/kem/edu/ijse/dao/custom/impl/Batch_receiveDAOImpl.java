/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Batch_receiveDAOImpl implements Batch_receiveDAO{
    
    private Connection conn;

    public Batch_receiveDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public ArrayList<Batch_receiveDTO> getAll() throws Exception {

        String sql="Select * from batch_receive";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Batch_receiveDTO> blist=new ArrayList<>();
        
        while(rst.next()){
            Batch_receiveDTO b=new Batch_receiveDTO(rst.getString("brid"),rst.getString("grid"),rst.getString("mid"),rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getBigDecimal("received_qty_kg"),rst.getBigDecimal("current_qty_kg"),rst.getBigDecimal("unit_price_1kg"),rst.getBigDecimal("total"));
            blist.add(b);
        }
        return blist;
    }

    @Override
    public boolean add(ArrayList<Batch_receiveDTO> dtoList) throws Exception {
        
        int res=0;
        
        for (Batch_receiveDTO batch_receiveDTO : dtoList) {
            
            String sql="insert into batch_receive values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, batch_receiveDTO.getBrid());
            stm.setObject(2, batch_receiveDTO.getGrid());
            stm.setObject(3, batch_receiveDTO.getMid());
            stm.setObject(4, batch_receiveDTO.getMfd());
            stm.setObject(5, batch_receiveDTO.getExp());
            stm.setObject(6, batch_receiveDTO.getReceived_qty_kg());
            stm.setObject(7, batch_receiveDTO.getCurrent_qty_kg());
            stm.setObject(8, batch_receiveDTO.getUnitPrice_1kg());
            stm.setObject(9, batch_receiveDTO.getTotal());
            res+=stm.executeUpdate();
            
        }
        if(res==dtoList.size()){
            System.out.println("1");
            return true;

        }
        System.out.println("2");
        return false;
    }

    @Override
    public boolean update(ArrayList<Batch_receiveDTO> dtoList) throws Exception {
        
        int res=0;
        for (Batch_receiveDTO batch_receiveDTO : dtoList) {
            
            String sql="update batch_receive set current_qty_kg=? where brid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, batch_receiveDTO.getCurrent_qty_kg());
            stm.setObject(2, batch_receiveDTO.getBrid());
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

}
