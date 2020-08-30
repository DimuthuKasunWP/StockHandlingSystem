/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Reject_orderDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Reject_orderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Reject_orderDAOImpl implements Reject_orderDAO{
    
    private Connection conn;

    public Reject_orderDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<Reject_orderDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<Reject_orderDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<Reject_orderDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Reject_orderDTO dto) throws Exception {
        
        int res=0;
        String sql="insert into reject_order values(?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getRjid());
        stm.setObject(2, dto.getReject_amount());
        stm.setObject(3, dto.getRejectDate());
        
        res+=stm.executeUpdate();
        
        if(res>0){
            return true;
        }
        return false;
    }
    
}
