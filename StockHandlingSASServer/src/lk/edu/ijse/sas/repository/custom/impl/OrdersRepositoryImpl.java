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
import lk.edu.ijse.sas.entity.Orders;
import lk.edu.ijse.sas.repository.custom.OrdersRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author dimuthu
 */
public class OrdersRepositoryImpl implements OrdersRepository{
    
    private Session session;
    
    

    @Override
    public List<Orders> getAll() throws Exception {
        List<Orders> list = session.createCriteria(Orders.class).list();
        return list;
//        String sql="Select * from orders";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<OrdersDTO> list=new ArrayList<>();
//        while(rst.next()){
//            OrdersDTO order=new OrdersDTO(rst.getString("oid"),rst.getString("cid"),rst.getString("po"),rst.getBigDecimal("total"),rst.getString("order_date"));
//            list.add(order);
//        }
//        return list;
    }

    @Override
    public boolean add(Orders dto) throws Exception {
        Serializable save = session.save(dto);
        return save!=null;
//        int res=0;
//        
//        String sql="insert into orders values(?,?,?,?,?)";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getOid());
//        stm.setObject(2, dto.getCid());
//        stm.setObject(3, dto.getPo());
//        stm.setObject(4, dto.getTotal());
//        stm.setObject(5, dto.getOrderDate());
//        
//        res=stm.executeUpdate();
//        
//        if(res>0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void update(Orders dto) throws Exception {
        session.update(dto);
//        String sql="update orders set total=? where oid=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, dto.getTotal());
//        stm.setObject(2, dto.getOid());
//        int res=stm.executeUpdate();
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
    public Orders getSpecific(String id) throws Exception {
        Orders get = (Orders) session.createCriteria(Orders.class).add(Restrictions.eq("oid", id)).list().get(0);
        return get;
    }
}
