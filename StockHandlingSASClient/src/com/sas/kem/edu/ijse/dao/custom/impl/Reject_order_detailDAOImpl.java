/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Reject_order_detailDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Reject_order_detailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Reject_order_detailDAOImpl implements Reject_order_detailDAO{

    private Connection conn;

    public Reject_order_detailDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<Reject_order_detailDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<Reject_order_detailDTO> dtoList) throws Exception {
        
        int res=0;
        for (Reject_order_detailDTO reject_order_detailDTO : dtoList) {
            
            String sql="insert into reject_order_detail values(?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, reject_order_detailDTO.getRjid());
            stm.setObject(2, reject_order_detailDTO.getBaid());
            stm.setObject(3, reject_order_detailDTO.getOid());
            stm.setObject(4,reject_order_detailDTO.getQty());
            
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
        
    }

    @Override
    public boolean update(ArrayList<Reject_order_detailDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Reject_order_detailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
