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
import lk.edu.ijse.sas.entity.Product_Order;
import lk.edu.ijse.sas.repository.custom.Product_orderRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author dimuthu
 */
public class Product_orderRepositoryImpl implements Product_orderRepository{
    
    private Session session;
    
    

    @Override
    public List<Product_Order> getAll() throws Exception {
        List<Product_Order> list = session.createCriteria(Product_Order.class).list();
        return list;
//        String sql="select * from product_order";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        ArrayList<Product_orderDTO> plist=new ArrayList<>();
//        while(rst.next()){
//            Product_orderDTO p=new Product_orderDTO(rst.getString("oid"),rst.getString("baid"),rst.getInt("packages"),rst.getBigDecimal("qty_kg"),rst.getBigDecimal("unit_price_1Bag"),rst.getBigDecimal("total"));
//            plist.add(p);
//        }
//        return plist;
    }

    @Override
    public boolean add(ArrayList<Product_Order> dtoList) throws Exception {
        Serializable save=null;
        for (Product_Order product_Order : dtoList) {
            save = session.save(product_Order);
        }
        return save!=null;
//        int res=0;
//        for (Product_orderDTO product_orderDTO : dtoList) {
//            
//            String sql="insert into product_order values(?,?,?,?,?,?)";
//            PreparedStatement stm=conn.prepareStatement(sql);
//            stm.setObject(1, product_orderDTO.getOid());
//            stm.setObject(2, product_orderDTO.getBaid());
//            stm.setObject(3, product_orderDTO.getPack());
//            stm.setObject(4, product_orderDTO.getQty());
//            stm.setObject(5, product_orderDTO.getUnitPrice_1Bag());
//            stm.setObject(6, product_orderDTO.getTotal());
//            
//            res+=stm.executeUpdate();
//        }
//        if(res==dtoList.size()){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean delete(String oid) throws Exception {
        Query createQuery = session.createQuery("delete from product_order where oid=:oid");
         createQuery.setParameter("oid", oid);
        boolean name = createQuery.executeUpdate()>0;
        return name;
//        String sql="delete from product_order where oid=?";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        stm.setObject(1, oid);
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
    public Product_Order getSpecific(String id) throws Exception {
        Product_Order get = (Product_Order) session.createCriteria(Product_Order.class).add(Restrictions.eq("oid", id)).list().get(0);
        return get;
    }
    
}
