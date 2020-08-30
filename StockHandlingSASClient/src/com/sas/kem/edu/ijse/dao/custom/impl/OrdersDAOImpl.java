/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.OrdersDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class OrdersDAOImpl implements OrdersDAO{
    
    private Connection conn;

    public OrdersDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<OrdersDTO> getAll() throws Exception {

        String sql="Select * from orders";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<OrdersDTO> list=new ArrayList<>();
        while(rst.next()){
            OrdersDTO order=new OrdersDTO(rst.getString("oid"),rst.getString("cid"),rst.getString("po"),rst.getBigDecimal("total"),rst.getString("order_date"));
            list.add(order);
        }
        return list;
    }

    @Override
    public boolean add(OrdersDTO dto) throws Exception {
        
        int res=0;
        
        String sql="insert into orders values(?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getOid());
        stm.setObject(2, dto.getCid());
        stm.setObject(3, dto.getPo());
        stm.setObject(4, dto.getTotal());
        stm.setObject(5, dto.getOrderDate());
        
        res=stm.executeUpdate();
        
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(OrdersDTO dto) throws Exception {

        String sql="update orders set total=? where oid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getTotal());
        stm.setObject(2, dto.getOid());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
}
