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
import lk.edu.ijse.sas.entity.Return_Order_Detail;
import lk.edu.ijse.sas.repository.custom.Return_order_detailRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

/**
 *
 * @author dimuthu
 */
public class Return_order_detailRepositoryImpl implements Return_order_detailRepository{
    
    private Session session;
    

    

    @Override
    public boolean add(ArrayList<Return_Order_Detail> dtoList) throws Exception {
        Serializable save=null;
        for (Return_Order_Detail return_Order_Detail : dtoList) {
           save= session.save(save);
        }
        return save!=null;
//        int res=0;
//        for (Return_order_detailDTO return_order_detailDTO : dtoList) {
//            String sql="insert into return_order_detail values(?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, return_order_detailDTO.getRnid());
//            stm.setObject(2, return_order_detailDTO.getBaid());
//            stm.setObject(3, return_order_detailDTO.getOid());
//            stm.setObject(4, return_order_detailDTO.getQty());
//            res+=stm.executeUpdate();
//            
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

  

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Return_Order_Detail getSpecific(String id) throws Exception {
        return (Return_Order_Detail) session.createCriteria(Return_Order_Detail.class).add(Restrictions.eq("oid", id)).list().get(0);
    }

    
}
