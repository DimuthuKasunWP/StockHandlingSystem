/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Purchase_orderDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Purchase_orderDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Purchase_orderDAOImpl implements Purchase_orderDAO{
    
    private Connection conn;

    public Purchase_orderDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<Purchase_orderDTO> getAll() throws Exception {
        
        String sql="select * from purchase_order";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Purchase_orderDTO> pOrderList=new ArrayList<>();
        while(rst.next()){
            
            Purchase_orderDTO p=new Purchase_orderDTO(rst.getString("pid"),rst.getString("cid"),rst.getInt("goodsAmount"),rst.getDouble("vat"),rst.getDouble("svat"),rst.getDouble("discount"),rst.getDouble("grand_total"),rst.getString("create_date"),rst.getString("confirm_date"));
            pOrderList.add(p);
        }
        return pOrderList;
    }

    @Override
    public boolean add(ArrayList<Purchase_orderDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<Purchase_orderDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Purchase_orderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
