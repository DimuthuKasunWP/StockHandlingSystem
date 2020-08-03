/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Remove_return_materialDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Remove_receive_materialDTO;
import com.sas.kem.edu.ijse.dto.Remove_return_materialDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class Remove_return_materialDAOImpl implements Remove_return_materialDAO{
    
    private Connection conn;

    public Remove_return_materialDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<Remove_return_materialDTO> getAll() throws Exception {

        String sql="select * from remove_return_material";
        Statement stm=conn.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        ArrayList<Remove_return_materialDTO> list=new ArrayList<>();
        while(rst.next()){
            Remove_return_materialDTO m=new Remove_return_materialDTO(rst.getString("mid"),rst.getString("rbrid"),rst.getBigDecimal("qty_Kg"),rst.getString("remove_date"),rst.getString("remove_time"),rst.getString("carry_sector_name"));
            list.add(m);
        }
        return list;
    }

    @Override
    public boolean add(ArrayList<Remove_return_materialDTO> dtoList) throws Exception {

        int res=0;
        for (Remove_return_materialDTO remove_return_materialDTO : dtoList) {
            
            String sql="insert into remove_return_material values(?,?,?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, remove_return_materialDTO.getMid());
            stm.setObject(2, remove_return_materialDTO.getRbrid());
            stm.setObject(3, remove_return_materialDTO.getQty_kg());
            stm.setObject(4, remove_return_materialDTO.getRemove_date());
            stm.setObject(5, remove_return_materialDTO.getRemove_time());
            stm.setObject(6, remove_return_materialDTO.getCarry_sector_name());
            
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(ArrayList<Remove_return_materialDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Remove_return_materialDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
