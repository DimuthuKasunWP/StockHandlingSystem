/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.QuaryDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.BatchGrnDetailsDTO;
import com.sas.kem.edu.ijse.dto.BatchOrderDTO;
import com.sas.kem.edu.ijse.dto.BatchProDTO;
import com.sas.kem.edu.ijse.dto.ProOrderDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public class QuaryDAOImpl implements QuaryDAO{
    
    private Connection conn;

    public QuaryDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public BigDecimal getUnitPriceFromReceiveBatch(String mid) throws Exception {
            
        String sql="select distinct unit_price_1kg from material m,batch_receive b where (m.mid=b.mid) && (m.mid=?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, mid);
        ResultSet rst=stm.executeQuery();
        BigDecimal unitPrice=null;
        while(rst.next()){
            unitPrice=rst.getBigDecimal("unit_price_1kg");
        }
        return unitPrice;
    }

    @Override
    public BigDecimal getUnitPriceFromReturnReceiveBatch(String mid) throws Exception {
        
        String sql="select distinct unit_price_1kg from material m,return_batch_receive b where (m.mid=b.mid) && (m.mid=?)";
        
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, mid);
        ResultSet rst=stm.executeQuery();
        BigDecimal unitPrice=null;
        while(rst.next()){
            unitPrice=rst.getBigDecimal("unit_price_1kg");
        }
        return unitPrice;
    }

    @Override
    public BatchGrnDetailsDTO getBatchGrnDetails(String brid) throws Exception {
       
        String sql="select cid,b.grid,add_time,grn_date from batch_receive b,grn g where (b.grid=g.grid)&& (b.brid=?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, brid);
        ResultSet rst=stm.executeQuery();
        
        BatchGrnDetailsDTO b=null;
        if(rst.next()){
            b=new BatchGrnDetailsDTO(rst.getString("cid"),rst.getString("add_time"),rst.getString("grn_date"),rst.getString("grid"));
        }
        return b;
    }

    @Override
    public ArrayList<String> getBrid(String date) throws Exception {
        
        String sql="Select brid from batch_receive b,grn g where (b.grid=g.grid) && g.grn_date=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, date);
        ResultSet rst=stm.executeQuery();
        ArrayList<String> stringList=new ArrayList<>();;
        while(rst.next()){
            String brid=rst.getString("brid");
            stringList.add(brid);
        }
        return stringList;
    }

    @Override
    public ArrayList<BatchProDTO> getBatchProDetail() throws Exception {
        
        String sql="Select distinct b.proid,baid,b.product_qty,b.current_qty from product p,batch_add b where p.proid=b.proid";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<BatchProDTO> bplist=new ArrayList<>();
        while(rst.next()){
            BatchProDTO bp=new BatchProDTO(rst.getString("baid"),rst.getString("proid"),rst.getInt("product_qty"),rst.getInt("current_qty"));
            bplist.add(bp);
        }
        return bplist;
    }

    @Override
    public ArrayList<ProOrderDTO> getProOrderDetails() throws Exception {

        String sql="select distinct p.oid,order_date,product_amount from orders o,product_order p where p.oid=o.oid";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<ProOrderDTO> plist=new ArrayList<>();
        while(rst.next()){
            
            ProOrderDTO p=new ProOrderDTO(rst.getString("oid"),rst.getString("order_date"),rst.getInt("product_amount"));
            plist.add(p);
        }
        return plist;
        
    }

    @Override
    public BatchGrnDetailsDTO getReturnBatchGrnDetails(String rbrid) throws Exception {

        String sql="select cid,b.grid,add_time,grn_date from return_batch_receive b,grn g where (b.grid=g.grid)&& (b.rbrid=?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, rbrid);
        ResultSet rst=stm.executeQuery();
        
        BatchGrnDetailsDTO b=null;
        if(rst.next()){
            b=new BatchGrnDetailsDTO(rst.getString("cid"),rst.getString("add_time"),rst.getString("grn_date"),rst.getString("grid"));
        }
        return b;
    }

    @Override
    public BatchOrderDTO getBatchAddDetail(String baid) throws Exception {

        String sql="select product_name,manufacture_date,expire_date from product p,batch_add b where p.proid=b.proid  && b.baid='"+baid+"'";
        PreparedStatement stm=conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery(sql);
        BatchOrderDTO b=null;
        if(rst.next()){
            b= new BatchOrderDTO(rst.getString("manufacture_date"),rst.getString("expire_date"),rst.getString("product_name"));
        }
        return b;
    }

    @Override
    public ArrayList<String> getOrderDate(String baid) throws Exception {

        String sql=" select distinct o.order_date from orders o,batch_add b,product_order p where b.baid=p.baid && p.oid=o.oid && b.baid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, baid);
        ResultSet rst=stm.executeQuery();
        ArrayList<String> list=new ArrayList<>();
        while(rst.next()){
            list.add(rst.getString("order_date"));
        }
        return list;
    }

    @Override
    public String getProName(String baid) throws Exception {

        String sql="select product_name from batch_add b,product_order po,product p where b.baid=po.baid && b.proid=p.proid && b.baid=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, baid);
        ResultSet rst=stm.executeQuery();
        String proName=null;
        if(rst.next()){
            proName=rst.getString("product_name");
        }
        return proName;
    }

    @Override
    public ArrayList<BigDecimal> getTotal(String month, String year) throws Exception {

        String sql="select p.total,o.order_date from orders o,product_order p where o.oid=p.oid && month(order_date)=? && year(order_date)=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, month);
        stm.setObject(2, year);
        ResultSet rst=stm.executeQuery();
        ArrayList<BigDecimal> blist=new ArrayList<>();
        while(rst.next()){
            BigDecimal total=rst.getBigDecimal("total");
            blist.add(total);
        }
        return blist;
    }
    
    
}
