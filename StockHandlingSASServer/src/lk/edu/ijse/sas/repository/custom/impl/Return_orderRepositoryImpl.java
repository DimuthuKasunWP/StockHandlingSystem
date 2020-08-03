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
import lk.edu.ijse.sas.entity.Return_Order;
import lk.edu.ijse.sas.repository.custom.Return_orderRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Return_orderRepositoryImpl implements Return_orderRepository{
    
    private Session session;
    
    

    

    @Override
    public boolean add(Return_Order dto) throws Exception {
        Serializable save = session.save(dto);
        return save!=null;
//        int res=0;
//        String sql="insert into return_order values(?,?,?) ";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getRnid());
//        stm.setObject(2, dto.getReturned_amount());
//        stm.setObject(3, dto.getReturnDate());
//        res+=stm.executeUpdate();
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
    public Return_Order getSpecific(String id) throws Exception {
        return (Return_Order) session.createCriteria(Return_Order.class).add(Restrictions.eq("rnid", id)).list().get(0);
    }
    
}
