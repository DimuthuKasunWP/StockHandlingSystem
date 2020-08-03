/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.entity.Purchase_Order;
import lk.edu.ijse.sas.repository.custom.Purchase_orderRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class Purchase_orderRepositoryImpl implements Purchase_orderRepository{
    
    private Session session;
    
    

    @Override
    public List<Purchase_Order> getAll() throws Exception {
        List<Purchase_Order> list = session.createCriteria(Purchase_Order.class).list();
        return list;
//        String sql="select * from purchase_order";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<Purchase_orderDTO> pOrderList=new ArrayList<>();
//        while(rst.next()){
//            
//            Purchase_orderDTO p=new Purchase_orderDTO(rst.getString("pid"),rst.getString("cid"),rst.getInt("goodsAmount"),rst.getDouble("vat"),rst.getDouble("svat"),rst.getDouble("discount"),rst.getDouble("grand_total"),rst.getString("create_date"),rst.getString("confirm_date"));
//            pOrderList.add(p);
//        }
//        return pOrderList;
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Purchase_Order getSpecific(String id) throws Exception {
        Purchase_Order get = (Purchase_Order) session.createCriteria(Purchase_Order.class).add(Restrictions.eq("company", id)).list().get(0);
        return get;
    }

  

    
    
}
