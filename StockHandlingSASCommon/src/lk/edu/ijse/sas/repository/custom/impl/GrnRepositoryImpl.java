/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.entity.GRN;
import lk.edu.ijse.sas.repository.custom.GrnRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */

public class GrnRepositoryImpl implements GrnRepository{
    
   private Session session; 

   
    
    @Override
    public List<GRN> getAll() throws Exception {
       List<GRN> list = session.createCriteria(GRN.class).list();
       return list;
//        String sql="Select * from grn";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<GrnDTO> glist=new ArrayList<>();
//        while(rst.next()){
//            GrnDTO g=new GrnDTO(rst.getString("grid"),rst.getString("cid"),rst.getString("pid"),rst.getInt("good_amount"),rst.getString("add_time"),rst.getString("grn_date"),rst.getBigDecimal("grand_total"));
//            glist.add(g);
//        }
//        return glist;
    }

    

    @Override
    public boolean add(GRN grn) throws Exception {
       Serializable save = session.save(grn);
       return save!=null;
//        int res=0;
//        
//        String sql="insert into grn values(?,?,?,?,?,?,?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, grn.getGrid());
//        stm.setObject(2, grn.getCid());
//        stm.setObject(3, grn.getPid());
//        stm.setObject(4, grn.getGoodAmount());
//        stm.setObject(5, grn.getAddTime());
//        stm.setObject(6, grn.getGrnDate());
//        stm.setObject(7, grn.getGrandTotal() );
//        
//        res=stm.executeUpdate();
//        
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    
//    @Override
//    public void update(GRN dto) throws Exception {
//        
////        String sql="Update grn set good_amount=good_amount+?,grand_total=grand_total+? where grid=?";
////        PreparedStatement stm=conn.prepareStatement(sql);
////        stm.setObject(1, dto.getGoodAmount());
////        stm.setObject(2, dto.getGrandTotal());
////        stm.setObject(3, dto.getGrid());
////        int res=stm.executeUpdate();
////        if(res>0){
////            return true;
////        }
////        return false;
//    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public GRN getSpecific(String id) throws Exception {
       GRN get = (GRN) session.createCriteria(GRN.class).add(Restrictions.eq("grid", id)).list().get(0);
       return get;
    }

    @Override
    public void update(GRN dto) throws Exception {
       session.update(dto);
    }
}
