/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Reject_return_receiveDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Reject_return_receiveDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class Reject_return_receiveDAOImpl implements Reject_return_receiveDAO{

    private Connection conn;

    public Reject_return_receiveDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<Reject_return_receiveDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<Reject_return_receiveDTO> dtoList) throws Exception {

        int res=0;
        for (Reject_return_receiveDTO reject_return_receiveDTO : dtoList) {
            String sql="insert into reject_return_receive values(?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, reject_return_receiveDTO.getRbrid());
            stm.setObject(2, reject_return_receiveDTO.getQty());
            stm.setObject(3, reject_return_receiveDTO.getCause());
            stm.setObject(4, reject_return_receiveDTO.getReject_date());
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(ArrayList<Reject_return_receiveDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Reject_return_receiveDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
