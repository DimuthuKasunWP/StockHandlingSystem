/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Return_batch_receiveDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class Return_batch_receiveDAOImpl implements Return_batch_receiveDAO{

    private Connection conn;

    public Return_batch_receiveDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<Return_batch_receiveDTO> getAll() throws Exception {

        String sql="select * from return_batch_receive";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Return_batch_receiveDTO> list=new ArrayList<>();
        while(rst.next()){
            Return_batch_receiveDTO b=new Return_batch_receiveDTO(rst.getString("rbrid"),rst.getString("grid"),rst.getString("mid"),rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getBigDecimal("returned_qty_kg"),rst.getBigDecimal("current_qty_kg"),rst.getBigDecimal("unit_price_1kg"),rst.getBigDecimal("total"));
            list.add(b);
        }
        return list;
    }

    @Override
    public boolean add(ArrayList<Return_batch_receiveDTO> dtoList) throws Exception {

        int res=0;
        for (Return_batch_receiveDTO return_batch_receiveDTO : dtoList) {
            String sql="insert into return_batch_receive values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, return_batch_receiveDTO.getRbrid());
            stm.setObject(2, return_batch_receiveDTO.getGrid());
            stm.setObject(3, return_batch_receiveDTO.getMid());
            stm.setObject(4, return_batch_receiveDTO.getMfd());
            stm.setObject(5, return_batch_receiveDTO.getExp());
            stm.setObject(6, return_batch_receiveDTO.getReturned_qty());
            stm.setObject(7, return_batch_receiveDTO.getCurrent_qty());
            stm.setObject(8, return_batch_receiveDTO.getUnitPrice());
            stm.setObject(9, return_batch_receiveDTO.getTotal());
            
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(ArrayList<Return_batch_receiveDTO> dtoList) throws Exception {
        
        int res=0;
        for (Return_batch_receiveDTO return_batch_receiveDTO : dtoList) {
            
            String sql="update return_batch_receive set current_qty_kg=? where rbrid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, return_batch_receiveDTO.getCurrent_qty());
            stm.setObject(2, return_batch_receiveDTO.getRbrid());
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

}
