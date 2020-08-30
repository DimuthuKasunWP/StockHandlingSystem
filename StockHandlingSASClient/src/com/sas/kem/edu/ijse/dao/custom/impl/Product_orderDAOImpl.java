/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Product_orderDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Product_orderDAOImpl implements Product_orderDAO{
    
    private Connection conn;

    public Product_orderDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<Product_orderDTO> getAll() throws Exception {

        String sql="select * from product_order";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Product_orderDTO> plist=new ArrayList<>();
        while(rst.next()){
            Product_orderDTO p=new Product_orderDTO(rst.getString("oid"),rst.getString("baid"),rst.getInt("packages"),rst.getBigDecimal("qty_kg"),rst.getBigDecimal("unit_price_1Bag"),rst.getBigDecimal("total"));
            plist.add(p);
        }
        return plist;
    }

    @Override
    public boolean add(ArrayList<Product_orderDTO> dtoList) throws Exception {
        
        int res=0;
        for (Product_orderDTO product_orderDTO : dtoList) {
            
            String sql="insert into product_order values(?,?,?,?,?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, product_orderDTO.getOid());
            stm.setObject(2, product_orderDTO.getBaid());
            stm.setObject(3, product_orderDTO.getPack());
            stm.setObject(4, product_orderDTO.getQty());
            stm.setObject(5, product_orderDTO.getUnitPrice_1Bag());
            stm.setObject(6, product_orderDTO.getTotal());
            
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String oid) throws Exception {

        String sql="delete from product_order where oid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, oid);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
    
}
