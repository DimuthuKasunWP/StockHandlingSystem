/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.GrnDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.GrnDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class GrnDAOImpl implements GrnDAO{
    
    private Connection conn;

    public GrnDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public ArrayList<GrnDTO> getAll() throws Exception {

        String sql="Select * from grn";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<GrnDTO> glist=new ArrayList<>();
        while(rst.next()){
            GrnDTO g=new GrnDTO(rst.getString("grid"),rst.getString("cid"),rst.getString("pid"),rst.getInt("good_amount"),rst.getString("add_time"),rst.getString("grn_date"),rst.getBigDecimal("grand_total"));
            glist.add(g);
        }
        return glist;
    }

    @Override
    public boolean update(ArrayList<GrnDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(GrnDTO grn) throws Exception {
        
        int res=0;
        
        String sql="insert into grn values(?,?,?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, grn.getGrid());
        stm.setObject(2, grn.getCid());
        stm.setObject(3, grn.getPid());
        stm.setObject(4, grn.getGoodAmount());
        stm.setObject(5, grn.getAddTime());
        stm.setObject(6, grn.getGrnDate());
        stm.setObject(7, grn.getGrandTotal() );
        
        res=stm.executeUpdate();
        
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(GrnDTO dto) throws Exception {

        String sql="Update grn set good_amount=good_amount+?,grand_total=grand_total+? where grid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getGoodAmount());
        stm.setObject(2, dto.getGrandTotal());
        stm.setObject(3, dto.getGrid());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
}
