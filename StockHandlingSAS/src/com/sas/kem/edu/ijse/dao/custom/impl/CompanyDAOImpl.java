/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.CompanyDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
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
public class CompanyDAOImpl implements CompanyDAO{
    
    private Connection conn;

    public CompanyDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<CompanyDTO> getAll() throws Exception {
        
        String sql="select * from company";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<CompanyDTO> clist=new ArrayList<>();
        while(rst.next()){
            
            CompanyDTO c=new CompanyDTO(rst.getString("cid"),rst.getString("com_name"),rst.getString("address_no"),rst.getString("address_lane"),rst.getString("address_area"),rst.getString("address_city"),rst.getString("email"),rst.getString("tel_no"),rst.getString("tel_add"),rst.getString("fax_no"));
            clist.add(c);
        }
        return clist;
    }

    @Override
    public String getCompanyId(String comName) throws Exception {
        
        String sql="select cid from company where com_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, comName);
        ResultSet rst=stm.executeQuery();
        String cid=null;
        if(rst.next()){
            cid=rst.getString("cid");
        }
        return cid;
        
    }


    @Override
    public ObservableList<String> getComNames(String comName) throws Exception {

        String sql="Select com_name from company where com_name like ?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, comName+'%');
        ResultSet rst=stm.executeQuery();
        
        ObservableList<String> list=FXCollections.observableArrayList();
        while(rst.next()){
            String name=rst.getString("com_name");
            list.add(name);
        }
        if(list.size()>0){
            return list;
        }
        return null;
    }


    @Override
    public boolean add(CompanyDTO dto) throws Exception {
        
        int res=0;
        
        String sql="insert into company values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getCid());
        stm.setObject(2, dto.getComName());
        stm.setObject(3, dto.getAddressNo());
        stm.setObject(4, dto.getAddressLane());
        stm.setObject(5, dto.getAddressArea());
        stm.setObject(6, dto.getAddressCity());
        stm.setObject(7, dto.getEmail());
        stm.setObject(8, dto.getTelNo());
        stm.setObject(9, dto.getTelAddNo());
        stm.setObject(10, dto.getFaxNo());
        
        res=stm.executeUpdate();
        
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateComName(String rename, String comName) throws Exception {

        String sql="update company set com_name=? where com_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, rename);
        stm.setObject(2, comName);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public String getComName(String cid) throws Exception {

        String sql="select com_name from company where cid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, cid);
        ResultSet rst=stm.executeQuery();
        String comName=null;
        if(rst.next()){
            comName=rst.getString("com_name");
        }
        return comName;
    }

    @Override
    public boolean remove(String id) throws Exception {

        String sql="delete from company where cid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(CompanyDTO dto) throws Exception {
        
       String sql="update company set com_name=?,address_no=?,address_lane=?,address_area=?,address_city=?,email=?,tel_no=?,tel_add=?,fax_no=? where cid=?";
       PreparedStatement stm=conn.prepareStatement(sql);
       stm.setObject(1, dto.getComName());
       stm.setObject(2, dto.getAddressNo());
       stm.setObject(3, dto.getAddressLane());
       stm.setObject(4, dto.getAddressArea());
       stm.setObject(5, dto.getAddressCity());
       stm.setObject(6, dto.getEmail());
       stm.setObject(7, dto.getTelNo());
       stm.setObject(8, dto.getTelAddNo());
       stm.setObject(9, dto.getFaxNo());
       stm.setObject(10, dto.getCid());
       int res=stm.executeUpdate();
       if(res>0){
           return true;
       }
       return false;
    }
    
}
