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
import lk.edu.ijse.sas.entity.Reject_Order;
import lk.edu.ijse.sas.repository.custom.Reject_orderRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Reject_orderRepositoryImpl implements Reject_orderRepository{
    
    private Session session;
    
    
    

    @Override
    public boolean add(Reject_Order dto) throws Exception {
        Serializable save = session.save(dto);
        return save!=null;
//        int res=0;
//        String sql="insert into reject_order values(?,?,?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getRjid());
//        stm.setObject(2, dto.getReject_amount());
//        stm.setObject(3, dto.getRejectDate());
//        
//        res+=stm.executeUpdate();
//        
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Reject_Order getSpecific(String id) throws Exception {
        Criteria add = session.createCriteria(Reject_Order.class).add(Restrictions.eq("rnid", id));
        return (Reject_Order) add.list().get(0);
    }
    
}
