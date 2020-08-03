/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.edu.ijse.sas.entity.Reject_Order_Detail;
import lk.edu.ijse.sas.repository.custom.Reject_order_detailRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Reject_order_detailRepositoryImpl implements Reject_order_detailRepository{

    private Session session;
    
    
    

    @Override
    public boolean add(ArrayList<Reject_Order_Detail> dtoList) throws Exception {
        Serializable save=null;
        for (Reject_Order_Detail reject_Order_Detail : dtoList) {
            save=session.save(reject_Order_Detail);
        }
        return save!=null;
//        int res=0;
//        for (Reject_order_detailDTO reject_order_detailDTO : dtoList) {
//            
//            String sql="insert into reject_order_detail values(?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, reject_order_detailDTO.getRjid());
//            stm.setObject(2, reject_order_detailDTO.getBaid());
//            stm.setObject(3, reject_order_detailDTO.getOid());
//            stm.setObject(4,reject_order_detailDTO.getQty());
//            
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
//        
    }

    @Override
    public void setSession(Session session) throws Exception {
       this.session=session;
    }

    @Override
    public Reject_Order_Detail getSpecific(String id) throws Exception {
     return   (Reject_Order_Detail) session.createCriteria(Reject_Order_Detail.class).add(Restrictions.eq("rjid", id)).list().get(0);
    }

    
    
}
