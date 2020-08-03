/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.ProductDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vidura
 */
public class ProductDAOImpl implements ProductDAO {
    
    private Connection conn;
    
    public ProductDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<ProductDTO> getAll() throws Exception {
        
        String sql="Select * from product";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<ProductDTO> prolist=new ArrayList<>();
        while(rst.next()){
            ProductDTO p=new ProductDTO(rst.getString("proid"),rst.getString("product_name"),rst.getBigDecimal("bag_size_kg"),rst.getInt("product_qty_bags"));
            prolist.add(p);
        }
        return prolist;
        
    }

    @Override
    public String getProid(String proName) throws Exception {
        
        String sql="Select proid from product where product_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, proName);
        ResultSet rst=stm.executeQuery();
        String proId=null;
        while(rst.next()){
            proId=rst.getString("proid");
        }
        return proId;   
    }


    @Override
    public boolean add(ArrayList<ProductDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ArrayList<ProductDTO> dtoList) throws Exception {
        
        int res=0;
        for (ProductDTO productDTO : dtoList) {
            
            String sql="update product set product_qty_bags=product_qty_bags-? where proid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, productDTO.getQtyBags());
            stm.setObject(2, productDTO.getProid());
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public ObservableList<String> getProNames(String proName) throws Exception {
        
        String sql="Select product_name from product where product_name like ?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, proName+'%');
        ResultSet rst=stm.executeQuery();
        
        ObservableList<String> list=FXCollections.observableArrayList();
        while(rst.next()){
            String name=rst.getString("product_name");
            list.add(name);
        }
        if(list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public String getProName(String proid) throws Exception {

        String sql="select product_name from product where proid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, proid);
        ResultSet rst=stm.executeQuery();
        
        String name=null;
        if(rst.next()){
            name=rst.getString("product_name");
        }
        return name;
    }

    @Override
    public boolean add(ProductDTO dto) throws Exception {
        
        int res=0;
        String sql="insert into product values(?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getProid());
        stm.setObject(2, dto.getProductName());
        stm.setObject(3, dto.getBagSize_kg());
        stm.setObject(4, dto.getQtyBags());
        res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList) throws Exception {

        int res=0;
        for (ProductDTO productDTO : dtoList) {
            
            String sql="update product set product_qty_bags=product_qty_bags+? where proid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, productDTO.getQtyBags());
            stm.setObject(2, productDTO.getProid());
            res+=stm.executeUpdate();
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(String rename, String product) throws Exception {

        String sql="update product set product_name=? where product_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, rename);
        stm.setObject(2, product);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String id) throws Exception {

        String sql="delete from product where proid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
    
}
