/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.MaterialDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
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
public class MaterialDaoImpl implements MaterialDAO{
    
    private Connection conn;

    public MaterialDaoImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    
    @Override
    public ArrayList<MaterialDTO> getAll() throws Exception {
        
        String sql="Select * from material";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<MaterialDTO> mlist=new ArrayList<>();
        while(rst.next()){
            
            MaterialDTO m=new MaterialDTO(rst.getString("mid"),rst.getString("material_name"),rst.getBigDecimal("amount_kg"));
            mlist.add(m);
                    
        }
        return mlist;
    }

    @Override
    public String getMaterialId(String matName) throws Exception {
        
        String sql="select mid from material where material_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, matName);
        ResultSet rst=stm.executeQuery();
        String mid=null;
        if(rst.next()){
            mid=rst.getString("mid");
        }
        return mid;
        
    }

    
    @Override
    public boolean update(ArrayList<MaterialDTO> dtoList) throws Exception {
        
        int res=0;
        
        for (MaterialDTO materialDTO : dtoList) {
            
            String sql="update material set amount_kg=amount_kg+? where mid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(2, materialDTO.getMid());
            stm.setObject(1, materialDTO.getAmount_kg());
            res+=stm.executeUpdate();
            
        }
        if(res==dtoList.size()){
            return true;
        }
        return false;
    }

    @Override
    public ObservableList<String> getMatNames(String matName) throws Exception {
        
        String sql="Select material_name from material where material_name like ?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, matName+'%');
        ResultSet rst=stm.executeQuery();
        
        ObservableList<String> list=FXCollections.observableArrayList();
        while(rst.next()){
            String name=rst.getString("material_name");
            list.add(name);
        }
        if(list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public String getMatName(String mid) throws Exception {
        
        String sql="Select material_name from material where mid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, mid);
        ResultSet rst=stm.executeQuery();
        String name=null;
        if(rst.next()){
            name=rst.getString("material_name");
        }
        return name;
    }

    @Override
    public boolean add(MaterialDTO dto) throws Exception {

        int res=0;
        String sql="insert into material values(?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getMid());
        stm.setObject(2,dto.getMaterialName());
        stm.setObject(3,dto.getAmount_kg());
        res=stm.executeUpdate();
        
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAsReduce(ArrayList<MaterialDTO> matlist) throws Exception {

        int res=0;
        
        for (MaterialDTO materialDTO : matlist) {
            
            String sql="update material set amount_kg=amount_kg-? where mid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(2, materialDTO.getMid());
            stm.setObject(1, materialDTO.getAmount_kg());
            res+=stm.executeUpdate();
            
        }
        if(res==matlist.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMatName(String rename,String matName) throws Exception {

        String sql="update material set material_name=? where material_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, rename);
        stm.setObject(2, matName);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String id) throws Exception {

        String sql="delete from material where mid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
    
}
