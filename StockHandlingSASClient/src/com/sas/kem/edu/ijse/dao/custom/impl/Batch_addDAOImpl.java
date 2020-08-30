/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Batch_addDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Batch_addDAOImpl implements Batch_addDAO{
    
    Connection conn;

    public Batch_addDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<Batch_addDTO> getAll() throws Exception {
      
        String sql="Select * from batch_add";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Batch_addDTO> blist=new ArrayList<>();
        while(rst.next()){
            Batch_addDTO b=new Batch_addDTO(rst.getString("baid"),rst.getString("proid"),rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getInt("product_qty"),rst.getInt("current_qty"),rst.getBigDecimal("unit_price"),rst.getString("add_time"),rst.getString("add_date"));
            blist.add(b);
        }
        return blist;
    }


    @Override
    public boolean add(ArrayList<Batch_addDTO> dtoList) throws Exception {
        
        int res=0;
        for (Batch_addDTO batch_addDTO : dtoList) {
            String sql="insert into batch_add values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, batch_addDTO.getBaid());
            stm.setObject(2, batch_addDTO.getProid());
            stm.setObject(3, batch_addDTO.getMfd());
            stm.setObject(4, batch_addDTO.getExp());
            stm.setObject(5, batch_addDTO.getProduct_qty());
            stm.setObject(6, batch_addDTO.getCurrent_qty());
            stm.setObject(7, batch_addDTO.getUnitPrice());
            stm.setObject(8, batch_addDTO.getAddTime());
            stm.setObject(9, batch_addDTO.getAddDate());
            
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
        

    }

    @Override
    public boolean update(ArrayList<Batch_addDTO> dtoList) throws Exception {
        
        int res=0;
        
        for (Batch_addDTO batch_addDTO : dtoList) {
            
            String sql="Update batch_add set current_qty=current_qty-? where baid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(2, batch_addDTO.getBaid());
            stm.setObject(1, batch_addDTO.getCurrent_qty());
            res+=stm.executeUpdate();
            
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAsIncreased(ArrayList<Batch_addDTO> dtoList) throws Exception {

        int res=0;
        
        for (Batch_addDTO batch_addDTO : dtoList) {
            
            String sql="Update batch_add set current_qty=current_qty+? where baid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(2, batch_addDTO.getBaid());
            stm.setObject(1, batch_addDTO.getCurrent_qty());
            res+=stm.executeUpdate();
            
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public String getProId(String baid) throws Exception {

        String sql="select proid from batch_add where baid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, baid);
        ResultSet rst=stm.executeQuery();
        String proid=null;
        if(rst.next()){
            proid=rst.getString("proid");
        }
        return proid;
    }

}
